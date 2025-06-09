package cadastroclientv2.ui;

import javax.swing.*;

public class SaidaFrame extends JDialog {
    public JTextArea texto = new JTextArea();

    public SaidaFrame() {
        setBounds(100, 100, 400, 300);
        setModal(false);
        add(texto);
    }
}