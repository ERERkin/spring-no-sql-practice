package kg.erkin.redis.controller;

import kg.erkin.redis.entity.Employee;
import kg.erkin.redis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    ResponseEntity<?> getById(@RequestParam Long id){
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @PostMapping
    ResponseEntity<?> save(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @GetMapping("/all")
    ResponseEntity<?> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @DeleteMapping
    ResponseEntity<?> deleteById(Long id){
        employeeService.deleteById(id);
        return ResponseEntity.ok("Ok");
    }
}
