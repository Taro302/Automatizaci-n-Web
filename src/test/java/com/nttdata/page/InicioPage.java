package com.nttdata.page;
import org.openqa.selenium.By;

public class InicioPage {
    public static By SearchPageLogin = By.xpath("//*[@id='_desktop_user_info']/div/a");  // Usamos <a> en lugar de <span>
    public static By Category = By.className("category");

}
