package spring.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import spring.service.pojo.PersonelType;

@Repository
public class PersonelTypeServiceDAOImpl extends HibernateDaoSupport implements PersonelTypeServiceDAO {

	@Autowired
	public void setTemplate(@Qualifier("hibernateTemplateForPersonel") HibernateTemplate hibernateTemplate){
		
		super.setHibernateTemplate(hibernateTemplate);
	}
	
	
	
	
	@Override
	public Long addType(PersonelType personelType) {
		return (Long) getSessionFactory().getCurrentSession().save(personelType);

	}

	@Override
	public PersonelType editType(PersonelType personelType) {
		PersonelType updatedType = getType(personelType.getType_id());
		getSessionFactory().getCurrentSession().update(personelType);
		return updatedType;

	}

	@Override
	public PersonelType getType(Long personelTypeId) {
		
		return (PersonelType)getSessionFactory().getCurrentSession().get(PersonelType.class, personelTypeId);
	}

	@Override
	public void deleteType(Long personelTypeId) {
		getSessionFactory().getCurrentSession().delete(getType(personelTypeId));

	}

	@Override
	public List<PersonelType> getAllType() {
		
		return getSessionFactory().getCurrentSession().createQuery("FROM PersonelType").list();
	}

}
