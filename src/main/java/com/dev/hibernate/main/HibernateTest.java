package com.dev.hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import com.dev.hibernate.model.Employee;
import com.dev.hibernate.util.HibernateUtil;

public class HibernateTest {
	public static void main(String[] args) {
		/*Employee emp = new Employee();
		emp.setName("kelly");
		emp.setRole("tester");
		emp.setInsertTime(new Date());*/
		
		//get session
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start Transaction
		session.beginTransaction();
		//save model object
		//session.save(emp);
		
		
		//Get Example
		try{
		Employee emp = (Employee) session.get(Employee.class, new Integer(200));
		System.out.println("Employee get called");
		//if(emp != null){
		System.out.println("Employee GET ID= "+emp.getId());
		System.out.println("Employee Get Details:: "+emp+"\n");
		//}
		}catch(Exception e){
			e.printStackTrace();
		}

		//load Example
		try{
		Employee emp1 = (Employee) session.load(Employee.class, new Integer(100));
		System.out.println("Employee load called");
		System.out.println("Employee LOAD ID= "+emp1.getId());
		System.out.println("Employee load Details:: "+emp1+"\n");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//commit transaction
		session.getTransaction().commit();
		
		//System.out.println("Employee Id : "+emp.getId());
		//terminate session factory, otherwise program won't end
		
		HibernateUtil.getSessionFactory().close();
		
		
	}

}
