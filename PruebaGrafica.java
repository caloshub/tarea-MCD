import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PruebaGrafica {
    static PruebaGrafica prueba = new PruebaGrafica();
    static JFrame ventana = new JFrame();
    static JPanel panelPrincipal = new JPanel();
    static JPanel numerosIngreso = new JPanel();
    static JTextField numeroA = new JTextField();
    static JTextField numeroB = new JTextField();
    static JPanel botonesOperacion = new JPanel();
    static JButton recursivo = new JButton("Metodo Recursivo");
    static JButton metWhile = new JButton("Metodo While");
    static JPanel panelResultado = new JPanel();
    static JTextArea resultado = new JTextArea();
    


    public void drawElement(){
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().add(panelPrincipal);
        ventana.pack();
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setVisible(true);

        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
            panelPrincipal.add(numerosIngreso);
                numerosIngreso.setLayout(new BoxLayout(numerosIngreso, BoxLayout.X_AXIS));
                numerosIngreso.add(numeroA);
                numerosIngreso.add(numeroB);
                numerosIngreso.setVisible(true);
            panelPrincipal.add(botonesOperacion);
                botonesOperacion.setLayout(new BoxLayout(botonesOperacion, BoxLayout.X_AXIS));
                botonesOperacion.add(metWhile);
                botonesOperacion.add(recursivo);
            panelPrincipal.add(panelResultado);
                panelResultado.add(resultado);    

            Font fuente  = new Font("consolas", Font.PLAIN, 60);
            Dimension dimensionIngreso = new Dimension(600, 6000);
            Dimension dimensionBotones= new Dimension(600,6000);
            Dimension dimensionResultado = new Dimension(240, 120);
            Dimension dimensionPanel = new Dimension(1200, 6000);
            Border border = BorderFactory.createLineBorder(Color.BLACK);

            numerosIngreso.setMaximumSize(dimensionPanel);
            numerosIngreso.setMinimumSize(dimensionPanel);
            numerosIngreso.setBorder(border);
            
            botonesOperacion.setMaximumSize(dimensionPanel);
            botonesOperacion.setMinimumSize(dimensionPanel);
            botonesOperacion.setBorder(border);

            panelResultado.setMaximumSize(dimensionPanel);
            panelResultado.setMinimumSize(dimensionPanel);
            panelResultado.setBorder(border);

            numeroA.setMaximumSize(dimensionIngreso);
            numeroA.setMinimumSize(dimensionIngreso);
            numeroA.setFont(fuente);

            numeroB.setMaximumSize(dimensionIngreso);
            numeroB.setMinimumSize(dimensionIngreso);
            numeroB.setFont(fuente);

            recursivo.setMaximumSize(dimensionBotones);
            recursivo.setMinimumSize(dimensionBotones);
            recursivo.setFont(fuente);
            metWhile.setMaximumSize(dimensionBotones);
            metWhile.setMinimumSize(dimensionBotones);
            metWhile.setFont(fuente);

            resultado.setMaximumSize(dimensionResultado);
            resultado.setMinimumSize(dimensionResultado);
            resultado.setPreferredSize(dimensionResultado);
            resultado.setFont(fuente); 
        
    }

    public void operacion(){
        prueba.drawElement();

        MCD mcd = new MCD();
        
        recursivo.setEnabled(true);
        recursivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent rec){
                try{
                final String aString = numeroA.getText();
                int a = Integer.parseInt(aString);
                final String bString = numeroB.getText();
                int b = Integer.parseInt(bString);
                int respuesta = mcd.calculoRecursivo(a, b);
                String respuestaStr = Integer.toString(respuesta);
                resultado.setText(respuestaStr); 
                }
                catch(Exception error){
                    resultado.setText("e");
                }
            }
        });

        metWhile.setEnabled(true);
        metWhile.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent reg){
                try{
                final String aString = numeroA.getText();
                int a = Integer.parseInt(aString);
                final String bString = numeroB.getText();
                int b = Integer.parseInt(bString);
                int respuesta = mcd.calculoRegular(a, b);
                String respuestaStr = Integer.toString(respuesta);
                resultado.setText(respuestaStr); 
                }
                catch(Exception error){
                    resultado.setText("e");
                }
            }
        });
    }


    public static void main(String[] args) {
        prueba.operacion();
    }
}
