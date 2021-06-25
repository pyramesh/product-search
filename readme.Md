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
Architecture diagram: product-search/product search-architecture.png
Sequence diagram : product-search/product search-sequence.png

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
        'mvn clean install'
    2. Result of the above command,can observe the below on the console
        a. test cases:
            '[INFO] Tests run: 31, Failures: 0, Errors: 0, Skipped: 0'

        b. jar file will be generated in the below path
            '\product-search\target\product-search-0.0.1-SNAPSHOT.jar'
    3. Execute the below command to start the application in the path (product-search/target)
            'java -jar product-search-0.0.1-SNAPSHOT.jar'

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

