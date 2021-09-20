package com.pavan.repoannotation.jpaDao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.pavan.repoannotation.entity.Student;

@Repository
public class JPAImpl {
	
	@Autowired
	EntityManager  entityManager;
	
	Student student = new Student("bhavani","india");
	
	@Transactional
	public void insertDataToDBUsingSpringJPA() {
		entityManager.persist(student);
		System.out.println("sql query executed using spring jpa ....");
	}

}
