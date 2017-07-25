package com.company;

/**
 * Created by franciswalsh on 7/25/17.
 */
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private String name;
    private List<FamilyTree> children;

    public FamilyTree (String name) {
        this.name = name;
        children = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void addChild (FamilyTree child) {
        children.add(child);
    }

    public List<FamilyTree> getChildren () {
        return children;
    }

    //Returns true if the tree has a person with "name" anywhere
    public boolean contains (String name) {
        if (this.getName().equals(name)){
            return true;
        }
        if (this.getChildren() != null){
            for (FamilyTree child : this.getChildren()){
                if(child.getName().equals(name)){
                    return true;
                }
            }
            for(FamilyTree child : this.getChildren()){
                if(child.contains(name)){
                    return true;
                }
            }
        }
        return false;
    }

    public int getNumChildren () {
        return children.size();
    }

    //Returns the number of descendants of this
    public int getNumDescendants () {
        int sum = 0;
        if (this.getChildren() != null){
            for (FamilyTree child : this.getChildren()){
                sum++;
            }
            for (FamilyTree child : this.getChildren()){
                sum += child.getNumDescendants();
            }
        }

        return sum;
    }

    //Returns the number of descendants (including grandchildren, great grandchildren, etc)
    //Of name. If name is NOT in the tree, return -1
    public int getNumDescendantsOf (String name) {
        int sum = 0;
        if (this.contains(name)){
            if (this.getName().equals(name)){
                sum += this.getNumDescendants();
            }
            else {
                for (FamilyTree child : this.getChildren()) {
                    if (child.getName().equals(name)) {
                        sum += child.getNumDescendantsOf(name);
                    }
                    for (FamilyTree grandChild : child.getChildren()){
                        if (grandChild.getName().equals(name)){
                            sum += child.getNumDescendantsOf(name);
                        }
                    }
                }


            }
            return sum;

        }
        else {
            return -1;
        }
    }
}
