
package br.com.deem.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.deem.utils.GenericService;
import br.com.deem.utils.ServicePath;

@RestController
@CrossOrigin
@RequestMapping(path = ServicePath.CONTACT_PATH)
public class ContactService extends GenericService<ContactEntity,Long>{
	
	@Autowired
	private ContactRepository contactRepository;
	
		
	@CrossOrigin
	@RequestMapping(value = "/findbycompany/{idCompany}",method = RequestMethod.GET)
	public ResponseEntity findByIdUserAndStatus(@PathVariable("idCompany") int idCompany){
		
		List<ContactEntity> lscontacts = this.contactRepository.findByIdCompany(idCompany);
				
		return new ResponseEntity (lscontacts, HttpStatus.OK);
	
	}

}