package io.javademo.micro.service.conference;

import java.time.LocalDate;

public class Conference {

    private String name;
    private LocalDate begin;
    private LocalDate end;
    private LocalDate cfp;
    private String website;
    private String country;
    private String city;
    private int daysLeft;
    private int cfpDaysLeft;
    private String isoCountry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public LocalDate getCfp() {
        return cfp;
    }

    public void setCfp(LocalDate cfp) {
        this.cfp = cfp;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public int getCfpDaysLeft() {
        return cfpDaysLeft;
    }

    public void setCfpDaysLeft(int cfpDaysLeft) {
        this.cfpDaysLeft = cfpDaysLeft;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
    }
}
