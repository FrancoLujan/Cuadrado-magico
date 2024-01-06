/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matrizes;

/**
 *
 * @author franc
 */
public class Matrizes {

    public static void main(String[] args) {
        int tamanio = 3;
        int mat[][] = new int[tamanio][tamanio]; // cuadratica...
        int SumaDiagonal = 0;
        int SumaDiagonal2 = 0;
        int SumaColumna[] = new int[tamanio];
        int SumaFila[] = new int[tamanio];
        int ResultadoMagico = 0;
        int posF = 0;
        int posC = 0;
        int posF2 = 0;
        int posC2 = 0;
        boolean bandera = false;
        boolean bandera2 = false;
        boolean encontrado = false;
        boolean encontradoFinal = false;

        // carga de matriz
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = (int) (Math.random() * 15);
            }

        }
        // muestra de matriz
        // CUADRADO MAGICO
        for (int f = 0; f < mat.length; f++) {
            System.out.println("\n \n");

            for (int c = 0; c < mat[f].length; c++) {
                ResultadoMagico += mat[f][c];

                System.out.print("\t" + mat[f][c] + "\t");
                // SUMA FILAS
                SumaFila[f] += mat[f][c];
                // SUMA Columna

                SumaColumna[c] += mat[f][c];

                //SUMA DIAGONALES principal
                if (!bandera) {
                    SumaDiagonal += mat[f][c];
                    bandera = true;
                    posF = f;
                    posC = c;

                } else {
                    if (f > posF && c > posC) {
                        SumaDiagonal += mat[f][c];
                        posF = f;
                        posC = c;
                    }

                }

                // SUMA DE DIAGONAL SECUNDARIA
                for (int c2 = mat.length - 1; c2 >= 0; c2--) {

                    if (!bandera2) {
                        SumaDiagonal2 += mat[f][c2];
                        bandera2 = true;
                        posF2 = f;
                        posC2 = c2;
                    } else {
                        if (f > posF2 && c2 < posC2) {
                            SumaDiagonal2 += mat[f][c2];
                            posF2 = f;
                            posC2 = c2;
                        }

                    }

                }

            }

        }
        System.out.print("\n\n\n\n");

        System.out.println("suma diagonal principal:" + SumaDiagonal);
        System.out.println("suma de diagonal secundaria:" + SumaDiagonal2);
        for (int i = 0; i < SumaColumna.length; i++) {
            System.out.println("\nfila" + i + " suma:" + SumaFila[i] + "\n");
            System.out.println("\ncolumna" + i + "suma:" + SumaColumna[i] + "\n");

        }

        int esperado = ResultadoMagico / tamanio;
        System.out.println("Resultado total:" + ResultadoMagico);
        System.out.println("Resultado de filas, columnas, diagonales deseado:"
                + esperado);
                
        // validacion
        int ant = -1;
        int ant2 = -1;
        for (int i = 0; i < tamanio; i++) {

            encontrado = ant == SumaColumna[i] && esperado == SumaColumna[i]
                    && ant2 == SumaFila[i] && esperado == SumaFila[i];
            ant = SumaColumna[i];
            ant2 = SumaFila[i];
        }

        if (encontrado && esperado == SumaDiagonal && SumaDiagonal2 == esperado) {
            encontradoFinal = true;

        }

        if (encontradoFinal) {
            System.out.println("!!!! CUADRADO MAGICO !!!!");
        }

    }
}
