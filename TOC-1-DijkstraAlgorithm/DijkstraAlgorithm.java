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
		System.out.println("[Initialize]");
		for(Vertex v:Q){
			System.out.println("dist["+v.name+"] = "+dist.get(v));
		}
		System.out.println("\n[Evaluate]\n==============================");
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
			System.out.println("Visit : "+u.name+" ,Dist["+u.name+"] = "+dist.get(u));
			for (Vertex v : u.adjacent) {
				alt = dist.get(u) + g.getWeight(u, v);
				if (alt < dist.get(v)) {
					dist.put(v, alt);
					prev.put(v, u);
				}
			}
			if(!Q.isEmpty())System.out.println("Evaluate distance of remain unvisited vertexs.");
			else System.out.println("No more vertex to evaluate.");
			for(Vertex v: Q){
				System.out.print("Dist["+v.name+"] = "+dist.get(v));
				System.out.print(" --> Path is : ");
				displayPath(prev,start,v,false);
				
			}
			System.out.println("==============================");
		}
		System.out.print("[Finished]\nShortest path is :");
		displayPath(prev,start,dest,true);
		System.out.println("Distancs from ["+start.name+"] to ["+dest.name+"] = "+dist.get(dest));
	}
	
	public static void displayPath(Map<Vertex,Vertex> prev,Vertex start,Vertex v,boolean end){
		String path="";
		Stack<String> st = new Stack<String>();
		if(prev.get(v)!=null){
			if(end) st.push(v.name);
			while(v!=start){
				st.push(prev.get(v).name);
				v = prev.get(v);
			}
			while(!st.isEmpty()){
				path = path+st.pop()+" ";
			}
		}else path = "Undefined.";
		System.out.println(path);
	}
}
