package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileManager {

	private BufferedWriter writer;

	private BufferedReader reader;

	private static final String DEFAULT_ENCODING = "UTF-8";

	public String fileWriterName = "";

	private String fileWriterPath = "";

	public FileManager() throws Exception {
	}

	public String getFileWriterPath() {
		return fileWriterPath;
	}

	public void setFileWriterPath(String fileWtriterPath) {
		this.fileWriterPath = fileWtriterPath;
	}

	public String getFileWriterName() {
		return fileWriterName;
	}

	public void setFileWriterName(String fileWriterName) {
		this.fileWriterName = fileWriterName;
	}

	public void openForWritting() throws UnsupportedEncodingException,
			FileNotFoundException {
		this.writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(fileWriterPath + fileWriterName),
				DEFAULT_ENCODING));
	}

	public BufferedReader openForReading() throws UnsupportedEncodingException,
			FileNotFoundException {
		return this.reader = new BufferedReader(new FileReader(fileWriterPath
				+ fileWriterName));
	}

	public void closeReader() throws IOException {
		if (reader != null) {
			reader.close();
		}
	}

	public void close() throws IOException {
		if (writer != null) {
			writer.close();
		}
	}

	public void writeLine(String line) throws IOException {
		writer.write(line);
	}

	public void newLine() throws IOException {
		writer.newLine();
	}

}
