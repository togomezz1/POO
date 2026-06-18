import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 1.2/2026
 * @author togomezz
 */
public class Vendedor extends JFrame {
    String nombre;
    String apellidos;
    int edad;

    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtEdad;
    private JLabel lblResultado;
    private JTextArea txtConsola;

    public Vendedor(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Vendedor() {
        setTitle("Registro de Vendedor");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel pnlHeader = new JPanel();
        pnlHeader.setBackground(new Color(240, 240, 240));
        JLabel lblTitulo = new JLabel("Formulario de Registro", JLabel.CENTER);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        pnlHeader.add(lblTitulo);

        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new GridLayout(4, 2, 10, 10));
        pnlForm.setBorder(new EmptyBorder(20, 30, 10, 30));

        txtNombre = new JTextField();
        txtApellidos = new JTextField();
        txtEdad = new JTextField();

        pnlForm.add(new JLabel("Nombre:"));
        pnlForm.add(txtNombre);
        pnlForm.add(new JLabel("Apellidos:"));
        pnlForm.add(txtApellidos);
        pnlForm.add(new JLabel("Edad:"));
        pnlForm.add(txtEdad);

        JButton btnRegistrar = new JButton("Registrar Vendedor");
        btnRegistrar.setBackground(new Color(0, 102, 204));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(new Font("SansSerif", Font.BOLD, 12));
        pnlForm.add(new JLabel("")); 
        pnlForm.add(btnRegistrar);

        JPanel pnlSouth = new JPanel(new BorderLayout());
        pnlSouth.setBorder(new EmptyBorder(10, 30, 20, 30));

        lblResultado = new JLabel("Ingrese los datos del vendedor.", JLabel.CENTER);
        lblResultado.setFont(new Font("SansSerif", Font.BOLD, 13));
        pnlSouth.add(lblResultado, BorderLayout.NORTH);

        txtConsola = new JTextArea(6, 20);
        txtConsola.setEditable(false);
        txtConsola.setBackground(new Color(235, 235, 235));
        JScrollPane scroll = new JScrollPane(txtConsola);
        pnlSouth.add(scroll, BorderLayout.SOUTH);

        add(pnlHeader, BorderLayout.NORTH);
        add(pnlForm, BorderLayout.CENTER);
        add(pnlSouth, BorderLayout.SOUTH);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblResultado.setText("");
                
                try {
                    String nom = txtNombre.getText().trim();
                    String ape = txtApellidos.getText().trim();
                    
                    if(nom.isEmpty() || ape.isEmpty()) {
                        throw new IllegalArgumentException("Todos los campos son obligatorios.");
                    }

                    Vendedor v = new Vendedor(nom, ape);
                    
                    int edadIngresada = Integer.parseInt(txtEdad.getText().trim());
                    
                    v.verificarEdad(edadIngresada);
                    
                    nombre = nom;
                    apellidos = ape;
                    edad = edadIngresada;

                    lblResultado.setForeground(new Color(0, 128, 0));
                    lblResultado.setText("¡Vendedor instanciado con éxito!");
                    
                    txtConsola.append("[ÉXITO] Objeto creado -> Nombre: " + nombre + " " + apellidos + ", Edad: " + edad + "\n");

                } catch (NumberFormatException nfe) {
                    lblResultado.setForeground(Color.RED);
                    lblResultado.setText("ERROR: La edad debe ser un número entero.");
                    txtConsola.append("[ERROR] Formato de edad inválido.\n");
                } catch (IllegalArgumentException ex) {
                    lblResultado.setForeground(Color.RED);
                    lblResultado.setText("ERROR: " + ex.getMessage());
                    txtConsola.append("[EXCEPCIÓN ATRAPADA] " + ex.getMessage() + "\n");
                }
            }
        });
    }

    void verificarEdad(int edad) {
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("La edad no puede ser negativa ni mayor a 120.");
        }
        if (edad < 18) {
            throw new IllegalArgumentException("El vendedor debe ser mayor de 18 años.");
        }
        this.edad = edad;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Vendedor().setVisible(true);
            }
        });
    }
}
