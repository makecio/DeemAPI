package br.com.deem.issue;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;

import br.com.deem.client.ClientEntity;
import br.com.deem.utils.BaseEntity;

@Entity
@Table(name="tb_issue")
public class IssueEntity extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8398124188141111704L;

	@Column(name="id",insertable = false, updatable = false)
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="id_user")
	private Long idUser;
	
	@Column(name="id_solver")
	private Long idSolver;
	
	@Column(name="category")
	private int category;
	
	@Column(name="status")
	private int status;
	
	@Column(name="date_created")
	private Date dateCreated;
	
	@Column(name="time_created")
	private Timestamp timeCreated;
	
	@Column(name="deleted")
	private Date deleted;

	@Column(name="id_company")
	private Long idCompany;
	
	@Transient
	private String targetDate;
	
	@Transient
	private String statusString;
	
	@Transient
	private String urlIcon;
	
	@Transient
	private String emailSolver;
	
	@Transient
	private String nameCompany;
	
	@Transient
	private String telefone;
	
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getUrlIcon() {
		return urlIcon;
	}

	public void setUrlIcon(String urlIcon) {
		this.urlIcon = urlIcon;
	}

	public String getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	
	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdSolver() {
		return idSolver;
	}

	public void setIdSolver(Long idSolver) {
		this.idSolver = idSolver;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	
	
	public String getEmailSolver() {
		return emailSolver;
	}

	public void setEmailSolver(String emailSolver) {
		this.emailSolver = emailSolver;
	}

	public IssueEntity(Long id, String title, String description, Long idUser,
			Long idSolver, int category, int status, Date dateCreated,
			Timestamp timeCreated, Date deleted) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.idUser = idUser;
		this.idSolver = idSolver;
		this.category = category;
		this.status = status;
		this.dateCreated = dateCreated;
		this.timeCreated = timeCreated;
		this.deleted = deleted;
		
	}

	public IssueEntity() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	
	public Long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}

	public void setExtraInfo(){
		
		if(this.getDateCreated() != null){
			String newstring = new SimpleDateFormat("dd/MM/yyyy").format(this.getDateCreated());
			this.setTargetDate(newstring);
		}
		
		if(this.getStatus() != 0){
			if(this.getStatus() == 1){
				this.setStatusString("Pendente");
			}else if(this.getStatus() == 2){
				this.setStatusString("Aceito");
			}else if(this.getStatus() == 3){
				this.setStatusString("Cancelada");
			}else if(this.getStatus() == 4){
				this.setStatusString("Finalizada");
			}
		}
		
		if(this.getCategory() != 0){
			if(this.getCategory() == 1){
				this.setUrlIcon("cloud_done");
			}else if(this.getCategory() == 2){
				this.setUrlIcon("shopping_cart");
			}else if(this.getCategory() == 3){
				this.setUrlIcon("flight");
			}else if(this.getCategory() == 4){
				this.setUrlIcon("local_phone");
			}else if(this.getCategory() == 5){
				this.setUrlIcon("account_balance");
			}
		}
		
		
	}
	
}
