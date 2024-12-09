package com.example.demo.modelo;

import java.math.BigDecimal;

public class PaymentRequest {

        private BigDecimal transactionAmount;
        private String token;
        private String description;
        private Integer installments;
        private String paymentMethodId;
        private Payer payer;
    
        // Getters y setters
        public BigDecimal getTransactionAmount() {
            return transactionAmount;
        }
    
        public void setTransactionAmount(BigDecimal transactionAmount) {
            this.transactionAmount = transactionAmount;
        }
    
        public String getToken() {
            return token;
        }
    
        public void setToken(String token) {
            this.token = token;
        }
    
        public String getDescription() {
            return description;
        }
    
        public void setDescription(String description) {
            this.description = description;
        }
    
        public Integer getInstallments() {
            return installments;
        }
    
        public void setInstallments(Integer installments) {
            this.installments = installments;
        }
    
        public String getPaymentMethodId() {
            return paymentMethodId;
        }
    
        public void setPaymentMethodId(String paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
        }
    
        public Payer getPayer() {
            return payer;
        }
    
        public void setPayer(Payer payer) {
            this.payer = payer;
        }
        //payer
        public static class Payer {
            private String email;
            private String firstName;
            private Identification identification;
    
            // Getters y setters
            public String getEmail() {
                return email;
            }
    
            public void setEmail(String email) {
                this.email = email;
            }
    
            public String getFirstName() {
                return firstName;
            }
    
            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }
    
            public Identification getIdentification() {
                return identification;
            }
    
            public void setIdentification(Identification identification) {
                this.identification = identification;
            }
    }
    
        //idetification
        public static class Identification{
            private String type;
            private String number;
    
            // Getters y setters
            public String getType() {
                return type;
            }
    
            public void setType(String type) {
                this.type = type;
            }
    
            public String getNumber() {
                return number;
            }
    
            public void setNumber(String number) {
                this.number = number;
            }
    }
}    