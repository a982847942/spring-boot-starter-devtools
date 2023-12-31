package edu.nuaa.override;

/**
 * @author brain
 * @version 1.0
 * @date 2023/7/12 11:01
 */
public class ParamB extends ParamA{
    @Override
    public void sayHello() {
        System.out.println("hello ParamB");
    }
    public void sayBye(){
        System.out.println("Bye ParamB");
    }
}
