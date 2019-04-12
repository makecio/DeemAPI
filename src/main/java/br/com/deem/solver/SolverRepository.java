package br.com.deem.solver;


import org.springframework.data.jpa.repository.JpaRepository;

public interface SolverRepository extends JpaRepository<SolverEntity,Long> {

	SolverEntity findByIdUser(Long id);
	

}
