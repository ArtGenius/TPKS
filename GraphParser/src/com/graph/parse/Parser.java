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
		// TODO ������� �������������� �����, ��������������� ��������
		// ������������� � ������ ���
		int cols = matrix.getColumnsCount();
		int rows = matrix.getRowsCount();
		list = new ArcList(rows);
		for (int i = 0; i < rows; i++) {
			byte begin=0,end=0;
			for (int j = 0; j < cols; j++) {
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
			}
			list.add(begin,end);
		}
		return list;
	}
}
