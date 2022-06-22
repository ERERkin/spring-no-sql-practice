package kg.erkin.redis.repository;

import kg.erkin.redis.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository  {
    public static final String HASH_KEY = "Employee";
    @Autowired
    private RedisTemplate template;

    public Employee save(Employee employee){
        template.opsForHash().put(HASH_KEY, employee.getId(), employee);
        return employee;
    }

    public List<Employee> getAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Employee getById(String id){
        return (Employee) template.opsForHash().get(HASH_KEY, id);
    }

    public void deleteById(String id){
        template.opsForHash().delete(HASH_KEY, id);
    }
}
