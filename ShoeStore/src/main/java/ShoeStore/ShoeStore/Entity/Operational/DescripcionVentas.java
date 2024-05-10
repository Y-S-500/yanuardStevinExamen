package ShoeStore.ShoeStore.Entity.Operational;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import ShoeStore.ShoeStore.Entity.ABaseEntity;

@Entity
@Table(name = "descripcion_ventas")
public class DescripcionVentas extends ABaseEntity {

	@Column(name="cantidad",nullable = false)
	private Integer cantidad;
	
	
	@Column(name="precio",nullable = false)
	private Double precio;
	
	@Column(name="descuento",nullable = false)
	private Double descuento;
	
	@Column(name="sub_total",nullable = false)
	private Double subTotal;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ventas_id", nullable = false)
    private Venta venta;
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "productos_id", nullable = false)
    private Producto producto;


	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
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

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	
	

}
