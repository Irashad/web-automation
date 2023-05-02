package com.insider.automation.steps;

import com.insider.automation.session.PageObjectHolder;
import com.insider.automation.utils.Helper;

public class BaseSteps extends Hooks{
     Helper helper;
    // PageObjectHolder pages;

    public BaseSteps(){
        helper = new Helper();
     //   pages = PageObjectHolder.getPages();
    }

}
