package com.example.assignment1gc200485862;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DBUtility {
    private static String user = "Dina200485862";
    private static String password = "gjvSH68mVu";
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/Dina200485862";


    /**
     * This method returns all COVID Cases information from the DB in an ArrayList
     */
    public static ArrayList<CovidVaccinationCases> getCasesFromDB(){
        ArrayList<CovidVaccinationCases> covidCases = new ArrayList<>(); // it creates by container to hold the data from database
        String sql = "Select Date, covid19_cases_unvac,covid19_cases_partial_vac,covid19_cases_full_vac, \n" +
                "    (covid19_cases_unvac + covid19_cases_partial_vac+ covid19_cases_full_vac)\n" +
                "    as 'totalCases' from COVID\n" +
                "    order by Date;";
        try (
                Connection conn = DriverManager.getConnection(connectURL, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) //loop around the resultSet
            {// create objects from CovidVaccinationCases class by assigning the attributes to the db columns
                Date date = resultSet.getDate("Date");
                int unVaccinatedCases = resultSet.getInt("covid19_cases_unvac");
                int partialVaccinatedCases = resultSet.getInt("covid19_cases_partial_vac");
                int vaccinatedCases = resultSet.getInt("covid19_cases_full_vac");
                int total = resultSet.getInt("totalCases");

                System.out.println("");
                //creating an object based on the data pulled from database
                CovidVaccinationCases cases = new CovidVaccinationCases(date,unVaccinatedCases,partialVaccinatedCases,vaccinatedCases,total);
                // I am adding each record pulled to my arrayList
                covidCases.add(cases);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return covidCases;

    }//end of getCasesFromDB()
}

