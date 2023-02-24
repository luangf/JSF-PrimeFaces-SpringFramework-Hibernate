package br.com.project.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//abstract -> para poder reutilizar em outros lugares *
@Target(value = ElementType.FIELD) // o alvo dessa anota��o, apenas campos/atributos...
@Retention(value=RetentionPolicy.RUNTIME) //VM(m�quina virtual) //padr�o p/annotation
@Documented //padr�o p/annotation
public abstract @interface IdentificaCampoPesquisa {
	
	String descricaoCampo(); //descri��o do campo(o que o user vai buscar) p/tela
	String campoConsulta(); //campo do banco que � buscado para retornar o valor
	int principal() default 10000; //posi��o q aparecer� no combo
	
}