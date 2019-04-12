package br.com.deem.categorySolver;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorySolverRepository extends JpaRepository<CategorySolverEntity,Long> {

	List<CategorySolverEntity> findByIdSolver(Long idSolver);
	

}
