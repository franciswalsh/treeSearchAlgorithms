package com.company;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Main {


    public static void main(String[] args) {
//        buildTree();

        testContains();
        testGetNumDescendants();
        testGetNumDescendantsOf();

        System.out.println("All tests passed!");
    }

    public static void testContains() {
        FamilyTree brenda = new FamilyTree("Brenda Sasser");
        brenda.addChild(new FamilyTree("Sally Sasser"));
        brenda.addChild(new FamilyTree("Ben Sasser"));

        FamilyTree charlie = new FamilyTree("Charlie McCall");

        FamilyTree casey = new FamilyTree("Casey McCall");
        casey.addChild(charlie);
        casey.addChild(new FamilyTree("Dan McCall"));

        FamilyTree pops = new FamilyTree("Grampa McCall");
        pops.addChild(casey);
        pops.addChild(brenda);

        assertTrue(pops.contains("Charlie McCall"));
        assertTrue(pops.contains("Ben Sasser"));
        assertFalse(pops.contains("McCall"));
        assertFalse(pops.contains("Lando Calrissian"));
    }

    public static void testGetNumDescendants () {
        FamilyTree brenda = new FamilyTree("Brenda Sasser");
        brenda.addChild(new FamilyTree("Sally Sasser"));
        brenda.addChild(new FamilyTree("Ben Sasser"));

        FamilyTree charlie = new FamilyTree("Charlie McCall");

        FamilyTree casey = new FamilyTree("Casey McCall");
        casey.addChild(charlie);
        casey.addChild(new FamilyTree("Dan McCall"));

        FamilyTree pops = new FamilyTree("Grampa McCall");
        pops.addChild(casey);
        pops.addChild(brenda);

        assertEquals(6, pops.getNumDescendants());
        assertEquals(2, casey.getNumDescendants());
        assertEquals(0, charlie.getNumDescendants());
    }

    public static void testGetNumDescendantsOf () {
        FamilyTree brenda = new FamilyTree("Brenda Sasser");
        brenda.addChild(new FamilyTree("Sally Sasser"));
        brenda.addChild(new FamilyTree("Ben Sasser"));

        FamilyTree charlie = new FamilyTree("Charlie McCall");

        FamilyTree casey = new FamilyTree("Casey McCall");
        casey.addChild(charlie);
        casey.addChild(new FamilyTree("Dan McCall"));

        FamilyTree pops = new FamilyTree("Grampa McCall");
        pops.addChild(casey);
        pops.addChild(brenda);

        assertEquals(6, pops.getNumDescendantsOf("Grampa McCall"));
        assertEquals(2, pops.getNumDescendantsOf("Casey McCall"));
        assertEquals(0, pops.getNumDescendantsOf("Charlie McCall"));
        assertEquals(-1, pops.getNumDescendantsOf("Lando Calrissian"));

        charlie.addChild(new FamilyTree("Jonas McCall"));

        assertEquals(7, pops.getNumDescendantsOf("Grampa McCall"));
        assertEquals(3, pops.getNumDescendantsOf("Casey McCall"));
        assertEquals(1, pops.getNumDescendantsOf("Charlie McCall"));
    }




}
