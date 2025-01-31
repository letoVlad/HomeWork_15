# Задание  

Возьмите любое задание, в котором используется более одного класса, и интегрируйте его в Spring.  
Можно выбрать что-то из предыдущих упражнений. 

## Реализация  

Задание выполнено в проекте: [GitHub - letoVlad/HomeWork_14](https://github.com/letoVlad/HomeWork_14).  

Для интеграции со Spring были внесены следующие изменения:  

- Классы `DatabaseConnection` и `CalculatorImpl` аннотированы `@Component`.  
- Класс `ProxyConfig` аннотирован `@Configuration`.  
- В `Main` добавлен вызов `ApplicationContext` для получения бинов `Calculator` и `DatabaseConnection`.  
