package cadastroserver;

import cadastroserver.controller.*;
import jakarta.persistence.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CadastroPU");
        ProdutoJpaController ctrl = new ProdutoJpaController(emf);
        UsuarioJpaController ctrlUsu = new UsuarioJpaController(emf);

        ServerSocket server = new ServerSocket(4321);
        while (true) {
            Socket client = server.accept();
            new CadastroThread(ctrl, ctrlUsu, client).start();
        }
    }
}