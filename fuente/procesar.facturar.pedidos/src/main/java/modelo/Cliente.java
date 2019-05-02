package modelo;

import enums.CondicionImpositivaEnum;
import enums.TipoDocumentoEnum;


public class Cliente {

	private Long nro;
	private String domicilio;
	private CondicionImpositivaEnum condicionImpositiva;
	private TipoDocumentoEnum tipoDocumento;
	private Long nroDocumento;

	public Long getNro() {
		return nro;
	}

	public void setNro(Long nro) {
		this.nro = nro;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public TipoDocumentoEnum getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoEnum tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Long getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(Long nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public CondicionImpositivaEnum getCondicioImpositiva() {
		return condicionImpositiva;
	}

	public void setCondicioImpositiva(CondicionImpositivaEnum condicionImpositiva) {
		this.condicionImpositiva = condicionImpositiva;
	}

}
