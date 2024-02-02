# Map in 

Official doc: https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/Map.html


In Java, a `Map` is a part of the Java Collections Framework and is designed to store key-value pairs. Each key must be unique within the `Map`, and the key-value pairs provide a way to associate data with those keys. Java provides several implementations of the `Map` interface, each with its own characteristics. Here are some common implementations:

1. **HashMap:**
   - Uses a hash table to store key-value pairs.
   - Provides constant-time average complexity for basic operations (**get and put**).
   - Does not guarantee order of elements.

   Example:
   ```java
   Map<String, Integer> hashMap = new HashMap<>();
   hashMap.put("one", 1);
   hashMap.put("two", 2);
   ```

2. **TreeMap:**
   - Implements `NavigableMap` and maintains keys in sorted order.
   - Provides log(n) time complexity for basic operations (get and put).
   - Allows custom ordering using comparators.

   Example:
   ```java
   Map<String, Integer> treeMap = new TreeMap<>();
   treeMap.put("one", 1);
   treeMap.put("two", 2);
   ```

3. **LinkedHashMap:**
   - Extends `HashMap` and maintains the order of insertion.
   - Provides faster iteration compared to `HashMap`.
   - Offers predictable iteration order.

   Example:
   ```java
   Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
   linkedHashMap.put("one", 1);
   linkedHashMap.put("two", 2);
   ```

4. **HashTable:**
   - A legacy class that is synchronized, making it thread-safe.
   - Considered less efficient than `HashMap` due to synchronization overhead.

   Example:
   ```java
   Map<String, Integer> hashTable = new Hashtable<>();
   hashTable.put("one", 1);
   hashTable.put("two", 2);
   ```

5. **ConcurrentHashMap:**
   - Introduced to provide a scalable and concurrent alternative to `HashTable`.
   - Offers high concurrency for read operations without the need for locking.
   
   Example:
   ```java
   Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
   concurrentHashMap.put("one", 1);
   concurrentHashMap.put("two", 2);
   ```

Choose the implementation that best suits your requirements based on factors such as performance, concurrency, and ordering.

# LinkedHashMap

`LinkedHashMap` in Java extends `HashMap` and maintains the order of the keys based on their insertion order. Here are some key functions and features you should be aware of when using `LinkedHashMap`:

1. **Insertion Order:**
   - `LinkedHashMap` maintains the order of key-value pairs based on the order in which they were inserted into the map. This is different from `HashMap`, which does not guarantee any specific order.

2. **Access Order:**
   - `LinkedHashMap` also supports access ordering through a constructor that takes a boolean parameter. If the access order is set to `true`, the map orders the entries based on their access (get, put, etc.), making it useful for building LRU (Least Recently Used) caches.

   Example with access ordering:
   ```java
   Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
   linkedHashMap.put("one", 1);
   linkedHashMap.put("two", 2);

   // Accessing "one" moves it to the end of the iteration order
   linkedHashMap.get("one");
   ```

3. **Iterating in Insertion Order:**
   - You can iterate through the entries of a `LinkedHashMap` in the order they were inserted.

   Example:
   ```java
   for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
       System.out.println(entry.getKey() + ": " + entry.getValue());
   }
   ```

4. **Removing Eldest Entry:**
   - `LinkedHashMap` can be configured to automatically remove the eldest entry when a new entry is added. This is often used for creating a fixed-size cache.

   Example:
   ```java
   Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true) {
       @Override
       protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
           return size() > 5; // Remove the eldest entry if the size exceeds 5
       }
   };
   ```

5. **Copy Constructor:**
   - `LinkedHashMap` provides a copy constructor that allows you to create a new `LinkedHashMap` with the same mappings as an existing one.

   Example:
   ```java
   Map<String, Integer> originalMap = new LinkedHashMap<>();
   // Add entries to the originalMap

   Map<String, Integer> copyMap = new LinkedHashMap<>(originalMap);
   ```

Understanding these features will help you use `LinkedHashMap` effectively based on your specific use case, whether you need to maintain insertion order, access order, or a combination of both.