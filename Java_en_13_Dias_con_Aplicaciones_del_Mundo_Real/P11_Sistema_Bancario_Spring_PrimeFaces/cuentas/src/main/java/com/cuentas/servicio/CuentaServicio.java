package com.cuentas.servicio;

import com.cuentas.modelo.Cuenta;
import com.cuentas.repositorio.CuentaRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServicio implements ICuentaServicio{

    @Autowired
    private CuentaRespositorio cuentaRespositorio;

    @Override
    public List<Cuenta> listarCuentas() {
        return cuentaRespositorio.findAll();
    }

    @Override
    public Cuenta buscarCuentaPorId(Integer idCuenta) {
        Cuenta cuenta = cuentaRespositorio.findById(idCuenta).orElse(null);
        return cuenta;
    }

    @Override
    public void guardarCuenta(Cuenta cuenta) {
        cuentaRespositorio.save(cuenta);
    }

    @Override
    public void eliminarCuenta(Cuenta cuenta) {
        cuentaRespositorio.delete(cuenta);
    }
}
