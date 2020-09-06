import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;
import java.lang.*;

import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


public class Demineur
{
	static ChampDeMines cdm;
	static int coteBouton = 25;
	static MaFrame maFrame;



	static int getCoteBouton()
	{
		return coteBouton;
	}

	public static void finDePartie( )
	{
		System.out.println( "fin de partie" );
		System.exit(0);
	}

	public static void createPartie( int lar, int haut )
	{
		System.out.println( "createPartie" );
		cdm = new ChampDeMines( lar, haut, 50 );
		maFrame.createPanel();
	}

	public static void afficheEchec( )
	{
		maFrame.createPanelEchec();
	}

	public static void updatePanel( )
	{
		maFrame.setVisible(true);
	}



	public static void main( String[] arguement )
	{

		
		maFrame = new MaFrame();
		
		maFrame.setTitle("démineur");
		maFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		maFrame.setLocationRelativeTo(null);
		maFrame.setResizable(true);

		createPartie( 20, 13 );

		maFrame.setVisible(true);
	} 
}