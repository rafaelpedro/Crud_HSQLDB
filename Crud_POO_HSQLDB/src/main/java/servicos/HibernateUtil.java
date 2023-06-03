package servicos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory INSTANCIA
    = Persistence
    .createEntityManagerFactory("minha-aplicacao");

    public static EntityManager criarEntityManager() {
       return INSTANCIA.createEntityManager();
    }

    public static void fecharFactory() {
        INSTANCIA.close();
    }
}
