package proxy;

import java.lang.reflect.*;
import java.util.*;

/**
 * This program demonstrates the use of proxius.
 */

public class ProxyTest
{
    public static void main(String[] args)
    {
        var elements = new Object[1000];

        // fill elements
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            var handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(
                    ClassLoader.getSystemClassLoader(),
                    new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        // constract a random integer
        Integer key = new Random().nextInt(elements.length) + 1;

        // search for the key
        int result = Arrays.binarySearch(elements, key);

        // print match if found
        if (result >= 0) System.out.println(elements[result]);
    }
}

/**
 * An invocation handler that prints out the method name and parameters, then
 * invokes the original method
 */
class TraceHandler implements InvocationHandler
{
    private Object target;

    /**
     * Construct a traceHandler
     * @param t the implicit parameter of the method call
     */

    public TraceHandler(Object t)
    {
        target = t;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
    {
        System.out.print(target);

        System.out.print("." + m.getName() + "(");

        if (args != null)
        {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i< args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");

        // invoke actual method
        return m.invoke(target, args);
    }
}