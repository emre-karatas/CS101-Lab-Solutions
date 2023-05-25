/**
 * @(#)ProjectApp.java
 *
 *
 * @author 
 * @version 1.00 2021/03/04
 */

public class ProjectApp {
        
   
    public static void main(String[] args) {
    	int result;
    	
        //create 2 projects
        Project p1 = new Project( "ArcTech Business Solution", 11520, 215, 48 );
        Project p2 = new Project( "SunMarkets POS Implementation", 315, 320, 12 );
        Project p3 = new Project( "HealthTech Hospital", 0, 0, 0 );
        
        //Display the projects
        System.out.println( p1 ); 
        System.out.println( p2 );
        System.out.println( p3 ); 
    }
    
}
