package cn.wolfcode.test.activemq;

import cn.wolfcode.domain.Message;
import cn.wolfcode.mapper.MessageMapper;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConsumerTest {

    @Autowired
    private MessageMapper messageMapper;

    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final Condition STOP = LOCK.newCondition();

    @Test
    public void test() throws JMSException {
        Connection connection = new ActiveMQConnectionFactory("tcp://192.168.197.129:61616").createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.SESSION_TRANSACTED);
        ActiveMQQueue testTopic = new ActiveMQQueue("test_queue");
        MessageConsumer consumer = session.createConsumer(testTopic);
        consumer.setMessageListener(message ->{
            ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
            try {
                String text = textMessage.getText();
                Message msg = new Message();
                msg.setContent(text);
                messageMapper.insert(msg);
                System.out.println(text);
                session.commit();
                messageMapper.deleteByPrimaryKey(msg.getId());

            } catch (JMSException e) {
                e.printStackTrace();
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try {
                LOCK.lock();
                STOP.signal();
            }finally {
                LOCK.unlock();
            }

        }));
        try {
            LOCK.lock();
            STOP.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }

        session.close();
        connection.close();
    }

    @Test
    public void test2(){
        System.out.println(messageMapper);
    }
}
