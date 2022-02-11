package com.example.assignment1gc200485862;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date")); //here it actually uses the get method of this variable
        unVaccinatedCasesColumn.setCellValueFactory(new PropertyValueFactory<>("unVaccinatedCases"));
        partialVaccinatedCasesColumn.setCellValueFactory(new PropertyValueFactory<>("partialVaccinatedCases"));
        vaccinatedCasesColumn.setCellValueFactory(new PropertyValueFactory<>("vaccinatedCases"));
        totalNumbOfCasesColumn.setCellValueFactory(new PropertyValueFactory<>("totalNumbOfCases"));

        tableView.getItems().addAll(DBUtility.getCasesFromDB());
    }
}
