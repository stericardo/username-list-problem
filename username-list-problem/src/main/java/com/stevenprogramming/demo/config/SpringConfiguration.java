package com.stevenprogramming.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author steven.mendez
 * @since 12/07/2016
 * @version 1.0
 */
@Configuration
@ComponentScan(basePackages = {
    "com.stevenprogramming.demo.application",
    "com.stevenprogramming.demo.services",
    "com.stevenprogramming.demo.model",
    "com.stevenprogramming.demo.dao"})
public class SpringConfiguration {

}
