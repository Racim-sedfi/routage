package routage.action;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import routage.fenetre.InterfaceGUI;

public class DisplayGraphButton extends AbstractAction {

    private final InterfaceGUI interfaceGUI;

    public DisplayGraphButton(InterfaceGUI interfaceGUI) {
        super("Afficher");
        this.interfaceGUI = interfaceGUI;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Bouton 'Afficher Graphe' cliqué");

        if (interfaceGUI.getGraph().getNodeCount() == 0) {
            JOptionPane.showMessageDialog(null, "Aucun graphe chargé.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            interfaceGUI.getGraph().display();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur lors de l'affichage du graphe.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
