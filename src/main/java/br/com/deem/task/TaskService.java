package br.com.deem.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deem.utils.GenericService;
import br.com.deem.utils.ServicePath;


@RestController
@CrossOrigin 
@RequestMapping(path = ServicePath.TASK_PATH)
public class TaskService extends GenericService<TaskEntity,Long>{
	
	@Autowired
	private TaskRepository taskRepository;


	
}
