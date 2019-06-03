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
    
    public void set(String n, int stats[])
    {
        name = n; 
        maxHP = stats[0]; 
        hp = stats[1]; 
        attack = stats[2]; 
        money = stats[3];
    }
    
    public void setHP(int current)
    {
        hp = current; 
    }
    
    public int getHP()
    {
        return hp; 
    }
    
    public int getMax()
    {
        return maxHP; 
    }
    
    public int getAttack()
    {
        return attack; 
    }
    
    public String getName()
    {
        return name; 
    }
    
    public int getMoney()
    {
        return money; 
    }
    
    public void setMoney(int m)
    {
        money = m; 
    }
    

    public void setAttack(int a)
    {
        attack += a; 
    }
    
    public void setMax(int mh)
    {
        maxHP += mh; 
    }
}
