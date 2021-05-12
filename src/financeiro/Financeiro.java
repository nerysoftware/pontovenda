/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro;

import vendas.*;

/**
 *
 * @author hugov
 */
public class Financeiro {

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
    
    public static String REGISTRAR = "INSERT INTO vendas(numero_ven, itens_vend, total_ven, data_ven, cliente_vend) "
            + "VALUES(?,?,?,?,?)";
    
    public static String ELIMINAR = "DELETE FROM vendas WHERE numero_ven = ?";
    
    public static String ELIMINAR_TUDO = "DELETE FROM vendas";
    
    private String primaryKey;
    private String itens;
    private String total;
    private String data;
    private String cliente;
    private String situacao;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Financeiro(){
        
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
}
