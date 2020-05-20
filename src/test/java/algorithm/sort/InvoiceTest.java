package algorithm.sort;

import org.junit.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class InvoiceTest {
    @Test
    public void test(){
        Invoice invoice = new Invoice();
        List<String> input = new ArrayList<>();
        invoice.processInvoice1(input);
        assertEquals(1,1);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(InvoiceTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }

}