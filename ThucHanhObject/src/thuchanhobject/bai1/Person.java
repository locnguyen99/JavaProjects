/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuchanhobject.bai1;

/**
 *
 * @author Admin
 */
public class Person {
     private String name;
  
    private boolean gt;
    private String quequan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGt() {
        return gt;
    }

    public void setGt(boolean gt) {
        this.gt = gt;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public Person(String name, boolean gt, String quequan) {
        this.name = name;
        this.gt = gt;
        this.quequan = quequan;
    }
    
}
