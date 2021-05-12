/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtos;

/**
 *
 * @author hugov
 */
public class Produtos {

   
    
    public static String LISTAR = "SELECT * FROM produtos ORDER BY nome_pro";
    
    public static String REGISTRAR = "INSERT INTO produtos(codigo_pro, tipo_pro, nome_pro,valor_compra, valor_pro,quant_pro,margem_lucro,un,ncm,cest,ean) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    
    public static String ATUALIZAR = "UPDATE produtos SET "
                + "tipo_pro=?, "
                + "nome_pro=?, "
                + "quant_pro=?, "
                + "valor_compra=?,"
                + "margem_lucro=?,"
                + "valor_pro=?,"
                + "un=?,"
                + "ean=? WHERE codigo_pro=?";
    
    public static String ELIMINAR = "DELETE FROM produtos WHERE codigo_pro = ?";
    
    public static String ELIMINAR_TUDO = "DELETE FROM produtos";
    
    private String primaryKey;
    private String tipo;
    private String nome;
    private String valorcompra;
    private String valor;
    private String quant_pro;
    private String margem_lucro;
    private String ncm;
    private String cest;
    private String un;
    private String ean;

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }
    
    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public Produtos(){
        
    }
    
   /**
     * @return the margem_lucro
     */
    public String getMargem_lucro() {
        return margem_lucro;
    }

    
    public void setMargem_lucro(String margem_lucro) {
        this.margem_lucro = margem_lucro;
    }

    
    public String getQuant_pro() {
        return quant_pro;
    }

    
    public void setQuant_pro(String quant_pro) {
        this.quant_pro = quant_pro;
    }

   
    public String getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(String valorcompra) {
        this.valorcompra = valorcompra;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    
}
