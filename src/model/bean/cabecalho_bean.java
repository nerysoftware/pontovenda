package model.bean;




public class cabecalho_bean {

   
    public Integer getId() {
        return id;
    }

   
    public void setId(Integer id) {
        this.id = id;
    }

   
    public String getNome_cliente() {
        return nome_cliente;
    }

   
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    
    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }
    
    private Integer id;
    private String nome_cliente;
    private String data_lancamento;

    
    
            
   
    
}
