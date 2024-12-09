package com.example.demo.controller;

import com.example.demo.service.PaymentService;
import com.example.demo.modelo.PaymentRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> processPayment(@RequestBody PaymentRequest paymentRequest) {
        try {
            // Llamamos al servicio para procesar el pago
            Payment payment = paymentService.processPayment(paymentRequest);

            // Si el pago es exitoso, devolvemos la respuesta
            return ResponseEntity.ok(payment);
        } catch (MPApiException | MPException e) {
            // Si hay un error al procesar el pago, devolvemos el error
            return ResponseEntity.status(500).body("Error procesando el pago: " + e.getMessage());
        } catch (RuntimeException e) {
            // Para otros errores no controlados, se devuelve una respuesta genérica
            return ResponseEntity.status(500).body("Error inesperado: " + e.getMessage());
        }
    }
}