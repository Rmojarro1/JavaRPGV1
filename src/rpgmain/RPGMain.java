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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gamef
 */
public class RPGMain {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        DataManager data = new DataManager(); 

        String input;
        int action; 
        Character player = new Character(); 
        
        input = JOptionPane.showInputDialog("Welcome to the RPG game!" + 
                "\n 1. Create a new game" + "\n 2. Load a saved game"); 
        action = Integer.parseInt(input);
        while (action <= 0 || action >= 3)
        {
            input = JOptionPane.showInputDialog("Not a valid selection!" + 
                "\n 1. Create a new game" + "\n 2. Load a saved game"); 
            action = Integer.parseInt(input);
        }
        if (action == 1)
        {
            data.newSaveData();      
        }
        else
        {
            data.loadData(); 
        } 
        player.set(data.getName(), data.getStats());
        Enemy enemy1 = new Enemy(); 
        BattleManager battle1 = new BattleManager(player, enemy1); 
        battle1.battle();
        RestArea rest = new RestArea(player, data); 
        //rest.healPlayer();
        rest.intermission();

        
//         
//        System.out.println("You won!");
//        playerMoney += 20; 
//        data.saveData(playerName, playerMaxHP, playerHP, playerAttack, 
//                playerMoney);
//        RestArea rest = new RestArea(); 
//        playerHP = rest.healPlayer(playerMoney, playerMaxHP, playerHP);
//        System.out.println(playerHP); 
//        System.out.println("Money" + playerMoney);
       
    }
    
}
