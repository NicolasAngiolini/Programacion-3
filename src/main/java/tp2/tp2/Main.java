package src.main.java.tp2.tp2;

public class Main {

    public static void main(String[] args) {

        int[] arreglo = {1, 2, 3, 4, 5};



        System.out.println(estaOrdenado(arreglo));
        System.out.println(buscarElemento(arreglo, 2));
        System.out.println(convertirBinario(26));
        imprimirFibonacci(7);
    }

    public static boolean estaOrdenado(int[] arr) {
        return estaOrdenadoRecursivo(arr, 0);
    }

    public static int buscarElemento(int[] arr, int n) {
        return buscarElementoRecursivo(arr, n, 0);
    }

    public static void imprimirFibonacci(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(fibonacci(i));
        }
    }

    //O(n)donde n es el arr.length- Es mas costoso en recursos(memoria)

    private static boolean estaOrdenadoRecursivo(int[] arr, int i) {
        if (i >= arr.length - 1)
            return true;
        else if (arr[i] > arr[i + 1])
            return false;
        return estaOrdenadoRecursivo(arr, i + 1);
    }
//O(n)
    private static int buscarElementoRecursivo(int[] arr, int n, int i) {
        if (i >= arr.length - 1)
            return -1;
        else if (arr[i] == n)
            return i;
        return buscarElementoRecursivo(arr, n, i + 1);

    }
//
    public static String convertirBinario(int n) {
        if (n == 0)
            return "0";
        else if (n == 1)
            return "1";
        return convertirBinario(n / 2) + (n % 2);

    }

    private static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
