/*Copyright (c) 2016-2017 vcstest4.com All Rights Reserved.
 This software is the confidential and proprietary information of vcstest4.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with vcstest4.com*/
package com.testallservicesforvcs.adventureworks2014;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Employee generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Employee`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_550s85r2wnakc17q5diuit3q5`", columnNames = {"`LoginID`"}),
            @UniqueConstraint(name = "`UK_36c8yp0q8ry0y2acrd50qjkt`", columnNames = {"`rowguid`"}),
            @UniqueConstraint(name = "`UK_ktpwii8so9uy1t5iwicaj002j`", columnNames = {"`NationalIDNumber`"})})
public class Employee implements Serializable {

    private Integer businessEntityId;
    private String nationalIdnumber;
    private String loginId;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] organizationNode;
    private Short organizationLevel;
    private String jobTitle;
    private Date birthDate;
    private char maritalStatus;
    private char gender;
    private Date hireDate;
    private boolean salariedFlag;
    private short vacationHours;
    private short sickLeaveHours;
    private boolean currentFlag;
    private String rowguid;
    private LocalDateTime modifiedDate;
    private List<EmployeeDepartmentHistory> employeeDepartmentHistories;
    private List<EmployeePayHistory> employeePayHistories;
    private List<JobCandidate> jobCandidates;

    @Id
    @Column(name = "`BusinessEntityID`", nullable = false, scale = 0, precision = 10)
    public Integer getBusinessEntityId() {
        return this.businessEntityId;
    }

    public void setBusinessEntityId(Integer businessEntityId) {
        this.businessEntityId = businessEntityId;
    }

    @Column(name = "`NationalIDNumber`", nullable = false, length = 15)
    public String getNationalIdnumber() {
        return this.nationalIdnumber;
    }

    public void setNationalIdnumber(String nationalIdnumber) {
        this.nationalIdnumber = nationalIdnumber;
    }

    @Column(name = "`LoginID`", nullable = false, length = 256)
    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Column(name = "`OrganizationNode`", nullable = true)
    public byte[] getOrganizationNode() {
        return this.organizationNode;
    }

    public void setOrganizationNode(byte[] organizationNode) {
        this.organizationNode = organizationNode;
    }

    @Column(name = "`OrganizationLevel`", nullable = true, scale = 0, precision = 5)
    public Short getOrganizationLevel() {
        return this.organizationLevel;
    }

    public void setOrganizationLevel(Short organizationLevel) {
        this.organizationLevel = organizationLevel;
    }

    @Column(name = "`JobTitle`", nullable = false, length = 50)
    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Column(name = "`BirthDate`", nullable = false)
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "`MaritalStatus`", nullable = false, length = 1)
    public char getMaritalStatus() {
        return this.maritalStatus;
    }

    public void setMaritalStatus(char maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Column(name = "`Gender`", nullable = false, length = 1)
    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Column(name = "`HireDate`", nullable = false)
    public Date getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Column(name = "`SalariedFlag`", nullable = false)
    public boolean isSalariedFlag() {
        return this.salariedFlag;
    }

    public void setSalariedFlag(boolean salariedFlag) {
        this.salariedFlag = salariedFlag;
    }

    @Column(name = "`VacationHours`", nullable = false, scale = 0, precision = 5)
    public short getVacationHours() {
        return this.vacationHours;
    }

    public void setVacationHours(short vacationHours) {
        this.vacationHours = vacationHours;
    }

    @Column(name = "`SickLeaveHours`", nullable = false, scale = 0, precision = 5)
    public short getSickLeaveHours() {
        return this.sickLeaveHours;
    }

    public void setSickLeaveHours(short sickLeaveHours) {
        this.sickLeaveHours = sickLeaveHours;
    }

    @Column(name = "`CurrentFlag`", nullable = false)
    public boolean isCurrentFlag() {
        return this.currentFlag;
    }

    public void setCurrentFlag(boolean currentFlag) {
        this.currentFlag = currentFlag;
    }

    @Column(name = "`rowguid`", nullable = false, length = 32)
    public String getRowguid() {
        return this.rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    @Column(name = "`ModifiedDate`", nullable = false)
    public LocalDateTime getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "employee")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public List<EmployeeDepartmentHistory> getEmployeeDepartmentHistories() {
        return this.employeeDepartmentHistories;
    }

    public void setEmployeeDepartmentHistories(List<EmployeeDepartmentHistory> employeeDepartmentHistories) {
        this.employeeDepartmentHistories = employeeDepartmentHistories;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "employee")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public List<EmployeePayHistory> getEmployeePayHistories() {
        return this.employeePayHistories;
    }

    public void setEmployeePayHistories(List<EmployeePayHistory> employeePayHistories) {
        this.employeePayHistories = employeePayHistories;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "employee")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public List<JobCandidate> getJobCandidates() {
        return this.jobCandidates;
    }

    public void setJobCandidates(List<JobCandidate> jobCandidates) {
        this.jobCandidates = jobCandidates;
    }

    @PostPersist
    public void onPostPersist() {
        if(employeeDepartmentHistories != null) {
            for(EmployeeDepartmentHistory employeeDepartmentHistory : employeeDepartmentHistories) {
                employeeDepartmentHistory.setEmployee(this);
            }
        }
        if(employeePayHistories != null) {
            for(EmployeePayHistory employeePayHistory : employeePayHistories) {
                employeePayHistory.setEmployee(this);
            }
        }
        if(jobCandidates != null) {
            for(JobCandidate jobCandidate : jobCandidates) {
                jobCandidate.setEmployee(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        final Employee employee = (Employee) o;
        return Objects.equals(getBusinessEntityId(), employee.getBusinessEntityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBusinessEntityId());
    }
}

