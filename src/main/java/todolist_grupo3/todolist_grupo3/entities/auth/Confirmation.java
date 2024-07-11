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

import java.util.UUID;

import static jakarta.persistence.FetchType.EAGER;

/**
 * when the new user is about to be created in UserServiceImpl, the service uses it to save
 * Check UserServiceImpl createUser()
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "confirmations")
public class Confirmation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @OneToOne(targetEntity = User.class, fetch = EAGER) // one user -> one confirmation
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) // if user is deleted, this entity will be deleted as well
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonProperty("id")
    @JsonIdentityReference(alwaysAsId = true)
    private User user;

    @Column(nullable = false, name="key_string")
    private String key;

    public Confirmation(User user){
        this.user = user;
        this.key = UUID.randomUUID().toString();
    }
}
