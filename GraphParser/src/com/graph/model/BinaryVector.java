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

	public int getSize() {
		return size;
	}

	public void print(int cols) {
		System.out.println("\nBinary vector");
		for (int i=0;i<vector.length;i++) {
			if(i%cols==0)System.out.println();
			System.out.print(makeBinaryString(vector[i])+" ");
		}
	}

	protected byte getByte(int i) {
		return vector[i];
	}

	protected boolean setByte(int i, byte b) {
		vector[i] = b;
		return true;
	}
	
	private String makeBinaryString(byte b) {
		String bstr = "";
		bstr = Integer.toBinaryString(b);
		if (bstr.length() > 8) {
			bstr = bstr.substring(bstr.length() - 8, bstr.length());
		} else if (bstr.length() < 8) {
			while (bstr.length() < 8) {
				bstr = "0" + bstr;
			}
		}
		return bstr;
	}
}
