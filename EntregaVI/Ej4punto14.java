class Profesor{
    public void imprimir(){
        System.out.println("Es un profesor");
    }
}

class ProfesorTitular extends Profesor{
    public void imprimir(){
        System.out.println("Es un profesor titular");
    }
}

public class Ej4punto14 {
    public void main(String[] args){
        Profesor profesor = new ProfesorTitular();
        profesor.imprimir();
    }
}
