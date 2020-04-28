import java.util.Objects;

public class Person {
    private String namePerson;
    private String adresDostavki;
    private Long telefonNumber;

    public Person(String namePerson, String adresDostavki, Long telefonNumber) {
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

    public Long getTelefonNamber() {
        return telefonNumber;
    }

    public void setTelefonNamber(Long telefonNamber) {
        this.telefonNumber = telefonNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(namePerson, person.namePerson) &&
                Objects.equals(adresDostavki, person.adresDostavki) &&
                Objects.equals(telefonNumber, person.telefonNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePerson, adresDostavki, telefonNumber);
    }

    @Override
    public String toString() {
        return "Person{" +
                "namePerson='" + namePerson + '\'' +
                ", adresDostavki='" + adresDostavki + '\'' +
                ", telefonNumber=" + telefonNumber +
                '}';
    }
}
