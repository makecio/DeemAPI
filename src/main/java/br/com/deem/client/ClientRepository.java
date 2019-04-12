package br.com.deem.client;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity,Long> {

	ClientEntity findByIdUser(Long idClient);
	

}
