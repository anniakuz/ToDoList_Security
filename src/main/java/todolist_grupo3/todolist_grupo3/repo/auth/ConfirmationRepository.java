package todolist_grupo3.todolist_grupo3.repo.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolist_grupo3.todolist_grupo3.entities.User;
import todolist_grupo3.todolist_grupo3.entities.auth.Confirmation;

import java.util.Optional;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Integer> {
    Optional<Confirmation> findByKey(String key);
    Optional<Confirmation> findByUser(User user);
}
