package genericReflection;

import java.lang.reflect.*;
import java.util.*;

/**
 * @version 1.11 2018-04-10
 * @author Cay Horstmann
 */
public class GenericReflectionTest
{
   public static void main(String[] args)
   {
      // read class name from command line args or user input
      String name;
      if (args.length > 0) name = args[0];
      else
      {
         try (var in = new Scanner(System.in))
         {
            System.out.println("Enter class name (e.g., java.util.Collections): ");
            name = in.next();
         }
      }

      try
      {
         // print generic info for class and public methods
         Class<?> cl = Class.forName(name);
         printClass(cl);
         for (Method m : cl.getDeclaredMethods())
            printMethod(m);
      }
      catch (ClassNotFoundException e)
      {
         e.printStackTrace();
      }
   }

   public static void printClass(Class<?> cl)
   {
      System.out.print(cl);
      printTypes(cl.getTypeParameters(), "<", ", ", ">", true);
      Type sc = cl.getGenericSuperclass();
      if (sc != null)
      {
         System.out.print(" extends ");
         printType(sc, false);
      }
      printTypes(cl.getGenericInterfaces(), " implements ", ", ", "", false);
      System.out.println();
   }

   public static void printMethod(Method m)
   {
      String name = m.getName();
      System.out.print(Modifier.toString(m.getModifiers()));
      System.out.print(" ");
      printTypes(m.getTypeParameters(), "<", ", ", "> ", true);

      printType(m.getGenericReturnType(), false);
      System.out.print(" ");
      System.out.print(name);
      System.out.print("(");
      printTypes(m.getGenericParameterTypes(), "", ", ", "", false);
      System.out.println(")");
   }

   public static void printTypes(Type[] types, String pre, String sep, String suf, 
         boolean isDefinition)
   {
      if (pre.equals(" extends ") && Arrays.equals(types, new Type[] { Object.class }))
         return;
      if (types.length > 0) System.out.print(pre);
      for (int i = 0; i < types.length; i++)
      {
         if (i > 0) System.out.print(sep);
         printType(types[i], isDefinition);
      }
      if (types.length > 0) System.out.print(suf);
   }

   public static void printType(Type type, boolean isDefinition)
   {
      if (type instanceof Class)
      {
         var t = (Class<?>) type;
         System.out.print(t.getName());
      }
      else if (type instanceof TypeVariable)
      {
         var t = (TypeVariable<?>) type;
         System.out.print(t.getName());
         if (isDefinition)
            printTypes(t.getBounds(), " extends ", " & ", "", false);
      }
      else if (type instanceof WildcardType)
      {
         var t = (WildcardType) type;
         System.out.print("?");
         printTypes(t.getUpperBounds(), " extends ", " & ", "", false);
         printTypes(t.getLowerBounds(), " super ", " & ", "", false);
      }
      else if (type instanceof ParameterizedType)
      {
         var t = (ParameterizedType) type;
         Type owner = t.getOwnerType();
         if (owner != null)
         {
            printType(owner, false);
            System.out.print(".");
         }
         printType(t.getRawType(), false);
         printTypes(t.getActualTypeArguments(), "<", ", ", ">", false);
      }
      else if (type instanceof GenericArrayType)
      {
         var t = (GenericArrayType) type;
         System.out.print("");
         printType(t.getGenericComponentType(), isDefinition);
         System.out.print("[]");
      }
   }
}

