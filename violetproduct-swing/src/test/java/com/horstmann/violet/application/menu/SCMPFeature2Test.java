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

public class SCMPFeature2Test {
	ClassDiagramGraph graph=new ClassDiagramGraph();
	IEditorPart editorPart=new EditorPart(graph);
	IGraphToolsBar graphsToolBar=new GraphToolsBar();
	
	@Test
	
	public void TestAggregation()
	{
			UMLEditorApplication.initBeanFactory();
			ManiocFramework.BeanInjector.getInjector().inject(this);
			ManiocFramework.BeanFactory.getFactory().getBean(UserPreferencesService.class);
		 	
			AddEdgeBehavior addEdge=new AddEdgeBehavior(editorPart, graphsToolBar);
			AggregationEdge e1=new AggregationEdge();
			AggregationEdge e2=new AggregationEdge();
		
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
		
			Point2D startLocation1=new Point2D.Double(100, 100);
			Point2D endLocation1=new Point2D.Double(100,400);
		
			Point2D startLocation2=new Point2D.Double(100, 400);
			Point2D endLocation2=new Point2D.Double(100, 100);
		//activeEditor.setFeature2=true;
		
			editorPart.setFeature2(true);
			assertTrue(addEdge.addEdgeAtPoints(e1, startLocation1, endLocation1));
			assertFalse(addEdge.addEdgeAtPoints(e2, startLocation2, endLocation2));
		
	}
	@Test
	public void TestComposition()
	{
		
		 	
			AddEdgeBehavior addEdge=new AddEdgeBehavior(editorPart, graphsToolBar);
			CompositionEdge e1=new CompositionEdge();
			CompositionEdge e2=new CompositionEdge();
		
			ClassNode node1 = new ClassNode();
			SingleLineText name1 = new SingleLineText();
			name1.setText("Node 1");
			node1.setName(name1);

			ClassNode node2 = new ClassNode();
			SingleLineText name2 = new SingleLineText();
			name2.setText("Node 2");
			node2.setName(name2);
		
			graph.addNode(node1, new Point2D.Double(200, 600));
			graph.addNode(node2, new Point2D.Double(100, 400));
		
			Point2D startLocation1=new Point2D.Double(200, 600);
			Point2D endLocation1=new Point2D.Double(100,400);
		
			Point2D startLocation2=new Point2D.Double(100, 400);
			Point2D endLocation2=new Point2D.Double(200, 600);
		//activeEditor.setFeature2=true;
		
			editorPart.setFeature2(true);
			assertTrue(addEdge.addEdgeAtPoints(e1, startLocation1, endLocation1));
			assertFalse(addEdge.addEdgeAtPoints(e2, startLocation2, endLocation2));
		
	}
	
}
