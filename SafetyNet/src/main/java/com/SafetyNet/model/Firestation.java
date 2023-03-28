package com.SafetyNet.model;

public class Firestation {
    private Integer station;
    private  Person person;

    public Firestation() {
    }

    public Firestation(Integer station, Person person) {
        this.station = station;
        this.person = person;
    }

    public Integer getStation() {
        return station;
    }

    public void setStation(Integer station) {
        this.station = station;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}