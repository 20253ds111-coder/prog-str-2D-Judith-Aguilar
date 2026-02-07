public class ShippingCalculator {

    private final double IVA = 0.16;
    private final double PRECIO_BASE_ESTANDAR = 50;
    private final double PRECIO_BASE_EXPRESS = 90;
    private final double PRECIO_POR_KG = 12;

    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota){
        double acumulado = 0;

        if (tipoServicio == 1){
            acumulado += PRECIO_BASE_ESTANDAR;
        } else {
            acumulado += PRECIO_BASE_EXPRESS;
        }
        acumulado += (pesoKg * PRECIO_POR_KG);

        if (distanciaKm <= 50){
            acumulado += 20;
        } else if (distanciaKm >= 51 && distanciaKm <= 200){
            acumulado += 60;
        } else {
            acumulado += 120;
        }
        if (zonaRemota == true) {
            acumulado = acumulado * 1.10; // Multiplicar por 1.10 es sumar el 10%
        }
        return acumulado;
    }
    public double calcularIVA(double subtotal){
        return subtotal * IVA;
    }
    public double calcularTotal(double subtotal, double iva){
        return subtotal + iva;
    }
}