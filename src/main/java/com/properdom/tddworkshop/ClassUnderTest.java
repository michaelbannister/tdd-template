package com.properdom.tddworkshop;

public class ClassUnderTest {

    private DependencyClass dependencyClass;

    public ClassUnderTest(DependencyClass dependencyClass) {
        this.dependencyClass = dependencyClass;
    }

    public String method(int x, int y) {
        return dependencyClass.method(x + y);
    }

    public DependencyClass getDependencyClass() {
        return dependencyClass;
    }
}
