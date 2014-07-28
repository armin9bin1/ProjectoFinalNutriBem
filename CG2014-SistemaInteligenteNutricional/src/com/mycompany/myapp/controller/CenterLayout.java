
package com.mycompany.myapp.controller;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;

/**
 *
 * @author Armindo Binje
 */
public class CenterLayout extends Layout{
    public void layoutContainer(Container parent) {
        int components = parent.getComponentCount();
        Style parentStyle = parent.getStyle();
        int centerPos = parent.getLayoutWidth() / 2 +
        parentStyle.getMargin(Component.LEFT);
        int y = parentStyle.getMargin(Component.TOP);
        for(int iter = 0 ; iter < components ; iter++) {
            Component current = parent.getComponentAt(iter);
            Dimension d = current.getPreferredSize();
            current.setSize(d);
            current.setX(centerPos - d.getWidth() / 2);
            Style currentStyle = current.getStyle();
            y += currentStyle.getMargin(Component.TOP);
            current.setY(y);
            y += d.getHeight() + currentStyle.getMargin(Component.BOTTOM);
        }
    }
    
    public Dimension getPreferredSize(Container parent) {
        int components = parent.getComponentCount();
        Style parentStyle = parent.getStyle();
        int height = parentStyle.getMargin(Component.TOP) +
        parentStyle.getMargin(Component.BOTTOM);
        int marginX = parentStyle.getMargin(Component.RIGHT) +
        parentStyle.getMargin(Component.LEFT);
        int width = marginX;
        for(int iter = 0 ; iter < components ; iter++) {
            Component current = parent.getComponentAt(iter);
            Dimension d = current.getPreferredSize();
            Style currentStyle = current.getStyle();
            width = Math.max(d.getWidth() + marginX +
            currentStyle.getMargin(Component.RIGHT)
            + currentStyle.getMargin(Component.LEFT), width);
            height += currentStyle.getMargin(Component.TOP) + d.getHeight() +
            currentStyle.getMargin(Component.BOTTOM);
        }
        Dimension size = new Dimension(width, height);
        return size;
    }
    
}
