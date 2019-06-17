package com.dev.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.dev.hibernate.common.EntityConstant;

@Entity
@Table(name="DEPARTMENT",uniqueConstraints={@UniqueConstraint(columnNames="ID"),@UniqueConstraint(columnNames="NAME")})

@NamedQueries({
		  @NamedQuery(name=EntityConstant.GET_DEPARTMENT_BY_ID,query=EntityConstant.GET_DEPARTMENT_BY_ID_QUERY),
		  @NamedQuery(name=EntityConstant.UPDATE_DEPARTMENT_BY_ID,query=EntityConstant.UPDATE_DEPARTMENT_BY_ID_QUERY)
		})
@NamedNativeQueries({
	@NamedNativeQuery(name=EntityConstant.GET_DEPARTMENT,query=EntityConstant.GET_DEPARTMENT_QUERY)
})
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",nullable=false,unique=true)
	private int id;
	@Column(name="NAME",nullable=false,unique=true)
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department() {
		
	}
	
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
