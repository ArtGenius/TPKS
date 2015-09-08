package com.graph.model;

public class ArcList extends BinaryVector{

	private int arcsCount;
	private int bottom;
	
	public ArcList(int arcsCount){
		super(arcsCount*2);
		this.arcsCount=arcsCount;
	}
	
	public boolean add(byte begin, byte end) {
		setByte(top++,begin);
		setByte(top++, end);
		return true;
	}
	
	public byte get(){
		return getByte(bottom++);
	}
	
	public int getArcsCount(){
		return arcsCount;
	}
}
