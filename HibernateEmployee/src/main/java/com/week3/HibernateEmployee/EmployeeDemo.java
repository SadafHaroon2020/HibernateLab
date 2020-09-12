package com.week3.HibernateEmployee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeDemo {

	private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Employee.class).buildSessionFactory();

	public static void main(String[] args) {

		EmployeeDemo employeeDemo = new EmployeeDemo();

		Employee newEmployee = new Employee("John", "Snow", "JohnSnow_Company");
		Long newId = employeeDemo.create(newEmployee);
		System.out.println(String.format("************** Newly created Id for Employee: %s", newId));

		Employee selectedEmployee = employeeDemo.select(newId);
		System.out.println(String.format("************** Fetched Employee: %s", selectedEmployee));

		selectedEmployee.setCompany("Hibernate Company");
		Long updatedId = employeeDemo.update(selectedEmployee);
		System.out.println(String.format("************** Id for updated Employee: %s", updatedId));

		Employee updatedEmployee = employeeDemo.select(newId);
		System.out.println(String.format("************** Updated Employee: %s", updatedEmployee));

		employeeDemo.delete(updatedId);
		System.out.println(String.format("************** Deleted Id for Employee: %s", updatedId));
		
		Employee deletedEmployee = employeeDemo.select(updatedId);
		System.out.println(String.format("************** Deleted Employee to confirm: %s", deletedEmployee));

	}

	public void delete(Long id) {
		Session session = factory.getCurrentSession();

		// start transaction
		session.beginTransaction();
		Employee employee = new Employee();
		employee.setId(id);
		session.delete(employee);
		session.getTransaction().commit();

	}

	public Long update(Employee selectedEmployee) {
		Session session = factory.getCurrentSession();

		// start transaction
		session.beginTransaction();
		session.update(selectedEmployee);
		session.getTransaction().commit();

		return selectedEmployee.getId();

	}

	public Employee select(Long newId) {
		Session session = factory.getCurrentSession();

		// start transaction
		session.beginTransaction();
		Employee employeeSelect = session.get(Employee.class, newId);
		session.getTransaction().commit();
		return employeeSelect;

	}

	public Long create(Employee newEmployee) {
		// create session
		Session session = factory.getCurrentSession();

		// start transaction
		session.beginTransaction();
		session.save(newEmployee);
		session.getTransaction().commit();

		return newEmployee.getId();
	}

}