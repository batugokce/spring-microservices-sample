package controllers

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"net/http"
	"strconv"

	"batugokce.dev/paymentservice/db"
	"batugokce.dev/paymentservice/models"
)

type PaymentReponse struct {
	Success bool `json:"success"`
}

func GetAllPaymentDetails(c *gin.Context) {
	paymentDetailsList := db.GetAllPaymentDetails()

	c.JSON(http.StatusOK, paymentDetailsList)
}

func Pay(c *gin.Context) {
	var paymentDetails models.PaymentDetails

	if err := c.BindJSON(&paymentDetails); err != nil {
		fmt.Println(err)
		return
	}

	db.InsertPaymentDetails(paymentDetails)

	fmt.Printf("Customer-%d has completed payment of order-%d successfully.\n",
		paymentDetails.CustomerId, paymentDetails.OrderId)

	response := new(PaymentReponse)
	response.Success = true

	c.JSON(http.StatusOK, response)
}

func CancelPayment(c *gin.Context) {
	orderId, _ := strconv.Atoi(c.Param("orderId"))

	db.DeletePaymentDetails(orderId)

	fmt.Printf("Order-%d has been cancelled successfully.", orderId)

	response := new(PaymentReponse)
	response.Success = true

	c.JSON(http.StatusOK, response)
}
