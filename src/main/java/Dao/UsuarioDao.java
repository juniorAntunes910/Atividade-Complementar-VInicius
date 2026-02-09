package Dao;

import Conexão.Conexao;
import Entidades.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao {
    public void inserirUsuario(Usuario usuario){
        String sql = """
                INSERT INTO usuarios (nome, email) VALUES (?,?)
                
                """;
        try(Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();
            System.out.println("Usuario inserido com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Usuario lerPorID(int id){
        String sql = """
                SELECT id, nome, email
                FROM usuarios
                WHERE id = ?
                """;
        try (Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if ( rs.next()){
                return new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Usuario> lerPorNome (String nome){
        String sql = """
                SELECT id, nome, email 
                FROM usuarios 
                WHERE nome LIKE ?
                """;
        try (Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Usuario> listaUsuarios = new ArrayList<>();
            while (rs.next()){
                listaUsuarios.add(new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email")));
            }
            return listaUsuarios;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Usuario> listarUsuarios(){
        String sql = """
                SELECT id, nome, email 
                FROM usuarios
                """;
        try(Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Usuario> listaUsuario = new ArrayList<>();
            while (rs.next()){
                listaUsuario.add(new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email")));
            }
            return listaUsuario;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public void atualizarNome(String nome, int id){
        String sql = """
                UPDATE usuarios
                SET nome = ?
                WHERE id = ?
                """;
        try(Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
