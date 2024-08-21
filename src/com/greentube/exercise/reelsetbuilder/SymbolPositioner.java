package com.greentube.exercise.reelsetbuilder;

/**
 * When calling {@link #start(int, char[])}, the symbols should begin to move, which means, {@link #getFirstSymbolPosition()}
 * and {@link #getSymbol(int)} should return different values for each call. These methods get called after {@link #update()} to get the
 * updated values.
 * @author hwitz
 */
public interface SymbolPositioner
{
	/**
	 * Starts the reel.
	 * @param position the position of the symbol in the reelset array that should be displayed in the first row when starting
	 * @param reelset the reelset array (each symbol is one character)
	 * @param speed in milliseconds per symbol
	 */
	public abstract void start(int position, char[] reelset, int speed);
	
	/**
	 * Gets called regularly to update the symbol positions. Continues to get called
	 * after {@link #stop(int, char[], int)} was called.
	 * @return {@code true}, if the symbols are moving
	 */
	public abstract boolean update();
	
	/**
	 * Returns the y position of the first visible symbol. In most cases, this value will be
	 * smaller than 0, because the first symbol is only visible partially when moving in.
	 * Will be called after {@link #update()} to get the new values.
	 * Gets called even before {@link #start(int, char[])} was called.
	 * @return the y position of the first visible symbol
	 */
	public abstract int getFirstSymbolPosition();
	
	/**
	 * Returns the symbol that should be drawn at the position {@code index}. The symbol returned for
	 * {@code index==0} will be drawn at {@link #getFirstSymbolPosition()}. The method usually gets
	 * called 4 times for the 4 symbols that are visible.
	 * Will be called after {@link #update()} to get the new values.
	 * Gets called even before {@link #start(int, char[])} was called.
	 * @param index the position (since only 4 symbols are visible at the same time, this will not be greater than 4)
	 * @return the symbol character for this position
	 */
	public abstract char getSymbol(int index);
}
