package br.com.deem.activity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.deem.task.TaskEntity;
import br.com.deem.user.UserEntity;
import br.com.deem.utils.BaseEntity;

@Entity
@Table(name="tb_activity")
public class ActivityEntity extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8398124188141111704L;

	@Column(name="id",insertable = false, updatable = false)
	private Long id;
	
	@Column(name="id_issue")
	private Long idIssue;
	
	@Column(name="id_task")
	private Long idTask;
	
	@Column(name="id_user")
	private Long idUser;
		
	@Column(name="description")
	private String description;
	
	@Column(name="date_created")
	private Date dateCreated;
	
	@Column(name="time_created")
	private Timestamp timeCreated;
	
	@Column(name="deleted")
	private Date deleted;
	
	@Transient
	private String photoBase64;
	
	@Transient Long[] arrayIdAttach;
	
	@OneToOne()
	@JoinColumns({
		@JoinColumn (name="id_task", referencedColumnName="id", insertable=false, updatable=false)
    })
	private TaskEntity task;
	
	@OneToOne()
	@JoinColumns({
		@JoinColumn (name="id_user", referencedColumnName="id", insertable=false, updatable=false)
    })
	private UserEntity user;
	
	@Transient
	private String targetDate;
	
	@Transient
	private String dono;
	
	
	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}

	public Long[] getArrayIdAttach() {
		return arrayIdAttach;
	}

	public void setArrayIdAttach(Long[] arrayIdAttach) {
		this.arrayIdAttach = arrayIdAttach;
	}

	public TaskEntity getTask() {
		return task;
	}

	public void setTask(TaskEntity task) {
		this.task = task;
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

	public Long getIdTask() {
		return idTask;
	}

	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Timestamp time_created) {
		this.timeCreated = time_created;
	}

	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	public ActivityEntity(Long id, Long idIssue, Long idTask, Long idUser,
			String description, Date dateCreated, Timestamp time_created,
			Date deleted) {
		super();
		this.id = id;
		this.idIssue = idIssue;
		this.idTask = idTask;
		this.idUser = idUser;
		this.description = description;
		this.dateCreated = dateCreated;
		this.deleted = deleted;
	}

	public ActivityEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setExtraInfo(){
		
		if(this.getDateCreated() != null){
			String newstring = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(this.getDateCreated());
			this.setTargetDate(newstring);
		}
		
		if(this.getUser().getTypeUser() == 1){
			this.setDono("Cliente");
		}else if(this.getUser().getTypeUser() == 2){
			this.setDono("Resolvedor");
		}
		
	}
	
	
	
}
