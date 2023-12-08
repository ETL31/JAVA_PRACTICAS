import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraConInterfaz extends JFrame {
    private JTextField display;
    private StringBuilder input;

    public CalculadoraConInterfaz() {
        super("Calculadora");

        input = new StringBuilder();

        // Configuración del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        // Configuración del layout
        setLayout(new BorderLayout());

        // Display para mostrar números y resultados
        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 4, 5, 5));

        // Números del 1 al 9 y 0
        for (int i = 1; i <= 9; i++) {
        final int numero = i;
        JButton btnNumero = new JButton(String.valueOf(i));
        btnNumero.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            input.append(numero);
            updateDisplay();
        }
    });
        btnNumero.setPreferredSize(new Dimension(10, 10)); // Ajusta el tamaño del botón según tus necesidades
        panelBotones.add(btnNumero);
}

      // Botón 0
JButton btnCero = new JButton("0");
btnCero.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        input.append("0");
        updateDisplay();
    }
});
btnCero.setPreferredSize(new Dimension(10, 10));
panelBotones.add(btnCero);

// Operadores +, -, *, /
String[] operadores = {"+", "-", "*", "/"};
for (String operador : operadores) {
    JButton btnOperador = new JButton(operador);
    btnOperador.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            input.append(" " + operador + " ");
            updateDisplay();
        }
    });
    btnOperador.setPreferredSize(new Dimension(10, 10));
    panelBotones.add(btnOperador);
}

// Botones de raíz cuadrada y potencia
JButton btnRaiz = new JButton("V");
btnRaiz.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        input.append(" V ");
        updateDisplay();
    }
});
btnRaiz.setPreferredSize(new Dimension(10, 10));
panelBotones.add(btnRaiz);

JButton btnPotencia = new JButton("^");
btnPotencia.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        input.append(" ^ ");
        updateDisplay();
    }
});
btnPotencia.setPreferredSize(new Dimension(10, 10));
panelBotones.add(btnPotencia);

// Botón de igual
JButton btnIgual = new JButton("=");
btnIgual.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        calcularResultado();
    }
});
btnIgual.setPreferredSize(new Dimension(10, 10));
panelBotones.add(btnIgual);

// Botón de limpiar
JButton btnLimpiar = new JButton("C");
btnLimpiar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        input.setLength(0);
        updateDisplay();
    }
});
btnLimpiar.setPreferredSize(new Dimension(10, 10));
panelBotones.add(btnLimpiar);

        add(panelBotones, BorderLayout.CENTER);
    }

    private void updateDisplay() {
        display.setText(input.toString());
    }

    private void calcularResultado() {
        String expresion = input.toString();

        // Separar la expresión en números y operadores
        String[] elementos = expresion.split(" ");
        double resultado = Double.parseDouble(elementos[0]);

        for (int i = 1; i < elementos.length; i += 2) {
            String operador = elementos[i];
            double numero = Double.parseDouble(elementos[i + 1]);

            switch (operador) {
                case "+":
                    resultado += numero;
                    break;
                case "-":
                    resultado -= numero;
                    break;
                case "*":
                    resultado *= numero;
                    break;
                case "/":
                    resultado /= numero;
                    break;
                case "^":
                    resultado = Math.pow(resultado, numero);
                    break;
                case "V":
                    resultado = Math.pow(resultado, 1.0 / numero);
                    break;
                default:
                    System.out.println("Operador no reconocido: " + operador);
                    return; // Salir si hay un operador no reconocido
            }
        }

        // Mostrar el resultado en el display y actualizar la variable "input"
        input.setLength(0);
        input.append(String.valueOf(resultado));
        updateDisplay();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraConInterfaz().setVisible(true);
            }
        });
    }
}
