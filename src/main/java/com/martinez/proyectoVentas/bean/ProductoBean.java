package com.martinez.proyectoVentas.bean;
public class ProductoBean { 
	private int codigo;
	public int getCodigo() { 
		return codigo;
	}
	public void setCodigo(int codigo) { 
		this.codigo = codigo;
	}
	private String nombre;
	public String getNombre() { 
		return nombre;
	}
	public void setNombre(String nombre) { 
		this.nombre = nombre;
	}
	private String descripcion = "";
	public String getDescripcion() { 
		return descripcion;
	}
	public void setDescripcion(String descripcion) { 
		this.descripcion = descripcion;
	}
	private int codigoMarc;
	public int getCodigoMarc() { 
		return codigoMarc;
	}
	public void setCodigoMarc(int codigoMarc) { 
		this.codigoMarc = codigoMarc;
	}
	private int codigoCate;
	public int getCodigoCate() { 
		return codigoCate;
	}
	public void setCodigoCate(int codigoCate) { 
		this.codigoCate = codigoCate;
	}
	private String Marca;
	public String getMarca() { 
		return Marca;
	}
	public void setMarca(String Marca) { 
		this.Marca = Marca;
	}
	private String Categoria;
	public String getCategoria() { 
		return Categoria;
	}
	public void setCategoria(String Categoria) { 
		this.Categoria = Categoria;
	}
	private String estado = "";
	public String getEstado() { 
		return estado;
	}
	public void setEstado(String estado) { 
		this.estado = estado;
	}

}