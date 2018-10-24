package com.martinez.proyectoVentas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Generico
 */
public class Generico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Generico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getParameter("codigo"));
		String codigo = "";
		if(request.getParameter("codigo")==null) {
			codigo = "104";
		}else {
			codigo = request.getParameter("codigo");
		}
		com.martinez.proyectoVentas.bean.FormularioBean dato = new com.martinez.proyectoVentas.bean.FormularioBean();
		com.martinez.proyectoVentas.dao.FormularioDao dao = new com.martinez.proyectoVentas.dao.FormularioDaoImpl();
		dato.setCodigo(Integer.parseInt(codigo));
		com.martinez.proyectoVentas.bean.FormularioBean rest = dao.selectOne(dato);
		response.getWriter().append(rest.getJsp());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
