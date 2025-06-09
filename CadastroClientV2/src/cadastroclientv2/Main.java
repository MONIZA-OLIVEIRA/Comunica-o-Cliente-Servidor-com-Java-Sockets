package cadastroclientv2;

import cadastroclientv2.model.*;
import cadastroclientv2.ui.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 4321);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        out.writeObject("op1");
        out.writeObject("op1");

        SaidaFrame frame = new SaidaFrame();
        frame.setVisible(true);
        new ThreadClient(in, frame.texto).start();

        String cmd;
        do {
            System.out.println("Comando (L, X): ");
            cmd = reader.readLine();
            out.writeObject(cmd);
        } while (!cmd.equals("X"));

        socket.close();
    }
}