package org.osmsurround.ra.traverse;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.osmsurround.ra.TestBase;
import org.osmsurround.ra.TestUtils;
import org.osmsurround.ra.context.AnalyzerContext;
import org.osmsurround.ra.data.Node;
import org.osmsurround.ra.export.Section;
import org.osmsurround.ra.export.SectionContainer;
import org.osmsurround.ra.graph.Graph;
import org.osmsurround.ra.graph.IntersectionNode;
import org.osmsurround.ra.segment.ConnectableSegment;
import org.springframework.beans.factory.annotation.Autowired;

public class TraverseServiceTest extends TestBase {

	@Autowired
	private TraverseService traverseService;

	@Test
	public void testTraverse() throws Exception {

		long relationId = TestUtils.RELATION_12320_NECKARTAL_WEG;

		AnalyzerContext analyzerContext = helperService.createGraphContext(relationId);

		Graph intersectionWeb = analyzerContext.getGraphs().get(0);

		Iterator<IntersectionNode> it = intersectionWeb.getLeaves().iterator();

		IntersectionNode startNode = it.next();
		IntersectionNode endNode = it.next();

		List<Node> traverse = traverseService.traverse(intersectionWeb, startNode, endNode);

		List<Section> sections = new ArrayList<Section>();
		SectionContainer sectionContainer = new SectionContainer("test");
		sectionContainer.addCoordinates(traverse);
		sections.add(sectionContainer);

		helperService.exportSimple(sections, relationId);
	}

	@Test
	public void testFillInNodes() throws Exception {
		List<Node> list = TestUtils.asNodes(1, 3, 1);
		List<ConnectableSegment> segments = TestUtils
				.asSegments(TestUtils.asNodes(1, 2, 3), TestUtils.asNodes(3, 4, 1));

		List<Node> nodes = traverseService.fillInNodes(list, segments);

		for (int x = 1; x <= 4; x++)
			assertTrue("should contain node id: " + x, nodes.contains(TestUtils.getNode(x)));

	}

}
