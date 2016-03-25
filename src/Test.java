/**
 * Created by Mitchell Findley on 2/23/16.
 * Student at University of Central Florida
 * Project/Class: COP4516IC
 */
public class Test
{
    public static void main(String[] args)
    {
        ProgramTestFile ptf = new ProgramTestFile("src/test.in", "src/test.out");
        if (ptf.isCorrect(new ProgramTestParams(null, lotto.class)))
        {
            System.out.println("solution is correct.");
        }
        /*
        COP4516Spring2016 ptf = new COP4516Spring2016("spr2016/ind/final/");
        if (ptf.isCorrect(new ProgramTestParams("factors", factors.class)))
        {
            System.out.println("factors solution is correct.");
        }*/
    }
}
