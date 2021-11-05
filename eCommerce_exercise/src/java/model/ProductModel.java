/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import entity.Category;
import entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import lombok.AllArgsConstructor;

/**
 *
 * @author juanluis
 */

@AllArgsConstructor
public class ProductModel {

    EntityManager em;
    UserTransaction utx;

    public List<Product> retrieveAll(){
        Query q = em.createQuery("select o from Category as o");
        return q.getResultList();
    }
    
    public List<Product> retrieveByCategory(int category){
        Query q = em.createNativeQuery(em,"SELECT description " +
                                 "FROM ecommerce.product " +
                                 "WHERE category = 1;", Product.class);
        return q.getResultList();
    }
}
