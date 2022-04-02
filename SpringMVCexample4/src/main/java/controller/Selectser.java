package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Selectpojo;

/**
 * Servlet implementation class Selectser
 */
@WebServlet("/Selectser")
public class Selectser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selectser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("select.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Selectpojo obj=new Selectpojo();
		obj.setS(request.getParameter("res"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/springmvcexample","root","");
			Statement st=con.createStatement();
			
			ResultSet res=st.executeQuery("select * from student");
			obj.setS(request.getParameter("res"));
			if(res!=null)
			{
				while(res.next())
				{
					//res.getString(obj.getS());
					response.sendRedirect("select.jsp?q="+res.getString(obj.getS()));
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print(e.getMessage().toString());
		}
		
	}

}
