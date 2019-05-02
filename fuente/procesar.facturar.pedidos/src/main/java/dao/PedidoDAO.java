package dao;

import io.FileManager;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import enums.CondicionImpositivaEnum;
import enums.TipoDocumentoEnum;
import modelo.Cliente;
import modelo.Detalle;
import modelo.Pedido;
import modelo.Producto;
import proceso.Constants;

public class PedidoDAO {


	public List<Pedido> getPedidos() throws Exception {

		List<Pedido> pedidos = null;
		FileManager fileManager = null;

		try {

			pedidos = new ArrayList<Pedido>();

			fileManager = new FileManager();
			fileManager.setFileWriterName(Constants.FILE_INFORME_DIARIO_FACTURACION);
			fileManager.setFileWriterPath("");
			BufferedReader buffer = fileManager.openForReading();
			System.out.println("Se lee los datos del archivo...: ["				+ fileManager.fileWriterName + "]");
			String linea;
			while ((linea = buffer.readLine()) != null) {				
				pedidos.add(this.buildPedido(linea));
			}
		} catch (Exception e) {
			System.out.println("Error al buscar Pedidos." + e.getMessage());
			throw e;
		} finally {
			try {
				if (fileManager != null)
					fileManager.closeReader();
			} catch (Exception e) {
				System.out.println("Error al cerrar archivo." + e.getMessage());
			}
		}

		return pedidos;

	}

	private Pedido buildPedido(String linea) throws Exception {
		Pedido pedido = new Pedido();

		try {
			String[] datos = linea.split("\\|");
			pedido.setNombre(datos[0]);
			pedido.setCliente(this.buildCliente(datos[1].split("#")));
			pedido.setDetalles(this.buildDetalle(datos[2].split("#")));
		} catch (Exception e) {
			System.out.println("ERROR EN PARSEO DE PEDIDO."+ e.getMessage());
			throw e;
		}

		return pedido;
	}

	private Cliente buildCliente(String[] datoCliente) throws Exception {
		Cliente cliente = new Cliente();

		try {

			cliente.setNro(new Long(datoCliente[0]));
			cliente.setDomicilio(datoCliente[1]);
			Integer datoCondicionImpositiva = Integer.parseInt(datoCliente[2]);

			if (CondicionImpositivaEnum.IVA_RESPONSABLE_INSCRIPTO
					.getCondicionImpositiva() == datoCondicionImpositiva) {
				cliente.setCondicioImpositiva(CondicionImpositivaEnum.IVA_RESPONSABLE_INSCRIPTO);
			} else if (CondicionImpositivaEnum.MONOTRIBUTO
					.getCondicionImpositiva() == datoCondicionImpositiva) {
				cliente.setCondicioImpositiva(CondicionImpositivaEnum.MONOTRIBUTO);
			} else if (CondicionImpositivaEnum.IVA_RESPONSABLE_NO_INSCRIPTO
					.getCondicionImpositiva() == datoCondicionImpositiva) {
				cliente.setCondicioImpositiva(CondicionImpositivaEnum.IVA_RESPONSABLE_NO_INSCRIPTO);
			} else {
				throw new Exception("CLIENTE - CONDICION IMPOSITIVA NO INFORMADA.");
			}

			Integer datoTipoDocumento = Integer.parseInt(datoCliente[3]);
			if (TipoDocumentoEnum.DNI.getTipoDocumento() == datoTipoDocumento) {
				cliente.setTipoDocumento(TipoDocumentoEnum.DNI);
			} else if (TipoDocumentoEnum.CUIT.getTipoDocumento() == datoTipoDocumento) {
				cliente.setTipoDocumento(TipoDocumentoEnum.CUIT);
			} else if (TipoDocumentoEnum.LE.getTipoDocumento() == datoTipoDocumento) {
				cliente.setTipoDocumento(TipoDocumentoEnum.LE);
			} else if (TipoDocumentoEnum.CUIL.getTipoDocumento() == datoTipoDocumento) {
				cliente.setTipoDocumento(TipoDocumentoEnum.CUIL);
			} else if (TipoDocumentoEnum.LC.getTipoDocumento() == datoTipoDocumento) {
				cliente.setTipoDocumento(TipoDocumentoEnum.LC);
			} else {
				throw new Exception("CLIENTE - TIPO DE DOCUMENTO NO INFORMADO.");
			}

			cliente.setNroDocumento(new Long(datoCliente[4]));

		} catch (Exception e) {
			System.out.println("ERROR EN PARSEO DE CLIENTE."+ e.getMessage());
			throw e;
		}

		return cliente;
	}

	private List<Detalle> buildDetalle(String[] datoDetalles) throws Exception {
		List<Detalle> detalles = new ArrayList<Detalle>();
		try {
			Detalle detalle = null;
			Producto producto = null;
			for (int i = 0; i < datoDetalles.length; i++) {
				String[] datosProduto = datoDetalles[i].split("\\*");
				detalle = new Detalle();
				producto = new Producto();
				producto.setCodigo(new Long(datosProduto[0]));
				producto.setNombre(datosProduto[1]);
				producto.setPrecio(new Double(datosProduto[2]));
				detalle.setProducto(producto);
				detalle.setCantidad(Integer.valueOf(datosProduto[3]));
				detalles.add(detalle);
			}

		} catch (Exception e) {
			System.out.println("ERROR EN PARSEO DE DETALLE." + e.getMessage());
			throw e;
		}
		return detalles;
	}
}
