import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntradaDatos entrada = new EntradaDatos();
        ArrayList<Cliente> historialClientes = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar nuevo comprador");
            System.out.println("2. Solicitar boletos");
            System.out.println("3. Ver solicitudes anteriores");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    Cliente nuevoCliente = entrada.crearCliente();
                    historialClientes.add(nuevoCliente);
                    break;

                case 2:
                    if (historialClientes.isEmpty()) {
                        System.out.println("No hay compradores registrados. Registre uno primero.");
                    } else {
                        Cliente clienteActual = historialClientes.get(historialClientes.size() - 1);
                        VentaBoleto venta = new VentaBoleto();
                        entrada.solicitarBoletos(clienteActual, venta);
                    }
                    break;

                case 3:
                    if (historialClientes.isEmpty()) {
                        System.out.println("No hay solicitudes registradas.");
                    } else {
                        System.out.println("=== Historial de compradores ===");
                        for (Cliente c : historialClientes) {
                            c.mostrarCliente();
                            System.out.println("-----------------------------");
                        }
                    }
                    break;

                case 4:
                    continuar = false;
                    System.out.println("Gracias por usar el sistema.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println(); // Separación visual
        }

        scanner.close();
    }
}