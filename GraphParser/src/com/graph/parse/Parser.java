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
		// TODO функция преобразования графа, представленного матрицей
		// инцидентности в список дуг
		list=new ArcList();
		return list;
	}
}
