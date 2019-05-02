package modelo;


public class NotaCredito {

	private Cabecera cabecera;
	private Detalle detalle;
	private Pie pie;

	public Cabecera getCabecera() {
		return cabecera;
	}

	public void setCabecera(Cabecera cabecera) {
		this.cabecera = cabecera;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public Pie getPie() {
		return pie;
	}

	public void setPie(Pie pie) {
		this.pie = pie;
	}

}
