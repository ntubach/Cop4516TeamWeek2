import java.util.*;

public class robot
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		while(N != 0)
		{
			N += 2; //Add the point 0,0 and 100,100
			int[] x = new int[N];
			int[] y = new int[N];
			int[] p = new int[N];
			
			//First and last points are unskippable
			x[0] = 0;
			y[0] = 0;
			p[0] = 1000000000;
			x[N-1] = 100;
			y[N-1] = 100;
			p[N-1] = 1000000000;
			
			for(int i=1; i<N-1; i++)
			{
				x[i] = in.nextInt();
				y[i] = in.nextInt();
				p[i] = in.nextInt();
			}
			
			double[] score = new double[N];
			score[N-1] = 1.0; //stop at end point costs 1
			
			for(int i=N-2; i>=0; i--)
			{
				int pen = 0;				
				score[i] = Double.MAX_VALUE;
				
				for(int j = i+1; j<N; j++)
				{
					int x2 = x[j] - x[i];
					int y2 = y[j] - y[i];
					//Find distance
					double dist = Math.sqrt(x2*x2 + y2*y2);					
					//Calculate cost of skipping
					double cost = 1.0 + dist + pen + score[j];
					//Replace your best with new value if better
					if(cost < score[i])
						score[i] = cost;
					//Increment penalty
					pen += p[j];					
					//3.0 occurs due to the one second stop
					// + shortest dist possible + best possible prev score
					if(pen+3.0 >= score[i])
						break;
				}
			}
			System.out.printf("%.3f", score[0]-1.0);
			System.out.println();
			N = in.nextInt();
		}
		in.close();
	}
}
