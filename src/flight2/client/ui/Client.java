package flight2.client.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import flight2.db.model.FlightReservationVO;
import flight2.exception.DatabaseException;
import flight2.protocol.Protocol;

import java.io.*;
import java.net.*;
public class Client extends JFrame implements ActionListener{
	
	Protocol p;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Socket soc;
	/** This field is graphic user interface for client.*/
	private Client c;
	
	// 생성자
	public Client(){
		super("Flight Reservation System");
		c = this;
		p = new Protocol();
		mainGUI();
		try {setAllTable(p.getAllReservationInfo());} catch (DatabaseException e) {e.printStackTrace();}
	}
	
	//메인메소드 - 서버 돌리고 실행
	//Object row[] = {"SA001", "SFO", "DEN", "SpeedyAir","400", "Sun","13:40", "20m", "50"};
	public static void main(String[] args){		
		Client c = new Client();
		System.out.println();
		
	}
	/*private void setAllTable() {
		// TODO Auto-generated method stub
		
	}*/
	public void setAllTable(ArrayList<FlightReservationVO>list) {
		// TODO Auto-generated method stub
		String[] columnNames = {"Flight_number", "Origin airport", "Destination airport", "Carrier", "Price", "Day", "Time", "Duration", "Available seats"};
		TableColumn col; 
		DefaultTableCellRenderer rend = null;
		tm = new DefaultTableModel(columnNames,0)
		{public boolean isCellEditable(int r, int c) {return false;}};	
		searchTable.setRowHeight(12);
		//searchTable.setShowVerticalLines(false);
		/*int count = tcm.getTotalColumnWidth();
		System.out.println(count);*/
		
		
		for(FlightReservationVO dto : list){
			Object row[] = {dto.getFlight_number(),dto.getOrigin_airport(),dto.getDestination_airport(),dto.getCarrier(),
							dto.getPrice(),dto.getDay(),dto.getTime(),dto.getDuration(),dto.getAvailable_seat()};
			((DefaultTableModel) tm).addRow(row);
			searchTable.setModel(tm);
		}
	}

	/** This field is for addChoiceItem method of this class.*/
	private HashSet originHS, destinationHS, carrierHS, dayHS;

	/** This field is for current date and time.*/
	private Date date;

	/** This field is for mainGUI method component.*/
	private JPanel			tPanel,mainPanel,mainNorth,mainNorthUnder, 																															mainNorthLeft,mainNorthRight,mainNorthRightUnder,
									northHeader,northLabel,northChoice,searchlabel,bookingLine,
									mainSouthPanel,south,southlist;

	/** This field is for mainGUI method component.*/
	private JLabel			title,h1,h2,h3,h4;
	private JLabel m1;
	private JLabel m2;
	private JLabel m3;
	private JLabel m4;
	private JLabel m5;
	private JLabel m6;
	private JLabel m7;
	private JLabel m8;
	private JLabel m9;
	private JLabel m10;
	private JLabel s2;
	private JLabel s3;
	private JLabel s4;
	private JLabel s5;
	private JLabel s6;
	private JLabel s7;
	private JLabel s8;
	private JLabel s9;
	private JLabel plane;
	private JLabel status;
	
	/** This field is for mainGUI method component.*/
	private JComboBox		origin,destination,carrier,day;

	/** This field is for mainGUI method component.*/
	private JButton			search, booking;

	/** This array type field is for mainGUI method component.*/
	private JLabel[]			mtf;
	/*private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;*/
	/** This field is for mainGUI method component.*/
	private JTextField		mtf10;

	/** This field is for mainGUI method component.*/
	private JScrollPane		scrollPane;

	/** This field is for mainGUI method component.*/
	private TableModel		tm;

	/** This field is for mainGUI method component.*/
	private TitledBorder		searchTB, bookTB;

	/** This field is for mainGUI method component.*/
	private JTable				searchTable;
	
	/** This field is for searchTable field.*/
	private Object[][]			tableData;
	
	/** This field is for searchTable field.*/
	private String[]			columnNames; 
	
	/** This field is for mainGUI method component.*/
	private ImageIcon		pro;
	
	/** This field is for booking confirmation.*/
	private int					confirm;
	

	/**
	* This constructor initialize this class and call the <code>showMode</code> method.<br>
	*/
	


