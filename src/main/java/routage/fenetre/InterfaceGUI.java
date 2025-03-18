package routage.fenetre;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

import routage.action.DisplayGraphButton;
import routage.action.DisplayTableButton;
import routage.action.LoadButton;

 
public class InterfaceGUI extends JFrame {

	private final Graph graph;
	private File fichierCharge;
	private JLabel status;
	private JComboBox listNodes;
	protected JButton afficherTable, afficherGraphe, charger;
	private Table table;

	public InterfaceGUI() {
		this.graph = new SingleGraph("GraphRoutage");
		this.setupUI();
	}

	/**
	 * Méthode se chargeant de mettre en forme le panel.
	 */
	public final void setupUI() {
		this.setTitle("Routing Table Generator");
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		gbc.insets = new Insets(5, 3, 5, 3);
		this.add(new JLabel("<html><big>Routing Tables Displayer</big></html>"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weightx = 1.;
		this.charger = new JButton(new LoadButton(this));
		this.add(this.charger, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 1;
		this.afficherGraphe = new JButton(new DisplayGraphButton(this));
		this.afficherGraphe.setEnabled(false);
		this.add(this.afficherGraphe, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		this.status = new JLabel("Chargé : Aucun");
		this.add(this.status, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		listNodes = new JComboBox();
		this.add(listNodes, gbc);

		gbc.gridx = 2;
		gbc.gridwidth = 1;
		this.afficherTable = new JButton(new DisplayTableButton(this));
		this.afficherTable.setEnabled(false);
		this.add(this.afficherTable, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.table = new Table();
		this.add(this.table, gbc);

		pack();
		this.setLocation(420, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void refreshComps() {
		if(fichierCharge == null) {
			this.afficherTable.setEnabled(false);
			this.afficherGraphe.setEnabled(false);
			this.status.setText("Chargé : Aucun");
		} else {
			this.afficherTable.setEnabled(true);
			this.afficherGraphe.setEnabled(true);
			this.status.setText("Chargé : " + fichierCharge.getName());
			this.listNodes.removeAllItems();
			for(Node n : graph.getNodeSet()) {
				this.listNodes.addItem(n.getId());
			}
		}
	}

	public void refreshViewer() {
		this.graph.addAttribute("ui.stylesheet", "url('src/main/style.css')");
		for(Node n:this.graph) 
			n.addAttribute("ui.label", n.getId());
		for(Edge e:this.graph.getEachEdge()) 
			e.addAttribute("ui.label", e.getAttribute("weight"));
	}

	public Graph getGraph() {
	    return graph;
	}
	public Table getTable() {
	    return table;
	}
	public JComboBox<String> getListNodes() {
	    return listNodes;
	}
	public void setFichierCharge(File fichierCharge) {
	    this.fichierCharge = fichierCharge;
	}



}
