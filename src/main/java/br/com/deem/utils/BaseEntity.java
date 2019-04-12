package br.com.deem.utils;

import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

//mapeia o codigo java com o banco de dados

public  abstract class BaseEntity <ID extends Serializable> extends AbstractPersistable<ID>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String toString(){
		//montra string do objeto
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public boolean equals(Object obj){
		
		return EqualsBuilder.reflectionEquals(this,obj);
	}
	
	public void setId(ID id){
		
		super.setId(id);
	}
	
	@JsonIgnore
	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return super.isNew();
	}
	
	

}
