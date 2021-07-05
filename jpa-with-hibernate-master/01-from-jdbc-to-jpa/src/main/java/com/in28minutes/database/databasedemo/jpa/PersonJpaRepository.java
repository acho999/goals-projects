package com.in28minutes.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.in28minutes.database.databasedemo.entity.Course;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	// connect to the database
	@PersistenceContext
	EntityManager entityManager;//here we have access to context i.e database connection

	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		//this is using  JPQL named query from Person definition
		return namedQuery.getResultList();
	}

	public Person findById(int id) {
		return entityManager.find(Person.class, id);// JPA
	}

	public Person update(Person person) {
		return entityManager.merge(person);
	}//merge updates the Person data changes

	public Person insert(Person person) {
		return entityManager.merge(person);
	}

	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}

	public List<Course> getCources(){

		Query query = entityManager.createNativeQuery("Select * from courses",Course.class);
		//that way we can create native query also can have parameters
		Query query1 = entityManager.createNativeQuery("Select * from courses where id = ?",Course.class);
		//? is place of the parameter and first is in position 1
		query1.setParameter(1,123);
		//also we can use named parameters like this
		Query query2 = entityManager.createNativeQuery("Select * from courses where id = :id",Course.class);
		query2.setParameter("id",123); //id is named parameter
		List<Course> courses = query.getResultList();
		return courses;
	}

}
