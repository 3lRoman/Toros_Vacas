public class Generala {
    //Genero 6 numeros random del 1 al 6
    public static void main(String[] args) {
        int dado1 = 1 + (int) (Math.random() * 6);
        int dado2 = 1 + (int) (Math.random() * 6);
        int dado3 = 1 + (int) (Math.random() * 6);
        int dado4 = 1 + (int) (Math.random() * 6);
        int dado5 = 1 + (int) (Math.random() * 6);

        //Guardo los numeros creados en un array
        int[] dados ={dado1, dado2, dado3, dado4, dado5};

        System.out.println("Dados:");

        //Recorro cada numero creado con un bucle
        for (int i = 0; i < dados.length; i++) {

            //Mostramos los numeros del array desde el 1
            System.out.println("Dado " + (i + 1) + ": " + dados[i]);
        }

        //Creacion de array de repeticiones  for-eash-
        int[] repeticiones = new int[7];
        for (int d : dados) {
            repeticiones[d]++;
        }

        //Creacion de variables boolean para luego usarlos con condiciones
        boolean hay5 = false, hay4 = false, hay3 = false, hay2 = false;
        int pares = 0;
        //Bucle para validar las repeticiones
        for (int i = 1; i <= 6; i++) {
            if (repeticiones[i] == 5)
                hay5 = true;
            if (repeticiones[i] == 4)
                hay4 = true;
            if (repeticiones[i] == 3)
                hay3 = true;
            if (repeticiones[i] == 2)
                hay2 = true;

        }

        java.util.Arrays.sort(dados); //Ordena el array de menor a mayor
        String secuencia = java.util.Arrays.toString(dados).replaceAll("[\\[\\], ]", ""); //
        boolean escalera = secuencia.equals("12345") || secuencia.equals("23456") || secuencia.equals("34561");

        // Mostrar resultado
        if (hay5) {
            System.out.println("GENERALA");
        } else if (hay4) {
            System.out.println("POKER");
        } else if (hay3 && hay2) {
            System.out.println("FULL");
        } else if (escalera) {
            System.out.println("ESCALERA");
        } else {
            System.out.println("NADA");
        }
    }






}






