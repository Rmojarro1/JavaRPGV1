/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmain;

/**
 *
 * @author gamef
 */
public class Enemy {
    private String name; 
    private int maxHP; 
    private int hp; 
    private int attack; 
    private int drop; 
    
    public Enemy()
    {
        name = "Slime";
        maxHP = 5; 
        hp = maxHP; 
        attack = 1; 
        drop = 5; 
    }
    
    public Enemy(Enemy copy)
    {
        name = copy.name; 
        maxHP = copy.maxHP; 
        hp = copy.hp; 
        attack = copy.attack; 
        drop = copy.drop; 
    }
    
    /**
     * Returns the current enemy health.
     * @return
     */
    public int getHP()
    {
        return hp; 
    }
    
    /**
     * Returns the enemy name. 
     * @return
     */
    public String getName()
    {
        return name; 
    }
    
    /**
     * Returns the enemy's attack. 
     * @return
     */
    public int getAttack()
    {
        return attack;  
    }
    
    /**
     * Returns the enemy's maximum health. 
     * @return
     */
    public int getMax()
    {
        return maxHP; 
    }
    
    /**
     * Returns the amount of money the enemy drops. 
     * @return
     */
    public int getDrop()
    {
        return drop; 
    }
    
    /**
     * Sets the variables for the enemy based on the arguments. 
     * @param enemyName
     * @param enemyMaxHP
     * @param enemyHP
     * @param enemyAttack
     * @param newDrop
     */
    public void set(String enemyName, int enemyMaxHP, int enemyHP, int enemyAttack,
            int newDrop)
    {
        name = enemyName; 
        maxHP = enemyMaxHP; 
        hp = enemyHP; 
        attack = enemyAttack;
        drop = newDrop; 
    }
    
    /**
     * Sets the enemy variables to that of the second enemy type. 
     */
    public void type2()
    {
        name = "Gorgon"; 
        maxHP = 10; 
        hp = maxHP; 
        attack = 2; 
        drop = 5; 
    }
    
    public void type3()
    {
        name = "Orc"; 
        maxHP = 15; 
        hp = maxHP; 
        attack = 2; 
        drop = 5; 
    }
    
    public void type4()
    {
        name = "Titan"; 
        maxHP = 20; 
        hp = maxHP; 
        attack = 3; 
        drop = 5; 
    }
}
