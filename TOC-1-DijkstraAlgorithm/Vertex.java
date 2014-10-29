import java.util.*;

//This class represent the vertex in a Graph
public class Vertex {

	public final String name;
	//ArrayList that contain the verties that connect with current vertex by the edge
	public ArrayList<Vertex> adjacent = new ArrayList<Vertex>();

	public Vertex() {
		this.name = " ";
	}
	public Vertex(String name) {
		this.name = name;
	}
	public Vertex(Vertex v) {
		name = v.name;
		adjacent.clear();
		adjacent = (ArrayList<Vertex>) v.adjacent.clone();
	}
	@Overrid  // Overide hashCode function to use for making key in Map<>
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override // Override equals function to compare the object Vertex
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
