package edu.nuaa.override.t_01;

/**
 * @author brain
 * @version 1.0
 * @date 2023/7/12 15:01
 */
public class Son extends Father{

    public void doSomething(String str) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Father son = new Son();
        son.doSomething(new String());
    }
}
