
package br.edu.unicatolica.radio.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido_musical")
public class PedidoMusical {
	
	@Id
	@Column(name = "id_pedido")
	@GeneratedValue
	private int idPedido;

	@Column(name="nome_musica")
	private String nomeMusica;

	@Column(name="data_pedido")
	private Date dataPedido;

	@Column(name="oferecimento")
	private String oferecimento;

	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario  usuarioId;
	
	@ManyToMany(mappedBy="pedidoMusical")
	private List<Ouvinte> ouvinte;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getNomeMusica() {
		return nomeMusica;
	}

	public void setNomeMusica(String nomeMusica) {
		this.nomeMusica = nomeMusica;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getOferecimento() {
		return oferecimento;
	}

	public void setOferecimento(String oferecimento) {
		this.oferecimento = oferecimento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

	public List<Ouvinte> getOuvinte() {
		return ouvinte;
	}

	public void setOuvinte(List<Ouvinte> ouvinte) {
		this.ouvinte = ouvinte;
	}
}
