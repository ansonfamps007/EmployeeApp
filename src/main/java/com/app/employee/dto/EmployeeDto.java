package com.app.employee.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
