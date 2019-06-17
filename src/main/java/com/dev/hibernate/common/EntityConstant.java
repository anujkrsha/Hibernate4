package com.dev.hibernate.common;

public class EntityConstant {
	    public  static final String GET_DEPARTMENT_BY_ID_QUERY = "from Department d where d.id = :id";
	    public static final String GET_DEPARTMENT_BY_ID = "GET_DEPARTMENT_BY_ID";
	     
	    public static final String UPDATE_DEPARTMENT_BY_ID_QUERY = "UPDATE Department d SET d.name=:name where d.id = :id";
	    public static final String UPDATE_DEPARTMENT_BY_ID = "UPDATE_DEPARTMENT_BY_ID";
	    
	    public static final String GET_DEPARTMENT = "GET_DEPARTMENT";
	    public static final String GET_DEPARTMENT_QUERY = "select * from DEPARTMENT";

}
