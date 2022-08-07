# Spring Microservices Sample

![Microservices diagram](https://i.hizliresim.com/gmps7mq.jpg)

### Used Technologies
- Spring Boot
- Maven
- Kafka
- Docker
- MapStruct
- SpringDoc
- GoLang
- Gin Framework

### Requirements
- JDK17
- Go 1.18.3
- Docker
- Postgres
- Kubernetes - v1.24.0
- Helm - v3.9.2

### Preparation and Deploy

Kafka broker and zookeeper can be deployed in the cluster using Helm package manager. The following commands can be used to deploy Kafka.

    helm repo add bitnami https://charts.bitnami.com/bitnami
    helm install kafka-service bitnami/kafka

Before applying manifests, images of the services need to be built using Docker.

    # first generate jar using maven in the folder of the corresponding service
    mvn clean package

    # after creating the jar file, use docker to build the image
    # run these commands in the corresponding folder
    docker build -t batugokce/order-service:0.0.1 .
    docker build -t batugokce/customer-service:0.0.1 .

After all preparation is done, manifests can be deployed into the cluster using these commands

    kubectl apply -f k8s-manifests/customer-service.yaml
    kubectl apply -f k8s-manifests/order-service.yaml

### Install Istio service mesh using Helm

I have used Istio for the service mesh tool in the cluster. It can be installed using Helm with explanation in this [page](https://istio.io/latest/docs/setup/install/helm/). Or, below commands can be used.

    # configure and update helm repository
    helm repo add istio https://istio-release.storage.googleapis.com/charts
    helm repo update

    # install required charts of istio
    helm install istio-base istio/base -n istio-system
    helm install istiod istio/istiod -n istio-system --wait

    # verify installation
    helm status istiod -n istio-system

#### Deploy gateway for routing requests

After installing Istio into the cluster, we will install Istio ingress gateway and VirtualService objects to configure routes for requests entering through the gateway using [this manifest](k8s-manifests/istio-gateway.yaml).

    # create & configure a namespace and install ingress in that namespace
    kubectl create namespace istio-ingress
    kubectl label namespace istio-ingress istio-injection=enabled
    helm install istio-ingress istio/gateway -n istio-ingress --wait
    
    # apply manifest to configure routes
    kubectl apply -f k8s-manifests/istio-gateway.yaml

VirtualService object includes route configurations. For example, it routes any request with */api/v1/customer* prefix in the uri to customer-service.