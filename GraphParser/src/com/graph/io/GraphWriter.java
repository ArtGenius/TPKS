package com.graph.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.graph.model.ArcList;

public class GraphWriter {

	private final static String ARC_LIST_LINE_PATTERN = "%d) %d %d";
	private File outputFile;

	public GraphWriter(String outputFileName) {
		outputFile = new File(outputFileName);
	}

	public void write(ArcList list) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter(outputFile))) {
			for (int i = 0; i < list.getSize() / 2; i++) {
				out.write(String.format(ARC_LIST_LINE_PATTERN, i, list.get(),
						list.get()));
				out.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}