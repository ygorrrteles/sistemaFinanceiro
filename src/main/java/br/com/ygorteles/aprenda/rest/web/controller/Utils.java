package br.com.ygorteles.aprenda.rest.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

public class Utils {

    public static URI uri;

    public static void setarLocationPost(Object id, String path, HttpServletResponse response){
        uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path(path)
                .buildAndExpand(id).toUri();
//        response.setHeader("Location", uri.toASCIIString());
    }
}
