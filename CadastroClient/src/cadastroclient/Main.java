package cadastroclient;

import cadastroclient.model.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 4321);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        out.writeObject("op1");
        out.writeObject("op1");

        out.writeObject("L");

        List<Produto> produtos = (List<Produto>) in.readObject();
        for (Produto p : produtos) {
            System.out.println("Produto: " + p.getNome());
        }

        socket.close();
    }
}