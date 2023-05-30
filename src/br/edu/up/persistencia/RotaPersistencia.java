package br.edu.up.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.edu.up.entidades.Rota;

public class RotaPersistencia {

    public static boolean incluir(Rota rota) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(rota);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean alterar(Rota rota) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.merge(rota);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean excluir(Rota rota) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.remove(rota);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Rota procurarPorId(int id) {
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("FROM Rota WHERE id = :param");
        consulta.setParameter("param", id);
        List<Rota> rotas = consulta.getResultList();
        if (!rotas.isEmpty()) {
            return rotas.get(0);
        }
        return null;
    }

    public static List<Rota> getRotas() {
        EntityManager manager = EntityManagerFactory.getInstance();
        Query query = manager.createQuery("SELECT r FROM Rota r");
        List<Rota> rotaList = query.getResultList();
        return rotaList;
    }

    public static boolean rotaExiste(int idRota) {
        EntityManager manager = EntityManagerFactory.getInstance();
        Query query = manager.createQuery("SELECT COUNT(r) FROM Rota r WHERE r.id = :idRota");
        query.setParameter("idRota", idRota);
        int count = ((Number) query.getSingleResult()).intValue();
        return count > 0;
    }

    public static void deleteByMotoristaID(int idMotorista) {
        EntityManager manager = EntityManagerFactory.getInstance();
        manager.getTransaction().begin();
        Query query = manager.createQuery("DELETE FROM Rota r WHERE r.idMotorista = :idMotorista");
        query.setParameter("idMotorista", idMotorista);
        query.executeUpdate();
        manager.getTransaction().commit();
    }

    public static void deleteByOnibusID(int idOnibus) {
        EntityManager manager = EntityManagerFactory.getInstance();
        manager.getTransaction().begin();
        Query query = manager.createQuery("DELETE FROM Rota r WHERE r.idOnibus = :idOnibus");
        query.setParameter("idOnibus", idOnibus);
        query.executeUpdate();
        manager.getTransaction().commit();
    }
}
