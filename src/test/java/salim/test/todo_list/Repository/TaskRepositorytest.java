package salim.test.todo_list.Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import salim.test.todo_list.Model.Statut;
import salim.test.todo_list.Model.Task;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TaskRepositorytest {
    @Autowired
    private TaskRepository repository;

    @Test
    public void testFindByStatut() {
        Task task = new Task();
        task.setTitre("Test");
        task.setDescription("Description test");
        task.setStatut(Statut.A_FAIRE);
        repository.save(task);

        List<Task> tasks = repository.findByStatut(Statut.A_FAIRE);
        assertThat(tasks).isNotEmpty();
}
}