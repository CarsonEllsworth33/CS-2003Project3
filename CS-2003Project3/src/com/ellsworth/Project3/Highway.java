package com.ellsworth.Project3;
import com.ellsworth.ArrayQueue.ArrayQueue;
public class Highway {
	private  ArrayQueue constructionHW;
	private  ArrayQueue regularHW;
	public Highway() {
		constructionHW = new ArrayQueue(50);
		regularHW = new ArrayQueue(50);
	}
	public ArrayQueue getContructionHW() {
		return constructionHW;
	}
	public ArrayQueue getRegularHW() {
		return regularHW;
	}
	
	public static void main(String...strings) {
		
	}
	
}
