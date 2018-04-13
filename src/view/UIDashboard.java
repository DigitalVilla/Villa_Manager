package view;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

public class UIDashboard {
	private JTextField txtfPasswordDash;
	private JTextField txtfUsernameDash;
	private JPanel contentPane;
	private JButton btnLogInDash;

	public UIDashboard(Color color1, Color color2, Color dark, Color dark2, Color light, Color graylight) {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0, 0));
		contentPane.setBounds(190, 0, 890, 621);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		contentPane.add(logInPanel(color1, color2, dark, dark2, light, graylight));
		bgPanel("calgary.jpg");
	}

	public JTextField getTxtfPasswordDash() {
		return txtfPasswordDash;
	}

	public void setTxtfPasswordDash(JTextField txtfPasswordDash) {
		this.txtfPasswordDash = txtfPasswordDash;
	}

	public JTextField getTxtfUsernameDash() {
		return txtfUsernameDash;
	}

	public void setTxtfUsernameDash(JTextField txtfUsernameDash) {
		this.txtfUsernameDash = txtfUsernameDash;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnLogInDash() {
		return btnLogInDash;
	}

	//LOG IN CLIENT PANNEL
	public JPanel logInPanel(Color color1, Color color2, Color dark, Color dark2, Color light, Color graylight) {
		JPanel panelLogInDash = new JPanel();
		panelLogInDash.setBounds(160, 112, 571, 393);
		panelLogInDash.setBackground(new Color(50, 60, 80, 150));
		panelLogInDash.setLayout(null);
		panelLogInDash.setVisible(true);

		//		Settings icon
		JLabel lblSettingsDash = new JLabel("");
		lblSettingsDash.setForeground(new Color(255, 255, 255));
		lblSettingsDash.setBounds(531, 352, 30, 30);
		lblSettingsDash.setIcon(new ImageIcon(("res/icons/settings.png")));
		panelLogInDash.add(lblSettingsDash);

		btnLogInDash = new JButton("LOG IN");
		btnLogInDash.setFocusPainted(false);
		btnLogInDash.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnLogInDash.setBackground(color1);
		btnLogInDash.setForeground(new Color(240, 240, 250));
		btnLogInDash.setBounds(103, 305, 360, 45);
		btnLogInDash.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelLogInDash.add(btnLogInDash);

		txtfPasswordDash = new JTextField();
		txtfPasswordDash.setFont(new Font("Lato", Font.PLAIN, 18));
		txtfPasswordDash.setForeground(new Color(248, 248, 255));
		txtfPasswordDash.setBackground(graylight.darker());
		txtfPasswordDash.setBounds(103, 220, 360, 40);
		txtfPasswordDash.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelLogInDash.add(txtfPasswordDash);
		txtfPasswordDash.setColumns(10);

		txtfUsernameDash = new JTextField();
		txtfUsernameDash.setFont(new Font("Lato", Font.PLAIN, 18));
		txtfUsernameDash.setForeground(new Color(248, 248, 255));
		txtfUsernameDash.setColumns(10);
		txtfUsernameDash.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtfUsernameDash.setBackground(graylight.darker());
		txtfUsernameDash.setBounds(103, 125, 360, 40);
		panelLogInDash.add(txtfUsernameDash);

		JLabel lblUsernameDash = new JLabel("Username");
		lblUsernameDash.setForeground(new Color(248, 248, 255));
		lblUsernameDash.setFont(new Font("Lato", Font.PLAIN, 16));
		lblUsernameDash.setBounds(103, 94, 100, 20);
		panelLogInDash.add(lblUsernameDash);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(248, 248, 255));
		lblPassword.setFont(new Font("Lato", Font.PLAIN, 16));
		lblPassword.setBounds(103, 189, 100, 20);
		panelLogInDash.add(lblPassword);

		JLabel lblTitleDash = new JLabel(" Villa Manager 2018 ");
		lblTitleDash.setBounds(139, 32, 313, 32);
		lblTitleDash.setBackground(new Color(0, 153, 204));
		lblTitleDash.setIcon(new ImageIcon(("res/icons/logo.png")));
		lblTitleDash.setForeground(new Color(240, 248, 255));
		lblTitleDash.setFont(new Font("Lato", Font.BOLD, 28));
		panelLogInDash.add(lblTitleDash);
		return panelLogInDash;
	}

	public void bgPanel(String image) {
		JLabel dashboardPanel = new JLabel("");
		dashboardPanel.setBounds(0, 0, 892, 621);
		dashboardPanel.setIcon(new ImageIcon(("res/images/" + image)));
		contentPane.add(dashboardPanel);
	}
}
