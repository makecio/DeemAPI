package br.com.deem.client;

import java.sql.Timestamp;
import java.util.Date;

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

import br.com.deem.issue.IssueEntity;
import br.com.deem.issue.IssueRepository;
import br.com.deem.solver.SolverEntity;
import br.com.deem.user.UserEntity;
import br.com.deem.user.UserRepository;
import br.com.deem.utils.EmailUtil;
import br.com.deem.utils.GenericService;
import br.com.deem.utils.ServicePath;


@RestController
@CrossOrigin
@RequestMapping(path = ServicePath.CLIENT_PATH)
public class ClientService extends GenericService<ClientEntity,Long>{
	
	private final  Logger LOGGER = Logger.getLogger(getClass());
	
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IssueRepository issueRepository;
	
	@CrossOrigin
	@RequestMapping(value = "/saveFirstClient",method = RequestMethod.POST)
	public UserEntity saveFirstClient(@RequestBody ClientEntity client){
		
		this.LOGGER.info(String.format("Save",client ));
		
		UserEntity userBD = userRepository.findByEmail(client.getEmail());
		
		if(userBD == null){
			//register User
			UserEntity user = new UserEntity();
			user.setDateCreated(new Date());
			user.setTimeCreated(new Timestamp(System.currentTimeMillis()));
			user.setEmail(client.getEmail());
			user.setPassword(client.getPassword());
			user.setTypeUser(1);
			
			this.userRepository.save(user);
			
			client.setId(null);
			client.setIdUser(user.getId());
			client.setDataCreated(new Date());
			client.setTimeCreated(new Timestamp(System.currentTimeMillis()));
			client = this.genericRepository.save(client);
			
			EmailUtil email = new EmailUtil();
			email.enviarEmailAlerta(client.getEmail());
			user.setError("SUCESSO");
			
			return user;
		}else{
			return new UserEntity("USER_EXISTENTE");
		}
		
	}

	@CrossOrigin
	@RequestMapping(value = "/saveClient",method = RequestMethod.POST)
	public ClientEntity saveSolver(@RequestBody ClientEntity client){
		
		this.LOGGER.info(String.format("Save",client ));

		ClientEntity clientBD = this.clientRepository.findByIdUser(client.getIdUser());
		
		if(client.getAction() == 1){
			
			clientBD.setName(client.getName());
			clientBD.setSurname(client.getSurname());
			clientBD.setCellphone(client.getCellphone());
			clientBD.setPhone(client.getPhone());
			clientBD.setDateBirth(client.getDateBirth());
			clientBD.setGender(client.getGender());
			clientBD.setMaritalStatus(client.getMaritalStatus());
			
		}else if(client.getAction() == 2){
			
			clientBD.setStreet(client.getStreet());
			clientBD.setNumber(client.getNumber());
			clientBD.setComplement(client.getComplement());
			clientBD.setCep(client.getCep());
			clientBD.setNeighborhood(client.getNeighborhood());
			clientBD.setCity(client.getCity());
			clientBD.setState(client.getState());
			clientBD.setCountry(client.getCountry());
			
		}

		
		this.genericRepository.save(clientBD);
		
		return client;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getClient/{id}",method = RequestMethod.GET)
	public ResponseEntity getClient(@PathVariable("id") Long idClient){
		
		ClientEntity client = this.clientRepository.findByIdUser(idClient);
		
		return new ResponseEntity (client, HttpStatus.OK);
		
	}
	
}
