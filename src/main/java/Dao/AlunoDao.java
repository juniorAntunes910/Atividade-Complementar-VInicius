package Dao;

import Conexão.Conexao;
import Entidades.Alunos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDao {
    public void inserirAluno(Alunos aluno){
        String sql = """
                INSERT INTO alunos (nome, matricula, curso)
                VALUES (?,?,?)
                """;
        try(Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getMatricula());
            stmt.setString(3, aluno.getCurso());
            stmt.execute();

            System.out.println("Aluno Inserido com sucesso!");
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }
    public Alunos lerAlunoID(int id){
        String sql = """
                SELECT id,nome,matricula,curso
                FROM alunos 
                WHERE id = ?
                """;
        try(Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if( rs.next()){
                return new Alunos(rs.getInt("id"), rs.getString("nome"), rs.getString("matricula"),
                        rs.getString("curso"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public Alunos lerPorNome(String nome){
        String sql = """
                SELECT id,nome,matricula,curso 
                FROM alunos
                WHERE nome = ?
                """;
        try (Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if( rs.next()){
                return new Alunos(rs.getInt("id"), rs.getString("nome"), rs.getString("matricula"),
                        rs.getString("curso"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Alunos lerPorMatricula(String matricula){
        String sql = """
                SELECT id,nome,matricula,curso 
                FROM alunos
                WHERE matricula = ?
                """;
        try (Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();
            if( rs.next()){
                return new Alunos(rs.getInt("id"), rs.getString("nome"), rs.getString("matricula"),
                        rs.getString("curso"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Alunos> lerPorCursos(String curso){
        String sql = """
                SELECT id,nome,matricula,curso 
                FROM alunos
                WHERE curso LIKE ?
                """;
        try(Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + curso + "%");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Alunos> listaALunos = new ArrayList<>();
            while (rs.next()){
                listaALunos.add(new Alunos(rs.getInt("id"), rs.getString("nome"), rs.getString("matricula"),
                        rs.getString("curso")));
            }
            return listaALunos;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public void atualizarAlunoNome(int id, String nome){
        String sql = """
                UPDATE alunos
                SET nome = ?
                WHERE id = ?
                """;
        try(Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Nome atualizado com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void atualizarAlunoMatricula(int id, String matricula){
        String sql = """
                UPDATE alunos
                SET matricula = ?
                WHERE id = ?
                """;
        try (Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(2,id);
            stmt.setString(1, matricula);
            stmt.executeUpdate();
            System.out.println("Nome atualizado com sucesso");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void atualizarCurso(int id, String curso) {
        String sql = """
                UPDATE alunos
                SET curso = ?
                WHERE id = ?
                """;
        try (Connection conn = Conexao.Conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(2, id);
            stmt.setString(1, curso);
            stmt.executeUpdate();
            System.out.println("Nome atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void atualizarTudo(Alunos aluno){
        String sql = """
                UPDATE alunos
                SET nome = ?,
                matricula = ?,
                curso = ?
                WHERE id = ?
                """;
        try (Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getMatricula());
            stmt.setString(3, aluno.getCurso());
            stmt.setInt(4, aluno.getId());
            stmt.executeUpdate();
            System.out.println("Atualizado com sucesso! ");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void removerAlunoPorID(int id){
        String sql = """
                DELETE FROM alunos
                WHERE id = ?
                """;
        try(Connection conn = Conexao.Conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Removido com sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
