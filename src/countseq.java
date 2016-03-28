import java.util.*;

/**
 * Created by Mitchell Findley on 3/25/16.
 * Student at University of Central Florida
 * Project/Class: Cop4516TeamWeek2
 */
public class countseq
{
    private static long total;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++)
        {
            String s = in.next();
            String sequence = in.next();

            //set up map
            HashMap<Character, ArrayList<Integer>> seqMap = new HashMap<>();
            for (int j = 0; j < sequence.length(); j++)
            {
                char c = sequence.charAt(j);
                if (!seqMap.containsKey(c))
                {
                    seqMap.put(c, new ArrayList<Integer>());
                }
            }

            //get indexes for chars in sequence
            for (int j = 0; j < s.length(); j++)
            {
                char c = s.charAt(j);
                if (seqMap.containsKey(c))
                {
                    ArrayList<Integer> list = seqMap.get(c);
                    list.add(j);
                    seqMap.put(c, list);
                }
            }

            //sort list
            for (Map.Entry<Character, ArrayList<Integer>> entry : seqMap.entrySet())
            {
                Collections.sort(entry.getValue());
            }

            //setup test loop
            int[] lowIndex = new int[sequence.length()];
            total = 0;
            sequences(seqMap, sequence, 0, -1, lowIndex);
            System.out.println(total);
        }
    }

    public static void sequences(HashMap<Character, ArrayList<Integer>> map,
                                String seq, int index, int pos, int[] low)
    {
        int smallMax = 1001;
        if (index == seq.length())
        {
            total++;
            return;
        }
        ArrayList<Integer> list = map.get(seq.charAt(index));
        for (int i = low[index]; i < list.size(); i++)
        {
            if (list.get(i) > pos)
            {
                smallMax = i < smallMax ? i : smallMax;
                sequences(map, seq, index + 1, list.get(i), low);
                //low[index] = smallMax;
            }
        }
        return;
    }
}
