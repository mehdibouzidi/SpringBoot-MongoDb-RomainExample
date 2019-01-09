package learn.springbmongodb.romain.springbmongodbromain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
    private String username;
    private int rating;
    private boolean approved;

    public Review() {
    }

    public Review(String username, int rating, boolean approved) {
        this.username = username;
        this.rating = rating;
        this.approved = approved;
    }
}
