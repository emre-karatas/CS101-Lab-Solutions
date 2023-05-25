/**
 * @(#)EmployeeApp.java
 *
 *
 * @author Lori Russell Dag 
 * @version 1.00 2020/3/29
 */

public class EmployeeApp {
   
   
   public static void main(String[] args) {
      final String LINE = "_____________________";
      boolean sameDept;
      
      // create a Project
      Project p1 = new Project( "SunMarkets POS Implementation", 1315, 320, 22 );
      
      // Create 3 Employees who have been assigned to the project p1
      Employee emp1 = new Employee( "Karakus, Zana", 215.0, "Information Technology", "IT", p1 );
      Employee emp2 = new Employee( "Rocca, Denis", 175.0, "Human Resources", "HR", p1 );
      Employee emp3 = new Employee( "Anders, Jamie", 275.0, "Human Resources", "HR", p1 );      
      
      // Construct a new employee who is a copy of emp1
      Employee emp4 = new Employee( emp1 );
      
      // Display all 4 employees
      System.out.println( LINE );
      System.out.println("Employees: ");
      System.out.println( emp1 + "\n" + emp2 + "\n" + emp3 + "\n" + emp4 );
      System.out.println( "--------- end employee list ----------");      
      
      sameDept = false;
      int count = 0;
      
      // Compare the departments and display if 2 employees have same department
      if ( emp1.getDepartment().equals( emp2.getDepartment() ) )
      {
         sameDept = true;
         count++;
         System.out.println( LINE );
         System.out.println( "Employees with Matching Departments (" + count + ")" );
         System.out.println( emp1 + " " + emp2 );
      }
      if ( emp1.getDepartment().equals(emp3.getDepartment() ) )
      {
         sameDept = true;
         count++;
         System.out.println( LINE );
         System.out.println( "Employees with Matching Departments (" + count + ")" );
         System.out.println( emp1 + " " + emp2 );
      }
      if ( emp1.getDepartment().equals( emp4.getDepartment() ) )
      {
         sameDept = true;
         count++;
         System.out.println( LINE );
         System.out.println( "Employees with Matching Departments (" + count + ")" );
         System.out.println( emp1 + " " + emp4 );
      }
      if ( emp2.getDepartment().equals( emp3.getDepartment() ) )
      {
         sameDept = true;
         count++;
         System.out.println( LINE );
         System.out.println( "Employees with Matching Departments (" + count + ")" );
         System.out.println( emp2 + " " + emp3 );
      }
      if ( emp2.getDepartment().equals( emp4.getDepartment() ) )
      {
         sameDept = true;
         count++;
         System.out.println( LINE );
         System.out.println( "Employees with Matching Departments (" + count + ")" );
         System.out.println( emp2 + " " + emp4 );
      }
      if ( emp3.getDepartment().equals( emp4.getDepartment() ) ) 
      {
         sameDept = true; 
         count++;
         System.out.println( LINE );
         System.out.println( "Employees with Matching Departments (" + count + ")" );
         System.out.println( emp3 + " " + emp4 );
      }
      if ( sameDept == false )
      {
         System.out.println( " No employees have the same department " );
      } 
   }
}
