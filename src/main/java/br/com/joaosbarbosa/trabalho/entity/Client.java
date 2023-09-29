package br.com.joaosbarbosa.trabalho.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_cliente")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_cliente_id")
    private Long id;
    @Column(name = "cli_nome")
    private String name;
    @Column(name = "cli_cpf")
    private String cpf;
    @Column(name = "cli_renda")
    private Double inCome;
    @Column(name = "cli_aniversario")
    private Instant birthDate;
    @Column(name = "cli_qtd_filhos")
    private Integer children;


    public Client(){}

    public Client(Long id, String name, String cpf, Double inCome, Instant birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.inCome = inCome;
        this.birthDate = birthDate;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getInCome() {
        return inCome;
    }

    public void setInCome(Double inCome) {
        this.inCome = inCome;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
