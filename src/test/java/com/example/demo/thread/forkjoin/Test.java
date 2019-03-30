package com.example.demo.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by Guoru on 2019/3/30.
 */
public class Test {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
// 生成一个计算任务，负责计算1+2+3+4
//        CountTask task = new CountTask(1, 4);
// 执行一个任务
//        Future<Integer> result = forkJoinPool.submit(task);
        ForkJoinTask<Integer> forkJoinTask = new CountTask(1, 4);
        Integer result = forkJoinPool.invoke(forkJoinTask);
        System.out.println(result);
        if (forkJoinTask.isCompletedAbnormally()) {
            System.out.println(forkJoinTask.getException());
        }
    }
}
