package com.internshala.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
	@FXML
	public Label welcomeLabel;
	@FXML
	public ChoiceBox<String> choicebox;
	@FXML
	public TextField userInputField;
	@FXML
	public Button convertBtn;

	private static final String C_TO_F_TEXT="Celsius to Fahrenheit";
	private static final String F_TO_C_TEXT="Fahrenheit to Celsius";

	private boolean isC_TO_F=true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choicebox.getItems().add(C_TO_F_TEXT);
		choicebox.getItems().add(F_TO_C_TEXT);
		choicebox.setValue(C_TO_F_TEXT);

		choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
		{
			if (newValue.equals(C_TO_F_TEXT)) {
				isC_TO_F = true;
			} else {
				isC_TO_F = false;
			}
		});
//		choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				if (newValue.equals(C_TO_F_TEXT)) {
//					isC_TO_F = true;
//				} else {
//					isC_TO_F = false;
//				}
//			}
//		});

		convertBtn.setOnAction(event ->
		{
			convert();
		});

	}
	float enteredTemperature=0.0f;
	private void convert(){
		String input=userInputField.getText();
		try{
			enteredTemperature=Float.parseFloat(input);
		}
		catch(Exception e) {
			warnUser();
			return;
		}

		float newTemperature=0.0f;
		if(isC_TO_F){   //if user selected "celsius to fahrenheit"
            newTemperature=(enteredTemperature*9/5)+32;
		}else {         //if user selected "fahrenheit to celsius"
			newTemperature = (enteredTemperature - 32) * 5 / 9;
		}

		display(newTemperature);
	}
	private void warnUser(){
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid temperature entered");
		alert.setContentText("Please enter valid temperature");
		alert.show();
	}
	private void display( float newTemperature){
		String unit= isC_TO_F?"F":"C";
		System.out.println("The new temperature entered:"+newTemperature + unit);
		Alert dialog=new Alert(Alert.AlertType.INFORMATION);
		dialog.setTitle("Result");
		dialog.setContentText("The new temperature is:"+newTemperature + unit);
		dialog.show();
	}
}
