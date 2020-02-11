package br.com.rsinet.appium.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CadastroUsuario.class,ConsultaProdutoTelaInicial.class,ConsultaProdutoBarraDePesquisa.class})
public class Runner {

}
