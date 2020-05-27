package com.chen.test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author Chen WeiJie
 * @date 2020-04-23 16:50:07
 **/
public class Mutex {


    public static class Sync extends AbstractQueuedSynchronizer {


        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }


        @Override
        protected boolean tryAcquire(int arg) {

            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {

            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

    }

    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }


    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

}
