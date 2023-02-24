package br.com.project.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//abstract -> para poder reutilizar em outros lugares *
@Target(value = ElementType.FIELD) // o alvo dessa anotação, apenas campos/atributos...
@Retention(value=RetentionPolicy.RUNTIME) //VM(máquina virtual) //padrão p/annotation
@Documented //padrão p/annotation
public abstract @interface IdentificaCampoPesquisa {
	
	String descricaoCampo(); //descrição do campo(o que o user vai buscar) p/tela
	String campoConsulta(); //campo do banco que é buscado para retornar o valor
	int principal() default 10000; //posição q aparecerá no combo
	
}