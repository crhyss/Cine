/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;

/**
 *
 * @author Branco
 */
public class ControladorVista {

    public boolean validarLetra(char tecla) {
        char letraEspannol[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ',
             'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ',
             'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'á', 'é', 'í', 'ó', 'ú', 'Á', 'É', 'Í', 'Ó', 'Ú', 'ü', 'Ü'};
        int tamanno = letraEspannol.length;
        boolean valido = false;
        for (int i = 0; i <= tamanno - 1; i++) {
            if (tecla == letraEspannol[i]) {
                valido = true;
                break;
            }
        }
        return valido;
    }

    public boolean validarNumero(char tecla) {
        char numero[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        int tamanno = numero.length;
        boolean valido = false;
        for (int i = 0; i <= tamanno - 1; i++) {
            if (tecla == numero[i]) {
                valido = true;
                break;
            }
        }
        return valido;
    }

    public boolean validarDv(char tecla) {
        char caracter[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'k', 'K'};
        int tamanno = caracter.length;
        boolean valido = false;
        for (int i = 0; i <= tamanno - 1; i++) {
            if (tecla == caracter[i]) {
                valido = true;
                break;
            }
        }
        return valido;
    }

    public boolean validarTexto(char tecla) {
        char texto[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'á', 'é', 'í', 'ó', 'ú', 'Á', 'É', 'Í', 'Ó', 'Ú', 'ü', 'Ü', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        int tamanno = texto.length;
        boolean valido = false;
        for (int i = 0; i <= tamanno - 1; i++) {
            if (tecla == texto[i]) {
                valido = true;
                break;
            }
        }
        return valido;
    }

    public boolean validarMasTexto(char tecla) {
        char texto[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'á', 'é', 'í', 'ó', 'ú', 'Á', 'É', 'Í', 'Ó', 'Ú', 'ü', 'Ü', ',', '.', ';', ':'};
        int tamanno = texto.length;
        boolean valido = false;
        for (int i = 0; i <= tamanno - 1; i++) {
            if (tecla == texto[i]) {
                valido = true;
                break;
            }
        }
        return valido;
    }

    public boolean validarUsuario(char tecla) {
        char texto[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };
        int tamanno = texto.length;
        boolean valido = false;
        for (int i = 0; i <= tamanno - 1; i++) {
            if (tecla == texto[i]) {
                valido = true;
                break;
            }
        }
        return valido;
    }
    
    public boolean validarHora(char tecla) {
        char numero[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ':'};
        int tamanno = numero.length;
        boolean valido = false;
        for (int i = 0; i <= tamanno - 1; i++) {
            if (tecla == numero[i]) {
                valido = true;
                break;
            }
        }
        return valido;
    }
}
