import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.ArrayList;

public class CadastroTela extends JFrame implements ActionListener{
    private JButton btnCriar, btnListar, btnExcluir, btnAtualizar, btnSair;

    public CadastroTela() {
        btnCriar = new JButton("Criar...");
        btnListar = new JButton("Listar...");
        btnExcluir = new JButton("Excluir...");
        btnAtualizar = new JButton("Atualizar...");
        btnSair = new JButton("Sair");

        setLayout(new GridLayout(5,1));
        add(btnCriar);
        add(btnListar);
        add(btnExcluir);
        add(btnAtualizar);
        add(btnSair);

        btnCriar.addActionListener(this);
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteDAO dao = new ClienteDAO();
                ArrayList<Cliente> lista = dao.selecionar();
                TelaLista tela = new TelaLista(lista);
                tela.setLocationRelativeTo(null);
            }
        });

        btnExcluir.setEnabled(false);
        btnAtualizar.setEnabled(false);

        setSize(150, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClienteTela tela = new ClienteTela();
        tela.setLocationRelativeTo(this);
    }
}
