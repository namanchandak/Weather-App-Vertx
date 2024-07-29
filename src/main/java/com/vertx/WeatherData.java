package com.vertx;
import java.util.List;


public class WeatherData {

    public static class Location {
        private String code;
        private String name;
        private String timezone;
        private Coordinates coordinates;

        // Getters and setters
        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getTimezone() { return timezone; }
        public void setTimezone(String timezone) { this.timezone = timezone; }

        public Coordinates getCoordinates() { return coordinates; }
        public void setCoordinates(Coordinates coordinates) { this.coordinates = coordinates; }
    }

    public static class Coordinates {
        private double latitude;
        private double longitude;

        // Getters and setters
        public double getLatitude() { return latitude; }
        public void setLatitude(double latitude) { this.latitude = latitude; }

        public double getLongitude() { return longitude; }
        public void setLongitude(double longitude) { this.longitude = longitude; }
    }

    public static class Forecast {
        private List<ForecastItem> items;

        // Getters and setters
        public List<ForecastItem> getItems() { return items; }
        public void setItems(List<ForecastItem> items) { this.items = items; }
    }

    public static class ForecastItem {
        private String date;
        private String dateWithTimezone;
        private double freshSnow;
        private Object snowHeight;
        private Weather weather;
        private Precipitation prec;
        private double sunHours;
        private Object rainHours;
        private Temperature temperature;
        private Wind wind;
        private Windchill windchill;
        private SnowLine snowLine;
        private Astronomy astronomy;

        // Getters and setters
        // Add all getters and setters here
        // ...
    }

    public static class Weather {
        private int state;
        private String text;
        private String icon;

        // Getters and setters
        public int getState() { return state; }
        public void setState(int state) { this.state = state; }

        public String getText() { return text; }
        public void setText(String text) { this.text = text; }

        public String getIcon() { return icon; }
        public void setIcon(String icon) { this.icon = icon; }
    }

    public static class Precipitation {
        private double sum;
        private int probability;
        private Object sumAsRain;
        private int precClass;

        // Getters and setters
        public double getSum() { return sum; }
        public void setSum(double sum) { this.sum = sum; }

        public int getProbability() { return probability; }
        public void setProbability(int probability) { this.probability = probability; }

        public Object getSumAsRain() { return sumAsRain; }
        public void setSumAsRain(Object sumAsRain) { this.sumAsRain = sumAsRain; }

        public int getPrecClass() { return precClass; }
        public void setPrecClass(int precClass) { this.precClass = precClass; }
    }

    public static class Temperature {
        private double min;
        private double max;
        private Object avg;

        // Getters and setters
        public double getMin() { return min; }
        public void setMin(double min) { this.min = min; }

        public double getMax() { return max; }
        public void setMax(double max) { this.max = max; }

        public Object getAvg() { return avg; }
        public void setAvg(Object avg) { this.avg = avg; }
    }

    public static class Wind {
        private String unit;
        private String direction;
        private String text;
        private Object avg;
        private double min;
        private double max;
        private Gusts gusts;
        private boolean significationWind;

        // Getters and setters
        // Add all getters and setters here
        // ...
    }

    public static class Gusts {
        private double value;
        private Object text;

        // Getters and setters
        public double getValue() { return value; }
        public void setValue(double value) { this.value = value; }

        public Object getText() { return text; }
        public void setText(Object text) { this.text = text; }
    }

    public static class Windchill {
        private double min;
        private double max;
        private Object avg;

        // Getters and setters
        public double getMin() { return min; }
        public void setMin(double min) { this.min = min; }

        public double getMax() { return max; }
        public void setMax(double max) { this.max = max; }

        public Object getAvg() { return avg; }
        public void setAvg(Object avg) { this.avg = avg; }
    }

    public static class SnowLine {
        private Object avg;
        private Object min;
        private Object max;
        private String unit;

        // Getters and setters
        // Add all getters and setters here
        // ...
    }

    public static class Astronomy {
        private String dawn;
        private String sunrise;
        private String suntransit;
        private String sunset;
        private String dusk;
        private String moonrise;
        private String moontransit;
        private String moonset;
        private int moonphase;
        private int moonzodiac;

        // Getters and setters
        // Add all getters and setters here
        // ...
    }

    private Location location;
    private Forecast forecast;

    // Getters and setters
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public Forecast getForecast() { return forecast; }
    public void setForecast(Forecast forecast) { this.forecast = forecast; }
}
