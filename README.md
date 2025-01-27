# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.0/maven-plugin)
- [Create an OCI image](https://docs.spring.io/spring-boot/3.4.0/maven-plugin/build-image.html)
- [Spring Batch](https://docs.spring.io/spring-boot/3.4.0/how-to/batch.html)

### Guides

The following guides illustrate how to use some features concretely:

- [Creating a Batch Service](https://spring.io/guides/gs/batch-processing/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

### Proposta de arquitetura

[Documento de arquitetura](https://whimsical.com/documento-de-arquitetura-8LxNXEgaTeKpriDEbzFLt9)

#### Link do console do h2

[H2)[http://localhost:8080/h2-console]

#### Chamada de exemplo usando o curl

Estando dentro da pasta que contém o arquivo, basta fazer a seguinte chamada

```
curl -X POST -F "file=@CNAB.txt" http://localhost:8080/cnab/upload
```

Relatório de transações

```
curl http://localhost:8080/transacoes | json_pp
```
