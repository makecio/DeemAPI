package br.com.deem.solver;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
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
import br.com.deem.issue.IssueEntity;
import br.com.deem.user.UserEntity;
import br.com.deem.user.UserRepository;
import br.com.deem.utils.EmailUtil;
import br.com.deem.utils.GenericService;
import br.com.deem.utils.ServicePath;


@RestController
@CrossOrigin
@RequestMapping(path = ServicePath.SOLVER_PATH)
public class SolverService extends GenericService<SolverEntity,Long>{
	
	private final  Logger LOGGER = Logger.getLogger(getClass());
	
	@Autowired
	private SolverRepository solverRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategorySolverRepository categorySolverRepository;
	
	@CrossOrigin
	@RequestMapping(value = "/saveFirstSolver",method = RequestMethod.POST)
	public int saveFirstClient(@RequestBody SolverEntity solver){
		
		this.LOGGER.info(String.format("Save",solver ));
		
		UserEntity userBD = userRepository.findByEmail(solver.getEmail());
		
		if(userBD == null){
			//register User
			UserEntity user = new UserEntity();
			user.setDateCreated(new Date());
			user.setTimeCreated(new Timestamp(System.currentTimeMillis()));
			user.setEmail(solver.getEmail());
			user.setPassword(solver.getPassword());
			user.setTypeUser(2);
			
			this.userRepository.save(user);
			
			solver.setId(null);
			solver.setIdUser(user.getId());
			solver.setDataCreated(new Date());
			solver.setHoraCreated(new Timestamp(System.currentTimeMillis()));
			solver = this.genericRepository.save(solver);
			if(solver != null){
				
				
				for (int i=0; i<solver.getCategorias().length; i++){
					
					CategorySolverEntity CategorySolver = new CategorySolverEntity();
					CategorySolver.setDataCreated(new Date());
					CategorySolver.setTimeCreated(new Timestamp(System.currentTimeMillis()));
					CategorySolver.setIdSolver(user.getId());
					CategorySolver.setIdCategory(solver.getCategorias()[i]);
					
					this.categorySolverRepository.save(CategorySolver);
				}
				
			}
			
			EmailUtil email = new EmailUtil();
			email.enviarEmailAlerta(solver.getEmail());
			
			return 0;
		}else{
			return 1;
		}
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/saveSolver",method = RequestMethod.POST)
	public SolverEntity saveSolver(@RequestBody SolverEntity solver){
		
		this.LOGGER.info(String.format("Save",solver ));

		SolverEntity solverBD = this.solverRepository.findByIdUser(solver.getIdUser());
		
		if(solver.getAction() == 1){
			
			solverBD.setName(solver.getName());
			solverBD.setSurname(solver.getSurname());
			solverBD.setCellphone(solver.getCellphone());
			solverBD.setPhone(solver.getPhone());
			solverBD.setDateBirth(solver.getDateBirth());
			solverBD.setGender(solver.getGender());
			solverBD.setMaritalStatus(solver.getMaritalStatus());
			
		}else if(solver.getAction() == 2){
			
			solverBD.setStreet(solver.getStreet());
			solverBD.setNumber(solver.getNumber());
			solverBD.setComplement(solver.getComplement());
			solverBD.setCep(solver.getCep());
			solverBD.setNeighborhood(solver.getNeighborhood());
			solverBD.setCity(solver.getCity());
			solverBD.setState(solver.getState());
			solverBD.setCountry(solver.getCountry());
			
		}if(solver.getAction() == 3){

			solverBD.setJob(solver.getJob());
			solverBD.setQualification(solver.getQualification());
			solverBD.setDegreeSchool(solver.getDegreeSchool());
			
		}

		
		this.genericRepository.save(solverBD);
		
		return solver;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getSolver/{id}",method = RequestMethod.GET)
	public ResponseEntity getSolver(@PathVariable("id") Long idSolver){
		
		SolverEntity solver = this.solverRepository.findByIdUser(idSolver);
		
		return new ResponseEntity (solver, HttpStatus.OK);
		
	}
	
}
