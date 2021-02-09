package com.itaz.Linster;

import com.itaz.utils.DoTask;
import com.itaz.utils.Task;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TaskLinster implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Timer timer = new Timer(true);
        Calendar calendar =Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day =calendar.get(Calendar.DAY_OF_MONTH);//每天
        long period = 24*60*60*100;
        calendar.set(year, month, day, 1, 41, 00);
        Date date = calendar.getTime();
        timer.schedule(new DoTask(),date,period);
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
