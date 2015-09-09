package com.graph.parse;

import com.graph.io.GraphReader;
import com.graph.io.GraphWriter;
import com.graph.model.ArcList;
import com.graph.model.IncidenceMatrix;

public class Main {

	private static final String INPUT_FILE_NAME = "input.txt";
	private static final String OUTPUT_FILE_NAME = "output.txt";

	public static void main(String[] args) {
		GraphReader reader = new GraphReader(INPUT_FILE_NAME);
		if (reader.read()) {
			IncidenceMatrix matrix = reader.getMatrix();
			int cols=matrix.getColumnsCount();
			matrix.print((cols%4==0)? (cols/4):(cols/4)+1);
			Parser parser = new Parser(matrix);
			ArcList list = parser.parse();
			list.print(2);
			GraphWriter writer = new GraphWriter(OUTPUT_FILE_NAME);
			writer.write(list);
		}
	}
}
