package todolist_grupo3.todolist_grupo3.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todolist_grupo3.todolist_grupo3.domain.Response;
import todolist_grupo3.todolist_grupo3.request.UserRequest;
import todolist_grupo3.todolist_grupo3.services.UserService;

import java.net.URI;

import static java.util.Collections.emptyMap;
import static org.springframework.http.HttpStatus.CREATED;
import static todolist_grupo3.todolist_grupo3.utils.RequestUtils.getResponse;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * UserRequest user is from package 'request' which is a body with required fields. This way we ensure
     * that the form for user registration is exactly as we want it to be
     * @param user
     * @param request
     * @return Response class described in 'domain' package class Response
     */
    @PostMapping("/signUp")
    public ResponseEntity<Response> createUser(@RequestBody @Valid UserRequest user, HttpServletRequest request){
        userService.createUser(user.getName(), user.getEmail(), user.getPassword());
        return ResponseEntity.created(getUri()).body(getResponse(request, emptyMap()
                , "Account created, check your email", CREATED));
    }

    private URI getUri(){
        return URI.create("");
    }
}
