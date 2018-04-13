package view;

import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class UINav {
	private ActionAudio myAction = new ActionAudio();
	private JPanel contentPane;
	private MyButton btnClose;
	private MyButton btnDashNav;
	private MyButton btnClientNav;
	private MyButton btnResidentialNav;
	private MyButton btnCommercialNav;
	private Color color1;
	private Color color1H;
	private Color color2;
	private Color dark;
	private Color light;

	/**
	 * The main constructor that draws all the elements in the Residential JPanel
	 * @param color1 primary color
	 * @param color1H primary color for a hover effect
	 * @param color2 secondary color 
	 * @param dark primary black
	 * @param light primary white
	 * @return the contentPane
	 */
	public UINav(Color color1, Color color1H, Color color2, Color dark, Color light) {
		this.color1 = color1;
		this.color1H = color1H;
		this.color2 = color2;
		this.dark = dark;
		this.light = light;
		contentPane = new JPanel();
		contentPane.setBackground(dark);
		contentPane.setBounds(0, 0, 190, 621);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		initpanel();
	}

	/**
	 * This method returns the main JPanel that holds all the client GUI methods  
	 * @return contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * * This method returns the JButton for CLOSE in the navigation JPanel
	 * @return btnClose
	 */
	public JButton getBtnClose() {
		return btnClose;
	}

	/**
	 * * This method returns the JButton for DASHBORAD in the navigation JPanel
	 * @return btnDashNav
	 */
	public JButton getBtnDashNav() {
		return btnDashNav;
	}

	/**
	 * * This method returns the JButton for CLIENT in the navigation JPanel
	 * @return btnClientNav
	 */
	public JButton getBtnClientNav() {
		return btnClientNav;
	}

	/**
	 * * This method returns the JButton for RESIDENTIAL in the navigation JPanel
	 * @return btnResidentialNav
	 */
	public JButton getBtnResidentialNav() {
		return btnResidentialNav;
	}

	/**
	 * * This method returns the JButton for COMMERCIAL in the navigation JPanel
	 * @return btnCommercialNav
	 */
	public JButton getBtnCommercialNav() {
		return btnCommercialNav;
	}

	/**
	 * This function applies the instructions from the action listener to the btnDashNav
	 * @param action ActionListener
	 */
	public void btnDashNav(ActionListener action) {
		btnDashNav.addActionListener(action);
	}

	/**
	 * This function applies the instructions from the action listener to the btnClientNav
	 * @param action ActionListener
	 */
	public void btnClientNav(ActionListener action) {
		btnClientNav.addActionListener(action);
	}

	/**
	 * This function applies the instructions from the action listener to the btnResidentialNav
	 * @param action ActionListener
	 */
	public void btnResidentialNav(ActionListener action) {
		btnResidentialNav.addActionListener(action);
	}

	/**
	 * This function applies the instructions from the action listener to the btnCommercialNav
	 * @param action ActionListener
	 */
	public void btnCommercialNav(ActionListener action) {
		btnCommercialNav.addActionListener(action);
	}

	/**
	 * This function applies the instructions from the action listener to the btnClose
	 * @param action ActionListener
	 */
	public void btnCloseNav(ActionListener action) {
		btnClose.addActionListener(action);
	}

	/**
	 * This method draws all the elements in the navigation JPanel
	 */
	public void initpanel() {
		btnDashNav = new MyButton("   Dashboard  ");
		btnDashNav.setFocusPainted(false);
		btnDashNav.setIcon(new ImageIcon(("res/icons/dash2.png")));
		btnDashNav.setForeground(new Color(240, 240, 250));
		btnDashNav.setFont(new Font("Lato", Font.PLAIN, 18));
		btnDashNav.setBackground(color1);
		//Personalized
		btnDashNav.setHoverBackgroundColor(color1H);
		btnDashNav.setPressedBackgroundColor(color1);
		btnDashNav.addActionListener(myAction);
		btnDashNav.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnDashNav.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDashNav.setBounds(0, 22, 190, 60);
		contentPane.add(btnDashNav);

		btnClientNav = new MyButton("   Client              ");
		btnClientNav.setFocusPainted(false);
		btnClientNav.setIcon(new ImageIcon(("res/icons/client.png")));
		btnClientNav.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientNav.setForeground(light);
		btnClientNav.setFont(new Font("Lato", Font.PLAIN, 18));
		btnClientNav.setBackground(dark);
		//Personalized
		btnClientNav.setHoverBackgroundColor(dark.brighter());
		btnClientNav.setPressedBackgroundColor(color1);
		btnClientNav.addActionListener(myAction);
		btnClientNav.setBounds(0, 92, 190, 60);
		btnClientNav.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(btnClientNav);

		btnResidentialNav = new MyButton("   Residential   ");
		btnResidentialNav.setFocusPainted(false);
		btnResidentialNav.setIcon(new ImageIcon(("res/icons/home.png")));
		btnResidentialNav.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResidentialNav.setForeground(new Color(240, 240, 250));
		btnResidentialNav.setFont(new Font("Lato", Font.PLAIN, 18));
		btnResidentialNav.setBackground(dark);
		//Personalized
		btnResidentialNav.setHoverBackgroundColor(dark.brighter());
		btnResidentialNav.setPressedBackgroundColor(color1);
		btnResidentialNav.addActionListener(myAction);
		btnResidentialNav.setBounds(0, 162, 190, 60);
		btnResidentialNav.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(btnResidentialNav);

		btnCommercialNav = new MyButton("   Commercial");
		btnCommercialNav.setFocusPainted(false);
		btnCommercialNav.setIcon(new ImageIcon(("res/icons/office.png")));
		btnCommercialNav.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCommercialNav.setForeground(new Color(240, 240, 250));
		btnCommercialNav.setFont(new Font("Lato", Font.PLAIN, 18));
		btnCommercialNav.setBackground(dark);
		//Personalized
		btnCommercialNav.setHoverBackgroundColor(dark.brighter());
		btnCommercialNav.setPressedBackgroundColor(color1);
		btnCommercialNav.addActionListener(myAction);
		btnCommercialNav.setBounds(0, 232, 190, 60);
		btnCommercialNav.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(btnCommercialNav);

		btnClose = new MyButton("   Close Manager");
		btnClose.setFocusPainted(false);
		btnClose.setIcon(new ImageIcon(("res/icons/exit.png")));
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.setForeground(new Color(240, 240, 250));
		btnClose.setFont(new Font("Lato", Font.PLAIN, 16));
		btnClose.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnClose.setBackground(dark);
		//Personalized
		btnClose.setHoverBackgroundColor(dark.brighter());
		btnClose.setPressedBackgroundColor(color2);
		btnClose.addActionListener(myAction);
		btnClose.setBounds(0, 560, 189, 40);
		btnClose.addActionListener(myAction);
		contentPane.add(btnClose);
	}

	//Custom functionality
	/**
	 *This class ads custom functionality to the navigation buttons
	 */
	class ActionAudio implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnDashNav)
				toggleBG(0);
			else if (e.getSource() == btnClientNav)
				toggleBG(1);
			else if (e.getSource() == btnResidentialNav)
				toggleBG(2);
			else if (e.getSource() == btnCommercialNav)
				toggleBG(3);
		}

		/**
		 * This method sets the background color of all the buttons to the default color
		 * @param index the button who should be highlighted 
		 * 0:btnDashNav, 1:btnClientNav, 2:btnResidentialNav, 3:btnCommercialNav
		 */
		private void toggleBG(int index) {
			ArrayList<MyButton> btns = new ArrayList<MyButton>();
			btns.add(btnDashNav);
			btns.add(btnClientNav);
			btns.add(btnResidentialNav);
			btns.add(btnCommercialNav);

			for (MyButton btn : btns) {
				btn.setBackground(dark);
				btn.setHoverBackgroundColor(dark.brighter());
			}

			btns.get(index).setBackground(color1);
			btns.get(index).setHoverBackgroundColor(color1H);
		}
	}
	

/**
 * This class adds hover and color functionality to the default buttons.
 */
class MyButton extends JButton {

    private static final long serialVersionUID = 1L;
    private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;

    public MyButton() {
        this(null);
    }

    public MyButton(String text) {
        super(text);
        super.setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }
}
}