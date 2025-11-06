package com.ecom.payment.gateway;

import com.ecom.payment.gateway.dto.PaymentRequest;
import com.ecom.payment.gateway.dto.PaymentResponse;
import com.ecom.payment.gateway.dto.RefundRequest;
import com.ecom.payment.gateway.dto.RefundResponse;
import com.ecom.payment.gateway.dto.PaymentMethodTokenizeRequest;
import com.ecom.payment.gateway.dto.PaymentMethodTokenizeResponse;

/**
 * Payment Gateway Interface (Strategy Pattern)
 * 
 * <p>Abstract interface for payment gateway integration. Allows switching
 * between different payment gateways (Razorpay, PayU, Cashfree, etc.)
 * without changing the service layer code.
 */
public interface PaymentGateway {
    
    /**
     * Process a payment
     * 
     * @param request Payment request with amount, currency, payment method details
     * @return Payment response with transaction ID and status
     */
    PaymentResponse processPayment(PaymentRequest request);
    
    /**
     * Process a refund
     * 
     * @param request Refund request with payment ID and amount
     * @return Refund response with refund ID and status
     */
    RefundResponse processRefund(RefundRequest request);
    
    /**
     * Tokenize a payment method (for saving cards)
     * 
     * @param request Payment method details (card, UPI, etc.)
     * @return Tokenized payment method reference
     */
    PaymentMethodTokenizeResponse tokenizePaymentMethod(PaymentMethodTokenizeRequest request);
    
    /**
     * Get payment status from gateway
     * 
     * @param gatewayTransactionId Gateway's transaction ID
     * @return Payment response with current status
     */
    PaymentResponse getPaymentStatus(String gatewayTransactionId);
    
    /**
     * Verify webhook signature
     * 
     * @param payload Webhook payload
     * @param signature Webhook signature
     * @return true if signature is valid
     */
    boolean verifyWebhookSignature(String payload, String signature);
    
    /**
     * Get gateway provider name
     * 
     * @return Provider name (e.g., "RAZORPAY")
     */
    String getProviderName();
}

