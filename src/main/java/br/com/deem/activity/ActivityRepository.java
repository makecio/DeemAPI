package br.com.deem.activity;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<ActivityEntity,Long> {

	List<ActivityEntity> findByIdIssue(Long idissue);
	

}
