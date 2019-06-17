package com.dev.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dev.hibernate.common.EntityConstant;
import com.dev.hibernate.model.Department;
import com.dev.hibernate.util.HibernateUtil;

public class HibernateNamedQueryExample {
	public static void main(String[] args) {
		//Open the hibernate session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try {
			//Update record using named query
			Query query = session.getNamedQuery(EntityConstant.UPDATE_DEPARTMENT_BY_ID)
					.setInteger("id", 2)
					.setString("name", "IT");
			 query.executeUpdate();
			 
			 query = session.getNamedQuery(EntityConstant.GET_DEPARTMENT_BY_ID)
					 .setInteger("id", 2);
			 Department dept = (Department) query.uniqueResult(); 
			 System.out.println("depatment details : "+dept.getName());
			 
			 @SuppressWarnings("unchecked")
			List<Object[]> deptObjArr = session.getNamedQuery(EntityConstant.GET_DEPARTMENT).list();
			 for(Object[] row : deptObjArr) {
				 for(Object obj : row){
						System.out.print(obj + "::");
					}
					System.out.println();
			 }
			
		}finally {
			session.getTransaction().commit();
			HibernateUtil.getSessionFactory().close();
			
		}
		
	}

}
