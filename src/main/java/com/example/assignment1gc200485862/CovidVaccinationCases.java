package com.example.assignment1gc200485862;

import java.util.Date;

public class CovidVaccinationCases {
    private Date date;
    private int unVaccinatedCases;
    private int partialVaccinatedCases;
    private int vaccinatedCases;

    public CovidVaccinationCases(Date date, int unVaccinatedCases, int partialVaccinatedCases, int vaccinatedCases) {
        this.date = date;
        this.unVaccinatedCases = unVaccinatedCases;
        this.partialVaccinatedCases = partialVaccinatedCases;
        this.vaccinatedCases = vaccinatedCases;
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
