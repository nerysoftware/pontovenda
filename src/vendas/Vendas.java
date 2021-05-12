/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas;

/**
 *
 * @author hugov
 */
public class Vendas {

    /**
     * @return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

   
    public static String LISTAR = "SELECT * FROM vendas ORDER BY data_ven";
    
    public static String REGISTRAR = "INSERT INTO vendas(numero_ven, itens_vend, total_ven, data_ven, cliente_vend,quantidade,modalidade,cabecalho,situacao) "
            + "VALUES(?,?,?,?,?,?,?,?,?)";
    
    public static String ELIMINAR = "DELETE FROM vendas WHERE numero_ven = ?";
    
    public static String ELIMINAR_TUDO = "DELETE FROM vendas";
    
    private String primaryKey;
    private String itens;
    private String total;
    private String data;
    private String cliente;
    private String quantidade;
    private String modalidede;
    private String cabecalho;
    private String situacao;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public Vendas(){
        
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public String getItens() {
        return itens;
    }

   
    public void setItens(String itens) {
        this.itens = itens;
    }

    /**
     * @return the modalidede
     */
    public String getModalidede() {
        return modalidede;
    }

    /**
     * @param modalidede the modalidede to set
     */
    public void setModalidede(String modalidede) {
        this.modalidede = modalidede;
    }

    /**
     * @return the cabecalho
     */
    public String getCabecalho() {
        return cabecalho;
    }

    /**
     * @param cabecalho the cabecalho to set
     */
    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho;
    }
}
