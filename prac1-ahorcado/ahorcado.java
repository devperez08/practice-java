import java.util.Scanner;

public class ahorcado {
        public static void main(String[] args) {
        // Creamos un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Configuración inicial del juego
        String palabra = "gato";           // Palabra que el jugador debe adivinar
        int intentosmax = 8;               // Número máximo de intentos permitidos
        int intentos = 0;                  // Contador de intentos fallidos
        boolean palabraadivinada = false;  // Bandera para saber si se adivinó la palabra

        // Crear array para almacenar las letras adivinadas
        char[] letrasadivinadas = new char[palabra.length()];

        // Inicializar el array con guiones bajos
        for (int i = 0; i < letrasadivinadas.length; i++) {
            letrasadivinadas[i] = '_';
        }

        // Bucle principal del juego
        while (!palabraadivinada && intentos < intentosmax) {
            // String.valueOf(): Convierte el array de caracteres a una cadena para poder imprimirlo
            // Útil para convertir arrays o tipos de datos a su representación en cadena
            System.out.println("\nPalabra a adivinar: " + String.valueOf(letrasadivinadas));
            System.out.println("Intentos restantes: " + (intentosmax - intentos));
            System.out.print("Introduce una letra: ");
            
            // scanner.next(): Obtiene la próxima cadena de texto ingresada por el usuario
            // charAt(0): Extrae el primer carácter de esa cadena
            // Sin charAt(0), no se podría convertir la entrada a un carácter individual
            // Si no usas charAt(0), obtendrías un error de compilación porque next() devuelve String, no char
            char letra = Character.toLowerCase(scanner.next().charAt(0));
            boolean letracorrecta = false;
            

            // Verificar si la letra está en la palabra
            for (int i = 0; i < palabra.length(); i++) {
                // charAt(i): Obtiene el carácter en la posición i de la palabra
                if (palabra.charAt(i) == letra) {
                    letrasadivinadas[i] = letra;
                    letracorrecta = true;
                }
            }

            // Incrementar intentos solo si la letra no es correcta
            if (!letracorrecta) {
                intentos++;
                System.out.println("¡Letra incorrecta!");
            } else {
                System.out.println("¡Letra correcta!");
            }

            // equals(): Compara si dos cadenas son exactamente iguales 
            // A diferencia de ==, equals() compara el contenido real de las cadenas
            if (String.valueOf(letrasadivinadas).equals(palabra)) {
                palabraadivinada = true;
                System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabra);
                System.out.println("Lo lograste en " + intentos + " intentos fallidos.");
            }
        }

        // Mostrar mensaje si se agotan los intentos
        if (!palabraadivinada) {
            System.out.println("\n¡Has perdido! La palabra era: " + palabra);
            System.out.println("Alcanzaste el máximo de " + intentosmax + " intentos fallidos.");
        }

        // Cerrar el scanner al final del programa
        scanner.close();
    }
}