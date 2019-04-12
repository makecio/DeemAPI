package br.com.deem.activity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.deem.attachment.AttachmentEntity;
import br.com.deem.attachment.AttachmentRepository;
import br.com.deem.client.ClientEntity;
import br.com.deem.issue.IssueEntity;
import br.com.deem.task.TaskEntity;
import br.com.deem.task.TaskRepository;
import br.com.deem.user.UserEntity;
import br.com.deem.utils.GenericService;
import br.com.deem.utils.ServicePath;


@RestController
@RequestMapping(path = ServicePath.ACTIVITY_PATH)
public class ActivityService extends GenericService<ActivityEntity,Long>{
	
	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private AttachmentRepository attachmentRepository;
	
	@CrossOrigin
	@RequestMapping(value = "/findByIdissue/{id}",method = RequestMethod.GET)
	public ResponseEntity findByIdproblem(@PathVariable("id") Long idissue){
	
		List<ActivityEntity> lsactivity = new ArrayList<ActivityEntity>();
		
		lsactivity=this.activityRepository.findByIdIssue(idissue);
		
		for(ActivityEntity a: lsactivity){
			a.setExtraInfo();
		}
		
		return new ResponseEntity (lsactivity, HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/updatePhotoActivity",method = RequestMethod.POST)
	public ActivityEntity updatePhotoActivity(@RequestBody ActivityEntity act){
		
		act.setDateCreated(new Date());
		act.setTimeCreated(new Timestamp(System.currentTimeMillis()));
		
		ActivityEntity activity = this.genericRepository.save(act);
		
		AttachmentEntity attachment = new AttachmentEntity();
		attachment.setIdActivity(activity.getId());
		attachment.setIdIssue(activity.getIdIssue());
		attachment.setType("PHOTO");
		attachment.setDateCreated(new Date());
		attachment.setTimeCreated(new Timestamp(System.currentTimeMillis()));
		attachment.setPhotoBase64(activity.getPhotoBase64());

		this.attachmentRepository.save(attachment);
		
		return activity;

	}
	
	@CrossOrigin
	@RequestMapping(value = "/updateAudioActivity",method = RequestMethod.POST)
	public ActivityEntity updateAudioActivity(@RequestBody ActivityEntity act){
		
		act.setDateCreated(new Date());
		act.setTimeCreated(new Timestamp(System.currentTimeMillis()));
		
		ActivityEntity activity = this.genericRepository.save(act);
			
		return activity;

	}
	
	@CrossOrigin
	@RequestMapping(value = "/updateDocsActivity",method = RequestMethod.POST)
	public ActivityEntity updateDocsActivity(@RequestBody ActivityEntity act){
		
		act.setDateCreated(new Date());
		act.setTimeCreated(new Timestamp(System.currentTimeMillis()));
		
		ActivityEntity activity = this.genericRepository.save(act);
		
		List<AttachmentEntity> lsAttachment = this.attachmentRepository.findByIdIn(act.getArrayIdAttach());
		
		for(AttachmentEntity a: lsAttachment){
			a.setIdActivity(activity.getId());
			this.attachmentRepository.save(a);
		}
		
		
		return activity;

	}
	
}
