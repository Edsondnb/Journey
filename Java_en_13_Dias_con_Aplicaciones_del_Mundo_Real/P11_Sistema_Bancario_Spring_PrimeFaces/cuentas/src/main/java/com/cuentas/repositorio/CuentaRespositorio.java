package com.cuentas.repositorio;

import com.cuentas.modelo.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRespositorio extends JpaRepository<Cuenta, Integer> {
}
