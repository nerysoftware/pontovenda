
package model.bean;


public class itens_bean {

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getCod_itens() {
        return cod_itens;
    }

 
    public void setCod_itens(String cod_itens) {
        this.cod_itens = cod_itens;
    }

 
   
    public Integer getId() {
        return id;
    }

   
    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getCod_cabecalho() {
        return cod_cabecalho;
    }

    
    public void setCod_cabecalho(String cod_cabecalho) {
        this.cod_cabecalho = cod_cabecalho;
    }

 
   
    public String getQuantidade() {
        return quantidade;
    }

   
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    
    public String getValor() {
        return valor;
    }

  
    public void setValor(String valor) {
        this.valor = valor;
    }

   
    public String getValor_total() {
        return valor_total;
    }

   
    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }
    
    private Integer id;
    private String cod_cabecalho;
    private String quantidade;
    private String valor;
    private String valor_total;
    private String cod_itens;
    private String situacao;
}
