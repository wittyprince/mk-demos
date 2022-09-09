package com.mk.demos.spring.cloud.config.client;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * GitAutoRefreshConfig
 *
 * @author WangChen
 * Created on 2022/9/9
 * @since 1.0
 */
@Component
@Data
@ConfigurationProperties(prefix = "data")
public class GitAutoRefreshConfig {

    private String env;

    private UserInfo user;

    public static class UserInfo {
        private String username;

        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

}
