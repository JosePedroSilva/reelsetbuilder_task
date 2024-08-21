package com.greentube.exercise.reelsetbuilder;

import java.awt.EventQueue;

public class ReelAnimator implements Runnable
{
	private ReelView reel;
	private SymbolPositioner positioner;
	
	public ReelAnimator(ReelView reel, SymbolPositioner positioner)
	{
		this.reel = reel;
		this.positioner = positioner;
	}
	
	protected void startImpl(int position, char[] reelset, int speed)
	{
		System.out.println("Start");
		positioner.start(position, reelset, speed);
	}
	
	protected boolean updateImpl()
	{
		boolean running = positioner.update();
		reel.setSymbols(positioner.getFirstSymbolPosition(),
				positioner.getSymbol(0), positioner.getSymbol(1), positioner.getSymbol(2), positioner.getSymbol(3));
		reel.repaint();
		//reel.saveScreenShot();
		return running;
	}
	
	public void start(final int position, final char[] reelset, final int speed)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				startImpl(position, reelset, speed);
			}
		});
	}
	
	public void run()
	{
		while(true) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						updateImpl();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
