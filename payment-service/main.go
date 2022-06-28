package main

import (
	"batugokce.dev/paymentservice/controllers"
	"github.com/gin-gonic/gin"
)

func setupRouter() *gin.Engine {
	router := gin.Default()

	group := router.Group("/api/v1/payment")

	group.GET("/getAll", controllers.GetAllPaymentDetails)
	group.POST("/pay", controllers.Pay)
	group.DELETE("/cancelPayment/:orderId", controllers.CancelPayment)

	return router
}

func main() {
	router := setupRouter()
	router.Run(":8083")
}
