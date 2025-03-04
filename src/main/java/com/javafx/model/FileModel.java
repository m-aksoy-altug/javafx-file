package com.javafx.model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
*/
public class FileModel {

	public static void save(File selected, String fileName, String text) throws IOException {
		Path fileAbsPath = Paths.get(selected.getAbsolutePath(), fileName);
		try{
			byte[] bytes= text.getBytes(StandardCharsets.UTF_8);
			Files.write(fileAbsPath, bytes);
		} catch (IOException e) {
			// TODO: Pass user friendly ones
			throw new IOException(e.getMessage());
		}
	}
}
