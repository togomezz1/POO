import java.util.Scanner;

enum tipoCuenta{
    AHORROS, CORRIENTE};
class Cuentabancaria{
    // Elementos de la cuenta bancaria 

    String nombre; 
    String apellidos; 
    int numero; 
    float saldocuenta = 0; 
    tipoCuenta tipo; 

    // Constructor de la clase
    Cuentabancaria(String nombre, String apellidos, int numero,tipoCuenta tipo, float saldocuenta ){
    this.nombre = nombre; 
    this.apellidos = apellidos; 
    this.numero = numero; 
    this.tipo = tipo; 
    this.saldocuenta = saldocuenta;
}

    void Imprimir(){
        System.out.println("El nombre del titular de la cuenta es: " + nombre);
        System.out.println("El apellido del titular de la cuenta es: " + apellidos);
        System.out.println("El número de la cuenta es: " + numero);
        System.out.println("El tipo de cuenta es: " + tipo);
        System.out.println("El saldo de la cuenta es: " + saldocuenta);
    }

    void ConsultarSaldo(){
        System.out.println("El saldo actual es: " + saldocuenta);
    }

    // Consignacion de un valor

    boolean consignar(int valor) {
    if (valor > 0) {
    saldocuenta = saldocuenta + valor; /* Se actualiza el saldocuenta de la cuenta con
    el valor consignado */
    System.out.println("Se ha consignado $" + valor + " en la cuenta " + " El nuevo saldo es $" + saldocuenta);
    return true;
    } else {
    System.out.println("El valor a consignar debe ser mayor que cero");
    return false;
    }
}

    // Retirar un valor de la cuenta bancaria

    boolean retirar(int valor) {
        if ((valor > 0) && (valor <= saldocuenta)) {
        saldocuenta = saldocuenta - valor;
        System.out.println("Se ha retirado $" + valor + " en la cuenta, el nuevo saldo es $" + saldocuenta);
        return true;
        } else {
        System.out.println("El valor a retirar debe ser menor que el saldo actual.");
        return false;
        }
        }
    
    boolean interes(float porcentaje){
        if (saldocuenta>0){
            float val = saldocuenta * (porcentaje/100);
            System.out.println("El interes mensual en la cuenta es: " + val);
            return true;
        } else{
            System.out.println("No hay interes mensual");
            return false;
        }
    }

    boolean interesAplicado(float porcentaje){
        if (saldocuenta>0){
            float val = saldocuenta * (porcentaje/100);
            saldocuenta = saldocuenta + val;
            System.out.println("El saldo con el interes aplicado es: " + saldocuenta);
            return true;
        } else{
            System.out.println("No hay interes mensual");
            return false;
        }
    }


}


public class Ejercicio2punto5{
     public static void main(String args[]){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese el nombre del titular: ");
        String nombre = teclado.nextLine();

        System.out.println("Ingrese los apellidos del titular: ");
        String apellidos = teclado.nextLine();

        System.out.println("Ingrese el numero de cuenta: ");
        int numero = teclado.nextInt();

        int saldoinicial = 0; 

        // Creacion de la cuenta bancaria 
        Cuentabancaria cuentaUsuario = new Cuentabancaria(nombre, apellidos, numero, tipoCuenta.AHORROS, saldoinicial);
        teclado.close();

        cuentaUsuario.Imprimir();
        cuentaUsuario.consignar(200000);
        cuentaUsuario.consignar(300000);
        cuentaUsuario.retirar(400000);
        cuentaUsuario.interes(12);
        cuentaUsuario.interesAplicado(12);


     }
}
