package todolist_grupo3.todolist_grupo3.entities.auth;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import todolist_grupo3.todolist_grupo3.entities.User;

import static jakarta.persistence.FetchType.EAGER;
/**
 * when the new user is about to be created in UserServiceImpl, the service uses it to save.
 * Check UserServiceImpl createUser()
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credentials")
public class Credential {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @OneToOne(targetEntity = User.class, fetch = EAGER) // one user -> one credential
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // if user is deleted, this entity will be deleted as weññ
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    //@JsonProperty("id")
    //@JsonIdentityReference(alwaysAsId = true)
    private User user;


}
