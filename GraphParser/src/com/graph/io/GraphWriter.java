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
		
	}

	public void write(ArcList list) {
		// TODO разработать функцию записи списка дуг в файл
		
try(BufferedWriter out=new BufferedWriter(new FileWriter(outputFile))){
	         for(int i=0; i<list.getSize()/2;i++){
			 out.write(i+")"+"  "+list.get()+"  "+list.get());
			 out.newLine();
	         }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
