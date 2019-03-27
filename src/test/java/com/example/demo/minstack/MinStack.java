package com.example.demo.minstack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
	private List<Integer> data = new ArrayList<Integer>();
	private List<Integer> mins = new ArrayList<Integer>();

	public void push(Integer element) {
		data.add(element);
		if (mins.size() == 0) {
			mins.add(element);
		} else {
			Integer min = getMin();
			if (min > element) {
				mins.add(element);
			} else {
				mins.add(min);
			}
		}
	}

	// 一起出栈
	public Integer pop() {
		Integer popValue = -1;
		if (data.size() > 0) {
			popValue = data.remove(data.size() - 1);
			mins.remove(mins.size() - 1);
		}

		return popValue;
	}

	public Integer getMin() {
		if (mins.size() == 0) {
			return -1;
		}
		return mins.get(mins.size() - 1);
	}
}

class MinStack2 {

	private List<Integer> data = new ArrayList<Integer>();
	private List<Integer> mins = new ArrayList<Integer>();

	public void push(int num) throws Exception {
		data.add(num);
		if (mins.size() == 0) {
			// 初始化mins
			mins.add(0);//放的是索引
		} else {
			// 辅助栈mins push最小值的索引
			int min = getMin();
			if (num < min) {
				mins.add(data.size() - 1);
			}
		}
	}

	public int pop() throws Exception {
		// 栈空，抛出异常
		if (data.size() == 0) {
			throw new Exception("栈为空");
		}
		// pop时先获取索引
		int popIndex = data.size() - 1;
		// 获取mins栈顶元素，它是最小值索引
		int minIndex = mins.get(mins.size() - 1);
		// 如果pop出去的索引就是最小值索引，mins才出栈
		if (popIndex == minIndex) {
			mins.remove(mins.size() - 1);
		}
		return data.remove(data.size() - 1);
	}

	public int getMin() throws Exception {
		// 栈空，抛出异常
		if (data.size() == 0) {
			throw new Exception("栈为空");
		}
		// 获取mins栈顶元素，它是最小值索引
		int minIndex = mins.get(mins.size() - 1);
		return data.get(minIndex);
	}

}
