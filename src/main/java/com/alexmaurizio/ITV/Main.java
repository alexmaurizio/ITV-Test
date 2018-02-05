package com.alexmaurizio.ITV;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.alexmaurizio.ITV.Business.CheckoutProcessor;
import com.alexmaurizio.ITV.Business.FileLoader;
import com.alexmaurizio.ITV.Models.Product;
import com.alexmaurizio.ITV.UserInterface.MainFrame;

public class Main {
	
    private static void createAndShowGUI() { 
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(chooser);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
           System.out.println("You chose to open this file: " +
                chooser.getSelectedFile().getName());
        }
        
        
    }
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //createAndShowGUI();
            	try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	MainFrame theMainFrame = new MainFrame();
            	theMainFrame.setSize(new Dimension(700,700));
            	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            	theMainFrame.setLocation(dim.width/2-700/2, dim.height/2-700/2);
            }
        });
    }
    
}
