package br.com.qwasolucoes.mentoria.implementacoes.relacionamento;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.qwasolucoes.mentoria.interfaces.relacionamento.Relacionamentos;
import br.com.qwasolucoes.mentoria.modelagem_dados.Contato;
import br.com.qwasolucoes.mentoria.modelagem_dados.CriaPessoa;
import br.com.qwasolucoes.mentoria.modelagem_dados.Pessoa;
import br.com.qwasolucoes.mentoria.modelagem_dados.PessoaContato;
import br.com.qwasolucoes.mentoria.modelagem_dados.PessoaEndereco;
import br.com.qwasolucoes.mentoria.modelagem_dados.PessoaProfissao;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeAnoTermino(Integer ano) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadeConcluido(String areaAtuacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> buscarPessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(String estadoCivil,
			String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> buscarEnderecoDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> buscarEnderecoPorTipoEndereco(String tipoEndereco) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> buscarNomeRuaEnderecoPorCidadePorPessoaSexoConjungeComAnoNascimento(String cidade, String sexo,
			Integer anoNascimentoConjunge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomeDoConjungeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomeDoConjungeDasPessoasPorEstadoCivil(List<String> estadoCivil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomeDoConjungeMaioresDeIdadeDasPessoasPorEstadoCivil(String estadoCivil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacao(String areaAtuacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadoEBairro(String areaAtuacao, String estado,
			String bairro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadosEBairro(String areaAtuacao,
			List<String> estados, String bairro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> buscarContatoPorTipoContato(String tipoContato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> buscarContatoPorTiposContato(List<String> tipoContato) {
		// TODO Auto-generated method stub
		return null;
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
