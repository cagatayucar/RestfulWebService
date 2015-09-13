package spring.service.dao;

import java.util.List;

import spring.service.pojo.PersonelType;

public interface PersonelTypeServiceDAO {
	
	public Long addType(PersonelType personelType);
	public PersonelType editType(PersonelType personelType);
	public PersonelType getType(Long personelTypeId);
	public void deleteType(Long personelTypeId);
	public List<PersonelType> getAllType();

}
