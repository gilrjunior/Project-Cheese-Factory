/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdf;

import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import fabricaDAO.FabricaDAO;
import classes.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDF {
    
    public static void Gera_pdf(int opc, String busca, int verif){
        
      Document documento = new Document();
      
      FabricaDAO fabricadao = null;
      
        try {
            fabricadao = new FabricaDAO();
        } catch (SQLException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      switch(opc){
          
          case 1: //puxar todos os clientes e gerar o pdf
              
                //chamar a função de busca dos clientes
                ArrayList <Cliente> listaC = fabricadao.mostracliente(busca, verif);
              
                PdfPTable pdft_tabela = new PdfPTable(8);
                Paragraph par_paragrafo01 = new Paragraph("Relatório da busca de cliente");
                
                pdft_tabela.addCell("Cpf");
                pdft_tabela.addCell("Nome");
                pdft_tabela.addCell("Telefone");
                pdft_tabela.addCell("Endereço");
                pdft_tabela.addCell("Instagram");
                pdft_tabela.addCell("E-mail");
                pdft_tabela.addCell("Facebook");
                pdft_tabela.addCell("Cartão de Crédito");
                
                for(Cliente cliente: listaC){
                    pdft_tabela.addCell(cliente.getCpf());
                    pdft_tabela.addCell(cliente.getNome());
                    pdft_tabela.addCell(cliente.getTelefone());
                    pdft_tabela.addCell(cliente.getEndereco());
                    pdft_tabela.addCell(cliente.getInstagram());
                    pdft_tabela.addCell(cliente.getEmail());
                    pdft_tabela.addCell(cliente.getFacebook());
                    pdft_tabela.addCell(cliente.getCartao());
                }

                
            try {
              PdfWriter.getInstance(documento, new FileOutputStream("Relatorio_Busca_Clientes.pdf"));
              documento.open();
              documento.add(par_paragrafo01);
              documento.add(new Paragraph(" "));
              documento.add(pdft_tabela);
              System.out.print("\n PDF criado com sucesso.");
              JOptionPane.showMessageDialog(null, "PDF criado com sucesso.");
            } catch (DocumentException | FileNotFoundException ex  ) {
              System.out.print("\n Erro: "+ex.toString());
            }
            documento.close();
          
          break;
          
          case 2: //puxar todos os queijos e gerar o pdf
              
                ArrayList <Queijo> listaQ = fabricadao.mostraQueijo(busca, verif);
                             
                pdft_tabela = new PdfPTable(6);
                par_paragrafo01 = new Paragraph("Relatório da busca de Queijos");
                
                pdft_tabela.addCell("Id Queijo");
                pdft_tabela.addCell("Lote");
                pdft_tabela.addCell("Tipo");
                pdft_tabela.addCell("Valor de Venda");
                pdft_tabela.addCell("Peso");
                pdft_tabela.addCell("Data de Fabricação");
                for(Queijo queijo : listaQ){
                    pdft_tabela.addCell(queijo.getId_queijo());
                    pdft_tabela.addCell(queijo.getLote());
                    pdft_tabela.addCell(queijo.getTipo());
                    pdft_tabela.addCell(Float.toString(queijo.getValor_venda()));
                    pdft_tabela.addCell(Float.toString(queijo.getPeso()));
                    pdft_tabela.addCell(queijo.getData_fabricacao().toString());
                }                                   
                
            try {
              PdfWriter.getInstance(documento, new FileOutputStream("Relatorio_Busca_Queijos.pdf"));
              documento.open();
              documento.add(par_paragrafo01);
              documento.add(new Paragraph(" "));
              documento.add(pdft_tabela);
              System.out.print("\n PDF criado com sucesso.");
              JOptionPane.showMessageDialog(null, "PDF criado com sucesso.");
            } catch (DocumentException | FileNotFoundException ex  ) {
              System.out.print("\n Erro: "+ex.toString());
            }
            documento.close();
              
          break;
          
          case 3: //puxar um pedido específico e suas informações
            
            
            Pedido pedido = fabricadao.mostraPedido(busca);
            
            pdft_tabela = new PdfPTable(4);
            par_paragrafo01 = new Paragraph("Relatório da busca de Pedido");
            
            
            pdft_tabela.addCell("Id Pedido");
            pdft_tabela.addCell("Cpf cliente");
            pdft_tabela.addCell("Data");
            pdft_tabela.addCell("Prazo entrega");
            pdft_tabela.addCell(pedido.getId_pedido());                  
            pdft_tabela.addCell(pedido.getCpf());                  
            pdft_tabela.addCell(pedido.getData().toString());                  
            pdft_tabela.addCell(Integer.toString(pedido.getPrazo_entrega()));                  
                
            ArrayList<QueijoPedido> listaQp = fabricadao.mostra_ID_queijos_pedido(pedido.getId_pedido());
            
            PdfPTable pdft_tabela2 = new PdfPTable(2);
            
                
            pdft_tabela2.addCell("ID queijo");
            pdft_tabela2.addCell("Quantidade");
                
            for(QueijoPedido Qp: listaQp){

                       pdft_tabela2.addCell(Qp.getId_queijo());
                       pdft_tabela2.addCell(Integer.toString(Qp.getQnt()));

            }

                
                
            try {
              PdfWriter.getInstance(documento, new FileOutputStream("Relatorio_Busca_Pedido.pdf"));
              documento.open();
              documento.add(par_paragrafo01);
              documento.add(new Paragraph(" "));
              documento.add(pdft_tabela);
              documento.add(new Paragraph(" "));
              documento.add(new Paragraph("Queijos pertencentes ao pedido"));
              documento.add(new Paragraph(" "));
              documento.add(pdft_tabela2);
              System.out.print("\n PDF criado com sucesso.");
              JOptionPane.showMessageDialog(null, "PDF criado com sucesso.");
            } catch (DocumentException | FileNotFoundException ex  ) {
              System.out.print("\n Erro: "+ex.toString());
            }
            documento.close();
            
            break;
            
          case 4:
              
            ArrayList <Pedido> listapedidos = fabricadao.mostraTodosPedidos();
            
            pdft_tabela = new PdfPTable(4);
            par_paragrafo01 = new Paragraph("Relatório da busca de todos os Pedidos");
            
            
            pdft_tabela.addCell("Id Pedido");
            pdft_tabela.addCell("Cpf cliente");
            pdft_tabela.addCell("Data");
            pdft_tabela.addCell("Prazo entrega");
            
            for(Pedido pedidos : listapedidos){
                pdft_tabela.addCell(pedidos.getId_pedido());                  
                pdft_tabela.addCell(pedidos.getCpf());                  
                pdft_tabela.addCell(pedidos.getData().toString());                  
                pdft_tabela.addCell(Integer.toString(pedidos.getPrazo_entrega()));
            }

                
            try {
              PdfWriter.getInstance(documento, new FileOutputStream("Relatorio_Busca_Todos_Pedidos.pdf"));
              documento.open();
              documento.add(par_paragrafo01);
              documento.add(new Paragraph(" "));
              documento.add(pdft_tabela);
              System.out.print("\n PDF criado com sucesso.");
              JOptionPane.showMessageDialog(null, "PDF criado com sucesso.");
            } catch (DocumentException | FileNotFoundException ex  ) {
              System.out.print("\n Erro: "+ex.toString());
            }
            documento.close();
               
          
            break;
          
          
                    
      }      
            
            
            
            
    }
    
}
