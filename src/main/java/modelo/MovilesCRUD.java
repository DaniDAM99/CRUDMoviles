package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MovilesCRUD {

    private static final String PUN = "com.mycompany_CRUDMoviles_war_1.0-SNAPSHOTPU";

    public static List<Moviles> getMoviles() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PUN);
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM moviles";
        Query q = manager.createNativeQuery(sql, Moviles.class);
        List<Moviles> movilesBD = q.getResultList();

        return movilesBD;
    }

    public static Moviles getMovil(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PUN);
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT m FROM Moviles m WHERE m.id = " + id;
        Query q = manager.createQuery(sql, Moviles.class);
        Moviles p = (Moviles) q.getSingleResult();

        return p;
    }

    public static void insertarMovil(Moviles movil) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PUN);
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(movil);
        manager.getTransaction().commit();
    }

    public static int borrarMovil(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PUN);
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from moviles WHERE id = " + id;
        Query q = manager.createNativeQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        return filasAfectadas;
    }

    public static int actualizarMovil(Moviles movil) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PUN);
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Moviles m SET m.marca = :marca, m.modelo = :modelo, m.color = :color, m.precio = :precio WHERE m.id = :id";
        Query q = manager.createQuery(sql, Moviles.class);
        q.setParameter("id", movil.getId());
        q.setParameter("marca", movil.getMarca());
        q.setParameter("modelo", movil.getModelo());
        q.setParameter("color", movil.getColor());
        q.setParameter("precio", movil.getPrecio());
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();

        return filasAfectadas;
    }
}
