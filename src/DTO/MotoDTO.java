
package DTO;


public class MotoDTO {
    
    private String placa, modelo, marca;
    private int id_moto, preco_moto;

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
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
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the preco_moto
     */
    public int getPreco_moto() {
        return preco_moto;
    }

    /**
     * @param preco_moto the preco_moto to set
     */
    public void setPreco_moto(int preco_moto) {
        this.preco_moto = preco_moto;
    }
    
}
