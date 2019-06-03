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
    
    public Enemy()
    {
        name = "Slime";
        maxHP = 5; 
        hp = maxHP; 
        attack = 1; 
    }
    
    public Enemy(Enemy copy)
    {
        name = copy.name; 
        maxHP = copy.maxHP; 
        hp = copy.hp; 
        attack = copy.attack; 
    }
    
    public int getHP()
    {
        return hp; 
    }
    
    public String getName()
    {
        return name; 
    }
    
    public int getAttack()
    {
        return attack; 
    }
    
    public int getMax()
    {
        return maxHP; 
    }
    
    public void set(String enemyName, int enemyMaxHP, int enemyHP, int enemyAttack)
    {
        name = enemyName; 
        maxHP = enemyMaxHP; 
        hp = enemyHP; 
        attack = enemyAttack; 
    }
}
