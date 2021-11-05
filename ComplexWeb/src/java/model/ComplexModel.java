package model;

import entity.Number;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;


/**
 *
 * @author evilmonkey19
 */
public class ComplexModel {
    UserTransaction utx;
    EntityManager em;
    
    public ComplexModel(UserTransaction utx, EntityManager em) {
        this.utx = utx;
        this.em = em;
    }
    
    public void create(Number complex) throws Exception {
        utx.begin();
        em.persist(complex);
        em.flush();
        utx.commit();
    }
    
    public Number retrieve(int id){
        return em.find(Number.class, id);
    }
    
    public Number retrieveById(int id){
        String sql = "select o from Number as o where o.id=:the_id";
        Query q = em.createQuery(sql);
        q.setParameter("the_id",id);
        return (Number) q.getSingleResult();
    }
    
    public void update(Number complex) throws Exception {
        utx.begin();
        em.merge(complex);
        em.flush();
        utx.commit();
    }
    
    public void delete(Number complex) throws Exception {
        utx.begin();
        complex = em.merge(complex);
        em.remove(complex);
        em.flush();
        utx.commit();
    }
    
    public List<Number> retrieveAllComplexNumbers() throws Exception {
        Query q = em.createQuery("select * from Complex.Number");
        return q.getResultList();
    }
    
}
