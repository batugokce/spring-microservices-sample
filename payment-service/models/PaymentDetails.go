package models

type PaymentDetails struct {
	CustomerId int     `json:"customerId"`
	OrderId    int     `json:"orderId"`
	TotalPrice float32 `json:"totalPrice"`
}
