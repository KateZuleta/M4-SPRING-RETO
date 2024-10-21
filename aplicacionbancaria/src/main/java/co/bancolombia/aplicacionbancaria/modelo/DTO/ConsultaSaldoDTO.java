package co.bancolombia.aplicacionbancaria.modelo.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ConsultaSaldoDTO {

    @NotEmpty(message = "La cuenta no puede estar vacia")
    @Pattern(regexp="^\\d+$", message = "La cuenta debe ser un valor numerico")
    private String idCuenta;
}
