package com.example.demo.service;

import org.springframework.stereotype.Service; // Para marcar la clase como un servicio de Spring
import com.example.demo.modelo.PaymentRequest;
// SDK de Mercado Pago
import com.mercadopago.MercadoPagoConfig; // Configuración de Mercado Pago
import com.mercadopago.client.payment.PaymentClient; // Cliente para manejar pagos
import com.mercadopago.client.payment.PaymentCreateRequest; // Solicitud de creación de pago
import com.mercadopago.client.payment.PaymentPayerRequest; // Datos del pagador
import com.mercadopago.client.common.IdentificationRequest; // Datos de identificación del pagador
import com.mercadopago.resources.payment.Payment; // Clase para la respuesta del pago

// Excepciones (si necesitas capturar errores específicos)
import com.mercadopago.exceptions.MPException;
import com.mercadopago.exceptions.MPApiException;

@Service
public class PaymentService {
    public Payment processPayment(PaymentRequest request) throws MPException, MPApiException {
        // Configura tu token de acceso de Mercado Pago
        MercadoPagoConfig.setAccessToken("");

    
    PaymentClient client = new PaymentClient();

    PaymentCreateRequest paymentCreateRequest = PaymentCreateRequest.builder()
           .transactionAmount(request.getTransactionAmount())
           .token(request.getToken())
           .description(request.getDescription())
           .installments(request.getInstallments())
           .paymentMethodId(request.getPaymentMethodId())
           .payer(
               PaymentPayerRequest.builder()
                   .email(request.getPayer().getEmail())
                   .firstName(request.getPayer().getFirstName())
                   .identification(
                       IdentificationRequest.builder()
                           .type(request.getPayer().getIdentification().getType())
                           .number(request.getPayer().getIdentification().getNumber())
                           .build())
                   .build())
           .build();
           Payment payment = client.create(paymentCreateRequest);
           if (payment == null) {
            throw new RuntimeException("El servicio de Mercado Pago devolvió una respuesta nula.");
        }
        return payment;
        }
    }
