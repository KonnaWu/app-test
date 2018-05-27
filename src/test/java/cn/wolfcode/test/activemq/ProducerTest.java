package cn.wolfcode.test.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProducerTest {

    @Test
    public void test() throws JMSException {
        Connection connection = new ActiveMQConnectionFactory("tcp://192.168.197.129:61616").createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE, Session.SESSION_TRANSACTED);
        ActiveMQQueue testTopic = new ActiveMQQueue("test_queue");
        MessageProducer producer = session.createProducer(testTopic);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        ActiveMQTextMessage textMessage = new ActiveMQTextMessage();
        textMessage.setText("hello world");
        producer.send(textMessage);
        session.commit();
        session.close();
        connection.close();
    }
}
