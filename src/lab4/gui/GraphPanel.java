/* 
 *  Program: Prosty edytor kolorowego grafu
 *     Plik: GraphPanel.java
 *           
 *  Klasa GraphPanel implementuje podstawowe funkcjonalności
 *  graficznego edytora grafu nieskierowanego.
 *  Klasa umożliwia:
 *     - rysowanie grafu w oknie,
 *     - obsługę zdarzeń generowanych przez myszkę,
 *     - tworzenie i obsługę menu kontekstowych
 *       umożliwiających wykonywanie operacji edycyjnych.
 *            
 *    Autor: Kacper Wiącek 259378
 *     Data: grudzień 2022r.
 */

package lab4.gui;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import lab4.data.Edge;
import lab4.data.Graph;
import lab4.data.Node;

public class GraphPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	protected Graph graph;
	protected int mouseX = 0;
	protected int mouseY = 0;
	private boolean mouseButtonLeft = false;
	@SuppressWarnings("unused")
	private boolean mouseButtonRigth = false;
	protected int mouseCursor = Cursor.DEFAULT_CURSOR;
	protected Node nodeUnderCursor = null;
	protected Edge edgeUnderCursor = null;
	protected Node node2UnderCursor = null;
	public GraphPanel() {
		this.addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	    setFocusable(true);
	}
	public Graph getGraph() {return graph;}
	
	public void setGraph(Graph graph) {
		this.graph = graph;
		nodeUnderCursor = null;
		node2UnderCursor = null;
		edgeUnderCursor = null;
		this.setCursor(Cursor.getDefaultCursor());
		this.repaint();
	}

	private void moveNode(int x, int y, Node node){
		node.setX(node.getX() + x);
		node.setY(node.getY() + y);
	}

	private void moveEdge(int x, int y, Edge edge){
		moveNode(x,y,edge.getNode1());
		moveNode(x,y,edge.getNode2());
	}

	private void moveGraph(int x, int y){
		Node[] var6;
		int var5 = (var6 = graph.getNodes()).length;

		for(int var4 = 0; var4 < var5; ++var4) {
			Node node = var6[var4];
			moveNode(x,y,node);
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (graph != null) {
			graph.draw(g);
		}
	}

	private Node findNode(int mx, int my){
		Node[] var6;
		int var5 = (var6 = graph.getNodes()).length;

		for(int var4 = 0; var4 < var5; ++var4) {
			Node node = var6[var4];
			if(node.isMouseOver(mx,my)) {
				return node;
			}
		}
		return null;
	}

	private Node findNode(MouseEvent event) {return findNode(event.getX(),event.getY());}

	private Edge findEdge(MouseEvent event) {
		Edge[] var5;
		int var4 = (var5 = graph.getEdges()).length;

		for(int var3 = 0; var3 < var4; ++var3) {
			Edge edge = var5[var3];
			if (edge.isMouseOver(event.getX(), event.getY())) {
				return edge;
			}
		}
		return null;
	}

	private Edge findEdge(int mx, int my) {
		Edge[] var6;
		int var5 = (var6 = graph.getEdges()).length;

		for(int var4 = 0; var4 < var5; ++var4) {
			Edge edge = var6[var4];
			if (edge.isMouseOver(mx, my)) {
				return edge;
			}
		}
		return null;
	}

	protected void setMouseCursor(int mx, int my) {
		nodeUnderCursor = findNode(mx, my);
		edgeUnderCursor = findEdge(mx, my);
		if (nodeUnderCursor != null) {
			mouseCursor = 12;
		} else if (node2UnderCursor != null) {
			mouseCursor = 3;
		} else if (edgeUnderCursor != null) {
			mouseCursor = 1;
		} else if (mouseButtonLeft) {
			mouseCursor = 13;
		} else {
			mouseCursor = 0;
		}

		this.setCursor(Cursor.getPredefinedCursor(mouseCursor));
		mouseX = mx;
		mouseY = my;
	}

	protected void setMouseCursor(MouseEvent event) {
		nodeUnderCursor = findNode(event);
		edgeUnderCursor = findEdge(event);
		if (nodeUnderCursor != null) {
			mouseCursor = 12;
		} else if (node2UnderCursor != null) {
			mouseCursor = 3;
		} else if (edgeUnderCursor != null) {
			mouseCursor = 1;
		} else if (mouseButtonLeft) {
			mouseCursor = 13;
		} else {
			mouseCursor = 0;
		}

		this.setCursor(Cursor.getPredefinedCursor(mouseCursor));
		mouseX = event.getX();
		mouseY = event.getY();
	}

	public void mouseDragged(MouseEvent event) {
		if (mouseButtonLeft) {
			if (nodeUnderCursor != null) {
				moveNode(event.getX() - mouseX, event.getY() - mouseY, nodeUnderCursor);
			} else if (edgeUnderCursor != null) {
				moveEdge(event.getX() - mouseX, event.getY() - mouseY, edgeUnderCursor);
			} else {
				moveGraph(event.getX() - mouseX,  event.getY() - mouseY);
			}
		}

		mouseX = event.getX();
		mouseY = event.getY();
		this.repaint();
	}

	public void mouseMoved(MouseEvent event) {
		setMouseCursor(event);
	}

	public void mouseClicked(MouseEvent event) {
		setMouseCursor(event);
		if (event.getButton() == 1) {
			if (node2UnderCursor != null && nodeUnderCursor != null && nodeUnderCursor != node2UnderCursor) {
				graph.addEdge(new Edge(node2UnderCursor, nodeUnderCursor));
				this.repaint();
			}

			node2UnderCursor = null;
		}

		setMouseCursor(event);
	}

	public void mouseEntered(MouseEvent event) {}

	public void mouseExited(MouseEvent event) {}

	public void mousePressed(MouseEvent event) {
		if (event.getButton() == 1) {
			mouseButtonLeft = true;
		}

		if (event.getButton() == 3) {
			mouseButtonRigth = true;
		}

		setMouseCursor(event);
	}

	public void mouseReleased(MouseEvent event) {
		if (event.getButton() == 1) {
			mouseButtonLeft = false;
		}

		if (event.getButton() == 3) {
			mouseButtonRigth = false;
		}

		setMouseCursor(event);
		if (node2UnderCursor == null) {
			if (event.getButton() == 3) {
				if (nodeUnderCursor != null) {
					createPopupMenu(event, nodeUnderCursor);
				} else if (edgeUnderCursor != null) {
					createPopupMenu(event, edgeUnderCursor);
				} else {
					createPopupMenu(event);
				}
			}

		}
	}

	public void keyPressed(KeyEvent event) {
		byte dist;
		if (event.isShiftDown()) {
			dist = 10;
		} else {
			dist = 1;
		}

		switch (event.getKeyCode()) {
			case 37:
				moveGraph(-dist, 0);
				break;
			case 38:
				moveGraph(0, -dist);
				break;
			case 39:
				moveGraph(dist, 0);
				break;
			case 40:
				moveGraph(0, dist);
				break;
			case 127:
				if (nodeUnderCursor != null) {
					graph.removeNode(nodeUnderCursor);
					nodeUnderCursor = null;
				}

				if (edgeUnderCursor != null) {
					graph.removeEdge(edgeUnderCursor);
					edgeUnderCursor = null;
				}
		}

		this.repaint();
		setMouseCursor(mouseX, mouseY);
	}

	public void keyReleased(KeyEvent event) {}

	public void keyTyped(KeyEvent event) {}

	protected void createPopupMenu(MouseEvent event) {
		JPopupMenu popup = new JPopupMenu();
		JMenuItem menuItem = new JMenuItem("Create new node");
		menuItem.addActionListener((a) -> {
			graph.addNode(new Node(event.getX(), event.getY()));
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
			 mouseCursor= 3;
		});
		popup.add(menuItem);
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
		popup.show(event.getComponent(), event.getX(), event.getY());
	}
}
