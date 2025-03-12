/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistenciaDB;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logicaJava.claseReservasJava;
import persistenciaDB.exceptions.NonexistentEntityException;

/**
 *
 * @author XicYac
 */
public class claseReservasJavaJpaController implements Serializable {

    
    //Esta va a ser nuestra conexión con la base de datos
    public claseReservasJavaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public claseReservasJavaJpaController(){
        emf = Persistence.createEntityManagerFactory("conexionDB");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    //Con este método, vamos a crear los nuevos registros con los datos traidos desde nuestro front-end
    public void create(claseReservasJava claseReservasJava) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(claseReservasJava);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    
    public void edit(claseReservasJava claseReservasJava) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseReservasJava = em.merge(claseReservasJava);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = claseReservasJava.getId();
                if (findclaseReservasJava(id) == null) {
                    throw new NonexistentEntityException("The claseReservasJava with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    //Con este método, vamos a eliminar los registros con el id traido desde nuestro front-end
    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseReservasJava claseReservasJava;
            try {
                claseReservasJava = em.getReference(claseReservasJava.class, id);
                claseReservasJava.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The claseReservasJava with id " + id + " no longer exists.", enfe);
            }
            em.remove(claseReservasJava);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<claseReservasJava> findclaseReservasJavaEntities() {
        return findclaseReservasJavaEntities(true, -1, -1);
    }
    
    //findclaseReservasJavaEntities, el cual retorna lo que se haya encontrado de dicha entidad
    public List<claseReservasJava> findclaseReservasJavaEntities(int maxResults, int firstResult) {
        return findclaseReservasJavaEntities(false, maxResults, firstResult);
    }

    private List<claseReservasJava> findclaseReservasJavaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claseReservasJava.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public claseReservasJava findclaseReservasJava(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(claseReservasJava.class, id);
        } finally {
            em.close();
        }
    }

    public int getclaseReservasJavaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<claseReservasJava> rt = cq.from(claseReservasJava.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
