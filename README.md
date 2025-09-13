# [API Documentation](https://developer.accuweather.com)
# Endpoints
1. [GET] [Admin Area List with country code](https://developer.accuweather.com/core-weather/list#administrative-area-list-by-country-code)
2. [GET] [Admin Area List](https://developer.accuweather.com/core-weather/list#administrative-area-list-by-country-code)

# How to use it
```declarative
// Create client
AccuWeatherClient client = new AccuWeatherClient();

// Create parameters if needed
Map<String,String> parameters = new HashMap<>();
parameters.put("parameter01", "value01");

// Create request
AccuWeatherRequest request = new AdminAreaListRequest("UY", parameters);

// Execute request
Object response = client.call(request);
```
