import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingApp {
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Banking System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setLayout(new BorderLayout());

            JTabbedPane tabbedPane = new JTabbedPane();

            tabbedPane.addTab("Create Account", createCreateAccountPanel());
            tabbedPane.addTab("Deposit/Withdraw", createTransactionPanel());
            tabbedPane.addTab("Transfer Funds", createTransferPanel());
            tabbedPane.addTab("View Statements", createStatementPanel());

            frame.add(tabbedPane, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }

    private static JPanel createCreateAccountPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        JLabel lblAccountNumber = new JLabel("Account Number:");
        JTextField txtAccountNumber = new JTextField();
        JLabel lblAccountHolder = new JLabel("Account Holder:");
        JTextField txtAccountHolder = new JTextField();
        JLabel lblInitialBalance = new JLabel("Initial Balance:");
        JTextField txtInitialBalance = new JTextField();
        JLabel lblPassword = new JLabel("Password:");
        JPasswordField txtPassword = new JPasswordField();
        JButton btnCreate = new JButton("Create Account");

        btnCreate.addActionListener(e -> {
            String accountNumber = txtAccountNumber.getText();
            String accountHolder = txtAccountHolder.getText();
            double initialBalance = Double.parseDouble(txtInitialBalance.getText());
            String password = new String(txtPassword.getPassword());
            bank.createAccount(accountNumber, accountHolder, initialBalance, password);
            JOptionPane.showMessageDialog(panel, "Account created successfully.");
        });

        panel.add(lblAccountNumber);
        panel.add(txtAccountNumber);
        panel.add(lblAccountHolder);
        panel.add(txtAccountHolder);
        panel.add(lblInitialBalance);
        panel.add(txtInitialBalance);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(new JLabel());
        panel.add(btnCreate);

        return panel;
    }

    private static JPanel createTransactionPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        JLabel lblAccountNumber = new JLabel("Account Number:");
        JTextField txtAccountNumber = new JTextField();
        JLabel lblAmount = new JLabel("Amount:");
        JTextField txtAmount = new JTextField();
        JButton btnDeposit = new JButton("Deposit");
        JButton btnWithdraw = new JButton("Withdraw");

        btnDeposit.addActionListener(e -> {
            String accountNumber = txtAccountNumber.getText();
            double amount = Double.parseDouble(txtAmount.getText());
            BankAccount account = bank.findAccount(accountNumber);
            if (account != null) {
                account.deposit(amount);
                JOptionPane.showMessageDialog(panel, "Deposit successful. New Balance: " + account.getBalance());
            } else {
                JOptionPane.showMessageDialog(panel, "Account not found.");
            }
        });

        btnWithdraw.addActionListener(e -> {
            String accountNumber = txtAccountNumber.getText();
            double amount = Double.parseDouble(txtAmount.getText());
            BankAccount account = bank.findAccount(accountNumber);
            if (account != null) {
                account.withdraw(amount);
                JOptionPane.showMessageDialog(panel, "Withdrawal successful. New Balance: " + account.getBalance());
            } else {
                JOptionPane.showMessageDialog(panel, "Account not found.");
            }
        });

        panel.add(lblAccountNumber);
        panel.add(txtAccountNumber);
        panel.add(lblAmount);
        panel.add(txtAmount);
        panel.add(btnDeposit);
        panel.add(btnWithdraw);

        return panel;
    }

    private static JPanel createTransferPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        JLabel lblFromAccount = new JLabel("From Account:");
        JTextField txtFromAccount = new JTextField();
        JLabel lblToAccount = new JLabel("To Account:");
        JTextField txtToAccount = new JTextField();
        JLabel lblAmount = new JLabel("Amount:");
        JTextField txtAmount = new JTextField();
        JButton btnTransfer = new JButton("Transfer");

        btnTransfer.addActionListener(e -> {
            String fromAccount = txtFromAccount.getText();
            String toAccount = txtToAccount.getText();
            double amount = Double.parseDouble(txtAmount.getText());
            bank.transferFunds(fromAccount, toAccount, amount);
            JOptionPane.showMessageDialog(panel, "Transfer completed.");
        });

        panel.add(lblFromAccount);
        panel.add(txtFromAccount);
        panel.add(lblToAccount);
        panel.add(txtToAccount);
        panel.add(lblAmount);
        panel.add(txtAmount);
        panel.add(new JLabel());
        panel.add(btnTransfer);

        return panel;
    }

    private static JPanel createStatementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea txtArea = new JTextArea(10, 40);
        txtArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnViewStatements = new JButton("View Statements");
        btnViewStatements.addActionListener(e -> {
            String accountNumber = JOptionPane.showInputDialog("Enter Account Number:");
            BankAccount account = bank.findAccount(accountNumber);
            if (account != null) {
                StringBuilder sb = new StringBuilder();
                for (Transaction transaction : account.getTransactionHistory()) {
                    sb.append(transaction).append("\n");
                }
                txtArea.setText(sb.toString());
            } else {
                JOptionPane.showMessageDialog(panel, "Account not found.");
            }
        });

        panel.add(btnViewStatements, BorderLayout.SOUTH);

        return panel;
    }
}
