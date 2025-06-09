package cadastroserver.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
public class Produto implements Serializable {
    @Id
    private int id;
    private String nome;
    private int quantidade;

    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }
}