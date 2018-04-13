package view;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

/**
 * @author 767110
 *
 */
public class UIResidential extends VillaGUI {
	private JTextField txtfBedroomsResInfo;
	private JTextField txtfDescriptionResInfo;
	private JTextField txtfAddressResInfo;
	private JTextField txtfFootageResInfo;
	private JTextField txtfCommentsResInfo;
	private JTextField txtfBathroomsResInfo;
	private JTextField txtfPriceResInfo;
	private JComboBox<String> cBoxGTypeResInfo;
	private JComboBox<String> cBoxZoningResInfo;
	private JComboBox<String> cBoxQuadrantResInfo;
	private DefaultComboBoxModel<String> comboResQuadrant;
	private DefaultComboBoxModel<String> comboResZoning;
	private DefaultComboBoxModel<String> comboResGType;

	/**
	 * This is the main constructor that draws all the elements in the Residential JPanel
	 * @param color1 primary color
	 * @param color2 secondary color 
	 * @param dark primary black
	 * @param dark2 secondary black
	 * @param light primary white
	 * @param light2 secondary white 
	 * @return the contentPane
	 */
	public UIResidential(Color color1, Color color2, Color dark, Color dark2, Color light, Color light2) {
		super(color1, color2, dark, dark2, light, light2);
		customInfoPanel();
		customSearchPanel();	}
	/**
	 * * This method returns the DefaultComboBoxModel<String> for QUARANT in the information JPanel
	 * @return comboResQuadrant
	 */
	public DefaultComboBoxModel<String> getComboResQuadrant() {
		return comboResQuadrant;
	}

	/**
	 * * This method returns the DefaultComboBoxModel<String> for ZONING in the information JPanel
	 * @return comboResZoning
	 */
	public DefaultComboBoxModel<String> getComboResZoning() {
		return comboResZoning;
	}

	/**
	 * * This method returns the DefaultComboBoxModel<String> for G. TYPE in the information JPanel
	 * @return comboResGType
	 */
	public DefaultComboBoxModel<String> getComboResGType() {
		return comboResGType;
	}

	/**
	 * * This method returns the JComboBox<String> for G. TYPE in the information JPanel
	 * @return cBoxGTypeResInfo
	 */
	public JComboBox<String> getcBoxGTypeResInfo() {
		return cBoxGTypeResInfo;
	}

	/**
	 * * This method returns the JComboBox<String> for ZONING in the information JPanel
	 * @return cBoxZoningResInfo
	 */
	public JComboBox<String> getcBoxZoningResInfo() {
		return cBoxZoningResInfo;
	}

	/**
	 * * This method returns the JComboBox<String> for QUADRANT in the information JPanel
	 * @return cBoxQuadrantResInfo
	 */
	public JComboBox<String> getcBoxQuadrantResInfo() {
		return cBoxQuadrantResInfo;
	}

	/**
	 * * This method returns the JTextField for BEDROOMS in the information JPanel
	 * @return txtfBedroomsResInfo
	 */
	public JTextField getTxtfBedroomsResInfo() {
		return txtfBedroomsResInfo;
	}

	/**
	 * * This method returns the JTextField for LEGAL DESCRIPTION in the information JPanel
	 * @return txtfDescriptionResInfo
	 */
	public JTextField getTxtfDescriptionResInfo() {
		return txtfDescriptionResInfo;
	}

	/**
	 * * This method returns the JTextField for ADDRESS in the information JPanel
	 * @return txtfAddressResInfo
	 */
	public JTextField getTxtfAddressResInfo() {
		return txtfAddressResInfo;
	}

	/**
	 * * This method returns the JTextField for FOOTAGE in the information JPanel
	 * @return txtfFootageResInfo
	 */
	public JTextField getTxtfFootageResInfo() {
		return txtfFootageResInfo;
	}

	/**
	 * * This method returns the JTextField for COMMENTS in the information JPanel
	 * @return txtfCommentsResInfo
	 */
	public JTextField getTxtfCommentsResInfo() {
		return txtfCommentsResInfo;
	}

