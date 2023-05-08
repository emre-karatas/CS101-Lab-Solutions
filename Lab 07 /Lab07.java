import java.util.Arrays;
import java.util.Scanner;

public class Lab07 
{
    
    private static int[] arrives = {9,5,8,7,9,7,8};    
    private static int[] departs = {12,7,11,12,10,9,10};
    private static String[] friend = {"Ela","Eren","Alona","Jen","Mark","Mel","Ender"};
    
    
    public static int[] friendsAttending(int start, int end)
    {
        int friendCount = 0;
        int ind = 0;
        int[] friendCounts = new int[end - start];
        for(int i = start; i < end; i++ )
        {
            friendCount = 0;
            for( int j = 0; j < arrives.length; j++)
            {
                if( i >= arrives[j] && i < departs[j] )
                {
                    friendCount++;
                }
            }
            friendCounts[ind] = friendCount;
            ind++;
        }
        return friendCounts;
    }
    
        
    public static int bestTimeToAttend( int start, int end, String name )
    {
        int friendCount = 0;
        int maxFriend = -1;
        boolean enemyIsAttending;
        int maxHour = -1;

        for(int i = start; i < end; i++ )
        {
            friendCount = 0;
            for( int j = 0; j < arrives.length; j++)
            {
                if( i >= arrives[j] && j < departs[j] )
                {
                    friendCount++;
                }
            }
            enemyIsAttending = friendAttendingAtTime( i,name );
            if( friendCount > maxFriend && !enemyIsAttending)
            {
                maxFriend = friendCount;
                maxHour = i;
            }
        }
        return maxHour;
    }

    public static boolean friendAttendingAtTime( int hour, String name )
    {
        boolean attending = false;
        for( int i = 0; i < friend.length; i++ )
        {
            if( friend[i].equalsIgnoreCase( name ) )
            {
                if( hour >= arrives[i] && hour < departs[i])
                {
                    attending = true;
                }
            }
        }
        return attending;
    }
    public static void main(String[] args) 
    {
        int[] numFriends;
        int start;
        int end;
        String friend;
        int hour;

        Scanner in = new Scanner( System.in ); 
        
        System.out.print("Enter time interval you are available: ");
        start = in.nextInt();
        end = in.nextInt();
        
        numFriends = friendsAttending(start, end);
        
        int ind = 0;
        for( int i = 0; i < numFriends.length;i++)
        {
            if( numFriends[i] > numFriends[ind] )
                ind = i;
            System.out.printf("At %dpm, %d friends will be at the party%n", start + i, numFriends[i]);    
        }
        System.out.printf("Best time to attend is %d%n", start + ind );
        
        System.out.print("Enter friend you wish to avoid: ");
        friend = in.next();
        
        System.out.print("Enter time interval you are available: ");
        start = in.nextInt();
        end = in.nextInt();

        hour = bestTimeToAttend(start, end, friend );
        System.out.printf("Best time to attend to avoid %s and to see the most friends is %d %n", friend, hour );

        in.close();

    }
}
