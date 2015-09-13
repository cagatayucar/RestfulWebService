package spring.service.pojo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PERSONEL" , schema="PUBLIC")
@SuppressWarnings("serial")
public class Personel implements Serializable{
	
	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq")
	@SequenceGenerator(name = "seq" ,sequenceName = "PERSONEL_SEQ" , allocationSize = 1)
	@Column(name="PERSONELID")
	private Long personelid;
	
	@Basic
	@Column(name = "NAME")
	private String name;
	
	@Basic
	@Column(name = "SURNAME")
	private String surname;
	
	@Basic
	@Column(name = "ADDRESS")
	private String address;
	
	@Basic
	@Column(name = "PHONENUMBER")
	private String phonenumber;
	
	@ManyToOne
	@JoinColumn(name = "PERSTYPE")
	private PersonelType personelType;
	
	

	public PersonelType getPersonelType() {
		return personelType;
	}

	public void setPersonelType(PersonelType personelType) {
		this.personelType = personelType;
	}

	public Long getPersonelid() {
		return personelid;
	}

	public void setPersonelid(Long personelid) {
		this.personelid = personelid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String tooString(){
		
		return "[" + getPersonelid() + "," + getName() + "," + getSurname() + "," + getAddress() + "," + getPhonenumber() + "," + getPersonelType() + "]";
	}
	
}
