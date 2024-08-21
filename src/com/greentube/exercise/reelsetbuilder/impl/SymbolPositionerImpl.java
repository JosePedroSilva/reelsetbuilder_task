package com.greentube.exercise.reelsetbuilder.impl;

import com.greentube.exercise.reelsetbuilder.Main;
import com.greentube.exercise.reelsetbuilder.ReelView;
import com.greentube.exercise.reelsetbuilder.SymbolPositioner;

/**
 * The methods of this class should be implemented to animate the symbols of the reels.
 * <br>
 * In the end, it should look like this animated gif (note, that the gif might be displayed with a wrong speed):
 * <br><br>
 * <img src="doc-files/reelanim.gif">
 * <br><br>
 * Each symbol of the reel is identified by a character. Depending on the character, the symbol automatically gets it's color.
 * The order of the symbols is called a "reelset". It's a char array that contains all symbols of this reel.
 * <br><br>
 * Example:<br>
 * Let's say, we have the following reelset: AGHHBX
 * <br>
 * When we start the reel at position 0, this means, symbols A, G and H should be visible. Then, the symbols move down, which
 * reveals symbol X at the top. Now, symbols X, A, G and H are visible while X and H are visible only partially. When the reel
 * moves on, you can see B, X, A and G, and so on. So, in most cases, 4 symbols are visible.
 * <br><br>
 * For this example, the whole gui implementation was done already. You only have to implement the methods of this class. You shouldn't
 * edit the other classes. Of course, you can edit the {@link Main} class to play with different reelsets, start positions and
 * speeds.
 * <br>
 * When starting the {@link Main} class, the {@link #update()}, {@link #getFirstSymbolPosition()} and {@link #getSymbol(int)} methods
 * are called on a regular basis. This happens about every 20 milliseconds, but you shouldn't take that for granted and shouldn't base
 * your animation on this interval.
 * <br>
 * As long as {@link #start(int, char[], int)} wasn't called, nothing should happen. You can return space as a character. This will
 * display empty black rectangles.
 * <br>
 * When the user presses the Start button, the {@link #start(int, char[], int)} method of this class gets called. You get a position
 * (index on the reelset) where the reel should start, the reelset and a speed (in milliseconds per symbol). After the call of
 * {@link #start(int, char[], int)}, you should do your calculations in the {@link #update()} method and return the updated values
 * in the {@link #getFirstSymbolPosition()} and {@link #getSymbol(int)} methods. Also, check the javadoc of these methods.
 * <br>
 * You can get the height of the symbol by calling {@link ReelView#SYMBOL_SIZE}.
 * <br><br><br>
 * Tasks:
 * <ul>
 * <li> Symbols of the start reelset should move down in the correct speed after start was called. </li>
 * <li> Your code has to be production ready. </li>
 * </ul>
 * 
 * <br>
 * If you have any questions feel free to write an e-mail to: careers@greentube.com
 * <br>
 */
public class SymbolPositionerImpl implements SymbolPositioner
{
	public void start(int position, char[] reelset, int speed)
	{
		
	}
	
	public boolean update()
	{
		return false;
	}
	
	public int getFirstSymbolPosition()
	{
		return 0;
	}
	
	public char getSymbol(int index)
	{
		return 'A';
	}
}
