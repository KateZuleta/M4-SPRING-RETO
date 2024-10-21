package co.bancolombia.aplicacionbancaria.modelo.DTO;

import co.bancolombia.aplicacionbancaria.modelo.enums.TipoDeposito;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class DepositoDTO extends TransaccionDTO{
    private TipoDeposito tipoDeposito;
}
