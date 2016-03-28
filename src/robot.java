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
        double[][] tbl = new double[1002][1002];
        float[] x = new float[1002];
        float[] y = new float[1002];
        float[] p = new float[1002];
        /*float[] table = new float[n];
        Target[] targets = new Target[n];*/

        while(n!=0)
        {
            /*
            float xPos = 0;
            float yPos = 0;
            float dist = 0;*/
            for(int i = 1; i < n + 1; i++)
            {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
                p[i] = in.nextInt();
            }

            x[n+1] = 100;
            y[n+1] = 100;

            for (int i = 1; i < n + 2; i++)
            {
                float xdis = x[i] - x[i-1];
                float ydis = y[i] - y[i-1];
                double time = Math.sqrt(xdis*xdis + ydis*ydis) + 1;
                for (int j = n; j < n + 1; j++)
                {

                }
                tbl[i][i] = time + tbl[i-1][i-1];
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
