package pair2;

import java.time.*;

public class PairTest2
{
    public static void main(String[] args)
    {
        LocalDate[] birthdays =
                {
                        LocalDate.of(1906,12,9),
        LocalDate.of(1815,12,9),
        LocalDate.of(1907,12,10),
        LocalDate.of(1908,12,11),
                };
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}