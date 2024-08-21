package com.greentube.exercise.reelsetbuilder;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReelView extends JFrame
{
	public static int SYMBOL_SIZE = 200;
	
	private JPanel contentPane;
	private JLabel symbol0Label;
	private JLabel symbol1Label;
	private JLabel symbol2Label;
	private JLabel symbol3Label;
	private JButton startButton;
	private JPanel panel_1;
	
	/**
	 * Create the frame.
	 */
	public ReelView()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 247, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firePropertyChange("start", null, null);
			}
		});
		contentPane.add(startButton, BorderLayout.NORTH);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(null);
		panel.setBounds(0, 0, SYMBOL_SIZE, SYMBOL_SIZE*3);
		panel.setPreferredSize(new Dimension(SYMBOL_SIZE, SYMBOL_SIZE*3));
		
		symbol0Label = new JLabel("New label");
		symbol0Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		symbol0Label.setForeground(Color.WHITE);
		symbol0Label.setBounds(0, 0, SYMBOL_SIZE, SYMBOL_SIZE);
		symbol0Label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		panel.add(symbol0Label);
		symbol0Label.setBackground(Color.ORANGE);
		symbol0Label.setOpaque(true);
		symbol0Label.setHorizontalAlignment(SwingConstants.CENTER);
		
		symbol1Label = new JLabel("New label");
		symbol1Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		symbol1Label.setForeground(Color.WHITE);
		symbol1Label.setBounds(0, SYMBOL_SIZE, SYMBOL_SIZE, SYMBOL_SIZE);
		symbol1Label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		panel.add(symbol1Label);
		symbol1Label.setOpaque(true);
		symbol1Label.setHorizontalAlignment(SwingConstants.CENTER);
		symbol1Label.setBackground(Color.GREEN);
		
		symbol2Label = new JLabel("New label");
		symbol2Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		symbol2Label.setForeground(Color.WHITE);
		symbol2Label.setBounds(0, SYMBOL_SIZE*2, SYMBOL_SIZE, SYMBOL_SIZE);
		symbol2Label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		panel.add(symbol2Label);
		symbol2Label.setOpaque(true);
		symbol2Label.setHorizontalAlignment(SwingConstants.CENTER);
		symbol2Label.setBackground(Color.BLUE);
		
		symbol3Label = new JLabel("New label");
		symbol3Label.setFont(new Font("Tahoma", Font.BOLD, 18));
		symbol3Label.setForeground(Color.WHITE);
		symbol3Label.setOpaque(true);
		symbol3Label.setHorizontalAlignment(SwingConstants.CENTER);
		symbol3Label.setBackground(Color.YELLOW);
		symbol3Label.setBounds(0, SYMBOL_SIZE*3, SYMBOL_SIZE, SYMBOL_SIZE);
		symbol3Label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		panel.add(symbol3Label);
	}
	
	public void setSymbols(int firstSymbolPos, char symbol0, char symbol1, char symbol2, char symbol3)
	{
		symbol0Label.setLocation(0, firstSymbolPos);
		symbol1Label.setLocation(0, firstSymbolPos+SYMBOL_SIZE);
		symbol2Label.setLocation(0, firstSymbolPos+SYMBOL_SIZE*2);
		symbol3Label.setLocation(0, firstSymbolPos+SYMBOL_SIZE*3);
		symbol0Label.setBackground(getColor(symbol0));
		symbol1Label.setBackground(getColor(symbol1));
		symbol2Label.setBackground(getColor(symbol2));
		symbol3Label.setBackground(getColor(symbol3));
		symbol0Label.setText(""+symbol0);
		symbol1Label.setText(""+symbol1);
		symbol2Label.setText(""+symbol2);
		symbol3Label.setText(""+symbol3);
	}
	
	private Color getColor(char c)
	{
		if (c<65||c>=90) {
			return Color.black;
		}
		
		if (c%3==0) {
			return new Color((c-65)*155/25+100, (c-65)*155/25+100, (c-65)*205/25+50);
		}
		
		if (c%3==1) {
			return new Color((c-65)*205/25+50, (c-65)*155/25+100, (c-65)*155/25+100);
		}
		
		return new Color((c-65)*155/25+100, (c-65)*205/25+50, (c-65)*155/25+100);
	}
	
	public void saveScreenShot()
    {
    	final BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
    	Graphics2D g = bufferedImage.createGraphics();
    	
    	paint(g);
    	
    	Thread t = new Thread(new Runnable() {
			public void run() {
				try {
		    		FileOutputStream stream = new FileOutputStream("F:/work/screens/image"+System.currentTimeMillis()+".png");
		    		ImageIO.write(bufferedImage, "png", stream);
		    		stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
    	t.start();
    }
}
