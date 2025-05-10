package salim.test.todo_list.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
@RequestMapping("/tasxks")
public class TaskController {

    @GetMapping("/str")
    public String Salut(){
        return "Salut mon pote";
    } 
}
