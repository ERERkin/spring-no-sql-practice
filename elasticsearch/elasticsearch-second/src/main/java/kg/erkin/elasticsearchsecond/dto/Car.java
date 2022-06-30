package kg.erkin.elasticsearchsecond.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Slf4j
public class Car {
    Long id;
    String model;
    Integer year;

    public Car(String model, Integer year) {
        this.model = model;
        this.year = year;
    }
}
