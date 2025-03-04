package com.javafx.viewmodel;

import com.javafx.model.FileModel;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FileViewModel  {
	
	private final Stage fileStage;
	private final TextArea textArea;
	
	public FileViewModel(Stage primaryStage,TextArea textArea) {
		this.fileStage= primaryStage;
		this.textArea= textArea;
	}
	
	public void saveButtonOnClick() {
		String input = textArea.getText();
		
	}

}
