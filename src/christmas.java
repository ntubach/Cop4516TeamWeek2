import java.util.*;

/**
 * Created by Mitchell Findley on 3/25/16.
 * Student at University of Central Florida
 * Project/Class: Cop4516TeamWeek2
 */
public class christmas
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        long[] gifts = new long[1000001];

        for(long i=1; i <= 1000000; i++)
        {
            gifts[(int)i]= ((i * (i+1))/2) + gifts[(int)(i-1)];
        }
        int day = in.nextInt();

        while(day != 0)
        {
            System.out.println(gifts[day]);
            day = in.nextInt();
        }
    }
}
