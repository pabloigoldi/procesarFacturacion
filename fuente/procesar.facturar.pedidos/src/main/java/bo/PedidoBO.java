package bo;

import dto.FacturacionDTO;
import modelo.Factura;

public class PedidoBO extends Thread {

	public FacturacionDTO facturacionDTO;

	public PedidoBO(FacturacionDTO facturacionDTO) throws Exception {
		this.facturacionDTO = facturacionDTO;
	}

	@Override
	public void run() {
		this.sleep(1);
		System.out.println("Se anula el siguiente pedido:"); 
		System.out.println(facturacionDTO.toString());
		System.out.println("*******************************************");
	}


	private void sleep(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}


}
