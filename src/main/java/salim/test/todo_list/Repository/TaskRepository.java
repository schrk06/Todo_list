package salim.test.todo_list.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import salim.test.todo_list.Model.Statut;
import salim.test.todo_list.Model.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{
    List<Task> findByStatut(Statut statut);
}
