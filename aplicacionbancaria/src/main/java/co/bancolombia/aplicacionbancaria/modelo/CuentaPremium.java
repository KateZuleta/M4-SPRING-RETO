package co.bancolombia.aplicacionbancaria.modelo;

import co.bancolombia.aplicacionbancaria.modelo.enums.TipoCompra;
import co.bancolombia.aplicacionbancaria.modelo.enums.TipoDeposito;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("premium")
public class CuentaPremium extends CuentaBanco {

    @Override
    public void Deposito(BigDecimal valorDeposito, TipoDeposito tipoDeposito) {
        switch (tipoDeposito) {
            case CAJERO_AUTOMATICO:
                this.setSaldo(getSaldo().add(valorDeposito));
                break;
            case SUCURSAL:
                this.setSaldo(getSaldo().add(valorDeposito));
                break;
            case OTRA_CUENTA:
                validarSaldoCuenta(new BigDecimal(1.5), valorDeposito);
                this.setSaldo(getSaldo().subtract(new BigDecimal(1.5)).add(valorDeposito));
                break;
            default:
                throw new IllegalArgumentException("Tipo de deposito no válido");
        }
    }

    @Override
    public void Retiro(BigDecimal valorRetiro) {
        validarSaldoCuenta(new BigDecimal(0), valorRetiro);
        this.setSaldo(getSaldo().subtract(valorRetiro));
    }

    @Override
    public void Compra(BigDecimal valorCompra, TipoCompra tipoCompra) {
        switch (tipoCompra) {
            case ESTABLECIMIENTO_FISICO:
                this.setSaldo(getSaldo().subtract(valorCompra));
                break;
            case PAGINA_WEB:
                validarSaldoCuenta(new BigDecimal(5), valorCompra);
                this.setSaldo(getSaldo().subtract(new BigDecimal(5)).subtract(valorCompra));
                break;
            default:
                throw new IllegalArgumentException("Tipo de compra no válida");
        }
    }
}
