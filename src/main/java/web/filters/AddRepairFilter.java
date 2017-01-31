package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns={"/addRepair.jsp","/addRepair","/overview.jsp"})
public class AddRepairFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		if(req.getSession().getAttribute("profile") == null){
			resp.sendRedirect("addProfile.jsp");
		}
		else{
			chain.doFilter(req, resp);
		}
	}

	public void destroy() {

	}
}
