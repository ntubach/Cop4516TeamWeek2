import java.util.Scanner;

/**
 * Created by Mitchell Findley on 3/25/16.
 * Student at University of Central Florida
 * Project/Class: Cop4516TeamWeek2
 */
public class spidey
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();

        for(int count=0; count<cases; count++)
        {
            int N = in.nextInt();
            int E = in.nextInt();
            boolean[][] G = new boolean[N][N];
            boolean flag = false;

            for(int i=0; i<E; i++)
            {
                int a = in.nextInt();
                int b = in.nextInt();
                if(a%2 == b%2)
                {
                    flag = true;
                    break;
                }
                G[a][b] = true;
                G[b][a] = true;
            }
            if(flag)
            {
                System.out.println("It's the end of the world!\n");
                continue;
            }
            spidey temp = new spidey(G, N);
            for(int i=0; i<N; i++)
            {
                if (!temp.V[i])
                {
                    flag = true;
                    break;
                }
            }
            if(flag)
            {
                System.out.println("It's the end of the world!\n");
                continue;
            }
            System.out.println("Way to go, Spider-Man!\n");
        }
    }

    spidey(boolean[][] G, int N)
    {
        V = new boolean[N];
        DFS(0, V, G, N);
    }
    boolean[] V;
    void DFS(int at, boolean[] V, boolean[][] G, int N)
    {
        V[at] = true;
        for(int i=0; i<N; ++i)
        {
            if(G[at][i]  && !V[i])
                DFS(i,V, G, N);
        }
    }
}
