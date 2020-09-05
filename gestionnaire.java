import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gestionnaire {

	private JFrame frame;
	private JTextField textField;
	private int nbtZF;
	private int nbtZNF;
	private int i=0,j=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestionnaire window = new gestionnaire();
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
	public gestionnaire() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 586, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Bienvenu Sur Notre Restaurant ");
		label.setForeground(new Color(250, 128, 114));
		label.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
		label.setBounds(44, 11, 491, 54);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Vous \u00EAtes combien");
		label_1.setForeground(new Color(0, 206, 209));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(42, 100, 154, 24);
		frame.getContentPane().add(label_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())){
			           e.consume();
			       }
			}
		});
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		
		comboBox.setBounds(240, 104, 88, 20);
		frame.getContentPane().add(comboBox);
		
		
		JLabel label_2 = new JLabel("Vous \u00EAtes des Fumeurs");
		label_2.setForeground(new Color(0, 206, 209));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(42, 150, 154, 24);
		frame.getContentPane().add(label_2);
		
		JRadioButton radioButton = new JRadioButton("Fumeur");
		radioButton.setBounds(198, 153, 69, 23);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Non Fumeur");
		radioButton_1.setBounds(282, 153, 109, 23);
		frame.getContentPane().add(radioButton_1);
		ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton);
        bg.add(radioButton_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(245, 222, 179));
		textField.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBounds(44, 204, 338, 54);
		frame.getContentPane().add(textField);
		
		JButton button = new JButton("Termin\u00E9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radioButton.isSelected())
				{
					if(i==20)
					{
						textField.setText(" Desole,Toutes les tables de la zone fumeur sont occuper ");
					}
					while(i<20)
					{ 
						textField.setText(" Dans la zone non fumeur , Aller a la table num° "+(i+1));
						nbtZF=nbtZF+i;
						i++;
						break;
					}
				}
				if(radioButton_1.isSelected())
				{
					if(j==20)
					{
						textField.setText(" Desole ,Toutes les tables de la zone non fumeur sont occuper ");
					}
					
					while(j<20)
					{ 
						textField.setText(" Dans la zone fumeur , Aller a la table num° "+(j+1));
						nbtZNF=nbtZNF+j;
						j++;
						break;
					}
				}
			}
		});
		
		JButton btnProprietaire = new JButton("Proprietaire");
		btnProprietaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tauxZF;
				tauxZF=(nbtZF*100)/20;
				textField.setText(" Le taux d'occupation sur la zone fumeur est "+tauxZF+"%");
				int tauxZNF;
				tauxZNF=(nbtZNF*100)/20;
				textField.setText(" Le taux d'occupation sur la zone fumeur est "+tauxZNF+"%");
				textField.setText(" Le taux d'occupation totale "+(tauxZNF+tauxZF)+"%");
				
			}
		});
		btnProprietaire.setForeground(Color.RED);
		btnProprietaire.setFont(new Font("Snap ITC", Font.PLAIN, 13));
		btnProprietaire.setBounds(44, 279, 128, 35);
		frame.getContentPane().add(btnProprietaire);
		button.setFont(new Font("Snap ITC", Font.PLAIN, 13));
		button.setBounds(254, 279, 128, 35);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\_a1a8429.jpg"));
		lblNewLabel.setBounds(-503, -358, 1125, 837);
		frame.getContentPane().add(lblNewLabel);
	}
}
