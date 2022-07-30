package DAO;

import DTO.ClienteDTO;
import DTO.MotoDTO;
import DTO.VendaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendaDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<VendaDTO> lista = new ArrayList<>();

    public void registrarVenda(VendaDTO objvendadto) throws SQLException {
        String sql = "INSERT INTO registro_venda (cpf, nome_cliente, telefone, placa, modelo, marca, preco, dt_venda) VALUES (?,?,?,?,?,?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objvendadto.getCpf_venda());
            pstm.setString(2, objvendadto.getNome_cliente_venda());
            pstm.setString(3, objvendadto.getTelefone_venda());
            pstm.setString(4, objvendadto.getPlaca_venda());
            pstm.setString(5, objvendadto.getModelo_venda());
            pstm.setString(6, objvendadto.getMarca_venda());
            pstm.setString(7, objvendadto.getPreco_moto());
            pstm.setString(8, objvendadto.getData_venda());
            
            pstm.execute();
            pstm.close();
            
        }
        
        catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VendaDAO: " + erro);
        } 
    }
    
    public ArrayList<VendaDTO> pesquisarVenda(){
        String sql = "SELECT * FROM registro_venda ORDER BY id_venda, nome_cliente";
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                VendaDTO objvendadto = new VendaDTO();
                
                objvendadto.setId_venda(rs.getInt("id_venda"));
                objvendadto.setCpf_venda(rs.getString("cpf"));
                objvendadto.setNome_cliente_venda(rs.getString("nome_cliente"));
                objvendadto.setTelefone_venda(rs.getString("telefone"));
                objvendadto.setPlaca_venda(rs.getString("placa"));
                objvendadto.setModelo_venda(rs.getString("modelo"));
                objvendadto.setMarca_venda(rs.getString("marca"));
                objvendadto.setPreco_moto(rs.getString("preco"));
                objvendadto.setData_venda(rs.getString("dt_venda"));
                
                lista.add(objvendadto);
            }
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VendaDAO " + erro);
        }
        return lista;
    }
    
    public ArrayList<VendaDTO> buscarVenda(String coluna, VendaDTO objvendadto){
        String sql = "SELECT * FROM registro_venda WHERE " + coluna + " LIKE ?";
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            
            switch (coluna) {
                case "cpf":
                    pstm.setString(1, objvendadto.getCpf_venda());
                    break;
                case "nome_cliente":
                    pstm.setString(1, objvendadto.getNome_cliente_venda());
                    break;
                case "telefone":
                    pstm.setString(1, objvendadto.getTelefone_venda());
                    break;
                case "modelo":
                    pstm.setString(1, objvendadto.getModelo_venda());
                    break;
                case "placa":
                    pstm.setString(1, objvendadto.getPlaca_venda());
                    break;
                case "marca":
                    pstm.setString(1, objvendadto.getMarca_venda());
                    break;
                case "preco":
                    pstm.setString(1, objvendadto.getPreco_moto());
                    break;
                case "dt_venda":
                    pstm.setString(1, objvendadto.getData_venda());
                    break;
            }
            
            rs = pstm.executeQuery();
            
            while(rs.next()){
                VendaDTO objvendaDTO = new VendaDTO();
                objvendaDTO.setId_venda(rs.getInt("id_venda"));
                objvendaDTO.setCpf_venda(rs.getString("cpf"));
                objvendaDTO.setNome_cliente_venda(rs.getString("nome_cliente"));
                objvendaDTO.setTelefone_venda(rs.getString("telefone"));
                objvendaDTO.setPlaca_venda(rs.getString("placa"));
                objvendaDTO.setModelo_venda(rs.getString("modelo"));
                objvendaDTO.setMarca_venda(rs.getString("marca"));
                objvendaDTO.setPreco_moto(rs.getString("preco"));
                objvendaDTO.setData_venda(rs.getString("dt_venda"));
                
                lista.add(objvendaDTO);
            }           
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "VendaDAO " + erro);
        }
        return lista;
    }

}
