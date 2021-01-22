package com.nagarro.fresherTraining.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nagarro.fresherTraining.dao.EmployeeDao;
import com.nagarro.fresherTraining.model.Employee;
import com.nagarro.fresherTraining.utils.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getListOfUser() {
		try {

			SessionFactory sessFact = HibernateUtil.getSessionFactory();
			Session session = sessFact.getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery("from Employee");
			@SuppressWarnings("unchecked")
			List<Employee> empList = query.list();
			return empList;
		} catch (Exception e) {

		}
		return null;

	}

	@Override
	public void updateEmployee(int id, Employee emp) {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		try {

			org.hibernate.Transaction transaction = session.beginTransaction();
			try {
				session.update(emp);
				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}

		}
	}

	@Override
	public void saveEmployee(Employee emp) {
		try {
			SessionFactory sessFact = HibernateUtil.getSessionFactory();
			Session session = sessFact.getCurrentSession();
			org.hibernate.Transaction transaction = session.beginTransaction();
			session.save(emp);
			transaction.commit();
		} catch (Exception e) {

		}

	}

}
