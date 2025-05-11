package salim.test.todo_list.Controller;
import salim.test.todo_list.Model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import salim.test.todo_list.Service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public List<Task> getAll(){
        return service.getAll();
    }

    //public List<Task> getAll(@RequestParam(required = false) Statut statut) {      //sert à combiner getall et getbystatut
    //    if (statut != null) {
  //          return service.getByStatut(statut);
  //      }
 //       return service.getAll();
 //   }

    @GetMapping("/statut/{statut}")
    public List<Task> getByStatut(@PathVariable Statut statut) {
        return service.getByStatut(statut);
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.create(task);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        return service.update(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
