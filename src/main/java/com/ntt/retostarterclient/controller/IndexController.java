package com.ntt.retostarterclient.controller;


import com.nttdata.retostarter.estado.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Manuel
 */
@RestController
public class IndexController {

    @Autowired
    private Estado estado;

    @GetMapping("/writer")
    public ResponseEntity<String> setEstado(String estadoEnviar) {
        return new ResponseEntity<String>(HttpStatus.OK).ok(estado.getEstado());
    }
}
