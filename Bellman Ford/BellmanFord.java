import java.util.ArrayList;
import java.util.List;

public class BellmanFord {

	public static void main(String[] args) {
		List<Vertex> vertices = new ArrayList<Vertex>();
		Vertex v0 = new Vertex(0);
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		Vertex v7 = new Vertex(7);
		Vertex v8 = new Vertex(8);
		Vertex v9 = new Vertex(9);

		vertices.add(v0);
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);
		vertices.add(v4);
		vertices.add(v5);
		vertices.add(v6);
		vertices.add(v7);
		vertices.add(v8);
		vertices.add(v9);

		List<Edge> edges = new ArrayList<Edge>();
		edges.add(new Edge(v1, v0, 6));
		edges.add(new Edge(v2, v3, 4));
		edges.add(new Edge(v2, v4, 6));
		edges.add(new Edge(v3, v5, 2));
		edges.add(new Edge(v3, v4, 2));
		edges.add(new Edge(v3, v0, 6));
		edges.add(new Edge(v3, v1, -6));
		edges.add(new Edge(v4, v3, 3));
		edges.add(new Edge(v4, v5, 9));
		edges.add(new Edge(v4, v9, -1));
		edges.add(new Edge(v5, v7, 5));
		edges.add(new Edge(v5, v9, 3));
		edges.add(new Edge(v6, v5, 8));
		edges.add(new Edge(v7, v6, 14));
		edges.add(new Edge(v7, v8, 3));
		edges.add(new Edge(v8, v9, 2));
		edges.add(new Edge(v9, v7, 6));

		System.out.println("Test Case 1 :\n");
		System.out.println("Starting Node: " + v2.val);
		BellmanFordAlgorithm(vertices, edges, v2);

		// changing the last edge --> refer sample diagram
		edges.remove(edges.size() - 1);
		edges.add(new Edge(v9, v7, -6));

		System.out.println("__________________________________________________________________\n");
		System.out.println("Test Case 2 :\n");
		System.out.println("Starting Node: " + v2.val);
		BellmanFordAlgorithm(vertices, edges, v2);

	}

	private static void BellmanFordAlgorithm(List<Vertex> vertices, List<Edge> edges, Vertex srcVertex) {

		// Setting all distances to Infinite before iteration
		for (int i = 0; i < vertices.size(); i++) {
			vertices.get(i).distance = Integer.MAX_VALUE;
			if (vertices.get(i).val == srcVertex.val)
				vertices.get(i).distance = 0;
		}

		int temp = 0;
		boolean check = false;
		
		for (int i = 0; i < vertices.size(); i++) {
			if (i == vertices.size() - 1)
				check = false;
			for (int j = 0; j < edges.size(); j++) {
				try {
					// USED JDK 1.8 TO CHECK FOR OVERFLOW
					temp = Math.addExact(vertices.get(edges.get(j).origin.val).distance, edges.get(j).weight);
				} catch (ArithmeticException ex) {
					temp = Integer.MAX_VALUE;
				}
				if (temp < vertices.get(edges.get(j).dest.val).distance) {
					check = true;
					vertices.get(edges.get(j).dest.val).distance = temp;
					vertices.get(edges.get(j).dest.val).prev = vertices.get(edges.get(j).origin.val);
				}
			}
		}

		if (check)
			System.out.println("=======Negative Cycle Found=========\n");
		else
			System.out.println("=======No Negative Cycle Found=========\n");
		System.out.println("Node \tDistance from Source \t Previous Node");
		for (Vertex v : vertices) {
			System.out.println(v.val + "\t\t" + v.distance + "\t\t\t" + (v.prev == null ? "null" : v.prev.val));
		}

	}
}

class Vertex {

	public Vertex(int value) {
		this.val = value;
	}

	int val;
	int distance;
	Vertex prev;

}

class Edge {
	Vertex origin;
	Vertex dest;
	int weight;

	public Edge(Vertex origin, Vertex dest, int weight) {
		this.origin = origin;
		this.dest = dest;
		this.weight = weight;
	}

}
