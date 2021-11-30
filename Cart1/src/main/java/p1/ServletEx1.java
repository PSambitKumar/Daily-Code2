package p1;

import p1.Album;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ServletEx1")
public class ServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(true);
		String x=request.getParameter("add");
		Vector v=null;
		Vector v1=null;
		if(x.equalsIgnoreCase("click"))
		{
		String ss1= request.getParameter("t1");
		String qty= request.getParameter("qty");
		StringTokenizer st = new StringTokenizer(ss1,"|");
		//out.println(s1);
		String s1=st.nextToken();
		String s2=st.nextToken();
		String s3= st.nextToken();
		String s4= st.nextToken();
		Album a = new Album();
		
		a.setAlbum(s1);
		a.setArtist(s2);
		a.setCountry(s3);
		a.setPrice(s4);
		a.setQty(qty);
			
		 v1=(Vector)sess.getAttribute("x1");
		if(v1==null) {
		 v = new Vector();
	
		v.add(a);
		}
		else
		{
			v1.add(a);
			v=v1;
			
		}
		}
		else if(x.equalsIgnoreCase("Delete"))
		{
			int index=Integer.parseInt(request.getParameter("delindex"));
			System.out.println(index);
			Vector v3=(Vector)sess.getAttribute("x1");
			v3.removeElementAt(index);
			v=v3;
			
		}
	
		sess.setAttribute("x1",v);
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/Next.jsp");
		rd.forward(request, response);
			
	}

}