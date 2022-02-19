package com.example.assignment1gc200485862;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DBUtility {
    private static String user = "Dina200485862";
    private static String password = "gjvSH68mVu";
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/Dina200485862";
    // this counter to get the number of records in the resultset
    public static int counter;
    //this variable is for the chart to populate the right data according to the year filtration and also used for the table data for same purpose
    public static int chartYear=1;

    /**
     * This method returns the correct sql statement based on the chosen radio button
     * and set chart variable to plot the right data on the chart according to the filtration of year
     * @param i
     */
    public static String createSQLStatement(int i) {
        String sql = "";
        if (i == 1) {
           chartYear=i;
            sql = "Select Date, covid19_cases_unvac,covid19_cases_partial_vac,covid19_cases_full_vac, \n" +
                    "    (covid19_cases_unvac + covid19_cases_partial_vac+ covid19_cases_full_vac)\n" +
                    "    as 'totalCases' from COVID\n" +
                    "    order by Date;";
        } else if (i == 2) {
            chartYear=i;

            sql = "Select Date, covid19_cases_unvac,covid19_cases_partial_vac,covid19_cases_full_vac,\n" +
                    "                    (covid19_cases_unvac + covid19_cases_partial_vac+ covid19_cases_full_vac)\n" +
                    "                   as 'totalCases' from COVID\n" +
                    "                   where year(date)=2021\n" +
                    "                   order by Date;";
        } else if (i == 3) {
            chartYear=i;

            sql = "Select Date, covid19_cases_unvac,covid19_cases_partial_vac,covid19_cases_full_vac,\n" +
                    "                                    (covid19_cases_unvac + covid19_cases_partial_vac+ covid19_cases_full_vac)\n" +
                    "                                      as 'totalCases' from COVID\n" +
                    "                                     where year(date)=2022\n" +
                    "                                     order by Date;";
        }

        return sql;
    }//end of createSQLStatement()

    /**
     * This method returns all COVID Cases information from the DB in an ArrayList
     * according to a sql statement and chart year, so it could be interactive with what data
     * the user was viewing on the chart
     * @param sql and chartYear
     */
    public static ArrayList<CovidVaccinationCases> getCasesFromDB(String sql, int chartYear) {
        ArrayList<CovidVaccinationCases> covidCases = new ArrayList<>(); // it creates by container to hold the data from database
        try (
                Connection conn = DriverManager.getConnection(connectURL, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            //starting the counter from 0 everytime the getCasesFromDB method is called
            counter = 0;
           // covidCases.removeAll(covidCases);
            while (resultSet.next()) //loop around the resultSet
            {// create objects from CovidVaccinationCases class by assigning the attributes to the db columns
                Date date = resultSet.getDate("Date");
                int unVaccinatedCases = resultSet.getInt("covid19_cases_unvac");
                int partialVaccinatedCases = resultSet.getInt("covid19_cases_partial_vac");
                int vaccinatedCases = resultSet.getInt("covid19_cases_full_vac");
                int total = resultSet.getInt("totalCases");
                //creating an object based on the data pulled from database
                CovidVaccinationCases cases = new CovidVaccinationCases(date, unVaccinatedCases, partialVaccinatedCases, vaccinatedCases, total);
                // I am adding each record pulled to my arrayList
                covidCases.add(cases);
                counter++;
            }
         } catch (SQLException e) {
            e.printStackTrace();
        }
        return covidCases;
    }//end of getCasesFromDB()

    /**
     * This method returns all Fully Vaccinated Cases information from the DB in an ArrayList
     * and creates series for it on the chart
     * based on the year filtration
     * @param chartYear
     */
    public static XYChart.Series<String, Integer> getFullyVaccinatedSeries(int chartYear) {
        XYChart.Series<String,Integer> vaccinatedCases = new Series<>();
        ArrayList<CovidVaccinationCases> allCases = getCasesFromDB(createSQLStatement(chartYear), chartYear);
        vaccinatedCases.setName("Fully Vaccinated");
        //loop over my array to add it to the XYChart.Series
        for (CovidVaccinationCases allCase : allCases)
        {
            vaccinatedCases.getData().add(new XYChart.Data<>(allCase.getDate().toString(), allCase.getVaccinatedCases()));
        }
        return vaccinatedCases;

    }// end of getFullyVaccinatedSeries()
    /**
     * This method returns all unvaccinated Cases information from the DB in an ArrayList and creates
     * series for it on the chart
     * based on the year filtration
     * @param chartYear
     */
    public static XYChart.Series<String, Integer> getUnVaccinatedSeries(int chartYear) {
        XYChart.Series<String,Integer> unVaccinatedCases = new Series<>();
        ArrayList<CovidVaccinationCases> allCases = getCasesFromDB(createSQLStatement(chartYear), chartYear);
        unVaccinatedCases.setName("Unvaccinated");
        //loop over my array to add it to the XYChart.Series
        for (CovidVaccinationCases allCase : allCases)
        {
            unVaccinatedCases.getData().add(new XYChart.Data<>(allCase.getDate().toString(), allCase.getUnVaccinatedCases()));
        }
        return unVaccinatedCases;

    } // end of getUnVaccinatedSeries()
    /**
     * This method returns all partial vaccination Cases information from the DB in an ArrayList and creates
     * series for it on the chart
     * based on the year filtration
     * @param chartYear
     */
    public static XYChart.Series<String, Integer> getPartialVaccinatedSeries(int chartYear) {
        XYChart.Series<String,Integer> partialVaccinatedCases = new Series<>();
        ArrayList<CovidVaccinationCases> allCases = getCasesFromDB(createSQLStatement(chartYear), chartYear);
        partialVaccinatedCases.setName("Partial Vaccination");
        //loop over my array to add it to the XYChart.Series
        for (CovidVaccinationCases allCase : allCases)
        {
            partialVaccinatedCases.getData().add(new XYChart.Data<>(allCase.getDate().toString(), allCase.getPartialVaccinatedCases()));
        }
        return partialVaccinatedCases;

    } // end of getPartialVaccinatedSeries()
}


