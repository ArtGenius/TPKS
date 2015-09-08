package com.graph.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.graph.model.IncidenceMatrix;

public class GraphReader {

	private IncidenceMatrix matrix;
	private File inputFile;

	public GraphReader(String inputFileName) {
		inputFile = new File(inputFileName);
	}

	public IncidenceMatrix getMatrix() {
		return matrix;
	}

	public GraphReader read() {
		// TODO разработать функцию считывания графа из файла и представление
		// его в виде матрицы инцидентности. при считывании проверять
		// корректность входных данных, при необходимости сообщать об ошибках
		try (BufferedReader in = new BufferedReader(new FileReader(inputFile))) {
			int rows;
			int cols;
			cols = Integer.parseInt(in.readLine());
			rows = Integer.parseInt(in.readLine());
			matrix = new IncidenceMatrix(cols, rows);
			String temp;
			String tmp[];
			while ((temp = in.readLine()) != null) {
				tmp = temp.split(" ");
				byte row[] = new byte[(cols%4==0)? (cols/4):(cols/4)+1];
				int j = 0;
				byte trow = 0;
				for (int i = 0; i < cols; i++) {
					if (i % 4 == 0 && i!=0) {
						++j;
					}
					switch (tmp[i]) {
					case "0":
						trow = 0;
						break;
					case "1":
						trow = 1;
						break;
					case "-1":
						trow = 2;
						break;
					default:
						break;
					}
					trow = (byte) (trow << (6 - (i % 4) * 2));
					row[j]=(byte)(row[j]|trow);
				}
				matrix.setRow(row);
				
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

}
