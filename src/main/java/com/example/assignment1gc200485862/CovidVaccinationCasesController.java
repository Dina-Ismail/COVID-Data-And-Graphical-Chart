package com.example.assignment1gc200485862;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class CovidVaccinationCasesController implements Initializable {
    //this flag will be used for the chart to populate according to the filteration critera
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
       //the following line gets the data from database according to the right sql statement, the parameter chartYear is to retrieve the
        //right data after being loaded from the chart view.
        tableView.getItems().addAll(DBUtility.getCasesFromDB( DBUtility.createSQLStatement(DBUtility.chartYear), DBUtility.chartYear));
        if(DBUtility.chartYear ==1)
            allRecordsRadioBtn.setSelected(true);
        else if(DBUtility.chartYear ==2)
            year21RadioBtn.setSelected(true);
        else if(DBUtility.chartYear ==3)
            year22RadioBtn.setSelected(true);

        totalRecordsLabel.setText("Number of Records:" + DBUtility.counter);

        yes.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
            Toggle o, Toggle n)

            {
                if(allRecordsRadioBtn.isSelected()) {
                    tableView.getItems().clear();
                    selectionLabel.setText("All Records are Shown");
                    tableView.getItems().addAll(DBUtility.getCasesFromDB( DBUtility.createSQLStatement(1), DBUtility.chartYear));
                    totalRecordsLabel.setText("Number of Records:" + DBUtility.counter);
                }
                 if(year21RadioBtn.isSelected())
                {
                    //this line resets the tableview
                    tableView.getItems().clear();
                    selectionLabel.setText("Year 2021 Data Only");
                    tableView.getItems().addAll(DBUtility.getCasesFromDB( DBUtility.createSQLStatement(2), DBUtility.chartYear));
                    totalRecordsLabel.setText("Number of Records:" + DBUtility.counter);
                }
                else if(year22RadioBtn.isSelected())
                {
                    tableView.getItems().clear();
                    selectionLabel.setText("Year 2022 Data Only");
                    tableView.getItems().addAll(DBUtility.getCasesFromDB( DBUtility.createSQLStatement(3), DBUtility.chartYear));
                    totalRecordsLabel.setText("Number of Records:" + DBUtility.counter);
                }

            }
        });
        }//end of initialize()
    @FXML
    private void loadChartView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "covidVaccinationCasesChartView.fxml");


    }



}
