import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JEditorPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class generator_window {

	private JFrame frame;
	private JTextField PlanetName;
	private JEditorPane TextWindow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					generator_window window = new generator_window();
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
	public generator_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 55, 45));
		
		JButton GENERATE = new JButton("GENERATE");
		GENERATE.addActionListener(new ActionListener() {
			
			
			
			//GENERATE
			
			public void actionPerformed(ActionEvent arg0) {
				
				generatePlanet();
				
				
			}
		});
		GENERATE.setFont(new Font("Verdana", Font.BOLD, 14));
		GENERATE.setForeground(new Color(255, 255, 0));
		GENERATE.setBackground(new Color(51, 153, 0));
		
		PlanetName = new JTextField();
		PlanetName.setFont(new Font("Yu Gothic Light", Font.BOLD, 14));
		PlanetName.setBackground(new Color(255, 255, 255));
		PlanetName.setHorizontalAlignment(SwingConstants.CENTER);
		PlanetName.setText("--random name--");
		PlanetName.setColumns(10);
		
		JLabel lblPlanetName = new JLabel("PLANET NAME");
		lblPlanetName.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblPlanetName.setForeground(new Color(255, 255, 0));
		
		TextWindow = new JEditorPane();
		TextWindow.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		TextWindow.setForeground(Color.BLACK);
		TextWindow.setBackground(Color.WHITE);
		TextWindow.setEditable(false);
		TextWindow.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		TextWindow.setToolTipText("");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(125)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(PlanetName, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(TextWindow, GroupLayout.PREFERRED_SIZE, 679, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(GENERATE, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblPlanetName))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addComponent(lblPlanetName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(TextWindow, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(PlanetName, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 441, Short.MAX_VALUE)
							.addComponent(GENERATE, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addGap(75))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	
	
	//generates a new planet
	
	
	Planet testPlanet;
	private void generatePlanet(){

		
		if (PlanetName.getText().equals("--random name--")){
			
			
			testPlanet = new Planet();
		    
		    
			
		}
		else
		testPlanet = new Planet(PlanetName.getText());
		
		
		
		TextWindow.setText(testPlanet.toString());
		
	}
}
