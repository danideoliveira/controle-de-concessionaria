package DAO;

import DTO.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ClienteDTO> lista = new ArrayList<>();

    public void cadastrarCliente(ClienteDTO objclientedto) throws SQLException {
        String sql = "INSERT INTO cliente (cpf, nome, telefone) VALUES (?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objclientedto.getCpf());
            pstm.setString(2, objclientedto.getNome_cliente());
            pstm.setString(3, objclientedto.getTelefone());
            
            pstm.execute();
            pstm.close();
            
        }
        
        catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException erro) {
            JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
        }
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO: " + erro);
        } 
    }
    
    public void editarCliente(ClienteDTO objclientedto) {
        String sql = "UPDATE cliente SET cpf = ?, nome = ?, telefone = ? WHERE id_cliente = ?";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objclientedto.getCpf());
            pstm.setString(2, objclientedto.getNome_cliente());
            pstm.setString(3, objclientedto.getTelefone());
            pstm.setInt(4, objclientedto.getId_cliente());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO " + erro);
        }
    }
    
    public void excluirCliente(ClienteDTO objclientedto) {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objclientedto.getId_cliente());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO " + erro);
        }
    }
    
    public void maiorValorId(ClienteDTO objClienteDTO) {
        String sql = "SELECT MAX(id_cliente) FROM cliente";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                objClienteDTO = new ClienteDTO();
                objClienteDTO.setId_cliente(rs.getInt("id_cliente"));
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO " + erro);
        }
    }
    
    public ArrayList<ClienteDTO> pesquisarCliente(){
        String sql = "SELECT * FROM cliente ORDER BY id_cliente, nome";
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                ClienteDTO objClienteDTO = new ClienteDTO();
                objClienteDTO.setId_cliente(rs.getInt("id_cliente"));
                objClienteDTO.setCpf(rs.getString("cpf"));
                objClienteDTO.setNome_cliente(rs.getString("nome"));
                objClienteDTO.setTelefone(rs.getString("telefone"));
                
                lista.add(objClienteDTO);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO " + erro);
        }
        return lista;
    }
    
    public ArrayList<ClienteDTO> buscarCliente(String coluna, ClienteDTO objclientedto){
        String sql = "SELECT * FROM cliente WHERE " + coluna + " LIKE ?";
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            
            switch (coluna) {
                case "nome":
                    pstm.setString(1, objclientedto.getNome_cliente());
                    break;
                case "cpf":
                    pstm.setString(1, objclientedto.getCpf());
                    break;
                case "telefone":
                    pstm.setString(1, objclientedto.getTelefone());
                    break;
            }
            
            rs = pstm.executeQuery();
            
            while(rs.next()){
                ClienteDTO objClienteDTO = new ClienteDTO();
                objClienteDTO.setId_cliente(rs.getInt("id_cliente"));
                objClienteDTO.setCpf(rs.getString("cpf"));
                objClienteDTO.setNome_cliente(rs.getString("nome"));
                objClienteDTO.setTelefone(rs.getString("telefone"));
                
                lista.add(objClienteDTO);
            }           
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO " + erro);
        }
        return lista;
    }
}
