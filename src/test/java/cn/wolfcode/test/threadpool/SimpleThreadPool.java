package cn.wolfcode.test.threadpool;

import org.apache.log4j.BasicConfigurator;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SimpleThreadPool {

    // BasicConfigurator.configure() 方法: 给跟记录器增加一个ConsoleAppender, 默认级别是DEBUG
    static {
        BasicConfigurator.configure();
    }

    public static void main(String[] args) throws InterruptedException {
        /**
         * corePoolSize: 线程池核心线程数,
         * maximumPoolSize: 线程池的最大线程数
         * keepAliveTime: 当线程池最大线程数大于线程池核心大小时, 多余的线程再等待了keepAliveTime后,仍然没有新的线程任务
         *                指派给他, 线程池将会回收该线程
         * workerQueue: 等待队列
         */
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10
                , 1, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            poolExecutor.submit(new TestRunnable(i));
        }

        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();

        synchronized (poolExecutor) {
            poolExecutor.wait();
        }
    }


}

