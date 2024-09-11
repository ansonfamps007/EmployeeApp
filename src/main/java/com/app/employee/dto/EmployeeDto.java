package com.app.employee.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    private Long id;

    @NotEmpty(message = "First Name cannot be empty !")
    private String firstName;

    @NotEmpty(message = "Last Name cannot be empty !")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty !")
    private String email;
}
