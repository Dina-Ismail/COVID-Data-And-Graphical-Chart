package com.example.assignment1gc200485862;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;


public class CovidVaccinationChartController implements Initializable {
    int  toTableViewYear;
    @FXML
    private Label chartYearLabel;

    @FXML
    private LineChart<String, Integer> lineChart;

    @FXML
    private NumberAxis noOfCases;

    @FXML
    private CategoryAxis vaccinationStatus;

    @FXML
    private XYChart.Series<Date, Number> cases;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lineChart.setCreateSymbols(false);
        toTableViewYear = DBUtility.chartYear;
        lineChart.getData().addAll(DBUtility.getFullyVaccinatedSeries(DBUtility.chartYear));
        lineChart.getData().add(DBUtility.getUnVaccinatedSeries(DBUtility.chartYear));
        lineChart.getData().add(DBUtility.getPartialVaccinatedSeries(DBUtility.chartYear));
        if(DBUtility.chartYear == 1)
            chartYearLabel.setText("Chart Showing all records");
        else   if(DBUtility.chartYear == 2)
            chartYearLabel.setText("Chart Showing Year 2021 records");
        else   if(DBUtility.chartYear == 3)
            chartYearLabel.setText("Chart Showing Year 2022 records");
    }

    /** This method loads the table view and set chartYear variable to the corresponding
     * year viewed by the user to reflect Data table
     * @param event
     * @throws IOException
     */
    @FXML
    private void loadTableView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "covidVaccinationCasesTableView.fxml");
        DBUtility.chartYear =  toTableViewYear;
    }
}
