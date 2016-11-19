package br.edu.unicatolica.radio.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ouvinte")
public class Ouvinte {

	@Id
	@Column(name = "id_ouvinte")
	@GeneratedValue
	private int idOuvinte;

	@Column(name = "nome_ouvinte")
	private String nomeOuvinte;

	@Column(name = "telefone")
	private int telefone;

	@Column(name = "dt_nascimento")
	private Date dtNascimento;

	@Column(name = "rua")
	private String rua;

	@Column(name = "numero")
	private String numero;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "cidade")
	private String cidade;

	@ManyToMany
	@JoinTable(name = "pedido_musica_ouvinte", joinColumns = 
{ @JoinColumn(name = "id_ouvinte") }, inverseJoinColumns = {
			@JoinColumn(name = "id_pedido") })
	private List<PedidoMusical> pedidoMusical;

	public int getIdOuvinte() {
		return idOuvinte;
	}

	public void setIdOuvinte(int idOuvinte) {
		this.idOuvinte = idOuvinte;
	}

	public String getNomeOuvinte() {
		return nomeOuvinte;
	}

	public void setNomeOuvinte(String nomeOuvinte) {
		this.nomeOuvinte = nomeOuvinte;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<PedidoMusical> getPedidoMusical() {
		return pedidoMusical;
	}

	public void setPedidoMusical(List<PedidoMusical> pedidoMusical) {
		this.pedidoMusical = pedidoMusical;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idOuvinte;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ouvinte other = (Ouvinte) obj;
		if (idOuvinte != other.idOuvinte)
			return false;
		return true;
	}

	public String toString() {
		return "Ouvinte [idOuvinte=" + idOuvinte + ", nomeOuvinte=" + nomeOuvinte + ", telefone=" + telefone
				+ ", dtNascimento=" + dtNascimento + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro
				+ ", cidade=" + cidade + "]";
	}
}
