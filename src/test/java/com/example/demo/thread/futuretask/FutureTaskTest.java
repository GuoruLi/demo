package com.example.demo.thread.futuretask;

import java.util.concurrent.*;

/**
 * Created by Ruby on 2019/4/1.
 */
public class FutureTaskTest {
    private final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<Object, Future<String>>();
    private String executionTask(final String taskName) throws ExecutionException, InterruptedException {
        while (true) {
            Future<String> future = taskCache.get(taskName);// 1.1,2.1
            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    public String call() throws InterruptedException {
                        return taskName;
                    }
                };
                FutureTask<String> futureTask = new FutureTask<String>(task);
                future = taskCache.putIfAbsent(taskName, futureTask); // 1.3
                if (future == null) {
                    future = futureTask;
                    futureTask.run();// 1.4执行任务
                }
            }
            try {
                return future.get(); // 1.5,2.2
            } catch (CancellationException e) {
                taskCache.remove(taskName, future);
            }
        }
    }
    public static void main(String[] args){

    }
}
