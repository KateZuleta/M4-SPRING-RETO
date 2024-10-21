package co.bancolombia.aplicacionbancaria.modelo.DTO;

import co.bancolombia.aplicacionbancaria.modelo.enums.TipoCompra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CompraDTO extends TransaccionDTO{
    private TipoCompra tipoCompra;
}
