package learn.springbmongodb.romain.springbmongodbromain.component;

import learn.springbmongodb.romain.springbmongodbromain.entity.Adress;
import learn.springbmongodb.romain.springbmongodbromain.entity.Hotel;
import learn.springbmongodb.romain.springbmongodbromain.entity.Review;
import learn.springbmongodb.romain.springbmongodbromain.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DbSeeder implements CommandLineRunner {

    private HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Adress("Paris","France"),
                Arrays.asList(
                        new Review("John", 8,false),
                        new Review("Marry", 7,true)
                )
        );

        Hotel ibis = new Hotel(
                "Ibis",
                90,
                new Adress("Bucharest","Romania"),
                Arrays.asList(
                        new Review("Tedd", 9,true)
                )
        );

        Hotel sofitel = new Hotel(
                "Sofitel",
                200,
                new Adress("Rome","Italy"),
                new ArrayList<>()
        );

        //Drop All Hotels
        this.hotelRepository.deleteAll();

        //Add Hotels to DB
        List<Hotel> hotels = Arrays.asList(marriot,ibis,sofitel);
        this.hotelRepository.saveAll(hotels);
    }
}
