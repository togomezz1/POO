import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class stats {
    public static double mean(double[] notas){
        int n = notas.length;
        double suma = 0;
        for(int i = 0; i < n; i++){
            suma = suma + notas[i];
        }
        return suma / n;
    }

    public static double desv(double[] notas){
        int n = notas.length;
        double suma2 = 0;
        double mean_ = stats.mean(notas);
        for(double num : notas){
            suma2 = suma2 + Math.pow(num - mean_, 2);
        }
        return Math.pow(suma2 / n, 0.5);
    }

    public static double min(double[] notas){
        int n = notas.length;
        double menor = notas[0];
        for(int i = 1; i < n; i++){
            double current = notas[i];
            if (current < menor){
                menor = current;
            }
        }
        return menor;
    }

    public static double max(double[] notas){
        int n = notas.length;
        double mayor = notas[0];
        for(int i = 1; i < n; i++){
            double current = notas[i];
            if (current > mayor){
                mayor = current;
            }
        }
        return mayor;
    }
}

class calificaciones {
    double[] notas;
    double max; 
    double min;     
    double media; 
    double So; 

    calificaciones(double[] notas){
        this.notas = notas; 
        this.max = stats.max(notas); 
        this.min = stats.min(notas);     
        this.media = stats.mean(notas); 
        this.So = stats.desv(notas); 
    }
}

class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel nota1, nota2, nota3, nota4, nota5, promedio, desviación, mayor, menor;
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    private JButton calcular, limpiar;

    public VentanaPrincipal(){
        inicio();
        setTitle("Notas"); 
        setSize(280,380); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
    }

    private void inicio() {
        contenedor = getContentPane(); 
        contenedor.setLayout(null); 

        nota1 = new JLabel("Nota 1:");
        nota1.setBounds(20, 20, 135, 23); 
        campoNota1 = new JTextField();
        campoNota1.setBounds(105, 20, 135, 23);

        nota2 = new JLabel("Nota 2:");
        nota2.setBounds(20, 50, 135, 23); 
        campoNota2 = new JTextField();
        campoNota2.setBounds(105, 50, 135, 23);

        nota3 = new JLabel("Nota 3:");
        nota3.setBounds(20, 80, 135, 23); 
        campoNota3 = new JTextField();
        campoNota3.setBounds(105, 80, 135, 23);

        nota4 = new JLabel("Nota 4:");
        nota4.setBounds(20, 110, 135, 23); 
        campoNota4 = new JTextField();
        campoNota4.setBounds(105, 110, 135, 23);

        nota5 = new JLabel("Nota 5:");
        nota5.setBounds(20, 140, 135, 23); 
        campoNota5 = new JTextField();
        campoNota5.setBounds(105, 140, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(20, 170, 100, 23); 
        calcular.addActionListener(this);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(125, 170, 80, 23); 
        limpiar.addActionListener(this);

        promedio = new JLabel("Promedio = ");
        promedio.setBounds(20, 210, 135, 23); 

        desviación = new JLabel("Desviación = ");
        desviación.setBounds(20, 240, 200, 23); 

        mayor = new JLabel("Nota mayor = ");
        mayor.setBounds(20, 270, 200, 23); 

        menor = new JLabel("Nota menor = ");
        menor.setBounds(20, 300, 200, 23); 

        contenedor.add(nota1);
        contenedor.add(campoNota1);
        contenedor.add(nota2);
        contenedor.add(campoNota2);
        contenedor.add(nota3);
        contenedor.add(campoNota3);
        contenedor.add(nota4);
        contenedor.add(campoNota4);
        contenedor.add(nota5);
        contenedor.add(campoNota5);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviación);
        contenedor.add(mayor);
        contenedor.add(menor);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) { 
            try {
                double[] notasIngresadas = new double[5];
                notasIngresadas[0] = Double.parseDouble(campoNota1.getText());
                notasIngresadas[1] = Double.parseDouble(campoNota2.getText());
                notasIngresadas[2] = Double.parseDouble(campoNota3.getText());
                notasIngresadas[3] = Double.parseDouble(campoNota4.getText());
                notasIngresadas[4] = Double.parseDouble(campoNota5.getText());

                calificaciones notas = new calificaciones(notasIngresadas);

                promedio.setText("Promedio = " + String.format("%.2f", notas.media));
                desviación.setText("Desviación estándar = " + String.format("%.2f", notas.So));
                mayor.setText("Valor mayor = " + String.format("%.2f", notas.max));
                menor.setText("Valor menor = " + String.format("%.2f", notas.min));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos en todos los campos.");
            }
        }
        if (evento.getSource() == limpiar) {
            campoNota1.setText("");
            campoNota2.setText("");
            campoNota3.setText("");
            campoNota4.setText("");
            campoNota5.setText("");
            promedio.setText("Promedio = ");
            desviación.setText("Desviación = ");
            mayor.setText("Nota mayor = ");
            menor.setText("Nota menor = ");
        }
    }
}

public class Ej8P2{
    public static void main(String args[]){
        VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal(); 
        miVentanaPrincipal.setVisible(true);
    }
}