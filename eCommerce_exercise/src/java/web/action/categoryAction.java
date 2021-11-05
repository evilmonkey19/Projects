package web.action;

/**
 *
 * @author evilmonkey19
 */
import entity.Product;
import java.util.List;
import javax.servlet.http.*;
import lombok.AllArgsConstructor;
import model.CategoryModel;
import model.ProductModel;
import web.ViewManager;

@AllArgsConstructor
public class categoryAction implements Action{
    CategoryModel categoryModel;
    ProductModel productModel;

    @Override
    public void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Product> products = productModel.retrieveByCategory(1);
        for (Product p : products) System.out.println(p.toString());
        //req.setAttribute("products", productModel.retrieveAllByCategory());
        
        ViewManager.nextView(req, resp, "undone.jsp"); //"/view/category.jsp");
    }
    
    
}
