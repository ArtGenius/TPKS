package com.graph.model;

public class IncidenceMatrix extends BinaryVector {

	private int rows;
	private int cols;

	public IncidenceMatrix(int columns, int rows) {
		super(((columns % 4 == 0) ? (columns / 4) : (columns / 4) + 1) * rows);
		this.cols = columns;
		this.rows = rows;
	}

	public byte getElement(int column, int row) {
		byte b = getByte(getByteNumber(column, row));
		b = (byte) ((byte) ((byte) (b << getElementPosition(column, row)) >>> 6) & 3);
		return b;
	}

	public void setRow(byte... matrixRow) {
		for (byte b : matrixRow)
			setByte(top++, b);
	}

	public int getColumnsCount() {
		return this.cols;
	}

	public int getRowsCount() {
		return this.rows;
	}

	public int getByteNumber(int col, int row) {
		// int x=(cols * row + col) / 4;
		int x = (cols % 4 == 0) ? cols : (cols / 4 + 1) * 4;
		x = (x * row + col) * 2 / 8;
		return x;
	}

	public int getElementPosition(int col, int row) {
		// int x=(cols%4==0)?cols:(cols/4)*4;
		int x = (cols % 4 == 0) ? cols : (cols / 4 + 1) * 4;
		x = (x * row + col) * 2 - getByteNumber(col, row) * 8;
		return x;
	}

	public static int maxSize(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++)
			result += (i - 1) * 2;
		return result;
	}
}