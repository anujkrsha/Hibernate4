package com.dev.hibernate.main;
import com.dev.hibernate.model.Person;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dev.hibernate.util.HibernateUtil;

public class HQLExamples {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		
		Transaction tx = session.beginTransaction();
		
		//HQL example - Get All Employees
		//Query query = session.createQuery("from Person");
		List<Person> personList = session.createQuery("from Person").list();
		for(Person p : personList) {
			System.out.println("List of Person :" +p.getId()+","+p.getAddress().getCity());
		}
		
		//HQL example - Get Employee with id
		
		/*Query query = session.createQuery("from Person where id =:id");
		query.setLong("id", 5);
		Person p = (Person)query.uniqueResult();
		System.out.println("Person details : "+p.getId()+","+p.getAddress().getCity());*/
		
		//HQL pagination example
		
		/*Query query = session.createQuery("from Person");
		 query.setFirstResult(0);
		 query.setFetchSize(2);
		 List<Person> pList = query.list();
		 for(Person p1 : pList) {
			 System.out.println("Pagination Person Details : "+p1.getId()+","+p1.getAddress().getCity());
		 }*/
		
		//HQL Update Employee
		
		/*Query query = session.createQuery("update Person set name =:name where id =:id");
		query.setParameter("name", "Hellena");
		query.setLong("id", 5);
		int result = query.executeUpdate();
		System.out.println("update employee : "+result);
		*/
		
		//HQL Delete Employee, we need to take care of foreign key constraints too
		
		/*Query query = session.createQuery("delete from Address where id =:id");
		query.setLong("id", 1);
		int result = query.executeUpdate();
		System.out.println("Address delete : "+result);
		
		Query query1 = session.createQuery("delete from Person where id =:id");
		query1.setLong("id", 1);
		int result1 = query1.executeUpdate();
		System.out.println("Address delete : "+result1);
		*/
		
		//HQL Aggregate function examples
		
	/*	Query query = session.createQuery("select sum(salary) from Person");
		double sal = (Double)query.uniqueResult();
		System.out.println("sum of all salary :"+sal);*/
		
		//HQL join examples
		/*Query query = session.createQuery("select p.name, a.city from Person p INNER JOIN p.address a");
		List<Object[]> list = query.list();
		for(Object[] arr : list){
			System.out.println(Arrays.toString(arr));
		}*/
		
		//HQL group by and like example
		/*
		Query query = session.createQuery("select p.name, sum(p.salary), count(p) from Person p where p.name like '%son%' group by p.name");
		List<Object[]> list = query.list();
		for(Object[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}*/
		
		//HQL order by example
		//Query query = session.createQuery("from Person e order by e.id desc");
		/*List<Person> pList = session.createQuery("from Person e order by e.id desc").list();
		for(Person emp3 : pList){
			System.out.println("ID Desc Order Employee::"+emp3.getId()+","+emp3.getAddress().getCity());
		}*/
		
		
		tx.commit();
		//tx.rollback();
		sessionFactory.close();
		
	}

}
