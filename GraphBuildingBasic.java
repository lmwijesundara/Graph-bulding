import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class GraphBuildingBasic {
    private Map<String, LinkedList<String>> map = new HashMap();

    public void addEdge(String node1, String node2) {
        LinkedList<String> adjacent = map.get(node1);
        if(adjacent==null) {
            adjacent = new LinkedList();
            map.put(node1, adjacent);
        }
        adjacent.add(node2);
    }
}