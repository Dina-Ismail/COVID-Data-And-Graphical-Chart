package com.example.assignment1gc200485862;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class CovidVaccinationCasesController implements Initializable {

    @FXML
    private TableView<CovidVaccinationCases> tableView;

    @FXML
    private TableColumn<CovidVaccinationCases, Date> dateColumn;

    @FXML
    private TableColumn<CovidVaccinationCases, Integer> unVaccinatedCasesColumn;

    @FXML
    private TableColumn<CovidVaccinationCases, Integer> partialVaccinatedCasesColumn;

    @FXML
    private TableColumn<CovidVaccinationCases, Integer> vaccinatedCasesColumn;

    @FXML
    private TableColumn<CovidVaccinationCases, Integer> totalNumbOfCasesColumn;

    @FXML
    private RadioButton allRecordsRadioBtn;

    @FXML
    private RadioButton year21RadioBtn;

    @FXML
    private RadioButton year22RadioBtn;

    @FXML
    private ToggleGroup yes;

    @FXML
    private Label selectionLabel;

    @FXML
    private Label totalRecordsLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date")); //here it actually uses the get method of this variable
        unVaccinatedCasesColumn.setCellValueFactory(new PropertyValueFactory<>("unVaccinatedCases"));
        partialVaccinatedCasesColumn.setCellValueFactory(new PropertyValueFactory<>("partialVaccinatedCases"));
        vaccinatedCasesColumn.setCellValueFactory(new PropertyValueFactory<>("vaccinatedCases"));
        totalNumbOfCasesColumn.setCellValueFactory(new PropertyValueFactory<>("totalNumbOfCases"));
//        allRecordsRadioBtn.setSelected(true);
//        tableView.getItems().addAll(DBUtility.getCasesFromDB( DBUtility.createSQLStatement(1)));
//        totalRecordsLabel.setText("Number of Records:" + DBUtility.counter);

        yes.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
            Toggle o, Toggle n)

            {

                if(allRecordsRadioBtn.isSelected()) {
                    tableView.getItems().removeAll();
                    selectionLabel.setText("All Records are Shown");
                    tableView.getItems().addAll(DBUtility.getCasesFromDB( DBUtility.createSQLStatement(1)));
                    totalRecordsLabel.setText("Number of Records:" + DBUtility.counter);

                }

                 if(year21RadioBtn.isSelected())
                {
                    tableView.getItems().removeAll();
                    selectionLabel.setText("Year 2021 Data Only");
                    tableView.getItems().addAll(DBUtility.getCasesFromDB( DBUtility.createSQLStatement(2)));
                    totalRecordsLabel.setText("Number of Records:" + DBUtility.counter);
                    tableView.refresh();
                }
                else if(year22RadioBtn.isSelected())
                {
                    tableView.getItems().removeAll();
                    selectionLabel.setText("Year 2022 Data Only");
                    tableView.getItems().addAll(DBUtility.getCasesFromDB( DBUtility.createSQLStatement(3)));
                    totalRecordsLabel.setText("Number of Records:" + DBUtility.counter);
                }

            }
        });


        }



}
