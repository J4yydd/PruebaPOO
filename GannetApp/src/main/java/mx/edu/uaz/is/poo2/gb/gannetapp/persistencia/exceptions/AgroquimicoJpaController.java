
package mx.edu.uaz.is.poo2.gb.gannetapp.persistencia.exceptions;

import mx.edu.uaz.is.poo2.gb.gannetapp.logica.Agroquimico;
import mx.edu.uaz.is.poo2.gb.gannetapp.persistencia.exceptions.exceptions.NonexistentEntityException;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;



public class AgroquimicoJpaController implements Serializable {

    public AgroquimicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public AgroquimicoJpaController(){
       emf = Persistence.createEntityManagerFactory("GannetPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
   // @PersistenceContext(unitName = "GannetPU")
    //EntityManager em;
//Método para crear un nuevo agroquímico en la base de datos.
    public void create(Agroquimico agroquimico) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(agroquimico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
//Método para editar un agroquímico existente.
    public void edit(Agroquimico agroquimico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            agroquimico = em.merge(agroquimico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = agroquimico.getId();
                if (findAgroquimico(id) == null) {
                    throw new NonexistentEntityException("The agroquimico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
//Método para eliminar un agroquímico por su ID.
    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Agroquimico agroquimico;
            try {
                agroquimico = em.getReference(Agroquimico.class, id);
                agroquimico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agroquimico with id " + id + " no longer exists.", enfe);
            }
            em.remove(agroquimico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
//Método para obtener todos los agroquímicos.
    public List<Agroquimico> findAgroquimicoEntities() {
        return findAgroquimicoEntities(true, -1, -1);
    }

    public List<Agroquimico> findAgroquimicoEntities(int maxResults, int firstResult) {
        return findAgroquimicoEntities(false, maxResults, firstResult);
    }

    private List<Agroquimico> findAgroquimicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Agroquimico.class));
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
//Método para buscar un agroquímico por su ID.

    public Agroquimico findAgroquimico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Agroquimico.class, id);
        } finally {
            em.close();
        }
    }
//Método para contar cuántos agroquímicos hay en la base de datos.
    public int getAgroquimicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Agroquimico> rt = cq.from(Agroquimico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