/*
Enter class name (e.g., java.util.Collections):
java.util.Collections
class java.util.Collections extends java.lang.Object
private static <T> T get(java.util.ListIterator<? extends T>, int)
public static <T> T min(java.util.Collection<? extends T>, java.util.Comparator<? super T>)
public static <T extends java.lang.Object & java.lang.Comparable<? super T>> T min(java.util.Collection<? extends T>)
public static <T extends java.lang.Object & java.lang.Comparable<? super T>> T max(java.util.Collection<? extends T>)
public static <T> T max(java.util.Collection<? extends T>, java.util.Comparator<? super T>)
public static void reverse(java.util.List<?>)
public static <T extends java.lang.Comparable<? super T>> void sort(java.util.List<T>)
public static <T> void sort(java.util.List<T>, java.util.Comparator<? super T>)
public static <T> void copy(java.util.List<? super T>, java.util.List<? extends T>)
public static <T> boolean replaceAll(java.util.List<T>, T, T)
public static <T> void fill(java.util.List<? super T>, T)
public static <T> java.util.ArrayList<T> list(java.util.Enumeration<T>)
public static transient <T> boolean addAll(java.util.Collection<? super T>, T[])
public static <T> java.util.Enumeration<T> emptyEnumeration()
public static <E> java.util.Set<E> newSetFromMap(java.util.Map<E, java.lang.Boolean>)
public static final <T> java.util.List<T> emptyList()
public static <T> java.util.Set<T> unmodifiableSet(java.util.Set<? extends T>)
public static <T> java.util.Enumeration<T> enumeration(java.util.Collection<T>)
public static <T> java.util.Set<T> synchronizedSet(java.util.Set<T>)
static <T> java.util.Set<T> synchronizedSet(java.util.Set<T>, java.lang.Object)
static <T> java.util.Collection<T> synchronizedCollection(java.util.Collection<T>, java.lang.Object)
public static <T> java.util.Collection<T> synchronizedCollection(java.util.Collection<T>)
public static <T> java.util.Iterator<T> emptyIterator()
public static <T> java.util.List<T> nCopies(int, T)
static boolean eq(java.lang.Object, java.lang.Object)
public static <T> java.util.Comparator<T> reverseOrder()
public static <T> java.util.Comparator<T> reverseOrder(java.util.Comparator<T>)
public static <K, V> java.util.Map<K, V> unmodifiableMap(java.util.Map<? extends K, ? extends V>)
public static void swap(java.util.List<?>, int, int)
private static void swap([Ljava.lang.Object;, int, int)
public static <T> int binarySearch(java.util.List<? extends T>, T, java.util.Comparator<? super T>)
public static <T> int binarySearch(java.util.List<? extends java.lang.Comparable<? super T>>, T)
private static <T> int indexedBinarySearch(java.util.List<? extends T>, T, java.util.Comparator<? super T>)
private static <T> int indexedBinarySearch(java.util.List<? extends java.lang.Comparable<? super T>>, T)
private static <T> int iteratorBinarySearch(java.util.List<? extends T>, T, java.util.Comparator<? super T>)
private static <T> int iteratorBinarySearch(java.util.List<? extends java.lang.Comparable<? super T>>, T)
public static void shuffle(java.util.List<?>, java.util.Random)
public static void shuffle(java.util.List<?>, java.util.random.RandomGenerator)
public static void shuffle(java.util.List<?>)
private static <T> void rotate1(java.util.List<T>, int)
private static void rotate2(java.util.List<?>, int)
public static void rotate(java.util.List<?>, int)
public static int indexOfSubList(java.util.List<?>, java.util.List<?>)
public static int lastIndexOfSubList(java.util.List<?>, java.util.List<?>)
public static <T> java.util.Collection<T> unmodifiableCollection(java.util.Collection<? extends T>)
public static <T> java.util.SequencedCollection<T> unmodifiableSequencedCollection(java.util.SequencedCollection<? extends T>)
public static <T> java.util.SequencedSet<T> unmodifiableSequencedSet(java.util.SequencedSet<? extends T>)
public static <T> java.util.SortedSet<T> unmodifiableSortedSet(java.util.SortedSet<T>)
public static <T> java.util.NavigableSet<T> unmodifiableNavigableSet(java.util.NavigableSet<T>)
public static <T> java.util.List<T> unmodifiableList(java.util.List<? extends T>)
public static <K, V> java.util.SequencedMap<K, V> unmodifiableSequencedMap(java.util.SequencedMap<? extends K, ? extends V>)
public static <K, V> java.util.SortedMap<K, V> unmodifiableSortedMap(java.util.SortedMap<K, ? extends V>)
public static <K, V> java.util.NavigableMap<K, V> unmodifiableNavigableMap(java.util.NavigableMap<K, ? extends V>)
public static <T> java.util.SortedSet<T> synchronizedSortedSet(java.util.SortedSet<T>)
public static <T> java.util.NavigableSet<T> synchronizedNavigableSet(java.util.NavigableSet<T>)
static <T> java.util.List<T> synchronizedList(java.util.List<T>, java.lang.Object)
public static <T> java.util.List<T> synchronizedList(java.util.List<T>)
public static <K, V> java.util.Map<K, V> synchronizedMap(java.util.Map<K, V>)
public static <K, V> java.util.SortedMap<K, V> synchronizedSortedMap(java.util.SortedMap<K, V>)
public static <K, V> java.util.NavigableMap<K, V> synchronizedNavigableMap(java.util.NavigableMap<K, V>)
public static <E> java.util.Collection<E> checkedCollection(java.util.Collection<E>, java.lang.Class<E>)
static <T> T[] zeroLengthArray(java.lang.Class<T>)
public static <E> java.util.Queue<E> checkedQueue(java.util.Queue<E>, java.lang.Class<E>)
public static <E> java.util.Set<E> checkedSet(java.util.Set<E>, java.lang.Class<E>)
public static <E> java.util.SortedSet<E> checkedSortedSet(java.util.SortedSet<E>, java.lang.Class<E>)
public static <E> java.util.NavigableSet<E> checkedNavigableSet(java.util.NavigableSet<E>, java.lang.Class<E>)
public static <E> java.util.List<E> checkedList(java.util.List<E>, java.lang.Class<E>)
public static <K, V> java.util.Map<K, V> checkedMap(java.util.Map<K, V>, java.lang.Class<K>, java.lang.Class<V>)
public static <K, V> java.util.SortedMap<K, V> checkedSortedMap(java.util.SortedMap<K, V>, java.lang.Class<K>, java.lang.Class<V>)
public static <K, V> java.util.NavigableMap<K, V> checkedNavigableMap(java.util.NavigableMap<K, V>, java.lang.Class<K>, java.lang.Class<V>)
public static <T> java.util.ListIterator<T> emptyListIterator()
public static final <T> java.util.Set<T> emptySet()
public static <E> java.util.SortedSet<E> emptySortedSet()
public static <E> java.util.NavigableSet<E> emptyNavigableSet()
public static final <K, V> java.util.Map<K, V> emptyMap()
public static final <K, V> java.util.SortedMap<K, V> emptySortedMap()
public static final <K, V> java.util.NavigableMap<K, V> emptyNavigableMap()
public static <T> java.util.Set<T> singleton(T)
static <E> java.util.Iterator<E> singletonIterator(E)
static <T> java.util.Spliterator<T> singletonSpliterator(T)
public static <T> java.util.List<T> singletonList(T)
public static <K, V> java.util.Map<K, V> singletonMap(K, V)
public static int frequency(java.util.Collection<?>, java.lang.Object)
public static boolean disjoint(java.util.Collection<?>, java.util.Collection<?>)
public static <E> java.util.SequencedSet<E> newSequencedSetFromMap(java.util.SequencedMap<E, java.lang.Boolean>)
public static <T> java.util.Queue<T> asLifoQueue(java.util.Deque<T>)

 */