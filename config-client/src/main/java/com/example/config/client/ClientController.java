package com.example.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AFA on 25.02.2017.
 */
@RestController
@RequestMapping(path = "/")
public class ClientController {

    @Value("${mypassword}")
    private String mypassword;

    @Value("${foo}")
    private String foo;

    @GetMapping
    public ResponseEntity<ConfigValues> getConfig() {
        ConfigValues configValues = new ConfigValues();
        configValues.setMypassword(mypassword);
        configValues.setFoo(foo);
        return ResponseEntity.ok(configValues);
    }

    public static class ConfigValues {
        private String mypassword;
        private String foo;

        public void setMypassword(String mypassword) {
            this.mypassword = mypassword;
        }

        public void setFoo(String foo) {
            this.foo = foo;
        }

        public String getMypassword() {
            return mypassword;
        }

        public String getFoo() {
            return foo;
        }
    }


}
