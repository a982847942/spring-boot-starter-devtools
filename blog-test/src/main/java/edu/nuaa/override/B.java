package edu.nuaa.override;

/**
 * @author brain
 * @version 1.0
 * @date 2023/7/12 11:04
 */
public class B extends A{
    @Override
    public ParamB sayHello() {
       return new ParamB();
    }
}
