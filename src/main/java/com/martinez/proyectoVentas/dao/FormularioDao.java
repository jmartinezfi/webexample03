package com.martinez.proyectoVentas.dao;
public interface FormularioDao { 
	public void insert (com.martinez.proyectoVentas.bean.FormularioBean dato);
	public void update (com.martinez.proyectoVentas.bean.FormularioBean dato);
	public void updateSelective (com.martinez.proyectoVentas.bean.FormularioBean dato);
	public com.martinez.proyectoVentas.bean.FormularioBean selectOne(com.martinez.proyectoVentas.bean.FormularioBean dato);
	public java.util.ArrayList<com.martinez.proyectoVentas.bean.FormularioBean> select(java.lang.String filtro);
	public Object listado(Object valores);
}