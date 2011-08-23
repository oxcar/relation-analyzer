package org.osmsurround.ra.export;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.osmsurround.ra.data.Node;
import org.osmsurround.ra.web.IntersectionNode;

public class SingleRouteTraverser {

	private List<Node> nodes = new ArrayList<Node>();
	private Collection<IntersectionNode> visitedNodes = new HashSet<IntersectionNode>();
	private IntersectionNode endNode;

	public SingleRouteTraverser(IntersectionNode startNode, IntersectionNode endNode) {
		this.endNode = endNode;
		traverseNodes(startNode);
	}

	public List<Node> getNodes() {
		return nodes;
	}

	private void traverseNodes(IntersectionNode startNode) {
		//		nodes.add(startNode.getNode());
		//		while (!startNode.equals(endNode)) {
		//			visitedNodes.add(startNode);
		//
		//			Iterator<Edge> edgeIterator = startNode.getEdgesIterator();
		//
		//			Edge edge = edgeIterator.next();
		//			IntersectionNode nextNode = edge.getNextNode(startNode);
		//
		//			while (visitedNodes.contains(nextNode)) {
		//				if (edgeIterator.hasNext()) {
		//					edge = edgeIterator.next();
		//					nextNode = edge.getNextNode(startNode);
		//				}
		//				else
		//					throw new AnalyzerException("No way to go. All nodes visited before.");
		//			}
		//
		//			nodes.addAll(edge.getNodesAfterNode(startNode.getNode()));
		//			startNode = nextNode;
		//		}
	}
}
