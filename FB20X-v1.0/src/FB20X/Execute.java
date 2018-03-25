package FB20X;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Execute extends JFrame {

	private JPanel contentPane;
	static boolean stop=false;
	static JLabel lblStatus_1;
	JTextArea textArea;
	JLabel lblFriends_1;
	JLabel lblPosts;
	/**
	 * Create the frame.
	 */
	public Execute(String osName,String botName,String username,String password,int rangeMin,int rangeMax,int confirmations,int waveMin,int waveMax,String fpath,String filename,String post) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Logs", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(386, 13, 486, 427);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 466, 395);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.LIGHT_GRAY);
		textArea.setBackground(Color.DARK_GRAY);
		scrollPane.setViewportView(textArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Configuration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(16, 13, 360, 427);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(12, 47, 110, 16);
		panel_1.add(lblUsername);
		
		JLabel lblUsername_1 = new JLabel(username);
		lblUsername_1.setBounds(134, 47, 277, 16);
		panel_1.add(lblUsername_1);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(12, 189, 110, 16);
		panel_1.add(lblStatus);
		
		JLabel lblFriends = new JLabel("Total Friends:");
		lblFriends.setBounds(12, 76, 110, 16);
		panel_1.add(lblFriends);
		
		lblFriends_1 = new JLabel();
		lblFriends_1.setBounds(134, 76, 277, 16);
		panel_1.add(lblFriends_1);
		
		JLabel lblPostsMade = new JLabel("Posts made:");
		lblPostsMade.setBounds(12, 105, 110, 16);
		panel_1.add(lblPostsMade);
		
		lblPosts = new JLabel("0");
		lblPosts.setBounds(134, 105, 277, 16);
		panel_1.add(lblPosts);
		
		lblStatus_1 = new JLabel("starting new browser session...");
		lblStatus_1.setBounds(134, 189, 277, 16);
		panel_1.add(lblStatus_1);
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("data"+File.separator+"logo.png"));
		} catch (IOException e) {
		}
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 336, 30, 30);
		panel_1.add(panel_3);
		
		BufferedImage btcReader = null;
		try {
			btcReader = ImageIO.read(new File("data"+File.separator+"btc.png"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"./data folder not found!");
		}
		JLabel btc = new JLabel(new ImageIcon(btcReader));
		panel_3.add(btc);
		
		JLabel lblCopyright = new JLabel("Copyright \u00A9 2017 zxcV32 | Email: c34r534w@gmail.com");
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setBounds(12, 398, 338, 16);
		panel_1.add(lblCopyright);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stop=true;
			}
		});
		btnStop.setBounds(100, 242, 110, 60);
		panel_1.add(btnStop);
		
		JLabel lblNewLabel = new JLabel("1D7AM8f1zeoh4XxZaRDnzQpWxwAGeQ4FVk");
		lblNewLabel.setBounds(52, 336, 298, 30);
		panel_1.add(lblNewLabel);
		
		JLabel lblWaveTime = new JLabel("Wave time:");
		lblWaveTime.setBounds(12, 157, 97, 14);
		panel_1.add(lblWaveTime);
		
		JLabel lblNewLabel_1 = new JLabel(waveMin+" - "+waveMax+" minutes");
		lblNewLabel_1.setBounds(134, 157, 277, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblConfirmaions = new JLabel("Confirmaions:");
		lblConfirmaions.setBounds(12, 132, 97, 14);
		panel_1.add(lblConfirmaions);
		
		JLabel lblNewLabel_2 = new JLabel(confirmations+" in one wave");
		lblNewLabel_2.setBounds(134, 132, 277, 14);
		panel_1.add(lblNewLabel_2);
		
		
		Thread FB201=new Thread(){
			public void run(){
				try {
					fb201(osName,botName,username,password,rangeMin,rangeMax,confirmations,waveMin,waveMax,fpath,filename,post);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		FB201.start();	
	
	}
	
	void fb201(String osName,String botName,String username,String password,int rangeMin,int rangeMax,int confirmations,int waveMin,int waveMax,String fpath,String filename,String post) throws IOException, InterruptedException{

		BufferedReader br1;
		BufferedWriter br2;
		String line;
		try{	
			br1=new BufferedReader(new FileReader(filename));
	}
	catch(FileNotFoundException x){
		br2 = new BufferedWriter(new FileWriter("error_log", true));
		br2.write(">>"+x.toString()+"\n");
		br2.close();
		textArea.append("Error reading file "+filename+", check if this exist and has read permission\n");
		lblStatus_1.setText("can not read "+filename);
		return;
		}

		ArrayList <String> friends = new ArrayList<String>();

		while((line=br1.readLine())!=null){
			try{
			if(line.length()!=0)
				friends.add(line);
			}
			catch(Exception x){	
				br2 = new BufferedWriter(new FileWriter("error_log", true));
				br2.write(">>"+x.toString()+"\n");
				br2.close();
				textArea.append("can not read "+filename+"\n");
				lblStatus_1.setText("error");
				return;
			}
		}
		lblFriends_1.setText(Integer.toString(friends.size()));

		/*
		 * 	    for(int i=0;i<friends.size();++i){
		    System.out.println(friends.get(i));
	    }*/
	    String executableLocation = null;
	    WebDriver driver = null;
	    try{
	    
	    	if(osName=="windows")
			executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver.exe";
		else 
			executableLocation=System.getProperty("user.dir")+File.separator+"data"+File.separator+osName+File.separator+"geckodriver"; 
	    
				System.setProperty("webdriver.gecko.driver",executableLocation);
				driver=new FirefoxDriver();
				}
	catch(Exception x){
		br2 = new BufferedWriter(new FileWriter("error_log", true));
		br2.write(">>"+x.toString()+"\n");
		textArea.append(">>ERROR<<\nPossible causes:\n1) either \""+executableLocation+"\" do not exist or does not have execute permission\n2) Path of firefox is wrong!\n");
		textArea.append("FireFox Path: "+fpath);
		lblStatus_1.setText("firefox error");
		return;
	}
		if(stop) {
			textArea.append("stopped by the user...\n");
			lblStatus_1.setText("Exiting...");
			driver.close();
			return;
		}
		//LOGIN 
		lblStatus_1.setText("Logging In");
		driver.get("https://www.facebook.com/?_rdr=p");	
		(driver.findElement(By.id("email"))).sendKeys(username);
		(driver.findElement(By.id("pass"))).sendKeys(password); 
		(driver.findElement(By.id("loginbutton"))).submit();
	
		Thread.sleep(5000);
	    
	    //LOGIN END
		if(stop) {
			textArea.append("stopped by the user...\n");
			lblStatus_1.setText("Exiting...");
			driver.close();
			return;
		}
		
		long timec;int timew = 0;int i=0,abort=0;int count=-1;
		BufferedReader brFriend=null;
		BufferedWriter posted=null;
		BufferedWriter notposted=null;
				System.out.println("Reading IDs from "+filename);
				
				try{
					brFriend=new BufferedReader(new FileReader(filename));
				}catch(Exception e){
					try{
					br2 = new BufferedWriter(new FileWriter("error_log", true));
					br2.write(">>"+e.toString()+"\n");
					br2.close();}catch(Exception x){}
					driver.close();
					textArea.append("Error: filename "+filename+" not found\nExiting the program...");
					System.exit(-31);
				}
					try {
						while((line=brFriend.readLine())!=null&&(line.length()>3)){
							lblPosts.setText(Integer.toString(count+1));
							++i;++count;
							if(stop) {
								textArea.append("stopped by the user...\n");
								lblStatus_1.setText("Exiting...");
								break;
							}
							  if(abort>10){
								 textArea.append("10 successive failed posts\nExiting the program...\n");
								  brFriend.close();
								 break;
							  }							 
							  try{
								  driver.get(friends.get(count));
								  lblStatus_1.setText("posting...");
								  textArea.append("posting to "+friends.get(count)+"\n");
								  timec = (long) (Math.random()*(rangeMax-rangeMin)+rangeMin)*1000;
								  Thread.sleep(timec);
								  driver.findElement(By.xpath(".//textarea")).sendKeys(post);
								  driver.findElement(By.xpath(".//*[@id='timelineBody']/div[1]/div[1]/form/table/tbody/tr/td[2]/div/input")).click();			
								  lblStatus_1.setText("refreshing");
								  Thread.sleep(1500);
								  driver.navigate().refresh();
								  abort=0;								  
							  }
							  catch(Exception e){
									br2 = new BufferedWriter(new FileWriter("error_log", true));
									br2.write(">>"+e.toString()+"\n");
									br2.close();
							  ++abort;
							  lblStatus_1.setText("Error");
							  textArea.append("Error:skipping url="+friends.get(count)+"\n");
							  }
							 if(i==confirmations){
								i=0;
								  timew = (int) (Math.random()*(waveMax-waveMin)+waveMin)*60;
								  textArea.append("\n-----------------------------------\nwaiting for ext wave\n");
								  for(;timew>0;--timew){
									  if(stop) {
											break;
										}
									  Thread.sleep(1000);
									  lblStatus_1.setText("starts in: "+Integer.toString(timew));
								  }
							 }
						}if (line==null){
							System.out.println("posted on all walls! Exiting now...");
							brFriend.close();
							br1.close();
							driver.quit();
								textArea.append("saving logs...\n");
								lblStatus_1.setText("Exiting...");
								driver.quit();
						}
						
					} catch (IOException | InterruptedException e) {
						lblStatus_1.setText("Error see logs");
						br2 = new BufferedWriter(new FileWriter("error_log", true));
						br2.write(">>"+e.toString()+"\n");
						br2.close();
						driver.quit();
					}
					lblStatus_1.setText("Exiting...");
					driver.quit();
					posted = new BufferedWriter(new FileWriter("posted_"+filename));
					posted.write(String.join("\n", friends.subList(0, count)));
					posted.close();			
					notposted = new BufferedWriter(new FileWriter("not_posted_"+filename));
					notposted.write(String.join("\n", friends.subList(count,friends.size())));
					notposted.close();					
		  }
	}

