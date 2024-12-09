package com.example.demo.service;
import com.example.demo.modelo.Envio;
import com.example.demo.repository.EnvioR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SEnvio {
    
    @Autowired
    private EnvioR envioR;

    public Envio guardarEnvio(Envio envio){
      if (envio.getMail()==null|| !envio.getMail().contains("@")) {
        throw new IllegalStateException("La dirección de correo ingresada es inválida");
      }  
      return envioR.save(envio);
    }
    public Envio obtenerEnvioPorId(Long id) {
      return envioR.findById(id).orElseThrow(() -> new IllegalStateException("Envío no encontrado"));
  }
}
