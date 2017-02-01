package web;

import domain.Profile;
import domain.Repair;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@WebServlet(urlPatterns = "/addRepair")
public class AddRepairHttpServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession();

        String nameOfDevice = request.getParameter("nameOfDevice");
        String typeOfRepair = request.getParameter("typeOfRepair");

        if (nameOfDevice == null  || nameOfDevice.equals("") || typeOfRepair == null || typeOfRepair.equals("")) {
            response.sendRedirect("addRepair.jsp");
        }
        Profile profile = (Profile) session.getAttribute("profile");

        if (profile == null) {
            response.sendRedirect("addProfile.jsp");
        }

        Repair repair = new Repair();

        Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());

        Calendar c = Calendar.getInstance();

        c.getTimeInMillis();
        if(typeOfRepair.equals("Replace")){
            c.add(Calendar.DATE, 2);
            java.sql.Date timeLater = new java.sql.Date(c.getTimeInMillis());

            repair.setPrice(50);
            repair.setEndRepairDate(timeLater);
        } else if (typeOfRepair.equals("Installation")){
            c.add(Calendar.DATE, 3);
            java.sql.Date timeLater = new java.sql.Date(c.getTimeInMillis());

            repair.setPrice(25);
            repair.setEndRepairDate(timeLater);
        }else if (typeOfRepair.equals("Building")){
            c.add(Calendar.DATE, 4);
            java.sql.Date timeLater = new java.sql.Date(c.getTimeInMillis());

            repair.setPrice(40);
            repair.setEndRepairDate(timeLater);
        }else if (typeOfRepair.equals("Cleaning")){
            c.add(Calendar.DATE, 1);
            java.sql.Date timeLater = new java.sql.Date(c.getTimeInMillis());

            repair.setPrice(10);
            repair.setEndRepairDate(timeLater);
        }else if (typeOfRepair.equals("Repairing")){
            c.add(Calendar.DATE, 4);
            java.sql.Date timeLater = new java.sql.Date(c.getTimeInMillis());

            repair.setPrice(30);
            repair.setEndRepairDate(timeLater);
        }

        repair.setNameOfDeviceInRepair(nameOfDevice);
        repair.setStartRepairDate(timeNow);
        repair.setProfile(profile);
        List<Repair> repairs;
        if(session.getAttribute("repairs") == null) {
            repairs = new ArrayList<Repair>();
            session.setAttribute("repairs",repairs);
        }
        else
            repairs = (List<Repair>) session.getAttribute("repairs");
        repairs.add(repair);
        response.sendRedirect("addRepair.jsp");
    }
}
