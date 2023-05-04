import java.util.ArrayList;
import java.util.Random;

/**
 * Lab06_Q1
 */
public class Lab06_Q1 {
    public static final int RADIUS = 30;
    public static final int CAMPUS_RADIUS = 250;
    public static final int NUM_CATS = 10;

    public static double calculateDistance(String loc1,String loc2 ){
        int x1, y1, x2, y2;
        double dist;
        double xSquare;
        double ySquare;
        int ind1, ind2;
        
        //find the commas in the string locations
        ind1 = loc1.indexOf(",");
        ind2 = loc2.indexOf(",");
        
        //get the x and y coordinates of the two locations
        x1 = Integer.parseInt(loc1.substring(0,ind1));
        y1 = Integer.parseInt(loc1.substring(ind1 + 1));
        x2 = Integer.parseInt(loc2.substring(0,ind2));
        y2 = Integer.parseInt(loc2.substring(ind2 + 1));

        //square the differences
        xSquare = Math.pow( (x1-x2),2 );
        ySquare = Math.pow( (y1-y2),2 );

        //calculate distance
        dist = Math.sqrt( xSquare + ySquare );

        return dist;
    }
    public static boolean doesIntersect(String loc1, String loc2){
        double distance;
        int sumRadii;

        distance = calculateDistance(loc1, loc2);
        sumRadii = RADIUS * 2;
        return distance <= sumRadii;
    }
    public static int countIntersecting( String location, ArrayList<String> locations ){
        int intersections = 0;
        for( int i = 0; i < locations.size(); i++ ){
            if( doesIntersect(location, locations.get(i))){
                intersections++;
            }
        } 
        return intersections;
    }
    public static void displayIntersections(ArrayList<String> cats, ArrayList<String> locations,ArrayList<Integer> months){
        boolean isIntersection;
        for(int cat = 0; cat < cats.size(); cat++) {
            System.out.printf("%n%s at location %s for %d months intersects with: ", cats.get(cat), locations.get(cat), months.get(cat));
            isIntersection = false;
            for( int j = 0; j < locations.size(); j++ ){
                if ( cat != j ) {
                    if( doesIntersect(locations.get(cat), locations.get(j))){
                        isIntersection = true;
                        System.out.printf("%n\t%s, at location %s for %d months", cats.get(j), locations.get(j), months.get(j));
                    }
                }
            }
            if( !isIntersection ){
                System.out.println("NO CATS");
            }
        }
    }
    public static int findMinMonthsAtLocation( String loc, ArrayList<String> locations, ArrayList<Integer> months ){
        int minTime = Integer.MAX_VALUE;
        int minIndex = -1;

        //for all locations
        for( int i = 0; i < locations.size(); i++ ){
            //if location matches intersecting location
            if( doesIntersect( loc, locations.get(i)) ){
                //if months is less than current min
                if( months.get(i) <= minTime ){
                    //store index of current location
                    minTime = months.get(i);
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
    public static String findRandomLocation(){
        Random gen = new Random();
        int x,y;
        do {
            x = gen.nextInt(CAMPUS_RADIUS * 2 + 1);
            y = gen.nextInt(CAMPUS_RADIUS * 2 + 1);
        } while ( Math.sqrt( Math.pow(x,2) + Math.pow(y,2)) > CAMPUS_RADIUS );
        return x + "," +y;
    }
    public static void moveCats( ArrayList<String> locations,ArrayList<Integer> months){
        String randLoc;
        
        //for all locations
        for( int loc = 0; loc < locations.size(); loc++ ){
            //if the number of cats at intersecting locations is 3 or more, 
            if( countIntersecting(locations.get(loc), locations) >= 3 ) {
                    //find the cat who has been at the location for the shortest amount of time
                    int minInd = findMinMonthsAtLocation(locations.get(loc),locations, months);
                    
                    //move the cat who has been at the location for the shortest amount of time
                    //do 
                    do {
                        //get random location
                        randLoc = findRandomLocation();
                    } while( countIntersecting(randLoc, locations) != 0);
                    //while the number of intersections under 3
                    //set the cats location
                    locations.set( minInd, randLoc );
                    months.set( minInd, 0 );
            }
        }
    }
    public static void main(String[] args) {
        
        ArrayList<String> cats;
        ArrayList<String> locations;
        ArrayList<Integer> months;

        //add cats to the ArrayList of cats and locations (name and coordinates)
        cats = CatInfoGenerator.getRandomNameList(NUM_CATS);
        months = CatInfoGenerator.getRandomMonthList(cats.size());
        locations = CatInfoGenerator.getRandomLocationList(cats.size());
        
        //display the cats and intersections
        System.out.println("Before moving the cats: ");
        displayIntersections(cats, locations, months);
        
        moveCats( locations, months );
        System.out.println("\nAfter moving the cats: ");
        displayIntersections(cats, locations, months);
    }
}