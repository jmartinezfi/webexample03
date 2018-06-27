package com.martinez.proyectoVentas.dao;
public class ProductoDaoImpl extends ConexionDB implements ProductoDao { 
	public void insert (com.martinez.proyectoVentas.bean.ProductoBean dato){
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		try {
			conn = getConexion();
			String sql = "insert into Producto(codigoProd,nombreProd,descripcionProd,codigoMarcProd,codigoCateProd,estadoProd) values(?,?,?,?,?,?)" ; 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, getSecuencia("codigoProd"));
			pstm.setString(2, dato.getNombre());
			pstm.setString(3, dato.getDescripcion());
			pstm.setInt(4, dato.getCodigoMarc());
			pstm.setInt(5, dato.getCodigoCate());
			pstm.setString(6, dato.getEstado());
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
	public void update (com.martinez.proyectoVentas.bean.ProductoBean dato){
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		try {
			conn = getConexion();
			String sql = "update Producto set " ;
			if(null!= dato.getNombre())
				sql += " nombreProd = ? ,";
			if(null!= dato.getDescripcion() && !dato.getDescripcion().isEmpty())
				sql += " descripcionProd = ? ,";
			if(0!= dato.getCodigoMarc())
				sql += " codigoMarcProd = ? ,";
			if(0!= dato.getCodigoCate())
				sql += " codigoCateProd = ? ,";
			if(null!= dato.getEstado() && !dato.getEstado().isEmpty())
				sql += " estadoProd = ? ,";
			sql = sql.substring(0, sql.length()-1);
			sql += " where  codigoProd = ? " ; 
			pstm = conn.prepareStatement(sql);
			int i = 1;
			if(null!= dato.getNombre())
				pstm.setString(i++, dato.getNombre());
			if(null!= dato.getDescripcion() && !dato.getDescripcion().isEmpty())
				pstm.setString(i++, dato.getDescripcion());
			if(0!= dato.getCodigoMarc())
				pstm.setInt(i++, dato.getCodigoMarc());
			if(0!= dato.getCodigoCate())
				pstm.setInt(i++, dato.getCodigoCate());
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
	public void updateSelective (com.martinez.proyectoVentas.bean.ProductoBean dato){
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		try {
			conn = getConexion();
			String sql = "update Producto set " ;
			if(null!= dato.getNombre())
				sql += " nombreProd = ? ,";
			if(null!= dato.getDescripcion() && !dato.getDescripcion().isEmpty())
				sql += " descripcionProd = ? ,";
			if(0!= dato.getCodigoMarc())
				sql += " codigoMarcProd = ? ,";
			if(0!= dato.getCodigoCate())
				sql += " codigoCateProd = ? ,";
			if(null!= dato.getEstado() && !dato.getEstado().isEmpty())
				sql += " estadoProd = ? ,";
			sql = sql.substring(0, sql.length()-1);
			sql += " where  codigoProd = ? " ; 
			pstm = conn.prepareStatement(sql);
			int i = 1;
			if(null!= dato.getNombre())
				pstm.setString(i++, dato.getNombre());
			if(null!= dato.getDescripcion() && !dato.getDescripcion().isEmpty())
				pstm.setString(i++, dato.getDescripcion());
			if(0!= dato.getCodigoMarc())
				pstm.setInt(i++, dato.getCodigoMarc());
			if(0!= dato.getCodigoCate())
				pstm.setInt(i++, dato.getCodigoCate());
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
	public com.martinez.proyectoVentas.bean.ProductoBean selectOne(com.martinez.proyectoVentas.bean.ProductoBean dato){
       com.martinez.proyectoVentas.bean.ProductoBean listado = new com.martinez.proyectoVentas.bean.ProductoBean();
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		java.sql.ResultSet rs = null;
		try {
			conn = getConexion();
			String sql = "Select * from Producto " ;
			sql += " where CodigoProd =  ? ";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, dato.getCodigo());
			rs = pstm.executeQuery();
			while(rs.next()){
				listado.setCodigo(rs.getInt("CodigoProd"));
				listado.setNombre(rs.getString("NombreProd"));
				listado.setDescripcion(rs.getString("DescripcionProd"));
				listado.setCodigoMarc(rs.getInt("CodigoMarcProd"));
				listado.setCodigoCate(rs.getInt("CodigoCateProd"));
				listado.setEstado(rs.getString("EstadoProd"));
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
	public java.util.ArrayList<com.martinez.proyectoVentas.bean.ProductoBean> select(java.lang.String filtro){
       java.util.ArrayList<com.martinez.proyectoVentas.bean.ProductoBean> listado = new java.util.ArrayList<com.martinez.proyectoVentas.bean.ProductoBean>();
       java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		java.sql.ResultSet rs = null;
		try {
			conn = getConexion();
			String sql = "Select * from Producto  left join Marca on Producto.codigoMarcProd = Marca.codigoMarc  left join Categoria on Producto.codigoCateProd = Categoria.codigoCate  ";
			if(filtro!=null&&!filtro.isEmpty())
				sql += filtro;
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				com.martinez.proyectoVentas.bean.ProductoBean idato = new com.martinez.proyectoVentas.bean.ProductoBean();
				idato.setCodigo(rs.getInt("CodigoProd"));
				idato.setNombre(rs.getString("NombreProd"));
				idato.setDescripcion(rs.getString("DescripcionProd"));
				idato.setCodigoMarc(rs.getInt("CodigoMarcProd"));
				idato.setCodigoCate(rs.getInt("CodigoCateProd"));
				idato.setMarca(rs.getString("nombreMarc"));
				idato.setCategoria(rs.getString("nombreCate"));
				idato.setEstado(rs.getString("EstadoProd"));
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