package br.com.deem.company;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.deem.utils.GenericService;
import br.com.deem.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.COMPANY_PATH)
public class CompanyService extends GenericService<CompanyEntity,Long>{
	
	private CompanyRepository companyRepository;

}