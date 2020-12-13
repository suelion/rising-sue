package org.notepad;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



@SuppressWarnings("serial")
class Notepad extends JFrame {

	// ���� 1
	private static final long serialVersionUID = 1L;
	
	// �޴� ������ ��� ���� (�迭 �ε��� ��� ����� ��� - ������)
	static final int NEW_FILE = 0;  
	static final int OPEN = 1;
	static final int SAVE = 2;
	static final int EXIT = 3;
	
	// �⺻ ���ϸ�
	static final String DEFAULT_FILE_NAME = "untitled";
	
	// �޴��� 
	private JMenuBar menuBar;
	
	// �ؽ�Ʈ �Է�â
	private JTextArea textArea;
	
	// ��ũ�ѹ� (��ũ�� �г�)
	private JScrollPane scrollPane;
	
	// �ϴ� label 
	private JLabel label;
	
	// ���� ���� ��ü
	private JFileChooser fileChooser = new JFileChooser();

	// ���ϸ� ���� (JFrame Ÿ��Ʋ ����)
	private void updateFilename(String newName) {
		this.setTitle(newName + " - Notepad");
	}
	
	// �޴��� �ʱ�ȭ
	private void initMenuBar() {
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		
		// �޴� ������ �迭ȭ
		JMenuItem[] menuItems = { 
				new JMenuItem("New File"), 
				new JMenuItem("Open"), 
				new JMenuItem("Save"),
				new JMenuItem("Exit"), };
		
		// MenuItem�� Menu�� ���
		for (JMenuItem item : menuItems) {
			menu.add(item);
		}
		
		// Menu�� MenuBar�� ���
		menuBar.add(menu);

		
		/*
		 * ActionListener : Ŭ���Ǿ��� �� �߻��ϴ� �̺�Ʈ�� ��ٸ���(listen) ��ü 
		 *  �� �޴� �����ۿ��� ActionListener�� �͸� ��ü�� ���� �־��ش�. 
		 */
		
		// NewFile �޴� ���� �� 
		menuItems[NEW_FILE].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText(""); // TextArea�� ������ ���ڿ��� ��ü 
				updateFilename(DEFAULT_FILE_NAME); // �����̸�(=������ Ÿ��Ʋ) �� ���� 
			}
		});

		// Open �޴� ���� �� 
		menuItems[OPEN].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���Ͽ��� ���̾�α� �� ���
				int result = fileChooser.showOpenDialog(Notepad.this);
				if (result == JFileChooser.APPROVE_OPTION) { // ������ ������ ��� ��ȯ
					File selectedFile = fileChooser.getSelectedFile(); // ��� ���
					char[] arr = new char[(int)selectedFile.length()]; // ��¹��� ��Ʈ��(br)�� ���� �ؽ�Ʈ�� ���� �ӽ� �׸��� �����.
					
					
					/* 0. ���õ� ���� : selectedFile
					 * 1. ���õ� ���ϰ� ����� �� ��Ʈ�� ���� : new FileInputStream(selectedFile), "utf-8")
					 * 2. (1)���� ������ ��Ʈ���� InputStreamReader������ ����
					 * 	 InputStreamReader : InputStream�� Reader �� ����
					 * 3. BufferedReader ��ü ���� <=== ���� ��ǥ ��Ʈ�� 
					 *   => ���� ���� ��
					 * 
					 */
					
					try(BufferedReader br = new BufferedReader(  // ��¹��� ��Ʈ�� ����� (https://codechacha.com/ko/java-try-with-resources/)
							new InputStreamReader(new FileInputStream(selectedFile), "utf-8"))) {
						br.read(arr); // br�� ������ read�Ͽ� arr�� ����
						textArea.setText(String.valueOf(arr)); // arr�� ���ڵ��� String������ ��ȯ�Ͽ� textarea�� ��� 
						updateFilename(selectedFile.getName());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(Notepad.this, "�߸��� ��� �Դϴ�.");
					} 
				}
			}
		});
		
		// Save �޴� ���� �� 
		menuItems[SAVE].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���Ͽ��� ���̾�α� �� ���
				int result = fileChooser.showSaveDialog(Notepad.this);
				if (result == JFileChooser.APPROVE_OPTION) { // ������ ������ ��� ��ȯ
					File selectedFile = fileChooser.getSelectedFile(); // ��� ���
					if(!selectedFile.getName().endsWith(".txt")) {  // �� �����̸� �Է� �� txt Ȯ���ڰ� ������,
						try {
							File f = new File(selectedFile.getCanonicalPath() + ".txt"); // �ش� ���Ͽ� txt Ȯ���� ����
							selectedFile.renameTo(f);
							selectedFile = f;
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
					// try-with-resource (�ڵ� close�� ����)
					try(BufferedWriter br = new BufferedWriter( 
							new OutputStreamWriter(new FileOutputStream(selectedFile), "utf-8"))) {
						
						br.write(textArea.getText());
						updateFilename(selectedFile.getName());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(Notepad.this, "�߸��� ��� �Դϴ�.");
					} 
				}
			}
		});
		
		// Exit �޴� ���� �� 
		menuItems[EXIT].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // ���α׷� ����
			}

		});

	}

	// TextArea �ʱ�ȭ
	private void initTextArea() {
		textArea = new JTextArea();
		textArea.setLineWrap(true); // �ڵ� �ٹٲ��� ���� 
		textArea.setWrapStyleWord(true);// �ڵ� �ٹٲ��� ���� 
		
		// ��ũ�� �� �غ�
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setSize(20, 500);

		// textArea�� ����(Document)�� ���� ������
		textArea.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) { // �ؽ�Ʈ ���� ��
				label.setText(textArea.getText().length() + " characters "); // ���� �� ���� label ��������
			}

			@Override
			public void insertUpdate(DocumentEvent e) { // �ؽ�Ʈ �Է� ��
				label.setText(textArea.getText().length() + " characters "); // ���� �� ���� label ��������
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
	}

	// �ϴ� label �ʱ�ȭ
	private void initFooterLabel() {
		label = new JLabel("0 characters ");
		label.setHorizontalAlignment(SwingConstants.RIGHT); // �ؽ�Ʈ�� label �����ʿ� ��ġ 
	}

	// JFrame ����
	private void run() {

		initMenuBar();
		initFooterLabel();
		initTextArea();

		// ũ��
		this.setSize(700, 500);

		// Ÿ��Ʋ
		updateFilename(DEFAULT_FILE_NAME);

		// ȭ���� �Ѱ���� �ߵ���
		this.setLocationRelativeTo(null);

		// 'X' ������ ���α׷� ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ���̾ƿ� ����
		this.setLayout(new BorderLayout());

		// NORTH ���� �޴���
		this.add(menuBar, BorderLayout.NORTH);

		// CENTER ���� TEXTAREA
		this.add(scrollPane, BorderLayout.CENTER);

		// SOUTH ���� JLabel
		this.add(label, BorderLayout.SOUTH);

		// ȭ�� ����
		this.setVisible(true);
	}

	// ������ : ȸ�� ���� + ȭ�� ������ 
	public Notepad() {
		run();
	}
}