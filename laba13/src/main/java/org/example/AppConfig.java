package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    // Этот класс представляет конфигурацию Spring.
    // Он аннотирован @Configuration, что указывает на то, что этот класс содержит конфигурации бинов.
    // Используется также аннотация @ComponentScan, чтобы Spring сканировал пакет "org.example" на предмет классов, аннотированных @Component, @Service, @Repository и других.
    // Класс может оставаться пустым, если в нем нет дополнительной конфигурации бинов или если вся конфигурация находится в других классах.
}