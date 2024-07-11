package todolist_grupo3.todolist_grupo3.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todolist_grupo3.todolist_grupo3.entities.User;
import todolist_grupo3.todolist_grupo3.entities.auth.Confirmation;
import todolist_grupo3.todolist_grupo3.entities.auth.Credential;
import todolist_grupo3.todolist_grupo3.entities.enums.Role;
import todolist_grupo3.todolist_grupo3.repo.UserRepository;
import todolist_grupo3.todolist_grupo3.repo.auth.ConfirmationRepository;
import todolist_grupo3.todolist_grupo3.repo.auth.CredentialRepository;

import java.time.LocalDate;

@Service@AllArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CredentialRepository credentialRepository;
    @Autowired
    private ConfirmationRepository confirmationRepository;

    //private final BCryptPasswordEncoder encoder;
    @Override
    public void createUser(String name, String email, String password) {
            var userEntity = userRepository.save(createNewUser(name, email));
            var credentialEntity = Credential.builder().user(userEntity).password(password).build();
            credentialRepository.save(credentialEntity);
            var confirmationEntity = new Confirmation(userEntity);
            confirmationRepository.save(confirmationEntity);
    }

    private User createNewUser(String name, String email){
        User newUser = User.builder().name(name).email(email).role(Role.USER).registerDate(LocalDate.now()).build();
        return newUser;
    }
}
