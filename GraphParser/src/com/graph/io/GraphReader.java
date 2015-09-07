package com.graph.io;

import java.io.File;

import com.graph.model.IncidenceMatrix;


public class GraphReader {

	private IncidenceMatrix matrix;
	private File inputFile;

	public GraphReader(String inputFileName) {
		inputFile=new File(inputFileName);
	}

	public IncidenceMatrix getMatrix() {
		return matrix;
	}

	public GraphReader read() {
		// TODO Auto-generated method stub
		return this;
	}
	
}
