package com.graph.model;

public abstract class BinaryVector {

	private byte[] vector;
	private int size;
	protected int rows;
	protected int cols;
	
	public BinaryVector() {
		size = 240;
		vector = new byte[size];
	}

	public BinaryVector(int size, int cols, int rows) {
		this.size = size;
		this.cols=cols;
		this.rows=rows;
		vector = new byte[size];
	}
	
	protected byte getByte(int i, int j){
		return vector [(cols*i+j)/4];
	}
	
	protected boolean setByte(int i, int j, byte b){
		vector [(cols*i+j)/4]=b;
		return true;
	}
}
