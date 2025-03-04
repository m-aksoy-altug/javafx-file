package com.javafx.component;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
}
