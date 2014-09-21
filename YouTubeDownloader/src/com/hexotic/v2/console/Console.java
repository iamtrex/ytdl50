package com.hexotic.v2.console;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


/**
 * This is an added "hidden" feature that will allow log viewing in real-time via
 * a built-in console window
 * 
 * @author Bradley
 *
 */
public class Console extends JInternalFrame{

	private static final long serialVersionUID = -283865083441921493L;
	private ConsoleContent output;
	
	
	public Console() {
		super("Hexotic Software - Console",
                false, //resizable
                false, //closable
                true,  //maximizable
                false);//iconifiable
		
		// Default Size
		setSize(600, 250);
		this.setOpaque(false);
		// pssh, who needs borders
		//this.setBorder(BorderFactory.createEmptyBorder());
		this.setBorder(BorderFactory.createLineBorder(Color.RED));

		((BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		// Add a scroll bar to the console window
		output = new ConsoleContent();
		JScrollPane scroll = new JScrollPane(output);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		// Add the console "editor" to the window
		this.add(scroll);
		
	}
	
	public void println(String line) {
		try {
			Document doc = output.getDocument();
			doc.insertString(doc.getLength(), line+"\n", null);
		} catch(BadLocationException exc) {
			// Nothing to worry about really
		}
	}
	
	
	private class ConsoleContent extends JEditorPane{
		private static final long serialVersionUID = -8670826262403444979L;
		
		public ConsoleContent() {
			this.setBackground(new Color(0xff0066));
			this.setFont(new Font("Arial", Font.BOLD, 12));
			this.setForeground(Color.WHITE);
			this.setEditable(false);
		}
	}
}