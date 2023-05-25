/**
 * @(#)Employee.java
 *
 *
 * @author Lori Russell Dag 
 * @version 1.00 2018/4/2
 */

public class Employee 
{
   
   private final int WORKING_DAYS = 261;
   
   // properties
   private String employeeName;
   private double dailyRate;
   private Department department;
   private Project project;
   
   /**
    * Creates a new instance of <code>Employee</code>.
    */
   public Employee( String employeeName, double dailyRate, String deptName, 
                   String deptCode, Project project ) 
   {      
      this.employeeName = employeeName;
      this.dailyRate = dailyRate;
      this.department = new Department( deptName, deptCode );
      this.project = project;
      
   }
   
   public Employee( Employee emp )
   {
      this.employeeName = emp.getEmployeeName();
      this.dailyRate = emp.getDailyRate();
      this.department = new Department( emp.getDepartment().getDeptName(), 
                                       emp.getDepartment().getDeptCode() );
      this.project = emp.getProject();
   }
   
   public void setEmployeeName( String employeeName )
   {
      this.employeeName = employeeName;
   }
   
   public String getEmployeeName()
   {
      return employeeName;
   }
   
   public void setDailyRate( double dailyRate )
   {
      this.dailyRate = dailyRate;
   }
   
   public double getDailyRate()
   {
      return dailyRate;
   }
   
   public void setDepartment( String deptName, String deptCode )
   {
      department = new Department( deptName, deptCode );
   }
   
   public Department getDepartment()
   {
      return department;
   }
   
   public void setProject( Project project )
   {
      this.project = project;
   } 
   
   public Project getProject()
   {
      return project;
   }
   
   public double calculateYearlySalary()
   {
      return WORKING_DAYS * dailyRate;
   }
   
   public String toString( )
   {
      String str = "\nEmployee Name: " + employeeName;
      str = str +  " Yearly Salary: " + calculateYearlySalary();
      str = str + department;
      str = str + project;
      return str;
   }
   
}
