/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import modelo.Persona;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author yue
 */

public class PersonaSpringDAO implements PersonaDAO{

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }    

    @Override
    public void create(Persona persona) {
        
        String sql = "INSERT INTO persona (" +
                    "nombre, " +
                    "clave, " +
                    "tipo) " +
                    "VALUES ( ?, ?, ? )";

            Object[] valores = new Object[] {
                persona.getNombre(),
                persona.getClave(),
                persona.getTipo()
            };

            int[] tipos = new int[] {
                Types.VARCHAR,
                Types.VARCHAR,
                Types.VARCHAR
            };
            jdbcTemplate.update(sql, valores, tipos);
    }

    @Override
    public Persona find(Long Id) {
        RowMapper rm=new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Persona persona = new Persona();
                persona.setId(rs.getLong("id"));
                persona.setNombre(rs.getString("nombre"));
                persona.setClave(rs.getString("clave"));
                persona.setTipo(rs.getString("tipo"));
                return persona;
            }
        };
        String sql="Select * from persona where id='"+Id+"'";
        Persona rpta= (Persona) jdbcTemplate.queryForObject(sql, rm);
        return rpta;
    }

    
    @Override
    public void update(Persona persona) {
        String sql="update persona set nombre=?, clave=?,tipo=? where id=?";
        Object []valores=new Object[]{persona.getNombre(),persona.getClave(),
        persona.getTipo(),persona.getId()};
        jdbcTemplate.update(sql, valores);
    }

    @Override
    public void delete(Long personaId) {
        String sql = "delete from persona where id=?";
        Object []p= new Object[]{personaId};
        jdbcTemplate.update(sql, p);
    }

    @Override
    public Collection findAll() {
        RowMapper rm=new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Persona persona = new Persona();
                persona.setId(rs.getLong("id"));
                persona.setNombre(rs.getString("nombre"));
                persona.setClave(rs.getString("clave"));
                persona.setTipo(rs.getString("tipo"));

                return persona;
            }
        };
        String sql="Select * from persona";
        return jdbcTemplate.query(sql, rm);
    }    
}
