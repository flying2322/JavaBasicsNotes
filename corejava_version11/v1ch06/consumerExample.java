import java.util.function.Consumer;


public class consumerExample {
    public static void main(String[] args) {
        Consumer<String> printConsumer = s -> System.out.println(s);
        printConsumer.accept("Hello, World!");
        printConsumer.accept("Hai Robotics.");

        String testSplit = "This#is#a#string#Split#test";
        String separator = "#";
        String[] result = testSplit.split(separator);
        System.out.println();
        System.out.println("the length of splited strings is : " + result.length);
        for(var a : result)
            printConsumer.accept(a);
    }
}