import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class Cilindro extends FiguraGeometrica{
    double radio; 
    double altura; 
    public Cilindro(double radio, double altura){
        super(calcVo(radio,altura),calcSo(radio,altura));
        this.radio = radio;
        this.altura = altura; 
    }
    private static double calcVo(double r, double h) {
        return Math.PI * Math.pow(r, 2) * h;
    }

    private static double calcSo(double r, double h) {
        double surf_tapas = 2 * (Math.PI * Math.pow(r, 2));
        double surf_ext = 2 * Math.PI * r * h;
        return surf_tapas + surf_ext;
    }
    
    public double calVolumen(){
        return Math.PI* Math.pow(radio,2)*altura;
    }
    
    public double calSurface(){
        double surf_tapas = 2 * (Math.PI*Math.pow(radio,2));
        double surf_ext = 2*Math.PI*radio*altura;
        return surf_tapas + surf_ext;
    } 
}

class Esfera extends FiguraGeometrica{
    double radio; 
    public Esfera(double radio){
        super(calcVo(radio),calcSo(radio));
        this.radio = radio;
    }
    
    private static double calcVo(double r){
        return (4.0/3.0)*Math.PI*Math.pow(r,3);
    }
    private static double calcSo(double r){
        return 4 * Math.PI * Math.pow(r,2);
    }
    
    
    public double calcVolumen(){
        return (4.0/3.0)*Math.PI*Math.pow(radio,3);
    }
    public double calcSurface(){
        return 4 * Math.PI * Math.pow(radio,2);
    }
     
}

class Piramide extends FiguraGeometrica{
    double base; 
    double altura; 
    double apotema; 
    
    public Piramide(double base, double altura, double apotema){
        super(calcVo(base,altura),calcSo(base,apotema));
        this.base = base; 
        this.altura = altura; 
        this.apotema = apotema;
    }
    private static double calcVo(double base, double altura){
        double AreaBase = Math.pow(base,2);
        return (AreaBase * altura)/3;
    }
    private static double calcSo(double base, double apotema){
        double AreaBase = Math.pow(base,2);
        double AreaLateral = ((4 * base) * apotema)/2;
        return AreaBase + AreaLateral;
    }
    
    public double calcVolumen(){
        double AreaBase = Math.pow(base,2);
        return (AreaBase * altura)/3;
    }
    public double calcSurface(){
        double AreaBase = Math.pow(base,2);
        double AreaLateral = ((4 * base) * apotema)/2;
        return AreaBase + AreaLateral;
    }
    
}

class FiguraGeometrica {
    public double volumen;
    public double superficie; 
    
    public FiguraGeometrica(double volumen, double superficie){
        this.volumen = volumen; 
        this.superficie = superficie; 
    }
    public void setVolumen(double volumen){
        this.volumen = volumen;
    }
    public void setSuperficie(double superficie){
        this.superficie = superficie;
    }
    public double getVolumen(){
        return volumen; 
    }
    public double getSuperficie(){
        return superficie;
    }    
}

class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio,altura,volumen,superficie;
    private JTextField campoRadio,campoAltura;
    private JButton calcular;

    public VentanaCilindro(){
        inicio();
        setTitle("Cilindro"); 
        setSize(350,300); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
    }

    private void inicio() {
        contenedor = getContentPane(); 
        contenedor.setLayout(null); 

        radio = new JLabel("Radio (cms):");
        radio.setBounds(30, 30, 120, 23); 
        campoRadio = new JTextField();
        campoRadio.setBounds(160, 30, 140, 23);

        altura = new JLabel("Altura (cms):");
        altura.setBounds(30, 70, 120, 23); 
        campoAltura = new JTextField();
        campoAltura.setBounds(160, 70, 140, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(110, 120, 120, 30); 
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen(cm3) = ");
        volumen.setBounds(30, 170, 280, 23); 

        superficie = new JLabel("Superficie(cm2) = ");
        superficie.setBounds(30, 210, 280, 23); 


        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) { 
            try {
                double Radio, Altura, Volumen, Superficie;
                Radio = Double.parseDouble(campoRadio.getText());
                Altura = Double.parseDouble(campoAltura.getText());
                Cilindro cilindro = new Cilindro(Radio,Altura);
                Volumen = cilindro.calVolumen();
                Superficie = cilindro.calSurface();
                cilindro.volumen = Volumen; 
                cilindro.superficie = Superficie; 
                volumen.setText("Volumen(cm3) = " + String.format("%.2f", cilindro.volumen));
                superficie.setText("Superficie(cm2) = " + String.format("%.2f", cilindro.superficie));
                 } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos en todos los campos.");
            }
        }
    }
}

