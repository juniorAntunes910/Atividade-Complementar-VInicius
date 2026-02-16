package org.example.Main;

import Dao.AlunoDao;
import Dao.UsuarioDao;
import Entidades.Alunos;
import Entidades.Usuario;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    final static Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            menuInicio();
        }
    }
    public static void menuInicio(){
        System.out.println("""
                1 - Menu Usuário
                2 - Menu Alunos
                3 - Menu Produtos
                Escolha opção: 
                """);
        int opcao = SC.nextInt();
        switch (opcao){
            case 1:
                menuUsuario();
                break;
            case 2:
                menuAluno();
                break;
            case 3:
                menuProduto();
                break;
        }
    }
    public static void menuUsuario(){
        while (true){
            System.out.println("""
                    1 - Criar Usuário
                    2 - Ler Usuário 
                    3 - Atualizar Usuário
                    4 - Deletar Usuário
                    5 - Voltar ao menu inicial
                    Escolha opção: 
                    """);
            int opcao = SC.nextInt();
            switch (opcao){
                case 1:
                    criarUsuario();
                    break;
                case 2:
                    lerUsuarioMenu();
                    break;
                case 3:
                    atualizarUsuario();
                    break;
                case 4:
                    deletarUsuario();
                    break;
                case 5:
                    menuInicio();
                    break;
            }
        }
    }
    //Usuario
    public static void criarUsuario(){
        System.out.println("Insira o Nome do Usuário: ");
        SC.nextLine();
        String nome = SC.nextLine();
        System.out.println("Insira o Email do Usuário: ");
        String email = SC.nextLine();
        var dao = new UsuarioDao();
        dao.inserirUsuario(new Usuario(nome, email));
    }
    public static void lerUsuarioMenu(){
        System.out.println("""
                1 - Ler por ID
                2 - Ler por Nome (Varios)
                3 - Voltar ao menu Usuario
                Escolha opcao: 
                """);
        int opcao = SC.nextInt();
        switch (opcao){
            case 1:
                lerPorID();
                break;
            case 2:
                lerPorNome();
                break;
            case 3:
                menuUsuario();
                break;
        }
    }

    //Usuario Leituras
    public static void lerPorID(){
        System.out.println("Insira o ID do Usuário que você deseja Ler: ");
        int id = SC.nextInt();
        var dao = new UsuarioDao();
        Usuario usuario = dao.lerPorID(id);
        if(usuario == null){
            System.out.println("Usuário não encontrado!");
        }else{
            System.out.println(usuario);
        }
    }
    public static void lerPorNome(){
        System.out.println("Insira o nome do Usuário que você deseja Ler: ");
        SC.nextLine();
        String nome = SC.nextLine();
        var dao = new UsuarioDao();
        ArrayList<Usuario> listaUsuario = dao.lerPorNome(nome);
        for(Usuario usuario : listaUsuario){
            System.out.println(usuario);
        }
    }
    public static void atualizarUsuario(){
        System.out.println("""
                1 - Atualizar Nome
                2 - Atualizar Email
                3 - Voltar ao menu Usuario
                Escolha opção: 
                """);
        int opcao = SC.nextInt();
        switch (opcao){
            case 1:
                AtualizarNomeUSer();
                break;
            case 2:
                atualizarEmailUser();
                break;
            case 3:
                menuUsuario();
        }
    }
    public static void listarUsuario(){
        var dao = new UsuarioDao();
        ArrayList<Usuario> listaUsuarios = dao.listarUsuarios();
        for(Usuario user : listaUsuarios){
            System.out.println(user);
        }
    }
    //Atualização de Usuarios
    public static void AtualizarNomeUSer(){
        System.out.println("lista Usuarios: ");
        listarUsuario();
        System.out.println("Insira o ID do usuário que você deseja atualzar: ");
        int id = SC.nextInt();
        System.out.println("insira o novo Nome do Usuário: ");
        SC.nextLine();
        String nome = SC.nextLine();
        var dao = new UsuarioDao();
        dao.atualizarNome(nome, id);
    }
    public static void atualizarEmailUser(){
        System.out.println("Lista Usuários: ");
        listarUsuario();
        System.out.println("Insira o ID do usuário que você deseja atualizar: ");
        int id = SC.nextInt();
        System.out.println("Insira o novo Email do usuário: ");
        SC.nextLine();
        String email = SC.nextLine();
        var dao = new UsuarioDao();
        dao.atualizarEmail(email, id);
    }
    public static void deletarUsuario(){
        var dao = new UsuarioDao();
        System.out.println("Lista usuários: ");
        listarUsuario();
        System.out.println("Insira o ID do usuário que você deseja DELETAR: ");
        int id = SC.nextInt();
        Usuario userdel = dao.lerPorID(id);
        System.out.println("Digite o ID novamente para DELETAR o usuário - " + userdel.getNome());
        int idconfirm = SC.nextInt();
        if(id == idconfirm){
            dao.deletarUsuario(id);
        }else{
            System.out.println("IDs incompátiveis!");
        }
    }


    //Aluno
    public static void menuAluno() {
        while (true) {
            System.out.println("""
                    1 - Criar Aluno 
                    2 - Ler Aluno
                    3 - Atualizar Aluno
                    4 - Remover Aluno
                    5 - Voltar ao menu Principal
                    Escolha opção: 
                    """);
            int opcao = SC.nextInt();
            switch (opcao){
                case 1:
                    criarAluno();
                    break;
                case 2:
                    lerAluno();
                    break;
                case 3:
                    atualizarAluno();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 5:
                    menuInicio();
                    break;
            }
        }
    }

    public static void criarAluno(){
        System.out.println("Insira o nome do Aluno que você deseja criar: ");
        SC.nextLine();
        String nome = SC.nextLine();
        System.out.println("Insira a matricula do aluno que você deseja criar: ");
        String matricula = SC.nextLine();
        System.out.println("Insira o nome do curso do aluno que você deseja criar: ");
        String curso = SC.nextLine();
        var dao = new AlunoDao();
        dao.inserirAluno(new Alunos(nome,matricula,curso));
    }
    public static void lerAluno(){
        while(true) {
            System.out.println("""
                    1 - Ler Aluno por ID
                    2 - Ler Aluno por nome
                    3 - ler Aluno por matricula
                    4 - ler Alunos por curso
                    5 - Voltar
                    """);
            int opcao = SC.nextInt();
            switch (opcao){
                case 1:
                    lerAlunoPorID();
                    break;
                case 2:
                    lerAlunoPorNome();
                    break;

                case 3:
                    lerAlunoPorMatricula();
                    break;
                case 4:
                    lerAlunosPorCurso();
                    break;

                case 5:
                    menuAluno();
                    break;
            }
        }
    }
    public static void lerAlunoPorID(){
        System.out.println("Insira o ID do aluno que você deseja buscar: ");
        int id = SC.nextInt();
        var dao = new AlunoDao();
        Alunos aluno = dao.lerAlunoID(id);
        if(aluno == null){
            System.out.println("Aluno não existe ");
            return;
        }
        System.out.println(aluno);
    }
    public static void lerAlunoPorNome(){
        System.out.println("Insira o NOME do aluno que você deseja buscar: ");
        SC.nextLine();
        String nome = SC.nextLine();
        var dao = new AlunoDao();
        Alunos aluno = dao.lerPorNome(nome);
        if(aluno == null){
            System.out.println("Aluno não existe ");
            return;
        }
        System.out.println(aluno);
    }
    public static void lerAlunoPorMatricula(){
        System.out.println("Insira o Matricula do aluno que você deseja buscar: ");
        SC.nextLine();
        String matricula = SC.nextLine();
        var dao = new AlunoDao();
        Alunos aluno = dao.lerPorMatricula(matricula);
        if(aluno == null){
            System.out.println("Aluno não existe ");
            return;
        }
        System.out.println(aluno);
    }
    public static void lerAlunosPorCurso(){
        System.out.println("Insira o Curso dos Alunos que você deseja buscar: ");
        SC.nextLine();
        String curso = SC.nextLine();
        var dao = new AlunoDao();
        ArrayList<Alunos> alunos = dao.lerPorCursos(curso);
        for(Alunos aluno : alunos ){
            System.out.println(aluno);
        }
    }
    public static void atualizarAluno(){
        System.out.println("""
                1 - Atualizar nome
                2 - Atualizar matricula
                3 - Atualizar curso
                4 - Atualizar Tudo
                5 - Voltar
                """);
        int opcao = SC.nextInt();
        switch (opcao){
            case 1:
                atualizarNomeAluno();
                break;
            case 2:
                atualizarMatricula();
                break;
            case 3:
                atualizarCurso();
                break;
            case 4:
                atualizarTudo();
                break;
            case 5:
                menuAluno();
                break;
        }
    }
    public static void atualizarNomeAluno(){
        var dao = new AlunoDao();
        System.out.println("Insira o id do Aluno que você deseja atualizar: ");
        int id = SC.nextInt();
        Alunos aluno = dao.lerAlunoID(id);
        if(aluno == null){
            System.out.println("Aluno não existe!");
            return;
        }
        System.out.println("Insira o novo nome do Aluno: ");
        SC.nextLine();
        String nome = SC.nextLine();
        dao.atualizarAlunoNome(id, nome);
    }
    public static void atualizarMatricula(){
        var dao = new AlunoDao();
        System.out.println("Insira o id do Aluno que você deseja atualizar: ");
        int id = SC.nextInt();
        Alunos aluno = dao.lerAlunoID(id);
        if(aluno == null){
            System.out.println("Aluno não existe!");
            return;
        }
        System.out.println("Insira a nova Matricula do Aluno: ");
        SC.nextLine();
        String matricula = SC.nextLine();
        dao.atualizarAlunoMatricula(id, matricula);
    }
    public static void atualizarCurso(){
        var dao = new AlunoDao();
        System.out.println("Insira o id do Aluno que você deseja atualizar: ");
        int id = SC.nextInt();
        Alunos aluno = dao.lerAlunoID(id);
        if(aluno == null){
            System.out.println("Aluno não existe!");
            return;
        }
        System.out.println("Insira o novo curso do ALuno");
        SC.nextLine();
        String curso = SC.nextLine();
        dao.atualizarCurso(id, curso);

    }
    public static void atualizarTudo(){
        var dao = new AlunoDao();
        System.out.println("Insira o id do Aluno que você deseja atualizar: ");
        int id = SC.nextInt();
        Alunos aluno = dao.lerAlunoID(id);
        if(aluno == null){
            System.out.println("Aluno não existe!");
            return;
        }
        System.out.println("Insira o novo Nome: ");
        SC.nextLine();
        String nome = SC.nextLine();
        System.out.println("Insira a nova Matricula: ");
        String matricula = SC.nextLine();
        System.out.println("Insira o novo Curso: ");
        String curso = SC.nextLine();
        Alunos alunoAtualiza = new Alunos(id, nome, matricula, curso);
        dao.atualizarTudo(alunoAtualiza);
    }
    public static void removerAluno() {
        while (true) {
            System.out.println("""
                    1 - Remover aluno por ID
                    2 - Voltar """);
            int opcao = SC.nextInt();
            switch (opcao){
                case 1:
                    removerALunoPorID();
                    break;
                case 2:
                    menuAluno();
                    break;
            }
        }
    }
    public static void removerALunoPorID(){
        var dao = new AlunoDao();
        System.out.println("Insira o id do Aluno que você deseja Remover: ");
        int id = SC.nextInt();
        Alunos aluno = dao.lerAlunoID(id);
        if(aluno == null){
            System.out.println("Aluno não existe!");
            return;
        }
        System.out.println("""
                Para DELETAR o usuário digite:
                EICHENDORF
                """);
        SC.nextLine();
        String confirmaDell = SC.nextLine();
        if(!confirmaDell.equals("EICHENDORF")){
            System.out.println("Codigo de confirmação errado");
            return;
        }
        dao.removerAlunoPorID(id);
    }

    //Menu Produto
    public static void menuProduto(){

    }
}
