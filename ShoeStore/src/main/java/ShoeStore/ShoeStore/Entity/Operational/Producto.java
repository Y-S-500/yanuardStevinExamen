package ShoeStore.ShoeStore.Entity.Operational;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import ShoeStore.ShoeStore.Entity.ABaseEntity;

@Entity
@Table(name="productos")
public class Producto extends ABaseEntity{
	@Column(name="state", nullable = false)
	private Boolean state;

	
	@Column(name="nombre_producto",nullable = false)
	private String nombreProducto;
	
	@Column(name="descripcion",nullable = false)
	private String description;
	
	@Column(name="cantidad",nullable = false)
	private Integer cantidad;
	
	@Column(name="precio",nullable = false)
	private Double precio;
	
	@Column(name="porcentaje_iva",nullable = false)
	private int ProcentajeIva;
	
	@Column(name="porcentaje_descuento",nullable = false)
	private int ProcentajeDescuento;
	
	

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getProcentajeIva() {
		return ProcentajeIva;
	}

	public void setProcentajeIva(int procentajeIva) {
		ProcentajeIva = procentajeIva;
	}

	public int getProcentajeDescuento() {
		return ProcentajeDescuento;
	}

	public void setProcentajeDescuento(int procentajeDescuento) {
		ProcentajeDescuento = procentajeDescuento;
	}

}
