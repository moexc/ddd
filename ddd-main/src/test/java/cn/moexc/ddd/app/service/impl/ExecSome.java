package cn.moexc.ddd.app.service.impl;

abstract class ExecSome {
    public void start(){
        one();
        two();
        three();
    }

    protected abstract void one();
    protected abstract void two();
    protected abstract void three();
}
