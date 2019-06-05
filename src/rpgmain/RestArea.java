/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmain;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

/**
 *
 * @author gamef
 */
public class RestArea {
    private final Character character; 
    private DataManager data; 
    
    public RestArea(Character character, DataManager d)
    {
        this.character = character;
        data = new DataManager(d); 
    }
    
    /**
     * Repeats a loop for all of the 
     * actions that the player is able to do
     * while inbetween battles. Returns a boolean 
     * that determines if the loop in main will
     * continue or not. 
     * @return
     * @throws FileNotFoundException
     */
    public boolean intermission() throws FileNotFoundException
    {
        boolean preparing = true; 
        boolean continuePlay = true; 
        while (preparing == true)
        {
            String input; 
            int selection;
            input = JOptionPane.showInputDialog("HP: "+ character.getHP()+ 
                    "\n Money:" + character.getMoney()+ "\n Battles fought "
                    + "today: " + (character.getRow()) +
                    "\nWhat would you like to do?"
                    + "\n 1. Visit shop" + "\n 2. Heal (10 g)" + 
                    "\n 3. Save and exit" + "\n 4. Save and continue" +
                    "\n 5. Continue");
            selection = Integer.parseInt(input); 
            if (selection == 1)
            {
                shop(); 
            }
            else if (selection == 2)
            {
                healPlayer(); 
            }
            else if (selection == 3)
            {
                rest(); 
                continuePlay = false; 
                preparing = false; 
            }
            else if (selection == 4)
            {
                rest(); 
                preparing = false; 
                character.setRow(0); 
            }
            else if (selection == 5)
            {
                preparing = false; 
                character.setRow((character.getRow() + 1));
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Not valid!"); 
            }
        }
        return continuePlay; 
    }
    
    /**
     * Allows the player to be fully restored
     * to full health if they have enough gold. 
     * Otherwise, they are denied healing. 
     */
    public void healPlayer()
    {
        JOptionPane.showMessageDialog(null, "Let's get you patched up!"); 
        if (character.getMoney() >= 10)
        {
            character.setHP(character.getMax()); 
            JOptionPane.showMessageDialog(null, "What a wonderful drink!");
            character.setMoney(-10);   
            JOptionPane.showMessageDialog(null, "Money: " + character.getMoney()
            );
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Not enough cash!");
            JOptionPane.showMessageDialog(null, "Money: " + character.getMoney()
            );
        }
        JOptionPane.showMessageDialog(null, "HP"+ character.getHP());
        JOptionPane.showMessageDialog(null, "Cash" + character.getMoney());  
    }
    
    /**
     * Allows the player to choose between
     * upgrades for their attack and maximum
     * health by spending gold. 
     */
    public void shop()
    {
        String input; 
        int selection; 
        boolean shopping = true; 
        
        while(shopping == true)
        {
            input = JOptionPane.showInputDialog("What would you like to buy?" + 
                    "\n All 5 gold!"+  "\n Money: " + character.getMoney()+ 
                    "\n 1. Wooden Sword (Attack +1)" + 
                    "\n 2. Shield (HP + "
                    + "5)" + "\n 0. Exit");
            selection = Integer.parseInt(input); 
            if (selection == 1)
            {
                if (character.getMoney() >= 5)
                {
                    character.setMoney(-5);
                    character.setAttack(1); 
                    JOptionPane.showMessageDialog(null, "Attack: " + 
                            character.getAttack());
                    JOptionPane.showMessageDialog(null, "Money: " + 
                            character.getMoney());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Not enough cash!");
                    JOptionPane.showMessageDialog(null, "Money: " + 
                            character.getMoney());
                }
                 
            }
            else if (selection == 2)
            {
                if(character.getMoney() >= 5)
                {
                    character.setMoney(-5); 
                    character.setMax(5);
                    JOptionPane.showMessageDialog(null, "Max HP: "+ 
                            character.getMax());
                    JOptionPane.showMessageDialog(null, "Money: " + 
                            character.getMoney());
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Not enough cash!");
                    JOptionPane.showMessageDialog(null, "Money: " + 
                            character.getMoney());
                }
                
            }
            else if (selection == 0)
            {
                shopping = false; 
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Not valid!");
            }
        }
        
    }
    
    /**
     * Restores the player health back to 
     * maximum, without having to spend gold, 
     * and saves calls the saveData method. 
     * 
     * @throws FileNotFoundException
     */
    public void rest() throws FileNotFoundException
    {
        character.setHP(character.getMax());
        data.saveData(character.getName(), character.getMax(), character.getHP()
                , character.getAttack(), character.getMoney());
    }
    
}
