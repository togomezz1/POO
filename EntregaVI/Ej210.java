class Pedido{
    
public void calcularPedido(String primerPlato,double costoPrimerPlato, String bebida, double costoBebida){
    double total = costoPrimerPlato + costoBebida;
    System.out.println("El costo de "+ primerPlato + " y " + bebida + " es = $ "+ total);
}


public void calcularPedido(String primerPlato,double costoPrimerPlato, String segundoPlato, double costosegundoPlato, String bebida, double costoBebida){
    double total = costoPrimerPlato + costosegundoPlato + costoBebida;
    System.out.println("El costo de "+ primerPlato + "," + segundoPlato + " y " + bebida + " es = $ " + total);
}


public void calcularPedido(String primerPlato,double costoPrimerPlato, String segundoPlato, double costosegundoPlato, String bebida, double costoBebida, String postre, double costoPostre){
    double total = costoPrimerPlato + costosegundoPlato + costoBebida + costoPostre;
    System.out.println("El costo de "+ primerPlato + "," + segundoPlato + "," + postre + " y " + bebida + " es = $ " + total);
}

}

public class Ej210 {

    public static void main(String[] args) {
        Pedido pedido1 = new Pedido();
        pedido1.calcularPedido("Sancocho", 5000,"Gaseosa", 2000);
        Pedido pedido2 = new Pedido();
        pedido2.calcularPedido("Crema de verduras", 5000, "Churrasco", 6000, "Gaseosa", 2000);
        Pedido pedido3 = new Pedido();
        pedido3.calcularPedido("Crema de espinacas", 5000, "Salmón", 10000, "Gaseosa", 2000, "Tiramisú", 5000);
    }
}