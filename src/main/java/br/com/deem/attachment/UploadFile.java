package br.com.deem.attachment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.sql.Timestamp;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.deem.activity.ActivityEntity;
import br.com.deem.activity.ActivityRepository;
import br.com.deem.utils.ServicePath;

@RestController
@CrossOrigin
@RequestMapping(path = ServicePath.FILE_PATH)
public class UploadFile {

	 
	    public static final String UPLOAD_FILE_SERVER = "/home/Deem/upload/";
	  
		@Autowired
		private ActivityRepository activityRepository;
		
		@Autowired
		private AttachmentRepository attachmentRepository;
		
	    @CrossOrigin
	    @POST
	    @RequestMapping(value = "/upload", method = RequestMethod.POST)	    
	    @Consumes(MediaType.MULTIPART_FORM_DATA)
	    public @ResponseBody Long uploadImageFile(
	    		@RequestParam(value = "file") MultipartFile file,
	    		@RequestParam(value = "idIssue") Long idIssue) {
	 
	    	AttachmentEntity attachment = new AttachmentEntity();
	    	
	        try {
	        	        		
        		attachment.setIdIssue(idIssue);
        		attachment.setType("DOC");
        		attachment.setDateCreated(new Date());
        		attachment.setTimeCreated(new Timestamp(System.currentTimeMillis()));
        		attachment.setDescription(file.getOriginalFilename());
        		attachment.setSize(file.getSize());
        		
        		this.attachmentRepository.save(attachment);
        		
	            writeToFileServer(file, attachment.getId().toString());
	        }
	        catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	        finally{
	            // release resources, if any
	        }
	        
	        return attachment.getId();
	    }
	 
	    /**
	     * write input stream to file server
	     * @param inputStream
	     * @param fileName
	     * @throws IOException
	     */
	    private boolean writeToFileServer(MultipartFile file, String fileName) throws IOException {
	 
	    	String qualifiedUploadFilePath = UPLOAD_FILE_SERVER + fileName;
	    	 
	    	try{
	    		File convFile = new File(qualifiedUploadFilePath);
				file.transferTo(convFile);
				return true;
	    	}catch(Exception e){
	    		return false;
	    	}
	    	
	    }
	}

