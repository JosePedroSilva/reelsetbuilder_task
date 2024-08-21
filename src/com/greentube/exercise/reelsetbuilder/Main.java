package com.greentube.exercise.reelsetbuilder;

import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.greentube.exercise.reelsetbuilder.impl.SymbolPositionerImpl;

public class Main
{
	public static void main(String[] args)
	{
		final char[] startSet = new char[] {'A','A','D','D','G','R','E','H','E','G','H'};
		final int startPos = 3;
		final int speed = 500;
		
		final ReelView frame = new ReelView();
		final ReelAnimator anim = new ReelAnimator(frame, new SymbolPositionerImpl());
		
		frame.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("start")) {
					anim.start(startPos, startSet, speed);
				}
			}
		});
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t = new Thread(anim, "Anim Thread");
		t.start();
	}
}
