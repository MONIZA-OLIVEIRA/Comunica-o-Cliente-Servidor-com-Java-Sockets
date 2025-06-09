package cadastroserver;

import cadastroserver.controller.*;
import cadastroserver.model.*;
import java.io.*;
import java.net.*;
import java.util.List;

public class CadastroThread extends Thread {
    private ProdutoJpaController ctrl;
    private UsuarioJpaController ctrlUsu;
    private Socket socket;

    public CadastroThread(ProdutoJpaController ctrl, UsuarioJpaController ctrlUsu, Socket socket) {
        this.ctrl = ctrl;
        this.ctrlUsu = ctrlUsu;
        this.socket = socket;
    }

    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            String login = (String) in.readObject();
            String senha = (String) in.readObject();
            Usuario user = ctrlUsu.findUsuario(login, senha);

            if (user == null) {
                socket.close();
                return;
            }

            while (true) {
                String comando = (String) in.readObject();
                if (comando.equals("L")) {
                    List<Produto> produtos = ctrl.findProdutos();
                    out.writeObject(produtos);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}