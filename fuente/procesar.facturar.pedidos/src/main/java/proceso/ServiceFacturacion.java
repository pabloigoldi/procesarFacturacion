package proceso;

import java.util.List;

import modelo.Pedido;

import dao.FacturacionDAO;
import dao.PedidoDAO;
import dto.FacturacionDTO;
import bo.FacturaBO;
import bo.PedidoBO;

public class ServiceFacturacion {

	public void crearFacturacion() {

		try {
			PedidoDAO pedidoDAO = new PedidoDAO();
			System.out.println(" COMIENZA LA BUSQUEDA DE PEDIDOS.");
			List<Pedido> pedidos = pedidoDAO.getPedidos();
			System.out.println(" FINALIZA LA BUSQUEDA DE PEDIDOS.");

			System.out.println(" COMIENZA PROCESAMIENTO DE LA FACTURACION.");
			for (Pedido pedido : pedidos) {
				FacturaBO facturaBO = new FacturaBO(pedido);
				facturaBO.run();
			}
			System.out.println(" FIN DEL PROCESAMIENTO DE LA FACTURACION.");
		} catch (Exception e) {
			System.out.println(" ERROR AL PROCESAR LA FACTURACION. "
					+ e.getMessage());
		}
	}

	public void anularFacturacion() {

		try {
			FacturacionDAO facturacionDAO = new FacturacionDAO();
			System.out.println(" COMIENZA LA BUSQUEDA DE FACTURAS A ANULAR.");
			List<FacturacionDTO> facturas = facturacionDAO
					.getFacturasParaAnular();
			System.out.println(" FINALIZA LA BUSQUEDA DE FACTURAS A ANULAR.");
			System.out.println(" COMIENZA ANULACION DE LA FACTURAS.");
			for (FacturacionDTO factura : facturas) {
				PedidoBO pedidoBO = new PedidoBO(factura);
				pedidoBO.run();
			}
			System.out.println(" FINALIZA ANULACION DE LA FACTURAS.");

		} catch (Exception e) {
			System.out.println(" ERROR AL ANULAR LA FACTURAS. "
					+ e.getMessage());
		}
	}

}
