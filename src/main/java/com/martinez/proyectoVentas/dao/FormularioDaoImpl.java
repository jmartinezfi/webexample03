package com.martinez.proyectoVentas.dao;

import org.json.JSONObject;

public class FormularioDaoImpl extends ConexionDB implements FormularioDao {
	public void insert(com.martinez.proyectoVentas.bean.FormularioBean dato) {
		java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm = null;
		try {
			conn = getConexion();
			String sql = "insert into Formulario(codigo,nombre,version,jsp,bean,descripcion,detalle,estado) values(?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, getSecuencia("Formulario"));
			pstm.setString(2, dato.getNombre());
			pstm.setString(3, dato.getVersion());
			pstm.setString(4, dato.getJsp());
			pstm.setString(5, dato.getBean());
			pstm.setString(6, dato.getDescripcion());
			pstm.setString(7, dato.getDetalle());
			pstm.setString(8, dato.getEstado());
			pstm.execute();
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(com.martinez.proyectoVentas.bean.FormularioBean dato) {
		java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm = null;
		try {
			System.out.println("----");
			System.out.println(dato.getJsp());
			System.out.println("----");
			conn = getConexion();
			String sql = "update Formulario set ";
			if (null != dato.getNombre() && !dato.getNombre().isEmpty())
				sql += " nombre = ? ,";
			if (null != dato.getVersion())
				sql += " version = ? ,";
			if (null != dato.getJsp())
				sql += " jsp = ? ,";
			if (null != dato.getBean())
				sql += " bean = ? ,";
			if (null != dato.getDescripcion())
				sql += " descripcion = ? ,";
			if (null != dato.getDetalle())
				sql += " detalle = ? ,";
			if (null != dato.getEstado())
				sql += " estado = ? ,";
			sql = sql.substring(0, sql.length() - 1);
			sql += " where  codigo = ? ";
			pstm = conn.prepareStatement(sql);
			int i = 1;
			if (null != dato.getNombre() && !dato.getNombre().isEmpty())
				pstm.setString(i++, dato.getNombre());
			if (null != dato.getVersion())
				pstm.setString(i++, dato.getVersion());
			if (null != dato.getJsp())
				pstm.setString(i++, dato.getJsp());
			if (null != dato.getBean())
				pstm.setString(i++, dato.getBean());
			if (null != dato.getDescripcion())
				pstm.setString(i++, dato.getDescripcion());
			if (null != dato.getDetalle())
				pstm.setString(i++, dato.getDetalle());
			if (null != dato.getEstado())
				pstm.setString(i++, dato.getEstado());
			pstm.setInt(i++, dato.getCodigo());
			pstm.execute();
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateSelective(com.martinez.proyectoVentas.bean.FormularioBean dato) {
		java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm = null;
		try {
			conn = getConexion();
			String sql = "update Formulario set ";
			if (null != dato.getNombre() && !dato.getNombre().isEmpty())
				sql += " nombre = ? ,";
			if (null != dato.getVersion())
				sql += " version = ? ,";
			if (null != dato.getJsp())
				sql += " jsp = ? ,";
			if (null != dato.getBean())
				sql += " bean = ? ,";
			if (null != dato.getDescripcion())
				sql += " descripcion = ? ,";
			if (null != dato.getDetalle())
				sql += " detalle = ? ,";
			if (null != dato.getEstado())
				sql += " estado = ? ,";
			sql = sql.substring(0, sql.length() - 1);
			sql += " where  codigo = ? ";
			pstm = conn.prepareStatement(sql);
			int i = 1;
			if (null != dato.getNombre() && !dato.getNombre().isEmpty())
				pstm.setString(i++, dato.getNombre());
			if (null != dato.getVersion())
				pstm.setString(i++, dato.getVersion());
			if (null != dato.getJsp())
				pstm.setString(i++, dato.getJsp());
			if (null != dato.getBean())
				pstm.setString(i++, dato.getBean());
			if (null != dato.getDescripcion())
				pstm.setString(i++, dato.getDescripcion());
			if (null != dato.getDetalle())
				pstm.setString(i++, dato.getDetalle());
			if (null != dato.getEstado())
				pstm.setString(i++, dato.getEstado());
			pstm.setInt(i++, dato.getCodigo());
			pstm.execute();
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public com.martinez.proyectoVentas.bean.FormularioBean selectOne(
			com.martinez.proyectoVentas.bean.FormularioBean dato) {
		com.martinez.proyectoVentas.bean.FormularioBean listado = new com.martinez.proyectoVentas.bean.FormularioBean();
		java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rs = null;
		try {
			conn = getConexion();
			String sql = "Select * from Formulario ";
			sql += " where Codigo =  ? ";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, dato.getCodigo());
			rs = pstm.executeQuery();
			while (rs.next()) {
				listado.setCodigo(rs.getInt("Codigo"));
				listado.setNombre(rs.getString("Nombre"));
				listado.setVersion(rs.getString("Version"));
				listado.setJsp(rs.getString("Jsp"));
				listado.setBean(rs.getString("Bean"));
				listado.setDescripcion(rs.getString("Descripcion"));
				listado.setDetalle(rs.getString("Detalle"));
				listado.setEstado(rs.getString("Estado"));
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstm != null)
					pstm.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return listado;
	}

	public java.util.ArrayList<com.martinez.proyectoVentas.bean.FormularioBean> select(java.lang.String filtro) {
		java.util.ArrayList<com.martinez.proyectoVentas.bean.FormularioBean> listado = new java.util.ArrayList<com.martinez.proyectoVentas.bean.FormularioBean>();
		java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm = null;
		java.sql.ResultSet rs = null;
		try {
			conn = getConexion();
			String sql = "Select * from Formulario  ";
			if (filtro != null && !filtro.isEmpty())
				sql += filtro;
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				com.martinez.proyectoVentas.bean.FormularioBean idato = new com.martinez.proyectoVentas.bean.FormularioBean();
				idato.setCodigo(rs.getInt("Codigo"));
				idato.setNombre(rs.getString("Nombre"));
				idato.setVersion(rs.getString("Version"));
				idato.setJsp(rs.getString("Jsp"));
				idato.setBean(rs.getString("Bean"));
				idato.setDescripcion(rs.getString("Descripcion"));
				idato.setDetalle(rs.getString("Detalle"));
				idato.setEstado(rs.getString("Estado"));
				listado.add(idato);
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstm != null)
					pstm.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return listado;
	}

	public Object listado(Object valores) {
		java.util.ArrayList<Object> listado = new java.util.ArrayList<Object>();
		java.sql.Connection conn = null;
		java.sql.CallableStatement cs = null;
		java.sql.ResultSet rs = null;
		try {
			conn = getConexion();
			String sql = "CALL sp_marca_listar()";
			cs = conn.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("j1", rs.getString(1));
				jsonObject.put("j2", rs.getString(2));
				jsonObject.put("j3", rs.getString(3));
				jsonObject.put("j4", rs.getString(4));
				jsonObject.put("j5", rs.getString(5));
				listado.add(jsonObject);
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
			try {
				if (cs != null)
					cs.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return listado;
	}
}