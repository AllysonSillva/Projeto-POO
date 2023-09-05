package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;

import com.sun.org.apache.xpath.internal.jaxp.XPathImpl;

import sun.security.x509.X500Signer;
import model.Aluno;
import control.AlunoDAO;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import java.awt.Color;

public class AlunoView extends JFrame {
	
	AlunoDAO aluno = new AlunoDAO();

	private JPanel contentPane;
	private JTextField txfNome;
	private JTextField txfIdade;
	private JTextField txfCurso;
	private JTextField txfCidade;
	private JTextField txfEndereco;
	private JTextField txfTelefone;
	private JButton btnCadastrar;
	private JButton btnDeletar;
	private JButton btnAtualizar;
	private JButton btnConsultar;
	private JButton btnImprimir;
	private JButton btnSalvar;
	private JButton btnLimpar;
	private JButton btnOk;
	private JButton btnOkConsultar;
	private JTextField txfConsultar;
	private JLabel lblResultMatricula;
	private JLabel lblMatricula;
	private JPanel panelCadastrar;
	private JTextArea txaLista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoView frame = new AlunoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlunoView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 150, 660, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelCadastrar = new JPanel();
		panelCadastrar.setBorder(new TitledBorder(null, "Cadastro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCadastrar.setBounds(10, 11, 420, 281);
		contentPane.add(panelCadastrar);
		panelCadastrar.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 34, 64, 14);
		panelCadastrar.add(lblNome);
		
		txfNome = new JTextField();
		txfNome.setBorder(null);
		txfNome.setEnabled(false);
		txfNome.setBounds(84, 31, 315, 20);
		panelCadastrar.add(txfNome);
		txfNome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 65, 64, 14);
		panelCadastrar.add(lblIdade);
		
		txfIdade = new JTextField();
		txfIdade.setBorder(null);
		txfIdade.setEnabled(false);
		txfIdade.setBounds(84, 62, 315, 20);
		panelCadastrar.add(txfIdade);
		txfIdade.setColumns(10);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(10, 96, 64, 14);
		panelCadastrar.add(lblCurso);
		
