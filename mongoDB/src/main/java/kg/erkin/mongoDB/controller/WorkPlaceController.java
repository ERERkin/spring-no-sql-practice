package kg.erkin.mongoDB.controller;

import kg.erkin.mongoDB.document.WorkPlace;
import kg.erkin.mongoDB.service.WorkPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkPlaceController {
    @Autowired
    private WorkPlaceService workPlaceService;

    @GetMapping()
    public ResponseEntity<?> getById(@RequestParam String id){
        return ResponseEntity.ok(workPlaceService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> update(@RequestBody WorkPlace workPlace){
        return ResponseEntity.ok(workPlaceService.update(workPlace));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(workPlaceService.getAll());
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(String id){
        return ResponseEntity.ok("Success");
    }
}
