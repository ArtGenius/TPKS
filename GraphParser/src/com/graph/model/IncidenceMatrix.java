package com.graph.model;

/**
 * структура данных описывающая матрицу инцидентности
 * 
 * */
public class IncidenceMatrix extends BinaryVector {

	private int rows;
	private int cols;

	public IncidenceMatrix(int columns, int rows) {
		super((int)Math.ceil(Math.log(columns)/Math.log(2))*rows);
		this.cols = columns;
		this.rows = rows;
	}

	public byte getElement(int column, int row) {
		byte b = getByte(getByteNumber(column, row));
		b=(byte) (b<<getElementPosition(column, row)>>6);
		return b;
	}
	/**
	 * метод устанавливает указанный байт в указанное место таблицы инцидентности
	 * @param column - номер столбца 
	 * @param row - номер строки
	 * @param matrixRow- массив байтов (строка матрицы инцидентности)
	 * 
	 * */
	public void setRow(int column, int row, byte... matrixRow) {
		for (byte b : matrixRow)
			setByte(getByteNumber(column, row), b);
	}

	public int getColumnsCount() {
		return this.cols;
	}

	public int getRowsCount() {
		return this.rows;
	}

	public int getByteNumber(int col, int row) {
		return (cols * col + row) / 4;
	}

	public int getElementPosition(int col, int row) {
		return (cols * col + row) * 2 - getByteNumber(col, row) * 8;
	}

	public static int maxSize(int n) {
		int rez = 0;
		for (int i = 1; i <= n; i++)
			rez += (i - 1) * 2;
		return rez;
	}
}