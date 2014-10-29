import java.util.*;

//This class is represent the Graph that contains verties and edges
public class Graph {
	
	public ArrayList<Vertex> vertex = new ArrayList<Vertex>();
	public ArrayList<Edge> edge = new ArrayList<Edge>();
	
	//Find the vertex in the graph.
	public Vertex find(String name){
		for(Vertex u : vertex){
			if(u.name.equals(name)) {
				return u;
			}
		}
		return null;
	}

	//Get the weight of the edge 
	public double getWeight(Vertex start ,Vertex dest){
		for( Edge e : edge){
			if(e.start == start && e.dest == dest) return e.weight;
		}
		// Return infinity if not found that edge.
		return Double.POSITIVE_INFINITY;	
	}
}
