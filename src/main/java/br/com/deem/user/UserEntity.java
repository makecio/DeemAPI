package br.com.deem.user;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.deem.utils.BaseEntity;

@Entity
@Table(name="tb_user")
public class UserEntity extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="id",insertable = false, updatable = false)
	private Long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="type_user")
	private int typeUser;
	
	@Column(name="date_created")
	private Date dateCreated;
	
	@Column(name="time_created")
	private Timestamp timeCreated;
	
	@Column(name="deleted")
	private Date deleted;

	@Column(name="photoBase64", columnDefinition="LONGTEXT")
	private String photoBase64;
	
	@Transient
	private int validacao;

	@Transient 
	private String error;
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(int typeUser) {
		this.typeUser = typeUser;
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

	
	
	public int getValidacao() {
		return validacao;
	}

	public void setValidacao(int validacao) {
		this.validacao = validacao;
	}

	public UserEntity(Long id, String email, String password, int typeUser,
			Date dateCreated, Timestamp timeCreated, Date deleted,
			String photoBase64, int validacao) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.typeUser = typeUser;
		this.dateCreated = dateCreated;
		this.timeCreated = timeCreated;
		this.deleted = deleted;
		this.photoBase64 = photoBase64;
		this.validacao = validacao;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(String e) {
		error = e;
		// TODO Auto-generated constructor stub
	}

	
}
