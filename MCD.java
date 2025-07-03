import java.util.Scanner;

public class MCD {
    Scanner scanner = new Scanner(System.in);
    static MCD mcd = new MCD();
    public void mcdRegular(){
        System.out.print("Ingrese el primer número: ");
        int a = scanner.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int b = scanner.nextInt();

        int num1 = a;
        int num2 = b;

        int resultado = calculoRegular(a, b);

        
        System.out.println("El máximo común divisor de " + num1 + " y " + num2 + " es: " + resultado);
        scanner.close();
    }


    public int calculoRegular(int a, int b){
        int resto;
        while (b != 0) {
            resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }

    /*si bien en el algoritmo original dado por el docente, tanto el ingreso de
     * los numeros como el calculo de su MCD se realizan dentro una misma funcion;
     * en este caso decidi hacerlo en funciones separadas para poder realizar
     * con mayor facilidad la prueba de funcionamiento
     */

    public void mcdRecursivo(){
        System.out.print("Ingrese el primer número: ");
        int a = scanner.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int b = scanner.nextInt();

        int num1 = a;
        int num2 = b;

        int result = mcd.calculoRecursivo(a, b);

        System.out.println("El máximo común divisor de " + num1 + " y " + num2 + " es: " + result);
        scanner.close();

        
    }

 
    public int calculoRecursivo(int a, int b){
       if(b==0){
        return a;
       }
       else{
        return calculoRecursivo(b, a%b);
       }
    }

    public static void main(String[] args) {
        mcd.mcdRecursivo();
    }
    
}

/*notas del programa:
 * El  objeto mcd de la clase MCD fue creado de manera estatica para no tener que crear un objeto para cada metodo
 * la funcion no recursiva usa un bucle while y funcionaria de la siguente manera para los valores de 8 y 12 por ejemplo
 * 8 12 (b=12)
 * 12 8(b=8)
 * 8 4(b=4)
 * 4 0(b=0) debido que el valor de b es igual a cero el bucle se detiene y se utiliza
 * de esto deducimos que la condicional del bucle esta basada en la variable b
 * 
 * En cambio en la funcion recursiva se reemplaza el bucle while por una funcion
 * la cual se llamara a si misma. y que tomara como parametros los valores de a y b
 * en este caso 8 y 12 
 * func(8, 12) return (12, 8)
 * func(12, 8) return (8, 4)
 * func(8, 4) reurn (4 0); aqui el valor b se torna sero
 */
