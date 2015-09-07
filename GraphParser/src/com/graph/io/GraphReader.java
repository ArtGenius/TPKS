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
