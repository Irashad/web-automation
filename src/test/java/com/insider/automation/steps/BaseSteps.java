package com.insider.automation.steps;

import com.insider.automation.session.PageObjectHolder;
import com.insider.automation.utils.Helper;

public class BaseSteps extends Hooks {

    Helper helper;

    public BaseSteps() {
        helper = new Helper();

    }

    public PageObjectHolder getPages() {
        return PageObjectHolder.getInstance();
    }
}
