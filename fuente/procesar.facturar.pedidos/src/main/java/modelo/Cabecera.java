package modelo;

public class Cabecera {

	private String fechaEmision;
	private char letra;
	private Long numero;
	private Cliente cliente;

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

}
