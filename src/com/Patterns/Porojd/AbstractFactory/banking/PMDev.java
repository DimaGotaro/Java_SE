package com.Patterns.Porojd.AbstractFactory.banking;

import com.Patterns.Porojd.AbstractFactory.PM;

public class PMDev implements PM {
    @Override
    public void manageProject() {
        System.out.println("Manage project...");
    }
}
