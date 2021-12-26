///B.R.R
package com.juniper.onlinesavdo;


import com.juniper.onlinesavdo.configuration.InitConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class OnlineSavdoApplication extends SpringBootServletInitializer {



    public static void main(String[] args) {
                SpringApplication.run(OnlineSavdoApplication.class, args);

    }

}
