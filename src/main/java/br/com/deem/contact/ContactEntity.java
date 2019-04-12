package br.com.deem.contact;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.deem.utils.BaseEntity;

@Entity
@Table(name="tb_contact")
public class ContactEntity extends BaseEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="id",insertable = false, updatable = false)
	private Long id;
	
	@Column(name="name")
	private String name;
	@Column(name="id_company")
	private int idCompany;
	@Column(name="number_contact")
	private String numberContact;
	@Column(name="deleted")
	private String deleted;
	@Column(name="pic_contact")
	private String picContact;
	
	
	
	
	
	public ContactEntity() {
		super();
	}
	
	public ContactEntity(Long id, String name, int idCompany, String numberContact, String deleted,
			String picContact) {
		super();
		this.id = id;
		this.name = name;
		this.idCompany = idCompany;
		this.numberContact = numberContact;
		this.deleted = deleted;
		this.picContact = picContact;
	}
	//Getters and Setters
	
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
	public int getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}
	public String getNumberContact() {
		return numberContact;
	}
	public void setNumberContact(String numberContact) {
		this.numberContact = numberContact;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getPicContact() {
		return picContact;
	}
	public void setPicContact(String picContact) {
		this.picContact = picContact;
	}
	

}