package com.javafx.viewmodel;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import com.javafx.component.AlertMessage;
import com.javafx.component.TextInput;
import com.javafx.exception.InvalidFileException;
import com.javafx.helper.Constants;
import com.javafx.model.FileModel;
import com.javafx.validation.Validator;

import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;
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
		AlertMessage alert= new AlertMessage();
		TextInput textinput= new TextInput();
		// Do more validation here, like white list characters
		if(input.isBlank()) {  
			alert.showWarningAlert(Constants.WARNING,Constants.TEXT_AREA_IS_EMPTY);
			return; 
		}
		
		DirectoryChooser directory = new DirectoryChooser();
		directory.setInitialDirectory(null);
		directory.setTitle(Constants.SELECT_FOLDER_TO_SAVE_FILE);
		File selectedDirectory= directory.showDialog(fileStage);
		
		if(selectedDirectory!=null && selectedDirectory.exists()) {
			Optional<String> fileName=textinput
					.getFileName(Constants.FILE_NAME,Constants.ENTER_FILE_NAME);
			try {
				String fileNameMap = Validator.fileNameMapper(fileName);
				FileModel.save(selectedDirectory,fileNameMap,input);
				boolean response= alert.showConfirmationAlert(fileStage,Constants.SUCCESS,Constants.FILE_IS_SAVED_CLEAR_TEXT);
				if (response==true) 
					textArea.clear();
			} catch(InvalidFileException e) {
				alert.showWarningAlert(Constants.ERROR,e.getMessage());
				return;
			} catch (IOException e) {
				alert.showWarningAlert(Constants.ERROR,e.getMessage());
				return;
			}
		}
		else {
			alert.showWarningAlert(Constants.ERROR,Constants.SELECTED_DIRECTORY_IS_NOT_VALID);
			return; 
		}
	}
}
