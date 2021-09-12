//package h2c.example.config;
//
//import org.apache.catalina.connector.Connector;
//import org.apache.coyote.http2.Http2Protocol;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class Http2cServletContainer {
//
//    @Bean
//    public ServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//        tomcat.addAdditionalTomcatConnectors(createH2cConnector());
//        tomcat.addConnectorCustomizers();
//        return tomcat;
//    }
//
//   private Connector createH2cConnector() {
//        Connector connector = new Connector();
//        Http2Protocol upgradeProtocol = new Http2Protocol();
//        connector.addUpgradeProtocol(upgradeProtocol);
//        connector.setPort(8089);
//        return connector;
//    }
//}
