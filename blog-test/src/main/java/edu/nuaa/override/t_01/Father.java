package edu.nuaa.override.t_01;

import java.io.Serializable;

/**
 * @author brain
 * @version 1.0
 * @date 2023/7/12 15:00
 */
public class Father {
    public void doSomething(Object str){
        System.out.println("father");
    }

//    public void doSomething(Serializable str){
//        System.out.println("serializable father");
//    }
}
