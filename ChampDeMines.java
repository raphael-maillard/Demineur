import java.lang.*;
	

public class ChampDeMines 
{
	
	static MineButton champDeMines[][];
	static int larChamp, hautChamp, nbrMines;

	public ChampDeMines( int lar, int haut, int nbrM)
	{
		System.out.println( "ChampDeMines new" 	);
		larChamp = lar;
		hautChamp = haut;
		nbrMines = nbrM;
		champDeMines = new MineButton[haut][lar];
		System.out.println( "matrice OK" 	);

 		for( int y=0 ; y < haut ; y++ )
            for( int x=0 ; x < lar ; x++ )
            	setMine( x, y, new MineButton( x, y ) );

		System.out.println( "creation zone OK" 	);

		poseLesMines( nbrMines );
		System.out.println( "cdm "+ lar +" X " + haut + " construit.");
	}

	public void poseLesMines( int nbrMines )
	{
		int x,y;

		while( nbrMines-- != 0 )
		{
			x = (int)(Math.random()*1000000d) % this.larChamp;
			y = (int)(Math.random()*1000000d) % this.hautChamp;

			if ( ! getStatus( x, y ) )
				setStatus( x, y, true);
			else
				nbrMines++;
		}
	}

	public static boolean getStatus( int x, int y)
	{
		if ( x>=0 && x<larChamp && y>=0 && y<hautChamp )
			return champDeMines[y][x].status;
		return false;
	} 

	public void setStatus( int x, int y, boolean status)
	{
		if ( x>=0 && x<larChamp && y>=0 && y<hautChamp )
			champDeMines[y][x].status = status;
	} 

	public int getLargeur( )
	{
		return larChamp;
	} 

	public int getHauteur( )
	{
		return hautChamp;
	} 

	static public MineButton getMine( int x, int y )
	{
		return champDeMines[y][x];
	}

	static public void setMine( int x, int y, MineButton mb )
	{
		champDeMines[y][x] = mb;
	}

	public static int checkMine( int x, int y )
	{		
		int nbrMines=0;

		if ( x>=0 && x<larChamp && y>=0 && y<hautChamp && getMine( x, y ).visited  == false )
		{
			getMine( x, y ).visited = true; 
			System.out.println(  "entre checkMine " + x +","+y);
			if ( getStatus( x+1, y ) )
			    nbrMines++;
			else 
				checkMine( x+1, y );
		
			if ( getStatus( x-1, y ) )
			    nbrMines++;
			else 
				checkMine( x-1, y );

			if ( getStatus( x, y-1 ) )
			    nbrMines++;
			else 
				checkMine( x, y-1 );
		
			if ( getStatus( x, y+1 ) )
			    nbrMines++;
			else 
				checkMine( x, y+1 );
		
			if ( getStatus( x-1, y-1 ) )
			    nbrMines++;
			else 
				checkMine( x-1, y-1 );
		
			if ( getStatus( x+1, y-1 ) )
			    nbrMines++;
			else 
				checkMine( x+1, y-1 );
		
			if ( getStatus( x+1, y+1 ) )
			    nbrMines++;
			else 
				checkMine( x+1, y+1 );
		
	 		if ( getStatus( x-1, y+1 ) )
			    nbrMines++;
			else 
				checkMine( x-1, y+1 );

		
			//System.out.println(  "sort checkMine " + nbrMines );
			getMine( x, y ).nbrMinesVoisines = nbrMines; 
		}
		return nbrMines;
	}

/*
	public static  int checkMine_enProgress( int x, int y )
	{
		int nbrMines=0;

		if ( x>=0 && x<larChamp && y>=0 && y<hautChamp && getMine( x, y ).visited  == false )
		{
			getMine( x, y ).visited = true; 

			System.out.println(  "entre checkMine " + x +","+y);

			if ( getStatus( x+1, y ) == 1 )
			    nbrMines++;
			else if ( getStatus( x+1, y ) == 0 )
				checkMine( x+1, y );

			if ( getStatus( x-1, y ) == 1 )
			    nbrMines++;
			else if ( getStatus( x-1, y ) == 0 )
				checkMine( x-1, y );

			if ( getStatus( x, y-1 ) == 1 )
			    nbrMines++;
			else if ( getStatus( x, y-1 ) == 0 ) 
				checkMine( x, y-1 );

			if ( getStatus( x, y+1 ) == 1 )
			    nbrMines++;
			else if ( getStatus( x, y+1 ) == 0 )
				checkMine( x, y+1 );

			if ( getStatus( x-1, y-1 ) == 1 )
			    nbrMines++;
			else if ( getStatus( x-1, y-1 ) == 0 )
				checkMine( x-1, y-1 );

			if ( getStatus( x+1, y-1 ) == 1 )
			    nbrMines++;
			else if ( getStatus( x+1, y-1 ) == 0 )
				checkMine( x+1, y-1 );

			if ( getStatus( x+1, y+1 ) == 1 )
			    nbrMines++;
			else if ( getStatus( x+1, y+1 ) == 0 )
				checkMine( x+1, y+1 );
	 
	 		if ( getStatus( x-1, y+1 ) == 1 )
			    nbrMines++;
			else if ( getStatus( x-1, y+1 ) == 0 )
				checkMine( x-1, y+1 );

			System.out.println(  "sort checkMine " + nbrMines );
			return nbrMines; 
		}
		else
			return -1;
	}
	*/

}