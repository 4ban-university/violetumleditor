package com.horstmann.violet.product.diagram.classes.nodes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import com.horstmann.violet.product.diagram.abstracts.property.string.LineText;
import com.horstmann.violet.product.diagram.abstracts.property.string.decorator.LargeSizeDecorator;
import com.horstmann.violet.product.diagram.abstracts.property.string.decorator.OneLineString;
import com.horstmann.violet.product.diagram.abstracts.property.string.decorator.RemoveSentenceDecorator;
import com.horstmann.violet.product.diagram.abstracts.property.string.decorator.UnderlineDecorator;
import com.horstmann.violet.product.diagram.abstracts.node.INode;
import com.horstmann.violet.product.diagram.abstracts.node.RectangularNode;
import com.horstmann.violet.product.diagram.abstracts.property.string.MultiLineText;
import com.horstmann.violet.product.diagram.abstracts.property.string.SingleLineText;
import com.horstmann.violet.product.diagram.common.PointNode;

/**
 * A class node_old in a class diagram.
 */
public class ClassNode extends RectangularNode
{
    /**
     * Construct a class node_old with a default size
     */
    public ClassNode()
    {
        name = new SingleLineText(new LineText.Converter(){
            @Override
            public OneLineString toLineString(String text)
            {
                return new LargeSizeDecorator(new OneLineString(text));
            }
        });
//        name.setAlignment(MultiLineText.CENTER);

        LineText.Converter converter = new LineText.Converter(){
            @Override
            public OneLineString toLineString(String text)
            {
                OneLineString lineString = new OneLineString(text);

                if(lineString.contains("<<static>>"))
                {
                    lineString = new UnderlineDecorator(new RemoveSentenceDecorator(lineString, "<<static>>"));
                }
                return lineString;
            }
        };

        attributes = new MultiLineText(converter);
        methods = new MultiLineText(converter);
    }
    
    private Rectangle2D getTopRectangleBounds() {
        Rectangle2D globalBounds = new Rectangle2D.Double(0, 0, 0, 0);
        Rectangle2D nameBounds = name.getBounds();
        globalBounds.add(nameBounds);
        boolean isMethodsEmpty = (methods.getText().length() == 0);
        boolean isAttributesEmpty = (attributes.getText().length() == 0);
        double defaultHeight = DEFAULT_HEIGHT;
        if (!isMethodsEmpty || !isAttributesEmpty) {
            defaultHeight = DEFAULT_COMPARTMENT_HEIGHT;
        }
        globalBounds.add(new Rectangle2D.Double(0, 0, DEFAULT_WIDTH, defaultHeight));
        Point2D currentLocation = getLocation();
        double x = currentLocation.getX();
        double y = currentLocation.getY();
        double w = globalBounds.getWidth();
        double h = globalBounds.getHeight();
        globalBounds.setFrame(x, y, w, h);
        Rectangle2D snappedBounds = getGraph().getGridSticker().snap(globalBounds);
        return snappedBounds;
    }
    
    private Rectangle2D getMiddleRectangleBounds() {
        Rectangle2D globalBounds = new Rectangle2D.Double(0, 0, 0, 0);
        Rectangle2D attributesBounds = attributes.getBounds();
        globalBounds.add(attributesBounds);
        boolean isMethodsEmpty = (methods.getText().length() == 0);
        boolean isAttributesEmpty = (attributes.getText().length() == 0);
        if (!isMethodsEmpty || !isAttributesEmpty) {
            globalBounds.add(new Rectangle2D.Double(0, 0, DEFAULT_WIDTH, DEFAULT_COMPARTMENT_HEIGHT));
        }
        Rectangle2D topBounds = getTopRectangleBounds();
        double x = topBounds.getX();
        double y = topBounds.getMaxY();
        double w = globalBounds.getWidth();
        double h = globalBounds.getHeight();
        globalBounds.setFrame(x, y, w, h);
        Rectangle2D snappedBounds = getGraph().getGridSticker().snap(globalBounds);
        return snappedBounds;
    }
    
    private Rectangle2D getBottomRectangleBounds() {
        Rectangle2D globalBounds = new Rectangle2D.Double(0, 0, 0, 0);
        Rectangle2D methodsBounds = methods.getBounds();
        globalBounds.add(methodsBounds);
        boolean isMethodsEmpty = (methods.getText().length() == 0);
        boolean isAttributesEmpty = (attributes.getText().length() == 0);
        if (!isMethodsEmpty || !isAttributesEmpty) {
            globalBounds.add(new Rectangle2D.Double(0, 0, DEFAULT_WIDTH, DEFAULT_COMPARTMENT_HEIGHT));
        }
        Rectangle2D middleBounds = getMiddleRectangleBounds();
        double x = middleBounds.getX();
        double y = middleBounds.getMaxY();
        double w = globalBounds.getWidth();
        double h = globalBounds.getHeight();
        globalBounds.setFrame(x, y, w, h);
        Rectangle2D snappedBounds = getGraph().getGridSticker().snap(globalBounds);
        return snappedBounds;
    }

