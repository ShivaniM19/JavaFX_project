package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Created by Shivani on 7/13/2023.
 */
public class MyMain extends Application {

	public static void main(String[] args) {
		System.out.println("main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
//        Pane rootNode = loader.load();
		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);
		primaryStage.setTitle("Temperature Converter Tool");
		//  primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private MenuBar createMenu() {
		//file menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
//lambda function
//		newMenuItem.setOnAction(event -> {
//			System.out.println("new menu item clicked");
//		});
		newMenuItem.setOnAction(event -> System.out.println("new menu item clicked"));
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
//		quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				Platform.exit();
//				System.exit(0);
//			}
//		});
		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

		//help menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");

		aboutApp.setOnAction(event -> {
			aboutApp();
		});

//		aboutApp.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				aboutApp();
//			}
//		});

		helpMenu.getItems().addAll(aboutApp);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My first Desktop Application");
		alertDialog.setHeaderText("Learning Javafx");
		alertDialog.setContentText("I am just a beginner but soon i will be pro and strt developing awsome Java games");


		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

//		alertDialog.show();
		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

		if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn) {
			System.out.println("Yes button clicked");
		} else {
			System.out.println("No button clicked");
		}

	}

	public void stop() throws Exception {
		System.out.println("stop");
		super.stop();
	}


}
