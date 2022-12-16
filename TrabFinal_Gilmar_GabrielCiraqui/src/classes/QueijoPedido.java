package classes;

public class QueijoPedido {
    
    private String id_queijo_pedido;
    private String id_pedido;
    private String id_queijo;
    private int qnt;

    public QueijoPedido(String id_queijo_pedido, String id_pedido, String id_queijo, int qnt) {
        this.id_queijo_pedido = id_queijo_pedido;
        this.id_pedido = id_pedido;
        this.id_queijo = id_queijo;
        this.qnt = qnt;
    }
    
    public QueijoPedido() {
        this.id_queijo_pedido = "";
        this.id_pedido = "";
        this.id_queijo = "";
        this.qnt = 0;
    }

    public String getId_queijo_pedido() {
        return id_queijo_pedido;
    }

    public void setId_queijo_pedido(String id_queijo_pedido) {
        this.id_queijo_pedido = id_queijo_pedido;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getId_queijo() {
        return id_queijo;
    }

    public void setId_queijo(String id_queijo) {
        this.id_queijo = id_queijo;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    @Override
    public String toString() {
        return "QueijoPedido{" + "id_queijo_pedido=" + id_queijo_pedido + ", id_pedido=" + id_pedido + ", id_queijo=" + id_queijo + ", qnt=" + qnt + '}';
    }
}
