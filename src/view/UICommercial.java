package view;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

public class UICommercial extends VillaGUI {
	private JTextField txtfFloorsComInfo;
	private JTextField txtfDescriptionComInfo;
	private JTextField txtfAddressComInfo;
	private JTextField txtfCommentsComInfo;
	private JTextField txtfPriceComInfo;
	private JComboBox<String> cBoxTypeComInfo;
	private JComboBox<String> cBoxZoningComInfo;
	private JComboBox<String> cBoxQuadrantComInfo;
	private DefaultComboBoxModel<String> comboComType;
	private DefaultComboBoxModel<String> comboComZoning;
	private DefaultComboBoxModel<String> comboComQuadrant;
	private JRadioButton rdbtnQuadrantComSearch;
	private JRadioButton rdbtnLegalComSearch;
	private JRadioButton rdbtnPriceComSearch;
	private JRadioButton rdbtnIdComSearch;

	/**
	 * The main constructor that draws all the elements in the Commercial JPanel
	 * @param color1 primary color
	 * @param color2 secondary color 
	 * @param dark primary black
	 * @param dark2 secondary black
	 * @param light primary white
	 * @param light2 secondary white 
	 * @return the contentPane
	 */
	public UICommercial(Color color1, Color color2, Color dark, Color dark2, Color light, Color light2) {
		super(color1, color2, dark, dark2, light, light2);
		customInfoPanel();
		customSearchPanel();
	}

	/**
	 * * This method returns the JComboBox<String> for TYPE in the information JPanel
	 * @return cBoxTypeComInfo
	 */
	public JComboBox<String> getcBoxTypeComInfo() {
		return cBoxTypeComInfo;
	}

	/**
	 * * This method returns the JComboBox<String> for ZONING in the information JPanel
	 * @return cBoxZoningComInfo
	 */
	public JComboBox<String> getcBoxZoningComInfo() {
		return cBoxZoningComInfo;
	}

	/**
	 * * This method returns the JComboBox<String> for QAUDRANT in the information JPanel
	 * @return cBoxQuadrantComInfo
	 */
	public JComboBox<String> getcBoxQuadrantComInfo() {
		return cBoxQuadrantComInfo;
	}

	/**
	 * * This method returns the DefaultComboBoxModel<String> for TYPE in the information JPanel
	 * @return comboComType
	 */
	public DefaultComboBoxModel<String> getComboComType() {
		return comboComType;
	}

	/**
	 * * This method returns the DefaultComboBoxModel<String> for ZONING in the information JPanel
	 * @return comboComZoning
	 */
	public DefaultComboBoxModel<String> getComboComZoning() {
		return comboComZoning;
	}

	/**
	 * * This method returns the DefaultComboBoxModel<String> for QUARANT in the information JPanel
	 * @return comboComQuadrant
	 */
	public DefaultComboBoxModel<String> getComboComQuadrant() {
		return comboComQuadrant;
	}

	/**
	 * * This method returns the JTextField for FLOORS in the information JPanel
	 * @return txtfFloorsComInfo
	 */
	public JTextField getTxtfFloorsComInfo() {
		return txtfFloorsComInfo;
	}

	/**
	 * * This method returns the JTextField for LEGAL DESCRIPTION in the information JPanel
	 * @return txtfDescriptionComInfo
	 */
	public JTextField getTxtfDescriptionComInfo() {
		return txtfDescriptionComInfo;
	}

	/**
	 * * This method returns the JTextField for ADDRESS in the information JPanel
	 * @return txtfAddressClientInfo
	 */
	public JTextField getTxtfAddressComInfo() {
		return txtfAddressComInfo;
	}

	/**
	 * * This method returns the JTextField for COMMENTS in the information JPanel
	 * @return txtfCommentsComInfo
	 */
	public JTextField getTxtfCommentsComInfo() {
		return txtfCommentsComInfo;
	}

	/**
	 * * This method returns the JTextField for PRICE in the information JPanel
	 * @return txtfPriceComInfo
	 */
	public JTextField getTxtfPriceComInfo() {
		return txtfPriceComInfo;
	}

	/**
	 * * This method returns the JRadioButton for ID in the search JPanel
	 * @return rdbtnIdComSearch
	 */
	public JRadioButton getRdbtnIdComSearch() {
		return rdbtnIdComSearch;
	}

	/**
	 * * This method returns the JRadioButton for LEGAL DESCRIPTIONIN the search JPanel
	 * @return rdbtnLegalComSearch
	 */
	public JRadioButton getRdbtnLegalComSearch() {
		return rdbtnLegalComSearch;
	}

	/**
	 * * This method returns the JRadioButton for PRICE in the search JPanel
	 * @return rdbtnPriceComSearch
	 */
	public JRadioButton getRdbtnPriceComSearch() {
		return rdbtnPriceComSearch;
	}

	/**
	 * * This method returns the JRadioButton for QUADRANT in the search JPanel
	 * @return rdbtnQuadrantComSearch
	 */
	public JRadioButton getRdbtnQuadrantComSearch() {
		return rdbtnQuadrantComSearch;
	}

	@Override
	public void customInfoPanel() {
		getTxtfIdInfo().setBounds(45, 126, 82, 35);

		txtfFloorsComInfo = new JTextField();
		txtfFloorsComInfo.setBackground(light);
		txtfFloorsComInfo.setBounds(45, 338, 126, 35);
		txtfFloorsComInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfFloorsComInfo);

