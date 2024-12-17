/*
 *  Program: Prosty edytor kolorowego grafu
 *     Plik: Node.java
 *
 *  Klasa Node reprezentuje węzły grafu na płaszczyźnie.
 *  Klasa może być klasą bazową dla klas reprezentujących
 *  węzły grafów modelująch  wybrane zagadnienia np.:
 *     - schemat komunikacji miejskiej,
 *     - drzewo genealogiczne,
 *     - schemat obwodu elektronicznego typu RLC,
 *     - schemat topologi sieci komputerowej
 *
 *    Autor: Kacper Wiącek 259378
 *    Data: grudzień 2022r.
 */

package lab4.data;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Node implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int r = 20;
    private static final Font font = new Font("SansSerif", 1, 16);
    private int x;
    private int y;
    private String name;
    private Color color;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
        this.name = "";
        this.color = Color.BLACK;
    }
    public Node(int x, int y, String name, Color color) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() { return color;}

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean isMouseOver(int mx, int my) {
        return (x - mx) * (x - mx) + (y - my) * (y - my) <= r*r;
    }
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - r, y - r, 2*r, 2*r);
        g.setColor(Color.BLACK);
        g.drawOval(x - r, y - r, 2*r, 2*r);
        g.setFont(font);
        FontRenderContext fontRenderContext = ((Graphics2D)g).getFontRenderContext();
        Rectangle2D rectangle2D = font.getStringBounds(name, fontRenderContext);
        g.drawString(name, x - (int)rectangle2D.getWidth() / 2, y + (int)rectangle2D.getHeight() / 4);
    }

    public String toString() {
        return String.format("%s(%d, %d, %8X)", name, x, y, color.getRGB());
    }
}