package com.ge.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.stream.Stream;

public class ArrayQuadrantUtil {

//Varaible declaration
	int arraySize = 0;
	Object inputArray[][];

	public ArrayQuadrantUtil(Object[][] data) {
		this.inputArray =  data;
	}

	public Object[] getColumnData(int columnNumber) {
		Object[] colObj = new Object[this.inputArray.length];
		if (columnNumber >= 0 && this.inputArray.length >= columnNumber) {
			for (int i = 0; i < this.inputArray.length; i++) {
				colObj[i] = this.inputArray[i][columnNumber];
			}
			return colObj;
		} else
			return null;
	}

	public Object[] getRowData(int rowNumber) {
		if (rowNumber >= 0 && this.inputArray.length >= rowNumber)
			return this.inputArray[rowNumber];
		else
			return null;
	}

	public Object[] getQuadrantData(int row, int col) {
		int quadrantNum = 0;
		if (row <= ((this.inputArray.length / 2) - 1)) {
			if (col <= ((this.inputArray.length / 2) - 1))
				quadrantNum = 1;
			else
				quadrantNum = 0;
		} else if (col <= ((this.inputArray.length / 2) - 1))
			quadrantNum = 3;
		else
			quadrantNum = 4;

		switch (quadrantNum) {
		case 0:
			return getTopRightQuadrant();
		case 1:
			return getTopLeftQuadrant();
		case 2:
			return getBottomLeftQuadrant();
		case 3:
			return getBottomRightQuadrant();
		default:
			return null;
		}
	}

	public Object[] getTopRightQuadrant() {
		int colStart = (this.inputArray.length / 2);
		int totalDataCount = 0;
		Object[] quadrantData = new Object[(this.inputArray.length / 2) * ((this.inputArray.length / 2))];
		for (int i = 0; i < colStart; i++) {
			for (int j = colStart; j < this.inputArray.length; j++) {
				quadrantData[totalDataCount++] = this.inputArray[i][j];
			}
		}
		return quadrantData;
	}

	public Object[] getTopLeftQuadrant() {
		int colEnd = (this.inputArray.length / 2);
		int totalDataCount = 0;
		Object[] quadrantData = new Object[(this.inputArray.length / 2) * ((this.inputArray.length / 2))];
		for (int i = 0; i < colEnd; i++) {
			for (int j = 0; j < colEnd; j++) {
				quadrantData[totalDataCount++] = this.inputArray[i][j];
			}
		}
		return quadrantData;
	}

	public Object[] getBottomLeftQuadrant() {
		int rowStart = (this.inputArray.length / 2);
		int totalDataCount = 0;
		Object[] quadrantData = new Object[(this.inputArray.length / 2) * ((this.inputArray.length / 2))];
		for (int i = rowStart; i < this.inputArray.length; i++) {
			for (int j = 0; j < (this.inputArray.length / 2); j++) {
				quadrantData[totalDataCount++] = this.inputArray[i][j];
			}
		}
		return quadrantData;
	}

	public Object[] getBottomRightQuadrant() {
		int rowStart = (this.inputArray.length / 2);
		int totalDataCount = 0;
		Object[] quadrantData = new Object[(this.inputArray.length / 2) * ((this.inputArray.length / 2))];
		for (int i = rowStart; i < this.inputArray.length; i++) {
			for (int j = rowStart; j < this.inputArray.length; j++) {
				quadrantData[totalDataCount++] = this.inputArray[i][j];
			}
		}
		return quadrantData;
	}
}
