package proceso;

public class Main {

	public static void main(String[] args) {

		System.out.println("Incio Main.");
		try {
 			ServiceFacturacion serviceFacturacion = new ServiceFacturacion();
			serviceFacturacion.crearFacturacion();
			serviceFacturacion.anularFacturacion();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Fin Main.");
	}
}
