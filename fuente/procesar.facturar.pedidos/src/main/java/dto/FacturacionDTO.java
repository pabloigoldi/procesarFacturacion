package dto;

public class FacturacionDTO implements DataTransferObject {

	private static final long serialVersionUID = 1L;

	private Long nroCliente;
	private String tipoDocumento;
	private char letra;
	private Long numero;
	private String fechaEmision;
	private Double monto;

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(Long nroCliente) {
		this.nroCliente = nroCliente;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	@Override
	public String toString() {
		return "[nroCliente=" + nroCliente + ", tipoDocumento=" + tipoDocumento
				+ ", letra=" + letra + ", numero=" + numero + ", fechaEmision="
				+ fechaEmision + ", monto=" + monto + "]";
	}

}
