package com.hexotic.v2.gui.downloadbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.hexotic.lib.ui.buttons.SoftButton;
import com.hexotic.v2.gui.components.TextFieldWithPrompt;
import com.hexotic.v2.gui.theme.Theme;

/**
 * The download bar is the top panel that will have a button to toggle sidebar,
 * input box for pasting a URL, and a download button
 * 
 * @author Bradley Sheets
 * 
 */
public class DownloadBar extends JPanel {

	private static final long serialVersionUID = 5261700324127818276L;
	private TextFieldWithPrompt urlInput;

	private SoftButton downloadButton;

	public DownloadBar() {
		this.setPreferredSize(new Dimension(80, 80));
		this.setBackground(Theme.CONTROL_BAR_BACKGROUND);
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(24, 22, 24, 12));
		urlInput = new TextFieldWithPrompt("", "Paste in a URL and click that fancy download button to the right");

		JPanel downloadButtonContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 4,0));
		downloadButtonContainer.setOpaque(false);
		
		downloadButton = new SoftButton("Download");
		downloadButton.setBackgroundColor(Theme.DARK);
		downloadButton.setFont(new Font("Arial", Font.BOLD, 12));
		downloadButton.setArc(4);
		downloadButtonContainer.add(downloadButton);

	

		urlInput.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (urlInput.getText().length() == 7) {
					urlInput.setAccepted(true);
				} else {
					urlInput.setAccepted(false);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});

		this.add(urlInput, BorderLayout.CENTER);
		this.add(downloadButtonContainer, BorderLayout.EAST);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(Theme.CONTROL_BAR_BORDER);
		g2d.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
		
		int width = 10;
		int y = 0;
		g2d.setColor(Theme.DARK);
		g2d.fillRect(0, y+=10, width, width);
		
		g2d.setColor(Theme.MAIN_COLOR_ONE);
		g2d.fillRect(0, y+=10, width, width);
		g2d.setColor(Theme.MAIN_COLOR_TWO);
		g2d.fillRect(0, y+=10, width, width);
		g2d.setColor(Theme.MAIN_COLOR_THREE);
		g2d.fillRect(0, y+=10, width, width);
		g2d.setColor(Theme.MAIN_COLOR_FOUR);
		g2d.fillRect(0, y+=10, width, width);
		
//		g2d.setColor(Theme.DARK);
//		g2d.drawLine(2, 15, 2, 60);
//		g2d.drawLine(5, 15, 5, 60);
//		g2d.drawLine(8, 15, 8, 60);
		
	}
}