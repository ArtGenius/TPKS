package com.graph.parse;

import com.graph.model.ArcList;
import com.graph.model.IncidenceMatrix;

public class Parser {

	private ArcList list;
	private IncidenceMatrix matrix;
	public Parser(IncidenceMatrix matrix) {
		this.matrix=matrix;
	}

	ArcList parse() {
		// TODO ������� �������������� �����, ��������������� ��������
		// ������������� � ������ ���
		list=new ArcList();
		return list;
	}
}
