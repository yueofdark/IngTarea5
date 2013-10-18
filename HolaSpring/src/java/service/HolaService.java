/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author nilver
 */
import java.sql.*;
import controller.Usuario;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class HolaService {
    
    private JdbcTemplate jdbcTemplate;
 
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
           this.jdbcTemplate = jdbcTemplate;
     }

     public JdbcTemplate getJdbcTemplate() {
           return jdbcTemplate;
     }
     
     private DataSource dataSource;
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    public Usuario diHola(String nombreUsuario,String claveUsuario){
        //abrir la Base de datos
       //Aqui ya deberia conectarse bien, ya configure el dispacher-Servlet
        //SOlo que no se como mostrarlo con el .query
         // jdbcTemplate.query("select nombre,clave,tipo from usuario");
          
            String sql =  "SELECT * FROM USUARIO"
                 + " WHERE (NOMBRE = nombreUsuario) AND (CLAVE = claveUsuario)";
        
        
 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nombreUsuario);
			Usuario usuario = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new Usuario(
					rs.getString("NOMBRE"),
					rs.getString("CLAVE"), 
					rs.getString("TIPO")
				);
			}
			rs.close();
			ps.close();
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
                        }
                }
       
    }              
  
       
}