class VentanaEsfera extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio,volumen,superficie;
    private JTextField campoRadio;
    private JButton calcular;

    public VentanaEsfera(){
        inicio();
        setTitle("Esfera"); 
        setSize(350,260); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
    }

    private void inicio() {
        contenedor = getContentPane(); 
        contenedor.setLayout(null); 

        radio = new JLabel("Radio (cms):");
        radio.setBounds(30, 30, 120, 23); 
        campoRadio = new JTextField();
        campoRadio.setBounds(160, 30, 140, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(110, 80, 120, 30); 
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen(cm3) = ");
        volumen.setBounds(30, 140, 280, 23); 

        superficie = new JLabel("Superficie(cm2) = ");
        superficie.setBounds(30, 180, 280, 23); 


        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) { 
            try {
                double Radio,Volumen, Superficie;
                Radio = Double.parseDouble(campoRadio.getText());
                Esfera esfera = new Esfera(Radio);
                Volumen = esfera.calcVolumen();
                Superficie = esfera.calcSurface();
                esfera.volumen = Volumen; 
                esfera.superficie = Superficie; 
                volumen.setText("Volumen(cm3) = " + String.format("%.2f", esfera.volumen));
                superficie.setText("Superficie(cm2) = " + String.format("%.2f", esfera.superficie));
                 } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos en todos los campos.");
            }
        }
    }
}

class VentanaPiramide extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base,altura,apotema,volumen,superficie;
    private JTextField campoBase,campoAltura, campoApotema;
    private JButton calcular;

    public VentanaPiramide(){
        inicio();
        setTitle("Piramide"); 
        setSize(350,330); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
    }

    private void inicio() {
        contenedor = getContentPane(); 
        contenedor.setLayout(null); 

        base = new JLabel("Base (cms):");
        base.setBounds(30, 20, 120, 23); 
        campoBase = new JTextField();
        campoBase.setBounds(160, 20, 140, 23);

        altura = new JLabel("Altura (cms):");
        altura.setBounds(30, 55, 120, 23); 
        campoAltura = new JTextField();
        campoAltura.setBounds(160, 55, 140, 23);
        
        apotema = new JLabel("Apotema (cms):");
        apotema.setBounds(30, 90, 120, 23); 
        campoApotema = new JTextField();
        campoApotema.setBounds(160, 90, 140, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(110, 135, 120, 30); 
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen(cm3) = ");
        volumen.setBounds(30, 190, 280, 23); 

        superficie = new JLabel("Superficie(cm2) = ");
        superficie.setBounds(30, 230, 280, 23); 


        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(apotema);
        contenedor.add(campoApotema);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) { 
            try {
                double Base, Altura, Apotema,Volumen, Superficie;
                Base = Double.parseDouble(campoBase.getText());
                Altura = Double.parseDouble(campoAltura.getText());
                Apotema = Double.parseDouble(campoApotema.getText());
                Piramide piramide = new Piramide(Base,Altura,Apotema);
                Volumen = piramide.calcVolumen();
                Superficie = piramide.calcSurface();
                piramide.volumen = Volumen; 
                piramide.superficie = Superficie; 
                volumen.setText("Volumen(cm3) = " + String.format("%.2f", piramide.volumen));
                superficie.setText("Superficie(cm2) = " + String.format("%.2f", piramide.superficie));
                 } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos en todos los campos.");
            }
        }
    }
}

class VentanaPrincipal1 extends JFrame implements ActionListener {
    private Container contenedor;
    private JButton Cilindro, Esfera, Piramide;

    public VentanaPrincipal1(){
        inicio();
        setTitle("Figuras"); 
        setSize(480,130); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
    }

    private void inicio() {
        contenedor = getContentPane(); 
        contenedor.setLayout(null); 

        Cilindro = new JButton("Cilindro");
        Cilindro.setBounds(25, 35, 120, 23); 
        Cilindro.addActionListener(this);

        Esfera = new JButton("Esfera");
        Esfera.setBounds(175, 35, 120, 23); 
        Esfera.addActionListener(this);
        
        Piramide = new JButton("Piramide");
        Piramide.setBounds(325, 35, 120, 23); 
        Piramide.addActionListener(this);
        
        contenedor.add(Cilindro);
        contenedor.add(Esfera);
        contenedor.add(Piramide);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == Cilindro) { 
            VentanaCilindro miVentanaCilindro = new VentanaCilindro();
            miVentanaCilindro.setVisible(true);
        }
        if (evento.getSource() == Esfera) {
            VentanaEsfera miVentanaEsfera = new VentanaEsfera();
            miVentanaEsfera.setVisible(true);
        }
        if (evento.getSource() == Piramide) {
            VentanaPiramide miVentanaPiramide = new VentanaPiramide();
            miVentanaPiramide.setVisible(true);
        }
    }
}

public class Ej8P3 {
     public static void main(String args[]){
     VentanaPrincipal1 miVentanaPrincipal = new VentanaPrincipal1(); 
     miVentanaPrincipal.setVisible(true);

     } 
}
