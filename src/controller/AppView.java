package controller;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

import view.UIClient;
import view.UICommercial;
import view.UIDashboard;
import view.UINav;
import view.UIResidential;
/**
 * This class is the View in the MVC model.
 * It brings all the JPanels together and draws them to the JFrame
 */
public class AppView extends JFrame {
	private static final long serialVersionUID = -6296281019082418930L;
	private JPanel windowView;
	private UICommercial com;
	private UIResidential res;
	private UIDashboard dash;
	private UIClient client;
	private UINav nav;

	/**
	 * This constructor sets the size of the JFrame and initiates the imported JPanels in the order they should be painted 
	 */
	public AppView() {
		Color color1 = new Color(70, 130, 180);
		Color color1H = new Color(90, 150, 200);
		Color color2 = new Color(235, 85, 160);
		Color dark = new Color(50, 60, 80);
		Color dark2 = new Color(60, 70, 90);
		Color light = new Color(240, 240, 250);
		Color light2 = new Color(211, 211, 211);
		setUndecorated(true);
		setResizable(false);
		setBounds(160, 50, 1080, 621);

		windowView = new JPanel();
		windowView.setBackground(dark2);
		windowView.setBorder(new EmptyBorder(5, 5, 5, 5));
		windowView.setLayout(null);

		nav = new UINav(color1, color1H, color2, dark, light);
		dash = new UIDashboard(color1, color2, dark, dark2, light, light2);
		client = new UIClient(color1, color2, dark, dark2, light, light2);
		res = new UIResidential(color1, color2, dark, dark2, light, light2);
		com = new UICommercial(color1, color2, dark, dark2, light, light2);
		windowView.add(nav.getContentPane());
		windowView.add(dash.getContentPane());
		setContentPane(windowView);

		JPanel movingPanel = new MotionPanel(this);
		movingPanel.setBounds(0, 299, 190, 254);
		windowView.add(movingPanel);
	}

	/**
	 * This method sets a JPanel in the navigation menu that allows the user to move the window around  
	 */
	public void setMovingPanel() {
		JPanel movingPanel = new MotionPanel(this);
		movingPanel.setBounds(0, 299, 190, 254);
		windowView.add(movingPanel);
	}

	/**
	 * * This method returns the JPanel for the main panels container
	 * @return windowView
	 */
	public JPanel getWindowView() {
		return windowView;
	}
	/**
	 * * This method returns the JPanel for the Dashboard content
	 * @return dash
	 */
	public UIDashboard getDash() {
		return dash;
	}
	/**
	 * * This method returns the JPanel for Client content
	 * @return client
	 */
	public UIClient getClient() {
		return client;
	}
	/**
	 * * This method returns the JPanel for the navigation menu 
	 * @return nav
	 */
	public UINav getNav() {
		return nav;
	}
	/**
	 * * This method returns the JPanel for the Residential content
	 * @return res
	 */
	public UIResidential getRes() {
		return res;
	}
	/**
	 * * This method returns the JPanel for the Commercial content
	 * @return com
	 */
	public UICommercial getCom() {
		return com;
	}

	/**
	 * This class adds custom functionality to a JPanel, so it can be used as the moving panel container
	 */
	public class MotionPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private Point initialClick;
		@SuppressWarnings("unused")
		private JFrame parent;

		public MotionPanel(final JFrame parent) {
			this.parent = parent;

			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					initialClick = e.getPoint();
					getComponentAt(initialClick);
				}
			});

			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {

					// get location of Window
					int thisX = parent.getLocation().x;
					int thisY = parent.getLocation().y;

					// Determine how much the mouse moved since the initial click
					int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
					int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

					// Move window to this position
					int X = thisX + xMoved;
					int Y = thisY + yMoved;
					parent.setLocation(X, Y);
				}
			});
		}
	}
}