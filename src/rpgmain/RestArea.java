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
    
    public boolean intermission() throws FileNotFoundException
    {
        boolean preparing = true; 
        boolean continuePlay = true; 
        while (preparing == true)
        {
            String input; 
            int selection;
            input = JOptionPane.showInputDialog("HP: "+ character.getHP()+ 
                    "\n Money:" + character.getMoney()+ "\nWhat would you like to do?"
            + "\n 1. Visit shop" + "\n 2. Heal (10 g)" + "\n 3. Save and exit"
            + "\n 4. Continue");
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
                continuePlay = false; 
                preparing = false; 
            }
            else if (selection == 4)
            {
                preparing = false; 
            }
            else 
            {
                System.out.println("Not valid!"); 
            }
        }
        return continuePlay; 
    }
    
    public void healPlayer()
    {
        JOptionPane.showMessageDialog(null, "Let's get you patched up!"); 
        if (character.getMoney() >= 10)
        {
            character.setHP(character.getMax()); 
            JOptionPane.showMessageDialog(null, "What a wonderful drink!");
            character.setMoney(-10);   
            System.out.println("Money: " + character.getMoney());
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Not enough cash!");
            System.out.println("Money: " + character.getMoney());
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
                    System.out.println("Attack: "+character.getAttack());
                    System.out.println("Money: " + character.getMoney());
                }
                else
                {
                    System.out.println("Not enough cash!");
                    System.out.println("Money: " + character.getMoney());
                }
                 
            }
            else if (selection == 2)
            {
                if(character.getMoney() >= 5)
                {
                    character.setMoney(-5); 
                    character.setMax(5);
                    System.out.println("Max HP: "+ character.getMax());
                    System.out.println("Money: " + character.getMoney());
                }
                else 
                {
                    System.out.println("Not enough cash!");
                    System.out.println("Money: " + character.getMoney());
                }
                
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
        System.out.println("HP: "+ character.getHP());
        data.saveData(character.getName(), character.getMax(), character.getHP()
                , character.getAttack(), character.getMoney());
    }
}
