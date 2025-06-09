package cadastroserver.controller;

import cadastroserver.model.Usuario;
import jakarta.persistence.*;
import java.util.List;

public class UsuarioJpaController {
    private EntityManagerFactory emf;

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Usuario findUsuario(String login, String senha) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Usuario> q = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha", Usuario.class);
            q.setParameter("login", login);
            q.setParameter("senha", senha);
            List<Usuario> result = q.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } finally {
            em.close();
        }
    }
}