package com.example.assignment1gc200485862;

import java.util.Date;

public class CovidVaccinationCases {
    private Date date;
    private int unVaccinatedCases;
    private int partialVaccinatedCases;
    private int vaccinatedCases;
    private int totalNumbOfCases;

    public CovidVaccinationCases(Date date, int unVaccinatedCases, int partialVaccinatedCases, int vaccinatedCases, int totalNumbOfCases) {
        this.date = date;
        setUnVaccinatedCases(unVaccinatedCases);
        setPartialVaccinatedCases(partialVaccinatedCases);
        setVaccinatedCases(vaccinatedCases);
        setTotalNumbOfCases(totalNumbOfCases);
    }

    public int getTotalNumbOfCases() {
        return totalNumbOfCases;
    }

    public void setTotalNumbOfCases(int totalNumbOfCases) {
        this.totalNumbOfCases = totalNumbOfCases;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUnVaccinatedCases() {
        return unVaccinatedCases;
    }

    public void setUnVaccinatedCases(int unVaccinatedCases) {
        this.unVaccinatedCases = unVaccinatedCases;
    }

    public int getPartialVaccinatedCases() {
        return partialVaccinatedCases;
    }

    public void setPartialVaccinatedCases(int partialVaccinatedCases) {
        this.partialVaccinatedCases = partialVaccinatedCases;
    }

    public int getVaccinatedCases() {
        return vaccinatedCases;
    }

    public void setVaccinatedCases(int vaccinatedCases) {
        this.vaccinatedCases = vaccinatedCases;
    }
}
