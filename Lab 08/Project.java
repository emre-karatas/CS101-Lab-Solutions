import java.util.Calendar;
public class Project {
	
	private String projectId;
	private String projectName;
	private char projectType;
	private double personHours;
	private double ratePerHour;
	private double projectWeeks;
	
	private static final double TAX = 0.13;
	private static final int EMP_HOURS_WEEK = 45;
	private static final int OVERHEAD = 50000;
	private static int projectCounter = 5000;
	
	
	public Project(String projectName, double personHours, double ratePerHour, double projectWeeks) {
		projectCounter++;
		this.projectName = projectName;
		setProjectId();
		setPersonHours(personHours);
		setRatePerHour(ratePerHour);
		setProjectWeeks(projectWeeks);
		setProjectType();
	}
	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	private void setProjectId() {
		int year;
		year = Calendar.getInstance().get(Calendar.YEAR);
		this.projectId = year + "-" + projectCounter;
	}
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the projectType
	 */
	public char getProjectType() {
		return projectType;
	}
	/**
	 * @param projectType the projectType to set
	 */
	public void setProjectType() {
		double cost;
		cost = calculateProjectCost();
		if( cost > 1000000 ){
			projectType = 'm';
		}
		else if ( cost > 500000 ){
			projectType = 'l';
		}
		else if ( cost > 0 ){
			projectType = 's';
		}
		else {
			projectType = 'i';
		}
	}
	/**
	 * @return the personHours
	 */
	public double getPersonHours() {
		return personHours;
	}
	/**
	 * @param personHours the personHours to set
	 */
	public void setPersonHours(double personHours) {
		if ( personHours > 0 ){
			this.personHours = personHours;
		}
		else {
			this.personHours = 0;
		}
	}
	/**
	 * @return the ratePerHour
	 */
	public double getRatePerHour() {
		return ratePerHour;
	}
	/**
	 * @param ratePerHour the ratePerHour to set
	 */
	public void setRatePerHour(double ratePerHour) {
		if ( ratePerHour > 0 ){
			this.ratePerHour = ratePerHour;
		}
	}
	/**
	 * @return the projectWeeks
	 */
	public double getProjectWeeks() {
		return projectWeeks;
	}
	/**
	 * @param projectWeeks the projectWeeks to set
	 */
	public void setProjectWeeks(double projectWeeks) {
		if ( projectWeeks > 0 ){
			this.projectWeeks = projectWeeks;
		}
	}
	public void deactivateProject(){
		personHours = 0;
		ratePerHour = 0;
		projectType = 'i';
	}
	public void activateProject(double personHours, double ratePerHour){
		setPersonHours( personHours );
		setRatePerHour( ratePerHour );
		setProjectType();
	}
	public double calculateProjectCost(){
		double cost;
		cost = personHours * ratePerHour;
		if ( cost >= 20000 ){
			cost = ( cost + OVERHEAD );
			cost = cost + cost * TAX; 
		}
		return cost;
	}
	public double calculatePersonResources(){
		double totalPersonPerWeek,
			   personResources;
		
		totalPersonPerWeek = personHours / projectWeeks;
		personResources = totalPersonPerWeek / EMP_HOURS_WEEK;
		
		return personResources;
	}
	public String toString(){
    	String output = "";
    	
    	
    	if( getProjectType() == 'i' ){
    		output = output + "\n-------INACTIVE PROJECT------\n";
    		output = output + "Project Name: "+projectName+"\n";
    		output = output + "Project ID: "+projectId+"\n";
    	}
    	else {
    		output =  "Project Name: "+projectName+"\n";
    		output = output + "Project ID: "+projectId+"\n";
    		output = output +"Project Type: "+projectType+"\n";
    		output = output + "Team Size: "+ Math.round(calculatePersonResources())+"\n";
    		output = output + "Estimated Project Cost: "+calculateProjectCost()+"\n";
    	}
    	return output; 
    }	
}
