package com.chiragbohet.springintroduction.rough;

public class Runner {
    public static void main(String[] args) {
        A a = new A();
    }
}

class A{
    A(){
        System.out.println("A cons");
    }
    B b = new B();
}

class B{
    B(){
        System.out.println("B cons");
    }
}
