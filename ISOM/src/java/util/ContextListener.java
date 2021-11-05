/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.transaction.UserTransaction;
import model.IncidenciesModel;

/**
 * Web application lifecycle listener.
 *
 * @author evilmonkey19
 */
public class ContextListener implements ServletContextListener {

    @Resource
    private UserTransaction utx;
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        try{
            ServletContext context = event.getServletContext();
            
            IncidenciesModel model = new IncidenciesModel(em, utx);
            context.setAttribute("IncidenciesModel", model);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
