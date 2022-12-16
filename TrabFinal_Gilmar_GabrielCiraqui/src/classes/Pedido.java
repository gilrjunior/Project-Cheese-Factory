package classes;

import java.time.LocalDate;

public class Pedido {

    private String id_pedido;
    private String cpf;
    private LocalDate data;
    private int prazo_entrega;

    public Pedido(String id_pedido, String cpf, LocalDate data, int prazo_entrega) {
        this.id_pedido = id_pedido;
        this.cpf = cpf;
        this.data = data;
        this.prazo_entrega = prazo_entrega;
    }
    
    public Pedido() {
        this.id_pedido = "";
        this.cpf = "";
        this.data = data;
        this.prazo_entrega = 0;
    }

    public String getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(String id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getPrazo_entrega() {
        return prazo_entrega;
    }

    public void setPrazo_entrega(int prazo_entrega) {
        this.prazo_entrega = prazo_entrega;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", cpf=" + cpf + ", data=" + data + ", prazo_entrega=" + prazo_entrega + '}';
    }
}
