import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Search {
	private static  final String START="A";
    private static final String END = "B";


	public static void main(String[] args) throws FileNotFoundException {

		Graph graph = new Graph();
		Scanner graph_input=new Scanner(new File("g.txt"));
		
		while(graph_input.hasNext()){
			 graph.addEdge(graph_input.next(), graph_input.next());
		}
		
		LinkedList<String> visited = new LinkedList<String>();
		visited.add(START);

		Search srh = new Search();
		srh.depthFirst(graph, visited);
		graph_input.close();
	}
	
	private void depthFirst(Graph graph, LinkedList<String> visited) {
        LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
        // examine adjacent nodes
        for (String node : nodes) {
            if (visited.contains(node)) {
                continue;
            }
            if (node.equals(END)) {
                visited.add(node);
                printPath(visited);
                visited.removeLast();
                break;
            }
        }
        for (String node : nodes) {
            if (visited.contains(node) || node.equals(END)) {
                continue;
            }
            visited.addLast(node);
            depthFirst(graph, visited);
            visited.removeLast();
        }
    }
    
	 private void printPath(LinkedList<String> visited) {
	        for (String node : visited) {
	            System.out.print(node);
	            System.out.print(" ");
	        }
	        System.out.println();
	    }

}
