package learn.springbmongodb.romain.springbmongodbromain.controller;

import com.querydsl.core.types.dsl.BooleanExpression;
import learn.springbmongodb.romain.springbmongodbromain.entity.Hotel;
import learn.springbmongodb.romain.springbmongodbromain.entity.QHotel;
import learn.springbmongodb.romain.springbmongodbromain.repository.HotelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Hotel> getAll(){
        List<Hotel> hotels = this.hotelRepository.findAll();
        return hotels;
    }

    @PostMapping
    public void insert(@RequestBody Hotel hotel){
        this.hotelRepository.insert(hotel);
    }

    @PutMapping
    public void update(@RequestBody Hotel hotel){
        this.hotelRepository.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        this.hotelRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable("id") String id){
        Hotel hotel = this.hotelRepository.findById(id).get();
        return hotel;
    }

    @GetMapping("/price/{maxPrice}")
    public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice){
        List<Hotel> hotels= this.hotelRepository.findByPricePerNightLessThanEqual(maxPrice);
        return hotels;
    }

    @GetMapping("/address/{city}")
    public List<Hotel> getByCity(@PathVariable("city") String city){
        List<Hotel> hotels= this.hotelRepository.findByCity(city);
        return hotels;
    }

    @GetMapping("/country/{country}")
    public List<Hotel> getByCountry(@PathVariable("country") String country){
        //Create a query Class (QHotel)
        QHotel qHotel = new QHotel("hotel");
        //Using the query class we can create the filters
        BooleanExpression filterByCountry = qHotel.address.country.eq(country);
        //We can then pass the filters to findAll() method
        List<Hotel> hotels = (List<Hotel>) this.hotelRepository.findAll(filterByCountry);
        return hotels;
    }

    @GetMapping("/recommended")
    public List<Hotel> getRecommended(){
        final int maxPrice = 200;
        final int rating = 7;

        //Create a query Class (QHotel)
        QHotel qHotel = new QHotel("hotel");
        //Using the query class we can create the filters
        BooleanExpression filterByMaxPrice = qHotel.pricePerNight.lt(maxPrice);
        BooleanExpression filterByRating = qHotel.reviews.any().rating.gt(rating);

        //We can then pass the filters to findAll() method
        List<Hotel> hotels = (List<Hotel>) this.hotelRepository.findAll(filterByMaxPrice.and(filterByRating));
        return hotels;
    }

}
