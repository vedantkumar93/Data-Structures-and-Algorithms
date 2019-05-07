import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

	public static void main(String[] args) {
		Node node1 = new Node(1); 
		Node node2 = new Node(2); 
		Node node3 = new Node(3); 
		Node node4 = new Node(4); 
		Node node5 = new Node(5); 
		Node node6 = new Node(6); 
		Node node7 = new Node(7); 
		Node node8 = new Node(8); 
		Node node9 = new Node(9); 
		Node node10 = new Node(10); 
		Node nodes[] = { node1, node2, node3, node4, node5, node6, node7, node8, node9, node10 };
		int adjMatrix[][] = {{0,0,0,0,1,1,1,0,0,1},
				{0,0,1,1,0,0,1,0,0,1},
				{0,1,0,1,0,0,0,0,0,0},
				{0,1,1,0,0,0,0,1,1,0},
				{1,0,0,0,0,1,0,0,0,1},
				{1,0,0,0,1,0,0,0,0,0},
				{1,1,0,0,0,0,0,0,1,0},
				{0,0,0,1,0,0,0,0,1,0},
				{0,0,0,1,0,0,1,1,0,0},
				{1,1,0,0,1,0,0,0,0,0}};
		System.out.println("Adjacency Matrix Representation of the graph: ");

		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("First Node: " + node1.val);
		System.out.println();
		System.out.println("DFS Traversal:");
		dfsTraversal(adjMatrix, nodes, node1);
		System.out.println();
		System.out.println("BFS Traversal:");
		nodes = resetVisitedFlags(nodes);
		bfsTraversal(adjMatrix, nodes, node1);
	}

	private static Node[] resetVisitedFlags(Node[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			nodes[i].visitedFlag = false;
		}
		return nodes;
	}

	private static void bfsTraversal(int[][] adjMatrix, Node[] nodes, Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		nodes = markVisitedFlag(nodes, node);
		while (!queue.isEmpty()) {
			Node remove = queue.remove();
			System.out.print(" " + remove.val);
			List<Node> neighboringNodes = neighboringNodes(adjMatrix, nodes, remove);
			for (Node temp : neighboringNodes) {
				if (!temp.visitedFlag) {
					queue.add(temp);
					nodes = markVisitedFlag(nodes, temp);
				}
			}
		}

	}

	private static void dfsTraversal(int[][] adjMatrix, Node nodes[], Node node) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(node);
		nodes = markVisitedFlag(nodes, node);
		while (!stack.isEmpty()) {
			Node pop = stack.pop();
			System.out.print(" " + pop.val);
			List<Node> neighboringNodes = neighboringNodes(adjMatrix, nodes, pop);
			for (Node temp : neighboringNodes) {
				if (!temp.visitedFlag) {
					stack.add(temp);
					nodes = markVisitedFlag(nodes, temp);
				}
			}
		}
	}

	private static Node[] markVisitedFlag(Node[] nodes, Node node) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].val == node.val) {
				nodes[i].visitedFlag = true;
				break;
			}
		}
		return nodes;
	}

	private static List<Node> neighboringNodes(int[][] adjMatrix, Node[] nodes, Node node) {
		List<Node> neighboringNodes = new ArrayList<Node>();
		for (int i = 0; i < adjMatrix.length; i++) {
			if (i + 1 == node.val) {
				for (int j = 0; j < adjMatrix[i].length; j++) {
					if (adjMatrix[i][j] == 1) {
						for (int k = 0; k < nodes.length; k++) {
							if (j + 1 == nodes[k].val) {
								neighboringNodes.add(nodes[k]);
								break;
							}
						}
					}
				}
			}
		}
		return neighboringNodes;
	}
}

class Node {
	int val;
	boolean visitedFlag;

	Node(int val) {
		this.val = val;
	}
}
