package edu.nuaa.override;

/**
 * @author brain
 * @version 1.0
 * @date 2023/7/12 10:59
 */
public class A {
    private String name;

    public ParamA sayHello(){
        return new ParamA();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
