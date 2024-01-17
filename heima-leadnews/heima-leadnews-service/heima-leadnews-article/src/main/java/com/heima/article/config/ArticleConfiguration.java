package com.heima.article.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Data
@ConfigurationProperties(prefix = "server")
public class ArticleConfiguration {
    private String port;
}
