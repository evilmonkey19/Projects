/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Incidencies;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author evilmonkey19
 */
public class IncidenciesModel {
    
    UserTransaction utx;
    EntityManager em;
    
    public IncidenciesModel(EntityManager em, UserTransaction utx){
        this.utx = utx;
        this.em = em;
    }
    
    public List<Incidencies> retrieveAll(){
        Query q = em.createQuery("select o from Incidencies as o");
        return q.getResultList();
    }
    
    public boolean createIncidencia(Incidencies entity){
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
