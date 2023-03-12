import java.util.Scanner;

/**
 * Lab01Q2
 */
public class Lab01Q2 {

    public static void main(String[] args) {
        final String separator = "*********************";
        final int CALORIES_IN_FAT = 9;
        final int CALORIES_IN_PROTEIN = 4;
        final int CALORIES_IN_CARBS = 4;

        final int CALORIES_PER_KILO = 7700;
        final int RECOMMENDED_CALORIES = 2000;

        final double PERCENT_CARBS = 0.50;
        final double PERCENT_FAT = 0.30;
        final double PERCENT_PROTEIN = 0.20;

        int daysToLose;
        int kilosToLose;
        int caloriesPerDay;
        int caloriesToLose;
        int calorieDeficit;

        double dailyCarbGrams;
        double dailyFatGrams;
        double dailyProteinGrams;

        double percentDailyCarbs;
        double percentDailyFats;
        double percentDailyProtein;

        Scanner input = new Scanner( System.in );
        System.out.print( "Enter kilograms to lose: " );
        kilosToLose = input.nextInt();

        System.out.printf( "Enter days to lose %d kilograms: ",kilosToLose );
        daysToLose = input.nextInt();

        input.close();

        caloriesToLose = kilosToLose * CALORIES_PER_KILO;
        calorieDeficit = caloriesToLose / daysToLose;

        
        
        caloriesPerDay = RECOMMENDED_CALORIES - calorieDeficit;

        percentDailyCarbs = caloriesPerDay * PERCENT_CARBS;
        percentDailyFats = caloriesPerDay * PERCENT_FAT;
        percentDailyProtein = caloriesPerDay * PERCENT_PROTEIN;

        dailyCarbGrams = percentDailyCarbs / CALORIES_IN_CARBS;
        dailyFatGrams = percentDailyFats / CALORIES_IN_FAT;
        dailyProteinGrams = percentDailyProtein / CALORIES_IN_PROTEIN;

        System.out.printf("%s%s%s%s%s%n",separator,separator,separator,separator,separator);
        System.out.printf( "To lose %d kilograms in %d days you will need a daily deficit of %d calories\n", kilosToLose,daysToLose,calorieDeficit);
        System.out.printf("%s%s%s%s%s%n",separator,separator,separator,separator,separator);
        System.out.printf("RECOMMENDED DAILY CALORIES TO LOSE %d KILOS IN %d DAYS: %d %n",kilosToLose,daysToLose,caloriesPerDay);
        System.out.printf("%s%s%s%s%s%n",separator,separator,separator,separator,separator);
        System.out.printf("%-20s%20s%20s%25s%20s %n", "MACRO","RECOMMENDED PERCENT","CALORIES PER GRAM","RECOMMENDED CALORIES","GRAMS");

        System.out.printf("%-20s%19.0f%%%20d%25.0f%20.1f %n","CARBOHYDRATE",PERCENT_CARBS*100,CALORIES_IN_CARBS,percentDailyCarbs,dailyCarbGrams);
        System.out.printf("%-20s%19.0f%%%20d%25.0f%20.1f %n","FAT",PERCENT_FAT*100,CALORIES_IN_FAT,percentDailyFats,dailyFatGrams);
        System.out.printf("%-20s%19.0f%%%20d%25.0f%20.1f %n","PROTEIN",PERCENT_PROTEIN*100,CALORIES_IN_PROTEIN,percentDailyProtein,dailyProteinGrams);

        System.out.printf("%s%s%s%s%s%n",separator,separator,separator,separator,separator);
    }
}