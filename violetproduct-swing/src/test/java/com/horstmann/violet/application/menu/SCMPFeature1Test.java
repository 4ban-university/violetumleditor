package com.horstmann.violet.application.menu;

        import static org.junit.Assert.assertFalse;
        import static org.junit.Assert.assertTrue;

        import java.awt.geom.Point2D;

        import org.junit.Test;

        import com.horstmann.violet.UMLEditorApplication;
        import com.horstmann.violet.framework.injection.bean.ManiocFramework;
        import com.horstmann.violet.framework.userpreferences.UserPreferencesService;
        import com.horstmann.violet.product.diagram.classes.ClassDiagramGraph;
        import com.horstmann.violet.product.diagram.classes.edge.AggregationEdge;
        import com.horstmann.violet.product.diagram.classes.edge.CompositionEdge;
        import com.horstmann.violet.product.diagram.classes.node.ClassNode;
        import com.horstmann.violet.product.diagram.property.text.SingleLineText;
        import com.horstmann.violet.workspace.editorpart.EditorPart;
        import com.horstmann.violet.workspace.editorpart.IEditorPart;
        import com.horstmann.violet.workspace.editorpart.behavior.AddEdgeBehavior;
        import com.horstmann.violet.workspace.sidebar.graphtools.GraphToolsBar;
        import com.horstmann.violet.workspace.sidebar.graphtools.IGraphToolsBar;

public class SCMPFeature1Test {
    ClassDiagramGraph graph=new ClassDiagramGraph();
    IEditorPart editorPart=new EditorPart(graph);
    IGraphToolsBar graphsToolBar=new GraphToolsBar();

    @Test

    public void TestSelfDirection() {
        UMLEditorApplication.initBeanFactory();
        ManiocFramework.BeanInjector.getInjector().inject(this);
        ManiocFramework.BeanFactory.getFactory().getBean(UserPreferencesService.class);

        AddEdgeBehavior addEdge=new AddEdgeBehavior(editorPart, graphsToolBar);
        AggregationEdge connection0=new AggregationEdge();
        AggregationEdge connection1=new AggregationEdge();
        AggregationEdge connection2=new AggregationEdge();

        ClassNode node1 = new ClassNode();
        SingleLineText name1 = new SingleLineText();
        name1.setText("Node 1");
        node1.setName(name1);

        ClassNode node2 = new ClassNode();
        SingleLineText name2 = new SingleLineText();
        name2.setText("Node 2");
        node2.setName(name2);

        graph.addNode(node1, new Point2D.Double(100, 100));
        graph.addNode(node2, new Point2D.Double(100, 400));

        Point2D startLocation0=new Point2D.Double(100, 100);
        Point2D endLocation0=new Point2D.Double(110,110);

        Point2D startLocation1=new Point2D.Double(120, 120);
        Point2D endLocation1=new Point2D.Double(130,130);

        Point2D startLocation2=new Point2D.Double(100, 100);
        Point2D endLocation2=new Point2D.Double(100, 400);

        addEdge.addEdgeAtPoints(connection0, startLocation0, endLocation0);
        editorPart.setFeature1(true);

        assertFalse(addEdge.addEdgeAtPoints(connection1, startLocation1, endLocation1));
        assertTrue(addEdge.addEdgeAtPoints(connection2, startLocation2, endLocation2));

    }
}
