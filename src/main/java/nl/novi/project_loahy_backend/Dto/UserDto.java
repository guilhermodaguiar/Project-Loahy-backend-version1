package nl.novi.project_loahy_backend.Dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserDto {
    private final Long id;
    @NotBlank
    private final String firstName;

    @NotBlank
    private final String lastName;


    @Email(message = "invalid email address")
    private  final String userEmail;

    @NotBlank
    private String password;


}
