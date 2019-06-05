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
public class Character {
    private String name; 
    private int maxHP; 
    private int hp; 
    private int attack; 
    private int money; 
    private int row = 1;  
    
    public Character()
    {
        
    }
            
    public Character(String n, int mhp, int h, int a, int m)
    {
        name = n; 
        maxHP = mhp; 
        hp = h; 
        attack = a; 
        money = m; 
    }
    
    public Character(String n, int[] stats)
    {
        name = n; 
        maxHP = stats[0]; 
        hp = stats[1]; 
        attack = stats[2]; 
        money = stats[3]; 
    }
    
    public Character(Character copy)
    {
        name = copy.name; 
        maxHP = copy.maxHP; 
        hp = copy.hp; 
        attack = copy.attack; 
        money = copy.money; 
    }
    
    /**
     * Assigns the values in the constructors 
     * to the character. 
     * @param n
     * @param stats
     */
    public void set(String n, int stats[])
    {
        name = n; 
        maxHP = stats[0]; 
        hp = stats[1]; 
        attack = stats[2]; 
        money = stats[3];
    }
    
    /**
     * Modifies the player health stat to the
     * values posted in the argument. 
     * @param newHP
     */
    public void setHP(int newHP)
    {
        hp= newHP; 
    }
    
    /**
     * Returns the player health stat. 
     * @return
     */
    public int getHP()
    {
        return hp; 
    }
    
    /**
     * Returns the maximum player health. 
     * @return
     */
    public int getMax()
    {
        return maxHP; 
    }
    
    /**
     * Returns the player attack stat. 
     * @return
     */
    public int getAttack()
    {
        return attack; 
    }
    
    /**
     * Returns the player name. 
     * @return
     */
    public String getName()
    {
        return name; 
    }
    
    /**
     * Returns the player money. 
     * @return
     */
    public int getMoney()
    {
        return money; 
    }
    
    /**
     * Adds the argument to the player money. 
     * @param m
     */
    public void setMoney(int m)
    {
        money += m; 
    }
    
    /**
     * Adds the argument to the player attack. 
     * @param a
     */
    public void setAttack(int a)
    {
        attack += a; 
    }
    
    /**
     * Adds the argument to the player maximum health. 
     * @param mh
     */
    public void setMax(int mh)
    {
        maxHP += mh; 
    }
    
    /**
     * Returns how many battles the player has 
     * fought in a row without saving. 
     * @return
     */
    public int getRow()
    {
        return row; 
    }
    
    /**
     * Modifies the amount of battles the 
     * player has fought in a row. 
     * @param r
     */
    public void setRow(int r)
    {
        row = r; 
    }
}
