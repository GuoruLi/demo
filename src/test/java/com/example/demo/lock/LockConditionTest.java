package com.example.demo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionTest {
	private Object[] items;
	// 添加的下标，删除的下标和数组当前数量
	private int addIndex, removeIndex, count;
	private Lock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();

	public LockConditionTest(int size) {
		items = new Object[size];
	}

	// 添加一个元素，如果数组满，则添加线程进入等待状态，直到有"空位"
	public <T> void add(T t) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();//condition关联的锁会被当前线程释放，进入等待状态
			items[addIndex] = t;
			if (++addIndex == items.length)
				addIndex = 0;
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	// 由头部删除一个元素，如果数组空，则删除线程进入等待状态，直到有新添加元素
	@SuppressWarnings("unchecked")
	public <T> T remove() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0)
				notEmpty.await();
			Object x = items[removeIndex];
			if (++removeIndex == items.length)
				removeIndex = 0;
			--count;
			notFull.signal();
			return (T) x;
		} finally {
			lock.unlock();
		}
	}
}
