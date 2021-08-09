package overwatchutility;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/* @SpringBootApplicationは以下のアノテーションを一括して有効にする
 *  @EnableAutoConfiguration
 *  @ComponentScan
 *  @SpringBootConfiguration
 * */

@SpringBootApplication
public class OverwatchUtilityApplication {

    public static void main(String[] args) {
        SpringApplication.run(OverwatchUtilityApplication.class, args);
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

}