		txfCurso = new JTextField();
		txfCurso.setBorder(null);
		txfCurso.setEnabled(false);
		txfCurso.setBounds(84, 93, 315, 20);
		panelCadastrar.add(txfCurso);
		txfCurso.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 127, 64, 14);
		panelCadastrar.add(lblCidade);
		
		txfCidade = new JTextField();
		txfCidade.setBorder(null);
		txfCidade.setEnabled(false);
		txfCidade.setBounds(84, 124, 315, 20);
		panelCadastrar.add(txfCidade);
		txfCidade.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(10, 158, 64, 14);
		panelCadastrar.add(lblEndereco);
		
		txfEndereco = new JTextField();
		txfEndereco.setBorder(null);
		txfEndereco.setEnabled(false);
		txfEndereco.setBounds(84, 155, 315, 20);
		panelCadastrar.add(txfEndereco);
		txfEndereco.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 189, 64, 14);
		panelCadastrar.add(lblTelefone);
		
		txfTelefone = new JTextField();
		txfTelefone.setBorder(null);
		txfTelefone.setEnabled(false);
		txfTelefone.setBounds(84, 186, 315, 20);
		panelCadastrar.add(txfTelefone);
		txfTelefone.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.setEnabled(false);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nome = txfNome.getText();
				int idade = Integer.parseInt(txfIdade.getText());
				String curso = txfCurso.getText();
				String cidade = txfCidade.getText();
				String endereco = txfEndereco.getText();
				String telefone = txfTelefone.getText();
				
				Aluno a = new Aluno(nome, idade, curso, cidade, endereco, telefone);
				aluno.adicionar(a);
				
				JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
				
				btnConsultar.setEnabled(true);
				
				aluno.close();
			}
		});
		btnOk.setBounds(309, 217, 89, 23);
		panelCadastrar.add(btnOk);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setVisible(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Long matricula = Long.parseLong(lblResultMatricula.getText());
				String nome = txfNome.getText();
				int idade = Integer.parseInt(txfIdade.getText());
				String curso = txfCurso.getText();
				String cidade = txfCidade.getText();
				String endereco = txfEndereco.getText();
				String telefone = txfTelefone.getText();
				
				Aluno a = new Aluno(matricula, nome, idade, curso, cidade, endereco, telefone);
				
				aluno.atualizar(a);
				
				btnConsultar.setEnabled(true);
				btnSalvar.setVisible(false);
				
				txfEditableFalse();
				txfEnabledTrue();
				btnDeletar.setEnabled(true);
				
				JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!");
				
				aluno.close();
				
			}
		});
		btnSalvar.setBounds(84, 217, 89, 23);
		panelCadastrar.add(btnSalvar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setEnabled(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limpar();
		
			}
		});
		btnLimpar.setBounds(196, 217, 89, 23);
		panelCadastrar.add(btnLimpar);
		
		lblMatricula = new JLabel("Matricula:");
		lblMatricula.setVisible(false);
		lblMatricula.setBounds(10, 251, 64, 14);
		panelCadastrar.add(lblMatricula);
		
		lblResultMatricula = new JLabel("");
		lblResultMatricula.setBounds(84, 251, 126, 14);
		panelCadastrar.add(lblResultMatricula);
		
		JPanel panelOpcoes = new JPanel();
		panelOpcoes.setBorder(new TitledBorder(null, "Opções", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOpcoes.setBounds(440, 11, 191, 236);
		contentPane.add(panelOpcoes);
		panelOpcoes.setLayout(null);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panelCadastrar.setBorder(new TitledBorder(null, "Cadastro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				
				txaLista.setText("");
				
				txfEditableTrue();
				
				txfEnabledTrue();
				
				btnLimpar.setEnabled(true);
				btnOk.setEnabled(true);
				btnLimpar.setVisible(true);
				btnOk.setVisible(true);
				btnSalvar.setVisible(false);
				btnDeletar.setEnabled(false);
				btnAtualizar.setEnabled(false);
				btnOkConsultar.setEnabled(false);
				txfConsultar.setEnabled(false);
				btnConsultar.setEnabled(true);
				btnImprimir.setEnabled(true);
				lblMatricula.setVisible(false);
				lblResultMatricula.setVisible(false);
				limpar();
				
			}
		});
		btnCadastrar.setBounds(47, 23, 100, 23);
		panelOpcoes.add(btnCadastrar);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				long matricula = Long.parseLong(lblResultMatricula.getText());
				Aluno a = aluno.consultar(matricula);
				
				aluno.deletar(a);
				limpar();
				lblResultMatricula.setText("");
				btnDeletar.setEnabled(false);
				btnAtualizar.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Aluno não cadastrado!");
				
				aluno.close();
				
			}
		});
		btnDeletar.setEnabled(false);
		btnDeletar.setBounds(47, 57, 100, 23);
		panelOpcoes.add(btnDeletar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txfEditableTrue();
				btnSalvar.setVisible(true);
				btnLimpar.setEnabled(true);
				btnDeletar.setEnabled(false);
				txfConsultar.setEnabled(false);
				btnOkConsultar.setEnabled(false);
				btnImprimir.setEnabled(false);
				
			}
		});
		btnAtualizar.setEnabled(false);
		btnAtualizar.setBounds(47, 91, 100, 23);
		panelOpcoes.add(btnAtualizar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txaLista.setText("");
				
				txfEnabledFalse();
				
				txfConsultar.setEnabled(true);
				btnOkConsultar.setEnabled(true);
				btnLimpar.setEnabled(false);
				btnOk.setEnabled(false);
				
			}
		});
		
		if (aluno.listar().isEmpty()) {
			btnConsultar.setEnabled(false);
		} else {
			btnConsultar.setEnabled(true);
		}
		btnConsultar.setBounds(47, 125, 100, 23);
		panelOpcoes.add(btnConsultar);
		
		btnImprimir = new JButton("Imprimir");
		if (aluno.listar().isEmpty()) {
			btnImprimir.setEnabled(false);
		} else {
			btnImprimir.setEnabled(true);
		}
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txaLista.setText("");
				
				List<Aluno> listaAlunos = aluno.listar();
				for (int i = 0; i < listaAlunos.size(); i++) {
					txaLista.append(listaAlunos.get(i).getNome());
				}
			}
		});
		btnImprimir.setBounds(47, 159, 100, 23);
		panelOpcoes.add(btnImprimir);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int msg = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "", JOptionPane.YES_NO_OPTION);
				if (msg == 0){
					System.exit(0);
				}
			}
		});
		btnSair.setBounds(47, 193, 100, 23);
		panelOpcoes.add(btnSair);
		
		JPanel panelConsultar = new JPanel();
		panelConsultar.setBorder(new TitledBorder(null, "Consultar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelConsultar.setBounds(10, 295, 420, 66);
		contentPane.add(panelConsultar);
		panelConsultar.setLayout(null);
		
		JLabel lblMatriculaConsultar = new JLabel("Matricula:");
		lblMatriculaConsultar.setBounds(10, 26, 63, 14);
		panelConsultar.add(lblMatriculaConsultar);
		
		txfConsultar = new JTextField();
		txfConsultar.setBorder(null);
		txfConsultar.setEnabled(false);
		txfConsultar.setBounds(83, 23, 169, 20);
		panelConsultar.add(txfConsultar);
		txfConsultar.setColumns(10);
		
		btnOkConsultar = new JButton("OK");
		btnOkConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				long matricula = Long.parseLong(txfConsultar.getText());
				
				Aluno a = aluno.consultar(matricula);
				
				if (a.equals(null)) {
					JOptionPane.showMessageDialog(null, "Aluno não Cadastrado!");
				} else {
				
				txfNome.setText(a.getNome());
				txfIdade.setText(String.valueOf(a.getIdade()));
				txfCurso.setText(a.getCurso());
				txfCidade.setText(a.getCidade());
				txfEndereco.setText(a.getEndereco());
				txfTelefone.setText(a.getTelefone());
				lblResultMatricula.setText(String.valueOf(matricula));
				lblMatricula.setVisible(true);
				lblResultMatricula.setVisible(true);
				
				txfEditableFalse();
				txfEnabledTrue();
				
				btnOk.setVisible(false);
				btnLimpar.setVisible(false);
				btnAtualizar.setEnabled(true);
				btnDeletar.setEnabled(true);
				btnSalvar.setVisible(false);
				btnConsultar.setEnabled(false);
				
				panelCadastrar.setBorder(new TitledBorder(null, "Dados do Aluno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				
				}
			}
		});
		btnOkConsultar.setEnabled(false);
		btnOkConsultar.setBounds(292, 22, 89, 23);
		panelConsultar.add(btnOkConsultar);
		
		JPanel panelmprimir = new JPanel();
		panelmprimir.setBounds(440, 273, 191, 88);
		contentPane.add(panelmprimir);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelmprimir = new GroupLayout(panelmprimir);
		gl_panelmprimir.setHorizontalGroup(
			gl_panelmprimir.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
		);
		gl_panelmprimir.setVerticalGroup(
			gl_panelmprimir.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
		);
		
		txaLista = new JTextArea();
		scrollPane.setViewportView(txaLista);
		panelmprimir.setLayout(gl_panelmprimir);
		
		JLabel lblAlunosCadastrados = new JLabel("Alunos Cadastrados");
		lblAlunosCadastrados.setBounds(480, 256, 122, 14);
		contentPane.add(lblAlunosCadastrados);
		
	}
	
	public void txfEditableFalse() {
		
		txfNome.setEditable(false);
		txfIdade.setEditable(false);
		txfCurso.setEditable(false);
		txfCidade.setEditable(false);
		txfEndereco.setEditable(false);
		txfTelefone.setEditable(false);
	}
	
	public void txfEditableTrue() {
		
		txfNome.setEditable(true);
		txfIdade.setEditable(true);
		txfCurso.setEditable(true);
		txfCidade.setEditable(true);
		txfEndereco.setEditable(true);
		txfTelefone.setEditable(true);
		
	}
	
	public void txfEnabledTrue() {
		
		txfNome.setEnabled(true);
		txfIdade.setEnabled(true);
		txfCurso.setEnabled(true);
		txfCidade.setEnabled(true);
		txfEndereco.setEnabled(true);
		txfTelefone.setEnabled(true);
		
	}
	
	public void limpar() {
		
		txfNome.setText("");
		txfIdade.setText("");
		txfCurso.setText("");
		txfCidade.setText("");
		txfEndereco.setText("");
		txfTelefone.setText("");
	}
	
	public void txfEnabledFalse() {
		
		txfNome.setEnabled(false);
		txfIdade.setEnabled(false);
		txfCurso.setEnabled(false);
		txfCidade.setEnabled(false);
		txfEndereco.setEnabled(false);
		txfTelefone.setEnabled(false);
	}
}
