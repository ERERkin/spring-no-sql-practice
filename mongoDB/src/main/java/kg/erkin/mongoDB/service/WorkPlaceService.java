package kg.erkin.mongoDB.service;

import kg.erkin.mongoDB.document.WorkPlace;
import kg.erkin.mongoDB.repository.WorkPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkPlaceService {
    @Autowired
    WorkPlaceRepository workPlaceRepository;

    public WorkPlace getById(String id){
       return workPlaceRepository.findById(id).orElse(null);
    }

    public List<WorkPlace> getAll(){
        return workPlaceRepository.findAll();
    }

    public WorkPlace update(WorkPlace workPlace){
        return workPlaceRepository.save(workPlace);
    }

    public boolean delete(String id){
        try {
            workPlaceRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
