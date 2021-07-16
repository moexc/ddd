package cn.moexc.ddd.app.service.impl;

public class Test {
    public static void main(String[] args) {

        try(Cab cab = new Cab("moexc")){
            if (cab != null){
                throw new RuntimeException("this is an error");
            }
            System.out.println(cab.hello());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
