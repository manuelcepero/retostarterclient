package com.ntt.retostarterclient;

import com.ntt.retostarterclient.service.Servicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetostarterclientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RetostarterclientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Servicio service = new Servicio();

        String open = "open";
        String halfOpen = "half-open";
        String close = "close";

        Estado estado = new Estado("Hola");

        for (int i = 0; i < 5; i++) {
            if (estado.getEstado().equals(open)) {
                estado.setEstado(open);
                service.setToHalfOpen();
                Thread.sleep(5000);

                if (i >= 3) {
                    estado.setEstado(close);
                    service.setToClose();
                    Thread.sleep(5000);
                } else {
                    estado.setEstado(halfOpen);
                    service.setToHalfOpen();
                    Thread.sleep(5000);
                }
            }
        }
    }

}
