package register;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Register {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldUsername;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldAddress;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1003, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(35, 22, 203, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(161, 92, 77, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(134, 132, 104, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(134, 175, 114, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm password :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(73, 225, 165, 24);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(168, 277, 59, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Phone :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(161, 319, 99, 19);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(146, 349, 114, 22);
		frame.getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","9547");
					String sql="INSERT INTO registration(Name,Username,Password,ConfirmPassword,Email,Phone,Address)VALUES (?,?,?,?,?,?,?)";
					PreparedStatement pr=con.prepareStatement(sql);
					pr.setString(1,textFieldName.getText());
					pr.setString(2, textFieldUsername.getText());
					pr.setString(3, passwordField.getText());
					pr.setString(4, passwordField_1.getText());
					pr.setString(5, textFieldEmail.getText());
					pr.setString(6, textFieldPhone.getText());
					pr.setString(7, textFieldAddress.getText());
					int count=pr.executeUpdate();
					if(count==1) {
						JOptionPane.showMessageDialog(null, "Record added succesfully");
						textFieldName.setText("");
						textFieldUsername.setText("");
						passwordField.setText("");
						passwordField_1.setText("");
						textFieldEmail.setText("");
						textFieldPhone.setText("");
						textFieldAddress.setText("");
						con.close();
					}
					else {
						JOptionPane.showMessageDialog(null, "No record added");
						con.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace(); // print the stack trace for debugging
		            JOptionPane.showMessageDialog(null, "Error: " + e2.getMessage());
				}
			}
		});
		btnNewButton.setBounds(328, 397, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(676, 397, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(317, 97, 448, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(317, 141, 448, 20);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(317, 277, 448, 20);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(317, 319, 448, 20);
		frame.getContentPane().add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(317, 353, 448, 20);
		frame.getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(317, 188, 448, 20);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(317, 230, 448, 20);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 textFieldName.setText("");
			        textFieldUsername.setText("");
			        passwordField.setText("");
			        passwordField_1.setText("");
			        textFieldEmail.setText("");
			        textFieldPhone.setText("");
			        textFieldAddress.setText("");
			}
		});
		btnNewButton_1.setBounds(507, 397, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
