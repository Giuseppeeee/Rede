package rede;

//@author ggonzfern
public class Rede {

    public static void main(String[] args) {
        // Declaración de variables y constantes

        // Entrada de datos
        // Proceso
        // Salida
    }

    public static boolean validarIP(String ip) {
        boolean valida = true;
        int puntos;
        int lugarpuntos[];
        String ips[];

        if (ip.length() < 8 || ip.length() > 16) {
            valida = false;
        }

        puntos = contarPuntos(ip);
        if (puntos != 4) {
            valida = false;
        }

        lugarpuntos = lugarPuntos(puntos, ip);
        ips = separarIp(lugarpuntos, ip, puntos);

        for (int i = 0; i < ips.length; i++) {
            for (int j = 0; i < ips[i].length(); j++) {
                switch (j) {
                    case 0:

                        if (((int) ips[i].charAt(j)) == 48 && ips[i].length() > 1) {
                            valida = false;
                        }
                        if (((int) ips[i].charAt(j)) < 48 || ((int) ips[i].charAt(j)) > 50) {
                            valida = false;
                        }
                        break;
                    case 1:
                        if (ips[i].charAt(0) == '2') {
                            if (((int) ips[i].charAt(j)) < 48 || ((int) ips[i].charAt(j)) > 53) {
                                valida = false;
                            }
                        }else{
                            if (((int) ips[i].charAt(j)) < 48 || ((int) ips[i].charAt(j)) > 57) {
                                valida = false;
                            }
                        }
                        break;
                    case 2:
                        if (ips[i].charAt(1) == '5') {
                            if (((int) ips[i].charAt(j)) < 48 || ((int) ips[i].charAt(j)) > 53) {
                                valida = false;
                            }
                        }else{
                            if (((int) ips[i].charAt(j)) < 48 || ((int) ips[i].charAt(j)) > 57) {
                                valida = false;
                            }
                        }
                        break;
                }
            }
        }

        return valida;

    }

    public static int buscarIP(String ip, String[] ips) {
        int posicion = -1;
        for (int i = 0; i < ips.length; i++) {
            if (ip == ips[i]) {
                posicion = i;
            }
        }
        return posicion;
    }

    static int contarPuntos(String t) {
        int puntos = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '.') {
                puntos++;
            }
        }
        return puntos;
    }

    static int[] lugarPuntos(int puntos, String t) {
        int posiciones_puntos[] = new int[puntos];
        int c = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '.') {
                posiciones_puntos[c] = i;
                c++;
            }
        }
        return posiciones_puntos;
    }

    static String[] separarIp(int[] posi_puntos, String ip, int puntos) {
        String ips[] = new String[puntos];
        for (int i = 0; i < ips.length; i++) {
            if (i == 0) {//Condicion para evitar que de error
                ips[i] = ip.substring(0, posi_puntos[i]);
            } else {
                ips[i] = ip.substring(posi_puntos[i - 1] + 1, posi_puntos[i]);
            }
        }
        return ips;
    }
}
