package controller;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import model.exceptions.property.InvalidLegalDescriptionException;
import model.exceptions.property.InvalidNumberOfBathroomsException;
import model.persistence.property.*;

import model.persistence.Broker;
import model.exceptions.InvalidIdException;
import model.exceptions.clientale.*;
import model.problemDomain.clientale.Client;
import model.persistence.clientale.ClientBroker;

import model.problemDomain.property.CommercialProperty;
import model.problemDomain.property.Property;
import model.problemDomain.property.ResidentialProperty;
import view.VillaGUI;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.awt.Color;
import java.util.ArrayList;

/**
 *This class is the CONTROLLER in the MVC model.
 *This is the main interface between  MODEL and VIEW 
 * This class was remade from the ground up in order to make its code reusable and compact.
 * it is better organized, implements inheritance and reflection in order to reuse as many methods as possible.  
 * @version 2.0
 *
 */
public class AppController {
	private ArrayList<ArrayList> myDatabase;
	private ArrayList<Broker> myBrokers;
	private boolean validInput;
	private String [] myViews;
	private AppView view;

	public AppController(AppView view) {
		myViews = new String[] {"getClient","getRes","getCom"};
		ArrayList<ResidentialProperty> dbRes = new ArrayList<ResidentialProperty>();
		ResidentialPropertyBroker rb = ResidentialPropertyBroker.getBroker();
		ArrayList<CommercialProperty> dbCom = new  ArrayList<CommercialProperty>();
		CommercialPropertyBroker mb = CommercialPropertyBroker.getBroker();
		ArrayList<Client> dbClient = new ArrayList<Client>();
		ClientBroker cb = ClientBroker.getBroker();
		myDatabase = new ArrayList<ArrayList>();
		myDatabase.add(dbClient);
		myDatabase.add(dbRes);
		myDatabase.add(dbCom);
		myBrokers = new ArrayList<Broker>();
		myBrokers.add(cb);
		myBrokers.add(rb);
		myBrokers.add(mb);
		validInput = true;
		this.view = view;
	}

	/**
	 * This is the main controller method that initiates the GUI components that have an event listener. 
	 */
	public void start() {
		this.view.getNav().btnCloseNav(new MyActionEvent());
		this.view.getNav().btnDashNav(new MyActionEvent());
		this.view.getNav().btnClientNav(new MyActionEvent());
		this.view.getNav().btnResidentialNav(new MyActionEvent());
		this.view.getNav().btnCommercialNav(new MyActionEvent());
		viewListeners (0);
		viewListeners (1);
		viewListeners (2);
	}

