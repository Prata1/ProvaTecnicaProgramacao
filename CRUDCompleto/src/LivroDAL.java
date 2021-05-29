/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MauricioAsenjo
 */

import java.sql.*;


public class LivroDAL {

    private static Connection con;
    
    private static Statement stmt;

    public static void conecta()
    {
        Erro.setErro(false);
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://" + "Livros.mdb");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }
        catch (Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void desconecta()
    {
        Erro.setErro(false);
        try
        {
            con.close();
        }
        catch (Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void inseriLivro(Livro umlivro)
    {
        Erro.setErro(false);
        try
        {
            PreparedStatement st = con.prepareStatement("insert into TabLivros (titulo,autor,editora,ano,localizacao) values (?,?,?,?,?)");
            st.setString(1,umlivro.getTitulo());
            st.setString(2,umlivro.getAutor());
            st.setString(3,umlivro.getEditora());
            st.setString(4,umlivro.getAnoEdicao());
            st.setString(5,umlivro.getLocalizacao());
            st.executeUpdate();
            st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void consultaLivro(Livro umlivro)
    {
        ResultSet rs;

        try
        {
            PreparedStatement st = con.prepareStatement("SELECT * FROM TabLivros WHERE titulo=?");
            st.setString(1,umlivro.getTitulo());
            rs = st.executeQuery();
            if (rs.next())
            {
                umlivro.setAutor(rs.getString("autor"));
                umlivro.setEditora(rs.getString("editora"));
                umlivro.setAnoEdicao(rs.getString("ano"));
                umlivro.setLocalizacao(rs.getString("localizacao"));
            }
            else
            {
                Erro.setErro("Livro nao localizado.");
                return;
            }
            st.close();
        }
        catch(Exception e)
        {
            Erro.setErro(e.getMessage());
        }
    }

    public static void previousLivro(Livro umlivro){
        ResultSet rs;

        try
        {
            String query = "SELECT * FROM TabLivros";
            rs = stmt.executeQuery(query);
   
            if (rs.previous())
            {
                umlivro.setTitulo(rs.getString("titulo"));
                umlivro.setAutor(rs.getString("autor"));
                umlivro.setEditora(rs.getString("editora"));
                umlivro.setAnoEdicao(rs.getString("ano"));
                umlivro.setLocalizacao(rs.getString("localizacao"));
            }
            else
            {
                Erro.setErro("Livro nao localizado.");
                return;
            }
            stmt.close();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            Erro.setErro(e.getMessage());
        }
    }

    public static void firstLivro(Livro umlivro){
        ResultSet rs;

        try
        {
            String query = "SELECT * FROM TabLivros";
            rs = stmt.executeQuery(query);
   
            if (rs.first())
            {
                umlivro.setTitulo(rs.getString("titulo"));
                umlivro.setAutor(rs.getString("autor"));
                umlivro.setEditora(rs.getString("editora"));
                umlivro.setAnoEdicao(rs.getString("ano"));
                umlivro.setLocalizacao(rs.getString("localizacao"));
            }
            else
            {
                Erro.setErro("Livro nao localizado.");
                return;
            }
            stmt.close();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            Erro.setErro(e.getMessage());
        }
    }
    
    
    public static void nextLivro(Livro umlivro){
        ResultSet rs;

        try
        {
            String query = "SELECT * FROM TabLivros";
            rs = stmt.executeQuery(query);
   
            if (rs.next())
            {
                umlivro.setTitulo(rs.getString("titulo"));
                umlivro.setAutor(rs.getString("autor"));
                umlivro.setEditora(rs.getString("editora"));
                umlivro.setAnoEdicao(rs.getString("ano"));
                umlivro.setLocalizacao(rs.getString("localizacao"));
            }
            else
            {
                Erro.setErro("Livro nao localizado.");
                return;
            }
            stmt.close();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            Erro.setErro(e.getMessage());
        }
    }
    
    public static void lastLivro(Livro umlivro){
        ResultSet rs;

        try
        {
            String query = "SELECT * FROM TabLivros";
            rs = stmt.executeQuery(query);
   
            if (rs.last())
            {
                umlivro.setTitulo(rs.getString("titulo"));
                umlivro.setAutor(rs.getString("autor"));
                umlivro.setEditora(rs.getString("editora"));
                umlivro.setAnoEdicao(rs.getString("ano"));
                umlivro.setLocalizacao(rs.getString("localizacao"));
            }
            else
            {
                Erro.setErro("Livro nao localizado.");
                return;
            }
            stmt.close();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            Erro.setErro(e.getMessage());
        }
    }

    public static void alteraLivro(Livro umlivro){

    }
}