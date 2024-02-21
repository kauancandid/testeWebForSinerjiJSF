package br.com.senacrs.DAO;

import br.com.senacrs.TO.Address;
import br.com.senacrs.TO.Person;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SalvarDadosServlet")
public class SalvarDadosServelet {
    
    private static int generateRandomId() {       
        Random random = new Random();       
        int randomId = random.nextInt(Integer.MAX_VALUE);
        return randomId;
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Receber os parâmetros do formulário
        String name = request.getParameter("name");
        String ageString = request.getParameter("age");
        LocalDate age = LocalDate.parse(ageString);
        String sex = request.getParameter("sex");
        
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String publicPlace = request.getParameter("publicPlace");
        String numString = request.getParameter("num");
        int num = Integer.parseInt(numString);
        String zipCodeString = request.getParameter("zipCode");
        int zipCode = Integer.parseInt(zipCodeString);

       
        Address address = new Address(generateRandomId(), state, city, publicPlace, num, zipCode);
        List<Address> listaEnderecos = new ArrayList<>();
        listaEnderecos.add(address);
        Person person = new Person(generateRandomId(), name, age, sex, listaEnderecos);
        
        
        PersonDAO personDAO = new PersonDAO();
        personDAO.salvar(person);
        
        AddressDAO addressDAO = new AddressDAO();
        addressDAO.salvar(address);
        
        response.sendRedirect(request.getContextPath() + "/ListarPessoasServlet");
    }
    
}