	/**
	 * 
	 * @param myView
	 */
	private void viewListeners (int myView) {
		Method obj = null;
		try { obj = view.getClass().getMethod(myViews[myView]);
			((VillaGUI) obj.invoke(view)).jListSearch(new MyActionList());
			((VillaGUI) obj.invoke(view)).btnSearch(new MyActionEvent());
			((VillaGUI) obj.invoke(view)).btnClearSearch(new MyActionEvent());
			((VillaGUI) obj.invoke(view)).btnSaveInfo(new MyActionEvent());
			((VillaGUI) obj.invoke(view)).btnDeleteInfo(new MyActionEvent());
			((VillaGUI) obj.invoke(view)).btnClearInfo(new MyActionEvent());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This class implements ActionListener and gives a custom functionality to each swing component
	 */
	class MyActionEvent implements ActionListener {
		private String searchType;
		private String searchWord;
		public void actionPerformed(ActionEvent e) {
			searchType = "";
			searchWord ="";
			navControl(e);
			clientControl(e);
			residentialControl(e);
			commercialControl(e);
		}

		/**
		 * This method controls all the actions for the Commercial class
		 * @param Action Listener to implement
		 */
		private void commercialControl(ActionEvent e) {
			if (e.getSource() == view.getCom().getBtnSearch()) {
				clearSearch(2);
				setLblValid("",2,0); 
				getInputValue(2);
				if (validInput) {
					checkRdBtn(2);
					generateDB(2); 
				} else if (!validInput){
					view.getCom().getListModel().addElement(" Please enter a valid Input.");
				}
			} else if (e.getSource() == view.getCom().getBtnClearSearch()) {
				view.getCom().getTxtfInputSearch().setText("");
				clearSearch(2);		
			}  else if (e.getSource() == view.getCom().getBtnClearInfo()) {
				clearInfo(2);
				setLblValid("",2,0);
			} else if (e.getSource() == view.getCom().getBtnDeleteInfo()) {
				removeById(2);
				clearInfo(2);
				clearSearch(2);
			} else if (e.getSource() == view.getCom().getBtnSaveInfo() && this.saveCom()) {
				clearInfo(2);
			}
		}

		/**
		 * This method validates, updates and creates a new Property class
		 * If the Id exist it updates the data, if the Id is blank it will generate a new unique Id.   
		 * @return true if the class was successfully created 
		 */
		private boolean saveCom() {
			int valid = 0;
			double price = 0;
			int floors = 0;
			String legal = view.getCom().getTxtfDescriptionComInfo().getText().toUpperCase();
			String address =view.getCom().getTxtfAddressComInfo().getText();
			if (address.isEmpty()) ++valid;
			String	priceS = view.getCom().getTxtfPriceComInfo().getText();
			if (priceS.isEmpty()) ++valid;
			else if(valid == 0 && validNum(priceS,false)) price = Double.parseDouble(priceS);
			else ++valid;
			String floorS = view.getCom().getTxtfFloorsComInfo().getText();
			if (floorS.isEmpty()) ++valid;
			else if(valid == 0 && validNum(floorS,true)) floors = Integer.parseInt(floorS);
			else ++valid;
			String	comments = view.getCom().getTxtfCommentsComInfo().getText();
			if (comments.isEmpty()) ++valid;
			String type = ((String) view.getCom().getComboComType().getSelectedItem()).trim();
			if (type.isEmpty()) ++valid;
			String quadrant = ((String) view.getCom().getComboComQuadrant().getSelectedItem()).trim();
			if (quadrant.isEmpty()) ++valid;
			String zone = ((String) view.getCom().getComboComZoning().getSelectedItem()).trim();
			if (zone.isEmpty()) ++valid;
			if (valid == 0) {
				long id = 0;
				if (!view.getCom().getTxtfIdInfo().getText().isEmpty()) {
					id = Long.parseLong(view.getCom().getTxtfIdInfo().getText());
					valid = 1;
				}
				CommercialProperty c = null;
				try {
					c = new CommercialProperty(id,legal,address,quadrant,zone,price,comments,type, floors);
				} catch (InvalidLegalDescriptionException e) {
					setLblValid("              Invalid Legal Description",2,2); 
				}
				myBrokers.get(2).persist(c); 
				String msg = (valid==1)?"UPDATED":"ADDED";
				setLblValid("          The property was "+msg,2,1); 
				return true;
			} else {
				setLblValid("         Every Field Must Be Entered",2,2); 
				return false;
			}
		}

		/**
		 * This method controls all the actions for the Residential class
		 * @param Action Listener to implement
		 */
		private void residentialControl(ActionEvent e) {
			if (e.getSource() == view.getRes().getBtnSearch()) {
				clearSearch(1);
				setLblValid("",1,0); 
				getInputValue(1);
				if (validInput) {
					checkRdBtn(1);
					generateDB(1);
				} else if (!validInput){
					view.getRes().getListModel().addElement(" Please enter a valid Input.");
				}
			} else if (e.getSource() == view.getRes().getBtnClearSearch()) {
				view.getRes().getTxtfInputSearch().setText("");
				clearSearch(1);		
			}  else if (e.getSource() == view.getRes().getBtnClearInfo()) {
				clearInfo(1);
				setLblValid("",1,0);
			} else if (e.getSource() == view.getRes().getBtnDeleteInfo()) {
				removeById(1);
				clearInfo(1);
				clearSearch(1);
			} else if (e.getSource() == view.getRes().getBtnSaveInfo() && this.saveRes()) {
				clearInfo(1);
			}
		}
		/**
		 * This method validates, updates and creates a new Property class
		 * If the Id exist it updates the data, if the Id is blank it will generate a new unique Id.   
		 * @return true if the class was successfully created 
		 */
		private boolean saveRes() {
			int valid = 0;
			double price = 0;
			double footage = 0;
			double bathrooms = 0;
			int bedrooms = 0;
			String legal = view.getRes().getTxtfDescriptionResInfo().getText().toUpperCase();
			String address =view.getRes().getTxtfAddressResInfo().getText();
			if (address.isEmpty()) ++valid;
			String	priceS = view.getRes().getTxtfPriceResInfo().getText();
			if (priceS.isEmpty()) ++valid;
			else if(valid == 0 && validNum(priceS,false)) price = Double.parseDouble(priceS);
			else ++valid;
			String	footageS = view.getRes().getTxtfFootageResInfo().getText();
			if (footageS.isEmpty()) ++valid;
			else if(valid == 0 && validNum(footageS,false)) footage = Double.parseDouble(footageS);
			else ++valid;
			String	bathroomS = view.getRes().getTxtfBathroomsResInfo().getText();
			if (bathroomS.isEmpty()) ++valid;
			else if(valid == 0 && validNum(bathroomS,false)) bathrooms = Double.parseDouble(bathroomS);
			else ++valid;
			String	bedroomS = view.getRes().getTxtfBedroomsResInfo().getText();
			if (bedroomS.isEmpty()) ++valid;
			else if(valid == 0 && validNum(bedroomS,false)) bedrooms = (int)Double.parseDouble(bedroomS);
			else ++valid;
			String	comments = view.getRes().getTxtfCommentsResInfo().getText();
			if (comments.isEmpty()) ++valid;
			String garage = ((String) view.getRes().getComboResGType().getSelectedItem()).trim();
			if (garage.isEmpty()) ++valid;
			String quadrant = ((String) view.getRes().getComboResQuadrant().getSelectedItem()).trim();
			if (quadrant.isEmpty()) ++valid;
			String zone = ((String) view.getRes().getComboResZoning().getSelectedItem()).trim();
			if (zone.isEmpty()) ++valid;
			if (valid == 0) {
				long id = 0;
				if (!view.getRes().getTxtfIdInfo().getText().isEmpty()) {
					id = Long.parseLong(view.getRes().getTxtfIdInfo().getText());
					valid = 1;
				}
				ResidentialProperty r = null;
				try {
					r = new ResidentialProperty(id,legal,address,quadrant,zone,price,comments,footage,bathrooms,bedrooms,garage.charAt(0));
				} catch (InvalidLegalDescriptionException e) { setLblValid("              Invalid Legal Description",1,2);	}
				catch (InvalidNumberOfBathroomsException e) {}
				myBrokers.get(1).persist(r); 
				String msg = (valid==1)?"UPDATED":"ADDED";
				setLblValid("          The property was "+msg,1,1); 
				return true;
			} else {
				setLblValid("         Every Field Must Be Entered",1,2); 
				return false;
			}
		}

		/**
		 * This method controls all the actions for the Client class
		 * @param Action Listener to implement
		 */
		public void clientControl(ActionEvent e) {
			if (e.getSource() == view.getClient().getBtnSearch()) {
				clearSearch(0);
				setLblValid("",0,0); 
				getInputValue(0);
				if (validInput) {
					checkRdBtn(0);
					generateDB(0);
				} else if (!validInput){
					view.getClient().getListModel().addElement(" Please enter a valid Input.");
				}
			} else if (e.getSource() == view.getClient().getBtnClearSearch()) {
				view.getClient().getTxtfInputSearch().setText("");
				//				updateView(3);
				clearSearch(0);		
			}  else if (e.getSource() == view.getClient().getBtnClearInfo()) {
				clearInfo(0);
				setLblValid("",0,0);
			} else if (e.getSource() == view.getClient().getBtnDeleteInfo()) {
				removeById(0);
				clearInfo(0);
				clearSearch(0);
			} else if (e.getSource() == view.getClient().getBtnSaveInfo() && saveClient()) {
				clearInfo(0);
			}
		}
		/**
		 * This method validates, updates and creates a new Client class
		 * If the Id exist it updates the data, if the Id is blank it will generate a new unique Id.   
		 * @return true if the class was successfully created 
		 * @throws  
		 */
		private boolean saveClient() {
			int valid = 0;
			String firstName = view.getClient().getTxtfFirstNameClientInfo().getText();
			if (firstName.isEmpty()) ++valid;
			String	lastName = view.getClient().getTxtfLastNameClientInfo().getText();
			if (lastName.isEmpty()) ++valid;
			String address =view.getClient().getTxtfAddressClientInfo().getText();
			if (address.isEmpty()) ++valid;
			String	postalCode = view.getClient().getTxtfPostalClientInfo().getText().toUpperCase();
			if (postalCode.isEmpty()) ++valid;
			String	phoneNumber = view.getClient().getTxtPhoneClientInfo().getText();
			if (phoneNumber.isEmpty()) ++valid;
			String type = ((String) view.getClient().getComboClientType().getSelectedItem()).trim();
			if (type.isEmpty()) ++valid;
			if (valid == 0) {
				long id = 0;
				if (!view.getClient().getTxtfIdInfo().getText().isEmpty()) {
					id = Long.parseLong(view.getClient().getTxtfIdInfo().getText());
					valid = 1;
				}
				Client c = null;
				try {
					c = new Client(id,firstName,lastName,address,postalCode,phoneNumber,type.charAt(0));
				} catch (InvalidIdException |InvalidPhoneNumberException e) {
					setLblValid(" Invalid Phone, \"999-999-9999\"",0,2); 
				} catch (InvalidPostalCodeException e) {
					setLblValid(" Invalid PO, \"A9A 9A9\"",0,2); 
				}
				myBrokers.get(0).persist(c); 
				String msg = (valid==1)?"updated":"added";
				setLblValid("   The client was "+msg+" succesfully",0,1); 
				return true;
			} else {
				setLblValid("         Every Field Must Be Entered",0,2); 
				return false;
			}
		}

		/**
		 * This method gives a custom functionality to each button in the navigation Panel
		 * It also closes the myBrokers when the exit button is pressed. 
		 * @param Action Listener to implement
		 */
		public void navControl(ActionEvent e) {
			if (e.getSource() == view.getNav().getBtnClose()) {
				myBrokers.get(0).closeBroker();
				myBrokers.get(1).closeBroker();
				myBrokers.get(2).closeBroker();
				System.exit(0);
			} else if (e.getSource() == view.getNav().getBtnDashNav()) {
				updateView(1);
			} else if (e.getSource() == view.getNav().getBtnClientNav()) {
				updateView(2);
			} else if (e.getSource() == view.getNav().getBtnResidentialNav()) {
				updateView(3);
			} else if (e.getSource() == view.getNav().getBtnCommercialNav()) {
				updateView(4);
			}
		}

		/**
		 * This method paints the corresponding panels in order  
		 * @param index 1:Dashboard, 2:Client 3:Residential 4:Commercial 
		 */
		public void updateView(int index) {
			ArrayList<JPanel> views = new ArrayList<JPanel>();
			views.add(view.getNav().getContentPane());
			views.add(view.getDash().getContentPane());
			views.add(view.getClient().getContentPane());
			views.add(view.getRes().getContentPane());
			views.add(view.getCom().getContentPane());
			view.getWindowView().removeAll();
			view.getWindowView().add(views.get(0));
			view.getWindowView().add(views.get(index));
			view.setMovingPanel();
			view.revalidate();
			view.repaint();
		}

		/**
		 * This method validates if a string can be parse in to a digit. 
		 * @param number the string to be validated
		 * @param integer if true validates for integer if false it validates for doubles. 
		 * @return
		 */
		private boolean validNum(String number,boolean integer) {
			try {
				if(integer) Integer.parseInt(number); 
				else Double.parseDouble(number);}
			catch(NumberFormatException | NullPointerException e) {
				return false;
			}
			return true;
		}

		/**
		 * This method clears all the fields in the search JPanel 
		 */
		private void clearSearch(int myView) {
			searchType = "";
			searchWord = "";
			Method obj = null;
			try {
				obj = view.getClass().getMethod(myViews[myView]);
				((VillaGUI) obj.invoke(view)).getListModel().clear();
			} catch (NoSuchMethodException | SecurityException |  IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
			if (myDatabase.get(myView).size() > 0) myDatabase.get(myView).clear();
		}

		/**
		 * This method deletes an entire record from the database using its id 
		 */
		private void removeById(int myView) {
			setLblValid("",myView,0);
			Method obj = null;
			String id = null;
			try {
				obj = view.getClass().getMethod(myViews[myView]);
				id = ((VillaGUI) obj.invoke(view)).getTxtfIdInfo().getText();
				if (id.length()>0) {	
					myDatabase.set(myView,(ArrayList) ((Broker) myBrokers.get(myView)).search(id,"id"));
					((Broker) myBrokers.get(myView)).remove(myDatabase.get(myView).get(0));
					setLblValid("   The client was deleted succesfully",myView,1);
				}
			} catch (NoSuchMethodException | SecurityException |  IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		/**
		 * This method updates the info/warning JLabe in the information panel 
		 * @param message the string to be displayed 
		 * @param color 0:null, 1:green, 2:pink-red
		 */
		private void setLblValid(String message,int myView, int color) {
			Method obj = null;
			try {
				obj = view.getClass().getMethod(myViews[myView]);
				((VillaGUI) obj.invoke(view)).getLblValidInfo().setText(message);
				if (color != 0) {
					Color c = (color == 1)?new Color(60, 170, 120):new Color(235, 85, 160);
					((VillaGUI) obj.invoke(view)).getLblValidInfo().setBorder(new LineBorder(c, 2, false));
					((VillaGUI) obj.invoke(view)).getLblValidInfo().setForeground(c);
				} else 
					((VillaGUI) obj.invoke(view)).getLblValidInfo().setBorder(new EmptyBorder(0,0,0,0));
			} catch (NoSuchMethodException | SecurityException |  IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}			
		}

		/**
		 * This method clears all the fields in the information JPanel 
		 */
		private void clearInfo (int myView) {
			switch (myView) {
			case 0:
				view.getClient().clearFields();
				break;
			case 1:
				view.getRes().clearFields();
				break;
			case 2:
				view.getCom().clearFields();
				break;
			}
		}

	
		/**
		 * Reads and validates the input from the search panel
		 * @param myView the corresponding view to validate
		 */
		public void getInputValue(int myView) {
			Method obj = null;
			try {
				obj = view.getClass().getMethod(myViews[myView]);
				searchWord = ((VillaGUI) obj.invoke(view)).getTxtfInputSearch().getText();
				validInput = (searchWord != null || !searchWord.isEmpty())? true:false;
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		
		/**
		 * Method to load all the files found into the corresponding array. 
		 * @param myView the view to load
		 * @throws NumberFormatException
		 */
		public void generateDB(int myView) throws NumberFormatException {
			String caps = searchType.substring(0,1).toUpperCase() + searchType.substring(1);
			Method obj = null;
			try {
				obj = view.getClass().getMethod(myViews[myView]);
				myDatabase.set(myView,(ArrayList) ((Broker) myBrokers.get(myView)).search(searchWord,searchType));
				if (myDatabase.get(myView).size() != 0 && myView != 0) {
					for (Object c : myDatabase.get(myView))
						((VillaGUI) obj.invoke(view)).getListModel().addElement(" " + ((Property) c).getId() + " " +
								((Property) c).getLegalDescription() + " " + ((Property) c).getQuadrant() + " " + ((Property) c).getAskingPrice());
				} else if (myDatabase.get(myView).size() != 0 && myView == 0) {
					for (Object c : myDatabase.get(myView))
						((VillaGUI) obj.invoke(view)).getListModel().addElement(" " + ((Client) c).getId() + " " + ((Client) c).getFirstName()
								+ " " + ((Client) c).getLastName() + " " + ((Client) c).getClientType());
				} else {
					((VillaGUI) obj.invoke(view)).getListModel().addElement(" " + caps + " not found.");
					validInput = false;
				}
			} catch ( NoSuchMethodException | SecurityException | IllegalArgumentException | IllegalAccessException | InvocationTargetException e ) {
				try {
					((VillaGUI) obj.invoke(view)).getListModel().addElement(" " + caps + " not found.");
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
					e1.printStackTrace();
				}
				validInput = false;
			} 
		}

		/**
		 * This method checks which radio button is selected in any of the 3 views
		 * @param myView the view to validate 
		 */
		public void checkRdBtn(int myView) {
			Method obj = null;
			searchType = "";
			try {
				obj = view.getClass().getMethod(myViews[myView]);
				if (((VillaGUI) obj.invoke(view)).getRdBtnId().isSelected()) {
					validInput = validNum(searchWord,true);
					searchType = "id";
				} else if (((VillaGUI) obj.invoke(view)).getRdBtn2().isSelected())
					searchType = (myView == 0)?"type":"legal description";
				else if (((VillaGUI) obj.invoke(view)).getRdBtn3().isSelected()) {
					searchType = (myView == 0)?"name":"price";
					validInput = validNum(searchWord,true);					
				}
				else if (((VillaGUI) obj.invoke(view)).getRdBtn4().isSelected())
					searchType = "quadrant";
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This class implements ListSelectionListener and gives a custom functionality to the JLists in the GUI 
	 */
	class MyActionList implements ListSelectionListener {
		private int index = -1;
		public void valueChanged(ListSelectionEvent e) {
			if (e.getSource() == view.getClient().getJListSearch()) {
				index = view.getClient().getJListSearch().getSelectedIndex();
				if (validInput) {
					Client c = ( index != -1 && index >=0)? (Client)myDatabase.get(0).get(index):null;
					if (c != null) {				
						view.getClient().getTxtfIdInfo().setText(String.valueOf(c.getId()));
						view.getClient().getComboClientType().setSelectedItem(c.getClientType()+"");
						view.getClient().getTxtfFirstNameClientInfo().setText(c.getFirstName());
						view.getClient().getTxtfLastNameClientInfo().setText(c.getLastName());
						view.getClient().getTxtfAddressClientInfo().setText(c.getAddress());
						view.getClient().getTxtfPostalClientInfo().setText(c.getPostalCode());
						view.getClient().getTxtPhoneClientInfo().setText(c.getPhoneNumber());
					}
				}
			} else 	if (e.getSource() == view.getRes().getJListSearch()) {
				index = view.getRes().getJListSearch().getSelectedIndex();
				if (validInput) {
					ResidentialProperty r = ( index != -1 && index >=0)? (ResidentialProperty)myDatabase.get(1).get(index):null;
					if (r != null) {		
						view.getRes().getTxtfIdInfo().setText(r.getId()+"");
						view.getRes().getTxtfDescriptionResInfo().setText(r.getLegalDescription());
						view.getRes().getTxtfPriceResInfo().setText(r.getAskingPrice()+"");
						view.getRes().getTxtfFootageResInfo().setText(r.getArea()+"");
						view.getRes().getTxtfBathroomsResInfo().setText(r.getBathrooms()+"");
						view.getRes().getTxtfBedroomsResInfo().setText(r.getBedrooms()+"");
						view.getRes().getTxtfCommentsResInfo().setText(r.getComments());
						view.getRes().getTxtfAddressResInfo().setText(r.getAddress());
						view.getRes().getComboResGType().setSelectedItem(r.getGarage()+"");
						view.getRes().getComboResQuadrant().setSelectedItem(r.getQuadrant());
						view.getRes().getComboResZoning().setSelectedItem(r.getZone());
					}
				}
			}  else if (e.getSource() == view.getCom().getJListSearch()) {
				index = view.getCom().getJListSearch().getSelectedIndex();
				if (validInput) {
					CommercialProperty c = ( index != -1 && index >=0)? (CommercialProperty)myDatabase.get(2).get(index):null;
					if (c != null) {				
						view.getCom().getTxtfIdInfo().setText(c.getId()+"");
						view.getCom().getTxtfDescriptionComInfo().setText(c.getLegalDescription());
						view.getCom().getTxtfPriceComInfo().setText(c.getAskingPrice()+"");
						view.getCom().getTxtfFloorsComInfo().setText(c.getNoFloors() +"");
						view.getCom().getTxtfCommentsComInfo().setText(c.getComments());
						view.getCom().getTxtfAddressComInfo().setText(c.getAddress());
						view.getCom().getComboComType().setSelectedItem(c.getType()+"");
						view.getCom().getComboComQuadrant().setSelectedItem(c.getQuadrant());
						view.getCom().getComboComZoning().setSelectedItem(c.getZone());
					}
				}
			}
		}
	}
}

