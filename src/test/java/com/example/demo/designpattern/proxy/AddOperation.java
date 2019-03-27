package com.example.demo.designpattern.proxy;

/**
 * Created by Guoru on 2019/3/6.
 */
public class AddOperation implements IOperation{
    @Override
    public int operate(int x, int y) {
        return x + y;
    }
}
