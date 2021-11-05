package web.action;

import javax.servlet.http.*;
import model.CategoryModel;
import web.ViewManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class initAction implements Action {

    CategoryModel categoryModel;
    
    public void perform(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("categories", categoryModel.retrieveAll());
        ViewManager.nextView(req, resp, "/view/init.jsp");
    }
}
