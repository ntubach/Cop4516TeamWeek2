import java.util.HashSet;
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

        HashSet<lotto> set = new HashSet<>();
        int caseNum = 1;
        int lists;
        int n = in.nextInt(), m =in.nextInt();

        while (n != 0)
        {
            lists = 0;
            lotto top = new lotto(n);
            top.set(m, n-1);
            for (int i = n - 2; i > -1; i--)
            {
                top.set((int)Math.floor(top.get(i+1)/2),i);
            }
            set.add(top);
            lists++;

            System.out.println("Case " + caseNum + ": n = " + n + ", m = " + m + " # lists = " + lists);
            caseNum++;
            n = in.nextInt();
            m =in.nextInt();
        }
    }

    int[] arr;
    public lotto(int[] arr)
    {
        this.arr = arr;
    }

    public lotto(int size)
    {
        this.arr = new int[size];
    }

    public int get(int i)
    {
        return this.arr[i];
    }

    public void set(int i, int index)
    {
        this.arr[index] = i;
    }

    public void set(int[] arr)
    {
        this.arr = arr;
    }

    public int size()
    {
        return this.arr.length;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        for (int i = 0; i < this.arr.length; i++)
        {
            hash *= 10;
            hash += this.arr[i];
        }
        return hash;
    }
}
