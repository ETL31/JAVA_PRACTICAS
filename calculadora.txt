import java.util.Scanner;

public class Calculadora {
   static Scanner teclado = new Scanner(System.in);
   
   public static void main(String args[]) {
        System.out.println("********* CALCULADORA EXD ********* ");
        String nombre = "";
        System.out.println("Menciona tu nombre");
        nombre = teclado.nextLine();
        
        while (true) {
            for (int i = 0; i < 2; i++) {
                System.out.println(); 
            }
            int operacion = 0;

            System.out.println("Por favor, " + nombre + " elige una de las opciones:");
            System.out.println("1: Suma");
            System.out.println("2: Resta");
            System.out.println("3: Multiplicacion");
            System.out.println("4: Division");
            System.out.println("5: Potencia");
            System.out.println("6: Radicacion");
            System.out.println("0: Salir");

            System.out.print("Escoge la operacion a realizar (0 para salir): ");
            operacion = teclado.nextInt();

            if (operacion == 0) {
                System.out.println("Hasta luego, " + nombre + "!");
                break; // Sale del bucle infinito si elige salir
            }

            Operacion(operacion);
        }
    }

    static void Operacion(int operacion) {
        switch (operacion) {
            case 1:
                Suma();
                break;
            case 2:
                Resta();
                break;
            case 3:
                Multiplicacion();
                break;
            case 4:
                Division();
                break;
            case 5:
                RPotencia();
                break;
            case 6:
                RRadicacion();
                break;
            default:
                System.out.println("No p loco del 1 al 6 tiene que ser, y pa salir el 0.");
        }
    }

    static void Suma() {
        System.out.println("Dame el primer valor: ");
        int num_uno = teclado.nextInt();

        System.out.println("Dame el segundo valor: ");
        int num_dos = teclado.nextInt();
        int resultado = num_uno + num_dos;
        System.out.println("El resultado de la suma es " + resultado);
    }

    static void Resta() {
        System.out.println("Dame el primer valor: ");
        int num_uno = teclado.nextInt();

        System.out.println("Dame el segundo valor: ");
        int num_dos = teclado.nextInt();
        int resultado = num_uno - num_dos;
        System.out.println("El resultado de la resta es " + resultado);
    }

    static void Multiplicacion() {
        System.out.println("Dame el primer valor: ");
        int num_uno = teclado.nextInt();

        System.out.println("Dame el segundo valor: ");
        int num_dos = teclado.nextInt();
        int resultado = num_uno * num_dos;
        System.out.println("El resultado de la multiplicacion es " + resultado);
    }

    static void Division() {
        System.out.println("Dame el primer valor: ");
        int num_uno = teclado.nextInt();

        System.out.println("Dame el segundo valor: ");
        int num_dos = teclado.nextInt();
        int resultado = num_uno / num_dos;
        System.out.println("El resultado de la division es " + resultado);
    }

    static void RPotencia() {
        System.out.print("Ingrese la base: ");
        double base = teclado.nextDouble();

        System.out.print("Ingrese el exponente: ");
        int exponente = teclado.nextInt();

        double resultado = Potencia(base, exponente);

        System.out.println("El resultado de " + base + " elevado a la " + exponente + " es: " + resultado);
    }

    static double Potencia(double base, int exponente) {
        double resultado = 1;

        for (int i = 0; i < Math.abs(exponente); i++) {
            resultado *= base;
        }

        // Manejo de exponente negativo
        if (exponente < 0) {
            resultado = 1 / resultado;
        }

        return resultado;
    }

    static void RRadicacion() {
        System.out.print("Ingrese el indice de la raiz: ");
        int indice = teclado.nextInt();
        Radicacion(indice);
    }

    static void Radicacion(int indice) {
        System.out.print("Ingrese el radicando: ");
        double radicando = teclado.nextDouble();

        if (indice > 0) {
            double resultado = Math.pow(radicando, 1.0 / indice);
            System.out.println("La raiz " + indice + "-esima de " + radicando + " es: " + resultado);
        } else {
            System.out.println("El indice de la raiz debe ser un número positivo.");
        }
    }
   
}
