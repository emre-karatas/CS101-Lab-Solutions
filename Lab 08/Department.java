/**
 * @(#)Department.java
 * @author Lori Russell Dag 
 */

public class Department {
   
   private String deptName;
   private String deptCode; 
   
   /**
    * Creates a new instance of <code>Department</code>.
    */
   public Department( String deptName, String deptCode ) 
   {
      this.deptName = deptName;
      this.deptCode = deptCode;
   }
   
   public void setDeptName( String deptName )
   {
      this.deptName = deptName;
   }
   
   public String getDeptName(){
      return deptName;
   }
   
   public void setDeptCode( String deptCode ){
      this.deptCode = deptCode;
   }
   
   public String getDeptCode()
   {
      return deptCode;
   }
   
   public String toString()
   {
      return "\nDeptName: "  +deptName + " Dept Code: " + deptCode;
   }
   
   public boolean equals( Object obj )
   {
      if ( obj instanceof Department )
      {
         Department objDept = (Department) obj;
         if ( this.getDeptName().equals( objDept.getDeptName() ) &&
               this.getDeptCode().equals( objDept.getDeptCode() ) )
         {
            return true; 
         }
      }
      return false;
   }
   
}
