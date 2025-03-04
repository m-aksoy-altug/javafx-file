package com.javafx.component;

import java.lang.constant.Constable;
import java.util.Optional;

import com.javafx.helper.Constants;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class AlertMessage {
		
	private Alert alert = new Alert(null);
	
	public void showErrorAlert(String title, String message) {
		alert.setAlertType(AlertType.ERROR);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	
	public void showInfoAlert(String title, String message) {
		alert.setAlertType(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	public void showWarningAlert(String title, String message) {
		alert.setAlertType(AlertType.WARNING);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	public boolean showConfirmationAlert(Stage fileStage, String title, String message) {
		alert.setAlertType(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setContentText(message);
		alert.initOwner(fileStage);
		
		ButtonType yesBtn= new ButtonType(Constants.YES);
		ButtonType noBtn= new ButtonType(Constants.NO);
		
		alert.getButtonTypes().setAll(yesBtn,noBtn);
		
		Optional<ButtonType> response= alert.showAndWait();
		
		return response.isPresent() ? response.get()== yesBtn : false; 
		
	}
		
}
