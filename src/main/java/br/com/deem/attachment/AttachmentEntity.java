package br.com.deem.attachment;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.deem.utils.BaseEntity;

@Entity
@Table(name="tb_attachment")
public class AttachmentEntity extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8398124188141111704L;

	@Column(name="id",insertable = false, updatable = false)
	private Long id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="id_issue")
	private Long idIssue;
	
	@Column(name="id_activity")
	private Long idActivity;
	
	@Column(name="type")
	private String type;
	
	@Column(name="size")
	private float size;
	
	@Column(name="date_created")
	private Date dateCreated;
	
	@Column(name="time_created")
	private Timestamp timeCreated;
	
	@Column(name="deleted")
	private Date deleted;

	@Column(name="photoBase64", columnDefinition="LONGTEXT")
	private String photoBase64;
	
	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoBase64() {
		return photoBase64;
	}

	public void setPhotoBase64(String photoBase64) {
		this.photoBase64 = photoBase64;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdIssue() {
		return idIssue;
	}

	public void setIdIssue(Long idIssue) {
		this.idIssue = idIssue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dataCreated) {
		this.dateCreated = dataCreated;
	}

	public Timestamp getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}
	
	public Long getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}

	public AttachmentEntity(Long id, String description, Long idIssue,
			Long idActivity, String type, float size, Date dateCreated,
			Timestamp timeCreated, Date deleted, String photoBase64) {
		super();
		this.id = id;
		this.description = description;
		this.idIssue = idIssue;
		this.idActivity = idActivity;
		this.type = type;
		this.size = size;
		this.dateCreated = dateCreated;
		this.timeCreated = timeCreated;
		this.deleted = deleted;
		this.photoBase64 = photoBase64;
	}

	public AttachmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	


	
}
