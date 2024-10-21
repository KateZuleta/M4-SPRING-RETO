package co.bancolombia.aplicacionbancaria.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transacciones")
@Data
@Builder
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cuenta_asociada")
    private CuentaBanco cuentaAsociada;

    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;

    @Column(name = "sub_tipo_transaccion")
    private String subTipoTransaccion;

    private BigDecimal valor;

    @Column(name = "fecha")
    private Timestamp timestamp;
}
