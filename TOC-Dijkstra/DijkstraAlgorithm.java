import java.util.*;

public class DijkstraAlgorithm {
	public static void Dijkstra(Graph g, Vertex start, Vertex dest) {
		Map<Vertex, Double> dist = new HashMap<Vertex, Double>();
		Map<Vertex, Vertex> prev = new HashMap<Vertex, Vertex>();
		Vertex u = null;
		ArrayList<Vertex> Q = new ArrayList<Vertex>();
		double alt, min = 0;
		dist.put(g.find(start.name), 0.0);
		
		for (Vertex v : g.vertex) {
			if (!v.equals(start)) {
				dist.put(v, Double.POSITIVE_INFINITY);
				prev.put(v, null);
			}
			Q.add(v);
		}
		while (!Q.isEmpty()) {
			u = Q.get(0);
			min = dist.get(u);
			for (Vertex v : Q) {
				if (dist.get(v) < min) {
					u = v;
					min = dist.get(v);
				}
			}
			for (int i = 0; i < Q.size(); i++) {
				if (Q.get(i) == u) {
					Q.remove(i);
				}
			}
			for (Vertex v : u.adjacent) {
				alt = dist.get(u) + g.getWeight(u, v);
				if (alt < dist.get(v)) {
					dist.put(v, alt);
					prev.put(v, u);
				}
			}
		}
		Stack<Vertex> s = new Stack<Vertex>();
		u = dest;
		s.push(u);
		while (prev.get(u) != g.find(start.name)) {
			s.push(prev.get(u));
			u = prev.get(u);
		}
		s.push(prev.get(u));
		System.out.print("ShortestPath(" + start.name + "," + dest.name + ") : ");
		while (!s.isEmpty()) {
			System.out.print(s.pop().name + " ");
		}
		System.out.println("\nDistance from ["+start.name+"] to ["+dest.name+"] is " + dist.get(dest));
	}
}
