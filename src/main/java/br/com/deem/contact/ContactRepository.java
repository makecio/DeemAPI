package br.com.deem.contact;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity,Long>{
	
	public List<ContactEntity>findByIdCompany(int idCompany);

}