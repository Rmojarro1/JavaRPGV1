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
    
    /**
     * Plays out a battle between the player
     * and an enemy. Returns a true boolean 
     * upon completion if the player is successful
     * and a false one if they lose. 
     * @return
     */
    public boolean battle()
    {
        String input; 
        int action; 
        boolean playerAlive = true; 
        boolean enemyAlive = true; 
        if (character.getRow() > 3)
        {
            enemy.type4(); 
        }
        else if (character.getRow() > 2)
        {
            enemy.type3(); 
        }
        else if (character.getRow() > 1)
        {
            enemy.type2();
        }
        int playerHP = character.getHP(); 
        int enemyHP = enemy.getHP(); 
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
                 System.out.println(); 
                 JOptionPane.showMessageDialog(null,"You strike the " + 
                         enemy.getName() + "!" +  "\n" +  enemy.getName()
                         + ": " + enemyHP + "/" + enemy.getMax()); 
             }
             if (action == 2)
             {
                 JOptionPane.showMessageDialog(null, character.getName() +
                         " defends!"); 
             }
             
             if (enemyHP <= 0)
             {
                 enemyAlive = false;
                 JOptionPane.showMessageDialog(null, enemy.getName() + " beaten!");
             }
             
             else
             {
                 JOptionPane.showMessageDialog(null, "The "+ enemy.getName() + 
                         " attacks!");
                if (action == 2)
                {
                    playerHP -= ((enemy.getAttack() / 2)); 
                    JOptionPane.showMessageDialog(null, character.getName() + 
                            " blocks the strike!"+ "\n"+ character.getName() + 
                            ": " + playerHP + "/" + character.getMax()); 
                }
                else
                {
                    playerHP -= enemy.getAttack(); 
                    JOptionPane.showMessageDialog(null, character.getName() + 
                            " is hit!" + "\n" + character.getName() + 
                            ":" + playerHP + "/" + character.getMax());
                }
                if (playerHP <= 0)
                {
                    playerAlive = false; 
                    JOptionPane.showMessageDialog(null, character.getName() +
                            " died!");
                }
             }
        }
        character.setHP(playerHP); 
        if (character.getHP() > 0)
        {
            if (character.getRow() > 1)
            {
                character.setMoney((enemy.getDrop() * character.getRow()));
                JOptionPane.showMessageDialog(null, enemy.getName() + " dropped "+ 
                    (enemy.getDrop() * character.getRow()) + " gold!");
            }
            else
            {
                character.setMoney(enemy.getDrop());
                JOptionPane.showMessageDialog(null, enemy.getName() + " dropped "
                        + enemy.getDrop() + " gold!");
            }
        }

        return playerAlive; 
    }

}
