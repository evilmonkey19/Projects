package model;

import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author evilmonkey19
 */
public class UserModel {
    
    UserTransaction utx;
    EntityManager em;
    
    public UserModel(EntityManager em, UserTransaction utx){
        this.utx = utx;
        this.em = em;
    }
    
    public List<User> retrieveAll(){
        Query q = em.createQuery("select o from User as o");
        return q.getResultList();
    }
    
    public boolean createUser(User entity){
        try{
            utx.begin();
            em.persist(entity);
            em.flush();
            utx.commit();
            return true;
        } catch (Exception ex){
            try{
                utx.rollback();
                ex.printStackTrace();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
