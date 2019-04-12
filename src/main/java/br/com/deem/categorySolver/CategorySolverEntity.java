package br.com.deem.categorySolver;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.deem.utils.BaseEntity;

@Entity
@Table(name="tb_category_solver")
public class CategorySolverEntity extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8398124188141111704L;

	@Column(name="id",insertable = false, updatable = false)
	private Long id;

	@Column(name="id_solver")
	private Long idSolver;

	@Column(name="id_category")
	private Long idCategory;
	
	@Column(name="data_created")
	private Date dataCreated;
	
	@Column(name="time_created")
	private Timestamp timeCreated;
	
	@Column(name="deleted")
	private Date deleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSolver() {
		return idSolver;
	}

	public void setIdSolver(Long idSolver) {
		this.idSolver = idSolver;
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public Date getDataCreated() {
		return dataCreated;
	}

	public void setDataCreated(Date dataCreated) {
		this.dataCreated = dataCreated;
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

	public CategorySolverEntity(Long id, Long idSolver, Long idCategory,
			Date dataCreated, Timestamp timeCreated, Date deleted) {
		super();
		this.id = id;
		this.idSolver = idSolver;
		this.idCategory = idCategory;
		this.dataCreated = dataCreated;
		this.timeCreated = timeCreated;
		this.deleted = deleted;
	}

	public CategorySolverEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}
