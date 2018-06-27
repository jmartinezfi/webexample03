package com.martinez.proyectoVentas.dao;
public interface MarcaDao { 
	public void insert (com.martinez.proyectoVentas.bean.MarcaBean dato);
	public void update (com.martinez.proyectoVentas.bean.MarcaBean dato);
	public void updateSelective (com.martinez.proyectoVentas.bean.MarcaBean dato);
	public com.martinez.proyectoVentas.bean.MarcaBean selectOne(com.martinez.proyectoVentas.bean.MarcaBean dato);
	public java.util.ArrayList<com.martinez.proyectoVentas.bean.MarcaBean> select(java.lang.String filtro);

}