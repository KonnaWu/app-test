package cn.wolfcode.test.threadpool;

import org.apache.log4j.Logger;

public class TestRunnable implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(TestRunnable.class);

    private Integer index;

    public TestRunnable(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return this.index;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        TestRunnable.LOGGER.info("线程：" + currentThread.getId() + " 中的任务（" + this.getIndex() + "）开始执行===");
        synchronized (currentThread) {
            try {
                currentThread.wait(500);
            } catch (InterruptedException e) {
                TestRunnable.LOGGER.error(e.getMessage(), e);
            }
        }
        TestRunnable.LOGGER.info("线程：" + currentThread.getId() + " 中的任务（" + this.getIndex() + "）执行完成");
    }
}
