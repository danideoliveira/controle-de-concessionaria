package DAO;

import DTO.MotoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MotoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<MotoDTO> lista = new ArrayList<>();

    public void cadastrarMoto(MotoDTO objmotodto) throws SQLException {
        String sql = "INSERT INTO moto (placa, modelo, marca) VALUES (?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objmotodto.getPlaca());
            pstm.setString(2, objmotodto.getModelo());
            pstm.setString(3, objmotodto.getMarca());
            
            pstm.execute();
            pstm.close();
            
        }
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException erro) {
            JOptionPane.showMessageDialog(null, "Placa já cadastrada!");
        }
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "MotoDAO: " + erro);
        } 
    }
    
    public void editarMoto(MotoDTO objmotodto) {
        String sql = "UPDATE moto SET placa = ?, modelo = ?, marca = ? WHERE id_moto = ?";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objmotodto.getPlaca());
            pstm.setString(2, objmotodto.getModelo());
            pstm.setString(3, objmotodto.getMarca());
            pstm.setInt(4, objmotodto.getId_moto());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "MotoDAO " + erro);
        }
    }
    
    public void excluirMoto(MotoDTO objmotodto) {
        String sql = "DELETE FROM moto WHERE id_moto = ?";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objmotodto.getId_moto());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "MotoDAO " + erro);
        }
    }
    
    public ArrayList<MotoDTO> pesquisarMoto(){
        String sql = "SELECT * FROM moto ORDER BY id_moto, modelo";
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                MotoDTO objMotoDTO = new MotoDTO();
                objMotoDTO.setId_moto(rs.getInt("id_moto"));
                objMotoDTO.setPlaca(rs.getString("placa"));
                objMotoDTO.setModelo(rs.getString("modelo"));
                objMotoDTO.setMarca(rs.getString("marca"));
                
                lista.add(objMotoDTO);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "MotoDAO " + erro);
        }
        return lista;
    }
    
    public ArrayList<MotoDTO> buscarMoto(String coluna, MotoDTO objmotodto){
        String sql = "SELECT * FROM moto WHERE " + coluna + " LIKE ?";
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            
            switch (coluna) {
                case "modelo":
                    pstm.setString(1, objmotodto.getModelo());
                    break;
                case "placa":
                    pstm.setString(1, objmotodto.getPlaca());
                    break;
                case "marca":
                    pstm.setString(1, objmotodto.getMarca());
                    break;
            }
            
            rs = pstm.executeQuery();
            
            while(rs.next()){
                MotoDTO objMotoDTO = new MotoDTO();
                objMotoDTO.setId_moto(rs.getInt("id_moto"));
                objMotoDTO.setPlaca(rs.getString("placa"));
                objMotoDTO.setModelo(rs.getString("modelo"));
                objMotoDTO.setMarca(rs.getString("marca"));
                
                lista.add(objMotoDTO);
            }           
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "MotoDAO " + erro);
        }
        return lista;
    }
}
