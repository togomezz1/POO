import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * * @author togomezz
 */
public class InterfazExcepciones extends JFrame {

    private JTextField txtNumerador;
    private JTextField txtDenominador;
    private JLabel lblResultadoDivision;
    private JLabel lblResultadoObjeto;
    private JTextArea txtConsola;

    public InterfazExcepciones() {
        setTitle("Excepciones Java - Entrega 4");
        setSize(800, 550); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel pnlHeader = new JPanel();
        pnlHeader.setBackground(new Color(245, 245, 245)); 
        pnlHeader.setBorder(new EmptyBorder(15, 10, 15, 10));

        JLabel lblTitulo = new JLabel("Excepciones", JLabel.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 22)); 
        lblTitulo.setForeground(new Color(0, 102, 204)); 
        pnlHeader.add(lblTitulo);

        JPanel pnlCentral = new JPanel();
        pnlCentral.setLayout(new GridLayout(1, 2, 20, 0)); 
        pnlCentral.setBorder(new EmptyBorder(20, 20, 20, 20)); 

        JPanel pnlDivision = crearPanelEjercicio("Ejercicio 1: División por Cero");
        
        txtNumerador = new JTextField("10000");
        txtDenominador = new JTextField("0"); 
        JButton btnCalcular = new JButton("Calcular Cociente");
        
        btnCalcular.setBackground(new Color(0, 153, 51)); 
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnCalcular.setOpaque(true); 
        btnCalcular.setBorderPainted(false); 

        lblResultadoDivision = new JLabel(" ", JLabel.CENTER); 
        lblResultadoDivision.setFont(new Font("SansSerif", Font.BOLD, 16));

        pnlDivision.add(crearFilaInput("Numerador:", txtNumerador));
        pnlDivision.add(crearFilaInput("Denominador:", txtDenominador));
        pnlDivision.add(Box.createRigidArea(new Dimension(0, 15)));
        pnlDivision.add(btnCalcular);
        pnlDivision.add(Box.createRigidArea(new Dimension(0, 10))); 
        pnlDivision.add(new JLabel("Resultado de División:", JLabel.CENTER));
        pnlDivision.add(lblResultadoDivision);

        JPanel pnlNulo = crearPanelEjercicio("Ejercicio 2: Referencia Nula");
        
        JButton btnNulo = new JButton("Ejecutar toString() en Objeto Nulo");
        
        btnNulo.setBackground(new Color(230, 126, 34)); 
        btnNulo.setForeground(Color.WHITE);
        btnNulo.setFont(new Font("SansSerif", Font.BOLD, 14));
        btnNulo.setOpaque(true);
        btnNulo.setBorderPainted(false);

        lblResultadoObjeto = new JLabel(" ", JLabel.CENTER);
        lblResultadoObjeto.setFont(new Font("SansSerif", Font.BOLD, 16));

        pnlNulo.add(btnNulo);
        pnlNulo.add(Box.createRigidArea(new Dimension(0, 20))); 
        pnlNulo.add(new JLabel("Resultado del Objeto:", JLabel.CENTER));
        pnlNulo.add(lblResultadoObjeto);

        pnlCentral.add(pnlDivision);
        pnlCentral.add(pnlNulo);

        JPanel pnlLog = new JPanel();
        pnlLog.setLayout(new BorderLayout());
        pnlLog.setBorder(new EmptyBorder(0, 20, 20, 20));

        JLabel lblLog = new JLabel("Consola de Mensajes y Excepciones");
        lblLog.setFont(new Font("SansSerif", Font.BOLD, 14));
        pnlLog.add(lblLog, BorderLayout.NORTH);

        txtConsola = new JTextArea(8, 20);
        txtConsola.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtConsola.setBackground(new Color(224, 224, 224));
        txtConsola.setEditable(false); 
        JScrollPane scrollLog = new JScrollPane(txtConsola); 
        pnlLog.add(scrollLog, BorderLayout.CENTER);

        add(pnlHeader, BorderLayout.NORTH);
        add(pnlCentral, BorderLayout.CENTER);
        add(pnlLog, BorderLayout.SOUTH);

        logConsola("Iniciando aplicación...");
        logConsola("Interfaz gráfica cargada.");
        logConsola("Listo para ejecutar ejercicios...");

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblResultadoDivision.setText(""); 
                logConsola("\n[División] Intentando calcular...");

