package controller;

/**
 * This class is the runner for the Manager APP 
 */
public class AppDriver {

	public static void main(String[] args) {
		AppView view = new AppView();
		AppController controler = new AppController(view);
		controler.start();
		view.setVisible(true);
	}

}
