package br.com.gabrielluizsf.helloworld;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloworldApplication {

	List<Contato> contatos = new ArrayList<Contato>();

	@RequestMapping("/hello")
	public String helloWorld(){
		return "Hello World";
	}

	@RequestMapping("/exRevisao")
	public String respostasDoExercicioDeRevisao(){
		return "Repostas do exercicio de Revisão:\n1 = a, 2 = e, 3 = b, 4 = e, 5 = b, 6 = c, 7 = a, 8 = a, \n9 = b, 10 = c, 11 = c, 12 = b";
	}

	@PostMapping("/contatos")
	public String criarContato(@RequestBody Contato body){
		contatos.add(body);
		return body.getNome() + "\n\nSalvo com sucesso";
	}

	@GetMapping("/contatos")
	public List<Contato> allContatos(){
		return contatos;
	}

	@PutMapping("/contatos")
	public String atualizaContato(@RequestBody Contato body){
		String nome  = body.getNome();
		String email = body.getEmail();
		for (int i = 0; i < contatos.size(); i++) {
			if (contatos.get(i).getId() == body.getId()) {
				contatos.get(i).setNome(nome);
				contatos.get(i).setEmail(email);
				break;
			}
			
		}
		return nome + "\n\nAtualizado com Sucesso";
	}

	@DeleteMapping("/contatos")
	public String deletaContato(@RequestBody Contato body){
		int id = body.getId();
		for (int i = 0; i < contatos.size(); i++){
			if(contatos.get(i).getId() == id){
			contatos.remove(i);
			break;
			}
		}
		return "Deletado com sucesso";
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

}
