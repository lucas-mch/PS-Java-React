package br.com.banco.services;

import org.hibernate.ObjectNotFoundException;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransferenciaServiceTest {

    @Autowired
    private TransferenciaService transferenciaService;
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @BeforeEach
    void setUp() {
    }
    @Test
    @DisplayName("Deve lançar exception quando informar uma conta não existente.")
    public void deveLancarExceptionQuandoInformarIdInexistente() {

        exceptionRule.expect(ObjectNotFoundException.class);

        Assertions.assertThrows(ObjectNotFoundException.class, () -> transferenciaService.findPage(0,
                24,
                "id",
                "asc",
                "0",
                "",
                "","")
        );

    }

}
