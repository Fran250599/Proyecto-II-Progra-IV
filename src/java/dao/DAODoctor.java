
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.progra.personas.logic.Doctor;


public class DAODoctor {
    
    public static void addDoctor(Connection con, String id, String name, String password) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO proyecto.doctors (id, name, password) VALUES ('" +id +"','" + name +"','" + password + "');");

            int status = stmt.executeUpdate();
            if (status != 0) {
                System.out.println("Successfully added");
            }

        } catch (SQLException ex) {

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    public static ArrayList<Doctor> getDoctors(Connection con) throws SQLException{
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM proyecto.doctors");

        
        ArrayList<Doctor> doctors = new ArrayList<>();
        //String name, String id, String password, String especialidad, String costoConsulta, String ubicacion, String horario, String frecuencia, String bio
        while(result.next()){
            
            String id = result.getString(1);
            String name = result.getString(2);
            String password = result.getString(3);
            String especialidad = result.getString(4);
            String costo = result.getString(5);
            String ubicacion = result.getString(6);
            String horario = result.getString(7);
            String frecuencia = result.getString(8);
            String bio = result.getString(9);
            
            Doctor d = new Doctor(id,name,password, especialidad, costo, ubicacion, horario, frecuencia, bio);
            
            doctors.add((Doctor) d);
        }
        
        
        return doctors;
        
    }
    
    
    public static void actualizarDoctor(Connection con, Doctor d) throws SQLException{
        try{
        PreparedStatement stmt = con.prepareStatement("UPDATE proyecto.doctors SET "+
                "especialidad = '" + d.getEspecialidad() + "'," +
                "costo = '" + d.getCostoConsulta() + "'," +
                "ubicacion = '" + d.getUbicacion() + "'," +
                "horario = '" + d.getHorario() + "'," +
                "frecuencia = '" + d.getFrecuencia() + "'," +
                "bio = '" + d.getBio() + "'" +
                "where id = '" + d.getId() + "'"
        );
        
        
        int status = stmt.executeUpdate();
            if (status != 0) {
                System.out.println("Successfully updated");
            }

        } catch (SQLException ex) {

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }          
    }
    
   

}