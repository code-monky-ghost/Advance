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
		tfDir.setText("C:/MyJava");// �⺻��� ������

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
		ta.setText("");// ����ش�.

	}
	/**���� ��ư �̺�Ʈ*/
	private void btOpenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btOpenActionPerformed
		int n =jfc.showOpenDialog(this);
		if(n==JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			if(file==null)return;
			String path = file.getAbsolutePath();
			readFile(path);
					
		}
		
		
	}//------------------------------------

	JFileChooser jfc = new JFileChooser("C:/Myjava");// ���ϼ��� ���̾�α�

	/** ���� ��ư �̺�Ʈ */
	private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btSaveActionPerformed
		int n = jfc.showSaveDialog(this);
//		setTitle("n:"+n);
		if (n == JFileChooser.APPROVE_OPTION) {// ����� ���ش� ( APPROVE_OPTION)
			// ������ ���ϸ� ��� ==> ������ ��� (���̾�α�â���� ���;��Ѵ�.)
			File file = jfc.getSelectedFile();// ����Ÿ���̶� �Ű������� �ѱ�� ����.
			System.out.println(file);
			if (file == null)
				return;
			String path = file.getAbsolutePath();// �����η� �޾ƶ�
			setTitle(path);
			// ������ ���� ��� => ta���� ������
			String contents = ta.getText();

			// �ش� ������ �����ϴ��� ���θ� �Ǵ��ؼ� �����ϸ� "������?"
			if (file.exists()) {
				// �̹� �����ϴ� �����̶�� Ȯ��
				int n2 = JOptionPane.showConfirmDialog(ta, "�̹� �����ϴ� �����Դϴ�. ������?");
				if(n2==JOptionPane.YES_OPTION) {
					saveFile(path,contents);
				}
				// �������� ������ �׳� ����
			} else {
				saveFile(path, contents);
			}

		}

	}
	/**Help button �̺�Ʈ*/
	private void btHelpActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btHelpActionPerformed
		showMsg("NotePad v1.1\n�ۼ���:2021-06-17\n�ۼ���:�����");
	}// GEN-LAST:event_btHelpActionPerformed

	/** ���丮���� �˻��ϴ� �޼ҵ� */
	public void checkDir(String str) {
		// int indexOf(char|String)
		// Ư�� ���ڳ� ���ڿ��� ��ġ�� �ε��� ��ȣ�� ��ȯ�Ѵ�.
		// �ش� ����/���ڿ��� ������ -1�� ��ȯ�Ѵ�.
		int i = str.indexOf('/');
		int i2 = str.indexOf("\\");
		// System.out.println(i+"/"+i2);
		// 2. ��ȿ�� üũ(null,���ڿ�)
		if (str == null || str.trim().isEmpty()) {
			showMsg("���丮���� �Է��ϼ���");
			return;
		}
		// 3. �Է��� ���� ���丮���� ���� �Ǵ�
		File dir = new File(str);
		if (!dir.isDirectory() || (i == -1 && i2 == -1)) {
			showMsg("���丮�� �ƴմϴ�. ���丮���� �Է��ϼ���");
			tfDir.setText("");
			return;
		}
	}// ----------------------------------

	/** tfDir�� �Է��� �� ������� �����ִ� �̺�Ʈ */
	private void tfDirActionPerformed(java.awt.event.ActionEvent evt) {
		// 1. tfDir�� �Է��� �� �޾ƿ���
		String str = tfDir.getText();
		checkDir(str);
		File dir = new File(str);
		// 4. ���丮��� �ش� ���丮�� ���ϸ�� �����ͼ� JList�� ����ϱ�
		String[] fList = dir.list();// ������ ==> Model�̰��´�.
		// JList(View) ==> DefaultListModel
		if (fList != null) {
			DefaultListModel<String> model = new DefaultListModel<>();
			for (String fname : fList) {
				model.addElement(fname);
			}
			// ��� ���� ����
			list.setModel(model);
		}
	}// -------------------------------------------

	
	
	private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {

		boolean b = evt.getValueIsAdjusting();
		// System.out.println("b="+b);
		if (b) {
			// 1. list���� ������ ��ϰ� ��������
			String str = list.getSelectedValue();

			// 2. ������ ������ Ȯ���ڰ� .jpg, .png, .gif�����̶��
			// ==> �ش� �̹����� lb�� �����ش�.
			// boolean endsWith(String str)
			String str2 = str.toLowerCase();// ���ϸ��� ���� �ҹ��ڷ� �ٲ���
			String path = tfDir.getText() + "/" + str; // ������ ������ ��θ� �����η� �ٲ��ش�.

			if (str2.endsWith(".jpg") || str2.endsWith("png") || str2.endsWith(".gif")) {

				setTitle(path);
				previewImage(path);

			}

			// 3. ���� Ȯ���ڰ� .txt, .java, .html�̶�� �ش� ������
			// �����θ� ���ؼ� ���� �Է½�Ʈ���� �����Ͽ� ���� �ڿ�
			// ���� ������ ta�� ����Ѵ�.
			if (str2.endsWith(".txt") || str2.endsWith(".java") || str2.endsWith(".html")) {
				setTitle(path);
				readFile(path);

			}

		}

	}// -------------------------------------------

	public void readFile(String path) {
		try {
			// path�� --> ��彺Ʈ�� --> BufferedReader�� ���͸�
			br = new BufferedReader(new FileReader(path));
//			br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));// �긴�� ��Ʈ���� ���� :InputsteamReader ���ڵ������ ������ �� �ִ�.
			String line = "";
			ta.setText("");

			// �ݺ��� ���鼭 line������ �о ta�� append
			while ((line = br.readLine()) != null) {
				ta.append(line + "\r\n"); // Enter Ű ������ ������
			}
			br.close();

		} catch (IOException e) {
			showMsg(e.getMessage());
		}

	}// --------------------------------------------------------------------------------------

	/** ���� �����ϴ� �޼ҵ� */
	public void saveFile(String path, String contents) {
		// pw stream �����ؼ� ���ϰ� ������ �ڿ�
		try {
			pw = new PrintWriter(new FileWriter(path), true);// �ڵ����� flush
			pw.println(contents);
			pw.close();
			setTitle(path + "�� ����Ϸ�!!"); // ��ο� ����Ϸ� ���� ǥ��
		} catch (IOException e) {

		}

		// ���Ͽ� �� ���� ��������

		// ��Ʈ�� ���� �ݱ�

	}// -------------------------------------------------------------

	/** �̹��� �����ϸ� �̹��� â�� �����ִ� �޼ҵ� */
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