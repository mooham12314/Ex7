/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author mooham12314
 */
public class EmployeeTable {
        
    public static void insertEmployee(AbstractEmployee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void updateEmployee(AbstractEmployee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        AbstractEmployee fromDb = em.find(AbstractEmployee.class, emp.getId());
        fromDb.setName(emp.getName());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static AbstractEmployee findEmployeeById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        AbstractEmployee emp = em.find(AbstractEmployee.class, id);
        em.close();
        return emp;
    }
    public static List<AbstractEmployee> findAllEmployee() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        List<AbstractEmployee> empList = (List<AbstractEmployee>) em.createNamedQuery("Employee.findAll").getResultList();
        em.close();
        return empList;
    }
    public static List<AbstractEmployee> findEmployeeByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Employee.findByName");
        query.setParameter("name", name);
        List<AbstractEmployee> empList = (List<AbstractEmployee>) query.getResultList();
        em.close();
        return empList;
    }
    public static void removeEmployee(AbstractEmployee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        AbstractEmployee fromDb = em.find(AbstractEmployee.class, emp.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
                
    }
}
