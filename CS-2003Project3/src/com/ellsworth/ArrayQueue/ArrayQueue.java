package com.ellsworth.ArrayQueue;

import com.ellsworth.Project3.Car;

public class ArrayQueue implements QueueInterface {
	private final int MAX_QUEUE;
	private Object[] items;
	private int front, back, count;

	/**
	 * Constructs a circular queue implementation using an array
	 * 
	 * @param size
	 * @param ID
	 */
	public ArrayQueue(int size) {
		MAX_QUEUE = size;
		items = new Object[MAX_QUEUE];
		this.front = 0;
		this.back = MAX_QUEUE - 1;
		this.count = 0;
	}

	/**
	 * return the fullness of the array in a percent value
	 * 
	 * @return double percent
	 */
	public double percentFull() {
		double percent;
		percent = (((double) this.size() / (double) this.MAX_QUEUE) * 100);
		return percent;
	}

	/**
	 * looks through the queue to find and manipulate certain objects within it
	 * 
	 * @param intLocation
	 * @return Car at location intLocation
	 */
	public Car peekAt(int intLocation) {
		return (Car) items[intLocation];
	}

	/**
	 * determines if the Car being passed in is in the front of the array
	 * 
	 * @param Car
	 *            C
	 * @return boolean
	 */
	public boolean inFront(Car C) {
		if (items[front].equals(C)) {
			return true;
		} else
			return false;
	}

	/**
	 * returns an int of the max items allowed in the queue
	 * 
	 * @return int Max queue value
	 */
	public int getMAX_QUEUE() {
		return MAX_QUEUE;
	}

	/**
	 * returns the int value of the back pointer
	 * 
	 * @return int back
	 */
	public int getBack() {
		return back;
	}

	/**
	 * returns the int value of the front pointer
	 * 
	 * @return int front
	 */
	public int getFront() {
		return front;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public boolean isFull() {
		return count == MAX_QUEUE;
	}

	@Override
	public void enqueue(Object newItem) throws QueueException {
		// TODO Auto-generated method stub
		if ((!isFull())) {
			back = (back + 1) % MAX_QUEUE;
			items[back] = newItem;
			++count;
		} else {
			throw new QueueException("QueueException: Queue is full on enqueue");
		}
	}

	@Override
	public Object dequeue() throws QueueException {
		// TODO Auto-generated method stub
		if ((!isEmpty())) {
			Object queueFront = items[front];
			front = (front + 1) % MAX_QUEUE;
			--count;
			return queueFront;
		} else {
			throw new QueueException("QueueException: Queue is empty on dequeue");
		}
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void dequeueAll() {
		items = new Object[MAX_QUEUE];
		this.front = 0;
		this.back = MAX_QUEUE - 1;
		this.count = 0;
	}

	@Override
	public Object peek() throws QueueException {
		if ((!isEmpty())) {
			return items[front];
		} else {
			throw new QueueException("QueueException: Queue is empty on peek");
		}
	}
}
