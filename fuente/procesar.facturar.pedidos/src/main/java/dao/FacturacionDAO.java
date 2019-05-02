package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Pedido;
import bo.FacturaBO;
import dto.FacturacionDTO;

public class FacturacionDAO {


	public List<FacturacionDTO> getFacturasParaAnular() {
		List<FacturacionDTO> facturasDTO = new ArrayList<FacturacionDTO>();
		try {
			PedidoDAO pedidoDAO = new PedidoDAO();
			List<Pedido> pedidos = pedidoDAO.getPedidos();
			for (Pedido pedido: pedidos){
				FacturaBO facturaBO = new FacturaBO(pedido);
				FacturacionDTO facturacionDTO = facturaBO.getFacturacionDTO(pedido);
				facturasDTO.add(facturacionDTO);
			}
		} catch (Exception e) {
			System.out.println("ERROR AL BUSCAR FACTURAS A ANULAR." + e.getMessage());
		}
		return facturasDTO;
	}


}