		txtfDescriptionComInfo = new JTextField();
		txtfDescriptionComInfo.setBackground(light);
		txtfDescriptionComInfo.setColumns(10);
		txtfDescriptionComInfo.setBounds(45, 201, 339, 35);
		txtfDescriptionComInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfDescriptionComInfo);

		txtfAddressComInfo = new JTextField();
		txtfAddressComInfo.setBackground(light);
		txtfAddressComInfo.setColumns(10);
		txtfAddressComInfo.setBounds(45, 267, 339, 35);
		txtfAddressComInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfAddressComInfo);

		txtfPriceComInfo = new JTextField();
		txtfPriceComInfo.setBackground(light);
		txtfPriceComInfo.setColumns(10);
		txtfPriceComInfo.setBounds(206, 338, 178, 35);
		txtfPriceComInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfPriceComInfo);

		txtfCommentsComInfo = new JTextField();
		txtfCommentsComInfo.setBackground(light);
		txtfCommentsComInfo.setColumns(10);
		txtfCommentsComInfo.setBounds(45, 409, 339, 35);
		txtfCommentsComInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfCommentsComInfo);

		String[] type = { "", " O", " M" };
		comboComType = new DefaultComboBoxModel<String>(type);
		cBoxTypeComInfo = new JComboBox<String>(comboComType);
		cBoxTypeComInfo.setBackground(light);
		cBoxTypeComInfo.setFont(new Font("Lato", Font.PLAIN, 12));
		cBoxTypeComInfo.setBounds(155, 125, 49, 35);
		cBoxTypeComInfo.setBorder(null);
		getPanelInfo().add(cBoxTypeComInfo);

		String[] zoning = { "", " I1", " I2", " I3", " I4" };
		comboComZoning = new DefaultComboBoxModel<String>(zoning);
		cBoxZoningComInfo = new JComboBox<String>(comboComZoning);
		cBoxZoningComInfo.setFont(new Font("Lato", Font.PLAIN, 12));
		cBoxZoningComInfo.setBorder(null);
		cBoxZoningComInfo.setBackground(light);
		cBoxZoningComInfo.setBounds(232, 125, 55, 35);
		getPanelInfo().add(cBoxZoningComInfo);

		String[] quadrant = { "", " NW", " NE", " SW", " SE" };
		comboComQuadrant = new DefaultComboBoxModel<String>(quadrant);
		cBoxQuadrantComInfo = new JComboBox<String>(comboComQuadrant);
		cBoxQuadrantComInfo.setFont(new Font("Lato", Font.PLAIN, 12));
		cBoxQuadrantComInfo.setBorder(null);
		cBoxQuadrantComInfo.setBackground(light);
		cBoxQuadrantComInfo.setBounds(314, 125, 70, 35);
		getPanelInfo().add(cBoxQuadrantComInfo);

		JLabel lblIdComInfo = new JLabel("Property Id");
		lblIdComInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblIdComInfo.setBounds(45, 93, 112, 22);
		getPanelInfo().add(lblIdComInfo);

		JLabel lblDescriptionComInfo = new JLabel("Legal Description");
		lblDescriptionComInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblDescriptionComInfo.setBounds(45, 175, 137, 21);
		getPanelInfo().add(lblDescriptionComInfo);

		JLabel lblAddressComInfo = new JLabel("Address");
		lblAddressComInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblAddressComInfo.setBounds(45, 247, 80, 14);
		getPanelInfo().add(lblAddressComInfo);

		JLabel lblPriceComInfo = new JLabel("Asking price");
		lblPriceComInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblPriceComInfo.setBounds(206, 310, 100, 20);
		getPanelInfo().add(lblPriceComInfo);

		JLabel lblFloorsComInfo = new JLabel("No. of Floors");
		lblFloorsComInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblFloorsComInfo.setBounds(45, 310, 91, 20);
		getPanelInfo().add(lblFloorsComInfo);

		JLabel lblCommentsComInfo = new JLabel("Comments");
		lblCommentsComInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblCommentsComInfo.setBounds(45, 384, 112, 14);
		lblCommentsComInfo.setBorder(null);
		getPanelInfo().add(lblCommentsComInfo);

		JLabel lblTypeComInfo = new JLabel("Type");
		lblTypeComInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblTypeComInfo.setBounds(155, 93, 49, 22);
		getPanelInfo().add(lblTypeComInfo);


		JLabel lblQuadrantComInfo = new JLabel("Quadrant");
		lblQuadrantComInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblQuadrantComInfo.setBounds(316, 93, 68, 22);
		getPanelInfo().add(lblQuadrantComInfo);

		JLabel lblZoningComInfo = new JLabel("Zoning");
		lblZoningComInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblZoningComInfo.setBounds(232, 93, 49, 22);
		getPanelInfo().add(lblZoningComInfo);

		getLblTitleInfo().setText("  Commercial Information");
		getLblTitleInfo().setBounds(85, 20, 299, 27);
	}

	@Override
	public void customSearchPanel() {
		getRdBtnId().setText("Property Id");
		getRdBtn2().setText("Legal description");
		getRdBtn3().setText("Property Price");
		getRdBtn4().setText("City's Quadrant");
		getLblTitleSearch().setText(" Search Commercial Property");
		getLblTitleSearch().setBounds(25, 20, 313, 27);
	}

	@Override
	public void clearFields() {
		getTxtfIdInfo().setText("");
		txtfDescriptionComInfo.setText("");
		txtfPriceComInfo.setText("");
		txtfFloorsComInfo.setText("");
		txtfCommentsComInfo.setText("");
		txtfAddressComInfo.setText("");
		comboComType.setSelectedItem("");
		comboComQuadrant.setSelectedItem("");
		comboComZoning.setSelectedItem("");
	}
}
