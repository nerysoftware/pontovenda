
package os;


public class OrdenCarregamento {

    /**
     * @return the id_oc
     */
    public Integer getId_oc() {
        return id_oc;
    }

    /**
     * @param id_oc the id_oc to set
     */
    public void setId_oc(Integer id_oc) {
        this.id_oc = id_oc;
    }

    /**
     * @return the id_pedido
     */
    public String getId_pedido() {
        return id_pedido;
    }

    /**
     * @param id_pedido the id_pedido to set
     */
    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
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

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

 
    private Integer id_oc;
    private String id_pedido;
    private String  cliente;
    private String  produto;
    private String  endereco;
    private String  status;
    
}
