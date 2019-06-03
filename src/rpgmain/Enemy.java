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
        drop = 10; 
    }
    
    public Enemy(Enemy copy)
    {
        name = copy.name; 
        maxHP = copy.maxHP; 
        hp = copy.hp; 
        attack = copy.attack; 
        drop = copy.drop; 
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
    
    public int getDrop()
    {
        return drop; 
    }
    
    public void set(String enemyName, int enemyMaxHP, int enemyHP, int enemyAttack,
            int newDrop)
    {
        name = enemyName; 
        maxHP = enemyMaxHP; 
        hp = enemyHP; 
        attack = enemyAttack;
        drop = newDrop; 
    }
    
    public void type2()
    {
        name = "Gorgon"; 
        maxHP = 10; 
        hp = maxHP; 
        attack = 2; 
        drop = 10; 
    }
}
