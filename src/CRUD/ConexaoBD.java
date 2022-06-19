package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lucas
 */
public class ConexaoBD {
    private String usuario;
    private String senha;
    private String nome; 
    private int idade;
    private int altura; 
    private int peso;
    
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/projetopoo";
    String user = "root";
    String password = "";

    public ConexaoBD(){
        
    }
    public ConexaoBD(String nome, int idade, int altura, int peso) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }
    public ConexaoBD(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    
    public int cadastrar(String nome, int idade, int altura, int peso) {
        int resultado=0;
        try {
            Class.forName(driver);
            String sql = "INSERT INTO `projetopoo`.`cadastro` (`Nome`, `idade`, `altura`, `peso`) VALUES "
                            + "('"+this.nome+"', '"+this.idade+"', '"+this.altura+"', '"+this.peso+"');";
            try {
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                resultado = st.executeUpdate(sql);
                st.close();
                con.close();

            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return resultado;
    }
    
    
    public int ArmazenaLogin(String usuario, String senha){
        int resultadoLogin = 0;
        try {
            Class.forName(driver);
            String sql = "INSERT INTO `projetopoo`.`Login` (`usuario`, `senha`) VALUES "
                            + "('"+this.usuario+"', '"+this.senha+"');";
            try {
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                resultadoLogin = st.executeUpdate(sql);
                st.close();
                con.close();

            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return resultadoLogin;
    }
    

    
    public int autenticaçãoUsuario(String usuario, String senha){
        int resultadoAutenticacao=0;
        try {
            Class.forName(driver);
            String sql = "select * from login where usuario = '"+usuario+"' and senha = '"+senha+"'";
            try {
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                resultadoAutenticacao = st.executeUpdate(sql);
                st.close();
                con.close();

            } catch (SQLException e) {
                System.out.println(e);
                resultadoAutenticacao++;
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return resultadoAutenticacao;
    }
    
    public String getNomes(){
        String resultado = "";
        try {
            Class.forName(driver);
            String query = "SELECT nome FROM cadastro";
            try {
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);

                int colNum = rs.getMetaData().getColumnCount();
                while (rs.next()) {
                        for (int i=1; i<=colNum; i++)
                        {
                                resultado += rs.getString(i);
                        }
                        resultado += "\n";
                }
                rs.close();
                st.close();
                con.close();

            } catch (SQLException e) {
                    System.out.println(e);
            } 
        } catch (ClassNotFoundException e) {
                System.out.println(e);
        }
	
        
        return resultado;
    }
    
    public String[] buscarNome(String nome) {
        String[] resultado = null;
        try {
            Class.forName(driver);
            String query = "SELECT * FROM cadastro where Nome LIKE '" + nome + "%'";
            try {
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		int colNum = rs.getMetaData().getColumnCount();
		resultado = new String[colNum];
		if (rs.next()) {
                    for (int i = 0; i < colNum; i++) {
			resultado[i] = rs.getString(i + 1);
                    }
		}
		st.close();
		con.close();

		} catch (SQLException e) {
			System.out.println(e);
                    }
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	return resultado;
    }
    
public int Delete(String nome){
        int resultado = 0;
        try{
            Class.forName(driver);
            String sql = "delete from cadastro where nome = '"+nome+"'";
            try {
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                resultado = st.executeUpdate(sql);
                st.close();
                con.close();

            } catch (SQLException e) {
                System.out.println(e);
                resultado++;
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return resultado;
    }

    
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
}
