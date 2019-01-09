package learn.springbmongodb.romain.springbmongodbromain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Adress {
    private String city;
    private String country;

    public Adress() {
    }

    public Adress(String city, String country) {
        this.city = city;
        this.country = country;
    }
}
