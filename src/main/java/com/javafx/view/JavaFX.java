package com.javafx.view;

import com.javafx.helper.Constants;
import com.javafx.viewmodel.FileViewModel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class JavaFX  extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		TextArea textArea = new TextArea();
		FileViewModel fileViewModel = new FileViewModel(primaryStage,textArea);
		
		Button saveButton = new Button(Constants.SAVE);
		saveButton.setOnAction(x-> fileViewModel.saveButtonOnClick());
		
		VBox layout= new VBox(10);
		layout.getChildren().addAll(textArea,saveButton);
		
		Scene scene= new Scene(layout,500,400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
        

		
	}

}
