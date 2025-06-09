package cadastroserver.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
public class Usuario implements Serializable {
    @Id
    private int id;
    private String login;
    private String senha;

    public String getLogin() { return login; }
    public String getSenha() { return senha; }
}