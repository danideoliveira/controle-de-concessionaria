package DTO;

import java.sql.Timestamp;

public class VendaDTO {
    private String cpf_venda, nome_cliente_venda, telefone_venda, placa_venda, modelo_venda, marca_venda, preco_moto, data_venda;
    private int id_venda, id_cliente, id_moto;

    /**
     * @return the cpf_venda
     */
    public String getCpf_venda() {
        return cpf_venda;
    }

    /**
     * @param cpf_venda the cpf_venda to set
     */
    public void setCpf_venda(String cpf_venda) {
        this.cpf_venda = cpf_venda;
    }

    /**
     * @return the nome_cliente_venda
     */
    public String getNome_cliente_venda() {
        return nome_cliente_venda;
    }

    /**
     * @param nome_cliente_venda the nome_cliente_venda to set
     */
    public void setNome_cliente_venda(String nome_cliente_venda) {
        this.nome_cliente_venda = nome_cliente_venda;
    }

    /**
     * @return the telefone_venda
     */
    public String getTelefone_venda() {
        return telefone_venda;
    }

    /**
     * @param telefone_venda the telefone_venda to set
     */
    public void setTelefone_venda(String telefone_venda) {
        this.telefone_venda = telefone_venda;
    }

    /**
     * @return the placa_venda
     */
    public String getPlaca_venda() {
        return placa_venda;
    }

    /**
     * @param placa_venda the placa_venda to set
     */
    public void setPlaca_venda(String placa_venda) {
        this.placa_venda = placa_venda;
    }

    /**
     * @return the modelo_venda
     */
    public String getModelo_venda() {
        return modelo_venda;
    }

    /**
     * @param modelo_venda the modelo_venda to set
     */
    public void setModelo_venda(String modelo_venda) {
        this.modelo_venda = modelo_venda;
    }

    /**
     * @return the marca_venda
     */
    public String getMarca_venda() {
        return marca_venda;
    }

    /**
     * @param marca_venda the marca_venda to set
     */
    public void setMarca_venda(String marca_venda) {
        this.marca_venda = marca_venda;
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the id_moto
     */
    public int getId_moto() {
        return id_moto;
    }

    /**
     * @param id_moto the id_moto to set
     */
    public void setId_moto(int id_moto) {
        this.id_moto = id_moto;
    }

    /**
     * @return the id_venda
     */
    public int getId_venda() {
        return id_venda;
    }

    /**
     * @param id_venda the id_venda to set
     */
    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public void getMarca_venda(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the data_venda
     */
    public String getData_venda() {
        return data_venda;
    }

    /**
     * @param data_venda the data_venda to set
     */
    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    /**
     * @return the preco_moto
     */
    public String getPreco_moto() {
        return preco_moto;
    }

    /**
     * @param preco_moto the preco_moto to set
     */
    public void setPreco_moto(String preco_moto) {
        this.preco_moto = preco_moto;
    }
    
}