	/**
	 * * This method returns the JTextField for BATHROOMS in the information JPanel
	 * @return txtfBathroomsResInfo
	 */
	public JTextField getTxtfBathroomsResInfo() {
		return txtfBathroomsResInfo;
	}

	/**
	 * * This method returns the JTextField for PRICE in the information JPanel
	 * @return txtfPriceResInfo
	 */
	public JTextField getTxtfPriceResInfo() {
		return txtfPriceResInfo;
	}

	@Override
	public void customInfoPanel() {
		getTxtfIdInfo().setBounds(45, 126, 82, 35);

		txtfBedroomsResInfo = new JTextField();
		txtfBedroomsResInfo.setBackground(light);
		txtfBedroomsResInfo.setBounds(45, 338, 85, 35);
		txtfBedroomsResInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfBedroomsResInfo);

		txtfDescriptionResInfo = new JTextField();
		txtfDescriptionResInfo.setBackground(light);
		txtfDescriptionResInfo.setColumns(10);
		txtfDescriptionResInfo.setBounds(45, 201, 192, 35);
		txtfDescriptionResInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfDescriptionResInfo);

		txtfAddressResInfo = new JTextField();
		txtfAddressResInfo.setBackground(light);
		txtfAddressResInfo.setColumns(10);
		txtfAddressResInfo.setBounds(45, 267, 339, 35);
		txtfAddressResInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfAddressResInfo);

		txtfFootageResInfo = new JTextField();
		txtfFootageResInfo.setBackground(light);
		txtfFootageResInfo.setColumns(10);
		txtfFootageResInfo.setBounds(277, 338, 107, 35);
		txtfFootageResInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfFootageResInfo);

		txtfCommentsResInfo = new JTextField();
		txtfCommentsResInfo.setBackground(light);
		txtfCommentsResInfo.setColumns(10);
		txtfCommentsResInfo.setBounds(45, 409, 339, 35);
		txtfCommentsResInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfCommentsResInfo);

		txtfPriceResInfo = new JTextField();
		txtfPriceResInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtfPriceResInfo.setBackground(light);
		txtfPriceResInfo.setBounds(266, 201, 118, 35);
		getPanelInfo().add(txtfPriceResInfo);

		txtfBathroomsResInfo = new JTextField();
		txtfBathroomsResInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtfBathroomsResInfo.setBackground(light);
		txtfBathroomsResInfo.setBounds(162, 338, 85, 35);
		getPanelInfo().add(txtfBathroomsResInfo);

		JLabel lblIdResInfo = new JLabel("Property Id");
		lblIdResInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblIdResInfo.setBounds(45, 93, 112, 22);
		getPanelInfo().add(lblIdResInfo);

		JLabel lblDescriptionResInfo = new JLabel("Legal Description");
		lblDescriptionResInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblDescriptionResInfo.setBounds(45, 175, 137, 21);
		getPanelInfo().add(lblDescriptionResInfo);

		JLabel lblAddressResInfo = new JLabel("Address");
		lblAddressResInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblAddressResInfo.setBounds(45, 247, 80, 14);
		getPanelInfo().add(lblAddressResInfo);

		JLabel lblPriceResInfo = new JLabel("Asking price");
		lblPriceResInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblPriceResInfo.setBounds(266, 175, 100, 20);
		getPanelInfo().add(lblPriceResInfo);

		JLabel lblBedroomsResInfo = new JLabel("Bedrooms");
		lblBedroomsResInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblBedroomsResInfo.setBounds(45, 310, 82, 20);
		getPanelInfo().add(lblBedroomsResInfo);

		JLabel lblCommentsResInfo = new JLabel("Comments");
		lblCommentsResInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblCommentsResInfo.setBounds(45, 384, 112, 14);
		lblCommentsResInfo.setBorder(null);
		getPanelInfo().add(lblCommentsResInfo);

		JLabel lblGTypeResInfo = new JLabel("G Type");
		lblGTypeResInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblGTypeResInfo.setBounds(155, 93, 49, 22);
		getPanelInfo().add(lblGTypeResInfo);

		JLabel lblQuadrantResInfo = new JLabel("Quadrant");
		lblQuadrantResInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblQuadrantResInfo.setBounds(316, 93, 68, 22);
		getPanelInfo().add(lblQuadrantResInfo);

		JLabel lblZoningResInfo = new JLabel("Zoning");
		lblZoningResInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblZoningResInfo.setBounds(232, 93, 49, 22);
		getPanelInfo().add(lblZoningResInfo);

		JLabel lblBathroomsResInfo = new JLabel("Bathrooms");
		lblBathroomsResInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblBathroomsResInfo.setBounds(163, 310, 85, 20);
		getPanelInfo().add(lblBathroomsResInfo);

		JLabel lblSqFootageResInfo = new JLabel("Sq. Footage");
		lblSqFootageResInfo.setFont(new Font("Lato", Font.PLAIN, 16));
		lblSqFootageResInfo.setBounds(277, 310, 100, 20);
		getPanelInfo().add(lblSqFootageResInfo);

		String[] gType = { "", " A", " D", " N" };
		comboResGType = new DefaultComboBoxModel<String>(gType);
		cBoxGTypeResInfo = new JComboBox<String>(comboResGType);
		cBoxGTypeResInfo.setBackground(light);
		cBoxGTypeResInfo.setFont(new Font("Lato", Font.PLAIN, 12));
		cBoxGTypeResInfo.setBounds(155, 125, 49, 35);
		cBoxGTypeResInfo.setBorder(null);
		getPanelInfo().add(cBoxGTypeResInfo);

		String[] zoning = { "", " R1", " R2", " R3", " R4" };
		comboResZoning = new DefaultComboBoxModel<String>(zoning);
		cBoxZoningResInfo = new JComboBox<String>(comboResZoning);
		cBoxZoningResInfo.setFont(new Font("Lato", Font.PLAIN, 12));
		cBoxZoningResInfo.setBorder(null);
		cBoxZoningResInfo.setBackground(light);
		cBoxZoningResInfo.setBounds(232, 125, 55, 35);
		getPanelInfo().add(cBoxZoningResInfo);

		String[] quadrant = { "", " NW", " NE", " SW", " SE" };
		comboResQuadrant = new DefaultComboBoxModel<String>(quadrant);
		cBoxQuadrantResInfo = new JComboBox<String>(comboResQuadrant);
		cBoxQuadrantResInfo.setFont(new Font("Lato", Font.PLAIN, 12));
		cBoxQuadrantResInfo.setBorder(null);
		cBoxQuadrantResInfo.setBackground(light);
		cBoxQuadrantResInfo.setBounds(314, 125, 70, 35);
		getPanelInfo().add(cBoxQuadrantResInfo);

		getLblTitleInfo().setText("  Residential Information");
		getLblTitleInfo().setBounds(85, 20, 299, 27);

	}

	@Override
	public void customSearchPanel() {
		getRdBtnId().setText("Property Id");
		getRdBtn2().setText("Legal description");
		getRdBtn3().setText("Property Price");
		getRdBtn4().setText("City's Quadrant");
		getLblTitleSearch().setText("  Search Residential Property");
		getLblTitleSearch().setBounds(25, 20, 313, 27);
	}
	
	@Override
	public void clearFields() {
		getTxtfIdInfo().setText("");
		txtfDescriptionResInfo.setText("");
		txtfPriceResInfo.setText("");
		txtfFootageResInfo.setText("");
		txtfBathroomsResInfo.setText("");
		txtfBedroomsResInfo.setText("");
		txtfCommentsResInfo.setText("");
		txtfAddressResInfo.setText("");
		comboResGType.setSelectedItem("");
		comboResQuadrant.setSelectedItem("");
		comboResZoning.setSelectedItem("");
	}
}
