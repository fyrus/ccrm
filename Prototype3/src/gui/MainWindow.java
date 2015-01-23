/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

import javax.swing.UIManager;

import common.*;

/**
 * @author Nastia
 *
 */
public class MainWindow extends JFrame implements ChatIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private EditCatalog editCatalog;
	private Catalog catalog;
	private ActivateMarketingCampaign activateMarketingCampaign;
	private AddNewCampaignMarketingPattern addNewCampaignMarketingPattern;
	private AddNewPermissionDetails addNewPermissionDetails;
	private AddNewProductToCatalog addNewProductToCatalog;
	private AddNewDomainToCatalog addNewDomainToCatalog;
	private AddNewTypeToCatalog addNewTypeToCatalog;
	private AssignProductToType assignProductToType;
	private AssignTypeToDomain assignTypeToDomain;
	private AddNewPotentialCustomer addNewPotentialCustomer;
	private CustomerSalesHistory customerSalesHistory;
	private NewSalesManEvent newSalesManEvent;
	private ReportSelector reportSelector;
	private CampaignReactionReportProduce campaignReactionReportProduce;
	private ManageLocations manageLocations;
	private PotentialCustomerSalesList potentialCustomerSalesList;
	private AddNewMarketSegment addNewMarketSegment;
	private JLabel lblEmployeePortal;
	
	public JButton btnExit;
	private JButton btnReports;
	private JButton btnEditCatalog;
	private JButton btnManageLocations;
	private JButton btnDefineMarketingPattern;
	private JButton btnCustomerSalesHistory;
	private JButton btnActivateMarketingCampaign;
	private JButton btnEnterAnalyticalSystem;
	private JButton btnNewPotentialCustomer;
	private JButton btnPotentialCustomerSales;
	private JLabel lblLogedInAs;
	private JLabel lblUserName;
	private JButton btnAddUser;
	private JButton btnAddMarketSegment;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setSize(700,480);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * sets the display depending on user role
	 */
	public void setDisplay(){
		if (Login.user.getRole().equals("MarketingManager")){
			btnReports.setEnabled(true);
			btnEditCatalog.setEnabled(true);
			btnManageLocations.setEnabled(true);
			btnDefineMarketingPattern.setEnabled(true);
			btnCustomerSalesHistory.setEnabled(true);
			btnActivateMarketingCampaign.setEnabled(true);
			btnEnterAnalyticalSystem.setEnabled(true);
			btnNewPotentialCustomer.setEnabled(true);
			btnPotentialCustomerSales.setEnabled(false);
			btnAddUser.setVisible(false);
		}
		else if (Login.user.getRole().equals("MarketingMan")){
			btnManageLocations.setEnabled(false);
			btnReports.setEnabled(false);
			btnNewPotentialCustomer.setEnabled(false);
			btnActivateMarketingCampaign.setEnabled(false);
			btnEditCatalog.setEnabled(true);
			btnDefineMarketingPattern.setEnabled(true);
			btnCustomerSalesHistory.setEnabled(true);
			btnEnterAnalyticalSystem.setEnabled(true);
			btnPotentialCustomerSales.setEnabled(false);
			btnAddUser.setVisible(false);

			
		}
		else if (Login.user.getRole().equals("CustomerRelations")){
			btnNewPotentialCustomer.setEnabled(true);
			btnReports.setEnabled(false);
			btnEditCatalog.setEnabled(false);
			btnManageLocations.setEnabled(false);
			btnDefineMarketingPattern.setEnabled(false);
			btnCustomerSalesHistory.setEnabled(false);
			btnActivateMarketingCampaign.setEnabled(false);
			btnEnterAnalyticalSystem.setEnabled(false);
			btnPotentialCustomerSales.setEnabled(false);
			btnAddUser.setVisible(false);

		}
		else if (Login.user.getRole().equals("SalesMan")){
			btnManageLocations.setEnabled(false);
			btnDefineMarketingPattern.setEnabled(false);
			btnReports.setEnabled(false);
			btnNewPotentialCustomer.setEnabled(false);
			btnEditCatalog.setEnabled(false);
			btnActivateMarketingCampaign.setEnabled(false);
			btnEnterAnalyticalSystem.setEnabled(false);
			btnCustomerSalesHistory.setEnabled(true);
			btnPotentialCustomerSales.setEnabled(true);
			btnAddUser.setVisible(false);

		}
		else if (Login.user.getRole().equals("Admin")){
			btnReports.setEnabled(true);
			btnEditCatalog.setEnabled(true);
			btnManageLocations.setEnabled(true);
			btnDefineMarketingPattern.setEnabled(true);
			btnCustomerSalesHistory.setEnabled(true);
			btnActivateMarketingCampaign.setEnabled(true);
			btnEnterAnalyticalSystem.setEnabled(true);
			btnNewPotentialCustomer.setEnabled(true);
			btnPotentialCustomerSales.setEnabled(true);
			btnAddUser.setVisible(true);

		}
		else
		{
			
			btnReports.setEnabled(false);
			btnEditCatalog.setEnabled(false);
			btnManageLocations.setEnabled(false);
			btnDefineMarketingPattern.setEnabled(false);
			btnCustomerSalesHistory.setEnabled(false);
			btnActivateMarketingCampaign.setEnabled(false);
			btnEnterAnalyticalSystem.setEnabled(false);
			btnNewPotentialCustomer.setEnabled(false);
			btnPotentialCustomerSales.setEnabled(false);
			btnAddUser.setVisible(false);

			
		}
		lblUserName.setText(Login.user.getName()+" " + "("+Login.user.getRole() +")");
	}
	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setName("CCRM");
		setTitle("CCRM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 468);
		
		contentPane = new JPanel();
		editCatalog = new EditCatalog();
		catalog=new Catalog();
		activateMarketingCampaign = new ActivateMarketingCampaign();
		addNewCampaignMarketingPattern = new AddNewCampaignMarketingPattern();
		addNewPermissionDetails = new AddNewPermissionDetails();
		addNewProductToCatalog = new AddNewProductToCatalog();
		addNewDomainToCatalog = new AddNewDomainToCatalog();
		addNewTypeToCatalog = new AddNewTypeToCatalog();
		assignProductToType = new AssignProductToType();
		assignTypeToDomain = new AssignTypeToDomain();
		addNewPotentialCustomer = new AddNewPotentialCustomer();
		customerSalesHistory = new CustomerSalesHistory();
		newSalesManEvent = new NewSalesManEvent();
		reportSelector = new ReportSelector();
		campaignReactionReportProduce = new CampaignReactionReportProduce();
		manageLocations = new ManageLocations();
		potentialCustomerSalesList = new PotentialCustomerSalesList();
		addNewMarketSegment = new AddNewMarketSegment();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		lblEmployeePortal = new JLabel("Employee Portal");
		lblEmployeePortal.setBounds(12, 13, 176, 25);
		lblEmployeePortal.setForeground(Color.PINK);
		lblEmployeePortal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lblEmployeePortal);
		
		btnExit = new JButton("Logout");
		
		btnExit.setBounds(482, 372, 188, 36);
		btnExit.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnExit.setBackground(new Color(230, 230, 250));
		contentPane.add(btnExit);
		
		btnReports = new JButton("Reports");
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(reportSelector);
				setVisible(true);
			}
		});
		btnReports.setBounds(482, 80, 188, 36);
		btnReports.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnReports.setBackground(new Color(230, 230, 250));
		contentPane.add(btnReports);
		
		btnEditCatalog = new JButton("Edit Catalog");
		btnEditCatalog.setBounds(482, 146, 188, 36);
		btnEditCatalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(editCatalog);
				setVisible(true);
			}
		});
		btnEditCatalog.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnEditCatalog.setBackground(new Color(230, 230, 250));
		contentPane.add(btnEditCatalog);
		
		btnManageLocations = new JButton("Manage Locations");
		btnManageLocations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(manageLocations);
				setVisible(true);
			}
		});
		btnManageLocations.setBounds(22, 80, 188, 36);
		btnManageLocations.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnManageLocations.setBackground(new Color(230, 230, 250));
		contentPane.add(btnManageLocations);
		/**
		 * Change panel to AddNewMarketingPattern
		 */
		btnDefineMarketingPattern = new JButton("New Campaign Pattern");
		btnDefineMarketingPattern.setBounds(248, 80, 188, 36);
		btnDefineMarketingPattern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(addNewCampaignMarketingPattern);
				setVisible(true);
			}
		});
		btnDefineMarketingPattern.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnDefineMarketingPattern.setBackground(new Color(230, 230, 250));
		contentPane.add(btnDefineMarketingPattern);
		/**
		 * Change panel to AddNewPermissionDetails
		 */
		btnCustomerSalesHistory = new JButton("Customer Sales History");
		btnCustomerSalesHistory.setBounds(22, 146, 188, 36);
		btnCustomerSalesHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(customerSalesHistory);
				setVisible(true);
			}
		});
		btnCustomerSalesHistory.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnCustomerSalesHistory.setBackground(new Color(230, 230, 250));
		contentPane.add(btnCustomerSalesHistory);
		/**
		 * Change panel to ActivateMarketingCampaign
		 */
		btnActivateMarketingCampaign = new JButton("Activate Marketing Campaign");
		btnActivateMarketingCampaign.setBounds(22, 216, 188, 36);
		btnActivateMarketingCampaign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(activateMarketingCampaign);
				setVisible(true);
				
			}
		});
		
		
		
		btnActivateMarketingCampaign.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnActivateMarketingCampaign.setBackground(new Color(230, 230, 250));
		contentPane.add(btnActivateMarketingCampaign);
		
		btnEnterAnalyticalSystem = new JButton("Enter Analytical System");
		btnEnterAnalyticalSystem.setBounds(482, 216, 188, 36);
		btnEnterAnalyticalSystem.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnEnterAnalyticalSystem.setBackground(new Color(230, 230, 250));
		contentPane.add(btnEnterAnalyticalSystem);
		
		btnNewPotentialCustomer = new JButton("New Potential Customer");
		btnNewPotentialCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(addNewPotentialCustomer);
				setVisible(true);
			}
		});
		btnNewPotentialCustomer.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnNewPotentialCustomer.setBackground(new Color(230, 230, 250));
		btnNewPotentialCustomer.setBounds(248, 146, 188, 36);
		contentPane.add(btnNewPotentialCustomer);
		
		btnPotentialCustomerSales = new JButton("Potential Customer Sales List");
		btnPotentialCustomerSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				potentialCustomerSalesList.setVisible(true);
			}
		});
		btnPotentialCustomerSales.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnPotentialCustomerSales.setBackground(new Color(230, 230, 250));
		btnPotentialCustomerSales.setBounds(248, 216, 188, 36);
		contentPane.add(btnPotentialCustomerSales);
		
		lblLogedInAs = new JLabel("Loged in as:");
		lblLogedInAs.setForeground(Color.BLACK);
		lblLogedInAs.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLogedInAs.setBounds(39, 312, 89, 25);
		contentPane.add(lblLogedInAs);
		
		lblUserName = new JLabel("**********");
		lblUserName.setForeground(Color.DARK_GRAY);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserName.setBounds(126, 315, 230, 19);
		contentPane.add(lblUserName);
		
		btnAddUser = new JButton("Add User");
		btnAddUser.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAddUser.setBackground(new Color(230, 230, 250));
		btnAddUser.setBounds(22, 372, 188, 36);
		contentPane.add(btnAddUser);
		
		btnAddMarketSegment = new JButton("Add Market Segment");
		btnAddMarketSegment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(addNewMarketSegment);
				setVisible(true);
			}
		});
		btnAddMarketSegment.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.PINK));
		btnAddMarketSegment.setBackground(new Color(230, 230, 250));
		btnAddMarketSegment.setBounds(482, 283, 188, 36);
		contentPane.add(btnAddMarketSegment);
		/**
		 * Change panel to MainWindow 
		 */
		
		
	
		
		activateMarketingCampaign.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				setVisible(true);
				
			}
		});
		
	
		
		
		addNewCampaignMarketingPattern.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				setVisible(true);
				
			}
		});
		/**
		 * Handle CustomerSalesHistory buttons
		 */
		customerSalesHistory.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				setVisible(true);
				
			}
		});
		
		customerSalesHistory.btnNewCustomerPermission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(addNewPermissionDetails);
				setVisible(true);
				
			}
		});
		customerSalesHistory.btnNewSalesEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(newSalesManEvent);
				setVisible(true);
				
			}
		});
		/**
		 * Handle newSalesManEvent buttons
		 */
		
		newSalesManEvent.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(customerSalesHistory);
				setVisible(true);
				
			}
		});
		
		
		/**
		 * Handle EditCatalog buttons
		 */
		editCatalog.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				setVisible(true);
				
			}
		});
		editCatalog.btnAddNewDomain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(addNewDomainToCatalog);
				setVisible(true);
				
			}
		});
		editCatalog.btnAddNewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(addNewProductToCatalog);
				setVisible(true);
				
			}
		});
		editCatalog.btnAddNewType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(addNewTypeToCatalog);
				setVisible(true);
				
			}
		});
		editCatalog.btnAssignProductTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(assignProductToType);
				setVisible(true);
				
			}
		});
				
		addNewTypeToCatalog.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(editCatalog);
				setVisible(true);
				
			}
		});
		addNewDomainToCatalog.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(editCatalog);
				setVisible(true);
				
			}
		});
		addNewProductToCatalog.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(editCatalog);
				setVisible(true);
				
			}
		});
		assignProductToType.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(editCatalog);
				setVisible(true);
				
			}
		});
		assignTypeToDomain.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(editCatalog);
				setVisible(true);
				
			}
		});
		editCatalog.btnViewCatalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(catalog);
				setVisible(true);
			}
		});
		addNewPotentialCustomer.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				setVisible(true);
			}
		});
		addNewPermissionDetails.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(customerSalesHistory);
				setVisible(true);
				
			}
		});
		manageLocations.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				setVisible(true);
				
			}
		});
		addNewPermissionDetails.btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "Would you like to add another permission?", null, JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.NO_OPTION)
					setContentPane(customerSalesHistory);
				else 
					setContentPane(addNewPermissionDetails);
				setVisible(true);
				
			}
		});
		reportSelector.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				setVisible(true);
			}
		});
		reportSelector.btnCampaignReactionReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(campaignReactionReportProduce);
				setVisible(true);
			}
		});
		campaignReactionReportProduce.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(reportSelector);
				setVisible(true);
			}
		});


		addNewMarketSegment.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(contentPane);
				setVisible(true);
			}
		});
		
		
		
		potentialCustomerSalesList.btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				potentialCustomerSalesList.setVisible(false);
				setVisible(true);
			}
		});
		
		
			
		
	}
	

	/* (non-Javadoc)
	 * @see common.ChatIF#display(java.lang.Object)
	 */
	@Override
	public void display(Object message) {
		// TODO Auto-generated method stub
		
	}

}
