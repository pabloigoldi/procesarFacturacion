package enums;

public enum TipoDocumentoEnum {

	DNI(1), CUIT(2), LE(3), CUIL(4), LC(5);

	private int tipoDocumento;

	private TipoDocumentoEnum(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getTipoDocumento() {
		return tipoDocumento;
	}

}
