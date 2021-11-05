package demo.web;

import demo.spec.RemoteLogin;
import demo.spec.UserAccess;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerServlet extends HttpServlet {
    

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        process(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        process(request, response);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        
        String view = perform_action(request);
        forwardRequest(request, response, view);
    }

    protected String perform_action(HttpServletRequest request)
        throws IOException, ServletException {
        
        String serv_path = request.getServletPath();
        HttpSession session = request.getSession();

        // Login to the website
        if (serv_path.equals("/login.do")) {
            try{
                session.setAttribute("useraccess",
                                    getRemoteLogin().connect(
                                        request.getParameter("user"),
                                     request.getParameter("password")
                                    ));
                return "/wallview";
                // Next version: Only allow access to existing users
            } catch (Exception e){
                return "/error-no-user_access.html";
            }
        }
        
        // Post a new message
        else if (serv_path.equals("/put.do")) {
            try {
                UserAccess user = (UserAccess) session.getAttribute("useraccess");
                user.put(request.getParameter("msg"));
                return "/wallview";
            } catch (Exception e){
                return "/error-not-loggedin.html";
            }
        }
        
        // Refresh for new messages
        else if (serv_path.equals("/refresh.do")) {
            try {
                session.getAttribute("useraccess");
                return "/wallview";
            } catch(Exception e){
                return "/error-not-loggedin.html";
            }
        } 
        
        else if (serv_path.equals("/logout.do")) {
            // Next Version delete messages from logged out users
            session.removeAttribute("useraccess");
            return "/goodbye.html";
        } 
        /*
        else if (serv_path.equals("/delete.do")) {
            return "/error-not-loggedin.html";
        }
        */
        else {
            return "/error-bad-action.html";
        }
    }

    
    public RemoteLogin getRemoteLogin() {
        return (RemoteLogin) getServletContext().getAttribute("remoteLogin");
    }
    public void forwardRequest(HttpServletRequest request, HttpServletResponse response, String view) 
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(view);
        if (dispatcher == null) {
            throw new ServletException("No dispatcher for view path '"+view+"'");
        }
        dispatcher.forward(request,response);
    }
}


