package hy.material2inheritance.material2polymorphism;

import hy.material2inheritance.models.Child;
import hy.material2inheritance.models.Parent;

public class Polymorphism {

    public Polymorphism() {
    
        Parent p1 = new Parent();
        Parent p2 = new Child();

        Child c2 = new Child();

        p1 = p2;

        p1 = c2;

        needParent(new Parent());
        needParent(new Child());

        // needChild(new Parent());
        needChild(new Child());
    }

    public void needParent(Parent parent) {}

    public void needChild(Child child) {}

    public Parent polymorphParent() {
        return new Child();
    }

}
