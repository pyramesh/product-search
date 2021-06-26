Technologies used
-------------------------
Java 11

Spring Boot 2.4.7.

lombok

SLF4J

Swagger API Documentation

Feign Client

Junit

Design Documents
---------------------------------
**Architecture diagram**: product-search/product search-architecture.png

![alt text](https://github.com/pyramesh/product-search/blob/master/product-search-architecture.png)

**Sequence diagram** : product-search/product search-sequence.png

![alt text](https://github.com/pyramesh/product-search/blob/master/product-search-sequence.png)

Application
---------------------------
port: 8088
context path: /product-search

    swagger API documentation
    -----------------------
    http://localhost:8088/product-search/swagger-ui.html

    Actuator health endpoint
    ------------------------------
    http://localhost:8088/product-search/actuator/health

Assumption and design decissions
----------------------------------
    1. If no criteria matches, return nothing
    2. Since it is clearly mentioned that mock service response is static data, hence
     used @PostConstruct to load the data only once.
    3. Feign client being used to call mock service

How to run application
-----------------------------------
    1. Execute the below command in the project root directory(product-search)
        **mvn clean install**
    2. Result of the above command,can observe the below on the console
        a. test cases:
            **[INFO] Tests run: 31, Failures: 0, Errors: 0, Skipped: 0**

        b. jar file will be generated in the below path
            '\product-search\target\product-search-0.0.1-SNAPSHOT.jar'
    3. Execute the below command to start the application in the path (product-search/target)
            **java -jar product-search-0.0.1-SNAPSHOT.jar**

    4. Result of the above command (D:\product-search\target>java -jar product-search-0.0.1-SNAPSHOT.jar)


  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.7)

2021-06-25 17:22:56.402  INFO 26004 --- [           main] c.e.p.ProductSearchApplication           : Starting ProductSearchApplication v0.0.1-SNAPSHOT using Java 11.0.2
2021-06-25 17:22:56.482  INFO 26004 --- [           main] c.e.p.ProductSearchApplication           : No active profile set, falling back to default profiles: default
2021-06-25 17:23:01.516  INFO 26004 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=2b6e5b98-c953-301d-a6d5-e6307300d494
2021-06-25 17:23:03.859  INFO 26004 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8088 (http)
2021-06-25 17:23:03.885  INFO 26004 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-06-25 17:23:03.886  INFO 26004 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.46]
2021-06-25 17:23:04.084  INFO 26004 --- [           main] o.a.c.c.C.[.[.[/product-search]          : Initializing Spring embedded WebApplicationContext
2021-06-25 17:23:04.085  INFO 26004 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 7016 ms
2021-06-25 17:23:05.932  INFO 26004 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 2 endpoint(s) beneath base path '/actuator'
2021-06-25 17:23:06.881  INFO 26004 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
2021-06-25 17:23:07.103  INFO 26004 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 1 custom documentation plugin(s)
2021-06-25 17:23:07.156  INFO 26004 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2021-06-25 17:23:12.465  INFO 26004 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8088 (http) with context path '/product-search'
2021-06-25 17:23:14.000  INFO 26004 --- [           main] c.e.p.ProductSearchApplication           : Started ProductSearchApplication in 20.892 seconds (JVM running for 23.363)


How to test the application 
-----------------------------------------------------
1. Search products by annoucedate and price:
    
    http://localhost:8088/product-search/mobile/search?announceDate=1999&price=200
    
    **Response:**
    ```json
    {
    "message": null,
    "mobileHandSets": [
        {
            "id": 28354,
            "brand": "Ericsson",
            "phone": "Ericsson A1018s",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/er1018sb.gif",
            "sim": "Mini-SIM",
            "resolution": "3 x 12 chars",
            "hardware": {
                "audioJack": "No",
                "gps": "No",
                "battery": "Removable NiMH 800 mAh battery"
            },
            "release": {
                "announceDate": "1999",
                "priceEur": 200
            }
        },
        {
            "id": 26894,
            "brand": "Ericsson",
            "phone": "Ericsson I 888",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/eri888b.gif",
            "sim": "Mini-SIM",
            "resolution": "3 x 12 chars",
            "hardware": {
                "audioJack": "No",
                "gps": "No",
                "battery": "Removable NiMH 800 mAh battery"
            },
            "release": {
                "announceDate": "1999",
                "priceEur": 200
            }
        }
    ]
}```

2. 1. Search products by sim:
    http://localhost:8088/product-search/mobile/search?sim=eSim
    
    **Response:**
        ```json
    {
    "message": null,
    "mobileHandSets": [
        {
            "id": 25846,
            "brand": "Apple",
            "phone": "Apple iPad Pro 12.9 (2018)",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-129-2018.jpg",
            "sim": "Nano-SIM eSIM",
            "resolution": "2048 x 2732 pixels",
            "hardware": {
                "audioJack": "No",
                "gps": "Yes with A-GPS",
                "battery": "Li-Po 9720 mAh battery (36.71 Wh)"
            },
            "release": {
                "announceDate": "2018 October",
                "priceEur": 1100
            }
        },
        {
            "id": 22895,
            "brand": "Apple",
            "phone": "Apple iPad Pro 11",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-11-2018.jpg",
            "sim": "Nano-SIM eSIM",
            "resolution": "1668 x 2388 pixels",
            "hardware": {
                "audioJack": "No",
                "gps": "Yes with A-GPS",
                "battery": "Li-Po 7812 mAh battery (29.45 Wh)"
            },
            "release": {
                "announceDate": "2018 October",
                "priceEur": 880
            }
        },
        {
            "id": 24989,
            "brand": "Apple",
            "phone": "Apple iPhone XS",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-xs-new.jpg",
            "sim": "Nano-SIM eSIM",
            "resolution": "1125 x 2436 pixels",
            "hardware": {
                "audioJack": "No",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion 2658 mAh battery (10.13 Wh)"
            },
            "release": {
                "announceDate": "2018 September",
                "priceEur": 1150
            }
        },
        {
            "id": 28994,
            "brand": "Apple",
            "phone": "Apple iPhone XR",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-xr-new.jpg",
            "sim": "Nano-SIM eSIM",
            "resolution": "828 x 1792 pixels",
            "hardware": {
                "audioJack": "No",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion 2942 mAh battery"
            },
            "release": {
                "announceDate": "2018 September",
                "priceEur": 850
            }
        },
        {
            "id": 28298,
            "brand": "Apple",
            "phone": "Apple Watch Series 4",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-watch-series-4-steel.jpg",
            "sim": "eSIM",
            "resolution": "448 x 368 pixels",
            "hardware": {
                "audioJack": "No",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion battery"
            },
            "release": {
                "announceDate": "2018 September",
                "priceEur": 700
            }
        },
        {
            "id": 23131,
            "brand": "Apple",
            "phone": "Apple Watch Series 4 Aluminum",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-watch-series-4-aluminum.jpg",
            "sim": "eSIM",
            "resolution": "448 x 368 pixels",
            "hardware": {
                "audioJack": "No",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion battery"
            },
            "release": {
                "announceDate": "2018 September",
                "priceEur": 430
            }
        },
        {
            "id": 24748,
            "brand": "Apple",
            "phone": "Apple iPad 9.7 (2018)",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-97-2018.jpg",
            "sim": "Nano-SIM eSIM",
            "resolution": "1536 x 2048 pixels",
            "hardware": {
                "audioJack": "Yes",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion battery (32.4 Wh)"
            },
            "release": {
                "announceDate": "2018 March",
                "priceEur": 350
            }
        },
        {
            "id": 28977,
            "brand": "Apple",
            "phone": "Apple Watch Edition Series 3",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-watch-edition-series3.jpg",
            "sim": "eSIM",
            "resolution": "390 x 312 pixels",
            "hardware": {
                "audioJack": "No",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion 279 mAh battery (1.07 Wh) - 38mm version"
            },
            "release": {
                "announceDate": "2017 September",
                "priceEur": 1450
            }
        },
        {
            "id": 29976,
            "brand": "Apple",
            "phone": "Apple Watch Series 3",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-watch-series3-.jpg",
            "sim": "eSIM",
            "resolution": "390 x 312 pixels",
            "hardware": {
                "audioJack": "No",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion 279 mAh battery (1.07 Wh) - 38mm version"
            },
            "release": {
                "announceDate": "2017 September",
                "priceEur": 700
            }
        },
        {
            "id": 20504,
            "brand": "Apple",
            "phone": "Apple Watch Series 3 Aluminum",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-watch-series3-sport-.jpg",
            "sim": "eSIM",
            "resolution": "390 x 312 pixels",
            "hardware": {
                "audioJack": "No",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion 279 mAh battery (1.07 Wh) - 38mm version"
            },
            "release": {
                "announceDate": "2017 September",
                "priceEur": 480
            }
        },
        {
            "id": 25865,
            "brand": "Apple",
            "phone": "Apple iPad Pro 12.9 (2017)",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-129-2017.jpg",
            "sim": "Nano-SIM eSIM",
            "resolution": "2732 x 2048 pixels",
            "hardware": {
                "audioJack": "Yes",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion 10891 mAh battery (41 Wh)"
            },
            "release": {
                "announceDate": "2017 June",
                "priceEur": 900
            }
        },
        {
            "id": 28335,
            "brand": "Apple",
            "phone": "Apple iPad Pro 10.5 (2017)",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-105-2017.jpg",
            "sim": "Nano-SIM eSIM",
            "resolution": "1668 x 2224 pixels",
            "hardware": {
                "audioJack": "Yes",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion 8134 mAh battery (30.8 Wh)"
            },
            "release": {
                "announceDate": "2017 June",
                "priceEur": 730
            }
        },
        {
            "id": 23770,
            "brand": "Apple",
            "phone": "Apple iPad 9.7 (2017)",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-97-2017.jpg",
            "sim": "Nano-SIM eSIM",
            "resolution": "1536 x 2048 pixels",
            "hardware": {
                "audioJack": "Yes",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion 8827 mAh battery (32.9 Wh)"
            },
            "release": {
                "announceDate": "2017 March",
                "priceEur": 390
            }
        },
        {
            "id": 27459,
            "brand": "Apple",
            "phone": "Apple iPad Pro 9.7 (2016)",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-97.jpg",
            "sim": "Nano-SIM eSIM",
            "resolution": "1536 x 2048 pixels",
            "hardware": {
                "audioJack": "Yes",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion 7306 mAh battery (27.9 Wh)"
            },
            "release": {
                "announceDate": "2016 March",
                "priceEur": 690
            }
        },
        {
            "id": 28633,
            "brand": "Apple",
            "phone": "Apple iPad Pro 12.9 (2015)",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-.jpg",
            "sim": "Nano-SIM eSIM",
            "resolution": "2048 x 2732 pixels",
            "hardware": {
                "audioJack": "Yes",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion 10307 mAh battery (38.8 Wh)"
            },
            "release": {
                "announceDate": "2015 September",
                "priceEur": 850
            }
        },
        {
            "id": 27732,
            "brand": "Apple",
            "phone": "Apple iPad mini 4",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/ipad-mini-41.jpg",
            "sim": "Nano-SIM eSIM",
            "resolution": "1536 x 2048 pixels",
            "hardware": {
                "audioJack": "Yes",
                "gps": "Yes with A-GPS",
                "battery": "Li-Ion 5124 mAh battery (19.1 Wh)"
            },
            "release": {
                "announceDate": "2015 September",
                "priceEur": 360
            }
        },
        {
            "id": 26310,
            "brand": "Apple",
            "phone": "Apple iPad Air 2",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-air-2-new.jpg",
            "sim": "Nano-SIM eSIM",
            "resolution": "1536 x 2048 pixels",
            "hardware": {
                "audioJack": "Yes",
                "gps": "Yes with A-GPS",
                "battery": "Li-Po 7340 mAh battery (27.62 Wh)"
            },
            "release": {
                "announceDate": "2014 October",
                "priceEur": 440
            }
        },
        {
            "id": 25928,
            "brand": "Apple",
            "phone": "Apple iPad mini 3",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-mini-3-new.jpg",
            "sim": "Nano-SIM eSIM",
            "resolution": "1536 x 2048 pixels",
            "hardware": {
                "audioJack": "Yes",
                "gps": "Yes with A-GPS",
                "battery": "Li-Po 6470 mAh battery (24.3 Wh)"
            },
            "release": {
                "announceDate": "2014 October",
                "priceEur": 400
            }
        }
    ]
}```

3. Search  products by priceEur
http://localhost:8088/product-search/mobile/search?priceEur=200

**Response:**
```json{
    "message": null,
    "mobileHandSets": [
        {
            "id": 27999,
            "brand": "Apple",
            "phone": "Apple iPad mini Wi-Fi",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-mini-final.jpg",
            "sim": "No",
            "resolution": "768 x 1024 pixels",
            "hardware": {
                "audioJack": "Yes",
                "gps": "No",
                "battery": "Li-Po 4490 mAh battery (16.7 Wh)"
            },
            "release": {
                "announceDate": "2012 October",
                "priceEur": 200
            }
        },
        {
            "id": 29709,
            "brand": "Apple",
            "phone": "Apple iPad 2 Wi-Fi",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad2-new.jpg",
            "sim": "No",
            "resolution": "768 x 1024 pixels",
            "hardware": {
                "audioJack": "Yes",
                "gps": "No",
                "battery": "Li-Po 6930 mAh battery (25 Wh)"
            },
            "release": {
                "announceDate": "2011 March",
                "priceEur": 200
            }
        },
        {
            "id": 20551,
            "brand": "Apple",
            "phone": "Apple iPad 2 CDMA",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad2-new.jpg",
            "sim": "Mini-SIM",
            "resolution": "768 x 1024 pixels",
            "hardware": {
                "audioJack": "Yes",
                "gps": "Yes with A-GPS",
                "battery": "Li-Po 6930 mAh battery (25 Wh)"
            },
            "release": {
                "announceDate": "2011 March",
                "priceEur": 200
            }
        },
        {
            "id": 25494,
            "brand": "Apple",
            "phone": "Apple iPhone 4",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-4-ofic-final.jpg",
            "sim": "Micro-SIM",
            "resolution": "640 x 960 pixels ",
            "hardware": {
                "audioJack": "Yes",
                "gps": "Yes with A-GPS",
                "battery": "Li-Po 1420 mAh battery"
            },
            "release": {
                "announceDate": "2010 June",
                "priceEur": 200
            }
        },
        {
            "id": 27964,
            "brand": "Ericsson",
            "phone": "Ericsson R380",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/err380b.gif",
            "sim": "Mini-SIM",
            "resolution": "Big",
            "hardware": {
                "audioJack": "No",
                "gps": "No",
                "battery": "Removable NiMH battery"
            },
            "release": {
                "announceDate": "2000",
                "priceEur": 200
            }
        },
        {
            "id": 28354,
            "brand": "Ericsson",
            "phone": "Ericsson A1018s",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/er1018sb.gif",
            "sim": "Mini-SIM",
            "resolution": "3 x 12 chars",
            "hardware": {
                "audioJack": "No",
                "gps": "No",
                "battery": "Removable NiMH 800 mAh battery"
            },
            "release": {
                "announceDate": "1999",
                "priceEur": 200
            }
        },
        {
            "id": 26894,
            "brand": "Ericsson",
            "phone": "Ericsson I 888",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/eri888b.gif",
            "sim": "Mini-SIM",
            "resolution": "3 x 12 chars",
            "hardware": {
                "audioJack": "No",
                "gps": "No",
                "battery": "Removable NiMH 800 mAh battery"
            },
            "release": {
                "announceDate": "1999",
                "priceEur": 200
            }
        },
        {
            "id": 22615,
            "brand": "Ericsson",
            "phone": "Ericsson SH 888",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/ersh888b.gif",
            "sim": "Mini-SIM",
            "resolution": "3 x 12 chars",
            "hardware": {
                "audioJack": "No",
                "gps": "No",
                "battery": "Removable NiMH 800 mAh battery"
            },
            "release": {
                "announceDate": "1998",
                "priceEur": 200
            }
        },
        {
            "id": 23221,
            "brand": "Ericsson",
            "phone": "Ericsson GA 628",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/erga628b.gif",
            "sim": "Mini-SIM",
            "resolution": "1 x 12 chars",
            "hardware": {
                "audioJack": "No",
                "gps": "No",
                "battery": "Removable NiMH 1000 mAh battery"
            },
            "release": {
                "announceDate": "1996",
                "priceEur": 200
            }
        },
        {
            "id": 26466,
            "brand": "Ericsson",
            "phone": "Ericsson GF 388",
            "picture": "https://cdn2.gsmarena.com/vv/bigpic/ergf388b.gif",
            "sim": "Mini-SIM",
            "resolution": "3 x 12 chars",
            "hardware": {
                "audioJack": "No",
                "gps": "No",
                "battery": "Removable NiMH 915 mAh battery"
            },
            "release": {
                "announceDate": "1995",
                "priceEur": 200
            }
        }
    ]
}```
