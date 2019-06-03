/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmain;

import javax.swing.JOptionPane;

/**
 *
 * @author gamef
 */
public class BattleManager {

    private final Character character; 
    private Enemy enemy; 
    
    public BattleManager(Character character, Enemy ene)
    {
        this.character = character; 
        enemy = new Enemy(ene); 
    }
    
    public boolean battle()
    {
        String input; 
        int action; 
        int playerHP = character.getHP(); 
        int enemyHP = enemy.getHP(); 
        boolean playerAlive = true; 
        boolean enemyAlive = true; 
        if (playerHP > 5)
        {
            enemy.type2();
        }
        JOptionPane.showMessageDialog(null, "A " + enemy.getName() + " draws near!"); 
        while (playerAlive == true && enemyAlive == true)
        {
             input = JOptionPane.showInputDialog("Command?" + "\n 1. Attack" + 
                     "\n 2. Defend");
             action = Integer.parseInt(input); 
             
             while (action <= 0 || action >= 3)
             {
                 input = JOptionPane.showInputDialog("Invalid! Command?" + "\n"
                         + " 1. Attack" + "\n 2. Defend");
                 action = Integer.parseInt(input);
             }
             if (action == 1)
             {
                 enemyHP -= character.getAttack(); 
                 System.out.println(enemy.getName()+ ": " + enemyHP + "/" + 
                         enemy.getMax()); 
             }
             if (action == 2)
             {
                 System.out.println("Defending!"); 
             }
             
             if (enemyHP <= 0)
             {
                 enemyAlive = false;
                 System.out.println(enemy.getName() + " beaten!");
             }
             
             else
             {
                 System.out.println(enemy.getName() + " attacks!");
             
                if (action == 2)
                {
                    playerHP -= (enemy.getAttack() - 1); 
                    System.out.println(character.getName() + ": " + playerHP + 
                            "/" + character.getMax()); 
                }
                else
                {
                    playerHP -= enemy.getAttack(); 
                    System.out.println(character.getName() + ":" + playerHP + "/" +
                            character.getMax());
                }
                if (playerHP <= 0)
                {
                    playerAlive = false; 
                    System.out.println("You died!");
                    System.exit(0);
                }
             }
        }
        character.setHP(playerHP); 
        character.setMoney(enemy.getDrop());
        System.out.println(enemy.getName() + " dropped "+ enemy.getDrop() + " gold!");
        return playerAlive; 
    }

}
