package br.com.qwasolucoes.mentoria.implementacoes.relacionamento;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.relacionamento.Relacionamentos;
import br.com.qwasolucoes.mentoria.modelagem_dados.contato.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.contato.CriaContato;
import br.com.qwasolucoes.mentoria.modelagem_dados.pessoa.CriaPessoa;
import br.com.qwasolucoes.mentoria.modelagem_dados.pessoa.Pessoa;
import br.com.qwasolucoes.mentoria.modelagem_dados.pessoa.PessoaContato;
import br.com.qwasolucoes.mentoria.modelagem_dados.pessoa.PessoaEndereco;
import br.com.qwasolucoes.mentoria.modelagem_dados.pessoa.PessoaFormacao;
import br.com.qwasolucoes.mentoria.modelagem_dados.pessoa.PessoaProfissao;

public class RelacionamentoBusca implements Relacionamentos {

	@Override
	public void iniciar() {

	}

	@Override
	public List<String> buscarCPFsDasPessoasMaioresIdade() {
		List<String> pessoasMaiores = new ArrayList<>();
		try {
			List<Pessoa> pessoas = new CriaPessoa().criaObjetos();
			for (Pessoa maioresDeIdade : pessoas) {

				if (LocalDate.now().getYear() - maioresDeIdade.getDataNascimento().getYear() >= 18)
					pessoasMaiores.add(maioresDeIdade.getCpf());
			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}

		return pessoasMaiores;
	}

	@Override
	public List<String> buscarNomeSobrenomeDasPessoasPorAnorNascimento(Integer ano) {
		List<String> pessoasPesquisadasPorAno = new ArrayList<>();
		try {
			List<Pessoa> pessoas = new CriaPessoa().criaObjetos();
			for (Pessoa nomeDasPessoasPesquisadas : pessoas) {
				Integer anoNascimento = nomeDasPessoasPesquisadas.getDataNascimento().getYear();

				if (anoNascimento.equals(ano))
					pessoasPesquisadasPorAno.add(nomeDasPessoasPesquisadas.getSobreNome());
			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}

		return pessoasPesquisadasPorAno;
	}

	@Override
	public List<String> buscarNomeSobrenomeDasPessoasPorEstadoCivil(String estadoCivil) {
		List<String> pessoasPesquisadasPorEstadoCivil = new ArrayList<>();
		try {
			List<Pessoa> pessoas = new CriaPessoa().criaObjetos();
			for (Pessoa nomeDasPessoasEstadoCivil : pessoas) {
				String estadoCivile = nomeDasPessoasEstadoCivil.getEstadoCivil();

				if (estadoCivile.equals(estadoCivile))
					pessoasPesquisadasPorEstadoCivil
							.add(nomeDasPessoasEstadoCivil.getSobreNome() + nomeDasPessoasEstadoCivil.getSobreNome());
			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}

		return pessoasPesquisadasPorEstadoCivil;
	}

	@Override
	public List<Pessoa> buscarPessoasPorTipoResidencia(String tipoResidencia) {
		List<Pessoa> pessoaPorTipoEndereco = new ArrayList<>();
		try {
			List<PessoaEndereco> pessoaPorEndereco = new PessoaEndereco().pessoaEndereco();
			for (PessoaEndereco pessoaEndereco : pessoaPorEndereco) {
				if (pessoaEndereco.getEndereco().getTipo().getTipo().equalsIgnoreCase(tipoResidencia)) {
					pessoaPorTipoEndereco.add(pessoaEndereco.getPessoa());
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorTipoEndereco;

	}

	@Override
	public List<Pessoa> buscarPessoasPorTipoContato(String tipoContato) {
		List<Pessoa> pessoaContato = new ArrayList<>();
		try {
			List<PessoaContato> pessoa = new PessoaContato().pessoaContato();
			for (PessoaContato pessoaPorContatoEspecificado : pessoa) {
				if (pessoaPorContatoEspecificado.getContato().getTipo().getTipo().equalsIgnoreCase(tipoContato)) {
					pessoaContato.add(pessoaPorContatoEspecificado.getPessoa());
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaContato;

	}

	@Override
	public List<Pessoa> buscarPessoasPorBairro(String bairro) {
		List<Pessoa> pessoaPorBairro = new ArrayList<>();
		try {
			List<PessoaEndereco> pessoaPorEndereco = new PessoaEndereco().pessoaEndereco();
			for (PessoaEndereco pessoaEndereco : pessoaPorEndereco) {
				if (pessoaEndereco.getEndereco().getBairro().equalsIgnoreCase(bairro)) {
					pessoaPorBairro.add(pessoaEndereco.getPessoa());
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorBairro;

	}

	@Override
	public List<Pessoa> buscarPessoasPorNomeBairroContem(String valor) {
		List<Pessoa> pessoaPorBairroContem = new ArrayList<>();
		try {
			List<PessoaEndereco> pessoaPorEndereco = new PessoaEndereco().pessoaEndereco();
			for (PessoaEndereco pessoaEndereco : pessoaPorEndereco) {
				if (pessoaEndereco.getEndereco().getBairro().contains(valor)) {
					pessoaPorBairroContem.add(pessoaEndereco.getPessoa());
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorBairroContem;

	}

	@Override
	public List<Pessoa> buscarPessoasPorEstado(String estado) {
		List<Pessoa> pessoaPorEstado = new ArrayList<>();
		try {
			List<PessoaEndereco> pessoaPorEndereco = new PessoaEndereco().pessoaEndereco();
			for (PessoaEndereco pessoaEndereco : pessoaPorEndereco) {
				if (pessoaEndereco.getEndereco().getBairro().equalsIgnoreCase(estado)) {
					pessoaPorEstado.add(pessoaEndereco.getPessoa());
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorEstado;

	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissao(String nomeProfissao) {
		List<Pessoa> pessoaPorProfissao = new ArrayList<>();
		try {
			List<PessoaProfissao> pessoaProf = new PessoaProfissao().pessoaProfissao();
			for (PessoaProfissao ps : pessoaProf) {
				if (ps.getProfissao().getNomeProfissao().equalsIgnoreCase(nomeProfissao)) {
					pessoaPorProfissao.add(ps.getPessoa());
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorProfissao;

	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoNomeAreaAtuacaoContem(String valor) {
		List<Pessoa> pessoaPorAreaAtuacao = new ArrayList<>();
		try {
			List<PessoaProfissao> pessoaProf = new PessoaProfissao().pessoaProfissao();
			for (PessoaProfissao ps : pessoaProf) {
				if (ps.getProfissao().getAreaAtuacao().contains(valor)) {
					pessoaPorAreaAtuacao.add(ps.getPessoa());
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorAreaAtuacao;

	}

	@Override
	public List<Pessoa> buscarPessoasPorSalarioBaseMaiorQue(BigDecimal salarioBase) {
		List<Pessoa> pessoaPorSalarioMaiorQue = new ArrayList<>();
		try {
			List<PessoaProfissao> pessoaProf = new PessoaProfissao().pessoaProfissao();
			for (PessoaProfissao ps : pessoaProf) {
				BigDecimal bg = ps.getProfissao().getSalarioBase();
				int result = bg.compareTo(salarioBase);
				if (result == 1) {
					pessoaPorSalarioMaiorQue.add(ps.getPessoa());
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorSalarioMaiorQue;

	}

	@Override
	public List<Pessoa> buscarPessoasPorSalarioBaseMaiorIgual(BigDecimal salarioBase) {
		List<Pessoa> pessoaPorSalarioMaiorQue = new ArrayList<>();
		try {
			List<PessoaProfissao> pessoaProf = new PessoaProfissao().pessoaProfissao();
			for (PessoaProfissao ps : pessoaProf) {
				int result = ps.getProfissao().getSalarioBase().compareTo(salarioBase);
				if (result == 1 || result == 0) {
					pessoaPorSalarioMaiorQue.add(ps.getPessoa());
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorSalarioMaiorQue;

	}

	@Override
	public List<Pessoa> buscarPessoasPorSalarioBaseEntre(BigDecimal salarioBaseInicio, BigDecimal salarioBaseFim) {
		List<Pessoa> pessoaPorSalarioEntre = new ArrayList<>();
		try {
			List<PessoaProfissao> pessoaProf = new PessoaProfissao().pessoaProfissao();
			for (PessoaProfissao ps : pessoaProf) {
				int inicialResult = ps.getProfissao().getSalarioBase().compareTo(salarioBaseInicio);
				int finalResult = ps.getProfissao().getSalarioBase().compareTo(salarioBaseFim);
				System.out.println(ps.getProfissao().getSalarioBase());
				if (inicialResult == 1 && finalResult == -1) {
					pessoaPorSalarioEntre.add(ps.getPessoa());
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorSalarioEntre;

	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeConcluida() {
		List<Pessoa> pessoaPorEscolaridadeConcluida = new ArrayList<>();
		try {
			List<PessoaFormacao> pessoaForm = new PessoaFormacao().pessoaFormacao();
			for (PessoaFormacao ps : pessoaForm) {
				if (ps.getFormacao().getConcluido().equalsIgnoreCase("sim"))
					;
				pessoaPorEscolaridadeConcluida.add(ps.getPessoa());

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorEscolaridadeConcluida;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {
		List<Pessoa> pessoaPorEscolaridadeAreaAtuacao = new ArrayList<>();
		try {
			List<PessoaFormacao> pessoaForm = new PessoaFormacao().pessoaFormacao();
			List<PessoaProfissao> pessoaProf = new PessoaProfissao().pessoaProfissao();
			for (int i = 0; i < pessoaProf.size(); i++) {
				for (int j = 0; j < pessoaForm.size(); j++) {
					Integer codeForm = pessoaProf.get(i).getProfissao().getCodProfissao();
					Integer codeEsc = pessoaForm.get(j).getFormacao().getCodigo();
					if (codeForm.equals(codeEsc)
							&& pessoaProf.get(i).getProfissao().getAreaAtuacao().equalsIgnoreCase(areaAtuacao)) {
						pessoaPorEscolaridadeAreaAtuacao.add(pessoaProf.get(i).getPessoa());
					}
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorEscolaridadeAreaAtuacao;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeAnoTermino(Integer ano) {
		List<Pessoa> pessoaPorEscolaridadeAnoTermino = new ArrayList<>();
		try {
			List<PessoaFormacao> pessoaForm = new PessoaFormacao().pessoaFormacao();
			for (PessoaFormacao ps : pessoaForm) {

				if (ps.getFormacao().getDataTermino() != null) {
					Integer year = ps.getFormacao().getDataTermino().getYear();
					if (year.equals(ano)) {
						pessoaPorEscolaridadeAnoTermino.add(ps.getPessoa());
					}
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorEscolaridadeAnoTermino;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {
		List<Pessoa> pessoaPorEscolaridadeAnoTerminoQtdSemestre = new ArrayList<>();
		try {
			List<PessoaFormacao> pessoaForm = new PessoaFormacao().pessoaFormacao();
			for (PessoaFormacao ps : pessoaForm) {

				if (ps.getFormacao().getDataTermino() != null) {
					Integer semestreAtual = ps.getFormacao().getSemestreAtual();
					if (semestreAtual.equals(semestre)) {
						pessoaPorEscolaridadeAnoTerminoQtdSemestre.add(ps.getPessoa());
					}
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorEscolaridadeAnoTerminoQtdSemestre;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadeConcluido(String areaAtuacao) {
		List<Pessoa> pessoaPorEscolaridadeAreaAtuacaoConcluido = new ArrayList<>();
		try {
			List<PessoaFormacao> pessoaForm = new PessoaFormacao().pessoaFormacao();
			List<PessoaProfissao> pessoaProf = new PessoaProfissao().pessoaProfissao();
			for (int i = 0; i < pessoaProf.size(); i++) {
				for (int j = 0; j < pessoaForm.size(); j++) {
					Integer codeForm = pessoaProf.get(i).getProfissao().getCodProfissao();
					Integer codeEsc = pessoaForm.get(j).getFormacao().getCodigo();
					if (codeForm.equals(codeEsc)
							&& pessoaForm.get(i).getFormacao().getConcluido().equalsIgnoreCase(areaAtuacao)
							&& pessoaForm.get(i).getFormacao().getConcluido().equalsIgnoreCase("sim")) {
						pessoaPorEscolaridadeAreaAtuacaoConcluido.add(pessoaProf.get(i).getPessoa());
					}
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoaPorEscolaridadeAreaAtuacaoConcluido;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {
		List<Pessoa> pessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre = new ArrayList<>();
		try {
			List<PessoaFormacao> pessoaForm = new PessoaFormacao().pessoaFormacao();
			List<PessoaProfissao> pessoaProf = new PessoaProfissao().pessoaProfissao();
			for (int i = 0; i < pessoaProf.size(); i++) {
				for (int j = 0; j < pessoaForm.size(); j++) {
					Integer codeForm = pessoaProf.get(i).getProfissao().getCodProfissao();
					Integer codeEsc = pessoaForm.get(j).getFormacao().getCodigo();
					if (codeForm.equals(codeEsc)
							&& pessoaProf.get(i).getProfissao().getAreaAtuacao().equalsIgnoreCase(areaAtuacao)
							&& pessoaForm.get(i).getFormacao().getSemestreAtual().equals(semestre)) {
						pessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre.add(pessoaProf.get(i).getPessoa());
					}
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(String estadoCivil,
			String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {

		List<Pessoa> pessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao = new ArrayList<>();
		try {
			List<PessoaFormacao> pessoaForm = new PessoaFormacao().pessoaFormacao();
			List<PessoaProfissao> pessoaProf = new PessoaProfissao().pessoaProfissao();
			for (int i = 0; i < pessoaProf.size(); i++) {
				for (int j = 0; j < pessoaForm.size(); j++) {
					Integer codeForm = pessoaProf.get(i).getProfissao().getCodProfissao();
					Integer codeEsc = pessoaForm.get(j).getFormacao().getCodigo();
					if (codeForm.equals(codeEsc)
							&& pessoaProf.get(i).getProfissao().getAreaAtuacao().equalsIgnoreCase(areaAtuacaoProfissao)
							&& pessoaForm.get(j).getFormacao().getConcluido().equalsIgnoreCase(areaAtuacaoEscolaridade)
							&& pessoaForm.get(i).getPessoa().getEstadoCivil().equalsIgnoreCase(estadoCivil)) {
						pessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao
								.add(pessoaProf.get(i).getPessoa());
						break;
					}
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao;

	}

	@Override
	public List<Contato> buscarEnderecoDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		List<Contato> contatoPessoaMaiorDeIdadeEstadoCivil = new ArrayList<>();
		try {
			List<PessoaContato> pessoaContato = new PessoaContato().pessoaContato();
			List<PessoaEndereco> pessoaEndereco = new PessoaEndereco().pessoaEndereco();
			for (int i = 0; i < pessoaContato.size(); i++) {
				Integer idade = (LocalDate.now().getYear()
						- pessoaContato.get(i).getPessoa().getDataNascimento().getYear());
				Boolean contatoCpfValida = pessoaContato.get(i).getPessoa().getCpf()
						.equals(pessoaContato.get(i).getContato().getCpf());
				Boolean estadoCivilCasadoOuSolteiro = pessoaContato.get(i).getPessoa().getEstadoCivil()
						.equalsIgnoreCase(estadoCivil);
				if (contatoCpfValida && idade >= 18 && estadoCivilCasadoOuSolteiro) {
					for (int j = 0; j < pessoaEndereco.size(); j++) {
						if (pessoaContato.get(i).getPessoa().getCpf()
								.equals(pessoaEndereco.get(j).getEndereco().getCpf())) {
							;
							contatoPessoaMaiorDeIdadeEstadoCivil.add(pessoaContato.get(i).getContato());
							break;
						}
					}
				}
			}

		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return contatoPessoaMaiorDeIdadeEstadoCivil;

	}

	@Override
	public List<Contato> buscarEnderecoPorTipoEndereco(String tipoEndereco) {
		List<Contato> contatoEndereco = new ArrayList<>();
		try {
			List<PessoaContato> pessoaContato = new PessoaContato().pessoaContato();
			List<PessoaEndereco> pessoaEndereco = new PessoaEndereco().pessoaEndereco();
			for (int i = 0; i < pessoaEndereco.size(); i++) {

				for (int j = 0; j < pessoaContato.size(); j++) {
					if (pessoaContato.get(i).getPessoa().getCpf().equals(pessoaEndereco.get(j).getEndereco().getCpf())
							&& pessoaEndereco.get(j).getEndereco().getTipo().getTipo().equalsIgnoreCase(tipoEndereco)) {
						;
						contatoEndereco.add(pessoaContato.get(i).getContato());
						break;
					}
				}
			}

		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return contatoEndereco;

	}

	@Override
	public List<Contato> buscarNomeRuaEnderecoPorCidadePorPessoaSexoConjungeComAnoNascimento(String cidade, String sexo,
			Integer anoNascimentoConjunge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomeDoConjungeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		List<String> pessoasMaioresEstadoCilvolConjuge = new ArrayList<>();
		try {
			List<Pessoa> pessoas = new CriaPessoa().criaObjetos();
			for (Pessoa maioresDeIdade : pessoas) {

				if (LocalDate.now().getYear() - maioresDeIdade.getDataNascimento().getYear() >= 18
						&& maioresDeIdade.getEstadoCivil().equalsIgnoreCase("sim"))
					pessoasMaioresEstadoCilvolConjuge.add(maioresDeIdade.getConjuge());
				break;
			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}

		return pessoasMaioresEstadoCilvolConjuge;
	}

	@Override
	public List<String> buscarNomeDoConjungeDasPessoasPorEstadoCivil(List<String> estadoCivil) {
		List<String> pessoasMaioresEstadoCilvolConjuge = new ArrayList<>();
		try {
			List<Pessoa> pessoas = new CriaPessoa().criaObjetos();
			for (int i = 0; i < pessoas.size(); i++) {
				for (int j = 0; j < estadoCivil.size(); j++) {
					if (pessoas.get(i).getEstadoCivil().equalsIgnoreCase(estadoCivil.get(j))) {

						pessoasMaioresEstadoCilvolConjuge.add(pessoas.get(i).getConjuge());
						break;
					}
				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}

		return pessoasMaioresEstadoCilvolConjuge;
	}

	@Override
	public List<String> buscarNomeDoConjungeMaioresDeIdadeDasPessoasPorEstadoCivil(String estadoCivil) {
		List<String> pessoasMaioresEstadoCilvolConjuge = new ArrayList<>();
		try {
			List<Pessoa> pessoas = new CriaPessoa().criaObjetos();
			for (int i = 0; i < pessoas.size(); i++) {

				if (pessoas.get(i).getEstadoCivil().equalsIgnoreCase(estadoCivil)) {
					if ((LocalDate.now().getYear() - pessoas.get(i).getDataNascimento().getYear() >= 18
							&& pessoas.get(i).getEstadoCivil().equalsIgnoreCase(estadoCivil)))
						pessoasMaioresEstadoCilvolConjuge.add(pessoas.get(i).getConjuge());
					break;

				}

			}
		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}

		return pessoasMaioresEstadoCilvolConjuge;
	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacao(String areaAtuacao) {
		List<Contato> contatoPorProfissaoAreaAtuacao = new ArrayList<>();
		try {
			List<PessoaContato> pessoaContato = new PessoaContato().pessoaContato();
			List<PessoaProfissao> pessoaProfissao = new PessoaProfissao().pessoaProfissao();
			for (int i = 0; i < pessoaProfissao.size(); i++) {
				for (int j = 0; j < pessoaContato.size(); j++) {
					if (pessoaProfissao.get(i).getPessoa().getCpf()
							.equalsIgnoreCase(pessoaContato.get(j).getContato().getCpf())
							&& pessoaProfissao.get(i).getProfissao().getAreaAtuacao().equalsIgnoreCase(areaAtuacao)) {
						contatoPorProfissaoAreaAtuacao.add(pessoaContato.get(j).getContato());
					}
				}

			}

		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return contatoPorProfissaoAreaAtuacao;

	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadoEBairro(String areaAtuacao, String estado,
			String bairro) {
		List<Contato> contatoPorProfissaoAreaAtuacao = new ArrayList<>();
		try {
			List<PessoaContato> pessoaContato = new PessoaContato().pessoaContato();
			List<PessoaProfissao> pessoaProfissao = new PessoaProfissao().pessoaProfissao();
			List<PessoaEndereco> pessoaEndereco = new PessoaEndereco().pessoaEndereco();
			for (int i = 0; i < pessoaProfissao.size(); i++) {
				for (int j = 0; j < pessoaContato.size(); j++) {
					if (pessoaProfissao.get(i).getPessoa().getCpf()
							.equalsIgnoreCase(pessoaContato.get(j).getContato().getCpf())
							&& pessoaProfissao.get(i).getProfissao().getAreaAtuacao().equalsIgnoreCase(areaAtuacao)) {
						for (int k = 0; k < pessoaEndereco.size(); k++) {
							if (pessoaEndereco.get(k).getEndereco().getCpf()
									.equals(pessoaProfissao.get(i).getPessoa().getCpf())
									&& pessoaEndereco.get(k).getEndereco().getBairro().equalsIgnoreCase(bairro)
									&& pessoaEndereco.get(k).getEndereco().getEstado().equalsIgnoreCase(estado)) {

								contatoPorProfissaoAreaAtuacao.add(pessoaContato.get(i).getContato());
							}
						}
					}
				}

			}

		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return contatoPorProfissaoAreaAtuacao;

	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadosEBairro(String areaAtuacao,
			List<String> estados, String bairro) {
		List<Contato> contatoPorProfissaoAreaAtuacao = new ArrayList<>();
		return null;
	}

	@Override
	public List<Contato> buscarContatoPorTipoContato(String tipoContato) {
		List<Contato> contatoPorTipo = new ArrayList<>();
		try {
			List<Contato> pessoaContato = new CriaContato().criaObjetos();
			for (Contato cont : pessoaContato) {
				if (cont.getTipo().getTipo().equalsIgnoreCase(tipoContato)) {
					contatoPorTipo.add(cont);
				}

			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		return contatoPorTipo;

	}

	@Override
	public List<Contato> buscarContatoPorTiposContato(List<String> tipoContato) {
		List<Contato> contatoPorTipo = new ArrayList<>();
		try {
			List<Contato> pessoaContato = new CriaContato().criaObjetos();
			for (int i = 0; i < pessoaContato.size(); i++) {
				for (int j = 0; j < tipoContato.size(); j++) {
					if (pessoaContato.get(i).getTipo().getTipo().equalsIgnoreCase(tipoContato.get(j))) {

						pessoaContato.add(pessoaContato.get(i));

					}
				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		return contatoPorTipo;

	}

	@Override
	public List<String> buscarEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			Integer anoNasicmento, String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomeInstituicaoPorPorAreaAtuacao(String areaAtuacaoProfissao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomePessoasPorProfissaoPorAreaAtuacao(String areaAtuacaoProfissao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomePessoasPorEscolaridadePorAreaAtuacao(String areaAtuacaoEscolaridade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissaoPorAreaAtuacao(String areaAtuacaoProfissao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadePorAreaAtuacao(String areaAtuacaoEscolaridade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasMaioresIdade() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalDasPessoasPorEstadoCivil(String estadoCivil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorBairro(String bairro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissao(String nomeProfissao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorSalarioBaseMaiorIgual(BigDecimal salarioBase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			Integer anoNasicmento, String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalConjugeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalContatosPorTipoContato(String tipoContato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeNaoConcluida() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorBairroPorProfissaoPorAreaAtuacao(String bairro,
			String areaAtuacaoProfissao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalContatoPorTiposContato(List<String> tipoContato) {
		// TODO Auto-generated method stub
		return null;
	}

}
