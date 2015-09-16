package com.graph.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.graph.model.IncidenceMatrix;

public class GraphReader {
	private final static String ERROR_MESSAGE_5 = "Ошибка считывания входных данных. Проверьте корректность данных!";
	private final static String ERROR_MESSAGE_4 = "Файл с входными данными не найден.";
	private final static String ERROR_MESSAGE_3 = "Ребро не имеет начала или конца.";
	private final static String ERROR_MESSAGE_2 = "Дуга не может соединять более двух вершин.";
	private final static String ERROR_MESSAGE_1 = "Превышен максимальный объем графа";

	private IncidenceMatrix matrix;
	private File inputFile;

	public GraphReader(String inputFileName) {
		inputFile = new File(inputFileName);
	}

	public IncidenceMatrix getMatrix() {
		return matrix;
	}

	public boolean read() {
		try (BufferedReader in = new BufferedReader(new FileReader(inputFile))) {
			int rows;
			int cols;
			cols = Integer.parseInt(in.readLine());
			rows = Integer.parseInt(in.readLine());
			matrix = new IncidenceMatrix(16);
			if (!matrix.setDemansion(cols, rows)) {
				System.out.println(ERROR_MESSAGE_1);
				return false;
			}
			String temp;
			String tmp[];
			while ((temp = in.readLine()) != null) {
				tmp = temp.split(" ");
				byte row[] = new byte[(cols % 4 == 0) ? (cols / 4)
						: (cols / 4) + 1];
				int j = 0;
				byte trow = 0;
				int one = 0;
				int mone = 0;
				for (int i = 0; i < cols; i++) {
					if (i % 4 == 0 && i != 0) {
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
					if (one > 1 || mone > 1) {
						System.out.println(ERROR_MESSAGE_2);
						return false;
					}
					trow = (byte) (trow << (6 - (i % 4) * 2));
					row[j] = (byte) (row[j] | trow);
				}
				if (one == 0 || mone == 0) {
					System.out.println(ERROR_MESSAGE_3);
					return false;
				}
				matrix.setRow(row);
			}

		} catch (FileNotFoundException e) {
			System.out.println(ERROR_MESSAGE_4);
		} catch (IOException e) {
			System.out.println(ERROR_MESSAGE_5);
		}
		return true;
	}
}
