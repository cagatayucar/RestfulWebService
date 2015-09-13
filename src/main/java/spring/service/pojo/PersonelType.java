package spring.service.pojo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="PERSONELTYPE" , schema="PUBLIC")
@SuppressWarnings("serial")
public class PersonelType implements Serializable{
	
	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq")
	@SequenceGenerator(name = "seq" ,sequenceName = "PERSONELTYPE_SEQ" , allocationSize = 1)
	@Column(name = "TYPE_ID")
	private Long type_id;
	
	@Basic
	@Column(name = "TYPE_NAME")
	private String type_name;

	public Long getType_id() {
		return type_id;
	}

	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	public String tooString(){
		
		return "[" + getType_id() + "," + getType_name() + "]" ;
	}

}
