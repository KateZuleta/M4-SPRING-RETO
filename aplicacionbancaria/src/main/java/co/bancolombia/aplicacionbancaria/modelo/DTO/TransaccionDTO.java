package co.bancolombia.aplicacionbancaria.modelo.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TransaccionDTO {
    @NotEmpty(message = "La cuenta no puede estar vacia")
    @Pattern(regexp="^\\d+$", message = "La cuenta debe ser un valor numerico")
    private String idCuenta;

    @NotNull(message = "Debe ingresar el monto de la transacción")
    @Positive(message = "El monto debe ser mayor a cero")
    private BigDecimal monto;
    private String descripcionTransaccion;

}
