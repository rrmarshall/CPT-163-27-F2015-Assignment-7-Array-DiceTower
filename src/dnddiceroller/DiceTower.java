
package dnddiceroller;

import java.util.ArrayList;
import java.util.List;

/**
 * Dice Tower.
 * A Dice Tower is a tool used by serious gamers to roll many dice at once.
 *
 * An instance of a dice tower is defined by 
 *      the number of panels it contains to help provide a regular
 *      distribution of die values.
 * 
 * The die bounce from panel to panel until they exit the dice tower
 * at the bottom of they tray.
 * 
 * A dice tower will accept a collection of dice and report their results
 * when they reach the tray at the bottom
 */

/**
 *
 * @author Rhonda Marshall
 */
public class DiceTower {
    private final int PANEL_COUNT = 3;
    List<Die> dice;
    int trayValue;
    private final Boolean debug;   // This is for my purposes to debug this progam
    
    /**
     * DiceTower constructors
     * 
     */
    public DiceTower() {
        this.dice = new ArrayList();
        this.trayValue = 0;
        this.debug = false;
    }
    
    public DiceTower(List dice) {
            this.dice = dice;
            this.trayValue = 0;
            this.debug = false;
    }
    
    /**
     * getTrayValue accessors method
     * 
     * @return trayValue 
     */
    public int getTrayValue() {
        
        return this.trayValue;
        
    }  // getTrayValue
     
    /**
     * dropDice method will roll each die, the number of panels that are
     * in the dice tower
     * 
     * accumulate the trayValue
     */
    
    public void dropDice() {
        // for each of the die in the array
        for (Die theDice : this.dice) {
            // roll the dice the number of panels in the tower, PANEL_COUNT
            for (int j = 0; j < PANEL_COUNT; j++) { 
                if (this.debug) System.out.printf("dropDice: Rolling %d\n", j);
                theDice.roll();
            }
            if (this.debug) {
                System.out.printf("dropDice: value is %d\n\n", theDice.getValue());
            }
            this.trayValue += theDice.getValue();
        }
        
        if (this.debug)
            System.out.printf("trayValue: value of both dice %d\n\n", this.trayValue);
        
    } // dropDice
}