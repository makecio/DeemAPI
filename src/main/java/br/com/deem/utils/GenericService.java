package br.com.deem.utils;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class GenericService<T extends BaseEntity<ID>,ID extends Serializable>  implements ServiceMap{
	
	private final  Logger LOGGER = Logger.getLogger(getClass());
	
	@Autowired
	protected JpaRepository<T,ID> genericRepository;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public List<T> findAll(){
		this.LOGGER.info("Todas as linhas ");
		return this.genericRepository.findAll();
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public T insert(@RequestBody T entity){
		
		this.LOGGER.info(String.format("Save",entity ));
		entity.setId(null);
		
		return this.genericRepository.save(entity);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT)
	public T update(@RequestBody T entity){
		
		if(entity.getId() == null){
			
			this.LOGGER.error("");
			 return null;
		}
		
		return this.genericRepository.save(entity);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE)
	public void delete(@RequestBody T entity){
		
		this.LOGGER.info(String.format("",entity));
		
		this.genericRepository.delete(entity);
		
	}
	

}
