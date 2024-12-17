/* 
 *  Program: Prosty edytor kolorowego grafu
 *     Plik: Graph.java
 *           
 *  Klasa Graph reprezentuje graf na p³aszczyŸnie. 
 *  Klasa mo¿e byæ klas¹ bazow¹ dla klas reprezentuj¹cych 
 *  grafy modeluj¹ce wybrane zagadnienia np.: 
 *     - schemat komunikacji miejskiej,
 *     - drzewo genealogiczne,
 *     - schemat obwodu elektronicznego typu RLC,
 *     - schemat topologi sieci komputerowej
 *            
 *    Autor: Kacper Wi¹cek 259378
 *     Data: grudzieñ 2022r.
 */

package lab4.data;

import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Graph implements Serializable {

	private static final long serialVersionUID = 1L;
	private Set<Node> nodes = new HashSet();
	private Set<Edge> edges = new HashSet();
	
	public Graph() {}
	public void addNode(Node node){
		nodes.add(node);
	}

	public void removeNode(Node node) {
		Iterator<Edge> var3 = edges.iterator();

		while(true) {
			Edge tmp;
			do {
				if (!var3.hasNext()) {
					nodes.remove(node);
					return;
				}

				tmp = (Edge)var3.next();
			} while(tmp.getNode1() != node && tmp.getNode2() != node);

			var3.remove();
		}
	}
	public void addEdge(Edge edge) {edges.add(edge);}

	public void removeEdge(Edge edge) {edges.remove(edge);}

	public Node[] getNodes() {
		Node[] array = new Node[0];
		return (Node[])nodes.toArray(array);
	}

	public Edge[] getEdges() {
		Edge[] array = new Edge[0];
		return (Edge[])edges.toArray(array);
	}

	public void draw(Graphics g) {
		Iterator var3 = edges.iterator();

		while(var3.hasNext()) {
			Edge edge = (Edge)var3.next();
			edge.draw(g);
		}

		var3 = nodes.iterator();

		while(var3.hasNext()) {
			Node node = (Node)var3.next();
			node.draw(g);
		}

	}

	public static void printToFile(String file_name, Graph graph) throws Throwable {
		try {
			Throwable var2 = null;
			Object var3 = null;

			try {
				ObjectOutputStream objectOutputStream= new ObjectOutputStream(new FileOutputStream(file_name));

				try {
					objectOutputStream.writeObject(graph);
				} finally {
					if (objectOutputStream != null) {
						objectOutputStream.close();
					}

				}

			} catch (Throwable var14) {
				if (var2 == null) {
					var2 = var14;
				} else if (var2 != var14) {
					var2.addSuppressed(var14);
				}

				throw var2;
			}
		} catch (FileNotFoundException var15) {
			throw new Exception("Nie znaleziono pliku <" + file_name + ">");
		} catch (IOException var16) {
			throw new Exception("Wyst¹pi³ b³¹d przy zapisie pliku <" + file_name + ">");
		}
	}

	public static Graph readFromFile(String file_name) throws Throwable {
		try {
			Throwable var1 = null;
			Object var2 = null;

			try {
				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file_name));

				Graph var10000;
				try {
					var10000 = (Graph)objectInputStream.readObject();
				} finally {
					if (objectInputStream != null) {
						objectInputStream.close();
					}

				}

				return var10000;
			} catch (Throwable var15) {
				if (var1 == null) {
					var1 = var15;
				} else if (var1 != var15) {
					var1.addSuppressed(var15);
				}

				throw var1;
			}
		} catch (FileNotFoundException var16) {
			throw new Exception("Nie znaleziono pliku <" + file_name + ">");
		} catch (IOException var17) {
			throw new Exception("Wyst¹pi³ b³¹d przy odczycie pliku <" + file_name + ">");
		} catch (ClassNotFoundException var18) {
			throw new Exception("Nieprawid³owy format pliku <" + file_name + ">");
		}
	}

}
