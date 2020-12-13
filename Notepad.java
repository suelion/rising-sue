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

	// 버전 1
	private static final long serialVersionUID = 1L;
	
	// 메뉴 아이템 상수 선언 (배열 인덱스 대신 상수를 사용 - 가독성)
	static final int NEW_FILE = 0;  
	static final int OPEN = 1;
	static final int SAVE = 2;
	static final int EXIT = 3;
	
	// 기본 파일명
	static final String DEFAULT_FILE_NAME = "untitled";
	
	// 메뉴바 
	private JMenuBar menuBar;
	
	// 텍스트 입력창
	private JTextArea textArea;
	
	// 스크롤바 (스크롤 패널)
	private JScrollPane scrollPane;
	
	// 하단 label 
	private JLabel label;
	
	// 파일 선택 객체
	private JFileChooser fileChooser = new JFileChooser();

	// 파일명 변경 (JFrame 타이틀 변경)
	private void updateFilename(String newName) {
		this.setTitle(newName + " - Notepad");
	}
	
	// 메뉴바 초기화
	private void initMenuBar() {
		menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		
		// 메뉴 아이템 배열화
		JMenuItem[] menuItems = { 
				new JMenuItem("New File"), 
				new JMenuItem("Open"), 
				new JMenuItem("Save"),
				new JMenuItem("Exit"), };
		
		// MenuItem을 Menu에 등록
		for (JMenuItem item : menuItems) {
			menu.add(item);
		}
		
		// Menu를 MenuBar에 등록
		menuBar.add(menu);

		
		/*
		 * ActionListener : 클릭되었을 때 발생하는 이벤트를 기다리는(listen) 객체 
		 *  각 메뉴 아이템에게 ActionListener형 익명 객체를 각각 넣어준다. 
		 */
		
		// NewFile 메뉴 선택 시 
		menuItems[NEW_FILE].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText(""); // TextArea의 내용을 빈문자열로 대체 
				updateFilename(DEFAULT_FILE_NAME); // 파일이름(=프레임 타이틀) 을 변경 
			}
		});

		// Open 메뉴 선택 시 
		menuItems[OPEN].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일오픈 다이얼로그 를 띄움
				int result = fileChooser.showOpenDialog(Notepad.this);
				if (result == JFileChooser.APPROVE_OPTION) { // 선택한 파일의 경로 반환
					File selectedFile = fileChooser.getSelectedFile(); // 경로 출력
					char[] arr = new char[(int)selectedFile.length()]; // 출력버퍼 스트림(br)로 들어온 텍스트를 담을 임시 그릇을 만든다.
					
					
					/* 0. 선택된 파일 : selectedFile
					 * 1. 선택된 파일과 연결된 주 스트림 생성 : new FileInputStream(selectedFile), "utf-8")
					 * 2. (1)에서 생성한 스트림을 InputStreamReader형으로 포장
					 * 	 InputStreamReader : InputStream을 Reader 로 변경
					 * 3. BufferedReader 객체 생성 <=== 최종 목표 스트림 
					 *   => 성능 좋게 함
					 * 
					 */
					
					try(BufferedReader br = new BufferedReader(  // 출력버퍼 스트림 만들기 (https://codechacha.com/ko/java-try-with-resources/)
							new InputStreamReader(new FileInputStream(selectedFile), "utf-8"))) {
						br.read(arr); // br의 내용을 read하여 arr에 복사
						textArea.setText(String.valueOf(arr)); // arr의 문자들을 String형으로 변환하여 textarea에 출력 
						updateFilename(selectedFile.getName());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(Notepad.this, "잘못된 경로 입니다.");
					} 
				}
			}
		});
		
		// Save 메뉴 선택 시 
		menuItems[SAVE].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일오픈 다이얼로그 를 띄움
				int result = fileChooser.showSaveDialog(Notepad.this);
				if (result == JFileChooser.APPROVE_OPTION) { // 선택한 파일의 경로 반환
					File selectedFile = fileChooser.getSelectedFile(); // 경로 출력
					if(!selectedFile.getName().endsWith(".txt")) {  // 새 파일이름 입력 시 txt 확장자가 없으면,
						try {
							File f = new File(selectedFile.getCanonicalPath() + ".txt"); // 해당 파일에 txt 확장자 붙임
							selectedFile.renameTo(f);
							selectedFile = f;
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
					// try-with-resource (자동 close를 위해)
					try(BufferedWriter br = new BufferedWriter( 
							new OutputStreamWriter(new FileOutputStream(selectedFile), "utf-8"))) {
						
						br.write(textArea.getText());
						updateFilename(selectedFile.getName());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(Notepad.this, "잘못된 경로 입니다.");
					} 
				}
			}
		});
		
		// Exit 메뉴 선택 시 
		menuItems[EXIT].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // 프로그램 종료
			}

		});

	}

	// TextArea 초기화
	private void initTextArea() {
		textArea = new JTextArea();
		textArea.setLineWrap(true); // 자동 줄바꿈을 위해 
		textArea.setWrapStyleWord(true);// 자동 줄바꿈을 위해 
		
		// 스크롤 바 준비
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setSize(20, 500);

		// textArea의 내용(Document)에 대한 리스너
		textArea.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) { // 텍스트 삭제 시
				label.setText(textArea.getText().length() + " characters "); // 글자 수 세어 label 업데이터
			}

			@Override
			public void insertUpdate(DocumentEvent e) { // 텍스트 입력 시
				label.setText(textArea.getText().length() + " characters "); // 글자 수 세어 label 업데이터
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
	}

	// 하단 label 초기화
	private void initFooterLabel() {
		label = new JLabel("0 characters ");
		label.setHorizontalAlignment(SwingConstants.RIGHT); // 텍스트를 label 오른쪽에 배치 
	}

	// JFrame 설정
	private void run() {

		initMenuBar();
		initFooterLabel();
		initTextArea();

		// 크기
		this.setSize(700, 500);

		// 타이틀
		updateFilename(DEFAULT_FILE_NAME);

		// 화면의 한가운데에 뜨도록
		this.setLocationRelativeTo(null);

		// 'X' 누르면 프로그램 종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 레이아웃 설정
		this.setLayout(new BorderLayout());

		// NORTH 에는 메뉴바
		this.add(menuBar, BorderLayout.NORTH);

		// CENTER 에는 TEXTAREA
		this.add(scrollPane, BorderLayout.CENTER);

		// SOUTH 에는 JLabel
		this.add(label, BorderLayout.SOUTH);

		// 화면 띄우기
		this.setVisible(true);
	}

	// 생성자 : 회면 셋팅 + 화면 띄위기 
	public Notepad() {
		run();
	}
}