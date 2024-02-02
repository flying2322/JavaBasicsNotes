import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;

public class computeIfAbsent {
    public static void main(String[] args) {
        // Create a HashMap
        Map<String, Integer> map = new HashMap<>();

        // Using computeIfAbsent to add a value for a key if it's not present
        map.computeIfAbsent("key1", k -> 42);
        map.computeIfAbsent("key2", k -> 84);

        // If the key is already present, the existing value is returned
        Integer existingValue = map.computeIfAbsent("key1", k -> 100);

        // Print the map
        System.out.println("Map: " + map);
        System.out.println("Existing Value for key1: " + existingValue);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("one", 1);
        linkedHashMap.put("two", 2);

        // Accessing "one" moves it to the end of the iteration order
        System.out.println((linkedHashMap.get("one")));
    }
}
