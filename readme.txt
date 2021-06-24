
Actuator health endpoint
------------------------------
http://localhost:8088/product-search/actuator/health


Assumption and design decissions
----------------------------------
1. If no criteria matches, return whole response from the mock service without any filter
2. Since it is clearly mentioned that mock service response is static data, hence
 used @PostConstruct to load the data only once.
3.
