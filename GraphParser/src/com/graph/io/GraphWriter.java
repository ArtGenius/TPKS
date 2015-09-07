package com.graph.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.graph.model.ArcList;

public class GraphWriter {

	private File outputFile;
	public GraphWriter(String outputFileName) {
		outputFile=new File(outputFileName);
		try(BufferedWriter out=new BufferedWriter(new FileWriter(outputFile))){
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write(ArcList list) {
		// TODO разработать функцию записи списка дуг в файл

	}

}
