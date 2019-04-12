package br.com.deem.solver;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.deem.utils.BaseEntity;

@Entity
@Table(name="tb_solver")
public class SolverEntity extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8398124188141111704L;

	@Column(name="id",insertable = false, updatable = false)
	private Long id;
	
	@Column(name="idUser")
	private Long idUser;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="job")
	private String job;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="date_birth")
	private Date dateBirth;

	@Column(name="maritalStatus")
	private String maritalStatus;
	
	@Column(name="cellphone")
	private String cellphone;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="rg")
	private int rg;
	
	@Column(name="cpf")
	private int cpf;
	
	@Column(name="street")
	private String street;
	
	@Column(name="number")
	private int number;
	
	@Column(name="complement")
	private String complement;
	
	@Column(name="cep")
	private int cep;
	
	@Column(name="neighborhood")
	private String neighborhood;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="degree_school")
	private String degreeSchool;
	
	@Column(name="data_created")
	private Date dataCreated;
	
	@Column(name="time_created")
	private Timestamp timeCreated;
	
	@Column(name="status")
	private int status;
	
	@Column(name="deleted")
	private Date deleted;

	@Transient 
	private String email;
	
	@Transient 
	private String password;
	
	@Transient 
	private Long[] categorias;
	
	@Transient 
	private int action;
	
	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long[] getCategorias() {
		return categorias;
	}

	public void setCategorias(Long[] categorias) {
		this.categorias = categorias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDegreeSchool() {
		return degreeSchool;
	}

	public void setDegreeSchool(String degreeSchool) {
		this.degreeSchool = degreeSchool;
	}

	public Date getDataCreated() {
		return dataCreated;
	}

	public void setDataCreated(Date dataCreated) {
		this.dataCreated = dataCreated;
	}

	public Timestamp getHoraCreated() {
		return timeCreated;
	}

	public void setHoraCreated(Timestamp horaCreated) {
		this.timeCreated = horaCreated;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public SolverEntity(Long id, String name, String surname, String job,
			String gender, Date dateBirth, String maritalStatus,
			String cellphone, String phone, String photo, int rg, int cpf,
			String street, int number, String complement, int cep,
			String neighborhood, String city, String state, String country,
			String qualification, String degreeSchool, Date dataCreated,
			Timestamp timeCreated, int status, Date deleted, String email,
			String password, Long[] categorias) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.job = job;
		this.gender = gender;
		this.dateBirth = dateBirth;
		this.maritalStatus = maritalStatus;
		this.cellphone = cellphone;
		this.phone = phone;
		this.photo = photo;
		this.rg = rg;
		this.cpf = cpf;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.cep = cep;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.country = country;
		this.qualification = qualification;
		this.degreeSchool = degreeSchool;
		this.dataCreated = dataCreated;
		this.timeCreated = timeCreated;
		this.status = status;
		this.deleted = deleted;
		this.email = email;
		this.password = password;
		this.categorias = categorias;
	}

	public SolverEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
