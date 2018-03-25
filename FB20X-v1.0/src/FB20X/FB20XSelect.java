package FB20X;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FB20XSelect {
	String osName="windows";
	String botName="FB101";
	JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FB20XSelect window = new FB20XSelect();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FB20XSelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNext = new JButton("Next >>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null,"input accepted");
				frame.dispose();	
				Configuration config= new Configuration(osName,botName);
				config.setVisible(true);
			}
		});
		btnNext.setBounds(323, 315, 97, 25);
		frame.getContentPane().add(btnNext);
		
		JRadioButton bot101 = new JRadioButton("FB201 - post on all friend's wall");
		bot101.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botName="FB101";
			}
		});
		bot101.setSelected(true);
		bot101.setBounds(8, 250, 412, 25);
		frame.getContentPane().add(bot101);
		
		ButtonGroup groupBot = new ButtonGroup();
		groupBot.add(bot101);
		
		JRadioButton rdbtnMacOsX = new JRadioButton("Mac OS X");
		rdbtnMacOsX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				osName = "mac";
			}
		});
		rdbtnMacOsX.setBounds(8, 191, 412, 25);
		frame.getContentPane().add(rdbtnMacOsX);
		
		JRadioButton rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				osName = "windows";
			}
		});
		rdbtnWindows.setSelected(true);
		rdbtnWindows.setBounds(8, 131, 412, 25);
		frame.getContentPane().add(rdbtnWindows);
		
		JRadioButton rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				osName = "linux";
			}
		});
		rdbtnLinux.setBounds(8, 161, 412, 25);
		frame.getContentPane().add(rdbtnLinux);
		
		JLabel lblSelectBot = new JLabel("Select Bot");
		lblSelectBot.setBounds(8, 225, 97, 16);
		frame.getContentPane().add(lblSelectBot);
		
		ButtonGroup groupOs = new ButtonGroup();
		groupOs.add(rdbtnMacOsX);
		groupOs.add(rdbtnWindows);
		groupOs.add(rdbtnLinux);
			
		
		JLabel lblSelectOperatingSystem = new JLabel("Select Operating System");
		lblSelectOperatingSystem.setBounds(8, 106, 412, 16);
		frame.getContentPane().add(lblSelectOperatingSystem);
		
		JLabel lblFacebookAutoposter = new JLabel("Facebook auto-poster");
		lblFacebookAutoposter.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacebookAutoposter.setBounds(12, 77, 408, 16);
		frame.getContentPane().add(lblFacebookAutoposter);
		
		JLabel lblFbx = new JLabel("FB20X-v1.0");
		lblFbx.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblFbx.setHorizontalAlignment(SwingConstants.CENTER);
		lblFbx.setBounds(8, 13, 412, 80);
		frame.getContentPane().add(lblFbx);
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("data"+File.separator+"logo.png"));
		} catch (IOException e) {
		}
	}
}
