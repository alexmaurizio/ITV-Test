package com.alexmaurizio.ITV.UserInterface;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
/**
 * @author  Alessandro Maurizio
 * @created February 6, 2018
 */
public class MainFrame extends JFrame 
{

	private static final long serialVersionUID = 622517666505070304L;

	static MainFrame theMainFrame;

	// Panel
	JPanel pnPanel0;
		
	// Buttons
	JButton btBut0;
	JButton btBut1;
	JButton btBut10;
	JButton btBut11;
	JButton btBut12;
	
	// Labels
	JLabel lbLabel0;	
	JLabel lbLabel1;	
	JLabel lbLabel9;	
	JLabel lbLabel10;
	
	// Lists
	JList<ArrayList<String>> lsList0;
	JList<ArrayList<String>> lsList2;
	
	
	/**
	 */
	public static void main( String args[] ) 
	{
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch ( ClassNotFoundException e ) 
		{
		}
		catch ( InstantiationException e ) 
		{
		}
		catch ( IllegalAccessException e ) 
		{
		}
		catch ( UnsupportedLookAndFeelException e ) 
		{
		}
		theMainFrame = new MainFrame();
	} 

	/**
	 */
	public MainFrame() 
	{
		super( "TITLE" );

		pnPanel0 = new JPanel();
		pnPanel0.setBorder( BorderFactory.createTitledBorder( "" ) );
		pnPanel0.setName( "null" );
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		pnPanel0.setLayout( gbPanel0 );

		btBut0 = new JButton( "Calculate" );
		btBut0.setSize(new Dimension(20,20));
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 36;
		gbcPanel0.gridwidth = 11;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut0, gbcPanel0 );
		pnPanel0.add( btBut0 );
		
		btBut1 = new JButton( "Exit" );
		gbcPanel0.gridx = 24;
		gbcPanel0.gridy = 36;
		gbcPanel0.gridwidth = 11;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut1, gbcPanel0 );
		pnPanel0.add( btBut1 );

		String []dataList0 = { "" };
		lsList0 = new JList( dataList0 );
		gbcPanel0.gridx = 8;
		gbcPanel0.gridy = 16;
		gbcPanel0.gridwidth = 11;
		gbcPanel0.gridheight = 15;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lsList0, gbcPanel0 );
		pnPanel0.add( lsList0 );

		lbLabel0 = new JLabel( "Select the product to scan"  );
		gbcPanel0.gridx = 8;
		gbcPanel0.gridy = 14;
		gbcPanel0.gridwidth = 11;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLabel0, gbcPanel0 );
		pnPanel0.add( lbLabel0 );

		String []dataList2 = { "" };
		lsList2 = new JList( dataList2 );
		gbcPanel0.gridx = 29;
		gbcPanel0.gridy = 16;
		gbcPanel0.gridwidth = 11;
		gbcPanel0.gridheight = 15;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lsList2, gbcPanel0 );
		pnPanel0.add( lsList2 );

		lbLabel1 = new JLabel( "Scanned Products"  );
		gbcPanel0.gridx = 29;
		gbcPanel0.gridy = 14;
		gbcPanel0.gridwidth = 11;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLabel1, gbcPanel0 );
		pnPanel0.add( lbLabel1 );

		btBut10 = new JButton( "SCAN!"  );
		gbcPanel0.gridx = 20;
		gbcPanel0.gridy = 19;
		gbcPanel0.gridwidth = 8;
		gbcPanel0.gridheight = 8;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.CENTER;
		gbPanel0.setConstraints( btBut10, gbcPanel0 );
		pnPanel0.add( btBut10 );

		lbLabel9 = new JLabel( "Select the two files before starting the calculation!"  );
		gbcPanel0.gridx = 13;
		gbcPanel0.gridy = 8;
		gbcPanel0.gridwidth = 22;
		gbcPanel0.gridheight = 2;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLabel9, gbcPanel0 );
		pnPanel0.add( lbLabel9 );

		btBut11 = new JButton( "Select Database File"  );
		gbcPanel0.gridx = 10;
		gbcPanel0.gridy = 10;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 5;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut11, gbcPanel0 );
		pnPanel0.add( btBut11 );
		
		btBut12 = new JButton( "Select Offers File"  );
		gbcPanel0.gridx = 25;
		gbcPanel0.gridy = 10;
		gbcPanel0.gridwidth = 5;
		gbcPanel0.gridheight = 5;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btBut12, gbcPanel0 );
		pnPanel0.add( btBut12 );

		lbLabel10 = new JLabel( "FINAL PRICE:"  );
		gbcPanel0.gridx = 12;
		gbcPanel0.gridy = 32;
		gbcPanel0.gridwidth = 11;
		gbcPanel0.gridheight = 3;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbLabel10, gbcPanel0 );
		pnPanel0.add( lbLabel10 );

		setDefaultCloseOperation( EXIT_ON_CLOSE );

		setContentPane( pnPanel0 );
		pack();
		setVisible( true );
	} 
} 
