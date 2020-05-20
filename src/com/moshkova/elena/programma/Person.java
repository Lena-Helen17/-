package com.moshkova.elena.programma;

import java.util.*;

public class Person {
    private String namePerson;
    private String adresDostavki;
    private String telefonNumber;

    public Person(String namePerson, String adresDostavki, String telefonNumber) {
        this.namePerson = namePerson;
        this.adresDostavki = adresDostavki;
        this.telefonNumber = telefonNumber;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getAdresDostavki() {
        return adresDostavki;
    }

    public void setAdresDostavki(String adresDostavki) {
        this.adresDostavki = adresDostavki;
    }

    public String getTelefonNamber() {
        return telefonNumber;
    }

    public void setTelefonNamber(String telefonNamber) {
        this.telefonNumber = telefonNumber;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Person person = (Person)o;
            return Objects.equals(this.namePerson, person.namePerson) && Objects.equals(this.adresDostavki, person.adresDostavki) && Objects.equals(this.telefonNumber, person.telefonNumber);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.namePerson, this.adresDostavki, this.telefonNumber});
    }

    public String toString() {
        return "Person{namePerson='" + namePerson + '\'' + ", adresDostavki='" + adresDostavki + '\'' + ", telefonNumber=" + telefonNumber;
    }
}
