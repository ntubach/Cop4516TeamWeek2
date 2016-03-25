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

    /*public static int sequences(HashMap<Character, ArrayList<Integer>> map,
                                String seq, int[] low)
    {
        ArrayList<Integer> list = map.get(seq.charAt(0));
        int val = 0;
        for (int i = low[0]; i < list.size(); i++)
        {
            low[0] = i;
            val += sequences(map, seq, 1, list.get(i), low);
        }
        return val;
    }

    public static int sequences(HashMap<Character, ArrayList<Integer>> map,
                                String seq, int index, int pos, int[] low)
    {
        if (index == seq.length())
        {
            return 1;
        }
        ArrayList<Integer> list = map.get(seq.charAt(index));
        for (int i = low[index]; i < list.size(); i++)
        {
            if (list.get(i) > pos)
            {
                low[index] = i;
                return (list.size() - i) * sequences(map, seq, index + 1, list.get(i), low);
            }
        }
        return 0;
    }*/

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
