import java.util.*;

public class Vertex {

	public final String name;
	public ArrayList<Vertex> adjacent = new ArrayList<Vertex>();

	public Vertex() {
		this.name = " ";
	}

	public Vertex(String name) {
		this.name = name;
	}

	@SuppressWarnings("unchecked")
	public Vertex(Vertex v) {
		name = v.name;
		adjacent.clear();
		adjacent = (ArrayList<Vertex>) v.adjacent.clone();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
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
