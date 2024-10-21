package co.bancolombia.aplicacionbancaria.modelo;

import co.bancolombia.aplicacionbancaria.modelo.enums.TipoCompra;
import co.bancolombia.aplicacionbancaria.modelo.enums.TipoDeposito;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cuentas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_cuenta", discriminatorType = DiscriminatorType.STRING)
public abstract class CuentaBanco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nro_cuenta")
    private String nroCuenta;
    private String titular;
    private BigDecimal saldo;
    @OneToMany(mappedBy = "cuentaAsociada")
    private List<Transaccion> transacciones;

    abstract public void Deposito(BigDecimal valorDeposito, TipoDeposito tipoDeposito);
    abstract public void Retiro(BigDecimal valorRetiro);
    abstract public void Compra(BigDecimal valorCompra, TipoCompra tipoCompra);

    protected void validarSaldoCuenta(BigDecimal costo, BigDecimal valorCompra) {
        BigDecimal montoTotal = valorCompra.add(costo);
        if(this.getSaldo().compareTo(montoTotal) != 1) {
            throw new IllegalArgumentException("El saldo es insuficiente para realizar la operacion");
        }
    }

}
