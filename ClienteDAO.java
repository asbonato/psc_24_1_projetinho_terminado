import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ClienteDAO {
    public boolean salvar(Cliente cliente){
        Connection conn = null;
        try {
            conn = new ConnectionFactory().obtemConexao();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO cliente (nome, email, idade) VALUES (?, ?, ?)");
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setInt(3, cliente.getIdade());
            ps.execute();
            System.out.println("Cliente salvo: " + cliente);
            return true;
        } catch (Exception e){
            //e.printStackTrace();
            System.out.println("Passou no catch");
            return false;
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
    public ArrayList<Cliente> selecionar(){
        Connection conn = null;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            conn = new ConnectionFactory().obtemConexao();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Cliente c = new Cliente();
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setIdade(rs.getInt("idade"));
                clientes.add(c);
            }
            return clientes;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
}
