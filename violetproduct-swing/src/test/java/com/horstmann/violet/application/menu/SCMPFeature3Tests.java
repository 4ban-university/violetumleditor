package com.horstmann.violet.application.menu;

import com.horstmann.violet.product.diagram.classes.ClassDiagramGraph;
import com.horstmann.violet.product.diagram.classes.edge.DependencyEdge;
import com.horstmann.violet.product.diagram.classes.node.ClassNode;
import com.horstmann.violet.product.diagram.property.text.SingleLineText;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertTrue;

public class SCMPFeature3Tests {

    @Test
    public void allNodesHasNames() {
        ClassNode node_1 = new ClassNode();
        SingleLineText name_1 = new SingleLineText();
        ClassNode node_2 = new ClassNode();
        SingleLineText name_2 = new SingleLineText();
        ClassNode node_3 = new ClassNode();
        SingleLineText name_3 = new SingleLineText();
        ClassNode node_4 = new ClassNode();
        SingleLineText name_4 = new SingleLineText();
        ClassNode node_5 = new ClassNode();
        SingleLineText name_5 = new SingleLineText();

        name_1.setText("Class_1");
        name_2.setText("Class_2");
        name_3.setText("Class_3");
        name_4.setText("Class_4");
        name_5.setText("Class_5");

        node_1.setName(name_1);
        node_2.setName(name_2);
        node_3.setName(name_3);
        node_4.setName(name_4);
        node_5.setName(name_5);

        DependencyEdge connectionEdge_1 = new DependencyEdge();
        DependencyEdge connectionEdge_2 = new DependencyEdge();
        DependencyEdge connectionEdge_3 = new DependencyEdge();
        DependencyEdge connectionEdge_4 = new DependencyEdge();
        DependencyEdge connectionEdge_5 = new DependencyEdge();
        DependencyEdge connectionEdge_6 = new DependencyEdge();
        DependencyEdge connectionEdge_7 = new DependencyEdge();

        ClassDiagramGraph classDiagramGraph = new ClassDiagramGraph();

        classDiagramGraph.addNode(node_1, new Point2D.Double(0, 0));
        classDiagramGraph.addNode(node_2, new Point2D.Double(300, 0));
        classDiagramGraph.addNode(node_3, new Point2D.Double(600, 0));
        classDiagramGraph.addNode(node_4, new Point2D.Double(0, 300));
        classDiagramGraph.addNode(node_5, new Point2D.Double(300, 300));

        classDiagramGraph.connect(connectionEdge_1, node_1, new Point2D.Double(0, 0), node_2, new Point2D.Double(300, 0), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_2, node_1, new Point2D.Double(0, 0), node_4, new Point2D.Double(0, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_3, node_3, new Point2D.Double(600, 0), node_5, new Point2D.Double(300, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_4, node_3, new Point2D.Double(600, 0), node_2, new Point2D.Double(300, 0), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_5, node_4, new Point2D.Double(0, 300), node_5, new Point2D.Double(300, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_6, node_2, new Point2D.Double(300, 0), node_4, new Point2D.Double(0, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_7, node_2, new Point2D.Double(300, 0), node_5, new Point2D.Double(300, 300), new Point2D[]{});

        String actual = SCMProjectMenu.composeMap(classDiagramGraph);

        String result = "<html>" +
                "<style>table, th,td { border: 1px solid black; border-collapse: collapse; }</style>" +
                "<p>Objects: 5 Connections: 7</p>" +
                "<hr><br>" +
                "<table>" +
                "<tr><th>Names</th><th>Connections</th></tr>" +
                "<tr><td>Class_2</td><td>4</td></tr>" +
                "<tr><td>Class_1</td><td>2</td></tr>" +
                "<tr><td>Class_4</td><td>3</td></tr>" +
                "<tr><td>Class_3</td><td>2</td></tr>" +
                "<tr><td>Class_5</td><td>3</td></tr>" +
                "</table>" +
                "</html>";
        assertTrue(actual.equals(result));
    }

    @Test
    public void oneNodeWithoutName() {
        ClassNode node_1 = new ClassNode();
        SingleLineText name_1 = new SingleLineText();
        ClassNode node_2 = new ClassNode();
        SingleLineText name_2 = new SingleLineText();
        ClassNode node_3 = new ClassNode();
        SingleLineText name_3 = new SingleLineText();
        ClassNode node_4 = new ClassNode();
        SingleLineText name_4 = new SingleLineText();
        ClassNode node_5 = new ClassNode();
        SingleLineText name_5 = new SingleLineText();

        name_1.setText("Class_1");
        name_2.setText("Class_2");
        name_3.setText("Class_3");
        name_4.setText("Class_4");

        node_1.setName(name_1);
        node_2.setName(name_2);
        node_3.setName(name_3);
        node_4.setName(name_4);

        DependencyEdge connectionEdge_1 = new DependencyEdge();
        DependencyEdge connectionEdge_2 = new DependencyEdge();
        DependencyEdge connectionEdge_3 = new DependencyEdge();
        DependencyEdge connectionEdge_4 = new DependencyEdge();
        DependencyEdge connectionEdge_5 = new DependencyEdge();
        DependencyEdge connectionEdge_6 = new DependencyEdge();
        DependencyEdge connectionEdge_7 = new DependencyEdge();

        ClassDiagramGraph classDiagramGraph = new ClassDiagramGraph();

        classDiagramGraph.addNode(node_1, new Point2D.Double(0, 0));
        classDiagramGraph.addNode(node_2, new Point2D.Double(300, 0));
        classDiagramGraph.addNode(node_3, new Point2D.Double(600, 0));
        classDiagramGraph.addNode(node_4, new Point2D.Double(0, 300));
        classDiagramGraph.addNode(node_5, new Point2D.Double(300, 300));

        classDiagramGraph.connect(connectionEdge_1, node_1, new Point2D.Double(0, 0), node_2, new Point2D.Double(300, 0), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_2, node_1, new Point2D.Double(0, 0), node_4, new Point2D.Double(0, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_3, node_3, new Point2D.Double(600, 0), node_5, new Point2D.Double(300, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_4, node_3, new Point2D.Double(600, 0), node_2, new Point2D.Double(300, 0), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_5, node_4, new Point2D.Double(0, 300), node_5, new Point2D.Double(300, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_6, node_2, new Point2D.Double(300, 0), node_4, new Point2D.Double(0, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_7, node_2, new Point2D.Double(300, 0), node_5, new Point2D.Double(300, 300), new Point2D[]{});

        String actual = SCMProjectMenu.composeMap(classDiagramGraph);

        String result = "<html>" +
                "<style>table, th,td { border: 1px solid black; border-collapse: collapse; }</style>" +
                "<p>Objects: 5 Connections: 7</p>" +
                "<hr><br>" +
                "<table>" +
                "<tr><th>Names</th><th>Connections</th></tr>" +
                "<tr><td></td><td>3</td></tr>" +
                "<tr><td>Class_2</td><td>4</td></tr>" +
                "<tr><td>Class_1</td><td>2</td></tr>" +
                "<tr><td>Class_4</td><td>3</td></tr>" +
                "<tr><td>Class_3</td><td>2</td></tr>" +
                "</table>" +
                "</html>";
        assertTrue(actual.equals(result));
    }

    @Test
    public void oneNodeWithoutConnections() {
        ClassNode node_1 = new ClassNode();
        SingleLineText name_1 = new SingleLineText();
        ClassNode node_2 = new ClassNode();
        SingleLineText name_2 = new SingleLineText();
        ClassNode node_3 = new ClassNode();
        SingleLineText name_3 = new SingleLineText();
        ClassNode node_4 = new ClassNode();
        SingleLineText name_4 = new SingleLineText();
        ClassNode node_5 = new ClassNode();
        SingleLineText name_5 = new SingleLineText();

        name_1.setText("Class_1");
        name_2.setText("Class_2");
        name_3.setText("Class_3");
        name_4.setText("Class_4");
        name_5.setText("Class_5");

        node_1.setName(name_1);
        node_2.setName(name_2);
        node_3.setName(name_3);
        node_4.setName(name_4);
        node_5.setName(name_5);

        DependencyEdge connectionEdge_1 = new DependencyEdge();
        DependencyEdge connectionEdge_2 = new DependencyEdge();
        DependencyEdge connectionEdge_5 = new DependencyEdge();
        DependencyEdge connectionEdge_6 = new DependencyEdge();
        DependencyEdge connectionEdge_7 = new DependencyEdge();

        ClassDiagramGraph classDiagramGraph = new ClassDiagramGraph();

        classDiagramGraph.addNode(node_1, new Point2D.Double(0, 0));
        classDiagramGraph.addNode(node_2, new Point2D.Double(300, 0));
        classDiagramGraph.addNode(node_3, new Point2D.Double(600, 0));
        classDiagramGraph.addNode(node_4, new Point2D.Double(0, 300));
        classDiagramGraph.addNode(node_5, new Point2D.Double(300, 300));

        classDiagramGraph.connect(connectionEdge_1, node_1, new Point2D.Double(0, 0), node_2, new Point2D.Double(300, 0), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_2, node_1, new Point2D.Double(0, 0), node_4, new Point2D.Double(0, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_5, node_4, new Point2D.Double(0, 300), node_5, new Point2D.Double(300, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_6, node_2, new Point2D.Double(300, 0), node_4, new Point2D.Double(0, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_7, node_2, new Point2D.Double(300, 0), node_5, new Point2D.Double(300, 300), new Point2D[]{});

        String actual = SCMProjectMenu.composeMap(classDiagramGraph);

        String result = "<html>" +
                "<style>table, th,td { border: 1px solid black; border-collapse: collapse; }</style>" +
                "<p>Objects: 5 Connections: 5</p>" +
                "<hr><br>" +
                "<table>" +
                "<tr><th>Names</th><th>Connections</th></tr>" +
                "<tr><td>Class_2</td><td>3</td></tr>" +
                "<tr><td>Class_1</td><td>2</td></tr>" +
                "<tr><td>Class_4</td><td>3</td></tr>" +
                "<tr><td>Class_3</td><td>0</td></tr>" +
                "<tr><td>Class_5</td><td>2</td></tr>" +
                "</table>" +
                "</html>";
        assertTrue(actual.equals(result));
    }

    @Test
    public void allNodesWithousConnections() {
        ClassNode node_1 = new ClassNode();
        SingleLineText name_1 = new SingleLineText();
        ClassNode node_2 = new ClassNode();
        SingleLineText name_2 = new SingleLineText();
        ClassNode node_3 = new ClassNode();
        SingleLineText name_3 = new SingleLineText();
        ClassNode node_4 = new ClassNode();
        SingleLineText name_4 = new SingleLineText();
        ClassNode node_5 = new ClassNode();
        SingleLineText name_5 = new SingleLineText();

        name_1.setText("Class_1");
        name_2.setText("Class_2");
        name_3.setText("Class_3");
        name_4.setText("Class_4");
        name_5.setText("Class_5");

        node_1.setName(name_1);
        node_2.setName(name_2);
        node_3.setName(name_3);
        node_4.setName(name_4);
        node_5.setName(name_5);

        ClassDiagramGraph classDiagramGraph = new ClassDiagramGraph();

        classDiagramGraph.addNode(node_1, new Point2D.Double(0, 0));
        classDiagramGraph.addNode(node_2, new Point2D.Double(300, 0));
        classDiagramGraph.addNode(node_3, new Point2D.Double(600, 0));
        classDiagramGraph.addNode(node_4, new Point2D.Double(0, 300));
        classDiagramGraph.addNode(node_5, new Point2D.Double(300, 300));

        String actual = SCMProjectMenu.composeMap(classDiagramGraph);

        String result = "<html>" +
                "<style>table, th,td { border: 1px solid black; border-collapse: collapse; }</style>" +
                "<p>Objects: 5 Connections: 0</p>" +
                "<hr><br>" +
                "<table>" +
                "<tr><th>Names</th><th>Connections</th></tr>" +
                "<tr><td>Class_2</td><td>0</td></tr>" +
                "<tr><td>Class_1</td><td>0</td></tr>" +
                "<tr><td>Class_4</td><td>0</td></tr>" +
                "<tr><td>Class_3</td><td>0</td></tr>" +
                "<tr><td>Class_5</td><td>0</td></tr>" +
                "</table>" +
                "</html>";
        assertTrue(actual.equals(result));
    }
    @Test
    public void allNodesWithoutNames() {
        ClassNode node_1 = new ClassNode();
        ClassNode node_2 = new ClassNode();
        ClassNode node_3 = new ClassNode();
        ClassNode node_4 = new ClassNode();
        ClassNode node_5 = new ClassNode();

        DependencyEdge connectionEdge_1 = new DependencyEdge();
        DependencyEdge connectionEdge_2 = new DependencyEdge();
        DependencyEdge connectionEdge_3 = new DependencyEdge();
        DependencyEdge connectionEdge_4 = new DependencyEdge();
        DependencyEdge connectionEdge_5 = new DependencyEdge();
        DependencyEdge connectionEdge_6 = new DependencyEdge();
        DependencyEdge connectionEdge_7 = new DependencyEdge();

        ClassDiagramGraph classDiagramGraph = new ClassDiagramGraph();

        classDiagramGraph.addNode(node_1, new Point2D.Double(0, 0));
        classDiagramGraph.addNode(node_2, new Point2D.Double(300, 0));
        classDiagramGraph.addNode(node_3, new Point2D.Double(600, 0));
        classDiagramGraph.addNode(node_4, new Point2D.Double(0, 300));
        classDiagramGraph.addNode(node_5, new Point2D.Double(300, 300));

        classDiagramGraph.connect(connectionEdge_1, node_1, new Point2D.Double(0, 0), node_2, new Point2D.Double(300, 0), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_2, node_1, new Point2D.Double(0, 0), node_4, new Point2D.Double(0, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_3, node_3, new Point2D.Double(600, 0), node_5, new Point2D.Double(300, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_4, node_3, new Point2D.Double(600, 0), node_2, new Point2D.Double(300, 0), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_5, node_4, new Point2D.Double(0, 300), node_5, new Point2D.Double(300, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_6, node_2, new Point2D.Double(300, 0), node_4, new Point2D.Double(0, 300), new Point2D[]{});
        classDiagramGraph.connect(connectionEdge_7, node_2, new Point2D.Double(300, 0), node_5, new Point2D.Double(300, 300), new Point2D[]{});

        String actual = SCMProjectMenu.composeMap(classDiagramGraph);

        String result = "<html>" +
                "<style>table, th,td { border: 1px solid black; border-collapse: collapse; }</style>" +
                "<p>Objects: 5 Connections: 7</p>" +
                "<hr><br>" +
                "<table>" +
                "<tr><th>Names</th><th>Connections</th></tr>" +
                "<tr><td></td><td>2</td></tr>" +
                "</table>" +
                "</html>";
        assertTrue(actual.equals(result));
    }
}
