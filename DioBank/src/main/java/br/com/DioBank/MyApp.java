package br.com.DioBank;

import br.com.DioBank.classes.banco.Banco;
import br.com.DioBank.classes.conta.Conta;
import br.com.DioBank.classes.conta.ContaCorrente;
import br.com.DioBank.classes.conta.ContaPoupanca;
import br.com.DioBank.classes.cliente.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyApp extends JFrame {
    //main panel e componentes do header
    private JPanel mainPanel;
    private JLabel companyLabel;
    private JLabel dataLabel;
    private JLabel dataTextLabel;
    private JPanel HeaderPanel;

    //panel para selecionar funçoes do app
    private JPanel btnPanel;
    private JButton criarContaBtn;
    private JButton deletarContaBtn;
    private JButton buscaContabtn;
    private JButton sacarDepositarBtn;
    private JButton trasnferirBtn;

    //panel criação de contas
    private JPanel criaContaPanel;
    private JRadioButton contaCorrenteRadio;
    private JLabel tipoConta;
    private JRadioButton contaPoupancaRadio;
    private JLabel nomeLabel;
    private JTextField nomeTextField;
    private JLabel cpfLabel;
    private JTextField cpfTextField;
    private JButton cancelarCriacaoBtn;
    private JButton confirmaCriacaoBtn;

    //panel deletar contas
    private JPanel deletarContaPanel;
    private JLabel numeroContaDelLabel;
    private JTextField numeroContaDelText;
    private JButton confirmaDelContaBtn;
    private JButton cancelaDelBtn;

    //panel busca conta
    private JPanel buscarContaPanel;
    private JLabel buscaNumeroContaLabel;
    private JTextField buscaNumeroContaText;
    private JButton confirmaBuscaContaBtn;
    private JLabel nomeBuscaLabel;
    private JLabel numeroBuscaLabel;
    private JLabel cpfBuscaLabel;
    private JLabel agenciaBuscaLabel;
    private JLabel saldoBuscaLabel;
    private JLabel nomeBuscaLabelText;
    private JLabel numeroBuscaLabelText;
    private JLabel cpfBuscaLabelText;
    private JLabel agenciaBuscaLabelText;
    private JLabel saldoBuscaLabelText;
    private JButton voltarBuscaBtn;

    //panel saque/deposito
    private JPanel sacarDepositarPanel;
    private JLabel tipoOperacaoLabel;
    private JRadioButton sacarRadioBtn;
    private JRadioButton depositarRadioBtn;
    private JLabel valorSaqueDepositoLabel;
    private JTextField valorSaqueDepositoText;
    private JButton confirmaSaqueDepositoBtn;
    private JButton voltarOperacaoBtn;
    private JTextField numeroSaqueDepositoText;

    //panel transferencia
    private JLabel numeroContaPaganteLabel;
    private JLabel numeroContaDestinoLabel;
    private JLabel valorTransferenciaLabel;
    private JPanel transferenciaPanel;
    private JTextField numeroContaPaganteText;
    private JTextField numeroContaDestinoText;
    private JTextField valorTransferenciaText;
    private JButton confirmaTransferenciaBtn;
    private JButton cancelarTransferenciaBtn;

    public MyApp(){
        this.setTitle("Dio Bank");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        //dio bank para armazenamento de contas
        Banco dioBank = new Banco("Dio Bank");

        ButtonGroup poupancaCorrenteRadioGroup = new ButtonGroup();
        poupancaCorrenteRadioGroup.add(contaCorrenteRadio);
        poupancaCorrenteRadioGroup.add(contaPoupancaRadio);
        criaContaPanel.setVisible(false);

        deletarContaPanel.setVisible(false);
        buscarContaPanel.setVisible(false);
        transferenciaPanel.setVisible(false);

        ButtonGroup sacarDepositarRadioGroup = new ButtonGroup();
        sacarDepositarRadioGroup.add(sacarRadioBtn);
        sacarDepositarRadioGroup.add(depositarRadioBtn);
        sacarDepositarPanel.setVisible(false);

        //timer para atualizar e mostrar a data/hora
        Timer attTime = new Timer(1000, e -> updateDateTime(dataTextLabel));
        attTime.start();

        //criar conta panel listeners
        criarContaBtn.addActionListener(e ->{
            alteraPanel(criaContaPanel, btnPanel);
        });

        cancelarCriacaoBtn.addActionListener(e -> {
            this.limparCriaContaPanel(poupancaCorrenteRadioGroup);
            alteraPanel(btnPanel, criaContaPanel);
        });

        confirmaCriacaoBtn.addActionListener(e-> {
            if(contaCorrenteRadio.isSelected()){
                dioBank.addConta(new ContaCorrente(new Cliente(nomeTextField.getText(),cpfTextField.getText())));
            }
            if(contaPoupancaRadio.isSelected()){
                dioBank.addConta(new ContaPoupanca(new Cliente(nomeTextField.getText(),cpfTextField.getText())));
            }

            limparCriaContaPanel(poupancaCorrenteRadioGroup);
            if (JOptionPane.showConfirmDialog(null, "Deseja criar outra conta?", "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
                alteraPanel(btnPanel, criaContaPanel);
            }
        });

        //deletar conta panel listeners
        deletarContaBtn.addActionListener(e -> {
            alteraPanel(deletarContaPanel, btnPanel);
        });

        cancelaDelBtn.addActionListener(e -> {
            limparDeletarContaPanel();
        });

        confirmaDelContaBtn.addActionListener(e-> {
            dioBank.deletarConta(Integer.parseInt(numeroContaDelText.getText()));
            limparDeletarContaPanel();
        });

        //busca conta panel listeners
        buscaContabtn.addActionListener(e -> {
            alteraPanel(buscarContaPanel, btnPanel);
        });

        confirmaBuscaContaBtn.addActionListener(e -> {
            Conta resultado = dioBank.buscarConta(Integer.parseInt(buscaNumeroContaText.getText()));
            nomeBuscaLabelText.setText(resultado.getCliente().getNome());
            numeroBuscaLabelText.setText(String.valueOf(resultado.getNumero()));
            cpfBuscaLabelText.setText(resultado.getCliente().getCpf());
            agenciaBuscaLabelText.setText(String.valueOf(resultado.getAgencia()));
            saldoBuscaLabelText.setText(String.valueOf(resultado.getSaldo()));
            buscaNumeroContaText.setText("");
        });

        voltarBuscaBtn.addActionListener(e -> {
            alteraPanel(btnPanel,buscarContaPanel);
            nomeBuscaLabelText.setText("");
            numeroBuscaLabelText.setText("");
            cpfBuscaLabelText.setText("");
            agenciaBuscaLabelText.setText("");
            saldoBuscaLabelText.setText("");
            buscaNumeroContaText.setText("");
        });

        //sacar e depositar listeners
        sacarDepositarBtn.addActionListener(e -> {
            alteraPanel(sacarDepositarPanel, btnPanel);
        });

        confirmaSaqueDepositoBtn.addActionListener(e -> {
            Conta resultadoSaqueDeposito = dioBank.buscarConta(Integer.parseInt(numeroSaqueDepositoText.getText()));
            if (sacarRadioBtn.isSelected()){
                resultadoSaqueDeposito.sacar(Double.parseDouble(valorSaqueDepositoText.getText()));
            }
            if (depositarRadioBtn.isSelected()){
                resultadoSaqueDeposito.depositar(Double.parseDouble(valorSaqueDepositoText.getText()));
            }

            JOptionPane.showMessageDialog(null,"Sucesso!\n Nome: " +
                    resultadoSaqueDeposito.getCliente().getNome() +"\nnumero: " +
                    resultadoSaqueDeposito.getNumero() +
                    "\nnovo saldo: R$" + resultadoSaqueDeposito.getSaldo());

            limparSaqueDepositoPanel(sacarDepositarRadioGroup);
        });

        voltarOperacaoBtn.addActionListener(e -> {
            alteraPanel(btnPanel, sacarDepositarPanel);
            limparSaqueDepositoPanel(sacarDepositarRadioGroup);
        });

        //transferencia listeners
        trasnferirBtn.addActionListener(e -> {
            alteraPanel(transferenciaPanel, btnPanel);
        });

        cancelarTransferenciaBtn.addActionListener(e -> {
            alteraPanel(btnPanel, transferenciaPanel);
            limparTransferenciaPanel();
        });

        confirmaTransferenciaBtn.addActionListener(e -> {
            Conta pagante = dioBank.buscarConta(Integer.parseInt(numeroContaPaganteText.getText()));
            Conta destino = dioBank.buscarConta(Integer.parseInt(numeroContaDestinoText.getText()));
            pagante.transferir(Double.parseDouble(valorTransferenciaText.getText()), destino);
            JOptionPane.showMessageDialog(null,"Sucesso!\n Nome: " +
                    pagante.getCliente().getNome() +"\nnumero: " +
                    pagante.getNumero() +
                    "\nnovo saldo: R$" + pagante.getSaldo());
            limparTransferenciaPanel();
        });
    }


    //pega data/hora atual
    public void updateDateTime(JLabel dataTextLabel){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date now = new Date();
        dataTextLabel.setText(dateFormat.format(now));
    }

    public void limparCriaContaPanel(ButtonGroup btg){
        btg.clearSelection();
        nomeTextField.setText("");
        cpfTextField.setText("");
    }

    public void limparDeletarContaPanel(){
        deletarContaPanel.setVisible(false);
        btnPanel.setVisible(true);
        numeroContaDelText.setText("");
    }

    public void limparSaqueDepositoPanel(ButtonGroup btg){
        btg.clearSelection();
        valorSaqueDepositoText.setText("");
        numeroSaqueDepositoText.setText("");
    }

    public void limparTransferenciaPanel(){
        numeroContaDestinoText.setText("");
        numeroContaPaganteText.setText("");
        valorTransferenciaText.setText("");
    }


    public void alteraPanel(JPanel panelOn, JPanel panelOff){
        panelOn.setVisible(true);
        panelOff.setVisible(false);
    }
}
