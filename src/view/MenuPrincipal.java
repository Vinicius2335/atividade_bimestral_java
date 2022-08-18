package view;

import controller.Validacoes;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        Professor professor;
        Disciplina disciplina;
        Curso curso = new Curso();
        Colegiado colegiado = new Colegiado();
        Estudante estudante;
        AlunoCurso alunoCurso = new AlunoCurso();
        Aula aula = new Aula();

        List<Curso> listaCurso = new ArrayList<>();

        int opcao = 0;

        while (opcao != 8) {
            System.out.print("_______________________ MENU _______________________" +
                    "\n1 - Cadastrar Curso" +
                    "\n2 - Cadastrar Colegiado" +
                    "\n3 - Cadastrar Professor ao Colegiado" +
                    "\n4 - Cadastrar Disciplina ao Curso" +
                    "\n5 - Criar Aula" +
                    "\n6 - Cadastrar Aluno" +
                    "\n7 - Relátorio" +
                    "\n8 - Sair" +
                    "\nEscolha uma Opção: ");
            opcao = sc.nextInt();

            System.out.println();

            switch (opcao) {

                case 1:
                    System.out.println("_______________ CADASTRO DE CURSO _______________");
                    System.out.print("Digite o nome do Curso : ");
                    curso.setNomeCurso(sc.next());
                    alunoCurso.setCurso(curso);
                    listaCurso.add(curso);

                    System.out.println("Curso cadastrado com Sucesso ...");
                    break;

                case 2:
                    String nomeCurso;
                    System.out.println("_______________ CADASTRO DE COLEGIADO _______________");
                    System.out.print("Digite o nome do Curso : ");
                    nomeCurso = sc.next();

                    Curso c = Validacoes.cursoCadastrado(listaCurso, nomeCurso);
                    if (c != null) {
                        colegiado.setCurso(c);
                        System.out.println("Colegiado Cadastrado com Sucesso ...");
                    } else {
                        System.out.println("O Curso NÃO está CADASTRADO no Sistema !!");
                    }
                    break;

                case 3:
                    if (colegiado.getCurso() == null) {
                        System.out.println("É necessário cadastrar um COLEGIADO primeiro !!");
                        break;
                    }
                    professor = new Professor();
                    System.out.println("_______________ CADASTRO DE PROFESSOR _______________");
                    System.out.print("Digite o nome: ");
                    professor.setNome(sc.next());
                    System.out.print("Digite o CPF: ");
                    professor.setCpf(sc.next());
                    System.out.print("Digite a Data de Nascimento (dd/mm/yyyy): ");
                    professor.setDtNascimente(sc.next());
                    System.out.print("Digite o Numero do Registro: ");
                    professor.setnRegistro(sc.next());
                    System.out.print("Digite a Titulação: ");
                    professor.setTitulacao(sc.next());
                    System.out.print("Digite as Horas Semanais: ");
                    professor.setHorasSemanais(sc.nextFloat());
                    sc.nextLine();
                    System.out.print("Digite o Preço por Hora: ");
                    professor.setPrecoHora(sc.nextDouble());

                    colegiado.inserirProfessor(professor);
                    System.out.println("\nProfessor Cadastrado com Sucesso ...");

                    break;

                case 4:
                    System.out.println("_______________ CADASTRO DE DISCIPLINA _______________");
                    disciplina = new Disciplina();
                    System.out.print("Digite o nome: ");
                    disciplina.setNome(sc.next());
                    System.out.print("Digite a Carga Horária: ");
                    disciplina.setCargaHoraria(sc.nextInt());
                    System.out.print("Digite o número de Registro do Professor: ");
                    String nRegistro = sc.next();

                    Professor prof = Validacoes.validarProfessor(colegiado, nRegistro);
                    if (prof != null) {
                        disciplina.setProfessor(prof);
                        curso.inserirDisciplina(disciplina);
                        System.out.println("\nDisciplina Cadastrada com Sucesso ...");
                    } else {
                        System.out.println("\nO Professor NÃO está CADASTRADO no Sistema !!");
                    }
                    break;

                case 5:
                    if (curso.getNomeCurso() == null) {
                        System.out.println("É necessário cadastrar um CURSO primeiro !!");
                        break;
                    }
                    String nomeDisciplina;
                    System.out.println("_______________ CRIAR AULA _______________");
                    System.out.print("Digite o Laboratiro: ");
                    aula.setLab(sc.next());
                    System.out.print("Digite a Data e Hora da aula (dd/mm/yyyy hh:mm): ");
                    aula.setDataHora(sc.next());
                    System.out.print("Digite o nome da Disciplina: ");
                    nomeDisciplina = sc.next();

                    Disciplina d = Validacoes.validarDisciplina(curso, nomeDisciplina);
                    if (d != null){
                        aula.setDisciplina(d);
                        System.out.println("\nAula criada com Sucesso ...");
                    } else {
                        System.out.println("\nA Disciplina NÃO está CADASTRADO no Sistema !!");
                    }
                    break;

                case 6:
                    if (curso.getNomeCurso() == null) {
                        System.out.println("É necessário cadastrar um CURSO primeiro !!");
                        break;
                    }
                    estudante = new Estudante();
                    System.out.println("_______________ CADASTRO DE ALUNO _______________");
                    System.out.print("Digite o nome: ");
                    estudante.setNome(sc.next());
                    System.out.print("Digite o CPF: ");
                    estudante.setCpf(sc.next());
                    System.out.print("Digite a Data de Nascimento (dd/mm/yyyy): ");
                    estudante.setDtNascimente(sc.next());
                    System.out.print("Digite o RA : ");
                    estudante.setRa(sc.next());
                    System.out.print("Digite o Periodo : ");
                    estudante.setPeriodo(sc.nextInt());

                    estudante.setCurso(curso);
                    alunoCurso.inserirAluno(estudante);
                    aula.addAluno(estudante);
                    System.out.println("\nAluno cadastrado ao curso com Sucesso ...");
                    break;

                case 7:
                    Validacoes.relatorio(curso, alunoCurso, aula);
                    break;

                case 8:
                    System.out.println("Finalizando Programa ...");
                    break;

                default:
                    System.out.println("Opção invalida ...");
            }
        }
    }
}
