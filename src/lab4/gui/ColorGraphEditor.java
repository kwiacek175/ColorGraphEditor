/*
 *  Program: Prosty edytor kolorowego grafu
 *     Plik: ColorGraphEditor.java
 *
 *  Klasa ColorGraphEditor implementuje okno główne
 *  dla prostego graficznego edytora kolorowego grafu.
 *
 *    Autor: Kacper Wiącek 259378
 *     Data: grudzień 2022r.
 */

package lab4.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import lab4.data.Edge;
import lab4.data.Graph;
import lab4.data.Node;

public class ColorGraphEditor extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private static final String APP_AUTHOR = "Autor: Kacper Wiacek\n  Data: grudzien 2022";
    private static final String APP_TITLE = "Prosty edytor grafu kolorowanego";
    private static final String APP_INSTRUCTION = "                  O P I S   P R O G R A M U \n\nAktywne klawisze:\n   strzalki ==> przesuwanie calego grafu\n   SHIFT + strzalki ==> szybkie przesuwanie calego grafu\n\nponadto gdy kursor wskazuje wezel/krawedz:\n   DEL   ==> kasowanie wezla/krawedzi\n   w,r,g,b,c,m,y ==> zmiana koloru wezla/krawedzi\n\n\nOperacje myszka:\n   LPM ==> przesuwanie wezla/krawedzi/grafu\n   PPM ==> tworzenie nowego wezla\nponadto gdy kursor wskazuje wezel:\n   PPM ==> usuwanie wezla lub tworzenie krawedzi\n                    zmiana nazwy lub koloru wezela\nponadto gdy kursor wskazuje krawedz:\n   PPM ==> usuwanie krawedzi\n                    zmiana koloru krawedzi\n";
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu("File");
    private JMenu menuGraph = new JMenu("Graph");
    private JMenu menuHelp = new JMenu("Help");
    private JMenuItem menuNew = new JMenuItem("New", 78);
    private JMenuItem menuOpenFile = new JMenuItem("Open File", 79);
    private JMenuItem menuSave = new JMenuItem("Save to File", 83);
    private JMenuItem menuShowExample = new JMenuItem("Example", 88);
    private JMenuItem menuExit = new JMenuItem("Exit", 69);
    private JMenuItem menuListOfNodes = new JMenuItem("List of Nodes", 78);
    private JMenuItem menuListOfEdges = new JMenuItem("List of Edges", 69);
    private JMenuItem menuAuthor = new JMenuItem("Author", 65);
    private JMenuItem menuInstruction = new JMenuItem("Instruction", 73);
    private GraphWindowDialog panel = new GraphWindowDialog();

    public static void main(String[] args) {new ColorGraphEditor();}

    public ColorGraphEditor() {
        super(APP_TITLE);
        this.setDefaultCloseOperation(3);
        this.setSize(400, 400);
        this.setContentPane(panel);
        this.createMenu();
        this.setLocationRelativeTo((Component)null);
        this.openBuildinExample();
        this.setVisible(true);
    }
    private void showListOfNodes(Graph graph) {
        Node[] array = graph.getNodes();
        int i = 0;
        StringBuilder message = new StringBuilder("Liczba wezlow: " + array.length + "\n");
        Node[] var8 = array;
        int var7 = array.length;

        for(int var6 = 0; var6 < var7; ++var6) {
            Node node = var8[var6];
            message.append(node + "    ");
            ++i;
            if (++i % 5 == 0) {
                message.append("\n");
            }
        }

        JOptionPane.showMessageDialog(this, message, "Prosty edytor grafu kolorowanego - Lista wezlow", -1);
    }
    private void showListOfEdges(Graph graph) {
        Edge[] array = graph.getEdges();
        int i = 0;
        StringBuilder message = new StringBuilder("Liczba krawedzi: " + array.length + "\n");
        Edge[] var8 = array;
        int var7 = array.length;

        for(int var6 = 0; var6 < var7; ++var6) {
            Edge edge = var8[var6];
            message.append(edge + "    ");
            ++i;
            if (++i % 3 == 0) {
                message.append("\n");
            }
        }

        JOptionPane.showMessageDialog(this, message, "Prosty edytor grafu kolorowanego - Lista krawedzi", -1);
    }

    private void createMenu() {
        this.menuNew.addActionListener(this);
        this.menuOpenFile.addActionListener(this);
        this.menuSave.addActionListener(this);
        this.menuShowExample.addActionListener(this);
        this.menuExit.addActionListener(this);
        this.menuListOfNodes.addActionListener(this);
        this.menuListOfEdges.addActionListener(this);
        this.menuAuthor.addActionListener(this);
        this.menuInstruction.addActionListener(this);
        this.menuFile.setMnemonic(70);
        this.menuFile.add(this.menuNew);
        this.menuFile.add(this.menuOpenFile);
        this.menuFile.add(this.menuSave);
        this.menuFile.addSeparator();
        this.menuFile.add(this.menuShowExample);
        this.menuFile.addSeparator();
        this.menuFile.add(this.menuExit);
        this.menuGraph.setMnemonic(71);
        this.menuGraph.add(this.menuListOfNodes);
        this.menuGraph.add(this.menuListOfEdges);
        this.menuHelp.setMnemonic(72);
        this.menuHelp.add(this.menuInstruction);
        this.menuHelp.add(this.menuAuthor);
        this.menuBar.add(this.menuFile);
        this.menuBar.add(this.menuGraph);
        this.menuBar.add(this.menuHelp);
        this.setJMenuBar(this.menuBar);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == this.menuNew) {
            this.panel.setGraph(new Graph());
        }

        String file_name;
        if (source == this.menuOpenFile) {
            file_name = JOptionPane.showInputDialog("Podaj nazwe pliku");
            if (file_name == null ||  file_name.equals("")) {
                return;
            }

            try {
                try {
                    this.panel.setGraph(Graph.readFromFile(file_name));
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            } catch (Exception var6) {
                JOptionPane.showMessageDialog(this, var6.getMessage(), "Blad", 0);
            }
        }

        if (source == this.menuSave) {
            file_name = JOptionPane.showInputDialog("Podaj nazwe pliku");
            if (file_name == null || file_name.equals("")) {
                return;
            }

            try {
                try {
                    Graph.printToFile(file_name, this.panel.getGraph());
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            } catch (Exception var5) {
                JOptionPane.showMessageDialog(this, var5.getMessage(), "Blad", 0);
            }
        }

        if (source == this.menuShowExample) {
            this.openBuildinExample();
        }

        if (source == this.menuExit) {
            System.exit(0);
        }

        if (source == this.menuListOfNodes) {
            this.showListOfNodes(panel.getGraph());
        }

        if (source == this.menuListOfEdges) {
            this.showListOfEdges(panel.getGraph());
        }

        if (source == this.menuAuthor) {
            JOptionPane.showMessageDialog(this, APP_AUTHOR, APP_TITLE, JOptionPane.INFORMATION_MESSAGE);
        }

        if (source == this.menuInstruction) {
            JOptionPane.showMessageDialog(this, APP_INSTRUCTION, APP_TITLE, JOptionPane.PLAIN_MESSAGE);
        }
    }
    private void openBuildinExample() {
        Graph graph = new Graph();
        Node n1 = new Node(130, 70, "A", Color.GREEN);
        Node n2 = new Node(220, 220, "B", Color.RED);
        Node n3 = new Node(100, 300, "C", Color.YELLOW);
        Node n4 = new Node(300, 120);
        Node n5 = new Node(200, 120);
        Node n6 = new Node(300, 260);
        Node n7 = new Node(300, 70, "D", Color.BLUE);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addNode(n4);
        graph.addNode(n5);
        graph.addNode(n6);
        graph.addNode(n7);
        graph.addEdge(new Edge(n1, n2, Color.BLACK));
        graph.addEdge(new Edge(n2, n3, Color.CYAN));
        graph.addEdge(new Edge(n1, n3, Color.PINK));
        graph.addEdge(new Edge(n5, n6));
        graph.addEdge(new Edge(n5, n7));
        graph.addEdge(new Edge(n1, n2));
        panel.setGraph(graph);
    }
}