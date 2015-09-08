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
			if(cols>16){
				System.out.println("Входные данные не соответствуют заданным ограничениям(количество вершин не больше 16).");
			}
			rows = Integer.parseInt(in.readLine());
			matrix = new IncidenceMatrix(cols, rows);
			String temp;
			String tmp[];
			while ((temp = in.readLine()) != null) {
				tmp = temp.split(" ");
				byte row[] = new byte[(cols%4==0)? (cols/4):(cols/4)+1];
				int j = 0;
				byte trow = 0;
				int one=0;
				int mone=0;
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
						++one;
						break;
					case "-1":
						trow = 2;
						++mone;
						break;
					default:
						break;
					}
					if(one>1||mone>1){
						System.out.println("Ребро не может соединять более двух вершин.");
					}
					trow = (byte) (trow << (6 - (i % 4) * 2));
					row[j]=(byte)(row[j]|trow);
				}
				if(one==0||mone==0){
					System.out.println("Ребро не имеет начала или конца.");
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
