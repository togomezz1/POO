class articuloCientifico{
    String titulo; 
    String autor; 
    String[] palabrasClaves = new String[3];
    String publicacion; 
    int año; 
    String resumen; 
    public articuloCientifico(String titulo, String autor){
        this.titulo = titulo; 
        this.autor = autor;
    }
    public articuloCientifico(String titulo, String autor, String[] palabrasClaves, String publicacion, int año){
        this(titulo,autor);
        this.palabrasClaves = palabrasClaves;
        this.publicacion = publicacion;
        this.año = año;
    }
    public articuloCientifico(String titulo, String autor, String[] palabrasClaves, String publicacion, int año, String resumen){
        this(titulo,autor,palabrasClaves,publicacion,año);
        this.resumen = resumen;
    }
    public void imprimir(){
        System.out.println("El título del artículo cientifico es: " + titulo);
        System.out.println("El autor del artículo cientifico es: " + autor);
        System.out.println("Palabras claves del artículo cientifico son: " );
        for (int i = 0; i < palabrasClaves.length; i++){
            System.out.println(palabrasClaves[i]);
        }
        System.out.println("Nombre de la publicación del artículo cientifico es: " + publicacion);
        System.out.println("El año de publicación del artículo cientifico es: " + año);
        System.out.println("El resumen del artículo cientifico es: " + resumen);
        }
}

public class Ej211 {
    public static void main(String[] args){
    String[] palabras = {"Quantum Mechanics", "Quantum Electrodynamics", "Uncertainty principle"};
    articuloCientifico articulo = new articuloCientifico("Relativistic quantum mechanics","Paul Dirac", palabras, "Physics Review", 1935, "The electron is a particle with an intrisic quantum spin of semi half integer" );
    articulo.imprimir();
    }
}
