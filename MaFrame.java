import java.awt.*;
import java.util.*;
import java.awt.event.*;

import javax.swing.*;   


class ActionNewGame implements ActionListener
{   
        int lar, haut;

        public ActionNewGame( int lar, int haut )
        {
            this.lar = lar;
            this.haut = haut;
        }

        public void actionPerformed( ActionEvent e) 
        {
            System.out.println( "jeux : " + this.lar + " X " + this.haut );
            Demineur.createPartie( this.lar, this.haut );
        }

}

class ActionQuit implements ActionListener
{   
        public void actionPerformed( ActionEvent e) 
        {   
            Demineur.finDePartie();
        }
}

class ActionInfos implements ActionListener
{   
        public void actionPerformed( ActionEvent e) 
        {   
            System.out.println( "Infos" );
        }
}





public class MaFrame extends JFrame
{
    public MaFrame()
    {
      super();
      createMenu();
    } 

    public void createMenu()
    {
        JMenuBar menuBar = new JMenuBar();
            JMenu menu1 = new JMenu("Jeux");
                JMenuItem i11 = new JMenuItem();
                i11.setText( "15 X 15"); 
                i11.addActionListener( new ActionNewGame( 15, 15 ));
                menu1.add(i11);
            
                JMenuItem i12 = new JMenuItem();
                i12.setText( "20 X 20"); 
                i12.addActionListener( new ActionNewGame( 20, 20 ));
                menu1.add(i12);
               
                JMenuItem i13 = new JMenuItem();
                i13.setText( "Quit"); 
                i13.addActionListener( new ActionQuit( ));
                menu1.add(i13);
            
            menuBar.add(menu1);

            JMenu menu2 = new JMenu("A propos");
                JMenuItem i21 = new JMenuItem();
                i21.setText( "Infos"); 
                i21.addActionListener( new ActionInfos( ));
                menu2.add(i21);
            menuBar.add(menu2);

        this.setJMenuBar(menuBar);
    }

    public void createPanel()
    {
        this.setSize(Demineur.cdm.getLargeur() * (Demineur.getCoteBouton()+10), Demineur.cdm.getHauteur() * (Demineur.getCoteBouton()+5) + 60);

        JPanel monPanel     = new JPanel(new GridBagLayout());
        monPanel.setBorder(BorderFactory.createLineBorder(Color.red));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(1, 1, 1, 1);

        for( int y=0 ; y < Demineur.cdm.getHauteur() ; y++ )
        {
            for( int x=0 ; x < Demineur.cdm.getLargeur() ; x++ )
            {
                //MineButton mine   = new MineButton( x, y, Demineur.cdm.getStatus( x,y ) );
                constraints.gridx = x;
                constraints.gridy = y;     
                monPanel.add( ChampDeMines.getMine(x,y), constraints );
            }
        }
        this.setContentPane( monPanel );
    }


    public void createPanelEchec()
    {
        for( int y=0 ; y < Demineur.cdm.getHauteur() ; y++ )
            for( int x=0 ; x < Demineur.cdm.getLargeur() ; x++ )
                ChampDeMines.getMine(x,y).decouvre();
    }
}


