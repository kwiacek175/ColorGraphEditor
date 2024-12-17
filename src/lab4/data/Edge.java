/*
 *  Program: Prosty edytor kolorowego grafu
 *     Plik: Edge.java
 *
 *  Klasa Edge reprezentuje krawędzie grafu na płaszczyźnie.
 *  Klasa może być klasą bazową dla klas reprezentujących
 *  krawędzie grafów modelująch  wybrane zagadnienia np.:
 *     - schemat komunikacji miejskiej,
 *     - drzewo genealogiczne,
 *     - schemat obwodu elektronicznego typu RLC,
 *     - schemat topologi sieci komputerowej
 *
 *    Autor: Kacper Wiącek 259378
 *    Data: grudzień 2022r.
 */

package lab4.data;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

public class Edge implements Serializable {
    private static final long serialVersionUID = 1L;
    private Node node1;
    private Node node2;
    private Color color;

    public Edge(Node node1, Node node2) {
        this.node1 = node1;
        this.node2 = node2;
        this.color = Color.BLACK;
    }
    public Edge(Node node1, Node node2, Color color) {
        this.node1 = node1;
        this.node2 = node2;
        this.color = color;
    }
    public Node getNode1() {return node1;}
    public Node getNode2() {return node2;}

    public Color getColor() {return this.color;}
    public void setColor(Color color) { this.color = color;}

    void draw(Graphics g) {
        g.setColor(color);
        ((Graphics2D)g).setStroke(new BasicStroke(3.0F));
        g.drawLine(node1.getX(), node1.getY(), node2.getX(), node2.getY());
        ((Graphics2D)g).setStroke(new BasicStroke(1.0F));
        g.setColor(Color.BLACK);
    }

    public boolean isMouseOver(int mx, int my) {
        if ((mx <= node1.getX() || mx <= node2.getX()) && (mx >= node1.getX() || mx >= node2.getX())) {
            if (my > node1.getY() && my > node2.getY() || my < node1.getY() && my < node2.getY()) {
                return false;
            } else {
                int a = node2.getY() - node1.getY();
                int b = node1.getX() - node2.getX();
                int c = node2.getX() * node1.getY() - node1.getX() * node2.getY();
                double d = (double)Math.abs(a * mx + b * my + c) / Math.sqrt((double)(a * a + b * b));
                return d <= 2.0;
            }
        } else {
            return false;
        }
    }

    public String toString() {
        return String.format("( [" + node1+ "==>" + node2 + "]" + ", %8X)",color.getRGB());
    }
}