package cadastroclientv2;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class ThreadClient extends Thread {
    private ObjectInputStream in;
    private JTextArea texto;

    public ThreadClient(ObjectInputStream in, JTextArea texto) {
        this.in = in;
        this.texto = texto;
    }

    public void run() {
        try {
            while (true) {
                Object obj = in.readObject();
                SwingUtilities.invokeLater(() -> {
                    if (obj instanceof String) {
                        texto.append((String) obj + "\n");
                    } else if (obj instanceof List) {
                        List<?> list = (List<?>) obj;
                        for (Object item : list) {
                            texto.append(item.toString() + "\n");
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}