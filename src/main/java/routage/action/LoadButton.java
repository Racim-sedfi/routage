package routage.action;


import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.graphstream.graph.Graph;

import routage.fenetre.InterfaceGUI;

public class LoadButton extends AbstractAction {

    private final InterfaceGUI interfaceGUI;

    public LoadButton(InterfaceGUI interfaceGUI) {
        super("Charger");
        this.interfaceGUI = interfaceGUI;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Fichiers GraphStream", "dgs", "txt"));
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                Graph graph = interfaceGUI.getGraph();
                File fichier = chooser.getSelectedFile();
                graph.read(fichier.getAbsolutePath());
                interfaceGUI.setFichierCharge(fichier);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Le fichier ne correspond pas à la syntaxe de GraphStream", "Fichier invalide", JOptionPane.ERROR_MESSAGE);
            }
            interfaceGUI.refreshComps();
            interfaceGUI.refreshViewer();
        }
    }
}
