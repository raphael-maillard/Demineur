import java.awt.*;
import java.util.*;
import java.awt.event.*;

import javax.swing.*;   


class buttonListener implements ActionListener 
{
    public void actionPerformed( ActionEvent e )
    {
        MineButton mb = (MineButton)e.getSource();
        String result = "";
        
        if ( !mb.status )
        {
            mb.nbrMinesVoisines = ChampDeMines.checkMine( mb.x, mb.y );
            mb.color = Color.green;
            result = ""+ mb.nbrMinesVoisines;
        }
        else if ( mb.status )
        {
            mb.color =  Color.red;  
            result = "1";
            Demineur.afficheEchec( );
        }
        mb.setText( result );
        mb.setEnabled(false);
        Demineur.updatePanel();
    }
}

public class MineButton extends JButton
{
    int x, y, nbrMinesVoisines; 
    boolean status;

    boolean visited;
    Color color;

    public MineButton()
    {
        super();
        this.addActionListener( new buttonListener() );
        this.status = false;
        Dimension dimensionButton = new Dimension(Demineur.getCoteBouton(), Demineur.getCoteBouton() );
        this.setPreferredSize( dimensionButton );
      }

    public MineButton( int x, int y )
    {
        super();
        this.x = x;
        this.y = y;
        this.status = false;
        this.color = Color.white;
        this.addActionListener( new buttonListener() );
        Dimension dimensionButton = new Dimension(Demineur.getCoteBouton(), Demineur.getCoteBouton() );
        this.setPreferredSize( dimensionButton );
        this.visited  = false;
    }

    public void decouvre()
    {
        if ( !this.status )
        {
            this.color = Color.green;
        }
        else if ( this.status )
        {
            this.color =  Color.red;  
        }
        setEnabled(false);

        paintComponent(getGraphics());
    }


    @Override
    protected void paintComponent( Graphics g ) 
    {
        super.paintComponent(g);

        g.setColor( this.color );
        g.fillRect(0, 0, getWidth(), getHeight());

        //FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = getWidth() / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = getHeight() / 2;
        // Set the font
        //g.setFont(font);
        // Draw the String
        if ( nbrMinesVoisines > 0 )
        {
            g.setColor( Color.black );
            g.drawString( ""+nbrMinesVoisines, x, y);
        }
    }
}   
