/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

/**
 *
 * @author hugov
 */
public class Usuarios {

   
  
   
  
    
    public static String LISTAR_US = "SELECT * FROM usuarios ORDER BY nome_us";
    
    public static String REGISTRAR = "INSERT INTO usuarios(codigo_us, nome_us, sexo_us, tipo_us, senha, cep, rua, uf, bairro,cidade) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?)";
    
    public static String ATUALIZAR = "UPDATE usuarios SET "
                + "nome_us=?, "
                + "sexo_us=?, "
                + "tipo_us=?, "
                + "senha=? WHERE codigo_us=?";
    
    public static String ELIMINAR = "DELETE FROM usuarios WHERE codigo_us = ?";
    
    public static String ELIMINAR_TUDO = "DELETE FROM usuarios";
    
    private String primaryKey;
    private String nome;
    private String sexo;
    private String tipouser;
    private String senha;
    private String cep;
    private String rua;
    private String uf;
    private String bairro;
    private String cidade;

    public Usuarios(){
        
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipouser() {
        return tipouser;
    }

    public void setTipouser(String tipouser) {
        this.tipouser = tipouser;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
      public String getCep() {
        return cep;
    }

    
    public void setCep(String cep) {
        this.cep = cep;
    }

  
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

 
    public String getUf() {
        return uf;
    }

  
    public void setUf(String uf) {
        this.uf = uf;
    }

  
    public String getBairro() {
        return bairro;
    }

  
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
     
    public String getCidade() {
        return cidade;
    }

  
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    
}
