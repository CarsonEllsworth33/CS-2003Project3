package com.ellsworth.Project3;
import com.ellsworth.ArrayQueue.ArrayQueue;
public class Highway {
	private ArrayQueue contructionHW;
	private ArrayQueue regularHW;
	public Highway() {
		contructionHW = new ArrayQueue(50);
		regularHW = new ArrayQueue(50);
	}
	public ArrayQueue getContructionHW() {
		return contructionHW;
	}
	public ArrayQueue getRegularHW() {
		return regularHW;
	}
	
}
