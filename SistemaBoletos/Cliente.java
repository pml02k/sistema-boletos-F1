import java.util.Random;

public class Cliente {
    // Atributos del comprador
    private String nombre;
    private long dpi;
    private int cantidadBoletos;
    private double presupuestoMaximo;
    private long ticket;

    // Generador de tickets
    private Random generador;

    // Constructor
    public Cliente(String nombre, long dpi, int cantidadBoletos, double presupuestoMaximo) {
        this.nombre = nombre;
        this.dpi = dpi;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuestoMaximo = presupuestoMaximo;
        this.generador = new Random();
        this.ticket = generarTicket();
    }

    // Genera un código único de ticket
    private long generarTicket() {
        return 100000 + generador.nextInt(900000); // Código de 6 dígitos
    }

    // Métodos getters para mostrar información del cliente
    public String getNombre() {
        return nombre;
    }

    public long getDpi() {
        return dpi;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }

    public long getTicket() {
        return ticket;
    }

    // Muestra los datos del cliente
    public void mostrarCliente() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DPI: " + dpi);
        System.out.println("Cantidad de boletos: " + cantidadBoletos);
        System.out.println("Presupuesto máximo: Q" + presupuestoMaximo);
        System.out.println("Ticket asignado: " + ticket);
    }
}