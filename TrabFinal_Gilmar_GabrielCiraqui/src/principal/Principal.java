package principal;

import classes.*;
import fabricaDAO.*;
import java.sql.SQLException;
import tela.Tela;

public class Principal {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        FabricaDAO fabrica = new FabricaDAO();
        Cliente.num_cliente = fabrica.Conta_clientes();
        Tela tela = new Tela();
        tela.setVisible(true);
        
    }
    
}
