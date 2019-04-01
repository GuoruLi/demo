package com.example.demo.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

/**
 * Created by Guoru on 2019/3/30.
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 方法一：submit执行线程
        ForkJoinTask<Integer> forkJoinTask = new CountTask(1, 4);
        Future<Integer> result = forkJoinPool.submit(forkJoinTask);
        System.out.println(result.get());//get方法会阻塞当前线程，直到结果返回

        // 方法二：invoke执行线程
        Integer result1 = forkJoinPool.invoke(forkJoinTask);
        System.out.println(result1);

        //方法三：execute执行线程，不会返回结果
        forkJoinPool.execute(forkJoinTask);

        if (forkJoinTask.isCompletedAbnormally()) {
            System.out.println(forkJoinTask.getException());
        }
    }
}
