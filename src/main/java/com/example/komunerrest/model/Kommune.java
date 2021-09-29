package com.example.komunerrest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Kommune {

    @Id
    private int kommuneKode;
    private String kommune;
    private String regionKode;
    private String regionHref;
    private String regionsNavn;

    public Kommune(){}

    public String getRegionsNavn() {
        return regionsNavn;
    }

    public void setRegionsNavn(String regionsNavn) {
        this.regionsNavn = regionsNavn;
    }

    public int getKommuneKode() {
        return kommuneKode;
    }

    public void setKommuneKode(int kommuneKode) {
        this.kommuneKode = kommuneKode;
    }

    public String getKommune() {
        return kommune;
    }

    public void setKommune(String kommune) {
        this.kommune = kommune;
    }

    public String getRegionKode() {
        return regionKode;
    }

    public void setRegionKode(String regionKode) {
        this.regionKode = regionKode;
    }

    public String getRegionHref() {
        return regionHref;
    }

    public void setRegionHref(String regionHref) {
        this.regionHref = regionHref;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kommune kommune = (Kommune) o;
        return kommuneKode == kommune.kommuneKode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kommuneKode);
    }

    @Override
    public String toString() {
        return "Kommune{" +
                "kommuneKode=" + kommuneKode +
                ", kommune='" + kommune + '\'' +
                ", regionKode='" + regionKode + '\'' +
                ", regionHref='" + regionHref + '\'' +
                ", regionsNavn='" + regionsNavn + '\'' +
                '}';
    }
}