                try {
                    // Obtener valores de la interfaz
                    String numStr = txtNumerador.getText();
                    String denStr = txtDenominador.getText();
                    
                    int numerador = Integer.parseInt(numStr);
                    int denominador = Integer.parseInt(denStr);

                    double cociente = (double) numerador / denominador;
                    
                    if (Double.isInfinite(cociente)) {
                        throw new ArithmeticException("¡División por cero manual!");
                    }

                    logConsola("[División] 'Después de la división' (Exitoso).");
                    lblResultadoDivision.setForeground(new Color(0, 102, 0)); // Verde oscuro
                    lblResultadoDivision.setText(String.valueOf(cociente));

                } catch (NumberFormatException nfe) {
                    logConsola("[División] Error: Por favor ingresa números válidos.");
                    lblResultadoDivision.setForeground(Color.RED);
                    lblResultadoDivision.setText("NÚMERO INVÁLIDO");
                } catch (ArithmeticException ae) {

                    logConsola("[División] 'División por cero' (Excepción atrapada).");
                    lblResultadoDivision.setForeground(Color.RED);
                    lblResultadoDivision.setText("ERROR: Div/0");
                } finally {

                    logConsola("[División] 'Ingresando al primer finally'.");
                }
            }
        });

        // Lógica para el botón de Objeto Nulo (Usa Excepciones)
        btnNulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblResultadoObjeto.setText(""); // Limpiar previo
                logConsola("\n[Objeto Nulo] Intentando ejecutar toString()...");

                // --- TRY ORIGINAL ---
                try {
                    Object objeto = null; // Definido como nulo
                    objeto.toString(); // Esto lanza un NullPointerException

                    // Esta línea nunca se ejecutará
                    logConsola("[Objeto Nulo] 'Imprimiendo objeto' (Exitoso)."); 
                    lblResultadoObjeto.setForeground(new Color(0, 102, 0));
                    lblResultadoObjeto.setText("ÉXITO INESPERADO");

                } catch (NullPointerException npe) { 
                    // --- CATCH ESPECÍFICO QUE AGREGUÉ ANTES ---
                    logConsola("[Objeto Nulo] Ocurrió un error: ¡El objeto es nulo! (NullPointerException)");
                    lblResultadoObjeto.setForeground(Color.RED);
                    lblResultadoObjeto.setText("ERROR: Objeto Nulo");
                } catch (Exception ex) { 
                    // --- CATCH GENÉRICO ORIGINAL ---
                    logConsola("[Objeto Nulo] Ocurrió una excepción genérica.");
                    lblResultadoObjeto.setForeground(Color.RED);
                    lblResultadoObjeto.setText("ERROR GENÉRICO");
                } finally {
                    // --- FINALLY ORIGINAL ---
                    logConsola("[Objeto Nulo] 'Ingresando al segundo finally'.");
                }
            }
        });
    }

    /**
     * Helper para crear paneles con un diseño uniforme y borde con título.
     */
    private JPanel crearPanelEjercicio(String titulo) {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS)); // Apilado vertical
        pnl.setBackground(Color.WHITE); // Fondo blanco
        // Borde elegante con título y padding interior
        pnl.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                titulo, 0, 0, new Font("SansSerif", Font.BOLD, 15)));
        pnl.setBorder(BorderFactory.createCompoundBorder(
                pnl.getBorder(), new EmptyBorder(10, 15, 10, 15)));
        return pnl;
    }

    /**
     * Helper para crear una fila con etiqueta y campo de texto alineado.
     */
    private JPanel crearFilaInput(String textoEtiqueta, JTextField txt) {
        JPanel pnl = new JPanel();
        pnl.setOpaque(false); // Fondo transparente del panel de fila
        pnl.setLayout(new BorderLayout(5, 0)); // Espacio de 5px entre label y text
        pnl.add(new JLabel(textoEtiqueta, JLabel.RIGHT), BorderLayout.WEST);
        pnl.add(txt, BorderLayout.CENTER);
        return pnl;
    }

    /**
     * Método para escribir mensajes con hora en la consola de la interfaz.
     */
    private void logConsola(String mensaje) {
        txtConsola.append(mensaje + "\n");
        txtConsola.setCaretPosition(txtConsola.getDocument().getLength()); // Scroll automático hacia abajo
    }

    /**
     * Método Main: El punto de entrada de la aplicación.
     */
    public static void main(String[] args) {
        // Ejecutar la GUI en el hilo de despacho de eventos para que sea estable
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Intenta usar el estilo de ventana del sistema nativo (para que no se vea tan 'antiguo')
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    // Si falla, usa el estilo por defecto de Java (Metal)
                }
                new InterfazExcepciones().setVisible(true); // Crear y mostrar la ventana
            }
        });
    }
}
