package com.pavan.repoannotation.jpaDao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.pavan.repoannotation.entity.Student;

@Repository
public class JPAImpl {
	
	@Autowired
	EntityManager  entityManager;
	
	@Value(value = "${KeyInApplicationProperties}")
	private String key;
	
	@Value("this value is assigned to the variable declared below")
	private String key2;
	

	@Value("${datetoprocess: default value}")
	private String key3;

	@Value("${my.list.values}")
	private List<String> listValues;
	
	@Value("#{${dbValues}}")
	private Map<String,String> dbValues;
	
	Student student = new Student("bhavani","india");
	
	@Transactional
	public void insertDataToDBUsingSpringJPA() {
		entityManager.persist(student);
		System.out.println("sql query executed using spring jpa ....");
		
		System.out.println("=========@Value annotation=========");
		System.out.println("reading a value from application.properties ..... value of key is "+key);
		System.out.println("reading a value from application.properties ..... value of key2 is "+key2);
		System.out.println("reading a value from application.properties ..... value of key3 is "+key3);
		System.out.println("reading a value from application.properties ..... value of listValues is "+listValues);
		System.out.println("reading a value from application.properties ..... value of listValues[0] is "+listValues.get(0));
		System.out.println("reading a value from application.properties ..... value of dbValues is "+dbValues);
		System.out.println("reading a value from application.properties ..... value of dbValues is "+dbValues.get("password"));


	}

}
