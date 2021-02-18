package com.vallegrande.vgteams.helper.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class PayloadDTO implements Serializable {

    private List<String> authorities;
    private UsuarioDTO usuario;
    private String jti;
    private Integer iat;
    private Integer exp;

}
