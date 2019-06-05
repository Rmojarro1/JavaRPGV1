/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author gamef
 */
public class DataManager {
    
    private String playerName; 
    private int playerMaxHP; 
    private int playerHP; 
    private int playerAttack; 
    private int playerMoney; 
    Scanner keyboard = new Scanner(System.in);
    
    public DataManager()
    {
        
    }
    
    public DataManager(DataManager copy)
    {
        playerName = copy.playerName; 
        playerMaxHP = copy.playerMaxHP; 
        playerHP = copy.playerHP; 
        playerAttack = copy.playerAttack; 
        playerMoney = copy.playerMoney; 
    }

    /**
     * Creates a save file for the player
     * with default values for all fields. 
     * The user is also prompted to enter
     * a name for their character.
     * @throws FileNotFoundException
     */
    public void newSaveData() throws FileNotFoundException
    { 
        String name; 
        name = JOptionPane.showInputDialog("Enter a name for your player."); 
        PrintWriter outputFile = new PrintWriter("Data.txt"); 
        playerName = name;
        playerMaxHP = 5; 
        playerHP = 5; 
        playerAttack = 1; 
        playerMoney = 10;
        outputFile.println(playerName); 
        outputFile.println(playerMaxHP);
        outputFile.println(playerHP);
        outputFile.println(playerAttack);
        outputFile.println(playerMoney);
        outputFile.close();
    }
    
    /**
     * Writes all of the current stats to the 
     * Data.txt file and modifies the current stats
     * in this class to match. 
     * @param name
     * @param maxHP
     * @param currentHP
     * @param attack
     * @param money
     * @throws FileNotFoundException
     */
    public void saveData(String name, int maxHP, int currentHP, 
            int attack, int money) throws FileNotFoundException
    { 
        
        PrintWriter outputFile = new PrintWriter("Data.txt");  
        outputFile.println(name); 
        outputFile.println(maxHP);
        outputFile.println(currentHP);
        outputFile.println(attack);
        outputFile.println(money);
        outputFile.close();
        
        playerName = name; 
        playerMaxHP = maxHP; 
        playerHP = currentHP; 
        playerAttack = attack; 
        playerMoney = money; 
    }
    
    /**
     * Reads data from the file and 
     * modifies the stat variables to 
     * match. 
     * @throws FileNotFoundException
     */
    public void loadData() throws FileNotFoundException
    {
        File file = new File("Data.txt"); 
        Scanner inputFile = new Scanner(file); 
        playerName = inputFile.nextLine();
        playerMaxHP = inputFile.nextInt(); 
        playerHP = inputFile.nextInt();
        playerAttack = inputFile.nextInt();
        playerMoney = inputFile.nextInt();
        inputFile.close(); 
    }
    
    /**
     * Returns the player name. 
     * @return
     */
    public String getName()
    {
        return playerName; 
    }
    
    /**
     * Returns each of the stats
     * in an array form. 
     * @return
     */
    public int[] getStats()
    {
        int[] stats = new int[4]; 
        stats[0] = playerMaxHP; 
        stats[1] = playerHP; 
        stats[2] = playerAttack; 
        stats[3] = playerMoney; 
        return stats;  
    }
}
