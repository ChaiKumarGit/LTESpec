package chai.lte;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;


public class LTESpec extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmLteSpec;
	private JTextPane textPaneAttachHex;
	private JTextPane textPaneNRUECapHex;
	
	static JTextPane textPaneAttachDecoded;
	static JTextPane textPaneNRUECapDecoded;
	static JDialog inProgressDialog,completeDialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LTESpec window = new LTESpec();
					window.frmLteSpec.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	    Runtime.getRuntime().addShutdownHook(new Thread (new Runnable() {
	        public void run() {
	            System.out.println("In shutdown hook");

	        }
	    }, "Shutdown-thread"));
	    
	}

	/**
	 * Create the application.
	 */
	public LTESpec() {
			initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() {
		frmLteSpec = new JFrame();
		frmLteSpec.setResizable(false);
		frmLteSpec.setTitle(Data.appName +""+ Data.version);
		frmLteSpec.setBounds(1, 1, 1350, 700);
		frmLteSpec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmLteSpec.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Wireshark");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Data.wireSharkPath = JOptionPane.showInputDialog(null,
		                "Wireshark Path:", Data.wireSharkPath);
			}
			
		});
		mnNewMenu.add(mntmNewMenuItem);
		frmLteSpec.getContentPane().setLayout(null);
		
		JPanel panelHex = new JPanel();
		panelHex.setBorder(new TitledBorder(null, "Hex", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelHex.setBounds(10, 11, 1324, 269);
		frmLteSpec.getContentPane().add(panelHex);
		panelHex.setLayout(null);
		
		JPanel panelAttachHex = new JPanel();
		panelAttachHex.setBorder(new TitledBorder(null, "Attach Request", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAttachHex.setBounds(10, 22, 437, 242);
		panelHex.add(panelAttachHex);
		panelAttachHex.setLayout(null);
		
		textPaneAttachHex = new JTextPane();
		JScrollPane scrollAttachHex = new JScrollPane ( textPaneAttachHex );
		scrollAttachHex.setBounds(10, 23, 417, 207);
		scrollAttachHex.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		panelAttachHex.add(scrollAttachHex);
		
		JPanel panelUECapHex_1 = new JPanel();
		panelUECapHex_1.setLayout(null);
		panelUECapHex_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "UE Capability", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelUECapHex_1.setBounds(457, 22, 857, 242);
		panelHex.add(panelUECapHex_1);
		
		textPaneNRUECapHex = new JTextPane();
		JScrollPane scrollUECapHex_1 = new JScrollPane(textPaneNRUECapHex);
		scrollUECapHex_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollUECapHex_1.setBounds(10, 22, 837, 207);
		panelUECapHex_1.add(scrollUECapHex_1);
		
		JPanel panelDecoded = new JPanel();
		panelDecoded.setLayout(null);
		panelDecoded.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Decoded", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDecoded.setBounds(10, 280, 1324, 329);
		frmLteSpec.getContentPane().add(panelDecoded);
		
		JPanel panelAttachDecoded = new JPanel();
		panelAttachDecoded.setLayout(null);
		panelAttachDecoded.setBorder(new TitledBorder(null, "Attach Request", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAttachDecoded.setBounds(10, 22, 437, 296);
		panelDecoded.add(panelAttachDecoded);
		
		textPaneAttachDecoded = new JTextPane();
		textPaneAttachDecoded.setBackground(new Color(248, 248, 255));
		textPaneAttachDecoded.setEditable(false);
		JScrollPane scrollAttachDecoded = new JScrollPane(textPaneAttachDecoded);
		scrollAttachDecoded.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollAttachDecoded.setBounds(10, 23, 417, 262);
		panelAttachDecoded.add(scrollAttachDecoded);
		
		
		JPanel panelUECapDecoded_1 = new JPanel();
		panelUECapDecoded_1.setLayout(null);
		panelUECapDecoded_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "UE Capability", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelUECapDecoded_1.setBounds(457, 22, 857, 296);
		panelDecoded.add(panelUECapDecoded_1);
		
		textPaneNRUECapDecoded = new JTextPane();
		textPaneNRUECapDecoded.setBackground(new Color(248, 248, 255));
		textPaneNRUECapDecoded.setEditable(false);
		JScrollPane scrollUECapHexDecoded_1 = new JScrollPane(textPaneNRUECapDecoded);
		scrollUECapHexDecoded_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollUECapHexDecoded_1.setBounds(10, 22, 837, 263);
		panelUECapDecoded_1.add(scrollUECapHexDecoded_1);
		
		JButton btnParse = new JButton("Parse");
		btnParse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(showInProgress()) {
						resetValues();
						rawtoHex();
						Parse.convert();
						Parse.parseXML();
						Parse.writeToExcel();
						deleteFiles();
						
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally{
					deleteFiles();
					showComplete();
				}

			}
		});
		btnParse.setBounds(557, 609, 227, 30);
		frmLteSpec.getContentPane().add(btnParse);
			
	}
	
	boolean showInProgress() {
        // create a dialog Box 
        inProgressDialog = new JDialog(frmLteSpec, "In Process.."); 

        // create a label 
        JLabel lable = new JLabel("In Progress..."); 
        inProgressDialog.getContentPane().add(lable); 

        // setsize of dialog 
        inProgressDialog.setSize(700, 100); 

        // set visibility of dialog 
        inProgressDialog.setVisible(true); 
        
        return true;
	}
	
	boolean showComplete() {
		
		//Close previous dialog Box
		inProgressDialog.dispose();
		
        // create a dialog Box 
		completeDialog = new JDialog(frmLteSpec, "Sucess"); 

        // create a label 
        JLabel lable = new JLabel("Excel sheet created at "+System.getProperty("user.dir")+" directory"); 
        completeDialog.getContentPane().add(lable); 

        // setsize of dialog 
        completeDialog.setSize(700, 100); 

        // set visibility of dialog 
        completeDialog.setVisible(true); 
        
        return true;
	}
	void rawtoHex() {
		String attachRaw = textPaneAttachHex.getText();
		String ueCapNRRaw = textPaneNRUECapHex.getText();
		
		attachRaw = attachRaw.replaceAll(Data.newLine,"");
		attachRaw = attachRaw.replaceAll("[^a-zA-Z0-9]","");
		attachRaw = attachRaw.replaceAll("0x","");
		attachRaw = attachRaw.replaceAll("(.{" + 2 + "})", "$1 ").trim();
		
		Data.attachHex = attachRaw.substring(attachRaw.indexOf("07 41"));
		textPaneAttachHex.setText(attachRaw);
		Data.attachHex = Data.hexStartBits + Data.attachHex;
		
		ueCapNRRaw = ueCapNRRaw.replaceAll(Data.newLine,"");
		ueCapNRRaw = ueCapNRRaw.replaceAll("[^a-zA-Z0-9]","");
		ueCapNRRaw = ueCapNRRaw.replaceAll("0x","");
		ueCapNRRaw = ueCapNRRaw.replaceAll("(.{" + 2 + "})", "$1 ").trim();
		
		if(ueCapNRRaw.indexOf("38 02")>=0) {
			Data.ueCapNRHex = ueCapNRRaw.substring(ueCapNRRaw.indexOf("38 02"));
		} else
		if(ueCapNRRaw.indexOf("38 01")>=0) {
			Data.ueCapNRHex = ueCapNRRaw.substring(ueCapNRRaw.indexOf("38 01"));
		}	
		
		textPaneNRUECapHex.setText(ueCapNRRaw);
		Data.ueCapNRHex = Data.hexStartBits + Data.ueCapNRHex;
	}
	
	void resetValues() {
		Data.attachHex = "";
		Data.ueCapHex = "";
		Data.ueCapNRHex = "";
		
		Parse.excelRow = 0;
	    Parse.excelCol = 0;
	    
		textPaneAttachDecoded.setText(null);
		textPaneNRUECapDecoded.setText(null);
		
		//Create Empty Element List
		Data.createElementList();
	}
	
	static void deleteFiles() {
		try
        { 
            Files.deleteIfExists(Paths.get("attachHexData.txt")); 
            Files.deleteIfExists(Paths.get("attachTemp.pcap"));
            Files.deleteIfExists(Paths.get("attach.xml"));
            
            Files.deleteIfExists(Paths.get("ueNRCapHexData.txt")); 
            Files.deleteIfExists(Paths.get("ueNRCap.pcap"));
            Files.deleteIfExists(Paths.get("ueNRCap.txt"));
            Files.deleteIfExists(Paths.get("ueNRCap.xml"));
            
	        //Clear IEs for next run
	        Data.attachIEsElementList = new Vector<List>();
	    	Data.attachIEValues = new String[Data.attachIEs.length][][];
	        Data.lteUECapIEsElementList = new Vector<List>();
	        Data.lteUECapIEValues = new String[Data.lteUECapIEs.length][][];
	        Data.nrUECapIEsElementList = new Vector<List>();
	    	Data.nrUECapIEValues = new String[Data.nrUECapIEs.length][][];
	    	Data.bandIEsElementList = new Vector<List<List>>();
            
        } 
        catch(NoSuchFileException e) 
        { 
            System.out.println("No such file/directory exists"); 
        } 
        catch(DirectoryNotEmptyException e) 
        { 
            System.out.println("Directory is not empty."); 
        } 
        catch(IOException e) 
        { 
            System.out.println("Invalid permissions."); 
        } 
          
        System.out.println("Deletion successful."); 
	}
}
