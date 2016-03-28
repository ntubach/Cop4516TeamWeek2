import java.util.Scanner;

/**
 * Created by Mitchell Findley on 3/25/16.
 * Student at University of Central Florida
 * Project/Class: Cop4516TeamWeek2
 */
public class lotto
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int[][] allSets = new int[11][2001];

        for (int i = 1; i < 2001; i++)
        {
            allSets[1][i] = i;
        }

        for (int i = 2; i < 11; i++)
        {
            int min = (int)Math.pow(2, i-1);
            allSets[i][min] = 1;
            for (int j = min + 1; j < 2001; j++)
            {
                for (int k = j; k >= min; k--)
                {
                    allSets[i][j] += allSets[i - 1][(int)Math.floor(k/2)];
                }
            }
        }

        int caseNum = 1;
        int n = in.nextInt(), m = in.nextInt();

        while (n != 0)
        {
            System.out.println("Case " + caseNum + ": n = " + n + ", m = " + m + ", # lists = " + allSets[n][m]);
            caseNum++;
            n = in.nextInt();
            m =in.nextInt();
        }
    }
}
