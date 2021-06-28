/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachat2;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import javachat.Message;

/**
 *
 * @author user
 */
public class JavaChatGui2 extends javax.swing.JFrame implements Runnable {
	private Socket sock;// 소켓(데이터 통신을 위한)
	private String userId;// 유저 아이디
	private String nick;// 닉네임
	private String host;// 호스트 아이피
	private int port = 9999; // port number = 9999;
	private boolean isStop; // 스레드 중지 확인.
	private boolean isSendOne; // 귓속말 확인을 위한 변수
	private int fontCr = Color.black.getRGB();

	private ObjectOutputStream out; // OutPutStream 변수
	private ObjectInputStream in; // InputStream 변수

	private StyledDocument doc;

	// End of variables declaration//GEN-END:variables

	public JavaChatGui2() {
		initComponents();
		tfHost.setText("localhost");// 호스트 란에 기본값 아이피 저장
		doc = this.tpMsg.getStyledDocument();
		this.tabEnabled(LOGIN, CHAT_ENTER);// 로그인 패널 활성화
		this.btLogout.setEnabled(false);// 로그아웃 버튼 비활성화

		tpMsg.setEditable(false);// tpMsg 비활성화
		tfInput.setText("");
		tfInput.requestFocus();//

		// 창닫기 이벤트 처리-------------------
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exitProcess();
			}
		});

	}// Constructor----------------------

	/** 종료버튼 메소드 */
	protected void exitProcess() {
		int yn = ShowConfirm("종료할까요?");
		if (yn == JOptionPane.NO_OPTION) { // no 선택시 다시 돌아간다.
			return;
		}
		// 1. 채팅 서버에 접속하고 종료하는 경우
		if (sock != null && sock.isClosed()) {
			Message msg = new Message(900, userId, nick);
			try {
				out.writeObject(msg);
				out.flush();
			} catch (IOException e) {
				System.out.println("시스템 종료중 예외:" + e);
				System.exit(0);// 서버가 끊기면 종료
			}
		} else {
			// 2. 채팅 서버에 접속하지 않고 종료하는 경우
			System.exit(0);
		} // if------------------------

	}// exitProcess()-----------------------------------------------

	/** ConfirmDialog 상자 메소드 */
	private int ShowConfirm(String str) {
		int n = JOptionPane.showConfirmDialog(this, str, "확인", JOptionPane.YES_NO_OPTION);
		return 0;
	}

	@Override
	public void run() {

		while (!isStop) {
			try {
				Object obj = in.readObject();
				System.out.println("클라이언트 obj=" + obj);
				if (obj == null)
					return; // null값 체크
				if (obj instanceof Message) { // instanceof ==객체를 확인 true/false반환
					Message data = (Message) obj;
					parsing(data);
				}
			} catch (ClassNotFoundException | IOException e) {
				showMsg("클라이언트의 Run()예외" + e);

			}
		}

	}

	/** 프로토콜에 따라 접속자에게 보내는 메세지 메소드 */
	private void parsing(Message msg) {
		int code = msg.getCode();// 메세지 에 맞는 코드 출력에 필요한 변수
		switch (code) {
		case 100: {
			this.userModel = (DefaultTableModel) this.userTable.getModel();// 모델생성
			Object[] rowData = { msg.getId(), msg.getNick() };
			userModel.addRow(rowData);// rowData 배열에 행추가
		}
			break;

		case 400: {// 대화 메세지 " 400|보내는 사람 아이디| 대화명 | 메세지| 글자색"
			String fromId = msg.getId();
			String fromNick = msg.getNick();
			String str = msg.getMsg();
			int fcr = msg.getFontRGB();
			showChat(fromNick, fcr, str);
		}

		}

	}// parsing()------------------

	/** 클라이언트가 전한 메세지를 tpMsg에 스타일을 적용하여 표현하는 메소드 */
	private void showChat(String from, int fontRGB, String fromMsg) {
		synchronized (this) {
			SimpleAttributeSet attr = new SimpleAttributeSet();
			StyleConstants.setForeground(attr, new Color(fontRGB));
			StyleConstants.setFontSize(attr, 16);
			StyleConstants.setFontFamily(attr, "sans-serif");

			String str = from + ">>" + fromMsg + "\r\n";
			int pos = doc.getEndPosition().getOffset() - 1;
			tpMsg.setCaretPosition(pos);

			try {
				doc.insertString(pos, str, attr);
			} catch (BadLocationException e) {
				System.out.println("doc.insertString의 에러" + e);

			} // try - catch
		} // synchronized

	}// ------------------------------- showChat()-------------------

	// tabEnabled 에 사용될 상수 정의 (프로토콜에 정의됨.)
	public static final int LOGIN = 0;
	public static final int CHAT_ENTER = 1;
	public static final int THEME = 2;
	public static final int LOGOUT = -1;
	public static final int EXIT = -2;

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		tabP = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		tfId = new javax.swing.JTextField();
		tfNick = new javax.swing.JTextField();
		tfHost = new javax.swing.JTextField();
		btCon = new javax.swing.JButton();
		btReset = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		tpMsg = new javax.swing.JTextPane();
		tfInput = new javax.swing.JTextField();
		comboColor = new javax.swing.JComboBox<>();
		lbPreview = new javax.swing.JLabel();
		btEmoti = new javax.swing.JButton();
		chk = new javax.swing.JCheckBox();
		jPanel3 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		userTable = new javax.swing.JTable();
		jPanel5 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		lbId = new javax.swing.JLabel();
		lbNick = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		btLogout = new javax.swing.JButton();
		btRename = new javax.swing.JButton();
		btExit = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("::TIS Talk v1.1::");
		setResizable(false);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.PNG"))); // NOI18N

		jLabel2.setBackground(new java.awt.Color(255, 255, 255));
		jLabel2.setFont(new java.awt.Font("한컴 윤고딕 250", 1, 24)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(0, 102, 255));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("TIS Talk v1.1");
		jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		jLabel2.setOpaque(true);

		jLabel6.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
		jLabel6.setText("대 화 명 :");

		jLabel7.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
		jLabel7.setText("아 이 디 :");

		jLabel8.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
		jLabel8.setText("호 스 트 :");

		btCon.setBackground(new java.awt.Color(51, 153, 255));
		btCon.setForeground(new java.awt.Color(255, 255, 255));
		btCon.setMnemonic('C');
		btCon.setText("연    결");
		btCon.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btConActionPerformed(evt);
			}
		});

		btReset.setBackground(new java.awt.Color(51, 153, 255));
		btReset.setForeground(new java.awt.Color(255, 255, 255));
		btReset.setMnemonic('R');
		btReset.setText("다시 쓰기");
		btReset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btResetActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel8)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel4Layout.createSequentialGroup().addComponent(btCon)
												.addGap(110, 110, 110).addComponent(btReset))
										.addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 291,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel7)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 312,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel4Layout.createSequentialGroup().addComponent(jLabel6)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(tfNick, javax.swing.GroupLayout.PREFERRED_SIZE, 312,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(33, Short.MAX_VALUE)));

		jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { btCon, btReset });

		jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { tfHost, tfId, tfNick });

		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel4Layout.createSequentialGroup().addContainerGap(51, Short.MAX_VALUE)
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(34, 34, 34)
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(tfNick, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(38, 38, 38)
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(39, 39, 39)
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btReset).addComponent(btCon,
												javax.swing.GroupLayout.PREFERRED_SIZE, 42,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(36, 36, 36)));

		jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { btCon, btReset });

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addContainerGap()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(32, 32, 32).addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		tabP.addTab("로그인", jPanel1);

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));

		tpMsg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255), 3));
		jScrollPane2.setViewportView(tpMsg);

		tfInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255), 3));
		tfInput.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tfInputActionPerformed(evt);
			}
		});

		comboColor.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "검정색", "빨강색", "녹   색", "파   랑", "남   색" }));
		comboColor.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				comboColorItemStateChanged(evt);
			}
		});

		lbPreview.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
		lbPreview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lbPreview.setText("가");
		lbPreview.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		lbPreview.setMaximumSize(new java.awt.Dimension(20, 20));
		lbPreview.setPreferredSize(new java.awt.Dimension(20, 20));

		btEmoti.setText("이모티콘");
		btEmoti.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btEmotiActionPerformed(evt);
			}
		});

		chk.setText("귓  속  말");
		chk.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				chkItemStateChanged(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane2).addComponent(tfInput)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(chk).addGap(18, 18, 18)
						.addComponent(comboColor, 0, 200, Short.MAX_VALUE).addGap(18, 18, 18)
						.addComponent(lbPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(btEmoti).addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(tfInput, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(lbPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btEmoti))
								.addComponent(comboColor).addComponent(chk, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(0, 12, Short.MAX_VALUE)));

		tabP.addTab("채팅방", jPanel2);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 462, Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 465, Short.MAX_VALUE));

		tabP.addTab("테마색", jPanel3);

		userTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "아이디", "대화명" }));
		userTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				userTableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(userTable);

		jPanel5.setBackground(new java.awt.Color(255, 255, 204));
		jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "::My Info::",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("굴림", 1, 12))); // NOI18N

		jLabel3.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
		jLabel3.setText("아 이 디 :");

		lbId.setFont(new java.awt.Font("나눔고딕", 1, 14)); // NOI18N

		lbNick.setFont(new java.awt.Font("나눔고딕", 1, 14)); // NOI18N

		jLabel9.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
		jLabel9.setText("대 화 명:");

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel5Layout.createSequentialGroup().addComponent(jLabel3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbId))
						.addGroup(jPanel5Layout.createSequentialGroup().addComponent(jLabel9)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbNick)))
						.addGap(86, 86, 86)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addContainerGap(41, Short.MAX_VALUE)
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(lbId))
						.addGap(51, 51, 51)
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel9).addComponent(lbNick))
						.addGap(35, 35, 35)));

		btLogout.setBackground(new java.awt.Color(51, 153, 255));
		btLogout.setForeground(new java.awt.Color(255, 255, 255));
		btLogout.setText("퇴  장");
		btLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btLogoutActionPerformed(evt);
			}
		});

		btRename.setBackground(new java.awt.Color(51, 153, 255));
		btRename.setForeground(new java.awt.Color(255, 255, 255));
		btRename.setText("대화명 변경");
		btRename.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btRenameActionPerformed(evt);
			}
		});

		btExit.setBackground(new java.awt.Color(51, 153, 255));
		btExit.setForeground(new java.awt.Color(255, 255, 255));
		btExit.setText("종  료");
		btExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btExitActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addComponent(tabP, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup().addComponent(btLogout)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40,
										Short.MAX_VALUE)
								.addComponent(btRename).addGap(37, 37, 37).addComponent(btExit)))
				.addContainerGap()));

		layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { btExit, btLogout, btRename });

		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btLogout)
										.addComponent(btRename, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btExit))
								.addGap(8, 8, 8))
						.addComponent(tabP)).addContainerGap()));

		layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { btExit, btLogout, btRename });

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/** 연결 버튼 작동 이벤트 */
	private void btConActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btConActionPerformed
		check();
	}

	/** 아이디, 대화명 확인 메소드 */
	private void check() {
		// 사용자가 입력한 값 얻기
		userId = tfId.getText();
		nick = tfNick.getText();
		this.host = tfHost.getText();

		// 유효성 체크
		// null값 체크
		if (userId == null || nick == null || host == null ||
		// 공백체크
				userId.trim().isEmpty() || nick.trim().isEmpty() || host.trim().isEmpty()) {

			// 채팅방에 입장하는 메소드 호출
			chatEnter();

		}

	}

	/** 채팅방에 입장하는 메소드 */
	private void chatEnter() {
		try {
			sock = new Socket(host, port);// 소켓에 호스트아이피, 포트넘버
			tpMsg.setText("채팅 서버에 접속하셨습니다.\r\n");
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			// caution : 서버쪽에서 in, out순서로 생성하면 client쪽에서는
			// 반대로 생성해야 한다.

			// 리스너 스레드를 생성, 동작
			isStop = false; // 초기화
			Thread listener = new Thread(this);
			listener.start();

			// 입장 메세지를 서버에 보내자. "100|아이디|대화명"
			Message data = new Message(100, userId, nick);
			out.writeObject(data);
			out.flush();

			// 채팅창 활성화, 로그인 패널은 비활성화
			this.tabEnabled(CHAT_ENTER, LOGIN);

			// MyInfo셋팅
			this.lbId.setText(userId);
			this.lbNick.setText(nick);

			this.setTitle(this.getTitle() + "[" + nick + "]"); // 타이틀에 닉네임 표시

		} catch (UnknownHostException e) {
			showMsg("호스트 명을 확인하세요.");

		} catch (IOException e) {
			System.out.println("ChatEnter() 예외:" + e);
		} // -- try catch----------------------

	}// chatEnter()----------------------------------

	/** 메세지창 메소드 */
	private void showMsg(String str) {
		JOptionPane.showMessageDialog(this, str);// 메세지창

	}

	/** 탭창 활성화 조정 메소드 */
	private void tabEnabled(int enabled, int disabled) {// setEnabledAt을 위한 변수
		// enabled :0(로그인) |1(채팅방) (탭의 인덱스 번호),
		tabP.setEnabledAt(enabled, true);
		tabP.setEnabledAt(disabled, false);

		if (enabled == LOGIN) {
			tfId.requestFocus();

		} else if (enabled == CHAT_ENTER) {
			tfInput.requestFocus();
			btLogout.setEnabled(true);// 로그아웃 버튼 활성화
		} // if------------------
		tabP.setSelectedIndex(enabled);//
	}// tabEnabled()-----------------------------

	/** reset버튼 액션이벤트 */
	private void btResetActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btResetActionPerformed
		tfId.setText("");
		tfNick.setText("");
		tfHost.setText("");
	}// ----------------btResetActionPerformed-------------

	private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btLogoutActionPerformed
		int yn = ShowConfirm("로그아웃 할까요?");
		if (yn == JOptionPane.YES_NO_OPTION) {
			Message data = new Message(800, userId, nick);
			try {
				out.writeObject(data);
				out.flush();
			} catch (IOException e) {
				System.out.println("퇴장 중 예외:" + e);
			}

		}
	}// ----------------------btLogoutActionPerformed--------------------

	private void btRenameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btRenameActionPerformed

	}

	/** 종료버튼 액션 이벤트 */
	private void btExitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btExitActionPerformed
		exitProcess();
	}// --------------btExitActionPerformed

	private void btEmotiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btEmotiActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btEmotiActionPerformed

	private void tfInputActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfInputActionPerformed
		// tfInput에 입력한 값 얻기
		String sendMSg = tfInput.getText();
		// 서버에 해당 메세지 보내기
		SendMessage(sendMSg);
		tfInput.setText("");
		tfInput.requestFocus();
	}// GEN-LAST:event_tfInputActionPerformed

	private void SendMessage(String MSg) {
		if (isSendOne) {
		// 1. 귓속말인 경우 500: 500|귓속말 보내는 사람의 대화명|귓속말 메세지 체크박스(chk)에 체크하면 귓속말 적용
		}
		// 2
	}

	private void chkItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_chkItemStateChanged
		// TODO add your handling code here:
	}// GEN-LAST:event_chkItemStateChanged

	private void comboColorItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_comboColorItemStateChanged
		// TODO add your handling code here:
	}// GEN-LAST:event_comboColorItemStateChanged

	private void userTableMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_userTableMousePressed
		// TODO add your handling code here:
	}// GEN-LAST:event_userTableMousePressed

	// End of variables declaration//GEN-END:variables

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(JavaChatGui2.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(JavaChatGui2.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(JavaChatGui2.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(JavaChatGui2.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new JavaChatGui2().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btCon;
	private javax.swing.JButton btEmoti;
	private javax.swing.JButton btExit;
	private javax.swing.JButton btLogout;
	private javax.swing.JButton btRename;
	private javax.swing.JButton btReset;
	private javax.swing.JCheckBox chk;
	private javax.swing.JComboBox<String> comboColor;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel lbId;
	private javax.swing.JLabel lbNick;
	private javax.swing.JLabel lbPreview;
	private javax.swing.JTabbedPane tabP;
	private javax.swing.JTextField tfHost;
	private javax.swing.JTextField tfId;
	private javax.swing.JTextField tfInput;
	private javax.swing.JTextField tfNick;
	private javax.swing.JTextPane tpMsg;
	private javax.swing.JTable userTable;
	private javax.swing.table.DefaultTableModel userModel;
	// End of variables declaration//GEN-END:variables
}
