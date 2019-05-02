package modelo;

import java.util.List;


public class Factura {

	private CabeceraFactura cabeceraFactura;
	private List<DetalleFactura>  detalleFactura;
	private PieFactura pieFactura;

	public CabeceraFactura getCabeceraFactura() {
		return cabeceraFactura;
	}

	public void setCabeceraFactura(CabeceraFactura cabeceraFactura) {
		this.cabeceraFactura = cabeceraFactura;
	}


	public List<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

	public PieFactura getPieFactura() {
		return pieFactura;
	}

	public void setPieFactura(PieFactura pieFactura) {
		this.pieFactura = pieFactura;
	}

}
