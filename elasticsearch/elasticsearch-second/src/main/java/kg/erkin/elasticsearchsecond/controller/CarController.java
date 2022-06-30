package kg.erkin.elasticsearchsecond.controller;

import kg.erkin.elasticsearchsecond.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    ResponseEntity<?> getById(@RequestParam Long id){
        return ResponseEntity.ok(carService.getById(id));
    }
}
