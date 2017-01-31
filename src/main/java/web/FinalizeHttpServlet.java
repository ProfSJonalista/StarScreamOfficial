package web;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import domain.Profile;
import domain.Repair;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns="/finalize")
public class FinalizeHttpServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();

        IRepositoryCatalog catalog;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            catalog = new RepositoryCatalog("jdbc:hsqldb:hsql://localhost/workdb");
            Profile profile = (Profile) session.getAttribute("profile");
            List<Repair> repairs = (List<Repair>)session.getAttribute("repairs");



            catalog.profiles().add(profile);
            catalog.save();
            int id = catalog.profiles().getMaxId();
            for(Repair repair : repairs)
            {
                repair.setProfileID(id);
                catalog.repairs().add(repair);
            }
            catalog.saveAndClose();
            session.removeAttribute("profile");
            session.removeAttribute("repairs");
            response.sendRedirect("addProfile.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
