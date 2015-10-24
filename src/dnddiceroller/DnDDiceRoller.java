
package dnddiceroller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rhonda Marshall
 */
public class DnDDiceRoller {

    /**
     * Try out your dies and dice tower
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Start Test");
        for (int i = 0; i < 1000; i++) {
            int d6 = test_oneD6();
            if (d6 != -1) {
                System.out.println("Die Test Failed with Value: " + d6);
            }
            int tower = test_diceTowerWithTwoD6();
            if (tower != -1) {
                System.out.println("Tower Test Failed with Value: " + tower);
            }
        }
        System.out.println("End Test");
    } // main method
    
    public static int test_oneD6() {
        Die die = new Die(6);
        die.roll();
        
        int dieValue = die.getValue();
        if (dieValue >= 1 && dieValue <= 6) {
            return -1; // Means the die value is outsides its bounds for a die
        } else {
            return dieValue;
        }
    } // test_oneD6 method
    
    public static int test_diceTowerWithTwoD6() {
            List<Die> dice = new ArrayList();
            dice.add(new Die(6));
            dice.add(new Die(6));
            
            DiceTower tower = new DiceTower(dice);
            tower.dropDice();
            
            int trayValue = tower.getTrayValue();
            if (trayValue >= 2 && trayValue <= 12) {
                return -1;
            } else {
                return trayValue;
            }
    } // test_diceTowerWithTwoD6 method
    
}