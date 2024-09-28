package src.main.java.tp4;

public class Main {

    public static void main(String[] args) {

        GrafoDirigido<String> grafito = new GrafoDirigido<String>();

        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(3);
        grafito.agregarVertice(4);
        grafito.agregarVertice(5);
        grafito.agregarVertice(6);
        grafito.agregarVertice(7);

        /*
            1-------2------->5
            \       ^
             \       \
              \       \
               v       \
                3------>4------>6----->7
         */

        grafito.agregarArco(1, 2, "1-2");
        grafito.agregarArco(1, 3, "1-3");
        grafito.agregarArco(3, 4, "3-4");
        grafito.agregarArco(4, 2, "4-2");
        grafito.agregarArco(4, 6, "4-6");
        grafito.agregarArco(2, 5, "2-5");
        grafito.agregarArco(6, 7, "6-7");



        String etiqueta = grafito.obtenerArco(3, 4).getEtiqueta();

         System.out.println(etiqueta);

        System.out.println(grafito.existeArco(8,2));
        System.out.println(grafito.cantidadArcos());

        System.out.println(grafito.obtenerAdyacentes(3));
    }
}
