package view;

import model.Cliente;
import persistence.ClienteDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClienteView extends JFrame {
    private JTextField nomeField;
    private JTextField emailField;
    private DefaultTableModel tableModel;
    private JTable clienteTable;
    private Cliente clienteSelecionado = null;

    public ClienteView() {
        setTitle("Cadastro de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        JButton salvarButton = new JButton("Salvar");
        JButton alterarButton = new JButton("Alterar");
        JButton excluirButton = new JButton("Excluir");

        inputPanel.add(salvarButton);
        inputPanel.add(alterarButton);
        inputPanel.add(excluirButton);

        add(inputPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Email"}, 0);
        clienteTable = new JTable(tableModel);
        add(new JScrollPane(clienteTable), BorderLayout.CENTER);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                Cliente cliente = new Cliente(nome, email);
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.salvar(cliente);
                atualizarTabela();
                limparCampos();
            }
        });

        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clienteSelecionado != null) {
                    clienteSelecionado.setNome(nomeField.getText());
                    clienteSelecionado.setEmail(emailField.getText());
                    ClienteDAO clienteDAO = new ClienteDAO();
                    clienteDAO.atualizar(clienteSelecionado);
                    atualizarTabela();
                    limparCampos();
                    clienteSelecionado = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um cliente para alterar.");
                }
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clienteSelecionado != null) {
                    ClienteDAO clienteDAO = new ClienteDAO();
                    clienteDAO.excluir(clienteSelecionado);
                    atualizarTabela();
                    limparCampos();
                    clienteSelecionado = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir.");
                }
            }
        });

        clienteTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && clienteTable.getSelectedRow() != -1) {
                Long id = (Long) clienteTable.getValueAt(clienteTable.getSelectedRow(), 0);
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteSelecionado = clienteDAO.buscarPorId(id);
                if (clienteSelecionado != null) {
                    nomeField.setText(clienteSelecionado.getNome());
                    emailField.setText(clienteSelecionado.getEmail());
                }
            }
        });

        atualizarTabela();
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> clientes = clienteDAO.listarTodos();
        for (Cliente cliente : clientes) {
            tableModel.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getEmail()});
        }
    }

    private void limparCampos() {
        nomeField.setText("");
        emailField.setText("");
    }
}
