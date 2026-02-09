package Dao;

import Conexão.Conexao;
import Entidades.Alunos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

            System.out.println("Usuario Inserido com sucesso!");
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }
}
