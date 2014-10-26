import java.util.*;

public class Graph {
	
	public ArrayList<Vertex> vertex = new ArrayList<Vertex>();
	public ArrayList<Edge> edge = new ArrayList<Edge>();
	public Vertex find(String name){
		for(Vertex u : vertex){
			if(u.name.equals(name)) {
				//System.out.println(name+","+u.name);
				return u;
			}
		}
		return null;
	}

	public double getWeight(Vertex u,Vertex v){
		for( Edge e : edge){
			if(e.start==u&&e.dest==v) return e.weight;
		}
		return Double.POSITIVE_INFINITY;
	}
	
}
