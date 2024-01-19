import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        // Key: Char, Value: List of Strings that contains this Char
        Map<String, List<String>> map = new HashMap<>();

        // (1)"eat", (2)tea", (3)"tan"
        for(String s: strs) {
            // Sort all the chars of the current String
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars); 
            //(1)"aet", (2)"aet", (3)"ant", (4)"aet", (5)"ant", (6)"abt"
            
            // This line is the same as using the "if" method
            //map.computeIfAbsent(sorted, initWith -> new ArrayList<String>()).add(s);

            if(!map.containsKey(sorted)) map.put(sorted, new ArrayList<String>()); 
            // Only add to the map when it's a new combination
            // {
            //     (1)"aet": [""],
            //     (3)"ant": [""],
            //     (6)"abt": [""],
            // }
             
            map.get(sorted).add(s); 
            // {
            //     "aet": [(1)"eat", (2)"tea"],  
            //     "ant": [(3)"tan", (5) "nat"], 
            //     "abt": [(6)"bat"],
            // }
        }

        result.addAll(map.values());
        return result;
    }
}
