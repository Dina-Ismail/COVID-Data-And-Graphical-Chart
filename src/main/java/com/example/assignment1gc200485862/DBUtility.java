package com.example.assignment1gc200485862;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DBUtility {
    private static String user = "Dina200485862";
    private static String password = "gjvSH68mVu";
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/Dina200485862";
    public static int counter; // this counter to get the number of records in the resultset

    /**
     * This method returns the correct sql statement based on the chosen radio button
     *
     * @param i
     */
    public static String createSQLStatement(int i) {
        String sql = "";
        if (i == 1) {
            sql = "Select Date, covid19_cases_unvac,covid19_cases_partial_vac,covid19_cases_full_vac, \n" +
                    "    (covid19_cases_unvac + covid19_cases_partial_vac+ covid19_cases_full_vac)\n" +
                    "    as 'totalCases' from COVID\n" +
                    "    order by Date;";
        } else if (i == 2) {
            sql = "Select Date, covid19_cases_unvac,covid19_cases_partial_vac,covid19_cases_full_vac,\n" +
                    "                    (covid19_cases_unvac + covid19_cases_partial_vac+ covid19_cases_full_vac)\n" +
                    "                   as 'totalCases' from COVID\n" +
                    "                   where year(date)=2021\n" +
                    "                   order by Date;";
        } else if (i == 3) {
            sql = "Select Date, covid19_cases_unvac,covid19_cases_partial_vac,covid19_cases_full_vac,\n" +
                    "                                    (covid19_cases_unvac + covid19_cases_partial_vac+ covid19_cases_full_vac)\n" +
                    "                                      as 'totalCases' from COVID\n" +
                    "                                     where year(date)=2022\n" +
                    "                                     order by Date;";
        }

        return sql;
    }

    /**
     * This method returns all COVID Cases information from the DB in an ArrayList
     *
     * @param sql
     */
    public static ArrayList<CovidVaccinationCases> getCasesFromDB(String sql) {
        ArrayList<CovidVaccinationCases> covidCases = new ArrayList<>(); // it creates by container to hold the data from database
        try (
                Connection conn = DriverManager.getConnection(connectURL, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            //starting the counter from 0 everytime the getCasesFromDB method is called
            counter = 0;
            covidCases.removeAll(covidCases);
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



}

