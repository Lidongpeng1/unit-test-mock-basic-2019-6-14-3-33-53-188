package cashregister;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class CashRegisterTest {
    private  final ByteArrayOutputStream outContent =new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams(){
        System.setOut(originalOut);
    }


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        Purchase purchase = new Purchase(new Item[]{
                new Item("A",1),
                new Item("B",2),
                new Item("C",3),
        });
        Printer printer = new Printer();
        CashRegister cashRegister = new CashRegister(printer);
        //when
        cashRegister.process((purchase));
        //then
        assertThat(outContent.toString()).isEqualTo("A\t1.0\nB\t2.0\nC\t3.0\n");
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        //when
        //then
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        //when
        //then
    }

}
