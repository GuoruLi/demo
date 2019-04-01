package com.example.demo.thread.callable_futuretask;

import java.util.concurrent.*;

/**
 * Created by Ruby on 2019/4/1.
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 方法一：Runnable线程
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        //  方法二：使用futureTask来执行Callable接口的call方法
        FutureTask futureTask = new FutureTask<>(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                return Integer.MAX_VALUE;
            }
        });

        //  方法三、使用futureTask来执行Runnable的run方法，调用get方法只能取到传给它的值
        futureTask = new FutureTask<>(new Runnable() {
            @Override
            public void run() {

            }
        }, Integer.MAX_VALUE);


        //  执行方法一
        new Thread(futureTask).start();

        //  执行方法二
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(futureTask);

        //  执行方法三
        executorService.submit(futureTask);

        //  执行方法四
        futureTask.run();

        //  获取返回结果
        System.out.print(futureTask.get());//主线程阻塞，直到得到返回结果
    }
}
