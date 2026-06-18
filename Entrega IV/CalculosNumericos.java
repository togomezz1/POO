import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

/**
 * @version 1.2/2026
 * @author togomezz
 */
public class CalculosNumericos extends JFrame {

    private JTextField txtValor;
    private JLabel lblResultadoLog;
    private JLabel lblResultadoRaiz;
    private JTextArea txtConsola;

    public CalculosNumericos() {
        setTitle("Cálculos Numéricos");
        setSize(550, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout());

        JPanel pnlHeader = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlHeader.setBackground(new Color(240, 240, 240));
        JLabel lblTitulo = new JLabel("Múltiples Catchs: Logaritmo y Raíz");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        pnlHeader.add(lblTitulo);


        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new BoxLayout(pnlForm, BoxLayout.Y_AXIS));
        pnlForm.setBorder(new EmptyBorder(20, 50, 10, 50));
        
        JLabel lblIndicacion = new JLabel("Ingrese un valor numérico (double):");
        lblIndicacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblIndicacion.setFont(new Font("SansSerif", Font.PLAIN, 13));
        
        txtValor = new JTextField();
        txtValor.setMaximumSize(new Dimension(200, 30)); 
        txtValor.setHorizontalAlignment(JTextField.CENTER); 
        txtValor.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnCalcular = new JButton("Ejecutar Cálculos");
        btnCalcular.setBackground(new Color(204, 0, 0)); 
        btnCalcular.setForeground(Color.WHITE);  
        btnCalcular.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnCalcular.setMaximumSize(new Dimension(160, 35));
        btnCalcular.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnCalcular.setOpaque(true);
        btnCalcular.setContentAreaFilled(true);
        btnCalcular.setBorderPainted(false);

        pnlForm.add(lblIndicacion);
        pnlForm.add(Box.createRigidArea(new Dimension(0, 10)));
        pnlForm.add(txtValor);
        pnlForm.add(Box.createRigidArea(new Dimension(0, 15)));
        pnlForm.add(btnCalcular);

        JPanel pnlResultados = new JPanel();
        pnlResultados.setLayout(new BoxLayout(pnlResultados, BoxLayout.Y_AXIS));
        pnlResultados.setBorder(new EmptyBorder(10, 30, 10, 30));
        
        lblResultadoLog = new JLabel("Logaritmo Neperiano: -", JLabel.CENTER);
        lblResultadoLog.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblResultadoLog.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        lblResultadoRaiz = new JLabel("Raíz Cuadrada: -", JLabel.CENTER);
        lblResultadoRaiz.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblResultadoRaiz.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        pnlResultados.add(lblResultadoLog);
        pnlResultados.add(Box.createRigidArea(new Dimension(0, 8)));
        pnlResultados.add(lblResultadoRaiz);

        JPanel pnlSouth = new JPanel(new BorderLayout());
        pnlSouth.setBorder(new EmptyBorder(10, 40, 20, 40));
        
        JLabel lblConsolaInfo = new JLabel("Consola de Excepciones Interceptadas:", JLabel.CENTER);
        lblConsolaInfo.setFont(new Font("SansSerif", Font.ITALIC, 12));
        pnlSouth.add(lblConsolaInfo, BorderLayout.NORTH);

        txtConsola = new JTextArea(6, 20);
        txtConsola.setEditable(false);
        txtConsola.setBackground(new Color(235, 235, 235));
        txtConsola.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(txtConsola);
        pnlSouth.add(scroll, BorderLayout.SOUTH);

        add(pnlHeader, BorderLayout.NORTH);
        add(pnlForm, BorderLayout.CENTER);
        
        JPanel pnlCentralContenedor = new JPanel(new BorderLayout());
        pnlCentralContenedor.add(pnlResultados, BorderLayout.NORTH);
        pnlCentralContenedor.add(pnlSouth, BorderLayout.CENTER);
        add(pnlCentralContenedor, BorderLayout.SOUTH);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblResultadoLog.setForeground(Color.BLACK);
                lblResultadoRaiz.setForeground(Color.BLACK);
                lblResultadoLog.setText("Logaritmo Neperiano: -");
                lblResultadoRaiz.setText("Raíz Cuadrada: -");
                
                try {
                    String textoInput = txtValor.getText().trim();
                    
                    double valor;
                    try {
                        valor = Double.parseDouble(textoInput);
                    } catch (NumberFormatException nfe) {
                        throw new InputMismatchException();
                    }

                    double resLog = calcularLogaritmoNeperiano(valor);
                    lblResultadoLog.setText("Logaritmo Neperiano = " + resLog);
                    
                    double resRaiz = calcularRaízCuadrada(valor);
                    lblResultadoRaiz.setText("Raíz Cuadrada = " + resRaiz);

                } catch (ArithmeticException ae) {
                    lblResultadoLog.setForeground(Color.RED);
                    lblResultadoRaiz.setForeground(Color.RED);
                    lblResultadoLog.setText("Logaritmo: ERROR");
                    lblResultadoRaiz.setText("Raíz: ERROR");
                    txtConsola.append("[CATCH 1] ArithmeticException: " + ae.getMessage() + "\n");
                    
                } catch (InputMismatchException ime) {
                    lblResultadoLog.setForeground(Color.RED);
                    lblResultadoRaiz.setForeground(Color.RED);
                    lblResultadoLog.setText("Logaritmo: VALOR NO NUMÉRICO");
                    lblResultadoRaiz.setText("Raíz: VALOR NO NUMÉRICO");
                    txtConsola.append("[CATCH 2] InputMismatchException: Entrada no válida.\n");
                }
            }
        });
    }

    static double calcularLogaritmoNeperiano(double valor) {
        if (valor < 0) {
            throw new ArithmeticException("El valor debe ser positivo.");
        }
        return Math.log(valor);
    }

    static double calcularRaízCuadrada(double valor) {
        if (valor < 0) {
            throw new ArithmeticException("El valor debe ser positivo.");
        }
        return Math.sqrt(valor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculosNumericos().setVisible(true);
            }
        });
    }
}