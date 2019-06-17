package com.dev.hibernate.main;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.dev.hibernate.model.Person;
import com.dev.hibernate.util.HibernateUtil;

public class HibernateCriteriaExamples {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		List<Person> pList;

		// Get All Employees

		// Criteria criteria = session.createCriteria(Person.class);
		pList = session.createCriteria(Person.class).list();
		for (Person p : pList) {
			System.out.println("Person details : " + p.getName() + "," + p.getAddress().getCity());
		}

		// Get with ID, creating new Criteria to remove all the settings
		// Criteria criteria =
		// session.createCriteria(Person.class).add(Restrictions.eq("id", new Long(3)));
		Person p = (Person) session.createCriteria(Person.class).add(Restrictions.eq("id", new Long(3))).uniqueResult();
		System.out.println("Person details with given Id : " + p.getName() + "," + p.getAddress().getCity());

		// Pagination Example
		pList = session.createCriteria(Person.class).addOrder(Order.desc("id")).setFirstResult(0).setMaxResults(2)
				.list();
		for (Person p1 : pList) {
			System.out.println("Pagination of Person details : " + p1.getName() + "," + p1.getAddress().getCity());
		}

		//// Like example
		pList = session.createCriteria(Person.class).add(Restrictions.like("name", "%son%")).list();
		for (Person p2 : pList) {
			System.out.println("Person details with Like Operator : " + p2.getName() + "," + p2.getAddress().getCity());
		}

		// Projections example
		long count = (Long) session.createCriteria(Person.class).setProjection(Projections.rowCount())
				.add(Restrictions.like("name", "%son%")).uniqueResult();
		System.out.println("Number of employees with 'i' in name=" + count);

		// using Projections for sum, min, max aggregation functions
		double sumSalary = (Double) session.createCriteria(Person.class).setProjection(Projections.sum("salary"))
				.uniqueResult();
		System.out.println("Sum of Salaries=" + sumSalary);

		// Join example for selecting few columns
		Criteria criteria = session.createCriteria(Person.class, "person");
		criteria.setFetchMode("person.address", FetchMode.JOIN);
		criteria.createAlias("person.address", "address");// inner join by default
		ProjectionList columns = Projections.projectionList().add(Projections.property("name"))
				.add(Projections.property("address.city"));
		criteria.setProjection(columns);

		List<Object[]> list = criteria.list();
		for(Object[] arr : list){
			System.out.println(Arrays.toString(arr));
		}
		
				tx.commit();
				// closing hibernate resources
				sessionFactory.close();

	}

}
