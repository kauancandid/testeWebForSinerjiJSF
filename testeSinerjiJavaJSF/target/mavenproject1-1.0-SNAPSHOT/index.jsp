<%@page import="br.com.senacrs.TO.Person"%>
<%@page import="java.util.List"%>
<%@page import="br.com.senacrs.DAO.PersonDAO"%>
<%
    PersonDAO personDAO = new PersonDAO();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Teste SINERJI!</h1>
        
    <p:layoutUnit position="center">
        
        <form action="SalvarDadosServelet" method="post">
            <div>
                
                <label for="nome">Nome:</label>
                <input type="text" id="name" name="nome" required><br><br>          
    
                <label for="idade">Data de Nascimento:</label>
                <input type="date" id="age" name="idade" required><br><br>

                <label for="sexo">Sexo:</label>        
                <select id="sexo" name="sexo" required>
                    <option value="M">Masculino</option>
                    <option value="F">Feminino</option>
                </select><br><br>
                
                <h2><Endereço</h2>
    
                <label for="estado">Estado:</label>
                <input type="text" id="state" name="estado" required><br><br>

                <label for="cidade">Cidade:</label>
                <input type="text" id="city" name="cidade" required><br><br>

                <label for="logradouro">Logradouro:</label>
                <input type="text" id="publicPlace" name="logradouro" required><br><br>

                <label for="numero">Número:</label>
                <input type="number" id="num" name="numero" required><br><br>

                <label for="cep">Cep:</label>
                <input type="text" id="zipCode" name="zip" required><br><br>
                
                <input type="submit" value="Salvar">          
            </div
        </form
        
        <!-- Seção para listar pessoas -->
        
        <div>
            <h2>Listas de Pessoas</h2>            
            <ul>            
                <% List<Person> pessoas = personDAO.listar();
                for (Person pessoa : pessoas) { %>
                <li><%= pessoa.getName() %></li>
                <% } %>
            </ul>
        </div>
                
        <!-- Seção para deletar pessoa -->
        
        <div>
            <h2>Deletar Pessoa</h2>
            
            <form action="DeletarPessoaServelet" method="post">
                
                <label for="personIdToDelete">Selecione uma pessoa para deletar:</label>
                <select id="personIdToDelete" name="personIdToDelete" required>
                    
                    <option value="">Selecione uma pessoa</option>
                    <%
                        for (Person pessoa : pessoas) {
                    %>
                    <option value="<%= pessoa.getId() %>"><%= pessoa.getName() %></option>
                    <%
                        }
                    %>
                </select><br><br>
        
                <input type="submit" value="Deletar">
            </form>
        </div>
    </body>
</html>


