/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas;

/**
 *
 * @author nerysoftware
 */
public class cabecalho_bean {
    private int id;
    private String nome_cliente;
    private String data_lancamento;
    private String vendedor;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome_cliente
     */
    public String getNome_cliente() {
        return nome_cliente;
    }

    /**
     * @param nome_cliente the nome_cliente to set
     */
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    /**
     * @return the data_lancamento
     */
    public String getData_lancamento() {
        return data_lancamento;
    }

    /**
     * @param data_lancamento the data_lancamento to set
     */
    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    /**
     * @return the vendedor
     */
    public String getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    
}
