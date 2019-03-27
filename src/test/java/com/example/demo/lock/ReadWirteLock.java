package com.example.demo.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 允许多个读线程访问
 * 写线程访问时，其它线程阻塞
 * @author Ruby
 *
 */
public class ReadWirteLock {
	static Map<String, Object> map = new HashMap<String, Object>();//非线程安全的，需要用锁保证安全
	static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	static Lock r = rwl.readLock();//读锁允许多个线程同时访问
	static Lock w = rwl.writeLock();//写锁会导致其它线程阻塞

	// 获取一个key对应的value
	public static final Object get(String key) {
		r.lock();
		try {
			return map.get(key);
		} finally {
			r.unlock();
		}
	}

	// 设置key对应的value，并返回旧的value
	public static final Object put(String key, Object value) {
		w.lock();
		try {
			return map.put(key, value);
		} finally {
			w.unlock();
		}
	}

	// 清空所有的内容
	public static final void clear() {
		w.lock();
		try {
			map.clear();
		} finally {
			w.unlock();
		}
	}
}
