package com.employee.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Department implements Serializable {

	private static final long serialVersionUID = -5490712130206709539L;

	@Id
	@Column(name = "DEPART_CODE")
	private String departCode;

	private String deptName;

	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },mappedBy = "departments")//,mappedBy = "employeeDepartments"
	private Set<Employee> employees;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "department_project", joinColumns = @JoinColumn(name = "DEPART_CODE"), inverseJoinColumns = @JoinColumn(name = "PROJ_CODE"))
	private Set<Project> projects;

	public Department(String departCode, String deptName) {
		this.departCode = departCode;
		this.deptName = deptName;
	}

}
