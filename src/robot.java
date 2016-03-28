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

        while(n!=0)
        {
            for(int i = 1; i < n + 1; i++)
            {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
                p[i] = in.nextInt();
            }
            // set end
            x[n+1] = 100;
            y[n+1] = 100;

            // set penalties for start
            for (int i = 1; i < n + 2; i++)
            {
                tbl[0][i] = tbl[0][i - 1] + p[i];
            }

            for (int i = 1; i < n + 2; i++)
            {
                // set time from j to i
                for (int j = i - 1; j > - 1; j--)
                {
                    float xdis = x[i] - x[j];
                    float ydis = y[i] - y[j];

                    tbl[i][j] = Math.sqrt(xdis*xdis + ydis*ydis) + 1;
                }
                // set penalties for target i to target j
                for (int j = i + 1; j < n + 2; j++)
                {
                    tbl[i][j] = tbl[i][j - 1] + p[j];
                }
            }

            // from start
            for (int j = 1; j < n + 2; j++)
            {
                tbl[0][j] += tbl[j][0];
            }

            // solve
            for (int i = 1; i < n + 2; i++)
            {
                tbl[i][i] = tbl[i][i-1] + tbl[i-1][i-1];
                tbl[i][i] = tbl[i - 1][i] < tbl[i][i] ? tbl[i - 1][i] : tbl[i][i];
                for (int j = i + 1; j < n + 2; j++)
                {
                    tbl[i][j] += tbl[j][i] + tbl[i][i];
                    tbl[i][j] = tbl[i - 1][j] < tbl[i][j] ? tbl[i - 1][j] : tbl[i][j];
                }
            }

            System.out.printf("%.3f\n", tbl[n+1][n+1]);

            n = in.nextInt();
        }

    }
}
