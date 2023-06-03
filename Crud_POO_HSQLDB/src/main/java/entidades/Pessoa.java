package entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue
    private long id;
    private String nome;

    @CreationTimestamp
    private Instant dataCriacao;

    @UpdateTimestamp
    private Instant dataAlteracao;

    @Version
    private int versao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Instant getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Instant dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }
}
