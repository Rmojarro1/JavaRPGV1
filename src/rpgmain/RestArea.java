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
    private Character character; 
    private DataManager data; 
    
    public RestArea(Character player, DataManager d)
    {
        character = new Character(player);
        data = new DataManager(d); 
    }
    
    public void intermission() throws FileNotFoundException
    {
        boolean preparing = true; 
        while (preparing == true)
        {
            String input; 
            int selection;
            input = JOptionPane.showInputDialog("What would you like to do?"
            + "\n 1. Visit shop" + "\n 2. Heal (10 g)" + "\n 3. Save and exit");
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
                restExit(); 
                preparing = false; 
            }
            else 
            {
                System.out.println("Not valid!"); 
            }
        }
    }
    
    public void healPlayer()
    {
        JOptionPane.showMessageDialog(null, "Let's get you patched up!"); 
        if (character.getMoney() >= 10)
        {
            character.setHP(character.getMax()); 
            JOptionPane.showMessageDialog(null, "What a wonderful drink!");
            character.setMoney((character.getMoney() - 10));   
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Not enough cash!");
        }
        System.out.println("HP"+ character.getHP());
        System.out.println("Cash" + character.getMoney());  
    }
    
    public void shop()
    {
        String input; 
        int selection; 
        boolean shopping = true; 
        
        while(shopping == true)
        {
            input = JOptionPane.showInputDialog("What would you like to buy?" + "\n "
                + "1. Wooden Sword (Attack +3)" + "\n 2. Shield (HP + 5)" + 
                    "\n 0. Exit");
            selection = Integer.parseInt(input); 
            if (selection == 1)
            {
                character.setAttack(3); 
                System.out.println(character.getAttack()); 
            }
            else if (selection == 2)
            {
                character.setMax(5);
                System.out.println(character.getMax());
            }
            else if (selection == 0)
            {
                shopping = false; 
            }
            else
            {
                System.out.println("Not valid!");
            }
        }
        
    }
    
    public void restExit() throws FileNotFoundException
    {
        character.setHP(character.getMax());
        data.saveData(character.getName(), character.getMax(), character.getHP()
                , character.getAttack(), character.getMoney());
    }
}
