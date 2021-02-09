package com.itaz.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
        public static boolean doAuto(String name,String pwd){
            boolean finish=true;
            try {
                String url = "https://jksb.v.zzu.edu.cn/vls6sss/zzujksb.dll/first0";
                ChromeDriver chromeDriver = new ChromeDriver();
                chromeDriver.get(url);
                WebElement uid = chromeDriver.findElement(By.name("uid"));
                WebElement upw = chromeDriver.findElement(By.name("upw"));
                uid.sendKeys(name);
                upw.sendKeys(pwd);
                chromeDriver.findElement(By.name("smbtn")).click();
                chromeDriver.switchTo().frame(0);
                chromeDriver.findElement(By.xpath("/html/body/form/div/div[13]/div[5]/div[4]")).click();
                chromeDriver.findElement(By.xpath("/html/body/form/div/div[7]/div[2]/div[2]/div[6]/div[4]")).click();

                chromeDriver.close();
            }catch (Exception e){
                System.out.println(e);
                finish = false;
            }
            return finish;
        }
}
