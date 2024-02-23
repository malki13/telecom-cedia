package com.telecom.administracionservice.interventor.controller;

import com.telecom.administracionservice.interventor.data.dto.InterventorDTO;
import com.telecom.administracionservice.interventor.data.info.InterventorInfo;
import com.telecom.administracionservice.interventor.service.InterventorService;
import com.telecom.administracionservice.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interventor")
public class InterventorController {
    @Autowired
    private InterventorService interventorService;
    @GetMapping("/saludo/{id}")
    public ResponseEntity<String> getById(@PathVariable("id") int id) {
        return ResponseEntity.ok("Hola"+String.valueOf(id));
    }
    @GetMapping("/")
    public ResponseEntity<Page<InterventorInfo>> findAll(
            @PageableDefault(size = 10, page = 0) Pageable pageable
    ) {
        return new ResponseEntity<>(interventorService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{interventorId}")
    public ResponseEntity<Response> getOne(
            @PathVariable("interventorId") Integer interventorId
    ) {
        return new ResponseEntity<>(new Response(HttpStatus.OK.toString(), "Interventor encontrado", interventorService.getOne(interventorId).get()), HttpStatus.OK);
    }

    @PostMapping(value = "/{interventorTipoId}")
    public ResponseEntity<Response> save(
            @PathVariable("interventorTipoId") Integer interventorTipoId,
            @RequestBody InterventorDTO interventorDTO
    ) throws Exception {
        return new ResponseEntity<>(new Response(HttpStatus.CREATED.toString(), "Interventor creado", interventorService.save(interventorTipoId, interventorDTO)), HttpStatus.OK);
    }

    @DeleteMapping("/{interventorId}")
    public ResponseEntity<Response> delete(
            @PathVariable("interventorId") Integer interventorId
    ) {
        return new ResponseEntity<>(new Response(HttpStatus.OK.toString(), "Interventor eliminado", interventorService.delete(interventorId)), HttpStatus.OK);
    }

}
