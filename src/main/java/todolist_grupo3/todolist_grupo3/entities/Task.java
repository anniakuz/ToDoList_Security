package todolist_grupo3.todolist_grupo3.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import todolist_grupo3.todolist_grupo3.entities.enums.State;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(nullable = false, name="name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name="state")
    private State state;

    @ManyToOne
    @JsonProperty("user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;


}
