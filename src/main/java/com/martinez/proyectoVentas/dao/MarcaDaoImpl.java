package com.martinez.proyectoVentas.dao;
public class MarcaDaoImpl extends ConexionDB implements MarcaDao { 
	public void insert (com.martinez.proyectoVentas.bean.MarcaBean dato){
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		try {
			conn = getConexion();
			String sql = "insert into Marca(codigoMarc,nombreMarc,apellidoMarc,estadoMarc) values(?,?,?,?)" ; 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, getSecuencia("codigoMarc"));
			pstm.setString(2, dato.getNombre());
			pstm.setString(3, dato.getApellido());
			pstm.setString(4, dato.getEstado());
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
	public void update (com.martinez.proyectoVentas.bean.MarcaBean dato){
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		try {
			conn = getConexion();
			String sql = "update Marca set " ;
			if(null!= dato.getNombre() && !dato.getNombre().isEmpty())
				sql += " nombreMarc = ? ,";
			if(null!= dato.getApellido())
				sql += " apellidoMarc = ? ,";
			if(null!= dato.getEstado() && !dato.getEstado().isEmpty())
				sql += " estadoMarc = ? ,";
			sql = sql.substring(0, sql.length()-1);
			sql += " where  codigoMarc = ? " ; 
			pstm = conn.prepareStatement(sql);
			int i = 1;
			if(null!= dato.getNombre() && !dato.getNombre().isEmpty())
				pstm.setString(i++, dato.getNombre());
			if(null!= dato.getApellido())
				pstm.setString(i++, dato.getApellido());
			if(null!= dato.getEstado() && !dato.getEstado().isEmpty())
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
	public void updateSelective (com.martinez.proyectoVentas.bean.MarcaBean dato){
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		try {
			conn = getConexion();
			String sql = "update Marca set " ;
			if(null!= dato.getNombre() && !dato.getNombre().isEmpty())
				sql += " nombreMarc = ? ,";
			if(null!= dato.getApellido())
				sql += " apellidoMarc = ? ,";
			if(null!= dato.getEstado() && !dato.getEstado().isEmpty())
				sql += " estadoMarc = ? ,";
			sql = sql.substring(0, sql.length()-1);
			sql += " where  codigoMarc = ? " ; 
			pstm = conn.prepareStatement(sql);
			int i = 1;
			if(null!= dato.getNombre() && !dato.getNombre().isEmpty())
				pstm.setString(i++, dato.getNombre());
			if(null!= dato.getApellido())
				pstm.setString(i++, dato.getApellido());
			if(null!= dato.getEstado() && !dato.getEstado().isEmpty())
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
	public com.martinez.proyectoVentas.bean.MarcaBean selectOne(com.martinez.proyectoVentas.bean.MarcaBean dato){
       com.martinez.proyectoVentas.bean.MarcaBean listado = new com.martinez.proyectoVentas.bean.MarcaBean();
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		java.sql.ResultSet rs = null;
		try {
			conn = getConexion();
			String sql = "Select * from Marca " ;
			sql += " where CodigoMarc =  ? ";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, dato.getCodigo());
			rs = pstm.executeQuery();
			while(rs.next()){
				listado.setCodigo(rs.getInt("CodigoMarc"));
				listado.setNombre(rs.getString("NombreMarc"));
				listado.setApellido(rs.getString("ApellidoMarc"));
				listado.setEstado(rs.getString("EstadoMarc"));
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
	public java.util.ArrayList<com.martinez.proyectoVentas.bean.MarcaBean> select(java.lang.String filtro){
       java.util.ArrayList<com.martinez.proyectoVentas.bean.MarcaBean> listado = new java.util.ArrayList<com.martinez.proyectoVentas.bean.MarcaBean>();
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		java.sql.ResultSet rs = null;
		try {
			conn = getConexion();
			String sql = "Select * from Marca  ";
			if(filtro!=null&&!filtro.isEmpty())
				sql += filtro;
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				com.martinez.proyectoVentas.bean.MarcaBean idato = new com.martinez.proyectoVentas.bean.MarcaBean();
				idato.setCodigo(rs.getInt("CodigoMarc"));
				idato.setNombre(rs.getString("NombreMarc"));
				idato.setApellido(rs.getString("ApellidoMarc"));
				idato.setEstado(rs.getString("EstadoMarc"));
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
}