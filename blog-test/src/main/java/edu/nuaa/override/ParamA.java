package edu.nuaa.override;

/**
 * @author brain
 * @version 1.0
 * @date 2023/7/12 11:00
 */
public class ParamA {
    private String name;
    public void sayHello(){
        System.out.println("hello ParamA");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
