package com.iboss.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

import com.iboss.enums.AccountType;

@Entity
@Table(name = "USER")
@Indexed
public class User {

	public User() {
	}
	
	public User(Long userId) {
		this.id = userId;
	}
	
	public User(String userUUID) {
		this.userUUID = userUUID;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long id;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "USER_UUID", unique = true, nullable = false, length = 100)
	private String userUUID;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "ACCOUNT_ID", unique = true, nullable = false, length = 60)
	private String accountId;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "USER_NAME", unique = true, nullable = false, length = 60)
	private String userName;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "Email_ID", unique = true, nullable = false, length = 50)
	private String emailId;

	@Column(name = "PASSWORD", nullable = false, length = 20)
	private String password;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "FIRST_NAME", length = 60)
	private String firstName;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "LAST_NAME", length = 60)
	private String lastName;
	
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "PROFESSIONAL_TITLE", length = 60)
	private String professionalTitle;
	
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "COMPANY_NAME", length = 60)
	private String companyName;

	@Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
	@DateBridge(resolution = Resolution.DAY)
	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(name = "COUNTRY_ID")
	private Long countryId;
	
	@Column(name = "ROLE")
	private AccountType role;

	// @IndexedEmbedded
	@OneToMany(mappedBy = "user")
	private List<Address> address;

	@OneToMany(mappedBy = "user")
	private List<UserQualification> userQualifications;
	
	@OneToMany(mappedBy = "user")
	private List<UserExperience> userExperiences;
	
	@OneToMany(mappedBy = "user")
	private List<UserPortfolio> userPortfolios;	
	
	@OneToMany(mappedBy = "user")
	private List<UserSkillSet> skillSet;	
	
	@OneToMany(mappedBy = "client")
	private List<Job> jobs;
	
	@OneToMany(mappedBy = "user")
	private List<JobContract> contracts;	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public AccountType getRole() {
		return role;
	}

	public void setRole(AccountType role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<UserQualification> getUserQualifications() {
		return userQualifications;
	}

	public void setUserQualifications(List<UserQualification> userQualifications) {
		this.userQualifications = userQualifications;
	}

	public List<UserPortfolio> getUserPortfolios() {
		return userPortfolios;
	}

	public void setUserPortfolios(List<UserPortfolio> userPortfolios) {
		this.userPortfolios = userPortfolios;
	}

	public List<UserExperience> getUserExperiences() {
		return userExperiences;
	}

	public void setUserExperiences(List<UserExperience> userExperiences) {
		this.userExperiences = userExperiences;
	}

	public List<UserSkillSet> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(List<UserSkillSet> skillSet) {
		this.skillSet = skillSet;
	}

	public String getProfessionalTitle() {
		return professionalTitle;
	}

	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
}
