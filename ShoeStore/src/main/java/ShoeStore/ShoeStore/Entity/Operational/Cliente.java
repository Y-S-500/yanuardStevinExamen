package ShoeStore.ShoeStore.Entity.Operational;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import ShoeStore.ShoeStore.Entity.ABaseEntity;
import ShoeStore.ShoeStore.Entity.Parameter.Ciudad;

@Entity
@Table(name = "clientes")
public class Cliente extends ABaseEntity {
	  @Column(name = "nombre_cliente", length = 50, nullable = false)
	    private String nombreCliente;
	    
	    @Column(name = "apellido_cliente", length = 50, nullable = false)
	    private String apellidoCliente;
	    
	   
	    
	    @Column(name = "telefono", length = 15, nullable = false)
	    private String telefono;
	    
	    @Column(name = "tipo_indentificacion", nullable = false)
	    private String tipoIndentificacion;
	    
	    @Column(name = "indentificacion", length = 10, nullable = false)
	    private String indentificacion;
	    
	    @Column(name = "direccion", length = 100, nullable = false)
	    private String direccion;
	    
	    
	    
	    
	    @ManyToOne(fetch = FetchType.EAGER, optional = false)
		@JoinColumn(name = "Ciudad_id", nullable = false)
	    private Ciudad ciudad;
	    
	    


		public String getNombreCliente() {
			return nombreCliente;
		}


		public void setNombreCliente(String nombreCliente) {
			this.nombreCliente = nombreCliente;
		}


		public String getApellidoCliente() {
			return apellidoCliente;
		}


		public void setApellidoCliente(String apellidoCliente) {
			this.apellidoCliente = apellidoCliente;
		}


		public String getTelefono() {
			return telefono;
		}


		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}


		
		public String getTipoIndentificacion() {
			return tipoIndentificacion;
		}


		public void setTipoIndentificacion(String tipoIndentificacion) {
			this.tipoIndentificacion = tipoIndentificacion;
		}


		public String getIndentificacion() {
			return indentificacion;
		}


		public void setIndentificacion(String indentificacion) {
			this.indentificacion = indentificacion;
		}


		public String getDireccion() {
			return direccion;
		}


		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}


		public Ciudad getCiudad() {
			return ciudad;
		}


		public void setCiudad(Ciudad ciudad) {
			this.ciudad = ciudad;
		}
	    
	    

	

}
