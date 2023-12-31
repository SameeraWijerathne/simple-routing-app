package lk.wsrp.sameera.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements SuperEntity{
    private int id;
    private String name;
    private String address;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
