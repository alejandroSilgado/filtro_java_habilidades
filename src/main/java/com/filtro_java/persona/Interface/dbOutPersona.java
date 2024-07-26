package com.filtro_java.persona.Interface;

import java.sql.*;
import resources.conexionDB;

public class dbOutPersona {
    public static void main(String[] args) {

    }
    public static void dbimprimirCuidad() {
        String sql = "SELECT * FROM city";
        try (Connection conn = conexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("");
                System.out.println("-----------------");
                System.out.println("ID: " + id + ", Nombre: " + name);
                System.out.println("-----------------");
                System.out.println("");

            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void dbimprimirGenero() {
        String sql = "SELECT * FROM gender";
        try (Connection conn = conexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("");
                System.out.println("-----------------");
                System.out.println("ID: " + id + ", Nombre: " + name);
                System.out.println("-----------------");
                System.out.println("");

            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void dbimprimirPersona() {
        String sql = "SELECT p.id, p.name, p.lastname, p.address, p.age, p.email, g.name AS gender_name, c.name AS city_name "
                + "FROM persons p "
                + "JOIN gender g ON p.idgender = g.id "
                + "JOIN city c ON p.idcity = c.id";
        try (Connection conn = conexionDB.getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);
              ResultSet rs = ps.executeQuery()) {
    
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                Integer age = rs.getInt("age");
                String email = rs.getString("email");
                String gender_name = rs.getString("gender_name");
                String city_name = rs.getString("city_name");
                System.out.println("");
                System.out.println("-----------------");
                System.out.println("ID: " + id + ", Nombre: " + name + " " + lastname + ", Dirección: " + address + ", Edad: " + age + ", Email: " + email + ", Género: " + gender_name + ", ciudad: " + city_name);
                System.out.println("-----------------");
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void dbimprimirHabilidad() {
        String sql = "SELECT * FROM skill";
        try (Connection conn = conexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("");
                System.out.println("-----------------");
                System.out.println("ID: " + id + ", Nombre: " + name);
                System.out.println("-----------------");
                System.out.println("");

            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void dbregistrarPersona(String nombre, String apellido, Integer idciudad, String direccion, Integer edad, String email, Integer idgenero) {
        if (!existeCiudad(idciudad) || !existeGenero(idgenero)) {
            System.out.println("Error: idciudad o idgenero no válido.");
            return;
        }
    
        String sql = "INSERT INTO persons (name, lastname, idcity, address, age, email, idgender) VALUES (?,?,?,?,?,?,?)";
    
        try (Connection conn = conexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
    
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, idciudad);
            ps.setString(4, direccion);
            ps.setInt(5, edad);
            ps.setString(6, email);
            ps.setInt(7, idgenero);
    
            int filasAfectadas = ps.executeUpdate();
    
            if (filasAfectadas > 0) {
                System.out.println("La persona se creó correctamente.");
            } else {
                System.out.println("La persona no se creó correctamente.");
            }
    
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static boolean existeCiudad(int idciudad) {
        String sql = "SELECT COUNT(*) FROM city WHERE id = ?";
        try (Connection conn = conexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idciudad);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    private static boolean existeGenero(int idgenero) {
        String sql = "SELECT COUNT(*) FROM gender WHERE id = ?";
        try (Connection conn = conexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idgenero);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    

    public static void dbasignarHabilidad(String fecha, Integer idPersona, Integer idHabilidad) {
        String checkPersonSql = "SELECT COUNT(*) FROM persons WHERE id = ?";
        String checkSkillSql = "SELECT COUNT(*) FROM skill WHERE id = ?";
        String insertSql = "INSERT INTO person_skill (registration_date, idperson, idskill) VALUES (?, ?, ?)";

        try (Connection conn = conexionDB.getConnection();
                PreparedStatement checkPersonPs = conn.prepareStatement(checkPersonSql);
                PreparedStatement checkSkillPs = conn.prepareStatement(checkSkillSql);
                PreparedStatement insertPs = conn.prepareStatement(insertSql)) {

            // Verificar si la persona existe
            checkPersonPs.setInt(1, idPersona);
            ResultSet personRs = checkPersonPs.executeQuery();
            personRs.next();
            int personCount = personRs.getInt(1);
            if (personCount == 0) {
                System.out.println("La persona con id " + idPersona + " no existe.");
                return;
            }

            // Verificar si la habilidad existe
            checkSkillPs.setInt(1, idHabilidad);
            ResultSet skillRs = checkSkillPs.executeQuery();
            skillRs.next();
            int skillCount = skillRs.getInt(1);
            if (skillCount == 0) {
                System.out.println("La habilidad con id " + idHabilidad + " no existe.");
                return;
            }

            insertPs.setString(1, fecha);
            insertPs.setInt(2, idPersona);
            insertPs.setInt(3, idHabilidad);

            int filasAfectadas = insertPs.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("La habilidad fue asignada correctamente.");
            } else {
                System.out.println("La habilidad no fue asignada correctamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void dbcrearHabilidad(String nombre) {
        String sql = "INSERT INTO skill (name) VALUES (?)";

        try (Connection conn = conexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("La habilidad se creó correctamente.");
            } else {
                System.out.println("La habilidad no se creó correctamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void dbconsultarPorHabilidad(Integer habilidad) {
        String sql = "SELECT p.id, p.name, p.lastname, p.address, p.age, p.email, g.name AS gender_name, c.name AS city_name "
                + "FROM persons p "
                + "JOIN person_skill ps ON p.id = ps.idperson "
                + "JOIN skill s ON ps.idskill = s.id "
                + "JOIN gender g ON p.idgender = g.id "
                + "JOIN city c ON p.idcity = c.id "
                + "WHERE s.id = ?";
    
        try (Connection conn = conexionDB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
    
            ps.setInt(1, habilidad);
            try (ResultSet rs = ps.executeQuery()) {
    
                if (rs.next()) {
                    do {
                        Integer id = rs.getInt("id");
                        String name = rs.getString("name");
                        String lastname = rs.getString("lastname");
                        String address = rs.getString("address");
                        Integer age = rs.getInt("age");
                        String email = rs.getString("email");
                        String gender_name = rs.getString("gender_name");
                        String city_name = rs.getString("city_name");
                        System.out.println("");
                        System.out.println("-----------------");
                        System.out.println("ID: " + id + ", Nombre: " + name + " " + lastname + ", Dirección: " + address + ", Edad: " + age + ", Email: " + email + ", Género: " + gender_name + ", ciudad: " + city_name);
                        System.out.println("-----------------");
                        System.out.println("");
                    } while (rs.next());
                } else {
                    System.out.println("No se encontraron personas con la habilidad " + habilidad);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void dbactualizarPersona(Integer idPersona, String nombre, String apellido, Integer idCiudad, String direccion, Integer edad, String email, Integer idGenero) {
        String checkPersonSql = "SELECT COUNT(*) FROM persons WHERE id = ?";
        String sql = "UPDATE persons SET name = ?, lastname = ?, idcity = ?, address = ?, age = ?, email = ?, idgender = ? WHERE id = ?";

        try (Connection conn = conexionDB.getConnection();
             PreparedStatement checkPersonPs = conn.prepareStatement(checkPersonSql)) {

            // Verificar si la persona existe
            checkPersonPs.setInt(1, idPersona);
            ResultSet personRs = checkPersonPs.executeQuery();
            personRs.next();
            int personCount = personRs.getInt(1);
            if (personCount == 0) {
                System.out.println("La persona con id " + idPersona + " no existe.");
                return;
            }

            // Proceder a actualizar la persona
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setInt(3, idCiudad);
                ps.setString(4, direccion);
                ps.setInt(5, edad);
                ps.setString(6, email);
                ps.setInt(7, idGenero);
                ps.setInt(8, idPersona);

                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("La persona fue actualizada correctamente.");
                } else {
                    System.out.println("No se encontró una persona con el ID proporcionado.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void dbeliminarPersona(Integer idpersona) {
        String sql = "DELETE FROM persons WHERE id = ?";
        String checkPersonSql = "SELECT COUNT(*) FROM persons WHERE id = ?";
    
        try (Connection conn = conexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             PreparedStatement checkPersonPs = conn.prepareStatement(checkPersonSql)) {
    
            // Verificar si la persona existe
            checkPersonPs.setInt(1, idpersona);
            try (ResultSet personRs = checkPersonPs.executeQuery()) {
                personRs.next();
                int personCount = personRs.getInt(1);
                if (personCount == 0) {
                    System.out.println("La persona con id " + idpersona + " no existe.");
                    return;
                }
            }
    
            ps.setInt(1, idpersona);
    
            int filasAfectadas = ps.executeUpdate();
    
            if (filasAfectadas > 0) {
                System.out.println("La persona fue eliminada correctamente.");
            } else {
                System.out.println("No se encontró una persona con el ID proporcionado.");
            }
    
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
