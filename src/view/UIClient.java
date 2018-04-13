package view;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

public class UIClient extends VillaGUI{
	private JTextField txtfPostalClientInfo;
	private JTextField txtfFirstNameClientInfo;
	private JTextField txtfLastNameClientInfo;
	private JTextField txtfAddressClientInfo;
	private JTextField txtPhoneClientInfo;
	private JComboBox<String> cBoxTypeClientInfo;
	private DefaultComboBoxModel<String> comboClientType;
	private JRadioButton rdbtnIdClientSearch;
	private JRadioButton rdbtnTypeClientSearch;
	private JRadioButton rdbtnLastNameClientSearch;

	/**
	 * The main constructor that draws all the elements in the Client JPanel
	 * @param color1 primary color
	 * @param color2 secondary color 
	 * @param dark primary black
	 * @param dark2 secondary black
	 * @param light primary white
	 * @param light2 secondary white 
	 * @return the contentPane
	 */
	public UIClient(Color color1, Color color2, Color dark, Color dark2, Color light, Color light2) {
		super(color1, color2, dark, dark2, light, light2);
		customInfoPanel();
		customSearchPanel();
	}

	/**
	 * This method returns the DefaultComboBoxModel for the type in the information JPanel 
	 * @return comboClientType
	 */
	public DefaultComboBoxModel<String> getComboClientType() {
		return comboClientType;
	}

	/**
	 * This method returns the JTextField for POSTAL CODE in the information JPanel 
	 * @return txtfPostalClientInfo
	 */
	public JTextField getTxtfPostalClientInfo() {
		return txtfPostalClientInfo;
	}

	/**
	 * This method returns the JTextField for FIRST NAME in the information JPanel 
	 * @return txtfFirstNameClientInfo
	 */
	public JTextField getTxtfFirstNameClientInfo() {
		return txtfFirstNameClientInfo;
	}

	/**
	 * This method returns the JTextField for LAST NAME in the information JPanel 
	 * @return txtfLastNameClientInfo
	 */
	public JTextField getTxtfLastNameClientInfo() {
		return txtfLastNameClientInfo;
	}

	/**
	 * * This method returns the JTextField for ADDRESS in the information JPanel
	 * @return txtfAddressClientInfo
	 */
	public JTextField getTxtfAddressClientInfo() {
		return txtfAddressClientInfo;
	}

	/**
	 * * This method returns the JTextField for PHONE in the information JPanel
	 * @return lblVatxtPhoneClientInfolidInfo
	 */
	public JTextField getTxtPhoneClientInfo() {
		return txtPhoneClientInfo;
	}

	/**
	 * * This method returns the JRadioButton for ID in the search JPanel
	 * @return rdbtnIdClientSearch
	 */
	public JRadioButton getRdbtnIdClientSearch() {
		return rdbtnIdClientSearch;
	}

	/**
	 * * This method returns the JRadioButton for TYPE in the search JPanel
	 * @return rdbtnLastNameClientSearch
	 */
	public JRadioButton getRdbtnTypeClientSearch() {
		return rdbtnTypeClientSearch;
	}

	/**
	 * * This method returns the JRadioButton for LAST NAME in the search JPanel
	 * @return rdbtnLastNameClientSearch
	 */
	public JRadioButton getRdbtnLastNameClientSearch() {
		return rdbtnLastNameClientSearch;
	}

	@Override
	public void customInfoPanel() {
		getTxtfIdInfo().setBounds(45, 126, 173, 35);

		txtfPostalClientInfo = new JTextField();
		txtfPostalClientInfo.setBackground(light);
		txtfPostalClientInfo.setBounds(45, 409, 131, 35);
		txtfPostalClientInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfPostalClientInfo);

