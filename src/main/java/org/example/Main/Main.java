package org.example.Main;

import Dao.UsuarioDao;
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
    public static void menuAluno(){
        System.out.println("""
                
                """);
    }
    public static void menuProduto(){

    }
}
