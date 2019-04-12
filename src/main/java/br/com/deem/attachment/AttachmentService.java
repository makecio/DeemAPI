package br.com.deem.attachment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.deem.activity.ActivityEntity;
import br.com.deem.utils.GenericService;
import br.com.deem.utils.ServicePath;


@RestController
@RequestMapping(path = ServicePath.ATTACHMENT_PATH)
public class AttachmentService extends GenericService<AttachmentEntity,Long>{
	
	@Autowired
	private AttachmentRepository attachmentRepository;


	@CrossOrigin
	@RequestMapping(value = "/findByIdActivity/{id}",method = RequestMethod.GET)
	public ResponseEntity findByIdActivity(@PathVariable("id") Long IdActivity){
	
		List<AttachmentEntity> lsAttachment =this.attachmentRepository.findByIdActivity(IdActivity);
		
		return new ResponseEntity (lsAttachment, HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@RequestMapping(value="/getAttachment/{id}",method = RequestMethod.GET)
	public void getAttachment(HttpServletResponse response, @PathVariable("id") Long idAttachment) throws IOException {
		
		AttachmentEntity attachment = this.attachmentRepository.findOne(idAttachment);
		
		File file = new File("/home/Deem/upload/"+idAttachment);
		
		// Get your file stream from wherever.
		InputStream myStream = new FileInputStream(file);

		// Set the content type and attachment header.
		response.addHeader("Content-disposition", "attachment;filename="+attachment.getDescription());

		// Copy the stream to the response's output stream.
		IOUtils.copy(myStream, response.getOutputStream());
		response.flushBuffer();
	    
	}
	
}
