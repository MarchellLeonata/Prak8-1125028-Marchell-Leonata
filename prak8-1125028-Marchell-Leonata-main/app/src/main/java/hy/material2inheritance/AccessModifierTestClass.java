package hy.material2inheritance;

import hy.material2inheritance.accessmodifier.AccessModifier;

class AccessModifierTestClass extends AccessModifier {

    public AccessModifierTestClass() {
        AccessModifier sample = new AccessModifier();
        this.publicValue = 1;
        this.protectedValue = 2;
        
        sample.publicValue = 1;

    }
}
