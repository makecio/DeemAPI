package br.com.deem.categorySolver;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.deem.utils.GenericService;
import br.com.deem.utils.ServicePath;


@RestController
@CrossOrigin
@RequestMapping(path = ServicePath.CATEGORY_SOLVER_PATH)
public class CategorySolverService extends GenericService<CategorySolverEntity,Long>{
	
	private final  Logger LOGGER = Logger.getLogger(getClass());
	
	@Autowired
	private CategorySolverRepository categorySolverRepository;

	
	
}
