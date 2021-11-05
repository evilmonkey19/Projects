package util;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.transaction.UserTransaction;

import model.UserModel;

/**
 * Web application lifecycle listener.
 *
 * @author evilmonkey19
 */
public class MyContextListener implements ServletContextListener {
    
    @Resource
    private UserTransaction utx;
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        try{
            ServletContext context = event.getServletContext();
            
            UserModel userModel = new UserModel(em, utx);
            
            context.setAttribute("userModel", userModel);
            
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
