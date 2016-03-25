import java.util.Scanner;

/**
 * Created by Mitchell Findley on 3/25/16.
 * Student at University of Central Florida
 * Project/Class: Cop4516TeamWeek2
 */
public class robot
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        float[] table = new float[n];
        Target[] targets = new Target[n];

        while(n!=0){
            float xPos = 0;
            float yPos = 0;
            float dist = 0;
            for(int i = 0; i < n; i++)
            {
                int x = in.nextInt();
                int y = in.nextInt();
                int p = in.nextInt();
                targets[i].x = x;
                targets[i].y = y;
                targets[i].p = p;
            }
            table[0] = 0;
            for(int i = 0; i < n; i++)
            {

            }



            n = in.nextInt();
        }

    }
}

class Target{
    int x;
    int y;
    int p;

    public void Target(int a, int b, int c){
        x = a;
        y = b;
        p = c;
    }
}
