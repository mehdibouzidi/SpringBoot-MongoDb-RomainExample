package learn.springbmongodb.romain.springbmongodbromain.repository;

import learn.springbmongodb.romain.springbmongodbromain.entity.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String>{
}
