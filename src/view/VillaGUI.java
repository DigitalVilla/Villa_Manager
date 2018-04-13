package view;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public abstract class VillaGUI {
	private JPanel contentPane;
	//Search Pane
	private JButton btnSearch;
	private JButton btnClearSearch;
	private JTextField txtfInputSearch;
	private JLabel lblTitleSearch;
	private JList<String> jListSearch;
	private DefaultListModel<String> listModel;
	//Information Pane
	private JButton btnSaveInfo;
	private JButton btnDeleteInfo;
	private JButton btnClearInfo;
	private JLabel lblValidInfo;
	private JLabel lblTitleInfo;
	private JPanel panelInfo;
	private JPanel panelSearch;
	private JTextField txtfIdInfo;
	private JRadioButton rdBtnId;
	private JRadioButton rdBtn2;
	private JRadioButton rdBtn3;
	private JRadioButton rdBtn4;
	// Public color
	public Color light;
	
	/**
	 * The main constructor that draws all the elements in the Residential JPanel
	 * @param color1 primary color
	 * @param color2 secondary color 
	 * @param dark primary black
	 * @param dark2 secondary black
	 * @param light primary white
	 * @param light2 secondary white 
	 * @return the contentPane
	 */
	public VillaGUI (Color color1, Color color2, Color dark, Color dark2, Color light, Color light2) {
		this.light = light;
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBounds(190, 0, 890, 621);
		contentPane.setBackground(new Color(0, 0, 0, 0));
		setLblValidInfo();
		contentPane.add(this.lblValidInfo);
		contentPane.add(searchClientPanel(color1, color2, dark, dark2, light, light2));
		contentPane.add(infoClientPanel(color1, color2, dark, dark2, light, light2));
		bgPanel("calgary1.jpg");
	}

	/**
	 * This method sets the parameters for the warning JLabel in the information JPanel 
	 */
	public void setLblValidInfo() {
		this.lblValidInfo = new JLabel("");
		this.lblValidInfo.setBounds(530, 491, 233, 26);
		this.lblValidInfo.setFont(new Font("Lato", Font.BOLD, 14));
		this.lblValidInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.lblValidInfo.setVisible(true);
	}

	/**
	 * This method returns the main JPanel that holds all the client GUI methods  
	 * @return contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * This method returns the Information JPanel that holds all the basic GUI elements  
	 * @return contentPane
	 */
	public JPanel getPanelInfo() {
		return panelInfo;
	}

	/**
	 * This method returns the Search JPanel that holds all the basic GUI elements  
	 * @return contentPane
	 */
	public JPanel getPanelSearch() {
		return panelSearch;
	}
	/**
	 * * This method returns the JRadioButton for ID in the search JPanel
	 * @return rdBtnId
	 */
	public JRadioButton getRdBtnId() {
		return rdBtnId;
	}
	/**
	 * * This method returns the second JRadioButton for ID in the search JPanel
	 * @return rdBtn2
	 */
	public JRadioButton getRdBtn2() {
		return rdBtn2;
	}
	/**
	 * * This method returns the third JRadioButton for ID in the search JPanel
	 * @return rdBtn3
	 */
	public JRadioButton getRdBtn3() {
		return rdBtn3;
	}
	/**
	 * * This method returns the fourth JRadioButton for ID in the search JPanel
	 * @return rdBtn4
	 */
	public JRadioButton getRdBtn4() {
		return rdBtn4;
	}

	/**
	 * This method returns the warning JLabel in the information JPanel 
	 * @return lblValidInfo
	 */
	public JLabel getLblValidInfo() {
		return lblValidInfo;
	}
	
	/**
	 * This method returns the JLabel to set the Search panel's title 
	 * @return lblTitleSearch
	 */
	public JLabel getLblTitleSearch() {
		return lblTitleSearch;
	}

	/**
	 * This method returns the JTextField for the input Search 
	 * @return txtfInputSearch
	 */
	public JTextField getTxtfInputSearch() {
		return txtfInputSearch;
	}

	/**
	 * This method returns the JTextField for ID in the information JPanel 
	 * @return txtfIdInfo
	 */
	public JTextField getTxtfIdInfo() {
		return txtfIdInfo;
	}
	
	/**
	 * * This method returns the JButton for SEARCH in the search JPanel
	 * @return btnSearchClientSearch
	 */
	public JButton getBtnSearch() {
		return btnSearch;
	}

	/**
	 * * This method returns the JButton for CLEAR in the search JPanel
	 * @return btnClearClientSearch
	 */
	public JButton getBtnClearSearch() {
		return btnClearSearch;
	}

	/**
	 * * This method returns the JList<String> in the search JPanel
	 * @return jListClientSearch
	 */
	public JList<String> getJListSearch() {
		return jListSearch;
	}

	/**
	 * This method returns the DefaultListModel for the JList in the Search JPanel 
	 * @return listModel
	 */
	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	/**
	 * This method returns the JLabel to set the Information panel's title 
	 * @return lblTitleInfo
	 */
	public JLabel getLblTitleInfo() {
		return lblTitleInfo;
	}

	/**
	 * * This method returns the JButton for SAVE in the information JPanel
	 * @return btnSaveInfo
	 */
	public JButton getBtnSaveInfo() {
		return btnSaveInfo;
	}

	/**
	 * * This method returns the JButton for DELETE in the information JPanel
	 * @return btnDeleteInfo
	 */
	public JButton getBtnDeleteInfo() {
		return btnDeleteInfo;
	}

	/**
	 * * This method returns the JButton for CLEAR in the information JPanel
	 * @return btnClearInfo
	 */
	public JButton getBtnClearInfo() {
		return btnClearInfo;
	}

	//////  Action listeners ////////////////
	/**
	 * This function applies the instructions from the list selection listener to the jListSearch
	 * @param action ListSelectionListener
	 */
	public void jListSearch(ListSelectionListener action) {
		jListSearch.addListSelectionListener(action);
	}

	/**
	 * This function applies the instructions from the action listener to the btnSearch
	 * @param action ActionListener
	 */
	public void btnSearch(ActionListener action) {
		btnSearch.addActionListener(action);
	}

	/**
	 * This function applies the instructions from the action listener to the btnClearSearch
	 * @param action ActionListener
	 */
	public void btnClearSearch(ActionListener action) {
		btnClearSearch.addActionListener(action);
	}

	/**
	 * This function applies the instructions from the action listener to the btnSaveInfo
	 * @param action ActionListener
	 */
	public void btnSaveInfo(ActionListener action) {
		btnSaveInfo.addActionListener(action);
	}

	/**
	 * This function applies the instructions from the action listener to the btnDeleteInfo
	 * @param action ListSelectionListener
	 */
	public void btnDeleteInfo(ActionListener action) {
		btnDeleteInfo.addActionListener(action);
	}

	/**
	 * This function applies the instructions from the action listener to the btnClearInfo
	 * @param action ActionListener
	 */
	public void btnClearInfo(ActionListener action) {
		btnClearInfo.addActionListener(action);
	}

	//Information Panel ///////

	/**
	 * This method draws all the elements in the Information JPanel
	 * @param color1 primary color
	 * @param color2 secondary color 
	 * @param dark primary black
	 * @param dark2 secondary black
	 * @param light primary white
	 * @param light2 secondary white 
	 * @return the Information JPanel
	 */
	public JPanel infoClientPanel(Color color1, Color color2, Color dark, Color dark2, Color light, Color light2) {
		panelInfo = new JPanel();
		panelInfo.setLayout(null);
		panelInfo.setBackground(new Color(200, 200, 210));
		panelInfo.setBounds(432, 40, 421, 547);
		panelInfo.setVisible(true);

		btnSaveInfo = new JButton("  Save");
		btnSaveInfo.setFocusPainted(false);
		btnSaveInfo.setForeground(new Color(240, 240, 250));
		btnSaveInfo.setIcon(new ImageIcon(("res/icons/add.png")));
		btnSaveInfo.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		btnSaveInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnSaveInfo.setBackground(color1);
		btnSaveInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSaveInfo.setBounds(45, 484, 100, 40);
		panelInfo.add(btnSaveInfo);

		btnDeleteInfo = new JButton("  Delete");
		btnDeleteInfo.setFocusPainted(false);
		btnDeleteInfo.setForeground(new Color(240, 240, 250));
		btnDeleteInfo.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		btnDeleteInfo.setIcon(new ImageIcon(("res/icons/delete.png")));
		btnDeleteInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnDeleteInfo.setBackground(color1);
		btnDeleteInfo.setBounds(175, 484, 100, 40);
		btnDeleteInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelInfo.add(btnDeleteInfo);

		btnClearInfo = new JButton("  Clear");
		btnClearInfo.setFocusPainted(false);
		btnClearInfo.setForeground(new Color(240, 240, 250));
		btnClearInfo.setIcon(new ImageIcon(("res/icons/clear.png")));
		btnClearInfo.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		btnClearInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnClearInfo.setBackground(color1);
		btnClearInfo.setBounds(304, 484, 80, 40);
		btnClearInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelInfo.add(btnClearInfo);

		txtfIdInfo = new JTextField();
		txtfIdInfo.setBackground(light);
		txtfIdInfo.setEditable(false);
		txtfIdInfo.setColumns(10);
		txtfIdInfo.setBorder(new EmptyBorder(0, 0, 0, 0));
		getPanelInfo().add(txtfIdInfo);

		JPanel panelTitleClientInfo = new JPanel();
		panelTitleClientInfo.setLayout(null);
		panelTitleClientInfo.setBackground(new Color(70, 130, 180));
		panelTitleClientInfo.setBounds(0, 0, 421, 65);
		panelInfo.add(panelTitleClientInfo);

		lblTitleInfo = new JLabel("  Information Panel");
		lblTitleInfo.setIcon(new ImageIcon(("res/icons/file.png")));
		lblTitleInfo.setForeground(new Color(240, 240, 250));
		lblTitleInfo.setFont(new Font("Lato", Font.PLAIN, 22));
		lblTitleInfo.setBounds(125, 20, 225, 27);
		panelTitleClientInfo.add(lblTitleInfo);

		return panelInfo;
	}

	/**
	 * This method draws all the elements in the search JPanel
	 * @param color1 primary color
	 * @param color2 secondary color 
	 * @param dark primary black
	 * @param dark2 secondary black
	 * @param light primary white
	 * @param light2 secondary white 
	 * @return the search JPanel
	 */
	public JPanel searchClientPanel(Color color1, Color color2, Color dark, Color dark2, Color light, Color light2) {
		panelSearch = new JPanel();
		panelSearch.setBounds(38, 40, 355, 547);
		panelSearch.setBackground(dark2);
		panelSearch.setLayout(null);
		contentPane.add(panelSearch);
		panelSearch.setVisible(true);

		rdBtnId = new JRadioButton("rdBtnId");
		rdBtnId.setSelected(true);
		rdBtnId.setFocusPainted(false);
		rdBtnId.setFont(new Font("Lato", Font.PLAIN, 16));
		rdBtnId.setForeground(new Color(240, 240, 250));
		rdBtnId.setBackground(new Color(60, 70, 90));
		rdBtnId.setBounds(32, 84, 126, 23);
		panelSearch.add(rdBtnId);

		rdBtn2 = new JRadioButton("rdBtn2");
		rdBtn2.setFocusPainted(false);
		rdBtn2.setFont(new Font("Lato", Font.PLAIN, 16));
		rdBtn2.setForeground(new Color(240, 240, 250));
		rdBtn2.setBackground(new Color(60, 70, 90));
		rdBtn2.setBounds(182, 84, 142, 23);
		panelSearch.add(rdBtn2);

		rdBtn3 = new JRadioButton("rdBtn3");
		rdBtn3.setFocusPainted(false);
		rdBtn3.setFont(new Font("Lato", Font.PLAIN, 16));
		rdBtn3.setForeground(new Color(240, 240, 250));
		rdBtn3.setBackground(new Color(60, 70, 90));
		rdBtn3.setBounds(182, 126, 145, 23);
		panelSearch.add(rdBtn3);

		rdBtn4 = new JRadioButton("rdBtn4");
		rdBtn4.setForeground(new Color(240, 240, 250));
		rdBtn4.setFont(new Font("Lato", Font.PLAIN, 16));
		rdBtn4.setFocusPainted(false);
		rdBtn4.setBackground(new Color(60, 70, 90));
		rdBtn4.setBounds(32, 126, 145, 23);
		panelSearch.add(rdBtn4);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdBtnId);
		btnGroup.add(rdBtn2);
		btnGroup.add(rdBtn3);
		btnGroup.add(rdBtn4);
		
		btnSearch = new JButton("Search");
		btnSearch.setFocusPainted(false);
		btnSearch.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnSearch.setBackground(color1);
		btnSearch.setForeground(new Color(240, 240, 250));
		btnSearch.setBounds(246, 171, 78, 40);
		btnSearch.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelSearch.add(btnSearch);

		btnClearSearch = new JButton("Clear Search");
		btnClearSearch.setFocusPainted(false);
		btnClearSearch.setForeground(new Color(240, 240, 250));
		btnClearSearch.setBackground(color1);
		btnClearSearch.setIcon(new ImageIcon(("res/icons/clear.png")));
		btnClearSearch.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		btnClearSearch.setBounds(124, 490, 100, 40);
		btnClearSearch.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelSearch.add(btnClearSearch);

		listModel = new DefaultListModel<String>();
		jListSearch = new JList<String>(listModel);
		jListSearch.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		jListSearch.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jListSearch.setBackground(light2);
		jListSearch.setVisibleRowCount(12);

		JScrollPane JSPClient = new JScrollPane(jListSearch);
		JSPClient.setBorder(new EmptyBorder(0, 0, 0, 0));
		JSPClient.setBounds(32, 230, 292, 240);
		panelSearch.add(JSPClient);

		txtfInputSearch = new JTextField();
		txtfInputSearch.setBackground(new Color(211, 211, 211));
		txtfInputSearch.setFont(new Font("Lato", Font.PLAIN, 16));
		txtfInputSearch.setBounds(32, 171, 214, 40);
		txtfInputSearch.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelSearch.add(txtfInputSearch);
		txtfInputSearch.setColumns(10);

		lblTitleSearch = new JLabel(" Search Panel");
		lblTitleSearch.setBounds(25, 20, 313, 27);
		panelSearch.add(lblTitleSearch);
		lblTitleSearch.setBackground(new Color(0, 153, 204));
		lblTitleSearch.setIcon(new ImageIcon(("res/icons/search.png")));
		lblTitleSearch.setForeground(new Color(240, 240, 250));
		lblTitleSearch.setFont(new Font("Lato", Font.PLAIN, 22));

		JPanel panelTtitleComSearch = new JPanel();
		panelTtitleComSearch.setLayout(null);
		panelTtitleComSearch.setBackground(color1);
		panelTtitleComSearch.setBounds(0, 0, 355, 65);
		panelSearch.add(panelTtitleComSearch);

		return panelSearch;
	}

	/**
	 * This method draws the background image for the contentPane JPanel
	 * @param image the name and extension of the image i.e. image.png
	 * The image must be stored in the local res/images folder 
	 * @return the bgPanel
	 */
	public JLabel bgPanel(String image) {
		JLabel BackGroundImage = new JLabel("");
		BackGroundImage.setBounds(0, 0, 890, 621);
		BackGroundImage.setIcon(new ImageIcon(("res/images/" + image)));
		BackGroundImage.setVisible(true);
		contentPane.add(BackGroundImage);
		return BackGroundImage;
	}

	/**
	 * This method adds all the custom elements to the Information JPanel
	 */
	public abstract void customInfoPanel();
	/**
	 * This method adds all the custom elements to the Search JPanel
	 */
	public abstract void customSearchPanel();
	/**
	 * This method clears all the JTextfields elements in the Information Panel
	 */
	public abstract void clearFields();
}
