package com.application.rest.dto;

import com.application.rest.model.TipoDocumento;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FindUserRequestDTO {

    @NotNull(message = "El tipo de documento es obligatorio")
    @Pattern(regexp = "^[CP]$", message = "El tipo de documento debe ser 'C' o 'P'")
    private String tipoDocumento;

    @NotNull(message = "El número de documento es obligatorio")
    private String numeroDocumento;
}
