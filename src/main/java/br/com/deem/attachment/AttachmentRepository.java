package br.com.deem.attachment;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.deem.activity.ActivityEntity;

public interface AttachmentRepository extends JpaRepository<AttachmentEntity,Long> {

	List<AttachmentEntity> findByIdActivity(Long idActivity);

	List<AttachmentEntity> findByIdIn(Long[] arrayIdAttach);

}
