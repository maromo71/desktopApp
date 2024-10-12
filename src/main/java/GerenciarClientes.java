import view.ClienteView;

public class GerenciarClientes {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ClienteView clienteView = new ClienteView();
            clienteView.setVisible(true);
        });
    }
}
