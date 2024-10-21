package co.bancolombia.aplicacionbancaria.modelo;

import co.bancolombia.aplicacionbancaria.modelo.enums.TipoCompra;
import co.bancolombia.aplicacionbancaria.modelo.enums.TipoDeposito;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("basica")
public class CuentaBasica extends CuentaBanco {

    @Override
    public void Deposito(BigDecimal valorDeposito, TipoDeposito tipoDeposito) {
        switch (tipoDeposito) {
            case CAJERO_AUTOMATICO:
                validarSaldoCuenta(new BigDecimal(2), valorDeposito);
                this.setSaldo(this.getSaldo().subtract(new BigDecimal(2)).add(valorDeposito));
                break;
            case SUCURSAL:
                this.setSaldo(this.getSaldo().add(valorDeposito));
                break;
            case OTRA_CUENTA:
                validarSaldoCuenta(new BigDecimal(1.5), valorDeposito);
                this.setSaldo(this.getSaldo().subtract(new BigDecimal(1.5)).add(valorDeposito));
                break;
            default:
                throw new IllegalArgumentException("Tipo de deposito no válido");
        }
    }

    @Override
    public void Retiro(BigDecimal valorRetiro) {
        validarSaldoCuenta(new BigDecimal(1), valorRetiro);
        this.setSaldo(this.getSaldo().subtract(new BigDecimal(1)).subtract(valorRetiro));
    }

    @Override
    public void Compra(BigDecimal valorCompra, TipoCompra tipoCompra) {
        switch (tipoCompra) {
            case ESTABLECIMIENTO_FISICO:
                this.setSaldo(this.getSaldo().subtract(valorCompra));
                break;
            case PAGINA_WEB:
                validarSaldoCuenta(new BigDecimal(5), valorCompra);
                this.setSaldo(this.getSaldo().subtract(new BigDecimal(5)).subtract(valorCompra));
                break;
            default:
                throw new IllegalArgumentException("Tipo de compra no válida");
        }
    }
}
