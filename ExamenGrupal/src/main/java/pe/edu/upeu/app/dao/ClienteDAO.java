/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import pe.com.syscenterlife.autocomp.ModeloDataAutocomplet;
import pe.edu.upeu.app.dao.conx.Conn;
import pe.edu.upeu.app.modelo.ClienteTO;
import pe.edu.upeu.app.util.ErrorLogger;

public class ClienteDAO implements ClienteDaoI {

    Statement stmt = null;
    Vector columnNames;
    Vector visitdata;
    Connection connection = Conn.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ClienteDAO.class.getName());
    ResultSet rs = null;

    public ClienteDAO() {
        columnNames = new Vector();
        visitdata = new Vector();
    }

    @Override
    //Crear cliente
    public int create(ClienteTO d) {
        int rsId = 0;
        String[] returns = {"dniruc"};
        String sql = "INSERT INTO cliente(dniruc, nombrers, tipo, telefono) "
                + "VALUES(?,?,?,?)";
        int i = 0;
        try {
            ps = connection.prepareStatement(sql, returns);
            ps.setString(++i, d.getDniruc());
            ps.setString(++i, d.getNombresrs());
            ps.setString(++i, d.getTipo());
            ps.setString(++i, d.getTelefono());
            rsId = ps.executeUpdate();// 0 no o 1 si commit
            try ( ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId = rs.getInt(1);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            //System.err.println("create:" + ex.toString());
            log.log(Level.SEVERE, "create", ex);
        }
        return rsId;
    }

    @Override
    //Actualizar cliente
    public int update(ClienteTO d) {
        System.out.println("actualizar d.getDniruc: " + d.getDniruc());
        int comit = 0;
        String sql = "UPDATE cliente SET "
                + "nombrers=?, "
                + "tipo=? "
                + "WHERE dniruc=?";
        int i = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(++i, d.getNombresrs());
            ps.setString(++i, d.getTipo());
            ps.setString(++i, d.getDniruc());
            ps.setString(++i, d.getTelefono());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }

    @Override
    //Borrar cliente
    public int delete(String id) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM cliente WHERE dniruc = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Detalle:" + ex.getMessage());
        }
        return comit;
    }

    @Override
    public List<ClienteTO> listCmb(String filter) {
        List<ClienteTO> ls = new ArrayList();
        ls.add(new ClienteTO());
        ls.addAll(listarClientes());
        return ls;
    }

    @Override
    public List<ClienteTO> listarClientes() {
        List<ClienteTO> listarclientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            connection = new Conn().connectSQLite();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteTO cli = new ClienteTO();
                cli.setDniruc(rs.getString("dniruc"));
                cli.setNombresrs(rs.getString("nombrers"));
                cli.setTipo(rs.getString("tipo"));
                cli.setTelefono(rs.getString("telefono"));
                listarclientes.add(cli);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listarclientes;
    }

    @Override
    public ClienteTO buscarClientes(String dni) {
        ClienteTO cliente = new ClienteTO();
        String sql = "SELECT * FROM cliente WHERE dniruc = ?";
        try {
            connection = new Conn().connectSQLite();
            ps = connection.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setDniruc(rs.getString("dniruc"));
                cliente.setNombresrs(rs.getString("nombrers"));
                cliente.setTipo(rs.getString("tipo"));
                cliente.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cliente;
    }

    @Override
    public void reportarCliente() {
    }

    @Override
    public List<ModeloDataAutocomplet> listAutoComplet(String filter) {
        List<ModeloDataAutocomplet> listarclientes = new ArrayList();
        String sql = "SELECT * FROM cliente WHERE nombrers like ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, filter + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                ModeloDataAutocomplet data = new ModeloDataAutocomplet();
                ModeloDataAutocomplet.TIPE_DISPLAY = "ID";
                data.setIdx(rs.getString("dniruc"));
                data.setNombreDysplay(rs.getString("nombrers"));
                data.setOtherData(rs.getString("tipo"));
                listarclientes.add(data);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listarclientes;
    }
}

