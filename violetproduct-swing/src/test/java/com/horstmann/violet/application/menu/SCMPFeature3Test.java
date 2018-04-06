package com.horstmann.violet.application.menu;

import com.horstmann.violet.product.diagram.classes.ClassDiagramGraph;
import com.horstmann.violet.product.diagram.classes.edge.DependencyEdge;
import com.horstmann.violet.product.diagram.classes.node.ClassNode;
import com.horstmann.violet.product.diagram.property.text.SingleLineText;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertTrue;

public class SCMPFeature3Test {

    @Test
    public void composeList() {
        ClassNode node1 = new ClassNode();
        SingleLineText name1 = new SingleLineText();
        name1.setText("Node 1");
        node1.setName(name1);

        ClassNode node2 = new ClassNode();
        SingleLineText name2 = new SingleLineText();
        name2.setText("Node 2");
        node2.setName(name2);

        ClassNode node3 = new ClassNode();
        SingleLineText name3 = new SingleLineText();
        name3.setText("Node 3");
        node3.setName(name3);

        ClassNode node4 = new ClassNode();

        DependencyEdge dependencyEdge1 = new DependencyEdge();
        DependencyEdge dependencyEdge2 = new DependencyEdge();
        DependencyEdge dependencyEdge3 = new DependencyEdge();

        ClassDiagramGraph classDiagramGraph = new ClassDiagramGraph();
        classDiagramGraph.addNode(node1, new Point2D.Double(100, 100));
        classDiagramGraph.addNode(node2, new Point2D.Double(100, 400));
        classDiagramGraph.addNode(node3, new Point2D.Double(400, 100));
        classDiagramGraph.addNode(node4, new Point2D.Double(400, 400));

        classDiagramGraph.connect(dependencyEdge1, node1, new Point2D.Double(100, 100), node2, new Point2D.Double(100, 400), new Point2D[]{});
        classDiagramGraph.connect(dependencyEdge2, node2, new Point2D.Double(100, 400), node3, new Point2D.Double(400, 100), new Point2D[]{});
        classDiagramGraph.connect(dependencyEdge3, node3, new Point2D.Double(400, 100), node2, new Point2D.Double(100, 400), new Point2D[]{});

        String actual = SCMProjectMenu.composeList(classDiagramGraph);

        assertTrue(actual.contains("Node 1"));
    }
}
