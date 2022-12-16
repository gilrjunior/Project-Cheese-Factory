package fabricaDAO;

import classes.*;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FabricaDAO {
    
    Connection conexao;
    
    public FabricaDAO() throws SQLException, ClassNotFoundException{
        this.conexao = Conexao.getConexao();
    }
    
    public int Conta_clientes(){
        
        PreparedStatement ps;
        String query = "select count(cpf) as conta from cliente";
        ResultSet res;
        int qntd = 0;
        
        try{
            ps = this.conexao.prepareStatement(query);
            res = ps.executeQuery();
            
            if(res.next()){
               qntd = res.getInt("conta"); 
            }            
            
            res.close();
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao inserir no banco: "+e.toString());
        }
        return qntd;
        
    }
    
    public void insertCliente(Cliente cliente){
        PreparedStatement ps;
        String query = "insert into cliente values(?,?,?,?,?,?,?,?)";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getInstagram());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getFacebook());
            ps.setString(8, cliente.getCartao());
            ps.execute();
            ps.close();
            Cliente.num_cliente = Conta_clientes();
            JOptionPane.showMessageDialog(null, "\n Informacao inserida com sucesso.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao inserir no banco: "+e.toString());
        }
    }
    
    public void insertQueijo(Queijo queijo){
        PreparedStatement ps;
        String query = "insert into queijo values(?,?,?,?,?,?)";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, queijo.getId_queijo());
            ps.setString(2, queijo.getLote());
            ps.setString(3, queijo.getTipo());
            ps.setFloat(4, queijo.getValor_venda());
            ps.setFloat(5, queijo.getPeso());
            ps.setString(6,queijo.getData_fabricacao().toString());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "\n Informacao inserida com sucesso.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao inserir no banco: "+e.toString());
        }
    }
    
    public void insertPedido(Pedido pedido, ArrayList<QueijoPedido> listaQpedidos){
        
      PreparedStatement ps;
      String query = "insert into pedido values(?,?,?,?)";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, pedido.getId_pedido());
            ps.setString(2, pedido.getCpf());
            ps.setString(3, pedido.getData().toString());
            ps.setInt(4, pedido.getPrazo_entrega());
            ps.execute();
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao inserir no banco: "+e.toString());
        }
        
        query = "insert into queijo_pedido values(?,?,?,?)";
        
        for(QueijoPedido Qp : listaQpedidos){

            try{
                ps = this.conexao.prepareStatement(query);
                ps.setString(1, Qp.getId_queijo_pedido());
                ps.setString(2, Qp.getId_pedido());
                ps.setString(3, Qp.getId_queijo());
                ps.setInt(4, Qp.getQnt());
                ps.execute();
                ps.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "\n Erro ao inserir no banco: "+e.toString());
            }
            
        }        
        JOptionPane.showMessageDialog(null, "\n Pedido finalizado com sucesso.");
        
    }
    
    public void updateCliente(Cliente cliente){
        PreparedStatement ps;
        String query = "update cliente set cpf=?, nome=?, telefone=?, endereço=?, instagram=?, email=?, facebook=?, cartao=? where cpf= ?";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getInstagram());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getFacebook());
            ps.setString(8, cliente.getCartao());
            ps.setString(9, cliente.getCpf());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "\n Informacao atualizada com sucesso.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao atualizar no banco: "+e.toString());
        }
    }
    
     public void updateQueijo(Queijo queijo){
        PreparedStatement ps;
        String query = "update queijo set id_queijo=?, lote=?, tipo=?, valor_venda=?, peso=? where id_queijo = ?";
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, queijo.getId_queijo());
            ps.setString(2, queijo.getLote());
            ps.setString(3, queijo.getTipo());
            ps.setFloat(4, queijo.getValor_venda());
            ps.setFloat(5, queijo.getPeso());
            ps.setString(6, queijo.getData_fabricacao().toString());
            ps.setString(7, queijo.getId_queijo());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "\n Informacao atualizada com sucesso.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao atualizar no banco: "+e.toString());
        }
    } 
    
    public void excluirCliente(String cpf){

        PreparedStatement ps;
        String query = "delete from cliente where cpf= ?";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, cpf);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "\n Informacao removida com sucesso.");
            Cliente.num_cliente = Conta_clientes();  
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao alterar no banco: "+e.toString());
        }
        
    }
    
    public void excluirQueijo(String id_queijo){

        PreparedStatement ps;
        String query = "delete from queijo where id_queijo= ?";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, id_queijo);
            ps.execute();
            ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao  no banco: "+e.toString());
        }
        
        query = "delete from queijo_pedido where id_queijo= ?";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, id_queijo);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "\n Informacao removida com sucesso.");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao remover no banco: "+e.toString());
        }
        
        
        
    }
    
    public void excluirPedido(String id_pedido){

        PreparedStatement ps;
        String query = "delete from pedido where id_pedido= ?";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, id_pedido);
            ps.execute();
            ps.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao alterar no banco: "+e.toString());
        }
        
        query = "delete from queijo_pedido where id_pedido= ?";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, id_pedido);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "\n Pedido deletado com sucesso.");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao remover no banco: "+e.toString());
        }
        
    }
    
    public void excluirQueijoPedido(String id_pedido, String id_queijo){

        PreparedStatement ps;
        String query = "delete from queijo_pedido where id_pedido=? and id_queijo=?";
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, id_pedido);
            ps.setString(2, id_queijo);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "\n Informacao removida com sucesso.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao alterar no banco: "+e.toString());
        }
                
    }
    
     public ArrayList<Cliente> mostracliente(String busca, int verif){
        
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Cliente> listaclientes = null;
        String query  = "select * from cliente";
        if(verif == 1){
            query  = "select * from cliente where nome=?";
        }else if(verif == 2){
            query  = "select * from cliente where cpf=?";
        }
        
        
        try{
            ps = this.conexao.prepareStatement(query);
            if(verif != 0){
                ps.setString(1, busca);
            } 
            res = ps.executeQuery();
            listaclientes = new ArrayList();
            
            while(res.next())
            {
                Cliente cliente = new Cliente();
                
                cliente.setCpf(res.getString("cpf"));
                cliente.setNome(res.getString("nome"));
                cliente.setTelefone(res.getString("telefone"));
                cliente.setEndereco(res.getString("endereço"));
                cliente.setInstagram(res.getString("instagram"));
                cliente.setEmail(res.getString("email"));
                cliente.setFacebook(res.getString("facebook"));
                cliente.setCartao(res.getString("cartao"));
                
                listaclientes.add(cliente);
            }
            res.close();
            ps.close();
            
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao buscar as informações no banco: "+e.toString());
       }
       return (listaclientes);
        
    }
     
     public ArrayList<Queijo> mostraQueijo(String busca, int verif){
        
        PreparedStatement ps;
        ResultSet res;
        ArrayList<Queijo> listaqueijos = null;
        String query  = "select * from queijo";
        
        if(verif == 1){
            query  = "select * from queijo where lote=?";
        }

        
        try{
            ps = this.conexao.prepareStatement(query);
            if(verif == 1){
                ps.setString(1, busca);
            }
            res = ps.executeQuery();
            listaqueijos = new ArrayList();
            
            while(res.next())
            {
                Queijo queijo = new Queijo();

                queijo.setId_queijo(res.getString("id_queijo"));
                queijo.setLote(res.getString("lote"));
                queijo.setTipo(res.getString("tipo"));
                queijo.setValor_venda(res.getFloat("valor_venda"));
                queijo.setPeso(res.getFloat("peso"));
                queijo.setData_fabricacao((res.getDate("data_fabricacao").toLocalDate()));

                listaqueijos.add(queijo);
            }
            res.close();
            ps.close();
            
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao buscar as informações no banco: "+e.toString());
       }
       return (listaqueijos);
        
    }
     
    public Pedido mostraPedido(String busca){
        
        PreparedStatement ps;
        ResultSet res;
        String query  = "select * from pedido where cpf=? order by data";
        Pedido pedido = null;
        
        try{
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, busca); 
            res = ps.executeQuery();
            
            pedido = new Pedido();
            
            if(res.next()){
                pedido.setId_pedido(res.getString("id_pedido"));
                pedido.setCpf(res.getString("cpf"));
                pedido.setData(res.getDate("data").toLocalDate());
                pedido.setPrazo_entrega(res.getInt("prazo_entrega"));
            }

            
                
            res.close();
            ps.close();
            
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao buscar as informações no banco: "+e.toString());
       }
       return (pedido);
        
    }
    
    public ArrayList<Pedido> mostraTodosPedidos(){
        
        PreparedStatement ps;
        ResultSet res;
        String query  = "select * from pedido";
        Pedido pedido = null;
        ArrayList<Pedido> listapedidos = null;
        
        try{
            ps = this.conexao.prepareStatement(query);
            res = ps.executeQuery();
            
            listapedidos = new ArrayList();
            
            while(res.next()){
                
                pedido = new Pedido();
                
                pedido.setId_pedido(res.getString("id_pedido"));
                pedido.setCpf(res.getString("cpf"));
                pedido.setData(res.getDate("data").toLocalDate());
                pedido.setPrazo_entrega(res.getInt("prazo_entrega"));
                
                listapedidos.add(pedido);

            }
                
            res.close();
            ps.close();
            
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao buscar as informações no banco: "+e.toString());
       }
       return (listapedidos);
        
    }
    
    public ArrayList<QueijoPedido> mostra_ID_queijos_pedido(String busca){
        
        PreparedStatement ps;
        ResultSet res;
        String query  = "select * from queijo_pedido where id_pedido=?";
        QueijoPedido Qpedido = null;
        ArrayList<QueijoPedido> listaQpedidos = null;
        
        try{
            
            ps = this.conexao.prepareStatement(query);
            ps.setString(1, busca); 
            res = ps.executeQuery();
            
            QueijoPedido qpedido = new QueijoPedido();
            listaQpedidos = new ArrayList();
            
            while(res.next())
            {

                qpedido.setId_queijo_pedido(res.getString("id_queijo_pedido"));
                qpedido.setId_pedido(res.getString("id_pedido"));
                qpedido.setId_queijo(res.getString("id_queijo"));
                qpedido.setQnt(res.getInt("quantidade"));
                
                listaQpedidos.add(qpedido);
                
            }
                
            res.close();
            ps.close();
            
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "\n Erro ao buscar as informações no banco: "+e.toString());
       }
       return (listaQpedidos);
        
    }
    
    
     
}

