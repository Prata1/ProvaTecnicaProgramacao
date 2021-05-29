/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MauricioAsenjo
 */
public class LivroBLL {

public static void validaTitulo(char _op, Livro _umlivro)
{
     Erro.setErro(false);
     if (_umlivro.getTitulo().equals(""))
       {Erro.setErro("O campo TITULO é de preenchimento obrigatório..."); return;}

     LivroDAL.conecta();
     if (Erro.getErro()) return;
     switch (_op)
     {
         case 'c':  LivroDAL.consultaLivro(_umlivro); break;
     }
     LivroDAL.desconecta();
}

public static void validaDados(char _op, Livro _umlivro)
{
 Erro.setErro(false);
 if (_umlivro.getTitulo().equals(""))
   {Erro.setErro("O campo TITULO é de preenchimento obrigatório..."); return;}
 if (_umlivro.getAutor().equals(""))
   {Erro.setErro("O campo AUTOR é de preenchimento obrigatório..."); return;}
 if (_umlivro.getEditora().equals(""))
   {Erro.setErro("O campo EDITORA é de preenchimento obrigatório..."); return;}
 if (_umlivro.getAnoEdicao().equals(""))
   {Erro.setErro("O campo ANO EDICAO é de preenchimento obrigatório..."); return;}
 else
   try
     {
     Integer.parseInt(_umlivro.getAnoEdicao());
     }
   catch (Exception e)
     {
     Erro.setErro("O campo ANO EDICAO deve ser numerico!"); return;
     }
 if (_umlivro.getLocalizacao().equals(""))
   {Erro.setErro("O campo LOCALIZACAO é de preenchimento obrigatório..."); return;}
 
 LivroDAL.conecta();
 if (Erro.getErro()) return;
 switch (_op)
 {
     case 'i':  LivroDAL.inseriLivro(_umlivro); break;
     case 'a':  LivroDAL.alteraLivro(_umlivro); break;    
 }
 LivroDAL.desconecta();
 
}

public static void validaConsulta (char _op, Livro _umlivro)
{
    LivroDAL.conecta();
 if (Erro.getErro()) return;
 switch (_op)
 {
     case 'f':  LivroDAL.firstLivro(_umlivro); break;
     case 'p':  LivroDAL.previousLivro(_umlivro); break; 
     case 'n':  LivroDAL.consultaLivro(_umlivro); break;
     case 'g':  LivroDAL.nextLivro(_umlivro); break;
     case 'u':  LivroDAL.lastLivro(_umlivro); break;
 }
 LivroDAL.desconecta();
}
}
