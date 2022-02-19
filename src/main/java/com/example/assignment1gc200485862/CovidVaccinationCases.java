package com.example.assignment1gc200485862;

import java.util.Date;

public class CovidVaccinationCases {
    private Date date;
    private int unVaccinatedCases;
    private int partialVaccinatedCases;
    private int vaccinatedCases;
    private int totalNumbOfCases;

    public CovidVaccinationCases(Date date, int unVaccinatedCases, int partialVaccinatedCases, int vaccinatedCases, int totalNumbOfCases) {

        try{
            this.date = date;
            setUnVaccinatedCases(unVaccinatedCases);
            setPartialVaccinatedCases(partialVaccinatedCases);
            setVaccinatedCases(vaccinatedCases);
            setTotalNumbOfCases(totalNumbOfCases);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getTotalNumbOfCases() {
        return totalNumbOfCases;
    }

    public void setTotalNumbOfCases(int totalNumbOfCases) throws Exception {
        if(totalNumbOfCases>0)
            this.totalNumbOfCases = totalNumbOfCases;

        else throw new Exception("Number of Cases should be greater than or equal to 0");

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        try{
            this.date = date;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public int getUnVaccinatedCases() {
        return unVaccinatedCases;
    }

    public void setUnVaccinatedCases(int unVaccinatedCases) {
        try{
            this.unVaccinatedCases = unVaccinatedCases;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public int getPartialVaccinatedCases() {
        return partialVaccinatedCases;
    }

    public void setPartialVaccinatedCases(int partialVaccinatedCases) {
        try{
            this.partialVaccinatedCases = partialVaccinatedCases;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public int getVaccinatedCases() {
        return vaccinatedCases;
    }

    public void setVaccinatedCases(int vaccinatedCases) {
        try{
            this.vaccinatedCases = vaccinatedCases;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
