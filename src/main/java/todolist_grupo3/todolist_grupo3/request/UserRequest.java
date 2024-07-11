package todolist_grupo3.todolist_grupo3.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

//form for user registration passed to a UserController
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {
    @NotEmpty(message = "Name can't be empty")
    private String name;
    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Invalid email")
    private String email;
    @NotEmpty(message = "Password can't be empty")
    private String password;
}
