package com.gl.HibernateAssignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import config.HibernateConfig;
import entity.Address;
import entity.Student;


/**
 * Hello world!
 *
 */
public class App 
{private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
       
		System.out.println("config loaded");
		Session session= factory.openSession();
		
		//Create Student Object
		Student student= new Student();
		student.setName("Ram");
		student.setDept("Math");
		student.setAge(20);
		
		Student s1= new Student();
		s1.setName("Shyam");
		s1.setDept("Physics");
		s1.setAge(18);
		
		//Create Address Object
		Address address= new Address();
		address.setState("West Bengal");
		address.setCity("Kolkata");
		address.setStreet("17 Park Street");
		address.setPinCode("700051");
		
		Address a1= new Address();
		a1.setState("West Bengal");
		a1.setCity("Durgapur");
		a1.setStreet("17 Lalmohan Road");
		a1.setPinCode("700119");
		
		//Setting Address of student
		student.setAddress(address);
		
		s1.setAddress(a1);
		
		//Insert into the Student along with the required address
		Transaction tx= session.beginTransaction();
		//session.save(student);
		
		//Saving the 2nd student object
		//session.save(s1);
		
		
		//Fetching the student details along with address
		Student student2= session.get(Student.class, 2);
		System.out.println(student2.toString());
		System.out.println(student2.getAddress());

		
		
		//Removing a Student record from the database with the cascaded effect on Address table.
		session.remove(student2);
		tx.commit();
		session.close();
		
		
		
    }
   
}
