package spring.service;

import java.util.List;

import spring.service.pojo.Personel;
import spring.service.pojo.PersonelType;

public interface PersonelService {
	
	public void addPersonel(Personel personel);
	public void editPersonel(Personel personel);
	public Personel getPersonel(Long personelId);
	public void deletePersonel(Long personelId);
	public List<Personel> getAllPersonel();
	
	public Long addType(PersonelType personelType);
	public PersonelType editType(PersonelType personelType);
	public PersonelType getType(Long personelTypeId);
	public void deleteType(Long personelTypeId);
	public List<PersonelType> getAllType();
	
}
