package com.martinez.proyectoVentas.dao;
public interface ProductoDao { 
	public void insert (com.martinez.proyectoVentas.bean.ProductoBean dato);
	public void update (com.martinez.proyectoVentas.bean.ProductoBean dato);
	public void updateSelective (com.martinez.proyectoVentas.bean.ProductoBean dato);
	public com.martinez.proyectoVentas.bean.ProductoBean selectOne(com.martinez.proyectoVentas.bean.ProductoBean dato);
	public java.util.ArrayList<com.martinez.proyectoVentas.bean.ProductoBean> select(java.lang.String filtro);

}