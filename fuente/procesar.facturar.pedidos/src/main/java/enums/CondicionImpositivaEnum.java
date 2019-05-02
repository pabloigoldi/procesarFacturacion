package enums;

public enum CondicionImpositivaEnum {

	IVA_RESPONSABLE_INSCRIPTO(1), MONOTRIBUTO(2), IVA_RESPONSABLE_NO_INSCRIPTO(3);

	private int condicionImpositiva;

	private CondicionImpositivaEnum(int condicionImpositiva) {
		this.condicionImpositiva = condicionImpositiva;
	}

	public int getCondicionImpositiva() {
		return condicionImpositiva;
	}
}
