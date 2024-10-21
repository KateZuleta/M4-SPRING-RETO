package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.modelo.DTO.ConsultaSaldoDTO;
import co.bancolombia.aplicacionbancaria.modelo.DTO.TransaccionDTO;
import co.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cuenta")
public class CuentaController {
    private final CuentaService cuentaService;

    @GetMapping("/saldo")
    public String consultarSaldo(@Valid @RequestBody ConsultaSaldoDTO consultaSaldoDTO) {
        return cuentaService.consultarSaldo(consultaSaldoDTO);
    }
}
