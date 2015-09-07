package com.graph.parse;

import com.graph.model.ArcList;
import com.graph.model.IncidenceMatrix;

public class Parser {

	private ArcList list;
	private IncidenceMatrix matrix;

	public Parser(IncidenceMatrix matrix) {
		this.matrix = matrix;
	}

	ArcList parse() {
		// TODO функция преобразования графа, представленного матрицей
		// инцидентности в список дуг
		int cols = matrix.getRowsCount();
		list = new ArcList(cols);
		int rows = matrix.getRowsCount();
		for (int i = 0; i < cols; i++) {
			byte begin=0,end=0;
			for (int j = 0; j < rows; j++) {
				byte element = matrix.getElement(j, i);
				switch (element) {
				case 1:
					begin=(byte) j;
					break;
				case 2:
					end=(byte)j;
					break;
				default:
					break;
				}
				list.add(begin,end);
			}
		}
		return list;
	}
}
