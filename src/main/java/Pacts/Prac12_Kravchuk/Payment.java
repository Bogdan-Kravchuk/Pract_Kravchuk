package Pacts.Prac12_Kravchuk;

public record Payment(String id, String email, PaymentStatus status, double amountCents) { }