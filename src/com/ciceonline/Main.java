package com.ciceonline;
/**la aplicacion es un cronometro que se ejecuta en el hilo llamado cronometro,
que implementa el metodo abstracto run de la interfaz funcional Runnable, pasandole como
 parametro de entrada una expresion lambda al crear el objeto de la clase Thread **/

public class Main {

    public static void main(String[] args) {

        Thread cronometro = new Thread(() -> {
            int segundos = 50, minutos = 59, horas = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(horas + ":" + minutos + ":" + segundos);
                    ++segundos;
                    if (segundos > 59) {
                        segundos = 0;
                        minutos++;
                        if (minutos > 59) {
                            minutos = 0;
                            horas++;
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        cronometro.start();
    }
}
