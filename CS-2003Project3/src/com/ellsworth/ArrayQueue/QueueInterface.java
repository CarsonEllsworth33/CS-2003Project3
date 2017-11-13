package com.ellsworth.ArrayQueue;

public interface QueueInterface {
		public boolean isEmpty();
		public boolean isFull();
		public int size();
		public void enqueue(Object newItem) throws QueueException;
		public Object dequeue() throws QueueException;
		public void dequeueAll();
		public Object peek() throws QueueException;
}
