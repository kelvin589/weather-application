import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class WeatherParserTest {
    String apiKey = "ac4a0f1b15bf8f3aa7e4106d8784d837";
    String locationID = "2643743"; //london

    /**
     * Test getting the locationID
     */
    @Test
    public void testGetLocationID() {
        WeatherParser wp = new WeatherParser(apiKey, locationID);
        assertEquals(this.locationID, wp.getLocationID());
    }

    /**
     * Test setting the locationID
     */
    @Test
    public void testSetLocationID() {
        WeatherParser wp = new WeatherParser(apiKey, locationID);
        String newLocationID = "2655603"; //birmingham
        wp.setLocationID(newLocationID);
        assertEquals(newLocationID, wp.getLocationID());
    }

    /**
     * Test with invalid api key
     */
    @Test
    public void testInvalidApiKey() {
        WeatherParser wp = new WeatherParser("a", locationID);
        assertNull(wp.getWeather());
    }

    /**
     * Test with non-existing location ID
     */
    @Test
    public void testInvalidLocationID() {
        WeatherParser wp = new WeatherParser(apiKey, "0123");
        assertNull(wp.getWeather());
    }

    /**
     * Test with invalid location ID
     */
    @Test
    public void testInvalidParameter() {
        WeatherParser wp = new WeatherParser(apiKey, "a");
        assertNull(wp.getWeather());
    }

    /**
     * Test to make sure weather object gets returned when everything is valid
     */
    @Test
    public void testWeatherReturned() {
        WeatherParser wp = new WeatherParser(apiKey, locationID);
        assertNotNull(wp.getWeather());
    }

    /**
     * Test when you call the api more than 60 times within a minute
     */
    @Test
    public void testSixtyAPICalls() {
        WeatherParser wp = new WeatherParser(apiKey, locationID);
        for (int i=0;i<100;i++) {
            wp.getWeather();
        }
        assertNull(wp.getWeather());
    }
}
