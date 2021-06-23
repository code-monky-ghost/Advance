/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynotepad;

import javax.swing.*;
import java.io.*;

/**
 *
 * @author user
 */
public class NotePad2 extends javax.swing.JFrame {

	BufferedReader br;
	PrintWriter pw;

	/**
	 * Creates new form NotePad
	 */
	public NotePad2() {
		super("::NotePad v1.1::");
		initComponents();
		tfDir.setText("C:/MyJava");// 기본경로 지정함

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jToolBar1 = new javax.swing.JToolBar();
		btNew = new javax.swing.JButton();
		btOpen = new javax.swing.JButton();
		btSave = new javax.swing.JButton();
		filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0),
				new java.awt.Dimension(32767, 0));
		btHelp = new javax.swing.JButton();
		jSplitPane1 = new javax.swing.JSplitPane();
		jPanel1 = new javax.swing.JPanel();
		tfDir = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		list = new javax.swing.JList<>();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		ta = new javax.swing.JTextArea();
		jScrollPane3 = new javax.swing.JScrollPane();
		lb = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jToolBar1.setRollover(true);

		btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
		btNew.setFocusable(false);
		btNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btNew.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btNewActionPerformed(evt);
			}
		});
		jToolBar1.add(btNew);

		btOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/open.png"))); // NOI18N
		btOpen.setFocusable(false);
		btOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btOpen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btOpenActionPerformed(evt);
			}
		});
		jToolBar1.add(btOpen);

		btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
		btSave.setFocusable(false);
		btSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btSave.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btSaveActionPerformed(evt);
			}
		});
		jToolBar1.add(btSave);
		jToolBar1.add(filler1);

		btHelp.setText("Help");
		btHelp.setFocusable(false);
		btHelp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btHelp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btHelp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btHelpActionPerformed(evt);
			}
		});
		jToolBar1.add(btHelp);

		jSplitPane1.setDividerLocation(170);
		jSplitPane1.setDividerSize(7);
		jSplitPane1.setOneTouchExpandable(true);

		tfDir.setBorder(javax.swing.BorderFactory.createTitledBorder("::Directory::"));
		tfDir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				tfDirActionPerformed(evt);
			}
		});

		list.setBorder(javax.swing.BorderFactory.createTitledBorder("::List:::"));
		list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				listValueChanged(evt);
			}
		});
		jScrollPane1.setViewportView(list);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(tfDir, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(tfDir, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)));

		jSplitPane1.setLeftComponent(jPanel1);

		ta.setColumns(20);
		ta.setRows(5);
		ta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 3, true));
		jScrollPane2.setViewportView(ta);

		lb.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
		lb.setForeground(new java.awt.Color(102, 102, 102));
		lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lb.setText("No Image");
		jScrollPane3.setViewportView(lb);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
				.addComponent(jScrollPane3));

		jSplitPane1.setRightComponent(jPanel2);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jToolBar1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(jSplitPane1));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSplitPane1)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	/***/
	private void btNewActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btNewActionPerformed
		ta.setText("");// 비워준다.

	}
	/**열기 버튼 이벤트*/
	private void btOpenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btOpenActionPerformed
		int n =jfc.showOpenDialog(this);
		if(n==JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			if(file==null)return;
			String path = file.getAbsolutePath();
			readFile(path);
					
		}
		
		
	}//------------------------------------

	JFileChooser jfc = new JFileChooser("C:/Myjava");// 파일선택 다이얼로그

	/** 저장 버튼 이벤트 */
	private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btSaveActionPerformed
		int n = jfc.showSaveDialog(this);
