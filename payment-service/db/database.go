package db

import "batugokce.dev/paymentservice/models"

var PaymentDetailsList = []models.PaymentDetails{
	{CustomerId: 101, OrderId: 101, TotalPrice: 32.99},
}

func GetAllPaymentDetails() []models.PaymentDetails {
	return PaymentDetailsList
}

func InsertPaymentDetails(details models.PaymentDetails) []models.PaymentDetails {
	PaymentDetailsList = append(PaymentDetailsList, details)
	return PaymentDetailsList
}

func DeletePaymentDetails(orderId int) []models.PaymentDetails {
	var NewList []models.PaymentDetails
	for _, details := range PaymentDetailsList {
		if details.OrderId != orderId {
			NewList = append(NewList, details)
		}
	}
	PaymentDetailsList = NewList
	return PaymentDetailsList
}
