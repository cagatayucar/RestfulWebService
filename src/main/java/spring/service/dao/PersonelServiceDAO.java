package spring.service.dao;

import java.util.List;

import spring.service.pojo.Personel;

public interface PersonelServiceDAO {
	
	public void addPersonel(Personel personel);
	public void editPersonel(Personel personel);
	public Personel getPersonel(Long personelId);
	public void deletePersonel(Long personelId);
	public List<Personel> getAllPersonel();

}
