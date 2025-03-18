package routage.action;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import routage.fenetre.InterfaceGUI;

public class DisplayTableButton extends AbstractAction {

    private final InterfaceGUI interfaceGUI;

    public DisplayTableButton(InterfaceGUI interfaceGUI) {
        super("Afficher Table");
        this.interfaceGUI = interfaceGUI;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Bouton 'Afficher Table' cliqué");
        try {
            // Vérifie que l'utilisateur a bien sélectionné un nœud
            String selectedNode = (String) interfaceGUI.getListNodes().getSelectedItem();
            if (selectedNode == null) {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un nœud.", "Aucun nœud sélectionné", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Rafraîchit la table de routage avec le graphe
            interfaceGUI.getTable().refreshTable(selectedNode, interfaceGUI.getGraph());

            System.out.println("Table mise à jour !");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de l'établissement de la table de routage.", "Établissement impossible", JOptionPane.ERROR_MESSAGE);
        }
    }
}
