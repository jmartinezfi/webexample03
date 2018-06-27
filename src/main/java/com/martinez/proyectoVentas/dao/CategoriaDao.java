package com.martinez.proyectoVentas.dao;
public interface CategoriaDao { 
	public void insert (com.martinez.proyectoVentas.bean.CategoriaBean dato);
	public void update (com.martinez.proyectoVentas.bean.CategoriaBean dato);
	public void updateSelective (com.martinez.proyectoVentas.bean.CategoriaBean dato);
	public com.martinez.proyectoVentas.bean.CategoriaBean selectOne(com.martinez.proyectoVentas.bean.CategoriaBean dato);
	public java.util.ArrayList<com.martinez.proyectoVentas.bean.CategoriaBean> select(java.lang.String filtro);

}