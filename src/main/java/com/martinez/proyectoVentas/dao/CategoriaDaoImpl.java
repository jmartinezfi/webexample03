package com.martinez.proyectoVentas.dao;
public class CategoriaDaoImpl extends ConexionDB implements CategoriaDao { 
	public void insert (com.martinez.proyectoVentas.bean.CategoriaBean dato){
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		try {
			conn = getConexion();
			String sql = "insert into Categoria(codigoCate,nombreCate,descripcionCate,detalleCate,estadoCate) values(?,?,?,?,?)" ; 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, getSecuencia("codigoCate"));
			pstm.setString(2, dato.getNombre());
			pstm.setString(3, dato.getDescripcion());
			pstm.setString(4, dato.getDetalle());
			pstm.setString(5, dato.getEstado());
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
	public void update (com.martinez.proyectoVentas.bean.CategoriaBean dato){
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		try {
			conn = getConexion();
			String sql = "update Categoria set " ;
			if(null!= dato.getNombre() && !dato.getNombre().isEmpty())
				sql += " nombreCate = ? ,";
			if(null!= dato.getDescripcion())
				sql += " descripcionCate = ? ,";
			if(null!= dato.getDetalle())
				sql += " detalleCate = ? ,";
			if(null!= dato.getEstado())
				sql += " estadoCate = ? ,";
			sql = sql.substring(0, sql.length()-1);
			sql += " where  codigoCate = ? " ; 
			pstm = conn.prepareStatement(sql);
			int i = 1;
			if(null!= dato.getNombre() && !dato.getNombre().isEmpty())
				pstm.setString(i++, dato.getNombre());
			if(null!= dato.getDescripcion())
				pstm.setString(i++, dato.getDescripcion());
			if(null!= dato.getDetalle())
				pstm.setString(i++, dato.getDetalle());
			if(null!= dato.getEstado())
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
	public void updateSelective (com.martinez.proyectoVentas.bean.CategoriaBean dato){
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		try {
			conn = getConexion();
			String sql = "update Categoria set " ;
			if(null!= dato.getNombre() && !dato.getNombre().isEmpty())
				sql += " nombreCate = ? ,";
			if(null!= dato.getDescripcion())
				sql += " descripcionCate = ? ,";
			if(null!= dato.getDetalle())
				sql += " detalleCate = ? ,";
			if(null!= dato.getEstado())
				sql += " estadoCate = ? ,";
			sql = sql.substring(0, sql.length()-1);
			sql += " where  codigoCate = ? " ; 
			pstm = conn.prepareStatement(sql);
			int i = 1;
			if(null!= dato.getNombre() && !dato.getNombre().isEmpty())
				pstm.setString(i++, dato.getNombre());
			if(null!= dato.getDescripcion())
				pstm.setString(i++, dato.getDescripcion());
			if(null!= dato.getDetalle())
				pstm.setString(i++, dato.getDetalle());
			if(null!= dato.getEstado())
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
	public com.martinez.proyectoVentas.bean.CategoriaBean selectOne(com.martinez.proyectoVentas.bean.CategoriaBean dato){
       com.martinez.proyectoVentas.bean.CategoriaBean listado = new com.martinez.proyectoVentas.bean.CategoriaBean();
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		java.sql.ResultSet rs = null;
		try {
			conn = getConexion();
			String sql = "Select * from Categoria " ;
			sql += " where CodigoCate =  ? ";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, dato.getCodigo());
			rs = pstm.executeQuery();
			while(rs.next()){
				listado.setCodigo(rs.getInt("CodigoCate"));
				listado.setNombre(rs.getString("NombreCate"));
				listado.setDescripcion(rs.getString("DescripcionCate"));
				listado.setDetalle(rs.getString("DetalleCate"));
				listado.setEstado(rs.getString("EstadoCate"));
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
	public java.util.ArrayList<com.martinez.proyectoVentas.bean.CategoriaBean> select(java.lang.String filtro){
       java.util.ArrayList<com.martinez.proyectoVentas.bean.CategoriaBean> listado = new java.util.ArrayList<com.martinez.proyectoVentas.bean.CategoriaBean>();
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		java.sql.ResultSet rs = null;
		try {
			conn = getConexion();
			String sql = "Select * from Categoria  ";
			if(filtro!=null&&!filtro.isEmpty())
				sql += filtro;
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				com.martinez.proyectoVentas.bean.CategoriaBean idato = new com.martinez.proyectoVentas.bean.CategoriaBean();
				idato.setCodigo(rs.getInt("CodigoCate"));
				idato.setNombre(rs.getString("NombreCate"));
				idato.setDescripcion(rs.getString("DescripcionCate"));
				idato.setDetalle(rs.getString("DetalleCate"));
				idato.setEstado(rs.getString("EstadoCate"));
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