	/**
	* This method return the heading menu for search result table through
	* String array.<p>
	* The array is taken from data object.<br>
	* This return value is used for setting up the search result table.<br>
	*/	
	/*public String[] printMenu() {
		int col = 0;
		String[] columnNames = {"Flight number", "Origin airport", "Destination airport", "Carrier", "Price", "Day", "Time", "Duration", "Available seats"};
		
		return columnNames;
	}*/
	
	/**
	* This method return the all avaialible data for search result table through
	* <code>Object two dimensional array</code>.<p>
	* The array is taken from data object.<br>
	* This return value is used for setting up the search result table.<br>
	*/	
	/*public Object[][] printAllData() {
		int row = 0; //레코드 개수
		int col = 0; //필드 개수
		
		tableData = new Object[row][col];

		
		return tableData; 
	}*/
	

	/**
	* This method initialize the search items in <code>Search section</code>.<p>
	* There are four kind of category In search section<br>
	* <code>; Origin airport, Destination airport, Carrier, Day.</code><p>
	* Refer to the above category, this method take the all field from data object<br>
	* Especially, this field datas are managed by <code>HashSet</code>to avoid data duplication.<br>
	*/
	
	
	/**
	* This method create the main window for client service through <code>Swing components</code><br>
	*/
	public void mainGUI() {
		//creation of each component!
		date = new Date();
		Color option = new Color(232,232,232);
		Font f = new Font("Times New Roman",Font.BOLD,25);
		Color black = new Color(0,0,0);
		Color Nleft = new Color(200,227,227);
		Color heading = new Color(0,100,200);
		Color Nheader = new Color(239,239,222);
		Color Nright = new Color(200,227,227);
		tPanel = new JPanel();
		mainPanel = new JPanel();
		mainNorth = new JPanel();
		mainNorthUnder = new JPanel();
		mainNorthLeft = new JPanel();
		mainNorthRight = new JPanel();
		mainNorthRightUnder = new JPanel();
		bookingLine = new JPanel();
		mainSouthPanel = new JPanel();
		northHeader = new JPanel();
		northLabel = new JPanel();
		northChoice = new JPanel();
		searchlabel = new JPanel();
		south = new JPanel();
		southlist = new JPanel();

		title = new JLabel("  FLIGHT RESERVATION SYSTEM  ");
		origin = new JComboBox();	origin.addItem("Any");origin.addItem("SFO");origin.addItem("DAL");
									origin.addItem("FRA");origin.addItem("BOM");origin.addItem("DEN");
									origin.addItem("ABQ");origin.addItem("ATL");
									origin.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		destination = new JComboBox();	destination.addItem("Any");destination.addItem("DEN");		 
										destination.addItem("LHR");destination.addItem("LAX");
										destination.addItem("SFO");destination.addItem("FRA");
										destination.addItem("ABQ");destination.addItem("DAL");
										destination.addItem("BOM");
										destination.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		carrier = new JComboBox();	carrier.addItem("Any"); 
									carrier.addItem("SpeedyAir"); 
									carrier.addItem("PrompAir"); 
									carrier.addItem("RainvilleAir"); 
									carrier.addItem("BeethAir"); 
									carrier.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));			
		
		day = new JComboBox();	day.addItem("Any"); day.addItem("Sun");day.addItem("Mon");day.addItem("Tue");
								day.addItem("Wed");day.addItem("Thu");day.addItem("Fri");day.addItem("Sat");
								day.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));			
		
		search = new JButton("SEARCH"); search.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		search.addActionListener(this);

		h1 = new JLabel("   Origin airport ");						
		h2 = new JLabel("   Destination airport ");
		h3 = new JLabel("   Carrier ");
		h4 = new JLabel("   Day ");
		m1 = new JLabel("Flight  No",JLabel.CENTER);			
		m2 = new JLabel("Origin",JLabel.CENTER);
		m3 = new JLabel("Destination",JLabel.CENTER);
		m4 = new JLabel("Carrier",JLabel.CENTER);
		m5 = new JLabel("Price",JLabel.CENTER);
		m6 = new JLabel("Day",JLabel.CENTER);
		m7 = new JLabel("Time",JLabel.CENTER);
		m8 = new JLabel("Duration",JLabel.CENTER);
		m9 = new JLabel("Availible seat",JLabel.CENTER);
		m10 = new JLabel(" Your Booking Quantity >> ",JLabel.CENTER);
		s2= new JLabel();
		s3= new JLabel();
		s4= new JLabel();
		s5= new JLabel();
		s6= new JLabel();
		s7= new JLabel();
		s8= new JLabel();
		s9= new JLabel();
		booking = new JButton(" BOOKING ");booking.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		booking.setBackground(option);

		
		booking.setEnabled(false);
		booking.addActionListener(this);
		
		
		mtf = new JLabel[9];
		
		for (int i=0;i<mtf.length;i++){
			mtf[i] = new JLabel("  ",JLabel.CENTER);
			mtf[i].setOpaque(true);
			mtf[i].setBackground(option);
			mtf[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		}

		mtf10					= new JTextField(5);
		status					= new JLabel("",JLabel.CENTER);status.setOpaque(true); status.setBackground(option); status.setForeground(Color.blue); status.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		plane	 					= new JLabel();
				
	
		searchTable		=	new JTable(tm);
		(searchTable.getTableHeader()).setReorderingAllowed(false);
		searchTable.getTableHeader().setResizingAllowed(false);
		searchTable.getTableHeader().setBackground(Color.cyan);
		searchTable.setCellSelectionEnabled(false);
		searchTable.setRowSelectionAllowed(true);
		
		
		scrollPane = new JScrollPane(searchTable);
		
		// attach listener for table
		searchTable.addMouseListener(new TableHandler());
		
		//north area attach
		title.setFont(f);
		title.setForeground(heading);
		title.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		northHeader.add(title);
		northHeader.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		northHeader.setBackground(Nheader);

		northLabel.setLayout(new GridLayout(5,1,3,1));
		northLabel.setBackground(Nleft);
		northLabel.add(h1);
		northLabel.add(h2);
		northLabel.add(h3);
		northLabel.add(h4);
		northLabel.add(new JLabel("   Please Click  >>> "));
		northChoice.setLayout(new GridLayout(5,1,3,1));
		origin.setBackground(option);
		northChoice.add(origin);
		northChoice.add(destination);
		destination.setBackground(option);
		northChoice.add(carrier);
		carrier.setBackground(option);
		northChoice.add(day);
		day.setBackground(option);
		northChoice.add(search);
		search.setBackground(option);

		mainNorthLeft.setLayout(new GridLayout(1,2));
		mainNorthLeft.add(northLabel);
		mainNorthLeft.add(northChoice);
		mainNorthLeft.setBackground(Nleft);
		
		searchTB				= new TitledBorder("");
		searchTB.setTitlePosition(TitledBorder.CENTER);
		searchTB.setTitleJustification(TitledBorder.CENTER);
		searchTB.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		mainNorthLeft.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(searchTB,"Search Section"),BorderFactory.createBevelBorder(BevelBorder.RAISED)));


		searchlabel.setBackground(Nheader);
		searchlabel.setLayout(new GridLayout(2,9));
		m1.setForeground(black);m2.setForeground(black);m3.setForeground(black);m4.setForeground(black);
		m5.setForeground(black);m6.setForeground(black);m7.setForeground(black);m8.setForeground(black);
		m9.setForeground(black);
		searchlabel.add(m1);
		searchlabel.add(m2);
		searchlabel.add(m3);
		searchlabel.add(m4);
		searchlabel.add(m5);
		searchlabel.add(m6);
		searchlabel.add(m7);
		searchlabel.add(m8);
		searchlabel.add(m9);
		
		for (int i=0;i<mtf.length;i++){
			searchlabel.add(mtf[i]);			
		}
		
		mainNorthRight.setLayout(new BorderLayout(1,17));
		mainNorthRight.add(searchlabel,"North");
		
		
		
		bookingLine.setBackground(Nheader);
		bookingLine.setLayout(new FlowLayout(1,3,1));
		bookingLine.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		pro = new ImageIcon("air.gif");
		plane.setIcon(pro);
		
		bookingLine.add(m10);
		bookingLine.add(mtf10);
		bookingLine.add(booking);
		bookingLine.add(plane);
		mainNorthRight.add(bookingLine);
		status.setText(date.toString());
		mainNorthRight.add(status,"South");

		bookTB				= new TitledBorder("");
		bookTB.setTitlePosition(TitledBorder.CENTER);
		bookTB.setTitleJustification(TitledBorder.CENTER);
		bookTB.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		mainNorthRight.setBorder(bookTB);
		mainNorthRight.setBackground(Nright);
		mainNorthRight.setBorder(new CompoundBorder(BorderFactory.createTitledBorder(bookTB,"Booking Section"),BorderFactory.createBevelBorder(BevelBorder.RAISED)));
	
		mainNorthUnder.setLayout(new BorderLayout(5,10));
		mainNorthUnder.add(mainNorthLeft,"West");
		mainNorthUnder.add(mainNorthRight,"Center");
		mainNorthUnder.setBackground(Nheader);

		mainNorth.setLayout(new BorderLayout());
		mainNorth.add(northHeader,"North");
		mainNorth.add(mainNorthUnder,"Center");
		Color northForeground = new Color(210,230,210);
		mainNorth.setBackground(Nheader);

		//south area attach
		southlist.setLayout(new GridLayout(1,1));
		southlist.add(scrollPane);
		south.setLayout(new GridLayout(1,1));
		south.add(southlist);
		//north and south panel attach to main panel 
		mainPanel.setLayout(new BorderLayout(5,5));
		mainPanel.add(mainNorth,"Center");
		mainSouthPanel.setLayout(new GridLayout(1,1));
		mainSouthPanel.add(south);
		tPanel.setLayout(new BorderLayout(5,5));
		tPanel.add(mainPanel,"North");
		tPanel.add(mainSouthPanel,"Center");
		tPanel.setBackground(Nheader);

		//frame attach
		getContentPane().add(tPanel);
		setSize(980,600);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent w) {
				System.exit(0);					
			}
		});
		Dimension d = c.getToolkit().getScreenSize();
			c.setLocation(d.width/2 - c.getWidth()/2, d.height/2 -c.getHeight()/2);
			c.setVisible(true);

	}

	
	
		
	

	/**
	* This method brings up a dialog displaying a message.<p>
	* Refer to the int type parameter, the MessageDialog would be decided.<br>
	*@param int type The type number of the database file to open. 
	*@param String msg The name of the database file to open. 
	*/
	public void showMessage(int type, String msg){
			switch(type){
								/**
								* Brings up a dialog displaying a message, specifying all parameters.
								*
							    * @param c determines the <code>Frame</code> in which the
								*			dialog is displayed; if <code>null</code>,
								*			or if the <code>parentComponent</code> has no
								*			<code>Frame</code>, a  default <code>Frame</code> is used.
								* @param msg   the <code>Object</code> to display.
								* @param "Flight Reservation"     the title string for the dialog.
								* @param JOptionPane.INFORMATION_MESSAGE the type of message to be displayed:
								*                    ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE,
								*                    QUESTION_MESSAGE, or PLAIN_MESSAGE.
								* @param null or JOptionPane.QUESTION_MESSAGE means an icon to display in the dialog 
								*					that helps the user identify the kind of message that is being displayed.
								*/
				case 1:		JOptionPane.showMessageDialog
								(c, msg, "Flight Reservation", JOptionPane.INFORMATION_MESSAGE, null);
								break;
				case 2:		confirm = JOptionPane.showConfirmDialog
								(c, msg, "Flight Reservation",  JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			}
	}
	
	/**
	* This <code>TableHandler</code> inner class is for search result table event handling.<br>
	*/
	class TableHandler extends MouseAdapter{
		/**
		* This method handles event of mouse click in the search result table.<p> 
		* When the event is occurred, this method takes the row data and carry<br>
		* this data to <code>Booking section</code>.  
		*/
		public void mouseClicked(MouseEvent e) {
			
			//클릭하면 자동으로
			status.setText("You can reserve above available seats. current time : "+date.toString());
			booking.setEnabled(true);
			c.mtf10.setText("");
			c.mtf10.requestFocus();
			booking.setEnabled(true);

			int index = searchTable.getSelectedRow();
			int column = tm.getColumnCount();
			//System.out.println(column);
			//테스트용
			for(int i=0;i<column;i++){System.out.println(searchTable.getValueAt(index, i));}
			///테이블 자료를 위의 예약칸에 나눠서 넣기
			
			//int가 있으니까 그냥 다 때려넣기
			mtf[0].setText((String)searchTable.getValueAt(index, 0));
			mtf[1].setText((String)searchTable.getValueAt(index, 1));
			mtf[2].setText((String)searchTable.getValueAt(index, 2));
			mtf[3].setText((String)searchTable.getValueAt(index, 3));
			mtf[4].setText(String.valueOf(searchTable.getValueAt(index, 4)));
			mtf[5].setText((String)searchTable.getValueAt(index, 5));
			mtf[6].setText((String)searchTable.getValueAt(index, 6));
			mtf[7].setText((String)searchTable.getValueAt(index, 7));
			mtf[8].setText(String.valueOf(searchTable.getValueAt(index, 8)));
				
			//mtf[i].setText(String.searchTable.getValueAt(index, i));
			
		}
	}

	/**This <code>TableModel</code> Innerclass is for setting up a function of search result table.*/
	
	
	/**
	* This metohd handle the four kinds of button event<p>
	* <code> SEARCH, BOOKING</code><br>
	* 
	*/
	public void actionPerformed(ActionEvent ae){
		Object source = ae.getSource();
		
		//combobox item
		if(search==source){
			//origin,destination,carrier,day;
			//if("SpeedyAir".equals(carrier))
		if(origin.getSelectedItem().equals("Any")){
			
				System.out.print("\n"+origin.getSelectedItem() + " : ");
				try {
					setAllTable(p.getAllReservationInfo());
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}else if("SFO".equals(origin.getSelectedItem())){
					
				}else if("LAX".equals(origin.getSelectedItem())){
					System.out.print("\n"+origin.getSelectedItem() + " : ");
				}else if("DAL".equals(origin.getSelectedItem())){
					System.out.print("\n"+origin.getSelectedItem() + " : ");
				}else if("FRA".equals(origin.getSelectedItem())){
					System.out.print("\n"+origin.getSelectedItem() + " : ");
				}else if("BOM".equals(origin.getSelectedItem())){
					System.out.print("\n"+origin.getSelectedItem() + " : ");
				}else if("DEN".equals(origin.getSelectedItem())){
					System.out.print("\n"+origin.getSelectedItem() + " : ");
				}else if("ABQ".equals(origin.getSelectedItem())){
					System.out.print("\n"+origin.getSelectedItem() + " : ");
				}else if("ATL".equals(origin.getSelectedItem())){
					System.out.print("\n"+origin.getSelectedItem() + " : ");
					
		}if(destination.getSelectedItem().equals("Any")){
			System.out.print("\n"+destination.getSelectedItem() + " : ");
			try {
				setAllTable(p.getAllReservationInfo());
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}else if("ABQ".equals(destination.getSelectedItem())){
				System.out.print("\n"+destination.getSelectedItem() + " : ");
			}else if("DEN".equals(destination.getSelectedItem())){
				System.out.print("\n"+destination.getSelectedItem() + " : ");
			}else if("LHR".equals(destination.getSelectedItem())){
				System.out.print("\n"+destination.getSelectedItem() + " : ");
			}else if("LAX".equals(destination.getSelectedItem())){
				System.out.print("\n"+destination.getSelectedItem() + " : ");
			}else if("SFO".equals(destination.getSelectedItem())){
				System.out.print("\n"+destination.getSelectedItem() + " : ");
			}else if("FRA".equals(destination.getSelectedItem())){
				System.out.print("\n"+destination.getSelectedItem() + " : ");
			}else if("DAL".equals(destination.getSelectedItem())){
				System.out.print("\n"+destination.getSelectedItem() + " : ");
			}else if("BOM".equals(destination.getSelectedItem())){
				System.out.print("\n"+destination.getSelectedItem() + " : ");
			}else if("FRA".equals(destination.getSelectedItem())){
				System.out.print("\n"+destination.getSelectedItem() + " : ");
				
		
		}if(carrier.getSelectedItem().equals("Any")){
				System.out.print("\n"+carrier.getSelectedItem() + " : ");
				try {
					setAllTable(p.getAllReservationInfo());
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
			}else if("SpeedyAir".equals(carrier.getSelectedItem())){
				System.out.print("\n"+carrier.getSelectedItem() + " : ");
				
			
				
				
				
			}else if("PrompAir".equals(carrier.getSelectedItem())){
				System.out.print("\n"+carrier.getSelectedItem() + " : ");
				
				
				
			}else if("RainvilleAir".equals(carrier.getSelectedItem())){
				System.out.print("\n"+carrier.getSelectedItem() + " : ");
				
				
				
				
				
			}else if("BeethAir".equals(carrier.getSelectedItem())){
				System.out.print("\n"+carrier.getSelectedItem() + " : ");
				
				
				
				
// 요일검색			
			}if(day.getSelectedItem().equals("Any")){
				System.out.print("\n"+day.getSelectedItem() + " : ");
				try {
					setAllTable(p.getAllReservationInfo());
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if("Sun".equals(day.getSelectedItem())){
				System.out.print("\n"+day.getSelectedItem() + " : ");
				
				
				
				
				
			}else if("Mon".equals(day.getSelectedItem())){
				System.out.print("\n"+day.getSelectedItem() + " : ");
				
				
				
				
				
			}else if("Tue".equals(day.getSelectedItem())){
				System.out.print("\n"+day.getSelectedItem() + " : ");
				
				
				
				
				
			}else if("Wed".equals(day.getSelectedItem())){
				System.out.print("\n"+day.getSelectedItem() + " : ");
				
				
				
				
				
			}else if("Thu".equals(day.getSelectedItem())){
				System.out.print("\n"+day.getSelectedItem() + " : ");
				
				
				
				
				
			}else if("Fri".equals(day.getSelectedItem())){
				System.out.print("\n"+day.getSelectedItem() + " : ");
				
				
				
				
				
			}else if("Sat".equals(day.getSelectedItem())){
				System.out.print("\n"+day.getSelectedItem() + " : ");
				
				
				
				
				
			}
			
			/*if(origin.equals(origin.getSelectedItem())){
				System.out.println(origin.getSelectedItem());
			}else if(destination==source){
				System.out.println(destination.getSelectedItem());
			}else if(carrier==source){
				System.out.println(carrier.getSelectedItem());
			}else if(day==source){
				System.out.println(day.getSelectedItem());
			}	System.out.println("한바큉");*/
			
			//Object RowData[][]  = {{"SA001", "SFO", "DEN", "SpeedyAir","400", "Sun","13:40", "20m", "50"}};
			//tm.setDataVector(RowData, columnNames);
			/*Object row[] = {"SA001", "SFO", "DEN", "SpeedyAir","400", "Sun","13:40", "20m", "50"};
			tm.addRow(row);*/
		}
		else if(booking==source){
			
			if(mtf10.equals("")){
				JOptionPane.showMessageDialog(this, "예약실패", "잔여좌석없음", JOptionPane.ERROR_MESSAGE);
				//throw new NumberFormatException();
				
			}//quantitiy가 null이 아닐 때
			if(mtf10!=null){booking();} 
		
			
		}//예약버튼 끝
	
	}//end of actionPerformed method

	private void booking() {
		// TODO Auto-generated method stub
		//정보를 가지고 와서 리스트에 저장한 다음에 예약함
		ArrayList<Object> booking = new ArrayList<Object>();
		
		int quantity = 0; quantity=quantity+Integer.parseInt(mtf10.getText());
		int index = searchTable.getSelectedRow();
		
		//System.out.println(column);
		for(int i=0;i<index;i++){
			booking.add(searchTable.getValueAt(index, i));	
		}
		
		mtf[8].setText(String.valueOf(quantity = Integer.parseInt(mtf[8].getText())-quantity));
		
		for(Object dto : booking){System.out.println(dto);}
		
		JOptionPane.showMessageDialog(this, "예약되었습니다", "예약확인", JOptionPane.NO_OPTION);
		
		
		/*try {p.booking((String)searchTable.getValueAt(index, 0), quantity);
		} catch (NumberFormatException|DatabaseException e) {e.printStackTrace();}*/
		
		//setAllTable(booking);
		
		if(Integer.parseInt(mtf[8].getText())<=0){
			JOptionPane.showMessageDialog(this, "잔여좌석없음", "예약실패", JOptionPane.ERROR_MESSAGE);
			for(int i=0;i<9;i++){
				mtf[i].setText(" ");
			}
			booking2();
		}
		/*for(Object o:booking){
			System.out.print(o +" ");
		}*/
		
		// quantity가 0이되면 디비에서 삭제해버린다
	}

	private void booking2() {
		// TODO Auto-generated method stub
		ArrayList<Object> booking = new ArrayList<Object>();
		
		int quantity = 0; quantity=quantity+Integer.parseInt(mtf10.getText());
		int index = searchTable.getSelectedRow();
		
		//System.out.println(column);
		for(int i=0;i<index+1;i++){
			booking.add(searchTable.getValueAt(index+1, i));	
		}
		
	}
	
	
}