package com.ellsworth.project3;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class HighwayQueue<T> implements Iterable<T>{
	private Node<T> front;
	private Node<T> back;
	private int items = 0;
	private Node<T> fronts;
	
	private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String...strings) {
		
	}
}
