package br.edu.up.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.edu.up.entidades.Motorista;

public class MotoristaPersistencia {

    public static boolean incluir(Motorista motorista) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.persist(motorista);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean alterar(Motorista motorista) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.merge(motorista);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean excluir(Motorista motorista) {
        try {
            EntityManager manager = EntityManagerFactory.getInstance();
            manager.getTransaction().begin();
            manager.remove(motorista);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Motorista procurarPorCPF(String cpf) {
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Motorista where cpf = :param");
        consulta.setParameter("param", cpf);
        List<Motorista> motoristas = consulta.getResultList();
        if (!motoristas.isEmpty()) {
            return motoristas.get(0);
        }
        return null;
    }

    public static Motorista procurarPorNome(String nome) {
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Motorista where nome = :param");
        consulta.setParameter("param", nome);
        List<Motorista> motoristas = consulta.getResultList();
        if (!motoristas.isEmpty()) {
            return motoristas.get(0);
        }
        return null;
    }

    public static Motorista procurarPorId(int id) {
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Motorista where id = :param");
        consulta.setParameter("param", id);
        List<Motorista> motoristas = consulta.getResultList();
        if (!motoristas.isEmpty()) {
            return motoristas.get(0);
        }
        return null;
    }

    public static List<Motorista> getMotoristas(String nome) {
        EntityManager manager = EntityManagerFactory.getInstance();
        Query consulta = manager.createQuery("from Motorista where nome like :param");
        consulta.setParameter("param", "%" + nome + "%");
        List<Motorista> motoristas = consulta.getResultList();
        return motoristas;
    }

    public static boolean motoristaExiste(int idMotorista) {
        EntityManager manager = EntityManagerFactory.getInstance();
        Query query = manager.createQuery("SELECT COUNT(m) FROM Motorista m WHERE m.id = :idMotorista");
        query.setParameter("idMotorista", idMotorista);
        int count = ((Number) query.getSingleResult()).intValue();
        return count > 0;
    }
}
