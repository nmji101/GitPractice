package kh.git.exam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.control")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{
		String url = request.getRequestURI().substring(request.getContextPath().length() + 1);
		Git_membersDAO dao = new Git_membersDAO();
		
		if(url.equals("input.control"))
		{
			String name = request.getParameter("name");
			String msg = request.getParameter("msg");
			
			try
			{
				dao.insertMember(name, msg);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if(url.equals("output.control"))
		{
			try
			{
				List<String> list = dao.selectAll();
				request.setAttribute("list", list);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			request.getRequestDispatcher("ViewList.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
