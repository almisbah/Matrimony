package com.mycompany.entity;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository("nounDAO")
public class UserDAOImpl  {
//http://www.baeldung.com/hibernate-4-spring
	@Autowired
	
	public SessionFactory sessionFactory;


	public void persistEmployee(Users obj) throws Exception{
		sessionFactory.getCurrentSession().persist(obj);
		
	}


	public Users findEmployeeById(String id) {
		return (Users) sessionFactory.getCurrentSession().get(Users.class, id);
	}

	public List<String> findEmployeeByMeaning(String meaning) throws Exception {
		String qry = "select name from tblname where ?=?";
		Query q=  sessionFactory.getCurrentSession().createSQLQuery(qry).setParameter("Meaning", meaning);
		return q.list();
	}

	public void updateEmployee(Users employee) {
		sessionFactory.getCurrentSession().update(employee);

	}

	public void deleteEmployee(Users employee) {
		sessionFactory.getCurrentSession().delete(employee);
	}

}