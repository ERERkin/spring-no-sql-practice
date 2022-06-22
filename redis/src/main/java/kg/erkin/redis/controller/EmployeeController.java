package kg.erkin.redis.controller;

import kg.erkin.redis.dto.Employee;
import kg.erkin.redis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    ResponseEntity<?> getById(@RequestParam String id){
        return ResponseEntity.ok(employeeRepository.getById(id));
    }

    @PostMapping
    ResponseEntity<?> update(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAll(){
        return ResponseEntity.ok(employeeRepository.getAll());
    }

    @DeleteMapping
    ResponseEntity<?> deleteById(String id){
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("Ok");
    }
}
