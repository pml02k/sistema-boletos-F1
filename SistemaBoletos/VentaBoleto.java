import java.util.Random;

public class VentaBoleto {
    private double precio;
    private int cantidadDisponible;
    private String descripcion;

    private Random generador;

    // Constructor con categorías predefinidas
    public VentaBoleto() {
        generador = new Random();
        asignarCategoria();
    }

    // Asignación aleatoria de categoría y parámetros
    private void asignarCategoria() {
        int categoria = generador.nextInt(3); // 0, 1, 2

        switch (categoria) {
            case 0:
                descripcion = "General";
                precio = 350.00;
                cantidadDisponible = 200;
                break;
            case 1:
                descripcion = "Preferencial";
                precio = 650.00;
                cantidadDisponible = 100;
                break;
            case 2:
                descripcion = "VIP";
                precio = 1200.00;
                cantidadDisponible = 50;
                break;
        }
    }

    // Métodos para consultar datos
    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    // Método para reducir disponibilidad al confirmar venta
    public boolean venderBoletos(int cantidadSolicitada) {
        if (cantidadSolicitada <= cantidadDisponible) {
            cantidadDisponible -= cantidadSolicitada;
            return true;
        } else {
            return false;
        }
    }
    // Muestra info de la categoría actual
    public void mostrarInformacion() {
        System.out.println("Categoría: " + descripcion);
        System.out.println("Precio por boleto: Q" + precio);
        System.out.println("Boletos disponibles: " + cantidadDisponible);
    }
}