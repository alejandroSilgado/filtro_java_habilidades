package com.filtro_java.persona.Application;

import java.util.Scanner;

public class appPersona {
    public static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            limpiarPantalla();
            System.out.println(" ");
            System.out.println("╔═══════════════════════════════════════════════════════╗\r\n" + //
                                "║                                                       ║\r\n" + //
                                "║   ____           _                   _                ║\r\n" + //
                                "║  / ___| ___  ___| |_ ___  _ __    __| | ___           ║\r\n" + //
                                "║ | |  _ / _ \\/ __| __/ _ \\| '__|  / _` |/ _ \\          ║\r\n" + //
                                "║ | |_| |  __/\\__ \\ || (_) | |    | (_| |  __/          ║\r\n" + //
                                "║  \\____|\\___||___/\\__\\___/|_|     \\__,_|\\___|          ║\r\n" + //
                                "║  _   _       _     _ _ _     _           _            ║\r\n" + //
                                "║ | | | | __ _| |__ (_) (_) __| | __ _  __| | ___  ___  ║\r\n" + //
                                "║ | |_| |/ _` | '_ \\| | | |/ _` |/ _` |/ _` |/ _ \\/ __| ║\r\n" + //
                                "║ |  _  | (_| | |_) | | | | (_| | (_| | (_| |  __/\\__ \\ ║\r\n" + //
                                "║ |_| |_|\\__,_|_.__/|_|_|_|\\__,_|\\__,_|\\__,_|\\___||___/ ║\r\n" + //
                                "║                                                       ║\r\n" + //
                                "╚═══════════════════════════════════════════════════════╝");
            System.out.println("1. Registrar una Persona");
            System.out.println("2. Asignar una Habilidad a una Persona");
            System.out.println("3. Crear una Nueva Habilidad");
            System.out.println("4. Consultar Personas por Habilidad");
            System.out.println("5. Actualizar Información de una Persona");
            System.out.println("6. Eliminar una Persona");
            System.out.println("7. Salir");

            System.out.println("Ingrese una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    com.filtro_java.persona.Domain.domainPersona.registrarPersona();
                    break;
                case 2:
                    com.filtro_java.persona.Domain.domainPersona.asignarHabilidad();
                    break;
                case 3:
                    com.filtro_java.persona.Domain.domainPersona.crearHabilidad();
                    break;
                case 4:
                    com.filtro_java.persona.Domain.domainPersona.consultarPorHabilidad();
                    break;
                case 5:
                    com.filtro_java.persona.Domain.domainPersona.actualizarPersona();
                    break;
                case 6:
                    com.filtro_java.persona.Domain.domainPersona.eliminarPersona();
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }

            if (!salir) {
                System.out.print("Presione Enter para continuar...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    public static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
