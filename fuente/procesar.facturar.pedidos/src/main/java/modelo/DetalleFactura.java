package modelo;


public class DetalleFactura extends Detalle {

	private Double precioUnitario;
	private Double IVA;
	private int cantidad;
	private Double precioVenta;
	private Double precioNETO;
	private Double montoIVA;

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Double getIVA() {
		return IVA;
	}

	public void setIVA(Double iVA) {
		IVA = iVA;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Double getPrecioNETO() {
		return precioNETO;
	}

	public void setPrecioNETO(Double precioNETO) {
		this.precioNETO = precioNETO;
	}

	public Double getMontoIVA() {
		return montoIVA;
	}

	public void setMontoIVA(Double montoIVA) {
		this.montoIVA = montoIVA;
	}

}
