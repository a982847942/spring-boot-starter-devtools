package edu.nuaa.override.t_01;

import java.io.Serializable;

/**
 * @author brain
 * @version 1.0
 * @date 2023/7/12 15:26
 */
public class OverLoad {
//    public static void sayHello(Object arg){
//        System.out.println("hello Object");
//    }
//    public static void sayHello(int arg){
//        System.out.println("hello int");
//    }
//    public static void sayHello(long arg){
//        System.out.println("hello long");
//    }
    public static void sayHello(Character arg){
        System.out.println("hello character");
    }
//    public static void sayHello(char arg){
//        System.out.println("hello char");
//    }
    public static void sayHello(char... arg){
        System.out.println("hello char...");
    }
//    public static void sayHello(Serializable arg){
//        System.out.println("hello Serializable");
//    }

    public static void main(String[] args) {
        sayHello('a');
    }

}