		txtfFirstNameClientInfo = new JTextField();
		txtfFirstNameClientInfo.setBackground(light);
		txtfFirstNameClientInfo.setColumns(10);
		txtfFirstNameClientInfo.setBounds(45, 201, 339, 35);
		txtfFirstNameClientInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfFirstNameClientInfo);

		txtfLastNameClientInfo = new JTextField();
		txtfLastNameClientInfo.setBackground(light);
		txtfLastNameClientInfo.setColumns(10);
		txtfLastNameClientInfo.setBounds(45, 267, 339, 35);
		txtfLastNameClientInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfLastNameClientInfo);

		txtfAddressClientInfo = new JTextField();
		txtfAddressClientInfo.setBackground(light);
		txtfAddressClientInfo.setColumns(10);
		txtfAddressClientInfo.setBounds(45, 338, 339, 35);
		txtfAddressClientInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfAddressClientInfo);

		txtPhoneClientInfo = new JTextField();
		txtPhoneClientInfo.setBackground(light);
		txtPhoneClientInfo.setColumns(10);
		txtPhoneClientInfo.setBounds(211, 409, 173, 35);
		txtPhoneClientInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtPhoneClientInfo);

		String[] defaultType = new String[] { "", " C", " R" };
		comboClientType = new DefaultComboBoxModel<String>(defaultType);
		cBoxTypeClientInfo = new JComboBox<String>(comboClientType);
		cBoxTypeClientInfo.setBackground(light);
		cBoxTypeClientInfo.setFont(new Font("Lato", Font.PLAIN, 12));
		cBoxTypeClientInfo.setBounds(253, 125, 131, 35);
		cBoxTypeClientInfo.setBorder(null);
		getPanelInfo().add(cBoxTypeClientInfo);

		JLabel lblIdClientInfo = new JLabel("Client Id");
		lblIdClientInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblIdClientInfo.setBounds(45, 93, 112, 22);
		getPanelInfo().add(lblIdClientInfo);

		JLabel lblFirstNameClientInfo = new JLabel("First Name");
		lblFirstNameClientInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblFirstNameClientInfo.setBounds(45, 176, 80, 14);
		getPanelInfo().add(lblFirstNameClientInfo);

		JLabel lblLastNameClientInfo = new JLabel("Last Name");
		lblLastNameClientInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblLastNameClientInfo.setBounds(45, 247, 80, 14);
		getPanelInfo().add(lblLastNameClientInfo);

		JLabel lblAddressClientInfo = new JLabel("Address");
		lblAddressClientInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblAddressClientInfo.setBounds(45, 313, 100, 14);
		getPanelInfo().add(lblAddressClientInfo);

		JLabel lblPostalClientInfo = new JLabel("Postal Code");
		lblPostalClientInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblPostalClientInfo.setBounds(45, 384, 91, 14);
		getPanelInfo().add(lblPostalClientInfo);

		JLabel lblPhoneClientInfo = new JLabel("Phone Number");
		lblPhoneClientInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblPhoneClientInfo.setBounds(211, 384, 112, 14);
		lblPhoneClientInfo.setBorder(null);
		getPanelInfo().add(lblPhoneClientInfo);

		JLabel lblTypeClientInfo = new JLabel("Client Type");
		lblTypeClientInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblTypeClientInfo.setBounds(253, 93, 112, 22);
		getPanelInfo().add(lblTypeClientInfo);

		getLblTitleInfo().setText("  Client Information");
		getLblTitleInfo().setBounds(125, 20, 225, 27);
	}

	@Override
	public void customSearchPanel() {
		getRdBtnId().setText("Id");
		getRdBtnId().setBounds(32, 110, 58, 23);
		getRdBtnId().setFont(new Font("Lato", Font.PLAIN, 18));
		getRdBtn2().setText("Type");
		getRdBtn2().setBounds(118, 110, 67, 23);
		getRdBtn2().setFont(new Font("Lato", Font.PLAIN, 18));
		getRdBtn3().setText("Last Name");
		getRdBtn3().setBounds(218, 110, 109, 23);
		getRdBtn3().setFont(new Font("Lato", Font.PLAIN, 18));
		getRdBtn4().setVisible(false);
		getLblTitleSearch().setText("  Search Client");
		getLblTitleSearch().setBounds(96, 20, 183, 27);
	}
	
	@Override
	public void clearFields() {
		getTxtfIdInfo().setText("");
		comboClientType.setSelectedItem(" ");
		txtfFirstNameClientInfo.setText("");
		txtfLastNameClientInfo.setText("");
		txtfAddressClientInfo.setText("");
		txtfPostalClientInfo.setText("");
		txtPhoneClientInfo.setText("");
	}
}