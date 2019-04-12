package br.com.deem.issue;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<IssueEntity,Long> {

	List<IssueEntity> findByIdUser(Long id);

	List<IssueEntity> findByStatus(int i);

	List<IssueEntity> findByStatusAndIdSolver(int status, Long idsolver);

	List<IssueEntity> findByStatusAndCategoryIn(int i, Integer[] lsCat);

	List<IssueEntity> findByIdSolverAndStatusIn(Long idSolver, Integer[] status);

	List<IssueEntity> findByIdUserAndStatus(Long idUser, int status);

	List<IssueEntity> findByStatusInAndCategoryIn(Integer[] status,
			Integer[] lsCat);
}
