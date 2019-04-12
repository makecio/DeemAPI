package br.com.deem.user;

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

import br.com.deem.issue.IssueEntity;
import br.com.deem.utils.GenericService;
import br.com.deem.utils.ServicePath;


@RestController
@CrossOrigin
@RequestMapping(path = ServicePath.USER_PATH)
public class UserService extends GenericService<UserEntity,Long>{
	
	@Autowired
	private UserRepository userRepository;

	@CrossOrigin
	@RequestMapping(value = "/getUser/{email}/{password}",method = RequestMethod.GET)
	public UserEntity getUser(@PathVariable("email") String email, @PathVariable("password") String password){
		
		UserEntity user = this.userRepository.findByEmail(email);
	
		if (user == null) {
			user = new UserEntity();
			user.setValidacao(1);
		    return user;
		}else{
			if(user.getPassword().equals(password)){
				if(user.getTypeUser() == 1){
					return user;
				}else if(user.getTypeUser() == 2){
					return user;
				}else{
					user.setValidacao(2);
					return user;
				}
			}else{
				user.setValidacao(3);
				return user;
			}
		}
		
		 
	}
	
	@CrossOrigin
	@RequestMapping(value = "/updatePhotoUser",method = RequestMethod.PUT)
	public UserEntity updatePhotoUser(@RequestBody UserEntity u){
	
		UserEntity user = this.userRepository.findOne(u.getId());
	
		if(user != null){
			user.setPhotoBase64(u.getPhotoBase64());
			this.userRepository.save(user);
		}
		
		
		return user;
	}
	
}
