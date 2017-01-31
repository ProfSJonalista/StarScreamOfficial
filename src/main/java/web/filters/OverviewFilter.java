package web.filters;

import domain.Repair;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns={"/overview.jsp"})
public class OverviewFilter implements Filter{

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		
		HttpSession session = req.getSession();
	
		List<Repair> repairs =(List<Repair>)session.getAttribute("repairs") ;
		if (repairs == null || repairs.size() == 0){
			resp.sendRedirect("addAccount.html");
		} else {
			chain.doFilter(req, resp);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}
}