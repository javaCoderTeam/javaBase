package com.chen.api.util.thread.forkjoinpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author :  chen weijie
 * @Date: 2020-06-11 18:45
 */
public class ForkJoinPoolTest {


   static class Task extends RecursiveTask<Integer> {

        private int start;

        private int end;
        private int mid;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            if (end - start < 6) {
                // 当任务很小时，直接进行计算
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
                System.out.println(Thread.currentThread().getName() + " count sum: " + sum);
            } else {

                mid = (end - start) / 2 + start;
                Task leftTask = new Task(start, mid);
                Task rightTask = new Task(mid + 1, end);
                leftTask.fork();
                rightTask.fork();
                sum += leftTask.join();
                sum += rightTask.join();
            }
            return sum;
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Task countTask = new Task(1, 100);
        ForkJoinTask<Integer> result = forkJoinPool.submit(countTask);
        System.out.println("result: "+result.get());
        forkJoinPool.shutdown();
    }



}
