import java.io.*;
import java.lang.*;
import java.util.Scanner;

public class ShortestPath {

	public static void main(String[] arg) {
		BufferedReader br = null;
		int col = 0, row = -1, weight = 0;
		Graph g = new Graph();
		Vertex start, dest;
		Scanner reader = new Scanner(System.in);

		System.out
				.println("This is a program that calculate a shotrest path by Dijkstra Algorithm.");
		System.out
				.println("This program will read a graph from a file .csv and calculate.");
		System.out
				.println("User has to give the input of Path of file,Start vertex and Destination vertex.");
		System.out
				.println("---------------------------------------------------------------------------");

		while (true) {
			try {
				String sline = "", stemp = "", sword = "";

				System.out.print("Enter Path : ");
				String fpath = reader.nextLine();
				br = new BufferedReader(new FileReader(fpath));

				System.out
						.println("---------------------------------------------------------------------------");
				while ((sline = br.readLine()) != null) {
					col = 0;
					for (int i = 0; i < sline.length(); i++) {
						if (sline.charAt(i) != ',' && i != sline.length() - 1) {
							stemp += sline.charAt(i);
						} else {
							if (i == sline.length() - 1)
								stemp += sline.charAt(i);
							sword = stemp;
							stemp = "";
							System.out.print(sword + " ");
							if (isDigit(sword)) {
								weight = Integer.parseInt(sword);
								if (weight > 0) {
									Edge e = new Edge();
									e.start = g.vertex.get(row);
									e.dest = g.vertex.get(col);
									e.weight = weight;
									g.edge.add(e);
									g.vertex.get(row).adjacent.add(g.vertex
											.get(col));
								}
								col++;
							} else if (isAlpha(sword)) {
								Vertex r = new Vertex(sword);
								g.vertex.add(r);
							}

						}
					}
					row++;
					System.out.println("");
				}
				break;

			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		System.out
				.println("---------------------------------------------------------------------------");

		System.out.print("Vertex : ");
		for (Vertex v : g.vertex) {
			System.out.print(v.name + " ");
		}

		System.out.print("\nEdge : ");
		int i = 0;
		for (Edge e : g.edge) {
			if (i == 5) {
				System.out.println("");
				i = 0;
			}
			System.out.print("(" + e.start.name + "," + e.dest.name + ","
					+ e.weight + ") ");
			i++;
		}
		System.out
				.println("\n---------------------------------------------------------------------------");
		while (true) {
			System.out.print("Enter Start Vertex : ");
			start = g.find(reader.nextLine());
			System.out.print("Enter destination Vertex : ");
			dest = g.find(reader.nextLine());
			if (start != null && dest != null )
				break;
			System.out.println("Start or Destination vertex is NULL or they are same vertex.");
		}
		System.out
				.println("---------------------------------------------------------------------------");
		DijkstraAlgorithm.Dijkstra(g, start, dest);
		System.out
				.println("---------------------------------------------------------------------------");

	}

	public static boolean isAlpha(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isLetter(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isDigit(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
