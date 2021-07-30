package com.BlogPessoalGen.BlogPessoal.model;


import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;





@Entity
@Table(name = "tb_usuario")

public class UsuarioModel {

	/**
	 * Definindo os pares e valores da entidade Usuario
	 * 
	 * @author Guilherme Rodrigues
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome tem que conter caracteres")
	private String nome;

	@NotNull(message = "O email não pode ser nulo")
	@NotBlank(message = "O email tem que conter caracteres")
	@Email(message = "O email precisa ter o @ pra dizer que é um email")
	private String email;

	@NotNull(message = "A senha não pode ser nula")
	@NotBlank(message = "A senha precisa conter caracteres")
	private String senha;
	
	
	private String foto;
	
	private String tipo;

	@OneToMany(mappedBy = "usuario")
	private List<PostagemModel> postagens;

	public UsuarioModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioModel(
			@NotNull(message = "O nome não pode ser nulo") @NotBlank(message = "O nome tem que conter caracteres") String nome,
			@NotNull(message = "O email não pode ser nulo") @NotBlank(message = "O email tem que conter caracteres") @Email(message = "O email precisa ter o @ pra dizer que é um email") String email,
			@NotNull(message = "A senha não pode ser nula") @NotBlank(message = "A senha precisa conter caracteres") String senha,
	String foto,
	String tipo)
	{
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
		this.tipo = tipo;
	}


	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	

	

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
