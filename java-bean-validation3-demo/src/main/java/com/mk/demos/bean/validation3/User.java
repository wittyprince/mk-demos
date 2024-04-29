package com.mk.demos.bean.validation3;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * User
 *
 * @author WangChen
 * Created on 2024/4/29
 * @since 1.0
 */
@Data
public class User {

    @NotNull(message = "Name cannot be null")
    private String name;

    @AssertTrue
    private boolean working;

    @Size(min = 10, max = 200, message
            = "About Me must be between 10 and 200 characters")
    private String aboutMe;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private int age;

    @Email(message = "Email should be valid")
    private String email;


    /**
     * In this case, any value added to the preferences list will be validated.
     */
    private List<@NotBlank String> preferences;

    /**
     * supports the new Optional type in Java 8:
     * Here, the validation framework will automatically unwrap the LocalDate value and validate it.
     */
    private LocalDate dateOfBirth;
    public Optional<@Past LocalDate> getDateOfBirth() {
        return Optional.of(dateOfBirth);
    }

}
