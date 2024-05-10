package ShoeStore.ShoeStore.Entity.Operational;


import java.sql.Date;

import ShoeStore.ShoeStore.Entity.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta extends ABaseEntity {


	@Column(name="total",nullable = false)
	private String total;

	
	@Column(name="fecha_venta",nullable = false)
	private Date date;
	
	 @ManyToOne(fetch = FetchType.EAGER, optional = false)
	 @JoinColumn(name = "cliente_id", nullable = false)
	  private Cliente cliente;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	 
	
	
}
