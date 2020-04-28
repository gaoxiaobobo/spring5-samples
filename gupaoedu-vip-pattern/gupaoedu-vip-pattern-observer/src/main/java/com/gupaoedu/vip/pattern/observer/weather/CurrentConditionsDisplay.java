package com.gupaoedu.vip.pattern.observer.weather;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    // 当update()被调用时，我们把温度和湿度保存起来，然后调用display()
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    // 显示温度和湿度
    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + " F degrees and " + humidity + "% humidity");
    }
}
