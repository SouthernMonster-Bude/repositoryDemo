package o.h.j.m.templatemod.service;

import o.h.j.m.templatemod.template.GameDeveloper;

public class GameDeveloperExtend extends GameDeveloper {
    @Override
    protected void plan() {
        System.out.println("GameDeveloperExtend plan");
    }

    @Override
    protected void design() {
        System.out.println("GameDeveloperExtend design");
    }

    @Override
    protected void prepare() {
        System.out.println("GameDeveloperExtend prepare");
    }

    @Override
    protected void code() {
        System.out.println("GameDeveloperExtend code");
    }

    @Override
    protected void test() {
        System.out.println("GameDeveloperExtend test");
    }

    @Override
    protected void pack() {
        System.out.println("GameDeveloperExtend pack");
    }

    @Override
    protected void run() {
        System.out.println("GameDeveloperExtend run");
    }
}
