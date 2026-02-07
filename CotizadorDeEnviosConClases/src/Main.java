import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputDataValidator inputValidator = new InputDataValidator();
        ShippingCalculator calculator = new ShippingCalculator();

        System.out.println("ENVÍOS");

        double pesoKg = inputValidator.leerDoubleEnRango(sc, "Ingresa el peso (0.1 - 50.0 Kg):", 0.1, 50.0);
        int distanciaKm = inputValidator.leerIntEnRango(sc, "Ingresa la distancia (1 - 2000 Km):", 1, 2000);
        int tipoServicio = inputValidator.leerIntEnRango(sc, "Tipo de servicio: 1) Estándar  2) Express", 1, 2);
        boolean esZonaRemota = inputValidator.leerBoolean(sc, "¿Es zona remota? (true/false):");

        double subtotal = calculator.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        double iva = calculator.calcularIVA(subtotal);
        double totalFinal = calculator.calcularTotal(subtotal, iva);

        imprimirTicket(tipoServicio, pesoKg, distanciaKm, esZonaRemota, subtotal, iva, totalFinal);
    }
    public static void imprimirTicket(int servicio, double peso, int distancia, boolean remota, double sub, double iva, double total) {
        System.out.println("ticket de envio");
        System.out.print("Servicio: ");
        if(servicio == 1) System.out.println("Estándar"); else System.out.println("Express");

        System.out.println("Peso: "+ peso +" Kg");
        System.out.println("Distancia: "+ distancia +" Km");
        System.out.println("Zona Remota: "+ remota);
        System.out.println("Subtotal:  $"+ sub);
        System.out.println("IVA (16%): $"+ iva);
        System.out.println("TOTAL:     $"+ total);
    }
}