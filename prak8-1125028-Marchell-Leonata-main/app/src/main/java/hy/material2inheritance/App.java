package hy.material2inheritance;

import hy.material2inheritance.accessmodifier.AccessModifier;
import hy.material2inheritance.models.Child;
import hy.material2inheritance.models.Parent;

public class App {

    public static void main(String[] args) {
        Child child = new Child();
        child.printA(); 
        child.printB(); 

        Parent parent = new Parent();
        parent.printA(); 

        AccessModifier test = new AccessModifier();
        test.publicValue = 1;

    }
}
