package org.thefarm.tweb.jpa;

import javax.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String entrada;
    private String principal;
    private String bebida;
    private String sobremesa;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Orders(User user, String entrada, String principal, String bebida, String sobremesa) {
        this.user = user;
        this.entrada = entrada;
        this.principal = principal;
        this.bebida = bebida;
        this.sobremesa = sobremesa;


    }
    public String toString() {
        return String.format(
                "Orders[id=%d, entrada='%s', principla='%s', bebida='%s', sobremesa='%s']",
                id, entrada, principal, bebida, sobremesa);
    }

    public Orders() {}

    public Long getId() {
        return id;
    }
    public Long getClient_id() {
        return user.getId();
    }

    public String getEntrada() {
        return entrada;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getBebida() {
        return bebida;
    }

    public String getSobremesa() {
        return sobremesa;
    }

}
