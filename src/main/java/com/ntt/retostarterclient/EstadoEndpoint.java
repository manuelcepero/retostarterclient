/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntt.retostarterclient;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manuel
 */
@Component
@Endpoint(id = "status")
@RestController
public class EstadoEndpoint {
    private Counter counter;
    List<String> estados = new ArrayList();
    
    public EstadoEndpoint(MeterRegistry registry){
        this.counter = Counter.builder("invocaciones.llamada").description("Cambios del estado").register(registry);
    }
    
    @ReadOperation
    public List<String> status(){
        return estados;
    }
    
    @WriteOperation()
    public void write(@Selector String anadirEstado){
        counter.increment();
        estados.add(anadirEstado);
    }
    
    @DeleteOperation
    public void delete(@Selector String eliminarEstado){
        estados.remove(eliminarEstado);
    }
}
