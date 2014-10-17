import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class DijkstaAlgorithm {
	public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
      	vertexQueue.add(source);

	while (!vertexQueue.isEmpty()) {
	    Vertex u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge e : u.adjacent)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
		if (distanceThroughU < v.minDistance) {
		    vertexQueue.remove(v);
		    v.minDistance = distanceThroughU ;
		    v.previous = u;
		    vertexQueue.add(v);
		}
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }
    
    
    public static void main(String[] args)
    {
    	Vertex vA = new Vertex("a");
        Vertex vB = new Vertex("b");
        Vertex vC = new Vertex("c");
        Vertex vD = new Vertex("d");
        Vertex vE = new Vertex("e");
        Vertex vF = new Vertex("f");
        Vertex vG = new Vertex("g");
        Vertex vH = new Vertex("h");
        Vertex vI = new Vertex("i");
        Vertex vJ = new Vertex("j");
        Vertex vK = new Vertex("k");
        Vertex vZ = new Vertex("Z");
        
        vA.adjacent = new Edge[]{new Edge(vB,3),new Edge(vC,8),new Edge(vG,7),new Edge(vK,2)};
        vB.adjacent = new Edge[]{new Edge(vE,4),new Edge(vF,5),new Edge(vD,1)};
        vC.adjacent = new Edge[]{new Edge(vA,8),new Edge(vE,3)};
        vD.adjacent = new Edge[]{new Edge(vB,1),new Edge(vG,2),new Edge(vF,7),new Edge(vJ,2)};
        vE.adjacent = new Edge[]{new Edge(vB,4),new Edge(vF,1)};
        vF.adjacent = new Edge[]{new Edge(vB,5),new Edge(vE,1),new Edge(vD,7),new Edge(vZ,2)};
        vG.adjacent = new Edge[]{new Edge(vA,7),new Edge(vD,2),new Edge(vK,3)};
        vH.adjacent = new Edge[]{new Edge(vK,4),new Edge(vI,7)};
        vI.adjacent = new Edge[]{new Edge(vH,7),new Edge(vJ,4),new Edge(vZ,3)};
        vJ.adjacent = new Edge[]{new Edge(vD,2),new Edge(vI,4)};
        vK.adjacent = new Edge[]{new Edge(vA,2),new Edge(vG,3),new Edge(vH,4)};
        vZ.adjacent = new Edge[]{new Edge(vF,2),new Edge(vI,3)};
        
        System.out.println("Done");
        //Vertex[] ver = { vA,vB,vC,vD,vE,vF,vG,vH,vI,vJ,vK,vZ};
        computePaths(vA);
       	List<Vertex> path = getShortestPathTo(vZ);
        System.out.println("Path: " + path);
        
        
    }
    
}
