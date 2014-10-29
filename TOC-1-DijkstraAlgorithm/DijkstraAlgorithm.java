import java.util.*;
//this class is calculate Dijkstra Algorithm
public class DijkstraAlgorithm {
	public static void Dijkstra(Graph g, Vertex start, Vertex dest) {
		Map<Vertex, Double> dist = new HashMap<Vertex, Double>();
		Map<Vertex, Vertex> prev = new HashMap<Vertex, Vertex>();
		ArrayList<Vertex> Q = new ArrayList<Vertex>();
		Vertex u = null;
		double alt, min = 0;
		
		dist.put(g.find(start.name), 0.0);	//Add distancs from source to source = 0
		for (Vertex v : g.vertex) {		//Initialization 
			if (!v.equals(start)) {
				dist.put(v, Double.POSITIVE_INFINITY);
				prev.put(v, null);
			}
			Q.add(v);	//All vertex initially in Q
		}
		
		System.out.println("[Initialize]");	//Show a intialization process
		for(Vertex v:Q){
			System.out.println("dist["+v.name+"] = "+dist.get(v));
		}
		System.out.println("\n[Evaluate]\n==============================");
		
		while (!Q.isEmpty()) {		//Main loop
			//Find a vertex with the min distance of u from Q
			u = Q.get(0);
			min = dist.get(u);
			for (Vertex v : Q) {
				if (dist.get(v) < min) {
					u = v;
					min = dist.get(v);
				}
			}
			//Remove u from Q
			for (int i = 0; i < Q.size(); i++) {
				if (Q.get(i) == u) {
					Q.remove(i);
				}
			}
			System.out.println("Visit : "+u.name+" ,Dist["+u.name+"] = "+dist.get(u));
			//For each neighbor v of u where v hasn't been remove from Q
			for (Vertex v : u.adjacent) {
				alt = dist.get(u) + g.getWeight(u, v);
				if (alt < dist.get(v)) {	//A Shorter path to v has been found
					dist.put(v, alt);
					prev.put(v, u);
				}
			}
			//Show a visiting process
			if(!Q.isEmpty())System.out.println("Evaluate distance of remain unvisited vertexs.");
			else System.out.println("No more vertex to evaluate.");
			for(Vertex v: Q){
				System.out.print("Dist["+v.name+"] = "+dist.get(v));
				System.out.print(" --> Path is : ");
				displayPath(prev,start,v,false);	//Display path to "v" that not include v in the path 
				
			}
			System.out.println("==============================");
		}
		System.out.print("[Finished]\nShortest path is :");
		displayPath(prev,start,dest,true);	//Display path all path from start to destination
		System.out.println("Distancs from ["+start.name+"] to ["+dest.name+"] = "+dist.get(dest));
	}
	
	//Display path to from start to destination that include(or not include) destination in the path 
	public static void displayPath(Map<Vertex,Vertex> prev,Vertex start,Vertex dest,boolean includeEnd){
		String path="";
		Stack<String> st = new Stack<String>();
		if(prev.get(dest)!=null){
			if(includeEnd) st.push(dest.name);
			while(dest!=start){
				st.push(prev.get(dest).name);
				dest = prev.get(dest);
			}
			while(!st.isEmpty()){
				path = path+st.pop()+" ";
			}
		}else path = "Undefined.";
		System.out.println(path);
	}
}
