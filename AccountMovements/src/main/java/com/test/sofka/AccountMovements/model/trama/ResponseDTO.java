package com.test.sofka.AccountMovements.model.trama;

import lombok.*;
import org.slf4j.MDC;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase contiene los atributos que componen una consulta y respuesta genérica al consumir un endpoint
 * 
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseDTO implements Serializable {
    private String codRespuesta;
    private String msgTecnico="TRANSACCION REALIZADA CORRECTAMENTE";
    private String msgUsuario="TRANSACCION REALIZADA CORRECTAMENTE";
    private String guid = MDC.get("uuid");
    private String username = MDC.get("username");
    private Map<String, Object> detail= new HashMap<>();
}


