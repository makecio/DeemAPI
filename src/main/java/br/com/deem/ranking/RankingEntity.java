package br.com.deem.ranking;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.deem.utils.BaseEntity;

@Entity
@Table(name="tb_ranking")
public class RankingEntity extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8398124188141111704L;

	@Column(name="id",insertable = false, updatable = false)
	private Long id;
	
	@Column(name="id_user_client")
	private int idUserClient;
	
	@Column(name="id_user_solver")
	private int idUserSolver;
	
	@Column(name="point")
	private int point;
	
	@Column(name="date_created")
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

	public int getIdUserClient() {
		return idUserClient;
	}

	public void setIdUserClient(int idUserClient) {
		this.idUserClient = idUserClient;
	}

	public int getIdUserSolver() {
		return idUserSolver;
	}

	public void setIdUserSolver(int idUserSolver) {
		this.idUserSolver = idUserSolver;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
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

	public RankingEntity(Long id, int idUserClient, int idUserSolver,
			int point, Date dataCreated, Timestamp timeCreated, Date deleted) {
		super();
		this.id = id;
		this.idUserClient = idUserClient;
		this.idUserSolver = idUserSolver;
		this.point = point;
		this.dataCreated = dataCreated;
		this.timeCreated = timeCreated;
		this.deleted = deleted;
	}

	public RankingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
}