    @Override
    public Rectangle2D getBounds()
    {
        Rectangle2D top = getTopRectangleBounds();
        Rectangle2D mid = getMiddleRectangleBounds();
        Rectangle2D bot = getBottomRectangleBounds();
        top.add(mid);
        top.add(bot);
        Rectangle2D snappedBounds = getGraph().getGridSticker().snap(top);
        return snappedBounds;
    }

    @Override
    public void draw(Graphics2D g2)
    {
        // Backup current color;
        Color oldColor = g2.getColor();
        // Translate g2 if node_old has parent
        Point2D nodeLocationOnGraph = getLocationOnGraph();
        Point2D nodeLocation = getLocation();
        Point2D g2Location = new Point2D.Double(nodeLocationOnGraph.getX() - nodeLocation.getX(), nodeLocationOnGraph.getY() - nodeLocation.getY());
        g2.translate(g2Location.getX(), g2Location.getY());
        // Perform drawing
        super.draw(g2);
        Rectangle2D currentBounds = getBounds();
        Rectangle2D topBounds = getTopRectangleBounds();
        Rectangle2D midBounds = getMiddleRectangleBounds(); 
        Rectangle2D bottomBounds = getBottomRectangleBounds();
        if (topBounds.getWidth() < currentBounds.getWidth())
        {
        	// We need to re-center the topBounds - only do so if really required to avoid race conditions
        	topBounds.setRect(topBounds.getX(), topBounds.getY(), currentBounds.getWidth(), topBounds.getHeight());
        }
        g2.setColor(getBackgroundColor());
        g2.fill(currentBounds);
        g2.setColor(getBorderColor());
        g2.draw(currentBounds);
        g2.drawLine((int) topBounds.getX(),(int) topBounds.getMaxY(),(int) currentBounds.getMaxX(),(int) topBounds.getMaxY());
        g2.drawLine((int) bottomBounds.getX(),(int) bottomBounds.getY(),(int) currentBounds.getMaxX(),(int) bottomBounds.getY());
        g2.setColor(getTextColor());
        name.draw(g2, topBounds);
        attributes.draw(g2, midBounds);
        methods.draw(g2, bottomBounds);
        // Restore g2 original location
        g2.translate(-g2Location.getX(), -g2Location.getY());
        // Restore first color
        g2.setColor(oldColor);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.horstmann.violet.framework.Node#addNode(com.horstmann.violet.framework.Node, java.awt.geom.Point2D)
     */
    public boolean addChild(INode n, Point2D p)
    {
        // TODO : where is it added?
        if (n instanceof PointNode)
        {
            return true;
        }
        return false;
    }

    /**
     * Sets the name property value.
     * 
     * @param newValue the class name
     */
    public void setName(SingleLineText newValue)
    {
        name.setText(newValue.getText());
    }

    /**
     * Gets the name property value.
     * 
     * @return the class name
     */
    public SingleLineText getName()
    {
        return name;
    }

    /**
     * Sets the attributes property value.
     * 
     * @param newValue the attributes of this class
     */
    public void setAttributes(MultiLineText newValue)
    {
        attributes = newValue;
    }

    /**
     * Gets the attributes property value.
     * 
     * @return the attributes of this class
     */
    public MultiLineText getAttributes()
    {
        return attributes;
    }

    /**
     * Sets the methods property value.
     * 
     * @param newValue the methods of this class
     */
    public void setMethods(MultiLineText newValue)
    {
        methods = newValue;
    }

    /**
     * Gets the methods property value.
     * 
     * @return the methods of this class
     */
    public MultiLineText getMethods()
    {
        return methods;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.horstmann.violet.product.diagram.abstracts.RectangularNode#clone()
     */
    public ClassNode clone()
    {
        ClassNode cloned = (ClassNode) super.clone();
        cloned.name = (SingleLineText) name.clone();
        cloned.methods = (MultiLineText) methods.clone();
        cloned.attributes = (MultiLineText) attributes.clone();
        return cloned;
    }


    private SingleLineText name;
    private MultiLineText attributes;
    private MultiLineText methods;

    private static int DEFAULT_COMPARTMENT_HEIGHT = 20;
    private static int DEFAULT_WIDTH = 100;
    private static int DEFAULT_HEIGHT = 60;

}
