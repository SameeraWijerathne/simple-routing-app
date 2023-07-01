package lk.wsrp.sameera.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Integer id;
    @NotBlank(message = "Name can't be empty or null")
    @Pattern(regexp = "[A-Za-z ]+", message = "Invalid name!")
    private String name;
    @NotBlank(message = "Address can't be empty or null")
    @Length(min = 3, message = "Invalid address!")
    private String address;
}
