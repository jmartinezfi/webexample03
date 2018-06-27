package com.martinez.proyectoVentas.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
@WebServlet("/MarcaServlet")
public class MarcaServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Gson gson = new Gson();
		com.martinez.proyectoVentas.bean.ResultadoBean res = new com.martinez.proyectoVentas.bean.ResultadoBean();
		try {
			String accion = request.getParameter("a");
			com.martinez.proyectoVentas.bean.MarcaBean dato = new com.martinez.proyectoVentas.bean.MarcaBean();
			if ("l".equalsIgnoreCase(accion)) {
				com.martinez.proyectoVentas.dao.MarcaDao dao = new com.martinez.proyectoVentas.dao.MarcaDaoImpl();
				String filtro = "";
				String lbBusqueda = request.getParameter("lbBusqueda");
				if(null!=lbBusqueda && !lbBusqueda.isEmpty()) {
					filtro = " where NombreMarc like ('%"+lbBusqueda+"%')";
				}
				filtro += " order by NombreMarc asc";
				ArrayList<com.martinez.proyectoVentas.bean.MarcaBean> lista = dao.select(filtro);
				String base = "<tr><td>%s</td><td>%s</td><td>%s</td>"+ "<td><button type='button' class='btn btn-info px-3' onClick='return Clickbtn_Editar(%s);' ><i class='fa fa-search-plus' aria-hidden='true'></i></button>"
						+ "<button type='button' class='btn btn-danger px-3' onClick='return Clickbtn_Eliminar(%s);' ><i class='fa fa-times-circle' aria-hidden='true'></i></button>"
						+ "</td></tr>";
				if (lista != null && !lista.isEmpty()) {
					String html = "";
					int i = 0;
					while (i < lista.size()) {
						com.martinez.proyectoVentas.bean.MarcaBean idato = lista.get(i);
						html += String.format(base, idato.getCodigo(),idato.getNombre(),idato.getApellido(),idato.getCodigo(),idato.getCodigo());
						i++;
					}
					res.setHtml(html);
				}
				res.setDescripcion("Conforme Listar");
			}else if ("s".equalsIgnoreCase(accion)) {
				com.martinez.proyectoVentas.dao.MarcaDao dao = new com.martinez.proyectoVentas.dao.MarcaDaoImpl();
				String filtro = "";
				filtro += " order by NombreMarc asc";
				ArrayList<com.martinez.proyectoVentas.bean.MarcaBean> lista = dao.select(filtro);
				String base = "<option value='%s'>%s</option>" ;
				if (lista != null && !lista.isEmpty()) {
					String html = "";
					int i = 0;
					while (i < lista.size()) {
						com.martinez.proyectoVentas.bean.MarcaBean idato = lista.get(i);
						html += String.format(base, idato.getCodigo(),idato.getNombre());
						i++;
					}
					res.setHtml(html);
				}
				res.setDescripcion("Conforme Listar");
			} else if ("n".equalsIgnoreCase(accion)) {
				com.martinez.proyectoVentas.dao.MarcaDao dao = new com.martinez.proyectoVentas.dao.MarcaDaoImpl();
				dato.setNombre(request.getParameter("nombre"));
				dato.setApellido(request.getParameter("apellido"));
				dato.setEstado(request.getParameter("estado"));
				dao.insert(dato);
				res.setDescripcion("Nuevo elemento");
			} else if ("u".equalsIgnoreCase(accion)) {
				com.martinez.proyectoVentas.dao.MarcaDao dao = new com.martinez.proyectoVentas.dao.MarcaDaoImpl();
				dato.setCodigo(Integer.parseInt(request.getParameter("codigo")));
				dato.setNombre(request.getParameter("nombre"));
				dato.setApellido(request.getParameter("apellido"));
				dato.setEstado(request.getParameter("estado"));
				dao.update(dato);
				res.setDescripcion("Elemento actualizado");
			} else if ("d".equalsIgnoreCase(accion)) {
				com.martinez.proyectoVentas.dao.MarcaDao dao = new com.martinez.proyectoVentas.dao.MarcaDaoImpl();
				dato.setCodigo(Integer.parseInt(request.getParameter("codigo")));
				dato.setEstado("99");
				dao.updateSelective(dato);
				res.setDescripcion("Eliminado correctamente");
			} else if ("o".equalsIgnoreCase(accion)) {
				com.martinez.proyectoVentas.dao.MarcaDao dao = new com.martinez.proyectoVentas.dao.MarcaDaoImpl();
				dato.setCodigo(Integer.parseInt(request.getParameter("codigo")));
				com.martinez.proyectoVentas.bean.MarcaBean rest = dao.selectOne(dato);
				res.setValor(rest);
			} else {
				res.setCodigo("2002");
				res.setDescripcion("Opcion no disponible");
			}
			res.setCodigo("2000");
		} catch (Exception e) {
			res.setCodigo("2001");
			res.setDescripcion("Error :" + e.getLocalizedMessage());
			e.printStackTrace();
		}
		response.setContentType("application/json");
		response.getWriter().append(gson.toJson(res));	}
}