package pair1;


/**
 * @version 1.01 2023-09-05
 * @author Mr. Li Wenpeng
 */
import java.util.*;

public class PairTest1
{
    public static void main(String[] args)
    {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}

