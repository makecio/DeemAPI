package br.com.deem.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.deem.utils.BaseEntity;

@Entity
@Table(name="tb_company")
public class CompanyEntity extends BaseEntity<Long>{
	
	private static final long serialVersionUID = 8398124188141111704L;

	@Column(name="id",insertable = false, updatable = false)
	private Long id;
	private String nameCompany;
	private String deleted;
	private int rankCompany;
	
	
	
	

	public CompanyEntity() {
		super();
	}
	public CompanyEntity(Long id, String nameCompany, String deleted, int rankCompany) {
		super();
		this.id = id;
		this.nameCompany = nameCompany;
		this.deleted = deleted;
		this.rankCompany = rankCompany;
	}
	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameCompany() {
		return nameCompany;
	}
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public int getRankCompany() {
		return rankCompany;
	}
	public void setRankCompany(int rankCompany) {
		this.rankCompany = rankCompany;
	}
	

}