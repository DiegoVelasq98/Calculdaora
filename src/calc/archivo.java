package calc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class archivo extends frm_calcu {
    private JTextField txt_pantalla;
    private JButton calcularButton;
   

    public archivo() {
        setTitle("Calculadora con Guardado");
        setDefaultCloseOperation(frm_calcu.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        txt_pantalla = new JTextField(20);
        add(txt_pantalla);

        calcularButton = new JButton("C");
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             
            }
        });
        add(calcularButton);

        calcularButton = new JButton("C");
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarContenido();
            }
        });
        add(calcularButton);

        pack();
        setVisible(true);
    }

    private void guardarContenido() {
        String contenido = txt_pantalla.getText();
        try {
            FileWriter writer = new FileWriter("BicatoraCalculadora.txt");
            writer.write(contenido);
            writer.close();
            System.out.println("Contenido guardado en 'BicatoraCalculadora.txt'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new archivo();
            }
        });
    }
}
