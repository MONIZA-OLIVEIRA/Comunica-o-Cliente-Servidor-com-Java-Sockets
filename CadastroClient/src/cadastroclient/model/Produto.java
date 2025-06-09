package cadastroclient.model;

import java.io.Serializable;

public class Produto implements Serializable {
    private String nome;
    private int quantidade;

    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }
}