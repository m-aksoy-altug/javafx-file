package com.javafx.view;

import com.javafx.helper.Constants;
import com.javafx.viewmodel.FileViewModel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/* - Running on Eclipse by Maven:
 * Opt1 : Goals: compile exec:java -Dexec.mainClass="com.javafx.view.JavaFX"
 * Opt2 : Goals: exec:java
 * 
 * - Running as Jar file : Fat jar includes required javajfx jars, 
 *  Assumption : excluding all -linux.jars to make it platform independent, haven't test in other OS yet.  
 * 
 * - Running on Linux, requires to pass required ...-linux.jar files.
 *  
 * java --module-path /home/altug/.m2/repository/org/openjfx/javafx-controls/21.0.2/javafx-controls-21.0.2-linux.jar:/home/altug/.m2/repository/org/openjfx/javafx-fxml/21.0.2/javafx-fxml-21.0.2-linux.jar:/home/altug/.m2/repository/org/openjfx/javafx-graphics/21.0.2/javafx-graphics-21.0.2-linux.jar:/home/altug/.m2/repository/org/openjfx/javafx-base/21.0.2/javafx-base-21.0.2-linux.jar \
--add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.base \
-jar target/javafx-file-0.0.1-SNAPSHOT.jar

*/
public class JavaFX  extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		TextArea textArea = new TextArea();
		textArea.setMaxHeight(Double.MAX_VALUE);
		FileViewModel fileViewModel = new FileViewModel(primaryStage,textArea);
		
		Button saveBtn = new Button(Constants.SAVE);
		Button clearBtn = new Button(Constants.CLEAR);
		
		HBox horizontalBox= new HBox(10);
		horizontalBox.setAlignment(Pos.CENTER);
		horizontalBox.getChildren().addAll(saveBtn,clearBtn);
		
		saveBtn.setOnAction(x-> fileViewModel.saveButtonOnClick());
		clearBtn.setOnAction(x-> textArea.clear());
		
		BorderPane layout= new BorderPane();
		layout.setPadding(new Insets(10));
		layout.setCenter(textArea);
		layout.setBottom(horizontalBox);
		
		Scene scene= new Scene(layout,500,400);
		primaryStage.setScene(scene);
		primaryStage.show();
			
	}

}
