package br.com.deem.task;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.deem.utils.BaseEntity;

@Entity
@Table(name="tb_task")
public class TaskEntity extends BaseEntity<Long>{

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
	
	@Column(name="icon")
	private String icon;
	
	@Column(name="page")
	private String page;;
	
	@Column(name="date_created")
	private Date dataCreated;
	
	@Column(name="time_created")
	private Timestamp timeCreated;
	
	@Column(name="deleted")
	private Date deleted;

	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
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

	public TaskEntity(Long id, String title, String description,
			Date dataCreated, Timestamp timeCreated, Date deleted) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dataCreated = dataCreated;
		this.timeCreated = timeCreated;
		this.deleted = deleted;
	}

	public TaskEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
