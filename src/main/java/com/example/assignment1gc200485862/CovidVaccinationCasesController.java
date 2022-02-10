package com.example.assignment1gc200485862;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CovidVaccinationCasesController implements Initializable {

    @FXML
    private TableView<CovidVaccinationCases> tableView;

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
       ArrayList<CovidVaccinationCases> cases =  DBUtility.getCasesFromDB();
        System.out.println("");
    }
}
