package salim.test.todo_list.Service;
import salim.test.todo_list.Model.*;
import salim.test.todo_list.Repository.TaskRepository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAll() {
        return repository.findAll();
    }

    public List<Task> getByStatut(Statut statut) {
        return repository.findByStatut(statut);
    }
    public Task getByIdTask(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tâche introuvable"));
    }
  

    public Task create(Task task) {
        return repository.save(task);
    }

    public Task update(Long id, Task task) {
        Task existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Tâche introuvable"));
        existing.setTitre(task.getTitre());
        existing.setDescription(task.getDescription());
        existing.setStatut(task.getStatut());
        existing.setDateEcheance(task.getDateEcheance());
        return repository.save(existing);
    }

    public void delete(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("Tâche introuvable"));
        if (task.getStatut() == Statut.TERMINEE) {
            throw new IllegalStateException("Impossible de supprimer une tâche terminée");
        }
        repository.deleteById(id);
    }

}
