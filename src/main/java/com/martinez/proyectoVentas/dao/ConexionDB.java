package com.martinez.proyectoVentas.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://o677vxfi8ok6exrd.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/dh7m0ekzd0t0ltuy?sslmode=require"; 

	// Database credentials
	static final String USER = "snacp4rfodcyowgt";
	static final String PASS = "kswpoab7vjfsg027";

	public Connection getConexion() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
		}
		return conn;
	}
	public synchronized int getSecuencia(String nombresq) {
		int secuencia = 0;
		java.sql.Connection conn = null;
		java.sql.PreparedStatement pstm  = null;
		java.sql.ResultSet rs = null;
		try {
			int codigo = 0;
			conn = getConexion();
			String sql = "Select * from sistema_secuencias " ;
			sql += " where TABLA =  ? ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nombresq);
			rs = pstm.executeQuery();
			while(rs.next()){
				secuencia = rs.getInt("secuencia");
				codigo = rs.getInt("ID_SECUENCIA");
			}
			pstm.close();
			secuencia ++;
			sql = "update sistema_secuencias set " ;
			sql += " secuencia = ? ";
			sql += " where  ID_SECUENCIA = ? " ; 
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, secuencia);
			pstm.setInt(2, codigo);
			pstm.execute();
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
		return secuencia;
	}
}
