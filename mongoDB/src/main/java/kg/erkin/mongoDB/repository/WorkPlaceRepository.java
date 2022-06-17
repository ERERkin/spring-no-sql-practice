package kg.erkin.mongoDB.repository;

import kg.erkin.mongoDB.document.WorkPlace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkPlaceRepository extends MongoRepository<WorkPlace, String> {
}
