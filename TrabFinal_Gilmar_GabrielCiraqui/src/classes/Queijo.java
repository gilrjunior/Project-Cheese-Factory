package classes;

import java.time.LocalDate;

public class Queijo {
    
    private String id_queijo;
    private String lote;
    private String tipo;
    private float valor_venda;
    private float peso;
    private LocalDate data_fabricacao;

    public Queijo(String id_queijo, String lote, String tipo, float valor_venda, float peso, LocalDate data_fabricacao) {
        this.id_queijo = id_queijo;
        this.lote = lote;
        this.tipo = tipo;
        this.valor_venda = valor_venda;
        this.peso = peso;
        this.data_fabricacao = data_fabricacao;
    }
    
    public Queijo() {
        this.id_queijo = "";
        this.lote = "";
        this.tipo = "";
        this.valor_venda = 0;
        this.peso = 0;
        this.data_fabricacao = data_fabricacao;
    }

    public String getId_queijo() {
        return id_queijo;
    }

    public void setId_queijo(String id_queijo) {
        this.id_queijo = id_queijo;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(float valor_venda) {
        this.valor_venda = valor_venda;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public LocalDate getData_fabricacao() {
        return data_fabricacao;
    }

    public void setData_fabricacao(LocalDate data_fabricacao) {
        this.data_fabricacao = data_fabricacao;
    }

    @Override
    public String toString() {
        return "Queijo{" + "id_queijo=" + id_queijo + ", lote=" + lote + ", tipo=" + tipo + ", valor_venda=" + valor_venda + ", peso=" + peso + ", data_fabricacao=" + data_fabricacao + '}';
    }
    
    
}
