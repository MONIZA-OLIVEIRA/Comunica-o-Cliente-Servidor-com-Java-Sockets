package cadastroserver.controller;

import cadastroserver.model.Produto;
import jakarta.persistence.*;
import java.util.List;

public class ProdutoJpaController {
    private EntityManagerFactory emf;

    public ProdutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Produto> findProdutos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
        } finally {
            em.close();
        }
    }
}