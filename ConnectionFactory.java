import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private String usuario = "alunos";
    private String senha = "alunos";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "cad_clientes";

    public Connection obtemConexao(){
        Connection c = null;
        String url = "jdbc:mysql://" + host + ":" + porta + "/" + bd;
        try{
            c = DriverManager.getConnection(url, usuario, senha);
        } catch(Exception e){
            e.printStackTrace();
        }
        return c;
    }
}