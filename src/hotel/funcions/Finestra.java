package hotel.funcions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class Finestra extends JFrame{
	public JPanel panell1;
	public JPanel panell2;
	public JPanel panell3;
	public JTextField dni = new JTextField();
	public JTextField nom = new JTextField();
	public JTextField cognoms = new JTextField();
	public JTextField numPersones = new JTextField();
	public JTextField numNits = new JTextField();
	public JTextField nomHotel = new JTextField();
	public JTextField numHabBack = new JTextField();
	public JTextField numPersBack = new JTextField();
	public JCalendar calendari = new JCalendar();
	public JButton reserva = new JButton("RESERVA");
	public JButton guarda = new JButton("GUARDA!");
    public Finestra() {
        setVisible(true);
        setSize(1200,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Casa Rural");
        setLocationRelativeTo(null); //null -> centre
        setMinimumSize(new Dimension(1200,700));        
        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);
        iniciarComponents();

    }
    
	private void iniciarComponents() {
		crearPanells();
	}

	private void crearPanells() {
		int amplada = this.getWidth()/3;
		int altura = this.getHeight();
		System.out.println(amplada);
		System.out.println(altura);
		
		
        panell1 = new JPanel();
        panell1.setBackground(Color.LIGHT_GRAY);
        panell1.setBounds(0,0,amplada-2,altura);
        panell1.setLayout(null);
        this.getContentPane().add(panell1);
        
        panell2 = new JPanel();
        panell2.setBackground(Color.LIGHT_GRAY);
        panell2.setBounds(amplada,0,amplada-2,altura);
        panell2.setLayout(null);
        this.getContentPane().add(panell2);
        
        panell3 = new JPanel();
        panell3.setBackground(Color.LIGHT_GRAY);
        panell3.setBounds(amplada*2,0,amplada-2,altura);
        panell3.setLayout(null);
        this.getContentPane().add(panell3);
        
        System.out.println(panell1.getWidth()+" - "+panell1.getHeight());
        System.out.println(panell2.getWidth()+" - "+panell2.getHeight());
        System.out.println(panell3.getWidth()+" - "+panell3.getHeight());
        
        // GESTIÓ // PANELL1 //
        JLabel gestio = new JLabel("Gestiò");
        gestio.setBounds(0,20,398,20);
        gestio.setFont(new Font("arial",Font.BOLD,24));
        gestio.setHorizontalAlignment(SwingConstants.CENTER);
        panell1.add(gestio);
        
        JLabel jlReservesP = new JLabel("RESERVES PENDENTS:");
        jlReservesP.setBounds(20, 80, 300, 20);
        jlReservesP.setFont(new Font("arial",Font.PLAIN,16));
        panell1.add(jlReservesP);
        
        DefaultTableModel modelPendents = new DefaultTableModel();
        modelPendents.addColumn("#Reserva");
        modelPendents.addColumn("Dia");
        modelPendents.addColumn("Persona");
        modelPendents.addColumn("Habitació");
        JTable taulaReservesP = new JTable(modelPendents);
        taulaReservesP.setBounds(20, 110, 359, 200);
        panell1.add(taulaReservesP);
        JScrollPane scrollTaulaResP = new JScrollPane(taulaReservesP,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTaulaResP.setBounds(20, 110, 359, 200);
        panell1.add(scrollTaulaResP);
        
        JLabel jlReservesC = new JLabel("RESERVES CONFIRMADES:");
        jlReservesC.setBounds(20, 320, 220, 20);
        jlReservesC.setFont(new Font("arial",Font.PLAIN,16));
        panell1.add(jlReservesC);
        
        JDateChooser triarData = new JDateChooser();
        triarData.setBounds(250, 320, 130, 20);
        panell1.add(triarData);
        
        DefaultTableModel modelConfirmades = new DefaultTableModel();
        modelConfirmades.addColumn("Nom");
        modelConfirmades.addColumn("Date In");
        modelConfirmades.addColumn("Date Out");
        modelConfirmades.addColumn("Habitació");
        JTable taulaReservesC = new JTable(modelConfirmades);
        taulaReservesC.setBounds(20, 350, 359, 200);
        panell1.add(taulaReservesC);
        JScrollPane scrollTaulaResC = new JScrollPane(taulaReservesC,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollTaulaResC.setBounds(20, 350, 359, 200);
        panell1.add(scrollTaulaResC);
        
        // CLIENTS // PANELL2 //
        
        JLabel clients = new JLabel("Clients");
        clients.setBounds(0,20,398,20);
        clients.setFont(new Font("arial",Font.BOLD,24));
        clients.setHorizontalAlignment(SwingConstants.CENTER);
        panell2.add(clients);
        
        JLabel jlDni = new JLabel("DNI:");
        jlDni.setBounds(20, 80, 100, 20);
        jlDni.setFont(new Font("arial",Font.PLAIN,16));
        panell2.add(jlDni);
        
        dni.setBounds(180, 80, 200, 20);
        panell2.add(dni);
        
        JLabel jlNom = new JLabel("NOM:");
        jlNom.setBounds(20, 110, 100, 20);
        jlNom.setFont(new Font("arial",Font.PLAIN,16));
        panell2.add(jlNom);
        
        nom.setBounds(180, 110, 200, 20);
        panell2.add(nom);
        
        JLabel jlCognom = new JLabel("COGNOMS:");
        jlCognom.setBounds(20, 140, 100, 20);
        jlCognom.setFont(new Font("arial",Font.PLAIN,16));
        panell2.add(jlCognom);
        
        cognoms.setBounds(180, 140, 200, 20);
        panell2.add(cognoms);
        
        JLabel jlNumPers = new JLabel("NUM. PERSONES:");
        jlNumPers.setBounds(20, 170, 150, 20);
        jlNumPers.setFont(new Font("arial",Font.PLAIN,16));
        panell2.add(jlNumPers);
        
        numPersones.setBounds(180, 170, 60, 20);
        panell2.add(numPersones);
        
        JLabel jlNumNits = new JLabel("NUM. NITS:");
        jlNumNits.setBounds(20, 200, 150, 20);
        jlNumNits.setFont(new Font("arial",Font.PLAIN,16));
        panell2.add(jlNumNits);
        
        numNits.setBounds(180, 200, 60, 20);
        panell2.add(numNits);
        
        JLabel jlDataEntrada = new JLabel("DATA D'ENTRADA:");
        jlDataEntrada.setBounds(20, 270, 150, 20);
        jlDataEntrada.setFont(new Font("arial",Font.PLAIN,16));
        panell2.add(jlDataEntrada);
        
        calendari.setBounds(20, 300, 350, 250);
        panell2.add(calendari);
        
        reserva.setBounds(150, 570, 100, 30);
        panell2.add(reserva);
        
        // BACK // PANELL3 //
        
        JLabel back = new JLabel("Back");
        back.setBounds(0,20,398,20);
        back.setFont(new Font("arial",Font.BOLD,24));
        back.setHorizontalAlignment(SwingConstants.CENTER);
        panell3.add(back);
        
        JLabel jlNomHotel = new JLabel("NOM HOTEL:");
        jlNomHotel.setBounds(20, 80, 150, 20);
        jlNomHotel.setFont(new Font("arial",Font.PLAIN,16));
        panell3.add(jlNomHotel);
        
        nomHotel.setBounds(180, 80, 200, 20);
        panell3.add(nomHotel);
        
        guarda.setBounds(150, 110, 100, 30);
        panell3.add(guarda);
        
        JLabel jlRegNovaHabitacio = new JLabel("REGISTRE NOVA HABITACI�:");
        jlRegNovaHabitacio.setBounds(20, 160, 250, 20);
        jlRegNovaHabitacio.setFont(new Font("arial",Font.PLAIN,16));
        panell3.add(jlRegNovaHabitacio);
        
        
        JLabel jlNum = new JLabel("NUM:");
        jlNum.setBounds(20, 190, 50, 20);
        jlNum.setFont(new Font("arial",Font.PLAIN,16));
        panell3.add(jlNum);
        
        numHabBack.setBounds(110, 80, 60, 20);
        panell3.add(numHabBack);
        
        JLabel jlPers = new JLabel("# PERS:");
        jlPers.setBounds(180, 190, 80, 20);
        jlPers.setFont(new Font("arial",Font.PLAIN,16));
        panell3.add(jlPers);
        
        

	}
	
}
