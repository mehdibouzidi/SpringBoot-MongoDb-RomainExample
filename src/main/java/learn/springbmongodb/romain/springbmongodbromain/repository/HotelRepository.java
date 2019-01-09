package learn.springbmongodb.romain.springbmongodbromain.repository;

import learn.springbmongodb.romain.springbmongodbromain.entity.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String>, QuerydslPredicateExecutor<Hotel>{
     List<Hotel> findByPricePerNightLessThanEqual(int max);

     @Query(value = "{'address.city':?0}")
     List<Hotel> findByCity(String city);
}
