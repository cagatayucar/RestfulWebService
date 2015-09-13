package spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.service.dao.PersonelServiceDAO;
import spring.service.dao.PersonelTypeServiceDAO;
import spring.service.pojo.Personel;
import spring.service.pojo.PersonelType;

@Service("personelService")
@Transactional("transactionManagerForPersonel")
public class PersonelServiceImpl implements PersonelService {

	@Autowired
	public PersonelServiceDAO personelServiceDAO;
	@Autowired
	public PersonelTypeServiceDAO personelTypeServiceDAO;
	
	@Override
	public void addPersonel(Personel personel){
		personelServiceDAO.addPersonel(personel);
		
	}
	@Override
	public void editPersonel(Personel personel){
		personelServiceDAO.editPersonel(personel);
	}
	
	@Override
	public Personel getPersonel(Long personelId){
		
		return personelServiceDAO.getPersonel(personelId);
	}
	
	@Override
	public void deletePersonel(Long personelId){
		
		personelServiceDAO.deletePersonel(personelId);
		
	}
	
	@Override
	public List<Personel> getAllPersonel(){
		
		return personelServiceDAO.getAllPersonel();
	}
	
	
	//Personel Type 
	
	public Long addType(PersonelType personelType){
		
		return personelTypeServiceDAO.addType(personelType);
	}
	
	public PersonelType editType(PersonelType personelType){
		return personelTypeServiceDAO.editType(personelType);
	}
	
	public PersonelType getType(Long personelTypeId){
		
		return personelTypeServiceDAO.getType(personelTypeId);
	}
	
	public void deleteType(Long personelTypeId){
		
		personelTypeServiceDAO.deleteType(personelTypeId);
	}
	
	public List<PersonelType> getAllType(){
		
		return personelTypeServiceDAO.getAllType();
	}
	
	
	
	
	
	
	

}
