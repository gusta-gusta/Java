package PacoteAnotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)                    //Esta anota  o informa que poder  ser consultada tem tempo de execu  o
@Target(ElementType.FIELD)                             //Esta anota  o quer dizar que a anota  o que criamos pode estar em cima de um atributo (FIELD) OU em cima de um Metodo (METHOD) 
public @interface DoublePositivo {

}
