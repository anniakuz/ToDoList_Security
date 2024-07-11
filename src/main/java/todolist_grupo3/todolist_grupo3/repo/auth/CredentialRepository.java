package todolist_grupo3.todolist_grupo3.repo.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolist_grupo3.todolist_grupo3.entities.auth.Credential;

import java.util.Optional;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Integer> {
    Optional<Credential> getCredentialById(Integer id);
}
