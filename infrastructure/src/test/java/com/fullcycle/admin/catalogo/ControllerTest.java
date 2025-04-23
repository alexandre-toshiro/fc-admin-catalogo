package com.fullcycle.admin.catalogo;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // Pode ser usada em classes
@Retention(RetentionPolicy.RUNTIME) // Disponível em tempo de execução
@Inherited // Herda para subclasses
@ActiveProfiles("test") // Define para usar o profile "test"
@WebMvcTest // Anotação padrão para testes de controllers Spring MVC
public @interface ControllerTest {

    @AliasFor(annotation = WebMvcTest.class, attribute = "controllers")
    Class<?>[] controllers() default {};
}
// Esta anotação personalizada (@ControllerTest) facilita a configuração de testes de controllers no Spring.
// Ela já inclui @WebMvcTest e define automaticamente o profile "test", evitando repetição de código nas classes de teste.
// O atributo 'controllers' permite especificar os controllers a serem testados, repassando esse valor para o @WebMvcTest através do @AliasFor.