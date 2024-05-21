import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteTela extends JFrame implements ActionListener{
    private JLabel lblNome, lblEmail, lblIdade;
    private JTextField txtNome, txtEmail, txtIdade;
    private JButton btnSalvar, btnCancelar;
    private JPanel pnlNome, pnlEmailIdade, pnlBotoes;

    public ClienteTela(){
        lblNome = new JLabel("Nome:");
        lblEmail = new JLabel("Email:");
        lblIdade = new JLabel("Idade:");

        txtNome = new JTextField(20);
        txtEmail = new JTextField(10);
        txtIdade = new JTextField(3);

        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        btnSalvar.addActionListener(this);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        
        });

        setLayout(new GridLayout(3, 1));
        pnlNome = new JPanel(new FlowLayout());
        pnlNome.add(lblNome);
        pnlNome.add(txtNome);
        this.add(pnlNome);

        pnlEmailIdade = new JPanel(new FlowLayout());
        pnlEmailIdade.add(lblEmail);
        pnlEmailIdade.add(txtEmail);
        pnlEmailIdade.add(lblIdade);
        pnlEmailIdade.add(txtIdade);
        this.add(pnlEmailIdade);

        pnlBotoes = new JPanel(new FlowLayout());
        pnlBotoes.add(btnSalvar);
        pnlBotoes.add(btnCancelar);
        this.add(pnlBotoes);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Cliente cliente = new Cliente();
        cliente.setNome(this.txtNome.getText());
        cliente.setEmail(this.txtEmail.getText());
        cliente.setIdade(Integer.parseInt(this.txtIdade.getText()));
        ClienteDAO dao = new ClienteDAO(); 
        if (dao.salvar(cliente)){
            JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
            txtNome.setText("");
            txtEmail.setText("");
            txtIdade.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao salvar cliente!", "", JOptionPane.ERROR_MESSAGE);
        }
    }
}
