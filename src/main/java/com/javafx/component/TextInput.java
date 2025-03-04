package com.javafx.component;

import java.util.Optional;

import javafx.scene.control.TextInputDialog;

public class TextInput {
	
	private TextInputDialog  textInput= new TextInputDialog();
	
	public Optional<String> getFileName(String title, String header) {
		textInput.setTitle(title);
		textInput.setHeaderText(header);
		return textInput.showAndWait();
	}

}
