package cn.moexc.ddd.app.service.impl;

public class Cab implements AutoCloseable{
    private String name;

    public Cab(String name) {
        this.name = name;
    }

    public String hello(){
        return "hello, " + this.name;
    }

    @Override
    public void close() throws Exception{
        System.out.println("close resource...");
    }
}
