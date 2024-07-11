package todolist_grupo3.todolist_grupo3.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import todolist_grupo3.todolist_grupo3.entities.enums.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name="name")
    private String name;

    @Column(nullable = false, unique = true,name="email")
    private String email;

    @Column(nullable = false,name="registerDate")
    private LocalDate registerDate;

    @Column(nullable = false,name="role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Task> tasks;

}
