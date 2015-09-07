package com.graph.model;

/**
 * структура данных описывающая матрицу инцидентности
 * 
 * */
public class IncidenceMatrix extends BinaryVector {

	public IncidenceMatrix() {
		super();
	}
	
	public IncidenceMatrix(int columns, int rows) {
		super(maxSize(columns),columns, rows);
	}

	public void getElement(int column, int row) {
		byte b = getByte(column, row);
	}

	public void setRow(int column, int row, byte ...matrixRow) {
		for(byte b:matrixRow)setByte(column, row, b);
	}

	public static int maxSize(int n) {
		int rez = 0;
		for (int i = 1; i <= n; i++)
			rez += (i - 1) * 2;
		return rez;
	}
}