//		setTitle("n:"+n);
		if (n == JFileChooser.APPROVE_OPTION) {// 상수로 해준다 ( APPROVE_OPTION)
			// 저장할 파일명 얻기 ==> 절대경로 얻기 (다이얼로그창에서 얻어와야한다.)
			File file = jfc.getSelectedFile();// 파일타입이라 매개변수로 넘길수 없다.
			System.out.println(file);
			if (file == null)
				return;
			String path = file.getAbsolutePath();// 절대경로로 받아라
			setTitle(path);
			// 저장할 내용 얻기 => ta에서 얻어오기
			String contents = ta.getText();

			// 해당 파일이 존재하는지 여부를 판단해서 존재하면 "덮어쓸까요?"
			if (file.exists()) {
				// 이미 존재하는 파일이라면 확인
				int n2 = JOptionPane.showConfirmDialog(ta, "이미 존재하는 파일입니다. 덮어쓸까요?");
				if(n2==JOptionPane.YES_OPTION) {
					saveFile(path,contents);
				}
				// 존재하지 않으면 그냥 저장
			} else {
				saveFile(path, contents);
			}

		}

	}
	/**Help button 이벤트*/
	private void btHelpActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btHelpActionPerformed
		showMsg("NotePad v1.1\n작성일:2021-06-17\n작성자:김재경");
	}// GEN-LAST:event_btHelpActionPerformed

	/** 디렉토리명을 검사하는 메소드 */
	public void checkDir(String str) {
		// int indexOf(char|String)
		// 특정 문자나 문자열이 위치한 인덱스 번호를 반환한다.
		// 해당 문자/문자열이 없으면 -1을 반환한다.
		int i = str.indexOf('/');
		int i2 = str.indexOf("\\");
		// System.out.println(i+"/"+i2);
		// 2. 유효성 체크(null,빈문자열)
		if (str == null || str.trim().isEmpty()) {
			showMsg("디렉토리명을 입력하세요");
			return;
		}
		// 3. 입력한 값이 디렉토리인지 여부 판단
		File dir = new File(str);
		if (!dir.isDirectory() || (i == -1 && i2 == -1)) {
			showMsg("디렉토리가 아닙니다. 디렉토리명을 입력하세요");
			tfDir.setText("");
			return;
		}
	}// ----------------------------------

	/** tfDir에 입력한 값 목록으로 보여주는 이벤트 */
	private void tfDirActionPerformed(java.awt.event.ActionEvent evt) {
		// 1. tfDir에 입력한 값 받아오기
		String str = tfDir.getText();
		checkDir(str);
		File dir = new File(str);
		// 4. 디렉토리라면 해당 디렉토리의 파일목록 가져와서 JList에 출력하기
		String[] fList = dir.list();// 데이터 ==> Model이갖는다.
		// JList(View) ==> DefaultListModel
		if (fList != null) {
			DefaultListModel<String> model = new DefaultListModel<>();
			for (String fname : fList) {
				model.addElement(fname);
			}
			// 뷰와 모델을 연결
			list.setModel(model);
		}
	}// -------------------------------------------

	
	
	private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {

		boolean b = evt.getValueIsAdjusting();
		// System.out.println("b="+b);
		if (b) {
			// 1. list에서 선택한 목록값 가져오기
			String str = list.getSelectedValue();

			// 2. 선택한 파일의 확장자가 .jpg, .png, .gif파일이라면
			// ==> 해당 이미지를 lb에 보여준다.
			// boolean endsWith(String str)
			String str2 = str.toLowerCase();// 파일명을 전부 소문자로 바꿔줌
			String path = tfDir.getText() + "/" + str; // 선택한 파일의 경로를 절대경로로 바꿔준다.

			if (str2.endsWith(".jpg") || str2.endsWith("png") || str2.endsWith(".gif")) {

				setTitle(path);
				previewImage(path);

			}

			// 3. 파일 확장자가 .txt, .java, .html이라면 해당 파일의
			// 절대경로를 구해서 파일 입력스트림과 연결하여 읽은 뒤에
			// 읽은 내용을 ta에 출력한다.
			if (str2.endsWith(".txt") || str2.endsWith(".java") || str2.endsWith(".html")) {
				setTitle(path);
				readFile(path);

			}

		}

	}// -------------------------------------------

	public void readFile(String path) {
		try {
			// path와 --> 노드스트림 --> BufferedReader로 필터링
			br = new BufferedReader(new FileReader(path));
//			br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));// 브릿지 스트림의 장점 :InputsteamReader 인코딩방식을 지정할 수 있다.
			String line = "";
			ta.setText("");

			// 반복문 돌면서 line단위로 읽어서 ta에 append
			while ((line = br.readLine()) != null) {
				ta.append(line + "\r\n"); // Enter 키 단위로 더해짐
			}
			br.close();

		} catch (IOException e) {
			showMsg(e.getMessage());
		}

	}// --------------------------------------------------------------------------------------

	/** 파일 저장하는 메소드 */
	public void saveFile(String path, String contents) {
		// pw stream 생성해서 파일과 연결한 뒤에
		try {
			pw = new PrintWriter(new FileWriter(path), true);// 자동으로 flush
			pw.println(contents);
			pw.close();
			setTitle(path + "에 저장완료!!"); // 경로에 저장완료 됨을 표시
		} catch (IOException e) {

		}

		// 파일에 쓸 내용 내보내기

		// 스트림 연결 닫기

	}// -------------------------------------------------------------

	/** 이미지 선택하면 이미지 창에 보여주는 메소드 */
	public void previewImage(String path) {
		ImageIcon icon = new ImageIcon(path);
		lb.setIcon(icon);
		lb.setText("");
	}

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
				System.out.println(info.getName());
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(NotePad2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(NotePad2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(NotePad2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(NotePad2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new NotePad2().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btHelp;
	private javax.swing.JButton btNew;
	private javax.swing.JButton btOpen;
	private javax.swing.JButton btSave;
	private javax.swing.Box.Filler filler1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JSplitPane jSplitPane1;
	private javax.swing.JToolBar jToolBar1;
	private javax.swing.JLabel lb;
	private javax.swing.JList<String> list;
	private javax.swing.JTextArea ta;
	private javax.swing.JTextField tfDir;
	// End of variables declaration//GEN-END:variables
}