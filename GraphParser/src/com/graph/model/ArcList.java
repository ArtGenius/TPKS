package com.graph.model;

public class ArcList extends BinaryVector {

	private int arcsCount;
	private int bottom;
	private int maxArcsCount = 100;

	public ArcList(int arcsCount) {
		super(arcsCount);
		this.maxArcsCount = arcsCount;
	}

	public ArcList() {
		super(100);
	}

	public boolean add(byte begin, byte end) {
		setByte(top++, begin);
		setByte(top++, end);
		return true;
	}

	public byte get() {
		return getByte(bottom++);
	}

	public int getArcsCount() {
		return arcsCount;
	}

	public boolean setDemansion(int arcsCount) {
		if (arcsCount > maxArcsCount)
			return false;
		super.setSize(arcsCount * 2);
		this.arcsCount = arcsCount;
		return true;
	}
}
