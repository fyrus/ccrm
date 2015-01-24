
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

import javax.swing.JTextArea;

import client.ChatClient;
import common.*;

import javax.swing.JTextField;

import entities.*;

import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class MainFrame extends JFrame implements ChatIF{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5833343806043864671L;
	private JPanel contentPane;
	ChatClient client;
	private JTextField tfName;
	private JTextArea txtArea;
	private JScrollPane scrollPane;
	private JTextField tfId;
	private JTextField tfBday;
	private JTextField tfLocation;
	private JTextField tfPhone;
	private JTextField tfChangeid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		try 
		{
			client= new ChatClient("localhost",5555,this);
		} 
		catch(IOException exception) 
		{
			System.out.println("Error: Can't setup connection!"
					+ " Terminating client.");
			System.exit(1);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnClickMe = new JButton("click me");
		btnClickMe.setBounds(297, 215, 108, 36);
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Command cmd=new Command();
				
				
				
				Customer c1 = new Customer();
				c1.setcBirthDate(new Date(875675687L));
				c1.setcLocation(tfLocation.getText());
				c1.setcName(tfName.getText());
				c1.setcPhone(tfPhone.getText());
				c1.setcId(tfId.getText());
				
				
				
				RegisteredCustomer r1 = new RegisteredCustomer();
				r1.setcBirthDate(new Date(875675687L));
				r1.setcLocation(tfLocation.getText());
				r1.setcName(tfName.getText());
				r1.setcPhone(tfPhone.getText());
				r1.setcId(tfId.getText());
				
				Permission pp = new Permission();
				//pp.setCid(Integer.parseInt(tfName.getText()));
				//pp.setDid(Integer.parseInt(tfBday.getText()));
				
				entities.Type t1 = new entities.Type();
				//t1.setDid(Integer.parseInt(tfBday.getText()));
				t1.setTname(tfName.getText());
				
				Domain d1 = new Domain();
				d1.setdName(tfName.getText());
				
				
				Customer c2 = new Customer();
				c2.setcId("123");
				
				Customer c3 = new Customer();
				c3.setcId("6788889");
				c3.setcBirthDate(new Date(Calendar.getInstance().getTimeInMillis()));
				
				MarketingCampaign m1 = new MarketingCampaign();
				m1.setStartdate(new Date(0));
				m1.setEnddate(new Date(0));
				m1.AddCustomer(c2);
				m1.AddCustomer(c3);
				
				Sale s1 = new Sale();
				s1.setBuy(true);
				s1.setComments("buy stuff good item this");
				s1.setCustomerid("123");
				s1.setItemid(13);
				s1.setSaleDate(new Date(112324));
				
				Product p1 = new Product();
				p1.setPdescription("fff44");
				p1.setPname("aaa44");
				p1.setPphoto("bbbbb");
				p1.setPprice(13);
				p1.setPid(2);
				
				Location l1 = new Location();
				//l1.setLid(Integer.parseInt(tfId.getText()));
				
				MarketingSegment ms = new MarketingSegment();
				ms.setAge(12);
				ms.setImportance(1);
				ms.setInterest(1);
				ms.setLocation(1);
				
				ProductType pt = new ProductType();
				pt.setProductid(1);
				pt.setTypeid(1);
				
				
				cmd.setComVal(pt);
				cmd.setComExtra("2", null);
				cmd.setComNum(Com.ADD_PRODUCTTYPE);
				//cmd.setComExtra(tfId.getText(), null);
				client.handleMessageFromClientUI(cmd);
			}
		});
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtArea.setText("");
				Command cmd=new Command();
				Product p1 = new Product();
				Location l1 = new Location();
				Customer c1 = new Customer();
				RegisteredCustomer r1 = new RegisteredCustomer();
				Permission pp = new Permission();
				entities.Type t1 = new entities.Type();
				Domain d1 = new Domain();
				MarketingCampaign m1 = new MarketingCampaign();
				Sale s1 = new Sale();
				cmd.setComVal(p1);
				cmd.setComNum(Com.SEARCH_PRODUCT);
				client.handleMessageFromClientUI(cmd);
			}
		});
		btnSearch.setBounds(297, 300, 89, 23);
		contentPane.add(btnSearch);
		contentPane.setLayout(null);
		contentPane.add(btnClickMe);


		//textArea.add(scroll);

		tfName = new JTextField();
		tfName.setBounds(87, 260, 200, 30);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 395, 193);
		contentPane.add(scrollPane);
		
		txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		txtArea.setAutoscrolls(false);
		txtArea.setEditable(false);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(87, 215, 200, 30);
		contentPane.add(tfId);
		
		tfBday = new JTextField();
		tfBday.setColumns(10);
		tfBday.setBounds(87, 301, 200, 30);
		contentPane.add(tfBday);
		
		tfLocation = new JTextField();
		tfLocation.setColumns(10);
		tfLocation.setBounds(87, 342, 200, 30);
		contentPane.add(tfLocation);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(87, 382, 200, 30);
		contentPane.add(tfPhone);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(31, 226, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(31, 268, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblBday = new JLabel("bday");
		lblBday.setBounds(31, 309, 46, 14);
		contentPane.add(lblBday);
		
		JLabel lblLocation = new JLabel("location");
		lblLocation.setBounds(31, 350, 46, 14);
		contentPane.add(lblLocation);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setBounds(31, 390, 46, 14);
		contentPane.add(lblPhone);
		
		tfChangeid = new JTextField();
		tfChangeid.setBounds(338, 387, 86, 20);
		contentPane.add(tfChangeid);
		tfChangeid.setColumns(10);
		
		JLabel lblIdToChange = new JLabel("id to change");
		lblIdToChange.setBounds(338, 360, 86, 14);
		contentPane.add(lblIdToChange);
		
		
	}

	@Override
	public void display(Object msg) {
		StringBuilder sb = new StringBuilder();
		if (msg instanceof ArrayList<?>) {
			for(Object key:((ArrayList<?>)msg).toArray()){
				if(key instanceof Customer){
					sb.append("Customer id: "+ ((Customer)key).getcId() + "\n");
					sb.append("Customer name: "+ ((Customer)key).getcName() + "\n");
					sb.append("Customer phone: "+ ((Customer)key).getcPhone() + "\n");
					sb.append("Customer location: "+ ((Customer)key).getcLocation() + "\n");
					sb.append("Customer date: "+ ((Customer)key).getcBirthDate() + "\n");
				}
				
				if(key instanceof RegisteredCustomer){
					sb.append("Customer pid: "+ ((RegisteredCustomer)key).getPermission() + "\n");
				}
				
				if(key instanceof Domain){
					sb.append("Domain id: "+ ((Domain)key).getDid() + "\n");
					sb.append("Domain name: "+ ((Domain)key).getdName() + "\n");
				}
				
				if(key instanceof Location){
					sb.append("Domain id: "+ ((Location)key).getLid() + "\n");
					sb.append("Domain name: "+ ((Location)key).getLocation() + "\n");
				}
				
				if(key instanceof Product){
					sb.append(((Product)key).getPdescription() + "\n");
					sb.append(((Product)key).getPid() + "\n");
					sb.append(((Product)key).getPname() + "\n");
					sb.append(((Product)key).getPphoto() + "\n");
					sb.append(((Product)key).getPprice() + "\n");
				}
				
				if(key instanceof Permission){
					sb.append(((Permission)key).getPid() + "\n");
					sb.append(((Permission)key).getCid() + "\n");
					sb.append(((Permission)key).getDid() + "\n");
				}
				
				if(key instanceof entities.Type){
					sb.append(((entities.Type)key).getDid() + "\n");
					sb.append(((entities.Type)key).getTid() + "\n");
					sb.append(((entities.Type)key).getTname() + "\n");
				}
				
				if(key instanceof MarketingCampaign){
					sb.append(((MarketingCampaign)key).getCid() + "\n");
					sb.append(((MarketingCampaign)key).getStartdate() + "\n");
					sb.append(((MarketingCampaign)key).getEnddate() + "\n");
				}
				
				if(key instanceof Sale){
					sb.append(((Sale)key).getBuy() + "\n");
					sb.append(((Sale)key).getComments()+ "\n");
					sb.append(((Sale)key).getCustomerid() + "\n");
					sb.append(((Sale)key).getItemid()+ "\n");
					sb.append(((Sale)key).getSaleDate() + "\n");
				}
				
				sb.append("\n");
				txtArea.setText(sb + "\n");
				
			}
		}
	}
}
