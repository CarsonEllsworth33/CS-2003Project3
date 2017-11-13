package com.ellsworth.ArrayQueue;

public interface QueueInterface {
		public boolean isEmpty();
		public boolean isFull();
		public void enqueue(Object newItem) throws QueueException;
		public Object dequeue() throws QueueException;
		public void dequeueAll();
		public Object peek() throws QueueException;
}
