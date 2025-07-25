import java.util.Scanner;

public class EntradaDatos {
    private Scanner scanner;

    public EntradaDatos() {
        scanner = new Scanner(System.in);
    }

    // Método para registrar un nuevo cliente desde consola
    public Cliente crearCliente() {
        System.out.print("Ingrese nombre del comprador: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese DPI del comprador: ");
        long dpi = scanner.nextLong();

        System.out.print("Ingrese cantidad de boletos que desea comprar: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese su presupuesto máximo: Q");
        double presupuesto = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer

        Cliente cliente = new Cliente(nombre, dpi, cantidad, presupuesto);
        System.out.println("Cliente registrado exitosamente.\n");
        cliente.mostrarCliente(); 

        return cliente;
    }

    // Método para interactuar con VentaBoleto y procesar la solicitud
    public void solicitarBoletos(Cliente cliente, VentaBoleto venta) {
        venta.mostrarInformacion();

        System.out.println("\nProcesando solicitud...");
        int cantidadSolicitada = cliente.getCantidadBoletos();
        double total = venta.getPrecio() * cantidadSolicitada;

        if (total <= cliente.getPresupuestoMaximo() && venta.venderBoletos(cantidadSolicitada)) {
            System.out.println("Solicitud aprobada.");
            System.out.println("Total a pagar: Q" + total);
            System.out.println("Boletos confirmados para " + cliente.getNombre());
        } else {
            System.out.println("Solicitud rechazada. Verifique disponibilidad o presupuesto.");
        }
    }
}