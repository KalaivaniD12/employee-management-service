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
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Employee implements Serializable {

	private static final long serialVersionUID = -679585485495005741L;

	@Id
	@Column(name = "EMP_CODE")
	private String empCode;

	private String name;

	private Integer salary;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "employee_department", joinColumns = @JoinColumn(name = "EMP_CODE"), inverseJoinColumns = @JoinColumn(name = "DEPART_CODE"))
	private Set<Department> departments;//employeeDepartments;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "EMP_CODE"), inverseJoinColumns = @JoinColumn(name = "PROJ_CODE"))
	private Set<Project> projects;//employeeProjects;

}
