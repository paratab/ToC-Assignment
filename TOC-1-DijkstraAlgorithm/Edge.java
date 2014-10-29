//This class is represent the Edge of the graph
public class Edge {
	public Vertex start;
	public Vertex dest;
	public double weight;
	//Default Constructor
	public Edge() {
	}
	public Edge(Vertex start,Vertex dest,int weight){
		this.start = start;
		this.dest = dest;
		this.weight = weight;
	}
}
