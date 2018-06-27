package com.martinez.proyectoVentas.bean;
public class CategoriaBean { 
	private int codigo;
	public int getCodigo() { 
		return codigo;
	}
	public void setCodigo(int codigo) { 
		this.codigo = codigo;
	}
	private String nombre = "";
	public String getNombre() { 
		return nombre;
	}
	public void setNombre(String nombre) { 
		this.nombre = nombre;
	}
	private String descripcion;
	public String getDescripcion() { 
		return descripcion;
	}
	public void setDescripcion(String descripcion) { 
		this.descripcion = descripcion;
	}
	private String detalle;
	public String getDetalle() { 
		return detalle;
	}
	public void setDetalle(String detalle) { 
		this.detalle = detalle;
	}
	private String estado;
	public String getEstado() { 
		return estado;
	}
	public void setEstado(String estado) { 
		this.estado = estado;
	}

}