package FB20X;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import java.awt.Choice;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Configuration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextArea textArea;
	String username;
	String password;
	int rangeMin;
	int rangeMax;
	int confirmations;
	int waveMin;
	int waveMax;
	String fpath;
	String filename;
	String post;
	/**
	 * Create the frame.
	 */
	public Configuration(String osName,String botName) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		textField_2.setText("6");
		textField_2.setColumns(10);
		textField_2.setBounds(137, 157, 50, 22);
		contentPane.add(textField_2);

		JTextField textField_3 = new JTextField();
		textField_3.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		textField_3.setText("90");
		textField_3.setColumns(10);
		textField_3.setBounds(49, 309, 50, 22);
		contentPane.add(textField_3);
		
		JTextField textField_1 = new JTextField();
		textField_1.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		textField_1.setText("3");
		textField_1.setBounds(49, 157, 50, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Facebook login info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 13, 408, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setBounds(6, 21, 100, 16);
		panel.add(lblUsername_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(6, 50, 100, 16);
		panel.add(lblPassword);
		
		JTextField txtusername = new JTextField();
		txtusername.setBounds(93, 18, 303, 22);
		panel.add(txtusername);
		txtusername.setColumns(10);
		
		Component passwordField = new JPasswordField();
		passwordField.setBounds(93, 47, 303, 22);
		panel.add(passwordField);
		
		JLabel lblConfiguration = new JLabel("Configuration");
		lblConfiguration.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfiguration.setBounds(12, 102, 287, 16);
		contentPane.add(lblConfiguration);
		
		JLabel lblTimerangeGiven = new JLabel("Time range for two consicutive posts (generated randomly)");
		lblTimerangeGiven.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTimerangeGiven.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		lblTimerangeGiven.setBounds(12, 131, 408, 16);
		contentPane.add(lblTimerangeGiven);
		
		JLabel lblMin = new JLabel("Min:");
		lblMin.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		lblMin.setBounds(22, 160, 56, 16);
		contentPane.add(lblMin);
		
		JLabel lblMax = new JLabel("Max:");
		lblMax.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		lblMax.setBounds(109, 160, 56, 16);
		contentPane.add(lblMax);
		
		JLabel lblNumberOfConfirmations = new JLabel("Number of posts in one wave");
		lblNumberOfConfirmations.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumberOfConfirmations.setToolTipText("wave means number of confirmations in bulk(depends on time range given above) before waiting for a longer period, as facebook blocks user if too many requests are made in short period of time. ");
		lblNumberOfConfirmations.setBounds(12, 192, 287, 16);
		contentPane.add(lblNumberOfConfirmations);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(311, 192, 109, 16);
		contentPane.add(lblNewLabel);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblNewLabel.setText(Integer.toString(slider.getValue()));
			}
		});
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(10);
		slider.setMaximum(150);
		slider.setMajorTickSpacing(30);
		slider.setValue(25);
		slider.setToolTipText("wave means number of confirmations in bulk(depends on time range given above) before waiting for a longer period, as facebook blocks user if too many requests are made in short period of time. ");
		slider.setBounds(12, 221, 408, 47);
		contentPane.add(slider);
		
		JLabel lblSeconds = new JLabel("Seconds");
		lblSeconds.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		lblSeconds.setBounds(199, 160, 100, 16);
		contentPane.add(lblSeconds);
		
		JLabel lblTimeRangeTo = new JLabel("Time range to wait between two waves.");
		lblTimeRangeTo.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		lblTimeRangeTo.setBounds(12, 281, 408, 16);
		contentPane.add(lblTimeRangeTo);
		
		JLabel label_1 = new JLabel("Min:");
		label_1.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		label_1.setBounds(22, 312, 56, 16);
		contentPane.add(label_1);
		
		JTextField textField_4 = new JTextField();
		textField_4.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		textField_4.setText("360");
		textField_4.setColumns(10);
		textField_4.setBounds(140, 309, 50, 22);
		contentPane.add(textField_4);
		
		JLabel label_2 = new JLabel("Max:");
		label_2.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		label_2.setBounds(109, 312, 56, 16);
		contentPane.add(label_2);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setToolTipText("Actual time is generated randomly between the specified range to avoid consistency.");
		lblMinutes.setBounds(199, 312, 100, 16);
		contentPane.add(lblMinutes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Path to installed firefox browser", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 344, 408, 47);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextField txtCprogramFilesxmozilla = new JTextField();
		if(osName=="windows")
			txtCprogramFilesxmozilla.setText("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		else if(osName=="linux") 
			txtCprogramFilesxmozilla.setText("/usr/bin/firefox");
		else if(osName=="mac") 
			txtCprogramFilesxmozilla.setText("/Applications/Firefox.app/Contents/MacOS/firefox-bin");
			
		txtCprogramFilesxmozilla.setBounds(6, 18, 396, 22);
		panel_1.add(txtCprogramFilesxmozilla);
		txtCprogramFilesxmozilla.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("a text file containg only url to profiles where you want to post. Use bot FB401 to get the list;https://www.fiverr.com/techxjunkie");
		panel_2.setBorder(new TitledBorder(null, "filename containing url to friend's profile", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(16, 402, 394, 47);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("a text file containg only url to profiles where you want to post. Use bot FB401 to get the list;https://www.fiverr.com/techxjunkie");
		textField.setBounds(124, 18, 258, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblFilename = new JLabel("filename: ");
		lblFilename.setToolTipText("a text file containg only url to profiles where you want to post. Use bot FB401 to get the list;https://www.fiverr.com/techxjunkie");
		lblFilename.setBounds(12, 21, 100, 16);
		panel_2.add(lblFilename);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "what to post?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(12, 462, 408, 140);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 23, 374, 104);
		panel_3.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setForeground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(textArea);
		textArea.setToolTipText("what to post?");
		
		JButton btnExecute = new JButton("Next >>");
		
		try {
			BufferedReader br=new BufferedReader(new FileReader(".tmp"));
			txtusername.setText(dec(br.readLine()));
			((JPasswordField) passwordField).setText(dec(br.readLine()));
			textField_1.setText(dec(br.readLine()));
			 textField_2.setText(dec(br.readLine()));
			slider.setValue(Integer.parseInt(dec(br.readLine())));
			 textField_3.setText(dec(br.readLine()));
			 textField_4.setText(dec(br.readLine()));
			 txtCprogramFilesxmozilla.setText(dec(br.readLine()));
			 textField.setText(dec(br.readLine()));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
			try{
				 username = txtusername.getText();
				 password =new String(((JPasswordField) passwordField).getPassword());
				 rangeMin = Integer.parseInt(textField_1.getText());
				 rangeMax = Integer.parseInt(textField_2.getText());
				 confirmations=slider.getValue();
				 waveMin = Integer.parseInt(textField_3.getText());
				 waveMax = Integer.parseInt(textField_4.getText());
				 fpath=txtCprogramFilesxmozilla.getText();
				 filename=textField.getText();
				 post = textArea.getText();
				 
				 if(confirmations<1)
						JOptionPane.showMessageDialog(null,"confirmations ="+confirmations+" ,But why? anyways your wish"); 
				 
					if(username.length()>0 && password.length()>0 && rangeMin>=1 && rangeMax<Integer.MAX_VALUE && confirmations<=500 && waveMin>0 && waveMax<Integer.MAX_VALUE && fpath!=null && filename.length()>0&&post.length()>0)
						if(rangeMin<rangeMax && waveMin<waveMax )
							process(osName,botName);
						else
							JOptionPane.showMessageDialog(null,"Min is always less than Max :P");
						
					else 
						JOptionPane.showMessageDialog(null,"Please Input all field");
			}
			catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Invalid input");
			}
			}
		});
		btnExecute.setBounds(166, 615, 97, 25);
		contentPane.add(btnExecute);
		
	}
	Execute uInput = null;
	private JTextField textField;
	public void process(String osName,String botName){
		dispose();	
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(".tmp"));
			String wr=enc(username)+"\n"+enc(password)+"\n"+enc(Integer.toString(rangeMin))+"\n"+enc(Integer.toString(rangeMax))+"\n"+enc(Integer.toString(confirmations))+"\n"+enc(Integer.toString(waveMin))+"\n"+enc(Integer.toString(waveMax))+"\n"+enc(fpath)+"\n"+enc(filename);
			bw.write(wr);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		uInput = new Execute(osName,botName,username,password,rangeMin,rangeMax,confirmations,waveMin,waveMax,fpath,filename,post);
		uInput.setVisible(true);
	}
	
	static String enc(String text) {
		String key = "TheStrongestPasswordInTheWorld!!"; // 256 bit key
        byte[] encrypted = null;
        try {
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            encrypted = cipher.doFinal(text.getBytes());
           }
        catch(Exception e) {
            e.printStackTrace();
        }
		return (new String(encrypted));
	}
	static String dec(String text) {
		String key = "TheStrongestPasswordInTheWorld!!"; // 256 bit key
        String decrypted=null;
        try {
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");

            // decrypt the text
           cipher.init(Cipher.DECRYPT_MODE, aesKey);
           decrypted = new String(cipher.doFinal(text.getBytes()));
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
		return (new String(decrypted));
	}
}
