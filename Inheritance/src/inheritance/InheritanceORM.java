/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

/**
 *
 * @author mooham12314
 */
public class InheritanceORM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FulltimeEmployee emp1 = new FulltimeEmployee();
       ParttimeEmployee emp2 = new ParttimeEmployee();
       emp1.setName("Jo");
       emp1.setSalary(5000);
       emp2.setName("Jane");
       emp2.setHoursWork(4);
       persist(emp1);
       persist(emp2);
       int option =0;
       Scanner input =new Scanner(System.in);
       AbstractEmployee tempAE2 = new AbstractEmployee();
       
       while(option <5)
       {
           
           
           switch(option){
            case 1:
               List<AbstractEmployee> empList = EmployeeTable.findAllEmployee();
               printAllEmployee(empList);
               break;
            case 2:
               System.out.println("Enter ID :");
               int temp2 = input.nextInt();
               System.out.println("Enter Name :");
               String tempt = input.nextLine();
               tempAE = new AbstractEmployee(temp2, tempt);
               EmployeeTable.insertEmployee(tempAE1);
               break;
            case 3:
               System.out.println("Enter amount to be credited");
               System.out.println("Enter ID :");
               int temp3 = input.nextInt();
               System.out.println("Enter Name :");
               String tempr = input.nextLine();
               tempAE = new AbstractEmployee(temp3, tempr);
               updateEmployee(tempAE)
               break;
            case 4:
               System.out.println("Enter ID :");
               int temp4 = input.nextInt();
               tempAE = EmployeeTable.findEmployeeById(temp4);
               EmployeeTable.removeEmployee(emp);
               break;
                          }
           System.out.println("Select Option");
           System.out.println("1.View Table");
           System.out.println("2.Insert");
           System.out.println("3.Edit");
           System.out.println("4.Delete");
           System.out.println("5.Exit");
           option=input.nextInt();
        }
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritancePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void printAllEmp(List<AbstractEmployee> employeeList) {
        for(AbstractEmployee st : employeeList) {
           System.out.print(st.getId() + " ");
           System.out.println(st.getName() + " ");
       }
    }
}
