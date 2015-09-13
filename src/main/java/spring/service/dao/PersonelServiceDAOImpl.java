package spring.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import spring.service.pojo.Personel;

@Repository
public class PersonelServiceDAOImpl extends HibernateDaoSupport implements PersonelServiceDAO {
	
	@Autowired
	public void setTemplate(@Qualifier("hibernateTemplateForPersonel") HibernateTemplate hibernateTemplate){
		
		super.setHibernateTemplate(hibernateTemplate);
	}

	


	@Override
	public void addPersonel(Personel personel){
		
		getSessionFactory().getCurrentSession().save(personel);
	}
	
	@Override
	public void editPersonel(Personel personel){
		
		getSessionFactory().getCurrentSession().update(personel);
	}
	
	@Override
	public Personel getPersonel(Long personelId){
		
		return (Personel)getSessionFactory().getCurrentSession().get(Personel.class, personelId);
	}
	
	@Override
	public void deletePersonel(Long personelId){
		
		getSessionFactory().getCurrentSession().delete(getPersonel(personelId));
	}
	
	@Override
	public List<Personel> getAllPersonel(){
		
		return getSessionFactory().getCurrentSession().createQuery("FROM PERSONEL").list();
	}
}
