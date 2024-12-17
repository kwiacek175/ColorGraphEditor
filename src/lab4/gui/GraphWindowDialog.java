/*
 *  Program: Prosty edytor kolorowego grafu
 *     Plik: GraphWindowDialog.java
 *
 *  Klasa GraphWindowDialog implementuje pomocnicze okna dialogowe
 *  umozliwiajace utworzenie i wypelnienie danymi nowego węzła lub krawędzi
 *  oraz modyfikacje danych dla istniejących krawędzi i węzłów.
 *
 *    Autor: Kacper Wiącek 259378
 *     Data: grudzień 2022r.
 */

package lab4.gui;

import lab4.data.Edge;
import lab4.data.Node;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class GraphWindowDialog extends GraphPanel{
    private static final long serialVersionUID = 1L;
    private Color currentColor;

    public GraphWindowDialog() {this.currentColor = Color.WHITE;}

    public void mouseClicked(MouseEvent event) {
        setMouseCursor(event);
        if (event.getButton() == 1) {
            if (node2UnderCursor != null && nodeUnderCursor != null && nodeUnderCursor != node2UnderCursor) {
                String[] array = new String[]{"Black line", "Color line"};
                String message = (String)JOptionPane.showInputDialog(this, "Choose type of the new edge:", "New Edge", 3, (Icon)null, array, (Object)null);
                if (message != null) {
                    if (message.equals("Black line")) {
                        graph.addEdge(new Edge(node2UnderCursor, nodeUnderCursor));
                    }

                    if (message.equals("Color line")) {
                        changeColor(this);
                        graph.addEdge(new Edge(node2UnderCursor, nodeUnderCursor, this.currentColor));
                    }
                }

                this.repaint();
            }

            node2UnderCursor = null;
        }

        setMouseCursor(event);
    }

    public void keyTyped(KeyEvent  event) {
        char znak = event.getKeyChar();
        if (nodeUnderCursor != null) {
            if (nodeUnderCursor instanceof Node) {
                Node node = (Node) nodeUnderCursor;
                switch (znak) {
                    case 'b':
                        node.setColor(Color.BLUE);
                        break;
                    case 'c':
                        node.setColor(Color.CYAN);
                        break;
                    case 'g':
                        node.setColor(Color.GREEN);
                        break;
                    case 'm':
                        node.setColor(Color.MAGENTA);
                        break;
                    case 'r':
                        node.setColor(Color.RED);
                        break;
                    case 'w':
                        node.setColor(Color.WHITE);
                        break;
                    case 'y':
                        node.setColor(Color.YELLOW);
                }
            }

            this.repaint();
            setMouseCursor(mouseX, mouseY);
        }

        if (edgeUnderCursor != null) {
            if (edgeUnderCursor instanceof Edge) {
                Edge edge = (Edge) edgeUnderCursor;
                switch (znak) {
                    case 'b':
                        edge.setColor(Color.BLUE);
                        break;
                    case 'c':
                        edge.setColor(Color.CYAN);
                        break;
                    case 'g':
                        edge.setColor(Color.GREEN);
                        break;
                    case 'm':
                        edge.setColor(Color.MAGENTA);
                        break;
                    case 'r':
                        edge.setColor(Color.RED);
                        break;
                    case 'w':
                        edge.setColor(Color.WHITE);
                        break;
                    case 'y':
                        edge.setColor(Color.YELLOW);
                }
            }

            this.repaint();
            setMouseCursor(mouseX, mouseY);
        }
    }

        protected void createPopupMenu(MouseEvent event){
            JPopupMenu popup = new JPopupMenu();
            JMenuItem menuItem = new JMenuItem("Create new node");
            menuItem.addActionListener((a) -> {
                String[] array = new String[]{"Black point", "Color node"};
                String message = (String) JOptionPane.showInputDialog(this, "Choose type of the new node?:", "New Node", 3, (Icon) null, array, (Object) null);
                if (message != null) {
                    if (message.equals("Black point")) {
                        graph.addNode(new Node(event.getX(), event.getY()));
                    }

                    if (message.equals("Color node")) {
                        Node node = new Node(event.getX(), event.getY());
                        changeColor(this);
                        node.setColor(currentColor);
                        String name = (String)JOptionPane.showInputDialog(this, "Enter name of the new node:", "New Node", 3, (Icon)null, (Object[])null, node.getName());
                        if (name != null) {
                            node.setName(name);
                        }
                        graph.addNode(node);
                    }
                }

                this.repaint();
            });
            popup.add(menuItem);
            popup.show(event.getComponent(), event.getX(), event.getY());
        }


    protected void createPopupMenu(MouseEvent event, Node node) {
        JPopupMenu popup = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("Remove this node");
        menuItem.addActionListener((a) -> {
            graph.removeNode(node);
            this.repaint();
        });
        popup.add(menuItem);
        menuItem = new JMenuItem("Create new edge from this node");
        menuItem.addActionListener((a) -> {
            node2UnderCursor = node;
            mouseCursor = 3;
        });
        popup.add(menuItem);
        if (node instanceof Node) {
             menuItem= new JMenuItem("Change name of this node");
             menuItem.addActionListener((a) -> {
                String name = (String)JOptionPane.showInputDialog(this, "Enter new name:", "Change node name", 3, (Icon)null, (Object[])null, ((Node)node).getName());
                if (name != null) {
                    ((Node)node).setName(name);
                }

                this.repaint();
            });
            popup.add(menuItem);
            menuItem = new JMenuItem("Change color of this node");
            menuItem.addActionListener((a) -> {
                changeColor(this);
                ((Node)node).setColor(this.currentColor);
                this.repaint();
            });
            popup.add(menuItem);
        }

        popup.show(event.getComponent(), event.getX(), event.getY());
    }

    protected void createPopupMenu(MouseEvent event, Edge edge) {
        JPopupMenu popup = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("Remove this edge");
        menuItem.addActionListener((a) -> {
            graph.removeEdge(edge);
            this.repaint();
        });
        popup.add(menuItem);
        if (edge instanceof Edge) {
            menuItem = new JMenuItem("Change color of this edge");
            menuItem.addActionListener((a) -> {
                changeColor(this);
                ((Edge) edge).setColor(this.currentColor);
                this.repaint();
            });
            popup.add(menuItem);
        }

        popup.show(event.getComponent(), event.getX(), event.getY());
    }

    private void changeColor(Component component) {
        JColorChooser colorChooser = new JColorChooser(this.currentColor);
        colorChooser.setPreviewPanel(new JPanel());
        JDialog _01010100 = JColorChooser.createDialog(component, "Select color", true, colorChooser, (a) -> {
            this.currentColor = colorChooser.getColor();
            colorChooser.setVisible(false);
        }, (a) -> {
            colorChooser.setVisible(false);
        });
        _01010100.setVisible(true);
    }



}
