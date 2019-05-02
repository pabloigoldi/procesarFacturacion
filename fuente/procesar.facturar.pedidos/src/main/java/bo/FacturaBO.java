package bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.DateUtil;
import util.DoubleUtil;
import dto.FacturacionDTO;
import enums.CondicionImpositivaEnum;
import modelo.CabeceraFactura;
import modelo.Detalle;
import modelo.DetalleFactura;
import modelo.Factura;
import modelo.Pedido;
import modelo.PieFactura;
import modelo.Producto;

public class FacturaBO extends Thread {

	public Pedido pedido;

	public FacturaBO(Pedido pedido) throws Exception {
		this.pedido = pedido;
	}

	@Override
	public void run() {
		this.sleep(1);
		Factura factura = this.buildFactura(pedido);
		FacturacionDTO facturacionDTO = this.buildFactura(factura); 
		System.out.println(facturacionDTO.toString());
		System.out.println("*******************************************");
	}
	
	
	public FacturacionDTO getFacturacionDTO(Pedido pedido) {
		Factura factura = this.buildFactura(pedido);
		FacturacionDTO facturacionDTO = this.buildFactura(factura); 
		return facturacionDTO;
	}

	private FacturacionDTO buildFactura(Factura factura) {
		FacturacionDTO facturacionDTO = new FacturacionDTO();
		
		facturacionDTO.setNroCliente (factura.getCabeceraFactura().getCliente().getNro());
		facturacionDTO.setTipoDocumento(factura.getCabeceraFactura().getCliente().getTipoDocumento().toString());
		facturacionDTO.setLetra(factura.getCabeceraFactura().getLetra());
		facturacionDTO.setNumero(factura.getCabeceraFactura().getNumero());
		facturacionDTO.setFechaEmision(factura.getCabeceraFactura().getFechaEmision().toString());
		facturacionDTO.setMonto(DoubleUtil.format(factura.getPieFactura().getTotal(),DoubleUtil.DOS_DECIMALES));
		
		return facturacionDTO;
	}

	private void sleep(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	private Factura buildFactura(Pedido pedido) {
		Factura factura = new Factura();
		CabeceraFactura cabeceraFactura = new CabeceraFactura();
		Long codigoEmision = new Random().nextLong();
		cabeceraFactura.setCodigoEmision(codigoEmision);
		cabeceraFactura.setCliente(pedido.getCliente());
		cabeceraFactura.setFechaEmision(DateUtil.getDateCurrent());

		Long numero = new Random().nextLong();
		cabeceraFactura.setNumero(numero);
		char letraFactura = ' ';
		if (pedido.getCliente().getCondicioImpositiva() == CondicionImpositivaEnum.IVA_RESPONSABLE_INSCRIPTO) {
			letraFactura = 'A';
		} else if (pedido.getCliente().getCondicioImpositiva() == CondicionImpositivaEnum.MONOTRIBUTO) {
			letraFactura = 'B';
		} else {
			letraFactura = 'X';
		}
		cabeceraFactura.setLetra(letraFactura);
		factura.setCabeceraFactura(cabeceraFactura);

		List<DetalleFactura> listDetalleFactura = new ArrayList<DetalleFactura>();

		Double totalIVA = 0.0;
		Double totalFactura = 0.0;
		for (Detalle detalle : pedido.getDetalles()) {
			DetalleFactura detalleFactura = new DetalleFactura();

			Producto producto = detalle.getProducto();
			Double precioUnitario = detalle.getProducto().getPrecio();
			Double precioNeto = precioUnitario * detalle.getCantidad();
			Double IVA = 0.0;
			Double montoIVA = 0.0;

			if (pedido.getCliente().getCondicioImpositiva() == CondicionImpositivaEnum.IVA_RESPONSABLE_INSCRIPTO) {
				montoIVA = precioNeto * 1.1;
				IVA = 10.0;
			} else if (pedido.getCliente().getCondicioImpositiva() == CondicionImpositivaEnum.MONOTRIBUTO) {
				montoIVA = precioNeto * 21;
				IVA = 21.0;
			} else {
				montoIVA = precioNeto * 70;
				IVA = 70.0;
			}

			Double precioVenta = precioNeto + montoIVA;
			detalleFactura.setCantidad(detalle.getCantidad());
			detalleFactura.setIVA(IVA);
			detalleFactura.setMontoIVA(DoubleUtil.format(montoIVA,DoubleUtil.DOS_DECIMALES));
			detalleFactura.setPrecioNETO(DoubleUtil.format(precioNeto,DoubleUtil.DOS_DECIMALES));
			detalleFactura.setPrecioVenta(DoubleUtil.format(precioVenta,DoubleUtil.DOS_DECIMALES));
			detalleFactura.setProducto(producto);
			listDetalleFactura.add(detalleFactura);

			totalIVA = totalIVA + IVA;
			totalFactura = totalFactura + precioVenta;
		}

		factura.setDetalleFactura(listDetalleFactura);

		PieFactura pieFactura = new PieFactura();
		pieFactura.setTotal(DoubleUtil.format(totalFactura,DoubleUtil.DOS_DECIMALES));
		pieFactura.setTotalIVA(DoubleUtil.format(totalIVA,DoubleUtil.DOS_DECIMALES));
		factura.setPieFactura(pieFactura);
		return factura;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
