package rev1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RequestInfo() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>RequestInfo</title></head>");
		out.println("<p>Method: "+request.getMethod()+"</p>");
		out.println("<p>URI: "+request.getRequestURI()+"</p>");
		out.println("<p>URL: "+request.getRequestURL()+"</p>");
		out.println("<p>Remote Address: "+request.getRemoteAddr()+"</p>");
		out.println("<p>Context Path: "+request.getContextPath()+"</p>");
		if(request.getHeader("Accept-Encoding").indexOf("gzip")>=0)
			out.println("GZIP supported");
		else 
			out.println("GZIP not supported");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
