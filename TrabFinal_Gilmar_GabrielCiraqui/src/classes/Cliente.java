package classes;

public class Cliente {
    
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String instagram;
    private String email;
    private String facebook;
    private String cartao;
    public static int num_cliente;

    public Cliente(String cpf, String nome, String telefone, String endereco, String instagram, String email, String facebook, String cartao) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.instagram = instagram;
        this.email = email;
        this.facebook = facebook;
        this.cartao = cartao;
    }
    
    public Cliente() {
        this.cpf = "";
        this.nome = "";
        this.telefone = "";
        this.endereco = "";
        this.instagram = "";
        this.email = "";
        this.facebook = "";
        this.cartao = "";
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", instagram=" + instagram + ", email=" + email + ", facebook=" + facebook + ", cartao=" + cartao + '}';
    }
   
}
