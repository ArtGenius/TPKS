package com.graph.model;

public abstract class BinaryVector {

	private byte[] vector;
	private int size;
	protected int top;
	
	public BinaryVector() {
		size = 240;
		vector = new byte[size];
	}

	public BinaryVector(int size) {
		this.size = size;
		vector = new byte[size];
	}
	
	protected byte getByte(int i){
		return vector [i];
	}
	
	protected boolean setByte(int i, byte b){
		vector [i]=b;
		return true;
	}
	
	public int getSize(){
		return size;
	}
	
	public void print(){
		System.out.println("Binary vector");
		for(byte b:vector)System.out.println(Integer.toBinaryString(b));
	}
}
