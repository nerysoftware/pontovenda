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
public class itens_bean {
    private int id;
    private String cod_cabecalho;
    private String cod_itens;
    private String quantidade;
    private String valor;
    private String tipo;
    private String valor_total;
    private String descricao;

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
     * @return the cod_cabecalho
     */
    public String getCod_cabecalho() {
        return cod_cabecalho;
    }

    /**
     * @param cod_cabecalho the cod_cabecalho to set
     */
    public void setCod_cabecalho(String cod_cabecalho) {
        this.cod_cabecalho = cod_cabecalho;
    }

    /**
     * @return the cod_itens
     */
    public String getCod_itens() {
        return cod_itens;
    }

    /**
     * @param cod_itens the cod_itens to set
     */
    public void setCod_itens(String cod_itens) {
        this.cod_itens = cod_itens;
    }

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
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the valor_total
     */
    public String getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
