package dal;
import java.sql.*;
import javax.swing.JOptionPane;

public class Mod_conexao {
    public static Connection conexao(){
    //Abre uma classe com um método chamado 'conector'
    //O método é de objeto 'Connection' obtido no pacote java.sql
    //Este tipo de objeto é responsável por fazer a conexão com o banco SQL
    
        java.sql.Connection conexao = null;
        //armazena a conexão com o banco
        
        String driver = "com.mysql.cj.jdbc.Driver";
        //String que contém o nome da classe driver JDBC
        //(API de conexão do Java)
        
        String url = "jdbc:mysql://localhost:3307/agenda";
        //URL de conexão: 
        //localhost - endereço, 3306 - porta, bd_agenda - nome do banco de dados
        
        String user ="root";
        //nome do usuário padrão
        
        String password = "";
        //senha de usuário     
        
        //código da internet tentando resolver bug possível de driver:
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
            
        }catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        //
        
        try{
        //tentativa de conexão
            
            conexao = DriverManager.getConnection(url,user,password);
            //DriverManager - Gerenciador de "drives" do JDBC, 
            //getConnection - Requisição de conexão para o banco, 
            //variáveis - Parâmetros de conexão estabelecidas pelo SQL
            return conexao;
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
}
