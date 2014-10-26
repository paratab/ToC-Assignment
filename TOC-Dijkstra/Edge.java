
public class Edge {
	public Vertex start;
	public Vertex dest;
	public double weight;
	public Edge(Vertex start,Vertex dest,int weight){
		this.start = start;
		this.dest = dest;
		this.weight = weight;
	}
	public Edge() {
		
	}
}
