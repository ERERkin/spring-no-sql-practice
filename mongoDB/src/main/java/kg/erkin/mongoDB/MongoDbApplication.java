package kg.erkin.mongoDB;

import kg.erkin.mongoDB.controller.WorkPlaceController;
import kg.erkin.mongoDB.document.WorkPlace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbApplication.class, args);
	}

}
