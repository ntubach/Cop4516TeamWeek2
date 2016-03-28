import java.util.*;

/**
 * Created by Mitchell Findley on 3/25/16.
 * Student at University of Central Florida
 * Project/Class: Cop4516TeamWeek2
 */
public class countseq
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++)
        {
            System.out.println(countMatches(in.next(), in.next()));
        }
    }

    public static long countMatches(String seq, String subseq)
    {
        long[][] tbl = new long[subseq.length() + 1][seq.length() + 1];

        for (int col = 1; col < seq.length() + 1; col++)
        {
            tbl[1][col] += tbl[1][col - 1];
            if (seq.charAt(seq.length()-col) == subseq.charAt(subseq.length()-1))
            {
                tbl[1][col]++;
            }
        }

        for (int row = 2; row < subseq.length() + 1; row++)
        {
            for (int col = 1; col < seq.length() + 1; col++)
            {
                tbl[row][col] += tbl[row][col - 1];
                if (seq.charAt(seq.length()-col) == subseq.charAt(subseq.length()-row))
                {
                    tbl[row][col] += tbl[row - 1][col - 1];
                }
            }
        }

        return tbl[subseq.length()][seq.length()];
    }
}
