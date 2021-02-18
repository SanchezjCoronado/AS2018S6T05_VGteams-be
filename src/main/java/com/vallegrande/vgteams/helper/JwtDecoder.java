package com.vallegrande.vgteams.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vallegrande.vgteams.helper.dto.PayloadDTO;
import org.apache.commons.codec.binary.Base64;

public class JwtDecoder {

    public String decoded(String token) throws JsonProcessingException {
        String[] split_string = token.split("\\.");
        String base64EncodedBody = split_string[1];
        Base64 base64Url = new Base64(true);
        String payload = new String(base64Url.decode(base64EncodedBody));

        ObjectMapper objectMapper = new ObjectMapper();
        PayloadDTO payloadDTO = objectMapper.readValue(payload, PayloadDTO.class);
        return payloadDTO.getUsuario().get_id();
    }
}
