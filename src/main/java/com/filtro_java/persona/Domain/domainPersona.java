package com.filtro_java.persona.Domain;

import java.util.Scanner;

public class domainPersona {
    public static void registrarPersona() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la persona: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el apellido de la persona: ");
        String apellido = sc.nextLine();

        // imprimir la tabla de cuidades
        com.filtro_java.persona.Interface.dbOutPersona.dbimprimirCuidad();
        System.out.println("Ingrese el ID de la cuidad: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese la direccion de su casa: ");
        String direccion = sc.nextLine();

        System.out.println("Ingrese la edad de la persona: ");
        Integer edad = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese el email de la persona: ");
        String email = sc.nextLine();

        // imprimir la tabla de generos
        com.filtro_java.persona.Interface.dbOutPersona.dbimprimirGenero(); 
        System.out.println("Ingrese el ID del genero de la persona: ");
        Integer idGenero = sc.nextInt();
        sc.nextLine();

        com.filtro_java.persona.Interface.dbOutPersona.dbregistrarPersona(nombre, apellido, id, direccion, edad,email,idGenero);
    }

    public static void asignarHabilidad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la fecha de la asignacion: ");
        String fecha = sc.nextLine();
        // Imprimir tabla persona
        com.filtro_java.persona.Interface.dbOutPersona.dbimprimirPersona();
        System.out.println("Ingrese el ID de la persona: ");
        Integer id = sc.nextInt();
        sc.nextLine();
        // imprimir tabla habilidades
        com.filtro_java.persona.Interface.dbOutPersona.dbimprimirHabilidad();
        System.out.println("Ingrese el ID de la habilidad: ");
        Integer idHabilidad = sc.nextInt();
        sc.nextLine();

        com.filtro_java.persona.Interface.dbOutPersona.dbasignarHabilidad(fecha,id, idHabilidad);
    }

    public static void crearHabilidad() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la habilidad: ");
        String nombre = sc.nextLine();

        com.filtro_java.persona.Interface.dbOutPersona.dbcrearHabilidad(nombre);
    }

    public static void consultarPorHabilidad() {
        Scanner sc = new Scanner(System.in);
        com.filtro_java.persona.Interface.dbOutPersona.dbimprimirHabilidad();

        System.out.println("Ingrese el ID de la habilidad: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        com.filtro_java.persona.Interface.dbOutPersona.dbconsultarPorHabilidad(id);
    }

    public static void actualizarPersona() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el ID de la persona: ");
        Integer id = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Ingrese el nuevo nombre: ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el nuevo apellido: ");
        String apellido = sc.nextLine();
        com.filtro_java.persona.Interface.dbOutPersona.dbimprimirCuidad();
        System.out.println("Ingrese el nuevo ID de ciudad: ");
        Integer idCiudad = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Ingrese la nueva dirección: ");
        String direccion = sc.nextLine();

        System.out.println("Ingrese la nueva edad: ");
        Integer edad = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Ingrese el nuevo email: ");
        String email = sc.nextLine();
        com.filtro_java.persona.Interface.dbOutPersona.dbimprimirGenero();
        System.out.println("Ingrese el nuevo ID de género: ");
        Integer idGenero = sc.nextInt();
        sc.nextLine(); 

        // Llamar al método que actualiza la persona en la base de datos
        com.filtro_java.persona.Interface.dbOutPersona.dbactualizarPersona(id, nombre, apellido, idCiudad, direccion, edad, email, idGenero);
    }

    public static void eliminarPersona() {
        Scanner sc = new Scanner(System.in);
        com.filtro_java.persona.Interface.dbOutPersona.dbimprimirPersona();
        System.out.println("Ingrese el ID de la persona: ");
        Integer id = sc.nextInt();
        sc.nextLine();

        com.filtro_java.persona.Interface.dbOutPersona.dbeliminarPersona(id);
    }
}
