package br.com.deem.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.deem.utils.GenericService;
import br.com.deem.utils.ServicePath;


@RestController
@RequestMapping(path = ServicePath.CATEGORY_PATH)
public class CategoryService extends GenericService<CategoryEntity,Long>{
	
	@Autowired
	private CategoryRepository categoryRepository;


	
}
