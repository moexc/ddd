package cn.moexc.ddd.app.service.impl;

public class ExecSomeImpl extends ExecSome{
    @Override
    protected void one() {
        System.out.println("one");
    }

    @Override
    protected void two() {
        System.out.println("two");
    }

    @Override
    protected void three() {
        System.out.println("three");
    }
}
