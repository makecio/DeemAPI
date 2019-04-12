package br.com.deem.issue;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.deem.categorySolver.CategorySolverEntity;
import br.com.deem.categorySolver.CategorySolverRepository;
import br.com.deem.client.ClientEntity;
import br.com.deem.client.ClientRepository;
import br.com.deem.company.CompanyEntity;
import br.com.deem.company.CompanyRepository;
import br.com.deem.user.UserRepository;
import br.com.deem.utils.GenericService;
import br.com.deem.utils.ServicePath;


@RestController
@CrossOrigin
@RequestMapping(path = ServicePath.ISSUE_PATH)
public class IssueService extends GenericService<IssueEntity,Long>{
	
	@Autowired
	private IssueRepository issueRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategorySolverRepository categorySolverRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ClientRepository clientRepository;

	
	@CrossOrigin
	@RequestMapping(value = "/findByIdUserAndStatus/{id}/{status}",method = RequestMethod.GET)
	public ResponseEntity findByIdUserAndStatus(@PathVariable("id") Long idUser, @PathVariable("status") int status){
		
		List<IssueEntity> lsIssues = this.issueRepository.findByIdUserAndStatus(idUser, status);
		
		
		for(IssueEntity i: lsIssues){
			i.setExtraInfo();
			ClientEntity client = this.clientRepository.findByIdUser(i.getIdUser());
			i.setTelefone(client.getCellphone());
		}
		
		return new ResponseEntity (lsIssues, HttpStatus.OK);
	
	}

	
	@CrossOrigin
	@RequestMapping(value = "/availableIssues/{id}",method = RequestMethod.GET)
	public ResponseEntity availableIssues(@PathVariable("id") Long idSolver){
		

		List<CategorySolverEntity> lsCategorySolver = categorySolverRepository.findByIdSolver(idSolver);
		
		Integer[] lsCat = new Integer[lsCategorySolver.size()];
		Integer[] status = new Integer[]{1,3};
		
		int i =0;
		for(CategorySolverEntity cat: lsCategorySolver){
			lsCat[i] = Integer.parseInt(cat.getIdCategory().toString());
			i++;
		}
		List<IssueEntity> lsIssues = this.issueRepository.findByStatusInAndCategoryIn(status, lsCat);
		
		for(IssueEntity is: lsIssues){
			is.setExtraInfo();
			
		}
		
		return new ResponseEntity (lsIssues, HttpStatus.OK);
	
	}
	
	@CrossOrigin
	@RequestMapping(value = "/finishIssue",method = RequestMethod.POST)
	public IssueEntity finishIssue(@RequestBody IssueEntity i){

		IssueEntity issue = this.issueRepository.findOne(i.getId());
	
		issue.setStatus(4);
		
		this.issueRepository.save(issue);
	
	
		return issue;
	
	}
	
	@CrossOrigin
	@RequestMapping(value = "/giveupIssue",method = RequestMethod.POST)
	public IssueEntity giveupIssue(@RequestBody IssueEntity i){

		IssueEntity issue = this.issueRepository.findOne(i.getId());
	
		issue.setStatus(3);
		
		this.issueRepository.save(issue);
	
		return issue;
	
	}
	
	@CrossOrigin
	@RequestMapping(value = "/acceptIssue",method = RequestMethod.POST)
	public IssueEntity acceptIssue(@RequestBody IssueEntity i){

		IssueEntity issue = this.issueRepository.findOne(i.getId());
	
		issue.setIdSolver(i.getIdSolver());
		issue.setStatus(2);
		
		this.issueRepository.save(issue);
	
	
		return issue;
	
	}
	
	@CrossOrigin
	@RequestMapping(value = "/findByStatusAndIdSolver/{id}",method = RequestMethod.GET)
	public ResponseEntity findByStatusAndIdSolver(@PathVariable("id") Long idSolver){
		
		Integer[] status = new Integer[]{2,4};
		List<IssueEntity> lsIssues = this.issueRepository.findByIdSolverAndStatusIn(idSolver,status);
			
		for(IssueEntity i: lsIssues){
			i.setExtraInfo();
			ClientEntity client = this.clientRepository.findByIdUser(i.getIdUser());
			i.setTelefone(client.getCellphone());
		}
		
		return new ResponseEntity (lsIssues, HttpStatus.OK);
	
	}
	
	@CrossOrigin
	@RequestMapping(value = "/findById/{id}",method = RequestMethod.GET)
	public ResponseEntity findById(@PathVariable("id") Long id){
		
		IssueEntity i = this.issueRepository.findOne(id);
		
		i.setExtraInfo();		
		
		return new ResponseEntity (i, HttpStatus.OK);
	
	}
	
	@CrossOrigin
	@RequestMapping(value = "/saveIssue",method = RequestMethod.POST)
	public ResponseEntity saveIssue(@RequestBody IssueEntity issue){
		
		CompanyEntity company = null;
		if(issue.getIdCompany() == null){
			company = new CompanyEntity();
			company.setNameCompany(issue.getNameCompany());
			company.setRankCompany(0);
			this.companyRepository.save(company);
		}
		
		if(company != null){
			issue.setIdCompany(company.getId());
		}
		
		issue.setDateCreated(new Date());
		issue.setTimeCreated(new Timestamp(System.currentTimeMillis()));
		issue.setStatus(1);
		
		this.issueRepository.save(issue);
		
		
		
		
		
		return new ResponseEntity (issue, HttpStatus.OK);
	
	}
	
	
}
