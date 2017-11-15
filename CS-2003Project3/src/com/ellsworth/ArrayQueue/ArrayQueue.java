package com.ellsworth.ArrayQueue;

import com.ellsworth.Project3.Car;

public class ArrayQueue implements QueueInterface{
	private final int MAX_QUEUE;
	private Object[] items;
	private int front,back,count;
	
	public ArrayQueue(int size) {
		MAX_QUEUE = size;
		items = new Object[MAX_QUEUE];
		this.front = 0;
		this.back = MAX_QUEUE -1;
		this.count = 0;
	}
	
	public double percentFull() {
		double percent;
		percent = ((double)this.size()/(double)this.MAX_QUEUE)*100;
		return percent;
	}
	
	public Car peekAt(int intLocation) {
		return (Car) items[intLocation];
	}
	//needs work to fully determine what the end of the highway actually is
	public boolean atEnd(Car O) {
		if(O.getPosition() == MAX_QUEUE) {}
		return false;
	}
	public int getMAX_QUEUE() {
		return MAX_QUEUE;
	}
	public int getBack() {
		return back;
	}
	public int getFront() {
		return front;
	}
	/*public int itemPlace() {
		for(Object i:items) {
			
		}
		return 0;
	}*/
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
		if((!isFull())) {
			back = (back+1) % MAX_QUEUE;
			items[back] = newItem;
			++count;
		}
		else {throw new QueueException("QueueException: Queue is full on enqueue");}
	}

	@Override
	public Object dequeue() throws QueueException {
		// TODO Auto-generated method stub
		if((!isEmpty())) {
			Object queueFront = items[front];
			front = (front + 1) % MAX_QUEUE;
			--count;
			return queueFront;
		}
		else {throw new QueueException("QueueException: Queue is empty on dequeue");}
	}
	
	@Override
	public int size() {
		return count;
	}
	
	@Override
	public void dequeueAll() {
		items = new Object[MAX_QUEUE];
		this.front = 0;
		this.back = MAX_QUEUE -1;
		this.count = 0;
	}

	@Override
	public Object peek() throws QueueException {
		if((!isEmpty())) {
			return items[front];
		}
		else {throw new QueueException("QueueException: Queue is empty on peek");}
	}

	
}
