package com.insider.automation.pageobjects.components.base;

import framework.locators.ILocator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SelectDropDown extends BaseElement {


    public SelectDropDown(ILocator locator) {
        super(locator);
    }

    private Select select() {
        return new Select(webElement());
    }

    public List<WebElement> options() {
        return select().getOptions();
    }

    public List<String> optionNames() {
        return options()
                .stream()
                .map(option -> option.getText().trim())
                .collect(Collectors.toList());
    }

    public List<String> optionNamesNoSelectSize() {
        return optionNames()
                .stream()
                .filter(size -> !size.toLowerCase().contains("select"))
                .collect(Collectors.toList());
    }

    public int optionIndex(String option) {
        return optionNames().indexOf(option);
    }

    public void selectOption(String option) {
        option = option.trim();
        selectByVisibleText(option);

    }

    public void selectByVisibleText(String option) {
        select().selectByVisibleText(option);
    }

    public void selectOption(int index) {
        select().selectByIndex(index);
    }

    public void selectValue(String value) {
        select().selectByValue(value);
    }

    public Boolean containsOption(String option) {
        return select().getOptions().toString().contains(option);
    }

    public String getSelectedOption() {
        return select().getFirstSelectedOption().getText().trim();
    }

    public String getAttributeOfSelectedOption(String attr) {
        return select().getFirstSelectedOption().getAttribute(attr).trim();
    }

}

