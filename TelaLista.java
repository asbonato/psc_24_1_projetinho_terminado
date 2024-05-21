import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.ArrayList;

public class TelaLista extends JFrame{
    private JTextArea txtLista;
    private JScrollPane scroll;

    public TelaLista(ArrayList<Cliente> lista){ 
        scroll = new JScrollPane();
        txtLista = new JTextArea(10, 30);
        txtLista.setEditable(false);
        txtLista.setLineWrap(true);
        txtLista.setWrapStyleWord(true);
        scroll.setViewportView(txtLista);
        add(scroll);
        for (Cliente c : lista){
            txtLista.append(c + "\n");
        }
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
