package com.dev.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dev.hibernate.model.Address;
import com.dev.hibernate.model.Department;
import com.dev.hibernate.model.Person;
import com.dev.hibernate.util.HibernateUtil;

public class HibernateSaveExample {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//save example without transaction
		//Session session = sessionFactory.openSession();
		
/*		Person person = getTestPerson();
		long id =(Long)session.save(person);
		System.out.println("1.Person save called without Transaction id :  "+id);
		session.flush();//Address will not saved
		System.out.println("*************************************");*/
		
		//save example - with transaction
		//Transaction tx1 = session.beginTransaction();
		Session session1 = sessionFactory.openSession();
		Transaction tx1 = session1.beginTransaction();
		//Department
		Department dept = new Department(1,"Sell");
		session1.save(dept);
		
		Person p1 = getTestPerson();
		long id1 = (Long)session1.save(p1);
		System.out.println("2. Employee save called with transaction, id="+id1);
		System.out.println("3. Before committing save transaction");
		tx1.commit();
		System.out.println("4. After committing save transaction");
		System.out.println("*****");
		
		sessionFactory.close();
	}

	public static Person getTestPerson() {

		Person per = new Person();
		Address add = new Address();

		per.setName("Jenyy");
		per.setSalary(5000);

		add.setAddressLine1("Address4");
		add.setZipCode("560034");
		add.setCity("Franch");

		per.setAddress(add);
		add.setPerson(per);

		return per;
	}

}
